package com.gca.init.recipes;

import com.hbm.inventory.fluid.FluidType;
import com.hbm.inventory.recipes.MixerRecipes;
import com.hbm.inventory.recipes.MixerRecipes.MixerRecipe;

import java.util.HashMap;

public class AddonMixerRecipes {
    public static HashMap<FluidType, MixerRecipe[]> recipePtr = MixerRecipes.recipes;
    public static void register() {
    }
}