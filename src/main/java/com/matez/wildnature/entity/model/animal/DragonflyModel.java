package com.matez.wildnature.entity.model.animal;// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.matez.wildnature.entity.type.animal.insect.DragonflyEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class DragonflyModel extends EntityModel<DragonflyEntity> {
	private final ModelRenderer Body;
	private final ModelRenderer Tail;
	private final ModelRenderer TailEnd;
	private final ModelRenderer Head;
	private final ModelRenderer LeftFrontWings;
	private final ModelRenderer LeftBackWing;
	private final ModelRenderer RightFrontWings;
	private final ModelRenderer RightBackWings;
	private final ModelRenderer FrontRightLeg;
	private final ModelRenderer bone;
	private final ModelRenderer MiddleRightLeg;
	private final ModelRenderer bone2;
	private final ModelRenderer BackRightLeg;
	private final ModelRenderer bone3;
	private final ModelRenderer FrontLeftLeg;
	private final ModelRenderer bone4;
	private final ModelRenderer MiddleLeftLeg;
	private final ModelRenderer bone5;
	private final ModelRenderer BackLeftLeg;
	private final ModelRenderer bone6;

	public DragonflyModel() {
		textureWidth = 32;
		textureHeight = 32;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		Body.setTextureOffset(0, 10).addBox(-1.125F, -3.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(-0.5F, -2.5F, 0.0F);
		Body.addChild(Tail);
		setRotationAngle(Tail, -0.2618F, 0.0F, 0.0F);
		Tail.setTextureOffset(5, 7).addBox(-0.5625F, -0.5F, -0.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		TailEnd = new ModelRenderer(this);
		TailEnd.setRotationPoint(-0.5F, -2.5F, 0.0F);
		Body.addChild(TailEnd);
		TailEnd.setTextureOffset(0, 6).addBox(-0.5F, 0.0F, 2.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(-0.5F, 21.5F, -1.5F);
		setRotationAngle(Head, 0.8727F, 0.0F, 0.0F);
		Head.setTextureOffset(10, 6).addBox(-0.625F, -1.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		LeftFrontWings = new ModelRenderer(this);
		LeftFrontWings.setRotationPoint(-0.5F, 21.0F, -1.0F);
		setRotationAngle(LeftFrontWings, 0.0F, 0.1745F, 0.0F);
		LeftFrontWings.setTextureOffset(0, 1).addBox(0.0F, 0.0F, -0.5F, 6.0F, 0.0F, 1.0F, 0.0F, false);
		LeftFrontWings.setTextureOffset(0, 4).addBox(0.0F, 0.0F, 0.5F, 5.0F, 0.0F, 1.0F, 0.0F, false);

		LeftBackWing = new ModelRenderer(this);
		LeftBackWing.setRotationPoint(-0.5F, 21.0F, 0.0F);
		setRotationAngle(LeftBackWing, -0.2618F, -0.3491F, 0.0F);
		LeftBackWing.setTextureOffset(0, 5).addBox(0.0F, 0.0F, -0.5F, 5.0F, 0.0F, 1.0F, 0.0F, false);
		LeftBackWing.setTextureOffset(9, 9).addBox(0.0F, 0.0F, 0.5F, 3.0F, 0.0F, 1.0F, 0.0F, false);

		RightFrontWings = new ModelRenderer(this);
		RightFrontWings.setRotationPoint(-0.5F, 21.0F, -1.0F);
		setRotationAngle(RightFrontWings, 0.0F, -0.1745F, 0.0F);
		RightFrontWings.setTextureOffset(0, 0).addBox(-6.0F, 0.0F, -0.5F, 6.0F, 0.0F, 1.0F, 0.0F, false);
		RightFrontWings.setTextureOffset(0, 3).addBox(-5.0F, 0.0F, 0.5F, 5.0F, 0.0F, 1.0F, 0.0F, false);

		RightBackWings = new ModelRenderer(this);
		RightBackWings.setRotationPoint(-0.5F, 21.0F, 0.0F);
		setRotationAngle(RightBackWings, -0.2618F, 0.3491F, 0.0F);
		RightBackWings.setTextureOffset(0, 2).addBox(-5.0F, 0.0F, -0.5F, 5.0F, 0.0F, 1.0F, 0.0F, false);
		RightBackWings.setTextureOffset(4, 6).addBox(-3.0F, 0.0F, 0.5F, 3.0F, 0.0F, 1.0F, 0.0F, false);

		FrontRightLeg = new ModelRenderer(this);
		FrontRightLeg.setRotationPoint(-1.0F, 22.0F, -1.5F);
		setRotationAngle(FrontRightLeg, -0.4363F, 0.0F, 0.5236F);
		FrontRightLeg.setTextureOffset(6, 11).addBox(-0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(-0.5F, 1.0F, 0.0F);
		FrontRightLeg.addChild(bone);
		setRotationAngle(bone, 1.0472F, 0.0F, 0.0F);
		bone.setTextureOffset(4, 11).addBox(-0.25F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);

		MiddleRightLeg = new ModelRenderer(this);
		MiddleRightLeg.setRotationPoint(-1.0F, 22.0F, -0.5F);
		setRotationAngle(MiddleRightLeg, 0.0F, 0.0F, 0.4363F);
		MiddleRightLeg.setTextureOffset(10, 11).addBox(-0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(-0.5F, 1.0F, 0.0F);
		MiddleRightLeg.addChild(bone2);
		setRotationAngle(bone2, 1.1345F, 0.0F, 0.0F);
		bone2.setTextureOffset(0, 11).addBox(-0.25F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);

		BackRightLeg = new ModelRenderer(this);
		BackRightLeg.setRotationPoint(-1.0F, 22.0F, 0.0F);
		setRotationAngle(BackRightLeg, 0.3491F, 0.0F, 0.3491F);
		BackRightLeg.setTextureOffset(8, 11).addBox(-0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(-0.5F, 1.0F, 0.0F);
		BackRightLeg.addChild(bone3);
		setRotationAngle(bone3, 0.9599F, 0.0F, 0.0F);
		bone3.setTextureOffset(10, 8).addBox(-0.25F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);

		FrontLeftLeg = new ModelRenderer(this);
		FrontLeftLeg.setRotationPoint(0.0F, 22.0F, -1.5F);
		setRotationAngle(FrontLeftLeg, -0.4363F, 0.0F, -0.5236F);
		FrontLeftLeg.setTextureOffset(0, 10).addBox(-0.25F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.5F, 1.0F, 0.0F);
		FrontLeftLeg.addChild(bone4);
		setRotationAngle(bone4, 1.0472F, 0.0F, 0.0F);
		bone4.setTextureOffset(5, 8).addBox(-0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);

		MiddleLeftLeg = new ModelRenderer(this);
		MiddleLeftLeg.setRotationPoint(0.0F, 22.0F, -0.5F);
		setRotationAngle(MiddleLeftLeg, 0.0F, 0.0F, -0.4363F);
		MiddleLeftLeg.setTextureOffset(0, 8).addBox(-0.25F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(0.5F, 1.0F, 0.0F);
		MiddleLeftLeg.addChild(bone5);
		setRotationAngle(bone5, 1.1345F, 0.0F, 0.0F);
		bone5.setTextureOffset(5, 7).addBox(-0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);

		BackLeftLeg = new ModelRenderer(this);
		BackLeftLeg.setRotationPoint(0.0F, 22.0F, 0.0F);
		setRotationAngle(BackLeftLeg, 0.3491F, 0.0F, -0.3491F);
		BackLeftLeg.setTextureOffset(0, 7).addBox(-0.25F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(0.5F, 1.0F, 0.0F);
		BackLeftLeg.addChild(bone6);
		setRotationAngle(bone6, 0.9599F, 0.0F, 0.0F);
		bone6.setTextureOffset(0, 6).addBox(-0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(DragonflyEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftFrontWings.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftBackWing.render(matrixStack, buffer, packedLight, packedOverlay);
		RightFrontWings.render(matrixStack, buffer, packedLight, packedOverlay);
		RightBackWings.render(matrixStack, buffer, packedLight, packedOverlay);
		FrontRightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		MiddleRightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		BackRightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		FrontLeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		MiddleLeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		BackLeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}