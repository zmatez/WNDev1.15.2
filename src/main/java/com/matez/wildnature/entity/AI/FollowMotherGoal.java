package com.matez.wildnature.entity.AI;

import java.util.List;

import com.matez.wildnature.entity.type.animal.IFamily;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.passive.AnimalEntity;

public class FollowMotherGoal extends Goal {
   private final AnimalEntity child;
   private AnimalEntity parent;
   private final double moveSpeed;
   private int delayCounter;

   public FollowMotherGoal(AnimalEntity animal, double speed) {
      this.child = animal;
      this.moveSpeed = speed;
   }

   /**
    * Returns whether the EntityAIBase should begin execution.
    */
   public boolean shouldExecute() {
      if (this.child.getGrowingAge() >= 0) {
         return false;
      } else {
         List<AnimalEntity> list = this.child.world.getEntitiesWithinAABB(this.child.getClass(), this.child.getBoundingBox().grow(8.0D, 4.0D, 8.0D));
         AnimalEntity animalentity = null;
         double d0 = Double.MAX_VALUE;

         for(AnimalEntity animalentity1 : list) {
            if (animalentity1.getGrowingAge() >= 0) {
               double d1 = this.child.getDistanceSq(animalentity1);
               if (!(d1 > d0) && animalentity1 instanceof IFamily && ((IFamily)animalentity1).getGender()== IFamily.Gender.FEMALE) {
                  d0 = d1;
                  animalentity = animalentity1;
               }
            }
         }

         if (animalentity == null) {
            return false;
         } else if (d0 < 9.0D) {
            return false;
         } else {
            this.parent = animalentity;
            return true;
         }
      }
   }

   /**
    * Returns whether an in-progress EntityAIBase should continue executing
    */
   public boolean shouldContinueExecuting() {
      if (this.child.getGrowingAge() >= 0) {
         return false;
      } else if (!this.parent.isAlive()) {
         return false;
      } else {
         double d0 = this.child.getDistanceSq(this.parent);
         return !(d0 < 9.0D) && !(d0 > 256.0D);
      }
   }

   /**
    * Execute a one shot task or start executing a continuous task
    */
   public void startExecuting() {
      this.delayCounter = 0;
   }

   /**
    * Reset the task's internal state. Called when this task is interrupted by another one
    */
   public void resetTask() {
      this.parent = null;
   }

   /**
    * Keep ticking a continuous task that has already been started
    */
   public void tick() {
      if (--this.delayCounter <= 0) {
         this.delayCounter = 10;
         this.child.getNavigator().tryMoveToEntityLiving(this.parent, this.moveSpeed);
      }
   }
}