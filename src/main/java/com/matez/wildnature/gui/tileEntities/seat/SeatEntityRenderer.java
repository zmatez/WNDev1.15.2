package com.matez.wildnature.gui.tileEntities.seat;

import com.matez.wildnature.entity.render.animal.FawnRender;
import com.matez.wildnature.entity.type.animal.deer.AbstractDeerEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class SeatEntityRenderer extends EntityRenderer<SeatEntity>
{
    public SeatEntityRenderer(EntityRendererManager renderManager)
    {
        super(renderManager);
    }

    @Override
    public ResourceLocation getEntityTexture(SeatEntity entity)
    {
        return null;
    }

    public static class RenderFactory implements IRenderFactory<SeatEntity> {
        @Override
        public EntityRenderer<? super SeatEntity> createRenderFor(EntityRendererManager manager) {
            return new SeatEntityRenderer(manager);
        }
    }
}