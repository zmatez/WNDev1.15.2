package com.matez.wildnature.util.event;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.world.generation.structures.utils.StructureCache;
import net.minecraftforge.event.world.ChunkDataEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ChunkEvent {

    @SubscribeEvent
    public void chunkLoad(ChunkDataEvent.Load event) {
        StructureCache.read(event.getChunk(),event.getData());
    }

    @SubscribeEvent
    public void chunkSave(ChunkDataEvent.Save event) {
        StructureCache.write(event.getChunk(),event.getData());
    }

    @SubscribeEvent
    public void chunkUnload(ChunkDataEvent.Unload event) {
        StructureCache.free(event.getChunk());
    }
}
