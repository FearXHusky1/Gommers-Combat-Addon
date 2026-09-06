package com.gca.overwrite_contents.mixin.hbm;

import com.gca.overwrite_contents.config.GCAConfig;
import com.hbm.inventory.gui.GUITurretArty;
import com.hbm.tileentity.turret.TileEntityTurretArty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.Arrays;

@Mixin(value = GUITurretArty.class, remap = false)
public class MixinGUITurretArty {

    @ModifyArg(
            method = "drawScreen",
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/hbm/inventory/gui/GUITurretArty;drawCustomInfoStat(IIIIIIII[Ljava/lang/String;)V"
            ),
            index = 8,
            require = 1
    )
    private String[] gca$appendDetectorRange(String[] original) {
        try {
            AccessorGUITurretBase accessor = (AccessorGUITurretBase) (Object) this;
            TileEntityTurretArty arty = (TileEntityTurretArty) accessor.getTurret();

            String rangeText = "Range: "
                    + String.format("%,d", (int) arty.getDecetorRange()) + "m";

            String[] combined = Arrays.copyOf(original, original.length);
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