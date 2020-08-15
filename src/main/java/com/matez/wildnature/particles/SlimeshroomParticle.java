package com.matez.wildnature.particles;

import com.matez.wildnature.registry.ParticleRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SlimeshroomParticle extends SpriteTexturedParticle {
    private final float field_217571_C;
    private final float field_217572_F;

    private SlimeshroomParticle(World p_i47644_1_, double p_i47644_2_, double p_i47644_4_, double p_i47644_6_, double p_i47644_8_, double p_i47644_10_, double p_i47644_12_) {
        this(p_i47644_1_, p_i47644_2_, p_i47644_4_, p_i47644_6_);
        this.motionX *= 0.00000000149011612D;
        this.motionY *= 0.00000000149011612D;
        this.motionZ *= 0.00000000149011612D;
        this.motionX += p_i47644_8_;
        this.motionY += p_i47644_10_;
        this.motionZ += p_i47644_12_;
    }

    public IParticleRenderType getRenderType() {
        return IParticleRenderType.PARTICLE_SHEET_LIT;
    }

    protected SlimeshroomParticle(World p_i47645_1_, double p_i47645_2_, double p_i47645_4_, double p_i47645_6_) {
        super(p_i47645_1_, p_i47645_2_, p_i47645_4_, p_i47645_6_, 0.0D, 0.0D, 0.0D);
        this.particleGravity = 1.0F;
        this.particleScale /= 2.0F;
        this.field_217571_C = this.rand.nextFloat() * 3.0F;
        this.field_217572_F = this.rand.nextFloat() * 3.0F;
    }

    protected float getMinU() {
        return this.sprite.getInterpolatedU((double)((this.field_217571_C + 1.0F) / 4.0F * 16.0F));
    }

    protected float getMaxU() {
        return this.sprite.getInterpolatedU((double)(this.field_217571_C / 4.0F * 16.0F));
    }

    protected float getMinV() {
        return this.sprite.getInterpolatedV((double)(this.field_217572_F / 4.0F * 16.0F));
    }

    protected float getMaxV() {
        return this.sprite.getInterpolatedV((double)((this.field_217572_F + 1.0F) / 4.0F * 16.0F));
    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements IParticleFactory<BasicParticleType> {
        private final IAnimatedSprite spriteSet;

        public Factory(IAnimatedSprite p_i51180_1_) {
            this.spriteSet = p_i51180_1_;
        }

        public Particle makeParticle(BasicParticleType typeIn, World worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            SlimeshroomParticle slime = new SlimeshroomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed);
            slime.setAlphaF(0.95F);
            slime.selectSpriteRandomly(this.spriteSet);
            return slime;
        }
    }

    public enum SlimeshroomColor implements IStringSerializable{
        BLUE("blue"),
        GREEN("green");

        private String name = "";
        private SlimeshroomColor(String name){
            this.name=name;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}