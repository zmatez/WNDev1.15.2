package com.matez.wildnature.common.entity.render.animal;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.common.entity.model.animal.SparrowModel;
import com.matez.wildnature.common.entity.type.animal.bird.SparrowEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class SparrowMaleRenderer extends MobRenderer<SparrowEntity, SparrowModel> {
    public SparrowMaleRenderer(EntityRendererManager manager) {
        super(manager, new SparrowModel(), 0.8F);
    }

    @Nullable
    @Override
    public ResourceLocation getEntityTexture(SparrowEntity entity) {
        return WN.RegistryEvents.location("textures/entity/sparrow_male.png");
    }

    public static class RenderFactory implements IRenderFactory<SparrowEntity>{
        @Override
        public EntityRenderer<? super SparrowEntity> createRenderFor(EntityRendererManager manager) {
            return new SparrowMaleRenderer(manager);
        }
    }
}
