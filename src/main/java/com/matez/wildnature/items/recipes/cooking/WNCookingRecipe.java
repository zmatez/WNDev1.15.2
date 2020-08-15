package com.matez.wildnature.items.recipes.cooking;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public class WNCookingRecipe extends WNAbstractCookingRecipe {
   public static IRecipeType<WNCookingRecipe> COOKING = IRecipeType.register("wildnature:cooking");
   public WNCookingRecipe(ResourceLocation p_i50022_1_, String p_i50022_2_, Ingredient p_i50022_3_, ItemStack p_i50022_4_, float p_i50022_5_, int p_i50022_6_) {
      super(COOKING, p_i50022_1_, p_i50022_2_, p_i50022_3_, p_i50022_4_, p_i50022_5_, p_i50022_6_);
   }

   public ItemStack getIcon() {
      return new ItemStack(Blocks.SMOKER);
   }

   @Override
   public IRecipeSerializer<?> getSerializer() {
      return Registry.RECIPE_SERIALIZER.getOrDefault(new ResourceLocation("wildnature:cooking"));
   }

   @Override
   public IRecipeType<?> getType() {
      return COOKING;
   }
}