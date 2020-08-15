package com.matez.wildnature.entity.AI.Movement;

import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.util.math.MathHelper;

public class FlyingMovementControllerOld extends MovementController {
   private float moveForwardSpeed = 0, moveVerticalSpeed = 0;
   public FlyingMovementControllerOld(MobEntity p_i47418_1_, float moveForwardSpeed) {
      super(p_i47418_1_);
      this.moveForwardSpeed = moveForwardSpeed;
   }

   public void setMoveForwardSpeed(float moveForwardSpeed) {
      this.moveForwardSpeed = moveForwardSpeed;
   }

   public void tick() {
      if (this.action == MovementController.Action.MOVE_TO) {
         this.action = MovementController.Action.WAIT;
         this.mob.setNoGravity(true);
         double posX = this.posX - this.mob.getPosition().getX();
         double posY = this.posY - this.mob.getPosition().getY();
         double posZ = this.posZ - this.mob.getPosition().getZ();
         double dPos = posX * posX + posY * posY + posZ * posZ;
         if (dPos < (double)30.5000003E-7F) {
            this.mob.setMoveVertical(0.0F);
            this.mob.setMoveForward(0.0F);
            return;
         }

         float f = (float)(MathHelper.atan2(posZ, posX) * (double)(180F / (float)Math.PI)) - 90.0F;
         this.mob.rotationYaw = this.limitAngle(this.mob.rotationYaw, f, 10.0F);
         float moveSpeed;
         if (this.mob.onGround) {
            moveSpeed = (float)(this.speed * this.mob.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue());
         } else {
            if(moveVerticalSpeed==0) {
               moveSpeed = (float) (this.speed * this.mob.getAttribute(SharedMonsterAttributes.FLYING_SPEED).getValue());
            }else{
               moveSpeed=moveVerticalSpeed;
            }
         }

         this.mob.setAIMoveSpeed(moveForwardSpeed);
         double d4 = (double)MathHelper.sqrt(posX * posX + posZ * posZ);
         float angle = (float)(-(MathHelper.atan2(posY, d4) * (double)(180F / (float)Math.PI)));
         this.mob.rotationPitch = this.limitAngle(this.mob.rotationPitch, angle, 10.0F);
         this.mob.setMoveVertical(posY > 0.0D ? moveSpeed : -moveSpeed);
      } else {
         this.mob.setNoGravity(false);
         this.mob.setMoveVertical(0.0F);
         this.mob.setMoveForward(0.0F);
      }

   }
}