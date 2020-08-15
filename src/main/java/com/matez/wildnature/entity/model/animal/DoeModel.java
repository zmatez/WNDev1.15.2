package com.matez.wildnature.entity.model.animal;// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.matez.wildnature.entity.type.animal.deer.DoeEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class DoeModel extends EntityModel<DoeEntity> {
	private final ModelRenderer Body;
	private final ModelRenderer TorsoMiddle;
	private final ModelRenderer TorsoBack;
	private final ModelRenderer Tail;
	private final ModelRenderer TorsoFront;
	private final ModelRenderer Neck_Head;
	private final ModelRenderer LowerNeck;
	private final ModelRenderer UpperNeck;
	private final ModelRenderer Head;
	private final ModelRenderer Nose;
	private final ModelRenderer Jaw;
	private final ModelRenderer LeftEar;
	private final ModelRenderer RightEar;
	private final ModelRenderer LeftBackLeg;
	private final ModelRenderer LeftBackLowerLeg;
	private final ModelRenderer LeftBackHoof;
	private final ModelRenderer LeftThigh;
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

	public DoeModel() {
		textureWidth = 128;
		textureHeight = 128;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		TorsoMiddle = new ModelRenderer(this);
		TorsoMiddle.setRotationPoint(0.0F, -12.0F, -1.0F);
		Body.addChild(TorsoMiddle);
		setRotationAngle(TorsoMiddle, 0.0873F, 0.0F, 0.0F);
		TorsoMiddle.setTextureOffset(0, 0).addBox(-4.0F, -11.9772F, -3.9771F, 8.0F, 10.0F, 9.0F, 0.0F, false);

		TorsoBack = new ModelRenderer(this);
		TorsoBack.setRotationPoint(0.0F, -12.0F, 8.0F);
		Body.addChild(TorsoBack);
		setRotationAngle(TorsoBack, -0.0873F, 0.0F, 0.0F);
		TorsoBack.setTextureOffset(23, 28).addBox(-3.5F, -11.0908F, -5.9499F, 7.0F, 9.0F, 9.0F, 0.0F, false);

		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(-1.0F, -20.7577F, 12.25F);
		Body.addChild(Tail);
		setRotationAngle(Tail, 0.2618F, 0.0F, 0.0F);
		Tail.setTextureOffset(35, 18).addBox(-1.5F, -1.9701F, -0.4324F, 5.0F, 4.0F, 1.0F, 0.0F, false);
		Tail.setTextureOffset(25, 5).addBox(-0.5F, 1.8825F, -0.1736F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		TorsoFront = new ModelRenderer(this);
		TorsoFront.setRotationPoint(-0.5F, -12.0F, -4.0F);
		Body.addChild(TorsoFront);
		setRotationAngle(TorsoFront, -0.0873F, 0.0F, 0.0F);
		TorsoFront.setTextureOffset(0, 19).addBox(-4.0F, -11.9772F, -6.5229F, 9.0F, 11.0F, 7.0F, 0.0F, false);

		Neck_Head = new ModelRenderer(this);
		Neck_Head.setRotationPoint(0.0F, -19.0F, -8.0F);
		Body.addChild(Neck_Head);
		

		LowerNeck = new ModelRenderer(this);
		LowerNeck.setRotationPoint(0.0F, 3.5F, -1.75F);
		Neck_Head.addChild(LowerNeck);
		setRotationAngle(LowerNeck, 0.4363F, 0.0F, 0.0F);
		LowerNeck.setTextureOffset(34, 0).addBox(-3.5F, -9.9378F, -1.2143F, 7.0F, 11.0F, 7.0F, 0.0F, false);

		UpperNeck = new ModelRenderer(this);
		UpperNeck.setRotationPoint(0.0F, -2.9159F, -3.7801F);
		Neck_Head.addChild(UpperNeck);
		setRotationAngle(UpperNeck, -0.2618F, 0.0F, 0.0F);
		UpperNeck.setTextureOffset(30, 46).addBox(-3.0F, -8.1604F, -3.6967F, 6.0F, 7.0F, 6.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(-0.7565F, -9.9159F, -2.4848F);
		Neck_Head.addChild(Head);
		setRotationAngle(Head, 0.1745F, 0.0F, 0.0F);
		Head.setTextureOffset(0, 38).addBox(-3.0F, -6.3248F, -4.2081F, 7.0F, 7.0F, 8.0F, 0.0F, false);

		Nose = new ModelRenderer(this);
		Nose.setRotationPoint(0.5F, 3.039F, -7.6883F);
		Head.addChild(Nose);
		setRotationAngle(Nose, 0.2618F, 0.0F, 0.0F);
		Nose.setTextureOffset(49, 54).addBox(-2.5F, -6.5882F, -0.0383F, 5.0F, 3.0F, 5.0F, 0.0F, false);

		Jaw = new ModelRenderer(this);
		Jaw.setRotationPoint(1.0F, 3.8787F, -5.8055F);
		Head.addChild(Jaw);
		Jaw.setTextureOffset(49, 40).addBox(-2.5F, -6.0395F, -2.4699F, 4.0F, 2.0F, 6.0F, 0.0F, false);

		LeftEar = new ModelRenderer(this);
		LeftEar.setRotationPoint(3.5F, -0.1217F, 1.7292F);
		Head.addChild(LeftEar);
		setRotationAngle(LeftEar, -0.4363F, -0.3491F, -0.0873F);
		LeftEar.setTextureOffset(54, 48).addBox(0.7695F, -6.6146F, -1.9361F, 5.0F, 4.0F, 1.0F, 0.0F, false);

		RightEar = new ModelRenderer(this);
		RightEar.setRotationPoint(-2.5F, -0.1217F, 1.7292F);
		Head.addChild(RightEar);
		setRotationAngle(RightEar, -0.4363F, 0.3491F, 0.0F);
		RightEar.setTextureOffset(46, 31).addBox(-5.2459F, -6.6776F, -1.7553F, 5.0F, 4.0F, 1.0F, 0.0F, false);

		LeftBackLeg = new ModelRenderer(this);
		LeftBackLeg.setRotationPoint(3.25F, -16.0F, 9.0F);
		Body.addChild(LeftBackLeg);
		setRotationAngle(LeftBackLeg, 0.2618F, 0.0F, 0.0F);
		LeftBackLeg.setTextureOffset(34, 59).addBox(-1.5F, -1.8296F, -2.0F, 3.0F, 9.0F, 4.0F, 0.0F, false);

		LeftBackLowerLeg = new ModelRenderer(this);
		LeftBackLowerLeg.setRotationPoint(0.0F, 6.4227F, -0.3409F);
		LeftBackLeg.addChild(LeftBackLowerLeg);
		setRotationAngle(LeftBackLowerLeg, -0.2618F, 0.0F, 0.0F);
		LeftBackLowerLeg.setTextureOffset(63, 28).addBox(-1.0F, -0.3709F, -1.2955F, 2.0F, 10.0F, 3.0F, 0.0F, false);

		LeftBackHoof = new ModelRenderer(this);
		LeftBackHoof.setRotationPoint(-3.25F, 10.0F, -10.0477F);
		LeftBackLowerLeg.addChild(LeftBackHoof);
		LeftBackHoof.setTextureOffset(25, 19).addBox(1.75F, -1.3709F, 8.0F, 3.0F, 1.0F, 4.0F, 0.0F, false);

		LeftThigh = new ModelRenderer(this);
		LeftThigh.setRotationPoint(2.5F, -17.0F, 8.35F);
		Body.addChild(LeftThigh);
		setRotationAngle(LeftThigh, -0.0873F, 0.0F, 0.0F);
		LeftThigh.setTextureOffset(0, 53).addBox(-3.25F, -5.4943F, -2.8807F, 5.0F, 8.0F, 5.0F, 0.0F, false);

		RightThigh = new ModelRenderer(this);
		RightThigh.setRotationPoint(-2.5F, -17.0F, 8.35F);
		Body.addChild(RightThigh);
		setRotationAngle(RightThigh, -0.0873F, 0.0F, 0.0F);
		RightThigh.setTextureOffset(46, 18).addBox(-1.75F, -5.4943F, -2.8807F, 5.0F, 8.0F, 5.0F, 0.0F, false);

		RightBackLeg = new ModelRenderer(this);
		RightBackLeg.setRotationPoint(-1.75F, -16.0F, 9.0F);
		Body.addChild(RightBackLeg);
		setRotationAngle(RightBackLeg, 0.2618F, 0.0F, 0.0F);
		RightBackLeg.setTextureOffset(20, 55).addBox(-3.0F, -1.8296F, -2.0F, 3.0F, 9.0F, 4.0F, 0.0F, false);

		RightBackLowerLeg = new ModelRenderer(this);
		RightBackLowerLeg.setRotationPoint(-1.0F, 6.4227F, -0.3409F);
		RightBackLeg.addChild(RightBackLowerLeg);
		setRotationAngle(RightBackLowerLeg, -0.2618F, 0.0F, 0.0F);
		RightBackLowerLeg.setTextureOffset(62, 0).addBox(-1.5F, -0.9151F, -1.2955F, 2.0F, 10.0F, 3.0F, 0.0F, false);

		RightBackHoof = new ModelRenderer(this);
		RightBackHoof.setRotationPoint(-2.25F, 9.6894F, -10.2068F);
		RightBackLowerLeg.addChild(RightBackHoof);
		RightBackHoof.setTextureOffset(25, 0).addBox(0.25F, -0.9121F, 8.1591F, 3.0F, 1.0F, 4.0F, 0.0F, false);

		LeftFrontLeg = new ModelRenderer(this);
		LeftFrontLeg.setRotationPoint(4.25F, -16.0F, -6.0F);
		Body.addChild(LeftFrontLeg);
		setRotationAngle(LeftFrontLeg, -0.1745F, 0.0F, 0.0F);
		LeftFrontLeg.setTextureOffset(60, 62).addBox(-2.25F, -2.7748F, -2.2709F, 3.0F, 10.0F, 3.0F, 0.0F, false);

		LeftFrontLowerLeg = new ModelRenderer(this);
		LeftFrontLowerLeg.setRotationPoint(-0.65F, 7.0616F, -0.7997F);
		LeftFrontLeg.addChild(LeftFrontLowerLeg);
		setRotationAngle(LeftFrontLowerLeg, 0.1745F, 0.0F, 0.0F);
		LeftFrontLowerLeg.setTextureOffset(8, 66).addBox(-1.35F, -1.0008F, -1.0449F, 2.0F, 10.0F, 2.0F, 0.0F, false);

		LeftFrontHoof = new ModelRenderer(this);
		LeftFrontHoof.setRotationPoint(0.1F, 8.4468F, -0.1667F);
		LeftFrontLowerLeg.addChild(LeftFrontHoof);
		LeftFrontHoof.setTextureOffset(61, 15).addBox(-1.2F, -0.2976F, -1.5F, 2.0F, 1.0F, 3.0F, 0.0F, false);

		RightFrontLeg = new ModelRenderer(this);
		RightFrontLeg.setRotationPoint(-3.25F, -16.0F, -6.0F);
		Body.addChild(RightFrontLeg);
		setRotationAngle(RightFrontLeg, -0.1745F, 0.0F, 0.0F);
		RightFrontLeg.setTextureOffset(48, 62).addBox(-1.75F, -2.7748F, -2.2709F, 3.0F, 10.0F, 3.0F, 0.0F, false);

		RightFrontLowerLeg = new ModelRenderer(this);
		RightFrontLowerLeg.setRotationPoint(-0.65F, 7.0616F, -0.4551F);
		RightFrontLeg.addChild(RightFrontLowerLeg);
		setRotationAngle(RightFrontLowerLeg, 0.1745F, 0.0F, 0.0F);
		RightFrontLowerLeg.setTextureOffset(0, 66).addBox(-0.85F, -1.0616F, -1.3896F, 2.0F, 10.0F, 2.0F, 0.0F, false);

		RightFrontHoof = new ModelRenderer(this);
		RightFrontHoof.setRotationPoint(0.1F, 8.386F, -0.7667F);
		RightFrontLowerLeg.addChild(RightFrontHoof);
		RightFrontHoof.setTextureOffset(32, 24).addBox(-1.2F, -0.2976F, -1.2447F, 2.0F, 1.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(DoeEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
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