package com.gca;

import com.gca.contents.registers.AddonBlocks;
import com.gca.init.AddonFluidTraits;
import com.gca.init.recipes.AddonCompressorRecipes;
import com.gca.init.recipes.AddonSolderingRecipes;
import com.gca.overwrite_contents.config.GCAConfig;
import com.gca.proxy.CommonProxy;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;


@Mod(modid = gca.MODID, name = gca.NAME, version = gca.VERSION, dependencies = "required-after:hbm")
public class gca {

    public static final String MODID = "gca";
    public static final String NAME = "Gommers Combat Addon";
    public static final String VERSION = "1.0.0";

    @SidedProxy(
            clientSide = "com.gca.proxy.ClientProxy",
            serverSide = "com.gca.proxy.CommonProxy"
    )
    public static CommonProxy proxy;

    static {
        FluidRegistry.enableUniversalBucket();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        GCAConfig.init(event.getSuggestedConfigurationFile()); // make sure this runs first!!!!!!!!!!
        AddonBlocks.preInit();

        proxy.preInit(event);
        AddonFluidTraits.preInit();



    }

    private static void registerFluidHazard(com.hbm.inventory.fluid.FluidType ft, double rads) {
        try {
            net.minecraftforge.fluids.Fluid ff = ft.getFF();
            if (ff == null) return;
            String name = ff.getName();
            it.unimi.dsi.fastutil.objects.ObjectArrayList<com.hbm.hazard.HazardEntry> list =
                    new it.unimi.dsi.fastutil.objects.ObjectArrayList<>();
            list.add(new com.hbm.hazard.HazardEntry(com.hbm.hazard.HazardRegistry.RADIATION, rads));
            com.hbm.hazard.transformer.HazardTransformerForgeFluid.FLUID_HAZARDS.put(name, list);
        } catch (Exception ex) {
            System.err.println("[GCA] Failed to register fluid hazard: " + ex.getMessage());
        }
    }

    public static void registerSerializable() {
        // just steal these files from leafia under init/recipes as you need them

        //AddonChemplantRecipes.register();
        //AddonAssemblerRecipes.register();
        //AddonGasCentRecipes.register();
        //AddonElectrolyzerRecipes.register();
        //AddonPyroOvenRecipes.register();
        //AddonAnvilRecipes.registerSmithingRecipes();
        //AddonAnvilRecipes.registerConstructionRecipes();
        //AddonPUREXRecipes.register();
        //AddonWasteDrumRecipes.register();
        //AddonCentrifugeRecipes.register();
        //AddonArcWelderRecipes.register();
        //AddonDFCRecipes.register();
        //AddonSmeltingRecipes.register();
        AddonSolderingRecipes.register();
        //AddonMixerRecipes.register();
        AddonCompressorRecipes.register();
        //AddonPlasmaForgeRecipes.register();
        //AddonShredderRecipes.register();
        //AddonPARecipes.register();
        // AddonExposureChamberRecipes.register();

    }



}