package com.gca.client;

import com.gca.contents.registers.*;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class RegisterStuff {

    static {
        OBJLoader.INSTANCE.addDomain("gca");
    }

    @SubscribeEvent
    public static void regModels(ModelRegistryEvent e) {



        registerRenderers();
    }

    public static void registerRenderers() {


    }
}