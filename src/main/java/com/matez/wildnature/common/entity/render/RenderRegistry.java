package com.matez.wildnature.common.entity.render;


import com.matez.wildnature.common.entity.EntityRegistry;
import com.matez.wildnature.common.entity.render.animal.*;
import com.matez.wildnature.common.entity.render.misc.blowpipe.RowanBlowdartRender;
import com.matez.wildnature.common.entity.render.monster.GoblinRender;
import com.matez.wildnature.common.entity.render.tileentity.ItemTileEntityRender;
import com.matez.wildnature.client.gui.initGuis;
import com.matez.wildnature.common.tileentity.seat.SeatEntityRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.ClientRegistry;
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

        //misc
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.ROWAN_BLOWDART,new RowanBlowdartRender.RenderFactory());

        //tileentities

    }

    public static void registryTileEntityRenders(){
        ClientRegistry.bindTileEntityRenderer(initGuis.ITEM_TILE_ENTITY, ItemTileEntityRender::new);
    }
}
