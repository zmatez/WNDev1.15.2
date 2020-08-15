package com.matez.wildnature.entity.model.animal;// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

import com.matez.wildnature.entity.type.animal.duck.DucklingEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class DucklingModel extends EntityModel<DucklingEntity> {
	private final ModelRenderer neck;
	private final ModelRenderer head;
	private final ModelRenderer beak2;
	private final ModelRenderer beak;
	private final ModelRenderer body;
	private final ModelRenderer body2;
	private final ModelRenderer body3;
	private final ModelRenderer wing1;
	private final ModelRenderer wing2;
	private final ModelRenderer RightLeg;
	private final ModelRenderer RightFoot;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer LeftFoot;

	public DucklingModel() {
		textureWidth = 64;
		textureHeight = 32;

		neck = new ModelRenderer(this);
		neck.setRotationPoint(0.0F, 20.8F, -1.0F);
		setRotationAngle(neck, -1.139F, 0.0F, 0.0F);
		neck.setTextureOffset(18, 9).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -2.0F, -4.3F);
		neck.addChild(head);
		setRotationAngle(head, 1.1694F, 0.0F, 0.0F);
		head.setTextureOffset(0, 0).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		beak2 = new ModelRenderer(this);
		beak2.setRotationPoint(1.0F, 0.7F, -1.1F);
		head.addChild(beak2);
		setRotationAngle(beak2, 0.4166F, 0.0F, 0.0F);
		beak2.setTextureOffset(26, 0).addBox(-1.5F, 0.0F, -3.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		beak = new ModelRenderer(this);
		beak.setRotationPoint(0.5F, 1.9F, -1.5F);
		head.addChild(beak);
		beak.setTextureOffset(35, 0).addBox(-1.5F, 0.0F, -3.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(-2.0F, 18.0F, -1.5F);
		setRotationAngle(body, -0.1791F, 0.0F, 0.0F);
		body.setTextureOffset(30, 9).addBox(0.0F, 0.0F, 0.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);

		body2 = new ModelRenderer(this);
		body2.setRotationPoint(-1.5F, 18.9F, 1.3F);
		setRotationAngle(body2, -0.0087F, 0.0F, 0.0F);
		body2.setTextureOffset(30, 19).addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 3.0F, 0.0F, false);

		body3 = new ModelRenderer(this);
		body3.setRotationPoint(0.5F, 2.4F, -0.1F);
		body2.addChild(body3);
		setRotationAngle(body3, 0.6981F, 0.0F, 0.0F);
		body3.setTextureOffset(16, 19).addBox(0.0F, 0.0F, 0.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);

		wing1 = new ModelRenderer(this);
		wing1.setRotationPoint(-2.0F, 18.4F, -1.4F);
		setRotationAngle(wing1, 0.0F, -0.4712F, 0.0F);
		wing1.setTextureOffset(28, 25).addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 3.0F, 0.0F, false);

		wing2 = new ModelRenderer(this);
		wing2.setRotationPoint(1.0F, 18.5F, -1.0F);
		setRotationAngle(wing2, 0.0F, 0.5236F, 0.0F);
		wing2.setTextureOffset(28, 25).addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 3.0F, 0.0F, true);

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-1.5F, 22.0F, 0.0F);
		RightLeg.setTextureOffset(0, 16).addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		RightFoot = new ModelRenderer(this);
		RightFoot.setRotationPoint(-0.5F, 1.9F, -0.8F);
		RightLeg.addChild(RightFoot);
		RightFoot.setTextureOffset(1, 23).addBox(0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(0.5F, 22.0F, 0.0F);
		LeftLeg.setTextureOffset(0, 16).addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		LeftFoot = new ModelRenderer(this);
		LeftFoot.setRotationPoint(-0.5F, 1.9F, -0.8F);
		LeftLeg.addChild(LeftFoot);
		LeftFoot.setTextureOffset(1, 23).addBox(0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(DucklingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		neck.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		body2.render(matrixStack, buffer, packedLight, packedOverlay);
		wing1.render(matrixStack, buffer, packedLight, packedOverlay);
		wing2.render(matrixStack, buffer, packedLight, packedOverlay);
		RightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}