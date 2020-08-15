package com.matez.wildnature.entity.model.animal;// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

import com.matez.wildnature.entity.type.animal.duck.DrakeEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class DrakeModel extends EntityModel<DrakeEntity> {
	private final ModelRenderer RightLeg2;
	private final ModelRenderer RightLeg1;
	private final ModelRenderer RightLeg3;
	private final ModelRenderer LeftLeg2;
	private final ModelRenderer LeftLeg1;
	private final ModelRenderer LeftLeg3;
	private final ModelRenderer Body1;
	private final ModelRenderer Body2;
	private final ModelRenderer Neck;
	private final ModelRenderer Head;
	private final ModelRenderer Beak2;
	private final ModelRenderer Beak1;
	private final ModelRenderer Body3;
	private final ModelRenderer Body5;
	private final ModelRenderer Body4;
	private final ModelRenderer LeftWing;
	private final ModelRenderer RightWing;

	public DrakeModel() {
		textureWidth = 64;
		textureHeight = 32;

		RightLeg2 = new ModelRenderer(this);
		RightLeg2.setRotationPoint(-1.0F, 20.6F, 0.7F);
		setRotationAngle(RightLeg2, 0.1571F, 0.0F, 0.0F);
		RightLeg2.setTextureOffset(12, 27).addBox(-1.5F, -2.0F, -1.47F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		RightLeg1 = new ModelRenderer(this);
		RightLeg1.setRotationPoint(0.0F, 0.0F, 0.0F);
		RightLeg2.addChild(RightLeg1);
		setRotationAngle(RightLeg1, -0.1571F, 0.0F, 0.0F);
		RightLeg1.setTextureOffset(20, 26).addBox(-1.0F, -1.5F, -1.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		RightLeg3 = new ModelRenderer(this);
		RightLeg3.setRotationPoint(0.5F, 0.4F, 1.4F);
		RightLeg1.addChild(RightLeg3);
		RightLeg3.setTextureOffset(0, 28).addBox(-2.0F, 3.0F, -4.0F, 2.0F, 0.0F, 3.0F, 0.0F, false);

		LeftLeg2 = new ModelRenderer(this);
		LeftLeg2.setRotationPoint(1.0F, 20.6F, 0.7F);
		setRotationAngle(LeftLeg2, 0.1571F, 0.0F, 0.0F);
		LeftLeg2.setTextureOffset(12, 27).addBox(-0.5F, -2.0F, -1.47F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		LeftLeg1 = new ModelRenderer(this);
		LeftLeg1.setRotationPoint(0.0F, 0.0F, 0.0F);
		LeftLeg2.addChild(LeftLeg1);
		setRotationAngle(LeftLeg1, -0.1571F, 0.0F, 0.0F);
		LeftLeg1.setTextureOffset(20, 26).addBox(0.0F, -1.47F, -1.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		LeftLeg3 = new ModelRenderer(this);
		LeftLeg3.setRotationPoint(0.5F, 0.4F, 1.4F);
		LeftLeg1.addChild(LeftLeg3);
		LeftLeg3.setTextureOffset(0, 28).addBox(-1.0F, 3.0F, -4.0F, 2.0F, 0.0F, 3.0F, 0.0F, false);

		Body1 = new ModelRenderer(this);
		Body1.setRotationPoint(0.0F, 20.5F, 1.0F);
		Body1.setTextureOffset(40, 20).addBox(-3.0F, -5.53F, -4.0F, 6.0F, 5.0F, 6.0F, 0.0F, false);

		Body2 = new ModelRenderer(this);
		Body2.setRotationPoint(0.0F, -2.0F, -3.0F);
		Body1.addChild(Body2);
		setRotationAngle(Body2, -0.6981F, 0.0F, 0.0F);
		Body2.setTextureOffset(46, 11).addBox(-1.5F, -2.13F, -4.0F, 3.0F, 3.0F, 4.0F, 0.0F, false);

		Neck = new ModelRenderer(this);
		Neck.setRotationPoint(1.0F, 1.1F, -5.03F);
		Body2.addChild(Neck);
		setRotationAngle(Neck, -0.5585F, 0.0F, 0.0F);
		Neck.setTextureOffset(0, 20).addBox(-2.0F, -3.13F, -2.93F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(-1.0F, -21.9F, 0.37F);
		Neck.addChild(Head);
		setRotationAngle(Head, 1.3614F, 0.0F, 0.0F);
		Head.setTextureOffset(0, 13).addBox(-1.5F, -2.87F, -3.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		Beak2 = new ModelRenderer(this);
		Beak2.setRotationPoint(-0.5F, 0.3F, -0.33F);
		Head.addChild(Beak2);
		Beak2.setTextureOffset(0, 9).addBox(-0.5F, -1.2F, -4.6F, 2.0F, 1.0F, 3.0F, 0.0F, false);

		Beak1 = new ModelRenderer(this);
		Beak1.setRotationPoint(0.0F, 0.1F, -0.03F);
		Head.addChild(Beak1);
		setRotationAngle(Beak1, 0.2443F, 0.0F, 0.0F);
		Beak1.setTextureOffset(0, 4).addBox(-0.5F, -2.07F, -4.2F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		Body3 = new ModelRenderer(this);
		Body3.setRotationPoint(0.0F, -0.4F, 0.6F);
		Body1.addChild(Body3);
		setRotationAngle(Body3, 0.3665F, 0.0F, 0.0F);
		Body3.setTextureOffset(37, 0).addBox(-2.5F, -4.13F, 1.03F, 5.0F, 4.0F, 3.0F, 0.0F, false);

		Body5 = new ModelRenderer(this);
		Body5.setRotationPoint(0.0F, 1.0F, -1.0F);
		Body3.addChild(Body5);
		setRotationAngle(Body5, 0.5411F, 0.0F, 0.0F);
		Body5.setTextureOffset(24, 5).addBox(-1.5F, -0.13F, 4.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);

		Body4 = new ModelRenderer(this);
		Body4.setRotationPoint(0.0F, 0.8F, -0.5F);
		Body3.addChild(Body4);
		setRotationAngle(Body4, 0.1222F, 0.0F, 0.0F);
		Body4.setTextureOffset(22, 0).addBox(-2.0F, -4.13F, 4.5F, 4.0F, 2.0F, 3.0F, 0.0F, false);

		LeftWing = new ModelRenderer(this);
		LeftWing.setRotationPoint(2.7F, -4.7F, -2.7F);
		Body1.addChild(LeftWing);
		setRotationAngle(LeftWing, 0.1047F, 0.1396F, 0.0F);
		LeftWing.setTextureOffset(54, 0).addBox(0.0F, -0.13F, -1.0F, 1.0F, 3.0F, 4.0F, 0.0F, false);

		RightWing = new ModelRenderer(this);
		RightWing.setRotationPoint(-2.7F, -4.7F, -2.7F);
		Body1.addChild(RightWing);
		setRotationAngle(RightWing, 0.1047F, -0.1396F, 0.0F);
		RightWing.setTextureOffset(54, 0).addBox(-1.0F, -0.13F, -1.0F, 1.0F, 3.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(DrakeEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		RightLeg2.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftLeg2.render(matrixStack, buffer, packedLight, packedOverlay);
		Body1.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}