package com.gca.init.recipes;

import com.hbm.inventory.RecipesCommon.AStack;
import com.hbm.inventory.RecipesCommon.ComparableStack;
import com.hbm.inventory.RecipesCommon.OreDictStack;
import com.hbm.inventory.fluid.FluidStack;
import com.hbm.inventory.fluid.Fluids;
import com.hbm.inventory.recipes.SolderingRecipes;
import com.hbm.inventory.recipes.SolderingRecipes.SolderingRecipe;
import com.hbm.items.ItemEnums.EnumCircuitType;
import com.hbm.items.ModItems;

import com.gca.contents.AddonFluids;
import com.gca.contents.registers.RegistryHandler;
import net.minecraft.item.ItemStack;

import java.util.List;

import static com.hbm.inventory.OreDictManager.*;

public class AddonSolderingRecipes {
    public static List<SolderingRecipe> recipes = SolderingRecipes.recipes;

    public static void register() {

    }
}
