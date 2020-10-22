package com.matez.wildnature.entity.render.tileentity;

import com.matez.wildnature.Main;
import com.matez.wildnature.entity.model.animal.BoarModel;
import com.matez.wildnature.entity.render.animal.BoarRender;
import com.matez.wildnature.entity.type.animal.boar.BoarEntity;
import com.matez.wildnature.gui.tileEntities.item.ItemTileEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

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
