package com.matez.wildnature.common.entity.render.tileentity;

import com.matez.wildnature.common.tileentity.item.ItemTileEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ItemTileEntityRender extends TileEntityRenderer<ItemTileEntity> {
    public ItemTileEntityRender(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
    }

    @Override
    public void render(ItemTileEntity tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
        if(tileEntityIn.hasPlacedStack()){
            matrixStackIn.push();
            matrixStackIn.translate(0.5D, 1, 0.5D);
            matrixStackIn.scale(1.3F, 1.3F, 1.3F);
            matrixStackIn.rotate(Vector3f.XP.rotationDegrees(90.0F));
            matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(tileEntityIn.getFacing().getHorizontalIndex() * 90));
            Minecraft.getInstance().getItemRenderer().renderItem(tileEntityIn.getPlacedStack(), ItemCameraTransforms.TransformType.GROUND,combinedLightIn,combinedOverlayIn,matrixStackIn,bufferIn);
            matrixStackIn.pop();
        }
    }
}
