package com.matez.wildnature.util.event;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.world.generation.provider.WNWorldType;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class WorldUnloadEvent {

    @SubscribeEvent
    public void onWorldUnload(WorldEvent.Unload event){
        WN.LOGGER.info("Unloading world " + event.getWorld().getWorldInfo().getWorldName() + "...");
        if(WNWorldType.generator != null && event.getWorld().getDimension().getType() == DimensionType.OVERWORLD){
            WN.LOGGER.info("World was run on WildNature world generator:");
            WN.LOGGER.info("--- Unloading terrains...");
            //WNWorldType.generator.getContext().getTerrainProvider().unload();
            WN.LOGGER.info("--- Unloaded all terrains");
            WNWorldType.generator = null;
            WN.runningWorld = null;
            WN.LOGGER.info("Successfully unloaded world.");
            return;
        }
        WN.LOGGER.info("World isn't a WildNature world");
    }
}
