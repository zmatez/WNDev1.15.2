package com.matez.wildnature.common.items;

import com.matez.wildnature.init.Main;
import com.matez.wildnature.common.items.recipes.cooking.FillTool;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DeepBowlSoupItem extends FoodItem {
   public DeepBowlSoupItem(Properties p_i50054_1_) {
      super(p_i50054_1_, FillTool.DEEP_BOWL);
   }

   /**
    * Called when the player finishes using this Item (E.g. finishes eating.). Not called when the player stops using
    * the Item before the action is complete.
    */
   public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
      super.onItemUseFinish(stack,worldIn,entityLiving);

      super.onItemUseFinish(stack, worldIn, entityLiving);
      return new ItemStack(Main.getItemByID("wildnature:deep_bowl"));
   }
}