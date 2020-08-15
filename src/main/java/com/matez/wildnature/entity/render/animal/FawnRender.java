package com.matez.wildnature.entity.render.animal;

import com.matez.wildnature.Main;
import com.matez.wildnature.entity.model.animal.DoeModel;
import com.matez.wildnature.entity.model.animal.FawnModel;
import com.matez.wildnature.entity.type.animal.deer.AbstractDeerEntity;
import com.matez.wildnature.entity.type.animal.deer.FawnEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class FawnRender extends MobRenderer<FawnEntity, FawnModel> {
    public FawnRender(EntityRendererManager manager) {
        super(manager, new FawnModel(), 0.9F);
    }

    @Nullable
    @Override
    public ResourceLocation getEntityTexture(FawnEntity entity) {
        return Main.RegistryEvents.location("textures/entity/deer_baby.png");
    }

    public static class RenderFactory implements IRenderFactory<FawnEntity>{
        @Override
        public EntityRenderer<? super FawnEntity> createRenderFor(EntityRendererManager manager) {
            return new FawnRender(manager);
        }
    }
}
