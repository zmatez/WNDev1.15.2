package com.matez.wildnature.entity.render.animal;

import com.matez.wildnature.Main;
import com.matez.wildnature.entity.model.animal.PiranhaModel;
import com.matez.wildnature.entity.type.animal.fish.PiranhaEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class PiranhaRender extends MobRenderer<PiranhaEntity, PiranhaModel> {
    public PiranhaRender(EntityRendererManager manager) {
        super(manager, new PiranhaModel(), 0.2F);
    }

    @Nullable
    @Override
    public ResourceLocation getEntityTexture(PiranhaEntity entity) {
        if(!entity.isAngry()) {
            return Main.RegistryEvents.location("textures/entity/piranha.png");
        }else{
            return Main.RegistryEvents.location("textures/entity/piranha_angry.png");
        }
    }

    public static class RenderFactory implements IRenderFactory<PiranhaEntity>{
        @Override
        public EntityRenderer<? super PiranhaEntity> createRenderFor(EntityRendererManager manager) {
            return new PiranhaRender(manager);
        }
    }
}
