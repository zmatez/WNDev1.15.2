package com.matez.wildnature.common.items;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.common.items.recipes.cooking.FillTool;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MapleSoupItem extends FoodItem {
   public MapleSoupItem(Item.Properties p_i50054_1_) {
      super(p_i50054_1_, FillTool.MAPLE_BOWL);
   }

   /**
    * Called when the player finishes using this Item (E.g. finishes eating.). Not called when the player stops using
    * the Item before the action is complete.
    */
   public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
      super.onItemUseFinish(stack,worldIn,entityLiving);

      super.onItemUseFinish(stack, worldIn, entityLiving);
      return new ItemStack(WN.getItemByID("wildnature:maple_bowl"));
   }
}