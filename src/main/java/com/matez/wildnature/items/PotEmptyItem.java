package com.matez.wildnature.items;

import com.matez.wildnature.Main;
import com.matez.wildnature.items.recipes.cooking.CookingToolType;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import java.util.List;

public class PotEmptyItem extends CookingItem {
   public PotEmptyItem(Properties builder) {
      super(builder, CookingToolType.NONE);
   }

   /**
    * Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see
    * {@link #onItemUse}.
    */
   public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
      super.onItemRightClick(worldIn,playerIn,handIn);
      List<AreaEffectCloudEntity> list = worldIn.getEntitiesWithinAABB(AreaEffectCloudEntity.class, playerIn.getBoundingBox().grow(2.0D), (p_210311_0_) -> {
         return p_210311_0_ != null && p_210311_0_.isAlive() && p_210311_0_.getOwner() instanceof EnderDragonEntity;
      });
      ItemStack itemstack = playerIn.getHeldItem(handIn);
      if (!list.isEmpty()) {
         AreaEffectCloudEntity areaeffectcloudentity = list.get(0);
         areaeffectcloudentity.setRadius(areaeffectcloudentity.getRadius() - 0.5F);
         worldIn.playSound((PlayerEntity)null, playerIn.getPosition().getX(), playerIn.getPosition().getY(), playerIn.getPosition().getZ(), SoundEvents.ITEM_BOTTLE_FILL_DRAGONBREATH, SoundCategory.NEUTRAL, 1.0F, 0.7F);
         return new ActionResult<>(ActionResultType.SUCCESS, this.turnBottleIntoItem(itemstack, playerIn, new ItemStack(Items.DRAGON_BREATH)));
      } else {
         RayTraceResult raytraceresult = rayTrace(worldIn, playerIn, RayTraceContext.FluidMode.SOURCE_ONLY);
         if (raytraceresult.getType() == RayTraceResult.Type.MISS) {
            return new ActionResult<>(ActionResultType.PASS, itemstack);
         } else {
            if (raytraceresult.getType() == RayTraceResult.Type.BLOCK) {
               BlockPos blockpos = ((BlockRayTraceResult)raytraceresult).getPos();
               if (!worldIn.isBlockModifiable(playerIn, blockpos)) {
                  return new ActionResult<>(ActionResultType.PASS, itemstack);
               }

               if (worldIn.getFluidState(blockpos).isTagged(FluidTags.WATER)) {
                  worldIn.playSound(playerIn, playerIn.getPosition().getX(), playerIn.getPosition().getY(), playerIn.getPosition().getZ(), SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.NEUTRAL, 1.0F, 0.6F);
                  return new ActionResult<>(ActionResultType.SUCCESS, this.turnBottleIntoItem(itemstack, playerIn, PotionUtils.addPotionToItemStack(new ItemStack(Main.getItemByID("wildnature:pot_water")), Potions.WATER)));
               }
            }

            return new ActionResult<>(ActionResultType.PASS, itemstack);
         }
      }
   }

   protected ItemStack turnBottleIntoItem(ItemStack p_185061_1_, PlayerEntity player, ItemStack stack) {
      p_185061_1_.shrink(1);
      player.addStat(Stats.ITEM_USED.get(this));
      if (p_185061_1_.isEmpty()) {
         return stack;
      } else {
         if (!player.inventory.addItemStackToInventory(stack)) {
            player.dropItem(stack, false);
         }

         return p_185061_1_;
      }
   }
}