package com.matez.wildnature.common.entity.render.layer.blowdarts;

import com.matez.wildnature.common.entity.type.misc.blowpipe.darts.RowanBlowdartEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.layers.StuckInBodyLayer;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RowanBlowdartLayer<T extends LivingEntity, M extends PlayerModel<T>> extends StuckInBodyLayer<T, M> {
   private final EntityRendererManager renderManager;
   private RowanBlowdartEntity dartEntity;

   public RowanBlowdartLayer(LivingRenderer<T, M> rendererIn) {
      super(rendererIn);
      this.renderManager = rendererIn.getRenderManager();
   }

   protected int func_225631_a_(T p_225631_1_) {
      return p_225631_1_.getArrowCountInEntity();
   }

   protected void func_225632_a_(MatrixStack p_225632_1_, IRenderTypeBuffer p_225632_2_, int p_225632_3_, Entity entity, float p_225632_5_, float p_225632_6_, float p_225632_7_, float p_225632_8_) {
      float f = MathHelper.sqrt(p_225632_5_ * p_225632_5_ + p_225632_7_ * p_225632_7_);
      this.dartEntity = new RowanBlowdartEntity(entity.world, entity.getPosX(), entity.getPosY(), entity.getPosZ());
      this.dartEntity.rotationYaw = (float)(Math.atan2((double)p_225632_5_, (double)p_225632_7_) * (double)(180F / (float)Math.PI));
      this.dartEntity.rotationPitch = (float)(Math.atan2((double)p_225632_6_, (double)f) * (double)(180F / (float)Math.PI));
      this.dartEntity.prevRotationYaw = this.dartEntity.rotationYaw;
      this.dartEntity.prevRotationPitch = this.dartEntity.rotationPitch;
      this.renderManager.renderEntityStatic(this.dartEntity, 0.0D, 0.0D, 0.0D, 0.0F, p_225632_8_, p_225632_1_, p_225632_2_, p_225632_3_);
   }
}
