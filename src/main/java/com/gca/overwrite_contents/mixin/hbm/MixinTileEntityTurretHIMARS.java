package com.gca.overwrite_contents.mixin.hbm;

import com.gca.overwrite_contents.config.GCAConfig;
import com.hbm.tileentity.turret.TileEntityTurretHIMARS;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = TileEntityTurretHIMARS.class, remap = false)
public class MixinTileEntityTurretHIMARS {
    @Inject(method = "getDecetorRange", at = @At("HEAD"), cancellable = true)
    private void overrideDetectorRange(CallbackInfoReturnable<Double> cir) {
        cir.setReturnValue(GCAConfig.himarsDetectorRange);
    }
}