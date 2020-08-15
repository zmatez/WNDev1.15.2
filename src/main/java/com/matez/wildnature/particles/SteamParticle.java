package com.matez.wildnature.particles;

import com.matez.wildnature.customizable.CommonConfig;
import net.minecraft.client.particle.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.util.ReuseableStream;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.ArrayList;
import java.util.stream.Stream;

@OnlyIn(Dist.CLIENT)
public class SteamParticle extends SpriteTexturedParticle {
   private final IAnimatedSprite field_217583_C;
   public boolean touchingBlock = false;

   private SteamParticle(World p_i51015_1_, double p_i51015_2_, double p_i51015_4_, double p_i51015_6_, double p_i51015_8_, double p_i51015_10_, double p_i51015_12_, IAnimatedSprite p_i51015_14_) {
      super(p_i51015_1_, p_i51015_2_, p_i51015_4_, p_i51015_6_, 0.0D, 0.0D, 0.0D);
      this.field_217583_C = p_i51015_14_;
      float f = 2.5F;
      this.motionX *= (double)0.1F;
      this.motionY *= (double)0.1F;
      this.motionZ *= (double)0.1F;
      this.motionX += p_i51015_8_;
      this.motionY += p_i51015_10_;
      this.motionZ += p_i51015_12_;
      float f1 = 1.0F - (float)(Math.random() * (double)0.3F);
      this.particleRed = f1;
      this.particleGreen = f1;
      this.particleBlue = f1;
      this.particleScale *= 1.875F;
      int i = (int)(8.0D / (Math.random() * 0.8D + 0.3D));
      this.maxAge = (int)Math.max((float)i * CommonConfig.steamMaxAge.get(), 1.0F);
      this.canCollide = true;
      this.selectSpriteWithAge(p_i51015_14_);
   }

   public IParticleRenderType getRenderType() {
      return IParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
   }

   public float getScale(float p_217561_1_) {
      return this.particleScale * MathHelper.clamp(((float)this.age + p_217561_1_) / (float)this.maxAge * 32.0F, 0.0F, 1.0F);
   }

   public void tick() {
      this.prevPosX = this.posX;
      this.prevPosY = this.posY;
      this.prevPosZ = this.posZ;
      if (this.age++ >= this.maxAge) {
         this.setExpired();
      } else {


         this.selectSpriteWithAge(this.field_217583_C);
         this.move(this.motionX, this.motionY, this.motionZ);
         this.motionX *= (double)0.96F;
         this.motionY *= (double)0.96F;
         this.motionZ *= (double)0.96F;
         /*PlayerEntity playerentity = this.world.getClosestPlayer(this.posX, this.posY, this.posZ, 2.0D, false);
         if (playerentity != null) {
            AxisAlignedBB axisalignedbb = playerentity.getBoundingBox();
            if (this.posY > axisalignedbb.minY) {
               this.posY += (axisalignedbb.minY - this.posY) * 0.2D;
               this.motionY += (playerentity.getMotion().y - this.motionY) * 0.2D;
               this.setPosition(this.posX, this.posY, this.posZ);
            }
         }*/

         ArrayList<LivingEntity> entity = (ArrayList<LivingEntity>)this.world.getEntitiesWithinAABB(LivingEntity.class,this.getBoundingBox());
         ArrayList<ItemEntity> itementity = (ArrayList<ItemEntity>)this.world.getEntitiesWithinAABB(ItemEntity.class,this.getBoundingBox());
         double divider = 20;
         for (LivingEntity e : entity){
            e.setMotion(e.getMotion().x+(motionX/divider),e.getMotion().y+(motionY/divider),e.getMotion().z+(motionZ/divider));
         }
         for (ItemEntity e : itementity){
            e.setMotion(e.getMotion().x+(motionX/divider),e.getMotion().y+(motionY/divider),e.getMotion().z+(motionZ/divider));
         }




      }
   }

   public void move(double x, double y, double z) {
      double d0 = x;
      double d1 = y;
      double origZ = z;
      if (this.canCollide && (x != 0.0D || y != 0.0D || z != 0.0D)) {
         Vec3d vec3d = Entity.collideBoundingBoxHeuristically((Entity)null, new Vec3d(x, y, z), this.getBoundingBox(), this.world, ISelectionContext.dummy(), new ReuseableStream<>(Stream.empty()));
         x = vec3d.x;
         y = vec3d.y;
         z = vec3d.z;
      }

      if (x != 0.0D || y != 0.0D || z != 0.0D) {
         this.setBoundingBox(this.getBoundingBox().offset(x, y, z));
         this.resetPositionToBB();
      }
      double div = 5;
      this.onGround = d1 != y && d1 < 0.0D;
      if (d0 != x) {
         this.motionX = -(motionX/5);
         this.touchingBlock=true;
      }

      if (d1 != y) {
         this.motionY = -(motionY/5);
         this.touchingBlock=true;
      }

      if (origZ != z) {
         this.motionZ = -(motionZ/5);
         this.touchingBlock=true;
      }

   }

   @OnlyIn(Dist.CLIENT)
   public static class Factory implements IParticleFactory<BasicParticleType> {
      private final IAnimatedSprite spriteSet;

      public Factory(IAnimatedSprite p_i50630_1_) {
         this.spriteSet = p_i50630_1_;
      }

      public Particle makeParticle(BasicParticleType typeIn, World worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
         return new SteamParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
      }
   }

}