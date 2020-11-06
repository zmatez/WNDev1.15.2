package com.matez.wildnature.common.entity.render.animal;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.common.entity.model.animal.BuckModel;
import com.matez.wildnature.common.entity.type.animal.deer.BuckEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class BuckRender extends MobRenderer<BuckEntity, BuckModel> {
    public BuckRender(EntityRendererManager manager) {
        super(manager, new BuckModel(), 1.2F);
    }

    @Nullable
    @Override
    public ResourceLocation getEntityTexture(BuckEntity entity) {
        return WN.RegistryEvents.location("textures/entity/deer_male.png");
    }

    public static class RenderFactory implements IRenderFactory<BuckEntity>{
        @Override
        public EntityRenderer<? super BuckEntity> createRenderFor(EntityRendererManager manager) {
            return new BuckRender(manager);
        }
    }
}
