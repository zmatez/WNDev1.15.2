package com.matez.wildnature.entity.render.cape;

import com.matez.wildnature.event.PlayerEventHandler;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.player.PlayerModelPart;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WNCapeLayer extends LayerRenderer<AbstractClientPlayerEntity, PlayerModel<AbstractClientPlayerEntity>> {
    public WNCapeLayer(IEntityRenderer<AbstractClientPlayerEntity, PlayerModel<AbstractClientPlayerEntity>> p_i50950_1_) {
        super(p_i50950_1_);
    }

    public void render(MatrixStack matrix, IRenderTypeBuffer renderBuffer, int packedLightIn, AbstractClientPlayerEntity playerEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        ResourceLocation rl = PlayerEventHandler.getCapeResourceLocation(playerEntity);
        if (playerEntity.hasPlayerInfo() && !playerEntity.isInvisible() && playerEntity.isWearing(PlayerModelPart.CAPE) && rl != null) {
            ItemStack lvt_11_1_ = playerEntity.getItemStackFromSlot(EquipmentSlotType.CHEST);
            if (lvt_11_1_.getItem() != Items.ELYTRA) {
                matrix.push();
                matrix.translate(0.0D, 0.0D, 0.125D);
                double lvt_12_1_ = MathHelper.lerp((double)partialTicks, playerEntity.prevChasingPosX, playerEntity.chasingPosX) - MathHelper.lerp((double)partialTicks, playerEntity.prevPosX, playerEntity.getPosX());
                double lvt_14_1_ = MathHelper.lerp((double)partialTicks, playerEntity.prevChasingPosY, playerEntity.chasingPosY) - MathHelper.lerp((double)partialTicks, playerEntity.prevPosY, playerEntity.getPosY());
                double lvt_16_1_ = MathHelper.lerp((double)partialTicks, playerEntity.prevChasingPosZ, playerEntity.chasingPosZ) - MathHelper.lerp((double)partialTicks, playerEntity.prevPosZ, playerEntity.getPosZ());
                float lvt_18_1_ = playerEntity.prevRenderYawOffset + (playerEntity.renderYawOffset - playerEntity.prevRenderYawOffset);
                double lvt_19_1_ = (double)MathHelper.sin(lvt_18_1_ * 0.017453292F);
                double lvt_21_1_ = (double)(-MathHelper.cos(lvt_18_1_ * 0.017453292F));
                float lvt_23_1_ = (float)lvt_14_1_ * 10.0F;
                lvt_23_1_ = MathHelper.clamp(lvt_23_1_, -6.0F, 32.0F);
                float lvt_24_1_ = (float)(lvt_12_1_ * lvt_19_1_ + lvt_16_1_ * lvt_21_1_) * 100.0F;
                lvt_24_1_ = MathHelper.clamp(lvt_24_1_, 0.0F, 150.0F);
                float lvt_25_1_ = (float)(lvt_12_1_ * lvt_21_1_ - lvt_16_1_ * lvt_19_1_) * 100.0F;
                lvt_25_1_ = MathHelper.clamp(lvt_25_1_, -20.0F, 20.0F);
                if (lvt_24_1_ < 0.0F) {
                    lvt_24_1_ = 0.0F;
                }

                float lvt_26_1_ = MathHelper.lerp(partialTicks, playerEntity.prevCameraYaw, playerEntity.cameraYaw);
                lvt_23_1_ += MathHelper.sin(MathHelper.lerp(partialTicks, playerEntity.prevDistanceWalkedModified, playerEntity.distanceWalkedModified) * 6.0F) * 32.0F * lvt_26_1_;
                if (playerEntity.isCrouching()) {
                    lvt_23_1_ += 25.0F;
                }

                matrix.rotate(Vector3f.XP.rotationDegrees(6.0F + lvt_24_1_ / 2.0F + lvt_23_1_));
                matrix.rotate(Vector3f.ZP.rotationDegrees(lvt_25_1_ / 2.0F));
                matrix.rotate(Vector3f.YP.rotationDegrees(180.0F - lvt_25_1_ / 2.0F));
                IVertexBuilder lvt_27_1_ = renderBuffer.getBuffer(RenderType.getEntitySolid(rl));
                ((PlayerModel)this.getEntityModel()).renderCape(matrix, lvt_27_1_, packedLightIn, OverlayTexture.NO_OVERLAY);
                matrix.pop();
            }
        }
    }

}
