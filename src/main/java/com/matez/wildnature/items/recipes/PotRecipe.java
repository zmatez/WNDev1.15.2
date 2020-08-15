package com.matez.wildnature.items.recipes;

import it.unimi.dsi.fastutil.ints.IntList;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class PotRecipe extends AbstractCookingRecipe {

    public PotRecipe(IRecipeType<?> p_i50032_1_, ResourceLocation p_i50032_2_, String p_i50032_3_, Ingredient p_i50032_4_, ItemStack p_i50032_5_, float p_i50032_6_, int p_i50032_7_) {
        super(p_i50032_1_, p_i50032_2_, p_i50032_3_, p_i50032_4_, p_i50032_5_, p_i50032_6_, p_i50032_7_);
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return Registry.RECIPE_SERIALIZER.getOrDefault(new ResourceLocation("wildnature:pot_recipe"));

    }
}
