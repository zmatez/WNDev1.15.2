package com.matez.wildnature.common.entity.render.animal;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.common.entity.model.animal.DuckModel;
import com.matez.wildnature.common.entity.type.animal.duck.DuckEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class DuckRender extends MobRenderer<DuckEntity, DuckModel> {
    public DuckRender(EntityRendererManager manager) {
        super(manager, new DuckModel(), 0.3F);
    }

    @Nullable
    @Override
    public ResourceLocation getEntityTexture(DuckEntity entity) {
        return WN.RegistryEvents.location("textures/entity/duck_female.png");
    }


    public static class RenderFactory implements IRenderFactory<DuckEntity>{
        @Override
        public EntityRenderer<? super DuckEntity> createRenderFor(EntityRendererManager manager) {
            return new DuckRender(manager);
        }
    }
}
