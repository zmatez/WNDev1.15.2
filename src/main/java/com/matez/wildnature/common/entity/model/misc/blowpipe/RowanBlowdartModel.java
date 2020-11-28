package com.matez.wildnature.common.entity.model.misc.blowpipe;

import com.matez.wildnature.common.entity.type.misc.blowpipe.darts.RowanBlowdartEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class RowanBlowdartModel extends EntityModel<RowanBlowdartEntity> {
	private final ModelRenderer bb_main,bb_main_r1,bb_main_r2;

	public RowanBlowdartModel() {
		textureWidth = 16;
		textureHeight = 16;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.setTextureOffset(8, 8).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bb_main_r1 = new ModelRenderer(this);
		bb_main_r1.setRotationPoint(0.0F, 0.2F, -0.5F);
		bb_main.addChild(bb_main_r1);
		setRotationAngle(bb_main_r1, 0.0F, -0.7854F, 0.7854F);
		bb_main_r1.setTextureOffset(8, 8).addBox(-0.5F, -1.0F, 0.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bb_main_r2 = new ModelRenderer(this);
		bb_main_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bb_main.addChild(bb_main_r2);
		setRotationAngle(bb_main_r2, -0.0436F, -0.7854F, 0.0F);
		bb_main_r2.setTextureOffset(8, 8).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(RowanBlowdartEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}