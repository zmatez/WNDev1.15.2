package com.matez.wildnature.particles;

import net.minecraft.client.particle.IAnimatedSprite;
import net.minecraft.client.particle.TexturedParticle;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public abstract class WNSpriteTexturedParticle extends TexturedParticle {
   public TextureAtlasSprite sprite;

   public WNSpriteTexturedParticle(World p_i50998_1_, double p_i50998_2_, double p_i50998_4_, double p_i50998_6_) {
      super(p_i50998_1_, p_i50998_2_, p_i50998_4_, p_i50998_6_);
   }

   public WNSpriteTexturedParticle(World p_i50999_1_, double p_i50999_2_, double p_i50999_4_, double p_i50999_6_, double p_i50999_8_, double p_i50999_10_, double p_i50999_12_) {
      super(p_i50999_1_, p_i50999_2_, p_i50999_4_, p_i50999_6_, p_i50999_8_, p_i50999_10_, p_i50999_12_);
   }

   public void setSprite(TextureAtlasSprite sprite) {
      this.sprite = sprite;
   }

   public float getMinU() {
      return this.sprite.getMinU();
   }

   public float getMaxU() {
      return this.sprite.getMaxU();
   }

   public float getMinV() {
      return this.sprite.getMinV();
   }

   public float getMaxV() {
      return this.sprite.getMaxV();
   }

   public void selectSpriteRandomly(IAnimatedSprite p_217568_1_) {
      this.setSprite(p_217568_1_.get(this.rand));
   }

   public void selectSpriteWithAge(IAnimatedSprite p_217566_1_) {
      this.setSprite(p_217566_1_.get(this.age, this.maxAge));
   }
}