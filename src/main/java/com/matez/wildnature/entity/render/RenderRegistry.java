package com.matez.wildnature.entity.render;


import com.matez.wildnature.entity.EntityRegistry;
import com.matez.wildnature.entity.render.animal.*;
import com.matez.wildnature.entity.render.monster.GoblinRender;
import com.matez.wildnature.entity.type.animal.bird.SparrowEntity;
import com.matez.wildnature.entity.type.animal.boar.BoarEntity;
import com.matez.wildnature.entity.type.animal.deer.BuckEntity;
import com.matez.wildnature.entity.type.animal.deer.DoeEntity;
import com.matez.wildnature.entity.type.animal.deer.FawnEntity;
import com.matez.wildnature.entity.type.animal.duck.DrakeEntity;
import com.matez.wildnature.entity.type.animal.duck.DuckEntity;
import com.matez.wildnature.entity.type.animal.duck.DucklingEntity;
import com.matez.wildnature.entity.type.animal.fish.PiranhaEntity;
import com.matez.wildnature.entity.type.animal.insect.DragonflyEntity;
import com.matez.wildnature.entity.type.monster.GoblinEntity;
import com.matez.wildnature.gui.tileEntities.seat.SeatEntity;
import com.matez.wildnature.gui.tileEntities.seat.SeatEntityRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class RenderRegistry {
    public static void registryEntityRenders(){
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.GOBLIN,new GoblinRender.RenderFactory());
        //animals
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.DRAKE,new DrakeRender.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.DUCK,new DuckRender.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.DUCKLING,new DucklingRender.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.BOAR,new BoarRender.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.PIRANHA,new PiranhaRender.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.DRAGONFLY,new DragonflyRender.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.SPARROW_MALE,new SparrowMaleRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.BUCK,new BuckRender.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.DOE,new DoeRender.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.FAWN,new FawnRender.RenderFactory());

        //tiles
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.SEAT,new SeatEntityRenderer.RenderFactory());

    }
}
