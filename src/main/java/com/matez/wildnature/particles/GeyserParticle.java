package com.matez.wildnature.particles;

import com.matez.wildnature.other.Utilities;
import net.minecraft.client.particle.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.ArrayList;

@OnlyIn(Dist.CLIENT)
public class GeyserParticle extends SpriteTexturedParticle {
   private GeyserParticle(World p_i51046_1_, double p_i51046_2_, double p_i51046_4_, double p_i51046_6_, double p_i51046_8_, double p_i51046_10_, double p_i51046_12_, boolean p_i51046_14_) {
      super(p_i51046_1_, p_i51046_2_, p_i51046_4_, p_i51046_6_);
      this.multipleParticleScaleBy(3.0F);
      this.setSize(0.25F, 0.25F);
      if (p_i51046_14_) {
         this.maxAge = this.rand.nextInt(50) + 280;
      } else {
         this.maxAge = this.rand.nextInt(50) + 80;
      }
      float f1 = 1.0F - (float)(Math.random() * (double)0.3F);
      this.particleRed = f1;
      this.particleGreen = f1;
      this.particleBlue = f1;
      this.particleGravity = 3.0E-6F;
      this.motionX = p_i51046_8_;
      this.motionY = p_i51046_10_ + (double)(this.rand.nextFloat() / 500.0F);
      this.motionZ = p_i51046_12_;
   }

   public void tick() {
      this.prevPosX = this.posX;
      this.prevPosY = this.posY;
      this.prevPosZ = this.posZ;
      if (this.age++ < this.maxAge && !(this.particleAlpha <= 0.0F)) {
         this.motionX += (double)(this.rand.nextFloat() / 5000.0F * (float)(this.rand.nextBoolean() ? 1 : -1));
         this.motionZ += (double)(this.rand.nextFloat() / 5000.0F * (float)(this.rand.nextBoolean() ? 1 : -1));
         this.motionY -= (double)this.particleGravity;
         this.move(this.motionX, this.motionY, this.motionZ);
         if (this.age >= this.maxAge - 60 && this.particleAlpha > 0.01F) {
            this.particleAlpha -= 0.015F;
         }

         ArrayList<LivingEntity> entity = (ArrayList<LivingEntity>)this.world.getEntitiesWithinAABB(LivingEntity.class,this.getBoundingBox());
         ArrayList<ItemEntity> itementity = (ArrayList<ItemEntity>)this.world.getEntitiesWithinAABB(ItemEntity.class,this.getBoundingBox());
         double divider = 10;
         for (LivingEntity e : entity){
            e.setMotion(e.getMotion().x+(motionX/divider),e.getMotion().y+(motionY/divider),e.getMotion().z+(motionZ/divider));
            if(Utilities.rint(0,20)==0){

            }
         }
         for (ItemEntity e : itementity){
            e.setMotion(e.getMotion().x+(motionX/divider),e.getMotion().y+(motionY/divider),e.getMotion().z+(motionZ/divider));
         }

      } else {
         this.setExpired();
      }
   }

   public IParticleRenderType getRenderType() {
      return IParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
   }

   @OnlyIn(Dist.CLIENT)
   public static class GeyserParticleFactory implements IParticleFactory<BasicParticleType> {
      private final IAnimatedSprite spriteSet;

      public GeyserParticleFactory(IAnimatedSprite p_i51180_1_) {
         this.spriteSet = p_i51180_1_;
      }

      public Particle makeParticle(BasicParticleType typeIn, World worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
         GeyserParticle geyserParticle = new GeyserParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, false);
         geyserParticle.setAlphaF(0.95F);
         geyserParticle.selectSpriteRandomly(this.spriteSet);
         return geyserParticle;
      }
   }

}