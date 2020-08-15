package com.matez.wildnature.items;

import com.matez.wildnature.Main;
import com.matez.wildnature.items.recipes.cooking.FillTool;
import net.minecraft.block.Blocks;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

import static com.matez.wildnature.commands.RecipeCommand.checkIngredients;

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