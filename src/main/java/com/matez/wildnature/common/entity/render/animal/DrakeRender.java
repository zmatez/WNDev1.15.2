package com.matez.wildnature.common.entity.render.animal;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.common.entity.model.animal.DrakeModel;
import com.matez.wildnature.common.entity.type.animal.duck.DrakeEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class DrakeRender extends MobRenderer<DrakeEntity, DrakeModel> {
    public DrakeRender(EntityRendererManager manager) {
        super(manager, new DrakeModel(), 0.3F);
    }

    @Nullable
    @Override
    public ResourceLocation getEntityTexture(DrakeEntity entity) {
        return WN.RegistryEvents.location("textures/entity/duck_male.png");
    }

    public static class RenderFactory implements IRenderFactory<DrakeEntity>{
        @Override
        public EntityRenderer<? super DrakeEntity> createRenderFor(EntityRendererManager manager) {
            return new DrakeRender(manager);
        }
    }
}
