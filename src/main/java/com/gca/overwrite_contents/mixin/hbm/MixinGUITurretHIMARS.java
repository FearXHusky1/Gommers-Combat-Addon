package com.gca.overwrite_contents.mixin.hbm;

import com.hbm.inventory.gui.GUITurretHIMARS;
import com.hbm.tileentity.turret.TileEntityTurretHIMARS;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.Arrays;

@Mixin(value = GUITurretHIMARS.class, remap = false)
public class MixinGUITurretHIMARS {

    @ModifyArg(
            method = "drawScreen",
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/hbm/inventory/gui/GUITurretHIMARS;drawCustomInfoStat(IIIIIIII[Ljava/lang/String;)V"
            ),
            index = 8,
            require = 1
    )
    private String[] gca$appendDetectorRange(String[] original) {
        try {
            AccessorGUITurretBase accessor = (AccessorGUITurretBase) (Object) this;
            TileEntityTurretHIMARS himars = (TileEntityTurretHIMARS) accessor.getTurret();

            String rangeText = "Range: "
                    + String.format("%,d", (int) himars.getDecetorRange()) + "m";

            String[] combined = Arrays.copyOf(original, original.length); // <-- no .clone()
            if (combined.length > 1) {
                combined[1] = rangeText;
            }
            return combined;

        } catch (Throwable t) {
            t.printStackTrace();
            return original;
        }
    }


}