package com.matez.wildnature.particles;

import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.*;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class DustParticle extends SpriteTexturedParticle {
    private final float rotSpeed;
    private final IAnimatedSprite field_217580_F;

    private DustParticle(World p_i51033_1_, double p_i51033_2_, double p_i51033_4_, double p_i51033_6_, double p_i51046_8_, double p_i51046_10_, double p_i51046_12_, IAnimatedSprite p_i51033_11_) {
        super(p_i51033_1_, p_i51033_2_, p_i51033_4_, p_i51033_6_);
        this.field_217580_F = p_i51033_11_;
        this.particleScale *= 0.67499995F;
        int lvt_13_1_ = (int)(32.0D / (Math.random() * 0.8D + 0.2D));
        this.maxAge = (int)Math.max((float)lvt_13_1_ * 0.9F, 1.0F);
        this.selectSpriteWithAge(p_i51033_11_);
        this.rotSpeed = ((float)Math.random() - 0.5F) * 0.1F;
        this.particleAngle = (float)Math.random() * 6.2831855F;
        this.motionX = p_i51046_8_;
        this.motionY = p_i51046_10_ + (double)(this.rand.nextFloat() / 500.0F);
        this.motionZ = p_i51046_12_;
    }

    public IParticleRenderType getRenderType() {
        return IParticleRenderType.PARTICLE_SHEET_OPAQUE;
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
            this.selectSpriteWithAge(this.field_217580_F);
            this.prevParticleAngle = this.particleAngle;
            this.particleAngle += 3.1415927F * this.rotSpeed * 2.0F;
            if (this.onGround) {
                this.prevParticleAngle = this.particleAngle = 0.0F;
            }

            this.move(this.motionX, this.motionY, this.motionZ);
            this.motionY -= 0.003000000026077032D;
            this.motionY = Math.max(this.motionY, -0.14000000059604645D);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements IParticleFactory<BasicParticleType> {
        private final IAnimatedSprite spriteSet;

        public Factory(IAnimatedSprite p_i51180_1_) {
            this.spriteSet = p_i51180_1_;
        }

        public Particle makeParticle(BasicParticleType typeIn, World worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            DustParticle dust = new DustParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed,this.spriteSet);
            dust.setAlphaF(0.95F);
            dust.selectSpriteRandomly(this.spriteSet);
            return dust;
        }
    }
}
