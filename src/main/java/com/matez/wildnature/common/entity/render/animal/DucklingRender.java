package com.matez.wildnature.common.entity.render.animal;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.common.entity.model.animal.DucklingModel;
import com.matez.wildnature.common.entity.type.animal.duck.DucklingEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class DucklingRender extends MobRenderer<DucklingEntity, DucklingModel> {
    public DucklingRender(EntityRendererManager manager) {
        super(manager, new DucklingModel(), 0.3F);
    }

    @Nullable
    @Override
    public ResourceLocation getEntityTexture(DucklingEntity entity) {
        return WN.RegistryEvents.location("textures/entity/duck_baby.png");
    }

    public static class RenderFactory implements IRenderFactory<DucklingEntity>{
        @Override
        public EntityRenderer<? super DucklingEntity> createRenderFor(EntityRendererManager manager) {
            return new DucklingRender(manager);
        }
    }
}
