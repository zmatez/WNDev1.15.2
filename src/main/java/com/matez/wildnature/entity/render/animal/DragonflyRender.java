package com.matez.wildnature.entity.render.animal;

import com.matez.wildnature.Main;
import com.matez.wildnature.entity.model.animal.DragonflyModel;
import com.matez.wildnature.entity.type.animal.insect.DragonflyEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class DragonflyRender extends MobRenderer<DragonflyEntity, DragonflyModel> {
    public DragonflyRender(EntityRendererManager manager) {
        super(manager, new DragonflyModel(), 0.2F);


    }

    @Nullable
    @Override
    public ResourceLocation getEntityTexture(DragonflyEntity entity) {
        if(entity.getVariant()==null){
            return Main.RegistryEvents.location("textures/entity/"+ DragonflyEntity.DragonFlyVariant.BLUE.getPath());

        }else{
            return Main.RegistryEvents.location("textures/entity/"+entity.getVariant().getPath());
        }
    }

    public static class RenderFactory implements IRenderFactory<DragonflyEntity>{
        @Override
        public EntityRenderer<? super DragonflyEntity> createRenderFor(EntityRendererManager manager) {
            return new DragonflyRender(manager);
        }
    }
}
