package com.matez.wildnature.entity.model.animal;// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

import com.matez.wildnature.entity.type.animal.bird.SparrowEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class SparrowModel extends EntityModel<SparrowEntity> {
	private final ModelRenderer MainBody;
	private final ModelRenderer Body;
	private final ModelRenderer Head;
	private final ModelRenderer Beak;
	private final ModelRenderer Tail;
	private final ModelRenderer TailEnd;
	private final ModelRenderer RightWing;
	private final ModelRenderer LeftWing;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer RightLeg;

	public SparrowModel() {
		textureWidth = 32;
		textureHeight = 32;

		MainBody = new ModelRenderer(this);
		MainBody.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, -4.0F, 0.0F);
		MainBody.addChild(Body);
		setRotationAngle(Body, -0.5236F, 0.0F, 0.0F);
		Body.setTextureOffset(0, 8).addBox(-2.0F, -1.134F, -1.5F, 3.0F, 3.0F, 4.0F, 0.0F, false);
		Body.setTextureOffset(0, 0).addBox(-1.5F, -1.634F, -0.5F, 2.0F, 3.0F, 5.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(-0.5F, -7.0F, 0.0F);
		MainBody.addChild(Head);
		Head.setTextureOffset(0, 15).addBox(-1.25F, 1.0F, -2.0F, 2.0F, 3.0F, 3.0F, 0.0F, false);
		Head.setTextureOffset(16, 10).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);
		Head.setTextureOffset(9, 0).addBox(-0.5F, -0.25F, -2.5F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		Beak = new ModelRenderer(this);
		Beak.setRotationPoint(0.5F, 7.0F, 0.0F);
		Head.addChild(Beak);
		setRotationAngle(Beak, 0.2618F, 0.0F, 0.0F);
		Beak.setTextureOffset(16, 17).addBox(-1.0F, -7.0341F, -2.2588F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(-1.0F, -4.0F, 4.0F);
		MainBody.addChild(Tail);
		setRotationAngle(Tail, -0.3491F, 0.0F, 0.0F);
		Tail.setTextureOffset(10, 17).addBox(-0.25F, 0.9397F, 0.342F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		TailEnd = new ModelRenderer(this);
		TailEnd.setRotationPoint(0.0F, 0.0F, 0.0F);
		MainBody.addChild(TailEnd);
		TailEnd.setTextureOffset(15, 0).addBox(-1.0F, -2.5F, 5.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		RightWing = new ModelRenderer(this);
		RightWing.setRotationPoint(-2.0F, -6.0F, -1.0F);
		MainBody.addChild(RightWing);
		setRotationAngle(RightWing, -0.5236F, 0.0F, 0.0F);
		RightWing.setTextureOffset(10, 3).addBox(-0.5F, -0.134F, 0.5F, 1.0F, 2.0F, 5.0F, 0.0F, false);

		LeftWing = new ModelRenderer(this);
		LeftWing.setRotationPoint(1.0F, -6.0F, -1.0F);
		MainBody.addChild(LeftWing);
		setRotationAngle(LeftWing, -0.5236F, 0.0F, 0.0F);
		LeftWing.setTextureOffset(9, 10).addBox(-0.5F, -0.134F, 0.5F, 1.0F, 2.0F, 5.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(0.0F, -2.0F, 0.0F);
		MainBody.addChild(LeftLeg);
		LeftLeg.setTextureOffset(0, 0).addBox(-0.25F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		LeftLeg.setTextureOffset(0, 2).addBox(0.0F, 2.0F, -1.0F, 1.0F, 0.0F, 2.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-1.0F, -2.0F, 0.0F);
		MainBody.addChild(RightLeg);
		RightLeg.setTextureOffset(0, 0).addBox(-0.75F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		RightLeg.setTextureOffset(0, 0).addBox(-1.0F, 2.0F, -1.0F, 1.0F, 0.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(SparrowEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		MainBody.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}