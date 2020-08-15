package com.matez.wildnature.entity.AI;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;

import java.util.EnumSet;
import java.util.List;
import java.util.function.Predicate;

public class FindItemsGoal extends Goal {
    private AnimalEntity entity;
    private Predicate<ItemEntity> predicate = null;
      public FindItemsGoal(AnimalEntity entity, Predicate<ItemEntity> predicate) {
         this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
         this.entity=entity;
         this.predicate=predicate;
      }

      /**
       * Returns whether the EntityAIBase should begin execution.
       */
      public boolean shouldExecute() {
         if (!entity.getItemStackFromSlot(EquipmentSlotType.MAINHAND).isEmpty()) {
            return false;
         } else if (entity.getAttackTarget() == null && entity.getRevengeTarget() == null) {
            if (entity.getRNG().nextInt(10) != 0) {
               return false;
            } else {
               List<ItemEntity> list = entity.world.getEntitiesWithinAABB(ItemEntity.class, entity.getBoundingBox().grow(8.0D, 8.0D, 8.0D), predicate);
               return !list.isEmpty() && entity.getItemStackFromSlot(EquipmentSlotType.MAINHAND).isEmpty();
            }
         } else {
            return false;
         }
      }

      /**
       * Keep ticking a continuous task that has already been started
       */
      public void tick() {
         List<ItemEntity> list = entity.world.getEntitiesWithinAABB(ItemEntity.class, entity.getBoundingBox().grow(8.0D, 8.0D, 8.0D), predicate);
         ItemStack itemstack = entity.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
         if (itemstack.isEmpty() && !list.isEmpty()) {
            entity.getNavigator().tryMoveToEntityLiving(list.get(0), (double)1.2F);
         }

      }

      /**
       * Execute a one shot task or start executing a continuous task
       */
      public void startExecuting() {
         List<ItemEntity> list = entity.world.getEntitiesWithinAABB(ItemEntity.class, entity.getBoundingBox().grow(8.0D, 8.0D, 8.0D), predicate);
         if (!list.isEmpty()) {
            entity.getNavigator().tryMoveToEntityLiving(list.get(0), (double)1.2F);
         }

      }
   }