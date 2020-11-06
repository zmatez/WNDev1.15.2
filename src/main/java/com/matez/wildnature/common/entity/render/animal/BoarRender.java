package com.matez.wildnature.common.entity.render.animal;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.common.entity.model.animal.BoarModel;
import com.matez.wildnature.common.entity.type.animal.boar.BoarEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class BoarRender extends MobRenderer<BoarEntity, BoarModel> {
    public BoarRender(EntityRendererManager manager) {
        super(manager, new BoarModel(), 0.8F);
    }

    @Nullable
    @Override
    public ResourceLocation getEntityTexture(BoarEntity entity) {
        return WN.RegistryEvents.location("textures/entity/boar.png");
    }

    public static class RenderFactory implements IRenderFactory<BoarEntity>{
        @Override
        public EntityRenderer<? super BoarEntity> createRenderFor(EntityRendererManager manager) {
            return new BoarRender(manager);
        }
    }
}
