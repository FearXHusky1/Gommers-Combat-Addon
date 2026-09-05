package com.gca.overwrite_contents.mixin.hbm;

import com.hbm.inventory.gui.GUITurretHIMARS;
import com.hbm.tileentity.turret.TileEntityTurretHIMARS;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//this is supposed to replace the UI on the HIMARS to show you the actual range.
//It does nothing. I dont know why
@Mixin(value = GUITurretHIMARS.class, remap = false)
public class MixinGUITurretHIMARS {

    @Inject(method = "drawScreen", at = @At("TAIL"))
    private void addRangeDisplay(int mouseX, int mouseY, float f, CallbackInfo ci) {
        try {
            GUITurretHIMARS self = (GUITurretHIMARS)(Object) this;
            AccessorGUITurretBase accessor = (AccessorGUITurretBase)(Object) this;
            TileEntityTurretHIMARS himars = (TileEntityTurretHIMARS) accessor.getTurret();
            String rangeText = "Range: " + String.format("%,d", (int) himars.getDecetorRange()) + "m";

            Minecraft.getMinecraft().fontRenderer.drawString(
                    rangeText, self.guiLeft + 300, self.guiTop + 20, 0xFFFFFF);


        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}