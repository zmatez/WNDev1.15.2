package com.matez.wildnature.common.entity.render.animal;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.common.entity.model.animal.DoeModel;
import com.matez.wildnature.common.entity.type.animal.deer.DoeEntity;
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
        return WN.RegistryEvents.location("textures/entity/deer_female.png");
    }

    public static class RenderFactory implements IRenderFactory<DoeEntity>{
        @Override
        public EntityRenderer<? super DoeEntity> createRenderFor(EntityRendererManager manager) {
            return new DoeRender(manager);
        }
    }
}
