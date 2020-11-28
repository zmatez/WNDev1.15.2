package com.matez.wildnature.common.entity.render.misc.blowpipe;

import com.matez.wildnature.common.entity.model.misc.blowpipe.RowanBlowdartHitModel;
import com.matez.wildnature.common.entity.model.misc.blowpipe.RowanBlowdartModel;
import com.matez.wildnature.common.entity.type.misc.blowpipe.darts.RowanBlowdartEntity;
import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.lists.WNItems;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class RowanBlowdartRender extends EntityRenderer<RowanBlowdartEntity> implements IEntityRenderer<RowanBlowdartEntity, RowanBlowdartModel> {
    private RowanBlowdartModel entityModel;
    private RowanBlowdartHitModel entityHitModel;
    public RowanBlowdartRender(EntityRendererManager manager) {
        super(manager);
        entityModel = getEntityModel();
        entityHitModel = getEntityModelHit();
    }

    @Override
    public RowanBlowdartModel getEntityModel() {
        return new RowanBlowdartModel();
    }

    public RowanBlowdartHitModel getEntityModelHit() {
        return new RowanBlowdartHitModel();
    }

    @Override
    public ResourceLocation getEntityTexture(RowanBlowdartEntity entity) {
        if(entity.getItem() == WNItems.ROWANBERRY_ORANGE){
            return WN.RegistryEvents.location("textures/items/rowanberry_cluster_orange.png");
        }
        return WN.RegistryEvents.location("textures/items/rowanberry_cluster_red.png");
    }

    @Override
    public void render(RowanBlowdartEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        matrixStackIn.push();
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90.0F));
        matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
        float f9 = (float)entityIn.arrowShake - partialTicks;
        if (f9 > 0.0F) {
            float f10 = -MathHelper.sin(f9 * 3.0F) * f9;
            matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(f10));
        }

        matrixStackIn.scale(1F, 1F, 1F);
        matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(-90.0F));
        matrixStackIn.translate(0.0D, -1.4D, 0.0D);
        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
        int x = getPackedOverlay(entityIn, this.getOverlayProgress(entityIn, partialTicks));
        boolean flag = !entityIn.isInvisible();
        boolean flag1 = !flag && !entityIn.isInvisibleToPlayer(Minecraft.getInstance().player);
        if(entityIn.isInGround()){
            this.entityHitModel.render(matrixStackIn, ivertexbuilder, packedLightIn, x, 1.0F, 1.0F, 1.0F, 1.0F);
        }else {
            this.entityModel.render(matrixStackIn, ivertexbuilder, packedLightIn, x, 1.0F, 1.0F, 1.0F, 1.0F);
        }

        matrixStackIn.pop();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        //this.renderName(entityIn, "Szczała", matrixStackIn, bufferIn, packedLightIn);
    }

    public static int getPackedOverlay(RowanBlowdartEntity livingEntityIn, float uIn) {
        return OverlayTexture.getPackedUV(OverlayTexture.getU(uIn), OverlayTexture.getV(false));
    }

    protected float getOverlayProgress(RowanBlowdartEntity livingEntityIn, float partialTicks) {
        return 0.0F;
    }

    @Nullable
    protected RenderType getRenderType(RowanBlowdartEntity entity, boolean p_230042_2_, boolean p_230042_3_) {
        ResourceLocation resourcelocation = this.getEntityTexture(entity);
        if (p_230042_3_) {
            return RenderType.getEntityTranslucent(resourcelocation);
        } else if (p_230042_2_) {
            return this.entityModel.getRenderType(resourcelocation);
        } else {
            return entity.isGlowing() ? RenderType.getOutline(resourcelocation) : null;
        }
    }

    public static class RenderFactory implements IRenderFactory<RowanBlowdartEntity>{
        @Override
        public EntityRenderer<? super RowanBlowdartEntity> createRenderFor(EntityRendererManager manager) {
            return new RowanBlowdartRender(manager);
        }
    }

    public void drawVertex(Matrix4f matrix, Matrix3f normals, IVertexBuilder vertexBuilder, int offsetX, int offsetY, int offsetZ, float textureX, float textureY, int p_229039_9_, int p_229039_10_, int p_229039_11_, int packedLightIn) {
        vertexBuilder.pos(matrix, (float)offsetX, (float)offsetY, (float)offsetZ).color(255, 255, 255, 255).tex(textureX, textureY).overlay(OverlayTexture.NO_OVERLAY).lightmap(packedLightIn).normal(normals, (float)p_229039_9_, (float)p_229039_11_, (float)p_229039_10_).endVertex();
    }
}
