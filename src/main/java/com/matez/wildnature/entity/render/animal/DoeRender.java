package com.matez.wildnature.entity.render.animal;

import com.matez.wildnature.Main;
import com.matez.wildnature.entity.model.animal.BuckModel;
import com.matez.wildnature.entity.model.animal.DoeModel;
import com.matez.wildnature.entity.type.animal.deer.AbstractDeerEntity;
import com.matez.wildnature.entity.type.animal.deer.DoeEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class DoeRender extends MobRenderer<DoeEntity, DoeModel> {
    public DoeRender(EntityRendererManager manager) {
        super(manager, new DoeModel(), 1.2F);
    }

    @Nullable
    @Override
    public ResourceLocation getEntityTexture(DoeEntity entity) {
        return Main.RegistryEvents.location("textures/entity/deer_female.png");
    }

    public static class RenderFactory implements IRenderFactory<DoeEntity>{
        @Override
        public EntityRenderer<? super DoeEntity> createRenderFor(EntityRendererManager manager) {
            return new DoeRender(manager);
        }
    }
}
