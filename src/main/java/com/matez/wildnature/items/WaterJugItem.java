package com.matez.wildnature.items;

import com.matez.wildnature.Main;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.PotionUtils;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class WaterJugItem extends Item {
   public WaterJugItem(Item.Properties builder) {
      super(builder);
   }


   /**
    * Called when the player finishes using this Item (E.g. finishes eating.). Not called when the player stops using
    * the Item before the action is complete.
    */
   public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
      super.onItemUseFinish(stack,worldIn,entityLiving);

      PlayerEntity playerentity = entityLiving instanceof PlayerEntity ? (PlayerEntity)entityLiving : null;
      if (playerentity == null || !playerentity.abilities.isCreativeMode) {
         stack.shrink(1);
      }

      if (playerentity instanceof ServerPlayerEntity) {
         CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayerEntity)playerentity, stack);
      }

      if (!worldIn.isRemote) {
         for(EffectInstance effectinstance : PotionUtils.getEffectsFromStack(stack)) {
            if (effectinstance.getPotion().isInstant()) {
               effectinstance.getPotion().affectEntity(playerentity, playerentity, entityLiving, effectinstance.getAmplifier(), 1.0D);
            } else {
               entityLiving.addPotionEffect(new EffectInstance(effectinstance));
            }
         }
      }

      if (playerentity != null) {
         playerentity.addStat(Stats.ITEM_USED.get(this));
      }

      if (playerentity == null || !playerentity.abilities.isCreativeMode) {
         if (stack.isEmpty()) {
            return new ItemStack(Main.getItemByID("wildnature:jug"));
         }

         if (playerentity != null) {
            playerentity.inventory.addItemStackToInventory(new ItemStack(Main.getItemByID("wildnature:jug")));
         }
      }

      return stack;
   }

   /**
    * How long it takes to use or consume an item
    */
   public int getUseDuration(ItemStack stack) {
      return 32;
   }

   /**
    * returns the action that specifies what animation to play when the items is being used
    */
   public UseAction getUseAction(ItemStack stack) {
      return UseAction.DRINK;
   }

   /**
    * Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see
    * {@link #onItemUse}.
    */
   public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
      playerIn.setActiveHand(handIn);
      return new ActionResult<>(ActionResultType.SUCCESS, playerIn.getHeldItem(handIn));
   }

}