package com.matez.wildnature.common.entity.AI;

import javax.annotation.Nullable;

import com.matez.wildnature.init.Main;
import com.matez.wildnature.common.entity.AI.Navigator.WNRandomPosGen;
import com.matez.wildnature.common.entity.type.animal.duck.AbstractDuckEntity;
import com.matez.wildnature.util.other.Utilities;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
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