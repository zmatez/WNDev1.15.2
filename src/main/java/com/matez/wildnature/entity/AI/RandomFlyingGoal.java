package com.matez.wildnature.entity.AI;

import java.util.Iterator;
import javax.annotation.Nullable;

import com.matez.wildnature.Main;
import com.matez.wildnature.entity.AI.Navigator.WNRandomPosGen;
import com.matez.wildnature.entity.type.animal.duck.AbstractDuckEntity;
import com.matez.wildnature.other.Utilities;
import net.minecraft.block.Block;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class RandomFlyingGoal extends RandomWalkingGoal {
   public RandomFlyingGoal(CreatureEntity creatureEntity, double speed) {
      super(creatureEntity, speed);
   }

   public RandomFlyingGoal(CreatureEntity creatureEntity, double speed, int chance) {
      super(creatureEntity, speed, chance);
   }

   @Override
   public boolean shouldExecute() {
      return super.shouldExecute();
   }

   @Nullable
   protected Vec3d getPosition() {
      Vec3d vec3d = null;
      if (this.creature.getRNG().nextFloat() >= this.executionChance || !(creature.onGround && creature.isInWater())) {
         vec3d = WNRandomPosGen.getLandPos(creature,100,30,true);
         Main.LOGGER.debug("Flying navigation to " + vec3d);
         if(creature instanceof AbstractDuckEntity){
            ((AbstractDuckEntity) creature).setFlying(true);
         }
      }else{
         if(creature instanceof AbstractDuckEntity){
            ((AbstractDuckEntity) creature).setFlying(false);
         }
      }

      return vec3d == null ? super.getPosition() : new Vec3d(vec3d.x,vec3d.y+ Utilities.rint(0,7),vec3d.z);
   }
}