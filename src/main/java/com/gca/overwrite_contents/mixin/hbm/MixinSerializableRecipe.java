package com.gca.overwrite_contents.mixin.hbm;
import com.hbm.inventory.recipes.loader.SerializableRecipe;
import com.gca.init.AddonSerializableRecipe;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


import static com.gca.gca.registerSerializable;


@Mixin(value = SerializableRecipe.class,remap = false)
public class MixinSerializableRecipe {
    @Inject(method = "registerAllHandlers", at = @At(value = "TAIL"), require = 1)
    private static void onRegisterAllHandlers(CallbackInfo ci) {
        AddonSerializableRecipe.onRegisterAllHandlers();
    }

    @Inject(method = "initialize", at = @At(value = "TAIL"), require = 1)
    private static void onInitialize(CallbackInfo ci) {
        registerSerializable();
    }
}