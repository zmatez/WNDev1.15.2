package com.matez.wildnature.entity.AI;

import net.minecraft.block.*;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class RaidFarmGoal extends MoveToBlockGoal {
      private final AnimalEntity animal;
      private boolean wantsToRaid;
      private boolean canRaid;

      public RaidFarmGoal(AnimalEntity animal) {
         super(animal, (double)0.7F, 16);
         this.animal = animal;
      }

      /**
       * Returns whether the EntityAIBase should begin execution.
       */
      public boolean shouldExecute() {
         if (this.runDelay <= 0) {
            if (!net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.animal.world, this.animal)) {
               return false;
            }

            this.canRaid = false;
            //this.wantsToRaid = this.rabbit.isCarrotEaten();
            this.wantsToRaid = true;
         }

         return super.shouldExecute();
      }

      /**
       * Returns whether an in-progress EntityAIBase should continue executing
       */
      public boolean shouldContinueExecuting() {
         return this.canRaid && super.shouldContinueExecuting();
      }

      /**
       * Keep ticking a continuous task that has already been started
       */
      public void tick() {
         super.tick();
         this.animal.getLookController().setLookPosition((double)this.destinationBlock.getX() + 0.5D, (double)(this.destinationBlock.getY() + 1), (double)this.destinationBlock.getZ() + 0.5D, 10.0F, (float)this.animal.getVerticalFaceSpeed());
         if (this.getIsAboveDestination()) {
            World world = this.animal.world;
            BlockPos blockpos = this.destinationBlock.up();
            BlockState blockstate = world.getBlockState(blockpos);
            Block block = blockstate.getBlock();
            if (this.canRaid && block instanceof CarrotBlock) {
               Integer integer = blockstate.get(CarrotBlock.AGE);
               if (integer == 0) {
                  world.setBlockState(blockpos, Blocks.AIR.getDefaultState(), 2);
                  world.destroyBlock(blockpos, true);
               } else {
                  world.setBlockState(blockpos, blockstate.with(CarrotBlock.AGE, Integer.valueOf(integer - 1)), 2);
                  world.playEvent(2001, blockpos, Block.getStateId(blockstate));
               }

               //this.animal.carrotTicks = 40;
            }

            this.canRaid = false;
            this.runDelay = 10;
         }

      }

      /**
       * Return true to set given position as destination
       */
      protected boolean shouldMoveTo(IWorldReader worldIn, BlockPos pos) {
         Block block = worldIn.getBlockState(pos).getBlock();
         if (block instanceof FarmlandBlock && this.wantsToRaid && !this.canRaid) {
            pos = pos.up();
            BlockState blockstate = worldIn.getBlockState(pos);
            block = blockstate.getBlock();
            if (block instanceof CarrotBlock && ((CarrotBlock)block).isMaxAge(blockstate)) {
               this.canRaid = true;
               return true;
            }
         }

         return false;
      }
   }