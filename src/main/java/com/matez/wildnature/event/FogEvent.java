package com.matez.wildnature.event;

import com.matez.wildnature.Main;
import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomes;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class FogEvent {

    @SubscribeEvent
    public void fogEvent(EntityViewRenderEvent.FogDensity event){
        /*BlockPos pos = event.getInfo().getBlockPos();
        World world = event.getInfo().getRenderViewEntity().getEntityWorld();
        if(world.getBlockState(pos).getBlock()== Blocks.CAVE_AIR && pos.getY()<30){
            event.setDensity(0.5f);
            if(Utilities.rint(0,50)==0){
                Main.LOGGER.info("fog: " + event.getDensity());
            }
            event.setCanceled(true);
        }*/
    }


    @SubscribeEvent
    public void fogColorEvent(EntityViewRenderEvent.FogColors event){
        /*BlockPos pos = event.getInfo().getBlockPos();
        World world = event.getInfo().getRenderViewEntity().getEntityWorld();
        if(world.getBlockState(pos).getBlock()== Blocks.CAVE_AIR && pos.getY()<30){
            event.setBlue(0.7f);
            event.setRed(0.2f);
            event.setGreen(1f);

            if(Utilities.rint(0,50)==0){
                Main.LOGGER.info("fog: " + event.getBlue() + " " + event.getRed() + " " + event.getGreen());
            }
        }*/
    }

    @SubscribeEvent
    public void waterColorEvent(ColorHandlerEvent.Block event){
        //event.getBlockColors().
    }




}
