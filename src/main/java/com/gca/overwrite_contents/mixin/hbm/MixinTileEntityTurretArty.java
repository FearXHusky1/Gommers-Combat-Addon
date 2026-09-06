package com.gca.overwrite_contents.mixin.hbm;

import com.gca.overwrite_contents.config.GCAConfig;
import com.hbm.tileentity.turret.TileEntityTurretArty;

import com.hbm.tileentity.turret.TileEntityTurretHIMARS;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = TileEntityTurretArty.class, remap = false)
public class MixinTileEntityTurretArty {
    @Inject(method = "getDecetorRange", at = @At("HEAD"), cancellable = true)
    private void overrideDetectorRange(CallbackInfoReturnable<Double> cir) {
        cir.setReturnValue(GCAConfig.himarsDetectorRange);
    }

    // Force manual mode on every tick, regardless of NBT/network/OC state
    @Inject(method = "update", at = @At("HEAD"))
    private void gca$forceManualMode(CallbackInfo ci) {
        TileEntityTurretArty self = (TileEntityTurretArty) (Object) this;
        self.mode = TileEntityTurretArty.MODE_MANUAL;
    }

    // Prevent the mode-toggle button (meta 5) from doing anything at all
    @Inject(method = "handleButtonPacket", at = @At("HEAD"), cancellable = true)
    private void gca$blockModeToggle(int value, int meta, CallbackInfo ci) {
        if (meta == 5) {
            ci.cancel();
        }
    }
}