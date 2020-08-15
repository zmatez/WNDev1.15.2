package com.matez.wildnature.entity.model.monster;// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports
import com.matez.wildnature.entity.type.monster.GoblinEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class GoblinModel extends EntityModel<GoblinEntity> {
	private final ModelRenderer root;
	private final ModelRenderer Body;
	private final ModelRenderer Underbody;
	private final ModelRenderer Left_upperleg;
	private final ModelRenderer Left_Lowerleg;
	private final ModelRenderer left_foot;
	private final ModelRenderer Right_upperleg;
	private final ModelRenderer Right_Lowerleg;
	private final ModelRenderer Right_foot;
	private final ModelRenderer Left_upperarm;
	private final ModelRenderer Left_underarm;
	private final ModelRenderer Right_upperarm;
	private final ModelRenderer Right_underarm;
	private final ModelRenderer Head;
	private final ModelRenderer leftear;
	private final ModelRenderer rightear;
	private final ModelRenderer Nose;

	public GoblinModel() {
		textureWidth = 64;
		textureHeight = 64;

		root = new ModelRenderer(this);
		root.setRotationPoint(0.0F, 0.0F, 0.0F);
		

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 2.0F, 0.0F);
		root.addChild(Body);
		setRotationAngle(Body, 0.4363F, 0.0F, 0.0F);
		Body.setTextureOffset(0, 0).addBox(-3.0F, 0.0F, -2.0F, 6.0F, 6.0F, 4.0F, 0.0F, true);

		Underbody = new ModelRenderer(this);
		Underbody.setRotationPoint(0.0F, 6.0F, 0.0F);
		Body.addChild(Underbody);
		setRotationAngle(Underbody, -0.6109F, 0.0F, 0.0F);
		Underbody.setTextureOffset(20, 0).addBox(-2.0F, -1.3F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, true);

		Left_upperleg = new ModelRenderer(this);
		Left_upperleg.setRotationPoint(-2.4F, 5.5F, -1.0F);
		Underbody.addChild(Left_upperleg);
		setRotationAngle(Left_upperleg, -0.4363F, 0.0F, 0.0F);
		Left_upperleg.setTextureOffset(20, 13).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 6.0F, 2.0F, 0.0F, true);

		Left_Lowerleg = new ModelRenderer(this);
		Left_Lowerleg.setRotationPoint(1.0F, 6.0F, 1.0F);
		Left_upperleg.addChild(Left_Lowerleg);
		setRotationAngle(Left_Lowerleg, 1.1345F, 0.0F, 0.0F);
		Left_Lowerleg.setTextureOffset(20, 21).addBox(-2.0F, -2.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, true);

		left_foot = new ModelRenderer(this);
		left_foot.setRotationPoint(0.0F, 5.9F, 0.0F);
		Left_Lowerleg.addChild(left_foot);
		setRotationAngle(left_foot, -0.5236F, 0.0F, 0.0F);
		left_foot.setTextureOffset(20, 31).addBox(-2.0F, 0.0F, -3.0F, 2.0F, 1.0F, 4.0F, 0.0F, true);

		Right_upperleg = new ModelRenderer(this);
		Right_upperleg.setRotationPoint(2.4F, 5.5F, -1.0F);
		Underbody.addChild(Right_upperleg);
		setRotationAngle(Right_upperleg, -0.4363F, 0.0F, 0.0F);
		Right_upperleg.setTextureOffset(33, 13).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 6.0F, 2.0F, 0.0F, true);

		Right_Lowerleg = new ModelRenderer(this);
		Right_Lowerleg.setRotationPoint(1.0F, 6.0F, 1.0F);
		Right_upperleg.addChild(Right_Lowerleg);
		setRotationAngle(Right_Lowerleg, 1.1345F, 0.0F, 0.0F);
		Right_Lowerleg.setTextureOffset(33, 21).addBox(-2.0F, -2.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, true);

		Right_foot = new ModelRenderer(this);
		Right_foot.setRotationPoint(0.0F, 5.9F, 0.0F);
		Right_Lowerleg.addChild(Right_foot);
		setRotationAngle(Right_foot, -0.5236F, 0.0F, 0.0F);
		Right_foot.setTextureOffset(33, 31).addBox(-2.0F, 0.0F, -3.0F, 2.0F, 1.0F, 4.0F, 0.0F, true);

		Left_upperarm = new ModelRenderer(this);
		Left_upperarm.setRotationPoint(-3.0F, 0.2F, 0.0F);
		Body.addChild(Left_upperarm);
		setRotationAngle(Left_upperarm, -0.1745F, 0.0F, -0.1396F);
		Left_upperarm.setTextureOffset(0, 11).addBox(-2.0F, -0.2F, -0.8F, 2.0F, 6.0F, 2.0F, 0.0F, true);

		Left_underarm = new ModelRenderer(this);
		Left_underarm.setRotationPoint(-1.0F, 5.5F, 0.0F);
		Left_upperarm.addChild(Left_underarm);
		setRotationAngle(Left_underarm, -1.5708F, -0.1745F, 0.0F);
		Left_underarm.setTextureOffset(0, 20).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 8.0F, 2.0F, 0.0F, true);

		Right_upperarm = new ModelRenderer(this);
		Right_upperarm.setRotationPoint(3.0F, 0.2F, 0.0F);
		Body.addChild(Right_upperarm);
		setRotationAngle(Right_upperarm, -0.1745F, 0.0F, 0.1396F);
		Right_upperarm.setTextureOffset(10, 11).addBox(0.0F, -0.2F, -0.8F, 2.0F, 6.0F, 2.0F, 0.0F, true);

		Right_underarm = new ModelRenderer(this);
		Right_underarm.setRotationPoint(1.0F, 5.5F, 0.0F);
		Right_upperarm.addChild(Right_underarm);
		setRotationAngle(Right_underarm, -1.5708F, 0.1745F, 0.0F);
		Right_underarm.setTextureOffset(11, 20).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 8.0F, 2.0F, 0.0F, true);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(Head);
		setRotationAngle(Head, -0.4253F, 0.0F, 0.0F);
		Head.setTextureOffset(0, 30).addBox(-2.0F, -3.5F, -3.6F, 4.0F, 4.0F, 6.0F, 0.0F, true);

		leftear = new ModelRenderer(this);
		leftear.setRotationPoint(-2.0F, -1.5F, -1.5F);
		Head.addChild(leftear);
		setRotationAngle(leftear, 0.5236F, -0.384F, 0.0F);
		leftear.setTextureOffset(0, 40).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 3.0F, 0.0F, true);

		rightear = new ModelRenderer(this);
		rightear.setRotationPoint(2.0F, -1.5F, -1.5F);
		Head.addChild(rightear);
		setRotationAngle(rightear, 0.5236F, 0.384F, 0.0F);
		rightear.setTextureOffset(8, 40).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 3.0F, 0.0F, true);

		Nose = new ModelRenderer(this);
		Nose.setRotationPoint(0.5F, -1.5F, -4.3F);
		Head.addChild(Nose);
		Nose.setTextureOffset(16, 40).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
	}

	@Override
	public void setRotationAngles(GoblinEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		root.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}