package com.matez.wildnature.entity.render.monster;

import com.matez.wildnature.Main;
import com.matez.wildnature.entity.model.monster.GoblinModel;
import com.matez.wildnature.entity.type.monster.GoblinEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;
@OnlyIn(Dist.CLIENT)
public class GoblinRender extends MobRenderer<GoblinEntity, GoblinModel> {
    public GoblinRender(EntityRendererManager manager) {
        super(manager, new GoblinModel(), 0F);
    }

    @Nullable
    @Override
    public ResourceLocation getEntityTexture(GoblinEntity entity) {
        return Main.RegistryEvents.location("textures/entity/goblin.png");
    }

    public static class RenderFactory implements IRenderFactory<GoblinEntity>{

        @Override
        public EntityRenderer<? super GoblinEntity> createRenderFor(EntityRendererManager manager) {
            return new GoblinRender(manager);
        }
    }
}
