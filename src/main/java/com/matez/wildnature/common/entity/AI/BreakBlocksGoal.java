package com.matez.wildnature.common.entity.AI;

import com.matez.wildnature.init.WN;
import net.minecraft.block.Block;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class BreakBlocksGoal extends MoveToBlockGoal {
   private final ArrayList<Block> blocks;
   private final MobEntity entity;
   private int breakingTime;

   public BreakBlocksGoal(CreatureEntity creature, double speed, int yMax,Block... blocks) {
      super(creature, speed, 24, yMax);
      this.blocks = new ArrayList<>(Arrays.asList(blocks));
      this.entity = creature;
   }

   /**
    * Returns whether the EntityAIBase should begin execution.
    */
   public boolean shouldExecute() {
      if (!net.minecraftforge.common.ForgeHooks.canEntityDestroy(this.entity.world, this.destinationBlock, this.entity)) {
         return false;
      } else if (this.runDelay > 0) {
         --this.runDelay;
         return false;
      } else if (this.func_220729_m()) {
         this.runDelay = 20;
         return true;
      } else {
         this.runDelay = this.getRunDelay(this.creature);
         return false;
      }
   }

   private boolean func_220729_m() {
      return this.destinationBlock != null && this.shouldMoveTo(this.creature.world, this.destinationBlock) ? true : this.searchForDestination();
   }

   /**
    * Reset the task's internal state. Called when this task is interrupted by another one
    */
   public void resetTask() {
      super.resetTask();
      this.entity.fallDistance = 1.0F;
   }

   /**
    * Execute a one shot task or start executing a continuous task
    */
   public void startExecuting() {
      super.startExecuting();
      this.breakingTime = 0;
   }

   public void playBreakingSound(IWorld p_203114_1_, BlockPos p_203114_2_) {
   }

   public void playBrokenSound(World p_203116_1_, BlockPos p_203116_2_) {
   }

   /**
    * Keep ticking a continuous task that has already been started
    */
   public void tick() {
      super.tick();
      World world = this.entity.world;
      BlockPos blockpos = new BlockPos(this.entity);
      BlockPos blockpos1 = this.findTarget(blockpos, world);
      Random random = this.entity.getRNG();
      if (this.getIsAboveDestination() && blockpos1 != null) {
         if (this.breakingTime > 0) {
            Vec3d vec3d = this.entity.getMotion();
            this.entity.setMotion(vec3d.x, 0.3D, vec3d.z);
            if (!world.isRemote) {
               double d0 = 0.08D;
               ((ServerWorld)world).spawnParticle(new ItemParticleData(ParticleTypes.ITEM, new ItemStack(Items.EGG)), (double)blockpos1.getX() + 0.5D, (double)blockpos1.getY() + 0.7D, (double)blockpos1.getZ() + 0.5D, 3, ((double)random.nextFloat() - 0.5D) * 0.08D, ((double)random.nextFloat() - 0.5D) * 0.08D, ((double)random.nextFloat() - 0.5D) * 0.08D, (double)0.15F);
            }
         }

         if (this.breakingTime % 2 == 0) {
            Vec3d vec3d1 = this.entity.getMotion();
            this.entity.setMotion(vec3d1.x, -0.3D, vec3d1.z);
            if (this.breakingTime % 6 == 0) {
               this.playBreakingSound(world, this.destinationBlock);
            }
         }

         if (this.breakingTime > 60) {
            WN.LOGGER.debug("Breaking block");
            world.destroyBlock(blockpos1, true);
            if (!world.isRemote) {
               for(int i = 0; i < 20; ++i) {
                  double d3 = random.nextGaussian() * 0.02D;
                  double d1 = random.nextGaussian() * 0.02D;
                  double d2 = random.nextGaussian() * 0.02D;
                  ((ServerWorld)world).spawnParticle(ParticleTypes.POOF, (double)blockpos1.getX() + 0.5D, (double)blockpos1.getY(), (double)blockpos1.getZ() + 0.5D, 1, d3, d1, d2, (double)0.15F);
               }

               this.playBrokenSound(world, blockpos1);
            }
         }

         ++this.breakingTime;
      }

   }

   @Nullable
   private BlockPos findTarget(BlockPos p_203115_1_, IBlockReader p_203115_2_) {
      if (checkIfBlockEquals(p_203115_2_.getBlockState(p_203115_1_).getBlock())) {
         return p_203115_1_;
      } else {
         BlockPos[] ablockpos = new BlockPos[]{p_203115_1_.down(), p_203115_1_.west(), p_203115_1_.east(), p_203115_1_.north(), p_203115_1_.south(), p_203115_1_.down().down()};

         for(BlockPos blockpos : ablockpos) {
            if (checkIfBlockEquals(p_203115_2_.getBlockState(blockpos).getBlock())) {
               return blockpos;
            }
         }

         return null;
      }
   }

   /**
    * Return true to set given position as destination
    */
   protected boolean shouldMoveTo(IWorldReader worldIn, BlockPos pos) {
      IChunk ichunk = worldIn.getChunk(pos.getX() >> 4, pos.getZ() >> 4, ChunkStatus.FULL, false);
      if (ichunk == null) {
         return false;
      } else {
         return checkIfBlockEquals(ichunk.getBlockState(pos).getBlock()) && ichunk.getBlockState(pos.up()).isAir() && ichunk.getBlockState(pos.up(2)).isAir();
      }
   }

   public boolean checkIfBlockEquals(Block b){
      for (Block block : blocks) {
         if(block==b){
            return true;
         }
      }
      return false;
   }
}