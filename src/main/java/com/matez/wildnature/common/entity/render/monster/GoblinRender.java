package com.matez.wildnature.common.entity.render.monster;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.common.entity.model.monster.GoblinModel;
import com.matez.wildnature.common.entity.type.monster.GoblinEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
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
        return WN.RegistryEvents.location("textures/entity/goblin.png");
    }

    public static class RenderFactory implements IRenderFactory<GoblinEntity>{

        @Override
        public EntityRenderer<? super GoblinEntity> createRenderFor(EntityRendererManager manager) {
            return new GoblinRender(manager);
        }
    }
}
