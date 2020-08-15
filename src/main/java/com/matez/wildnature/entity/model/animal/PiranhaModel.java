package com.matez.wildnature.entity.model.animal;// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.matez.wildnature.entity.type.animal.fish.PiranhaEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class PiranhaModel extends EntityModel<PiranhaEntity> {
	private final ModelRenderer Body;
	private final ModelRenderer Head;
	private final ModelRenderer Jaw;
	private final ModelRenderer Tail;
	private final ModelRenderer bone;
	private final ModelRenderer TailFin;
	private final ModelRenderer BackSmallFin;
	private final ModelRenderer TopFins;
	private final ModelRenderer BottomFins;
	private final ModelRenderer LeftFin;
	private final ModelRenderer RightFin;

	public PiranhaModel() {
		textureWidth = 32;
		textureHeight = 32;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		Body.setTextureOffset(0, 0).addBox(-2.0F, -7.0F, -4.0F, 3.0F, 5.0F, 6.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(-0.25F, 19.0F, -2.5F);
		setRotationAngle(Head, 0.1745F, 0.0F, 0.0F);
		Head.setTextureOffset(10, 11).addBox(-1.5F, -1.75F, -3.6642F, 2.0F, 2.0F, 3.0F, 0.0F, false);
		Head.setTextureOffset(12, 1).addBox(0.85F, 0.25F, -3.5F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		Head.setTextureOffset(0, 0).addBox(-1.35F, 0.25F, -3.5F, 0.0F, 1.0F, 2.0F, 0.0F, false);

		Jaw = new ModelRenderer(this);
		Jaw.setRotationPoint(-0.25F, 1.5F, -1.0F);
		Head.addChild(Jaw);
		setRotationAngle(Jaw, 0.4363F, 0.0F, 0.0F);
		Jaw.setTextureOffset(12, 0).addBox(-1.0F, -0.5F, -2.4674F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		Jaw.setTextureOffset(2, 0).addBox(-0.9F, -1.5F, -2.4F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		Jaw.setTextureOffset(0, 0).addBox(0.9F, -1.5F, -2.4F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		Jaw.setTextureOffset(0, 0).addBox(-0.75F, -1.5F, -2.3F, 1.0F, 1.0F, 0.0F, 0.0F, false);

		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(-0.375F, 19.5F, 1.0F);
		Tail.setTextureOffset(0, 11).addBox(-1.125F, -2.0F, 0.0F, 2.0F, 4.0F, 3.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, 2.5F);
		Tail.addChild(bone);
		bone.setTextureOffset(17, 17).addBox(-0.625F, -1.5F, 0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		TailFin = new ModelRenderer(this);
		TailFin.setRotationPoint(-0.125F, 0.0F, 1.5F);
		bone.addChild(TailFin);
		TailFin.setTextureOffset(0, 15).addBox(0.0F, -2.5F, 0.0F, 0.0F, 5.0F, 3.0F, 0.0F, false);

		BackSmallFin = new ModelRenderer(this);
		BackSmallFin.setRotationPoint(-0.125F, -1.5F, 0.0F);
		Tail.addChild(BackSmallFin);
		setRotationAngle(BackSmallFin, -1.0472F, 0.0F, 0.0F);
		BackSmallFin.setTextureOffset(4, 0).addBox(0.0F, -3.5F, 0.5F, 0.0F, 2.0F, 1.0F, 0.0F, false);

		TopFins = new ModelRenderer(this);
		TopFins.setRotationPoint(-0.5F, 18.0F, 1.0F);
		setRotationAngle(TopFins, -1.0472F, 0.0F, 0.0F);
		TopFins.setTextureOffset(6, 16).addBox(0.0F, -3.0F, -1.8F, 0.0F, 4.0F, 2.0F, 0.0F, false);

		BottomFins = new ModelRenderer(this);
		BottomFins.setRotationPoint(-0.5F, 21.0F, 2.2F);
		setRotationAngle(BottomFins, 0.3491F, 0.0F, 0.0F);
		BottomFins.setTextureOffset(10, 12).addBox(0.0F, 0.0F, -2.0F, 0.0F, 2.0F, 4.0F, 0.0F, false);

		LeftFin = new ModelRenderer(this);
		LeftFin.setRotationPoint(1.0F, 20.5F, -3.0F);
		setRotationAngle(LeftFin, 0.0F, 0.2618F, 0.0F);
		LeftFin.setTextureOffset(7, 8).addBox(0.0F, -1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 0.0F, false);

		RightFin = new ModelRenderer(this);
		RightFin.setRotationPoint(-2.0F, 20.5F, -3.0F);
		setRotationAngle(RightFin, 0.0F, -0.2618F, 0.0F);
		RightFin.setTextureOffset(0, 0).addBox(0.0F, -1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(PiranhaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Tail.render(matrixStack, buffer, packedLight, packedOverlay);
		TopFins.render(matrixStack, buffer, packedLight, packedOverlay);
		BottomFins.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftFin.render(matrixStack, buffer, packedLight, packedOverlay);
		RightFin.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}