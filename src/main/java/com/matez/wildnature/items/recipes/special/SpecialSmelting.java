package com.matez.wildnature.items.recipes.special;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

public abstract class SpecialSmelting extends FurnaceRecipe {
    public SpecialSmelting(ResourceLocation idIn, String groupIn, Ingredient ingredientIn, ItemStack resultIn, float experienceIn, int cookTimeIn) {
        super(idIn, groupIn, ingredientIn, resultIn, experienceIn, cookTimeIn);
        this.id = idIn;
    }
    private final ResourceLocation id;

    public ResourceLocation getId() {
        return this.id;
    }

    public boolean isDynamic() {
        return true;
    }

}
