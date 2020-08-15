package com.matez.wildnature.entity.AI;

import com.matez.wildnature.entity.AI.Navigator.WNRandomPosGen;
import com.matez.wildnature.other.Utilities;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

import javax.annotation.Nullable;

public class RandomSwimmingGoal extends RandomWalkingGoal {
   protected final float probability;
   private int xz=10, y=7;

   public RandomSwimmingGoal(CreatureEntity creature, double speedIn) {
      this(creature, speedIn, 0.001F,10,7);
   }

   public RandomSwimmingGoal(CreatureEntity creature, double speedIn, float probabilityIn, int xz, int y) {
      super(creature, speedIn);
      this.probability = probabilityIn;
      this.xz=xz;
      this.y=y;
   }

   @Nullable
   protected Vec3d getPosition() {
      for(int i = 0; i < 30; i++) {
         Vec3d random = WNRandomPosGen.findRandomTarget(this.creature, xz, y,true);
         if(random!=null) {
            BlockPos pos = new BlockPos((int) random.x, (int) random.y, (int) random.z);
            Block b = creature.getEntityWorld().getBlockState(pos.down()).getBlock();
            if (b == Blocks.WATER) {
               if(Utilities.blockDistance(pos,creature.getPosition())>xz/2) {
                  return random;
               }
            }
         }
      }
      return super.getPosition();
   }
}