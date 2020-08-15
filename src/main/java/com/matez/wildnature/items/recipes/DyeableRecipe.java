package com.matez.wildnature.items.recipes;

import com.google.common.collect.Lists;
import java.util.List;

import com.matez.wildnature.items.dye.IDyeableItem;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.DyeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.SpecialRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class DyeableRecipe extends SpecialRecipe {
   public DyeableRecipe(ResourceLocation idIn) {
      super(idIn);
   }

   public boolean matches(CraftingInventory inv, World worldIn) {
      ItemStack itemstack = ItemStack.EMPTY;
      List<ItemStack> list = Lists.newArrayList();

      for(int i = 0; i < inv.getSizeInventory(); ++i) {
         ItemStack itemstack1 = inv.getStackInSlot(i);
         if (!itemstack1.isEmpty()) {
            if (itemstack1.getItem() instanceof IDyeableItem) {
               if (!itemstack.isEmpty()) {
                  return false;
               }

               itemstack = itemstack1;
            } else {
               if (!(itemstack1.getItem() instanceof DyeItem)) {
                  return false;
               }

               list.add(itemstack1);
            }
         }
      }

      return !itemstack.isEmpty() && !list.isEmpty();
   }

   public ItemStack getCraftingResult(CraftingInventory inv) {
      List<DyeItem> list = Lists.newArrayList();
      ItemStack itemstack = ItemStack.EMPTY;

      for(int i = 0; i < inv.getSizeInventory(); ++i) {
         ItemStack itemstack1 = inv.getStackInSlot(i);
         if (!itemstack1.isEmpty()) {
            Item item = itemstack1.getItem();
            if (item instanceof IDyeableItem) {
               if (!itemstack.isEmpty()) {
                  return ItemStack.EMPTY;
               }

               itemstack = itemstack1.copy();
            } else {
               if (!(item instanceof DyeItem)) {
                  return ItemStack.EMPTY;
               }

               list.add((DyeItem)item);
            }
         }
      }

      if (!itemstack.isEmpty() && !list.isEmpty()) {
         return IDyeableItem.func_219975_a(itemstack, list);
      } else {
         return ItemStack.EMPTY;
      }
   }

   /**
    * Used to determine if this recipe can fit in a grid of the given width/height
    */
   public boolean canFit(int width, int height) {
      return width * height >= 2;
   }

   public IRecipeSerializer<?> getSerializer() {
      return Registry.RECIPE_SERIALIZER.getOrDefault(new ResourceLocation("wildnature:dyeable_recipe"));

   }
}