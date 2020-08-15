package com.matez.wildnature.entity.model.animal;// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

import com.matez.wildnature.entity.type.animal.deer.FawnEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class FawnModel extends EntityModel<FawnEntity> {
	private final ModelRenderer Body;
	private final ModelRenderer TorsoMiddle;
	private final ModelRenderer TorsoBack;
	private final ModelRenderer Tail;
	private final ModelRenderer TorsoFront;
	private final ModelRenderer Neck;
	private final ModelRenderer LowerNeck;
	private final ModelRenderer UpperNeck;
	private final ModelRenderer Head;
	private final ModelRenderer Nose;
	private final ModelRenderer Jaw;
	private final ModelRenderer LeftEar;
	private final ModelRenderer RightEar;
	private final ModelRenderer LeftThigh;
	private final ModelRenderer LeftBackLeg;
	private final ModelRenderer LeftBackLowerLeg;
	private final ModelRenderer LeftBackHoof;
	private final ModelRenderer RightThigh;
	private final ModelRenderer RightBackLeg;
	private final ModelRenderer RightBackLowerLeg;
	private final ModelRenderer RightBackHoof;
	private final ModelRenderer LeftFrontLeg;
	private final ModelRenderer LeftFrontLowerLeg;
	private final ModelRenderer LeftFrontHoof;
	private final ModelRenderer RightFrontLeg;
	private final ModelRenderer RightFrontLowerLeg;
	private final ModelRenderer RightFrontHoof;

	public FawnModel() {
		textureWidth = 64;
		textureHeight = 64;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(1.0F, 24.0F, 0.0F);
		

		TorsoMiddle = new ModelRenderer(this);
		TorsoMiddle.setRotationPoint(0.0F, -12.0F, -1.0F);
		Body.addChild(TorsoMiddle);
		setRotationAngle(TorsoMiddle, 0.0873F, 0.0F, 0.0F);
		TorsoMiddle.setTextureOffset(0, 28).addBox(-3.75F, -4.1096F, -3.0F, 5.0F, 6.0F, 5.0F, 0.0F, false);

		TorsoBack = new ModelRenderer(this);
		TorsoBack.setRotationPoint(0.0F, -12.0F, 8.0F);
		Body.addChild(TorsoBack);
		setRotationAngle(TorsoBack, -0.0873F, 0.0F, 0.0F);
		TorsoBack.setTextureOffset(18, 7).addBox(-3.5F, -3.6101F, -7.7098F, 5.0F, 6.0F, 6.0F, 0.0F, false);

		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(-1.0F, -20.7577F, 9.25F);
		Body.addChild(Tail);
		setRotationAngle(Tail, 0.2618F, 0.0F, 0.0F);
		Tail.setTextureOffset(32, 33).addBox(-1.5F, 4.1586F, -4.846F, 3.0F, 3.0F, 1.0F, 0.0F, false);
		Tail.setTextureOffset(0, 0).addBox(-0.5F, 7.1586F, -4.846F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		TorsoFront = new ModelRenderer(this);
		TorsoFront.setRotationPoint(-0.5F, -12.0F, -4.0F);
		Body.addChild(TorsoFront);
		setRotationAngle(TorsoFront, -0.0873F, 0.0F, 0.0F);
		TorsoFront.setTextureOffset(0, 0).addBox(-3.5F, -4.0304F, -5.3028F, 6.0F, 7.0F, 6.0F, 0.0F, false);

		Neck = new ModelRenderer(this);
		Neck.setRotationPoint(0.0F, -13.0F, -8.0F);
		Body.addChild(Neck);
		

		LowerNeck = new ModelRenderer(this);
		LowerNeck.setRotationPoint(0.5F, -10.5F, -1.75F);
		Neck.addChild(LowerNeck);
		setRotationAngle(LowerNeck, 0.4363F, 0.0F, 0.0F);
		LowerNeck.setTextureOffset(19, 20).addBox(-4.0F, 4.7729F, -5.7259F, 5.0F, 8.0F, 5.0F, 0.0F, false);

		UpperNeck = new ModelRenderer(this);
		UpperNeck.setRotationPoint(0.0F, -11.9159F, -3.7801F);
		Neck.addChild(UpperNeck);
		setRotationAngle(UpperNeck, -0.2618F, 0.0F, 0.0F);
		UpperNeck.setTextureOffset(20, 33).addBox(-3.0F, 4.1791F, 1.009F, 4.0F, 4.0F, 4.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(-1.7565F, -6.3159F, -0.9848F);
		Neck.addChild(Head);
		setRotationAngle(Head, 0.1745F, 0.0F, 0.0F);
		Head.setTextureOffset(0, 13).addBox(-2.2435F, -5.8574F, -4.2817F, 6.0F, 6.0F, 6.0F, 0.0F, false);

		Nose = new ModelRenderer(this);
		Nose.setRotationPoint(0.5F, -4.961F, -7.6883F);
		Head.addChild(Nose);
		setRotationAngle(Nose, 0.2618F, 0.0F, 0.0F);
		Nose.setTextureOffset(24, 0).addBox(-1.7435F, 1.6895F, -0.5553F, 4.0F, 2.0F, 5.0F, 0.0F, false);

		Jaw = new ModelRenderer(this);
		Jaw.setRotationPoint(1.0F, -4.1213F, -5.8055F);
		Head.addChild(Jaw);
		Jaw.setTextureOffset(34, 7).addBox(-1.7435F, 1.2189F, -1.0988F, 3.0F, 2.0F, 4.0F, 0.0F, false);

		LeftEar = new ModelRenderer(this);
		LeftEar.setRotationPoint(3.5F, -8.1217F, 1.7292F);
		Head.addChild(LeftEar);
		setRotationAngle(LeftEar, -0.4363F, -0.3491F, -0.0873F);
		LeftEar.setTextureOffset(46, 46).addBox(-0.8852F, 1.8544F, 0.2074F, 4.0F, 3.0F, 1.0F, 0.0F, false);

		RightEar = new ModelRenderer(this);
		RightEar.setRotationPoint(-2.5F, -8.1217F, 1.7292F);
		Head.addChild(RightEar);
		setRotationAngle(RightEar, -0.4363F, 0.3491F, 0.0F);
		RightEar.setTextureOffset(44, 33).addBox(-2.8155F, 1.8749F, 0.3372F, 4.0F, 3.0F, 1.0F, 0.0F, false);

		LeftThigh = new ModelRenderer(this);
		LeftThigh.setRotationPoint(0.5F, -13.25F, 5.0F);
		Body.addChild(LeftThigh);
		setRotationAngle(LeftThigh, -0.0873F, 0.0F, 0.0F);
		LeftThigh.setTextureOffset(36, 15).addBox(-0.5F, -1.75F, -3.3699F, 2.0F, 5.0F, 4.0F, 0.0F, false);

		LeftBackLeg = new ModelRenderer(this);
		LeftBackLeg.setRotationPoint(1.5F, -12.0F, 4.0F);
		Body.addChild(LeftBackLeg);
		setRotationAngle(LeftBackLeg, 0.2618F, 0.0F, 0.0F);
		LeftBackLeg.setTextureOffset(10, 39).addBox(-1.25F, -1.5765F, -1.5761F, 2.0F, 7.0F, 3.0F, 0.0F, false);

		LeftBackLowerLeg = new ModelRenderer(this);
		LeftBackLowerLeg.setRotationPoint(0.0F, 4.8F, 0.0F);
		LeftBackLeg.addChild(LeftBackLowerLeg);
		setRotationAngle(LeftBackLowerLeg, -0.2618F, 0.0F, 0.0F);
		LeftBackLowerLeg.setTextureOffset(40, 45).addBox(-1.0F, -0.006F, -1.2087F, 1.0F, 7.0F, 2.0F, 0.0F, false);

		LeftBackHoof = new ModelRenderer(this);
		LeftBackHoof.setRotationPoint(-1.25F, 7.3121F, -6.5477F);
		LeftBackLowerLeg.addChild(LeftBackHoof);
		LeftBackHoof.setTextureOffset(44, 13).addBox(0.0F, -1.0121F, 4.4647F, 2.0F, 1.0F, 3.0F, 0.0F, false);

		RightThigh = new ModelRenderer(this);
		RightThigh.setRotationPoint(-3.5F, -13.25F, 5.0F);
		Body.addChild(RightThigh);
		setRotationAngle(RightThigh, -0.0873F, 0.0F, 0.0F);
		RightThigh.setTextureOffset(36, 36).addBox(-0.5F, -1.75F, -3.3699F, 2.0F, 5.0F, 4.0F, 0.0F, false);

		RightBackLeg = new ModelRenderer(this);
		RightBackLeg.setRotationPoint(-3.0F, -12.0F, 4.0F);
		Body.addChild(RightBackLeg);
		setRotationAngle(RightBackLeg, 0.2618F, 0.0F, 0.0F);
		RightBackLeg.setTextureOffset(0, 39).addBox(-1.25F, -1.6027F, -1.6067F, 2.0F, 7.0F, 3.0F, 0.0F, false);

		RightBackLowerLeg = new ModelRenderer(this);
		RightBackLowerLeg.setRotationPoint(0.0F, 4.7838F, 0.0076F);
		RightBackLeg.addChild(RightBackLowerLeg);
		setRotationAngle(RightBackLowerLeg, -0.2618F, 0.0F, 0.0F);
		RightBackLowerLeg.setTextureOffset(44, 0).addBox(-1.0F, -0.0244F, -1.1764F, 1.0F, 7.0F, 2.0F, 0.0F, false);

		RightBackHoof = new ModelRenderer(this);
		RightBackHoof.setRotationPoint(-1.25F, 6.0F, -5.65F);
		RightBackLowerLeg.addChild(RightBackHoof);
		RightBackHoof.setTextureOffset(18, 0).addBox(0.0F, 0.3162F, 3.5594F, 2.0F, 1.0F, 3.0F, 0.0F, false);

		LeftFrontLeg = new ModelRenderer(this);
		LeftFrontLeg.setRotationPoint(2.5F, -11.0F, -7.0F);
		Body.addChild(LeftFrontLeg);
		setRotationAngle(LeftFrontLeg, -0.1745F, 0.0F, 0.0F);
		LeftFrontLeg.setTextureOffset(20, 41).addBox(-2.0F, -2.0304F, -1.1527F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		LeftFrontLowerLeg = new ModelRenderer(this);
		LeftFrontLowerLeg.setRotationPoint(-0.65F, 4.7713F, 0.0874F);
		LeftFrontLeg.addChild(LeftFrontLowerLeg);
		setRotationAngle(LeftFrontLowerLeg, 0.1745F, 0.0F, 0.0F);
		LeftFrontLowerLeg.setTextureOffset(34, 45).addBox(-1.1F, -0.7713F, -0.7914F, 1.0F, 7.0F, 2.0F, 0.0F, false);

		LeftFrontHoof = new ModelRenderer(this);
		LeftFrontHoof.setRotationPoint(0.1F, -1.5532F, -6.1667F);
		LeftFrontLowerLeg.addChild(LeftFrontHoof);
		LeftFrontHoof.setTextureOffset(8, 25).addBox(-1.45F, 6.7819F, 4.7253F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		RightFrontLeg = new ModelRenderer(this);
		RightFrontLeg.setRotationPoint(-2.5F, -11.0F, -7.0F);
		Body.addChild(RightFrontLeg);
		setRotationAngle(RightFrontLeg, -0.1745F, 0.0F, 0.0F);
		RightFrontLeg.setTextureOffset(39, 24).addBox(-2.0F, -2.0304F, -1.1527F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		RightFrontLowerLeg = new ModelRenderer(this);
		RightFrontLowerLeg.setRotationPoint(-0.65F, 4.7713F, 0.0874F);
		RightFrontLeg.addChild(RightFrontLowerLeg);
		setRotationAngle(RightFrontLowerLeg, 0.1745F, 0.0F, 0.0F);
		RightFrontLowerLeg.setTextureOffset(28, 41).addBox(-1.1F, -0.7713F, -0.7914F, 1.0F, 7.0F, 2.0F, 0.0F, false);

		RightFrontHoof = new ModelRenderer(this);
		RightFrontHoof.setRotationPoint(0.1F, -1.5532F, -6.1667F);
		RightFrontLowerLeg.addChild(RightFrontHoof);
		RightFrontHoof.setTextureOffset(0, 25).addBox(-1.95F, 6.7819F, 4.7253F, 2.0F, 1.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(FawnEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}