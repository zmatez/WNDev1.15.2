package com.matez.wildnature.entity.model.animal;

import com.matez.wildnature.entity.type.animal.boar.BoarEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.PigModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

/**
 * ModelBoar - Matheus
 * Created using Tabula 7.0.0
 */
public class BoarModel extends EntityModel<BoarEntity> {
    public ModelRenderer neck;
    public ModelRenderer body;
    public ModelRenderer BackRightLeg;
    public ModelRenderer BackLeftLeg;
    public ModelRenderer FrontRightLeg;
    public ModelRenderer FrontLeftLeg;
    public ModelRenderer tail;
    public ModelRenderer head;
    public ModelRenderer neck2;
    public ModelRenderer head2;
    public ModelRenderer head3;
    public ModelRenderer head4;
    public ModelRenderer rightear;
    public ModelRenderer leftear;
    public ModelRenderer head5;
    public ModelRenderer teethright;
    public ModelRenderer teethleft;
    public ModelRenderer rightear2;
    public ModelRenderer leftear2;
    public ModelRenderer body2;
    public ModelRenderer tail2;

    public BoarModel() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.BackRightLeg = new ModelRenderer(this, 100, 29);
        this.BackRightLeg.setRotationPoint(-2.5F, 16.0F, 7.5F);
        this.BackRightLeg.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
        this.FrontLeftLeg = new ModelRenderer(this, 116, 29);
        this.FrontLeftLeg.setRotationPoint(2.5F, 16.0F, -4.5F);
        this.FrontLeftLeg.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
        this.neck2 = new ModelRenderer(this, 0, 20);
        this.neck2.setRotationPoint(-1.5F, -6.8F, -4.8F);
        this.neck2.addBox(0.0F, 0.0F, 0.0F, 3, 1, 5, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(1.0F, -2.6F, -1.4F);
        this.head.addBox(-4.0F, -4.0F, -8.0F, 6, 8, 6, 0.0F);
        this.setRotateAngle(head, 0.2617993877991494F, 0.0F, 0.0F);
        this.tail2 = new ModelRenderer(this, 56, 0);
        this.tail2.setRotationPoint(-2.5F, 0.0F, 2.1F);
        this.tail2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(tail2, -0.3490658503988659F, -0.0F, 0.0F);
        this.tail = new ModelRenderer(this, 44, 0);
        this.tail.setRotationPoint(2.0F, 9.5F, 10.6F);
        this.tail.addBox(-2.5F, 0.0F, -2.0F, 1, 1, 4, 0.0F);
        this.setRotateAngle(tail, -0.9599310885968813F, -0.0F, 0.0F);
        this.head5 = new ModelRenderer(this, 0, 20);
        this.head5.setRotationPoint(-2.5F, -5.0F, -7.0F);
        this.head5.addBox(0.0F, 0.0F, 0.0F, 3, 1, 5, 0.0F);
        this.BackLeftLeg = new ModelRenderer(this, 100, 29);
        this.BackLeftLeg.setRotationPoint(2.5F, 16.0F, 7.5F);
        this.BackLeftLeg.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
        this.head3 = new ModelRenderer(this, 55, 37);
        this.head3.setRotationPoint(1.0F, 3.5F, -5.0F);
        this.head3.addBox(-4.0F, -4.0F, -8.0F, 4, 3, 6, 0.0F);
        this.setRotateAngle(head3, 0.08726646259971647F, -0.0F, 0.0F);
        this.head4 = new ModelRenderer(this, 78, 37);
        this.head4.setRotationPoint(-1.0F, 3.5F, -7.3F);
        this.head4.addBox(-1.5F, -1.0F, -5.0F, 3, 1, 5, 0.0F);
        this.setRotateAngle(head4, 0.06981317007977318F, -0.0F, 0.0F);
        this.teethleft = new ModelRenderer(this, 0, 0);
        this.teethleft.setRotationPoint(2.5F, -3.5F, -3.5F);
        this.teethleft.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(teethleft, 0.0F, 0.0F, 0.5410520681182421F);
        this.body = new ModelRenderer(this, 28, 54);
        this.body.setRotationPoint(0.5F, 16.4F, -7.5F);
        this.body.addBox(-5.0F, -10.0F, 0.0F, 9, 10, 17, 0.0F);
        this.setRotateAngle(body, -0.05235987755982988F, -0.0F, 0.0F);
        this.leftear = new ModelRenderer(this, 25, 0);
        this.leftear.mirror = true;
        this.leftear.setRotationPoint(-0.9F, -3.23F, -5.0F);
        this.leftear.addBox(0.0F, 0.0F, 0.0F, 4, 2, 1, 0.0F);
        this.setRotateAngle(leftear, 0.15707963267948966F, 0.576482251933727F, -0.6841690667817772F);
        this.teethright = new ModelRenderer(this, 0, 0);
        this.teethright.setRotationPoint(-3.4F, -3.0F, -3.5F);
        this.teethright.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(teethright, 0.0F, 0.0F, -0.5410520681182421F);
        this.head2 = new ModelRenderer(this, 37, 37);
        this.head2.setRotationPoint(1.5F, -2.0F, -3.6F);
        this.head2.addBox(-4.0F, -4.0F, -8.0F, 3, 3, 6, 0.0F);
        this.setRotateAngle(head2, 0.7504915783575618F, 0.0F, 0.0F);
        this.rightear = new ModelRenderer(this, 25, 0);
        this.rightear.mirror = true;
        this.rightear.setRotationPoint(-4.0F, -5.53F, -7.4F);
        this.rightear.addBox(0.0F, 0.0F, 0.0F, 4, 2, 1, 0.0F);
        this.setRotateAngle(rightear, 0.15707963267948966F, -0.576482251933727F, 0.6841690667817772F);
        this.body2 = new ModelRenderer(this, 0, 20);
        this.body2.setRotationPoint(-2.0F, -10.8F, 1.2F);
        this.body2.addBox(0.0F, 0.0F, 0.0F, 3, 1, 13, 0.0F);
        this.setRotateAngle(body2, -0.06981317007977318F, 0.0F, 0.0F);
        this.neck = new ModelRenderer(this, 70, 17);
        this.neck.setRotationPoint(0.0F, 12.6F, -5.6F);
        this.neck.addBox(-3.5F, -6.0F, -5.0F, 7, 9, 5, 0.0F);
        this.setRotateAngle(neck, -0.2617993877991494F, -0.0F, 0.0F);
        this.leftear2 = new ModelRenderer(this, 25, 10);
        this.leftear2.setRotationPoint(3.7F, 0.6F, 0.0F);
        this.leftear2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.FrontRightLeg = new ModelRenderer(this, 116, 29);
        this.FrontRightLeg.setRotationPoint(-2.5F, 16.0F, -4.5F);
        this.FrontRightLeg.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
        this.rightear2 = new ModelRenderer(this, 25, 10);
        this.rightear2.setRotationPoint(-0.9F, 0.6F, -0.1F);
        this.rightear2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.neck.addChild(this.neck2);
        this.neck.addChild(this.head);
        this.tail.addChild(this.tail2);
        this.head.addChild(this.head5);
        this.head.addChild(this.head3);
        this.head.addChild(this.head4);
        this.head4.addChild(this.teethleft);
        this.head.addChild(this.leftear);
        this.head4.addChild(this.teethright);
        this.head.addChild(this.head2);
        this.head.addChild(this.rightear);
        this.body.addChild(this.body2);
        this.leftear.addChild(this.leftear2);
        this.rightear.addChild(this.rightear2);
    }


    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer ModelRenderer, float x, float y, float z) {
        ModelRenderer.rotateAngleX = x;
        ModelRenderer.rotateAngleY = y;
        ModelRenderer.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(BoarEntity boarEntity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.rotateAngleX = headPitch * 0.017453292F;
        this.head.rotateAngleY = netHeadYaw * 0.017453292F;
        //this.body.rotateAngleX = ((float)Math.PI / 2F)-90;
        this.FrontLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.FrontRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.BackRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.BackLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder iVertexBuilder, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.BackRightLeg.render(matrixStack,iVertexBuilder,packedLightIn,packedOverlayIn,red,green,blue,alpha);
        this.FrontLeftLeg.render(matrixStack,iVertexBuilder,packedLightIn,packedOverlayIn,red,green,blue,alpha);
        this.tail.render(matrixStack,iVertexBuilder,packedLightIn,packedOverlayIn,red,green,blue,alpha);
        this.BackLeftLeg.render(matrixStack,iVertexBuilder,packedLightIn,packedOverlayIn,red,green,blue,alpha);
        this.body.render(matrixStack,iVertexBuilder,packedLightIn,packedOverlayIn,red,green,blue,alpha);
        this.neck.render(matrixStack,iVertexBuilder,packedLightIn,packedOverlayIn,red,green,blue,alpha);
        this.FrontRightLeg.render(matrixStack,iVertexBuilder,packedLightIn,packedOverlayIn,red,green,blue,alpha);
    }
}
