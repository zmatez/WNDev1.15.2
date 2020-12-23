package com.matez.wildnature.world.generation.chunk.generation;

import com.matez.wildnature.world.generation.chunk.WNWorldContext;
import com.matez.wildnature.world.generation.provider.WNGridBiomeProvider;
import com.matez.wildnature.world.generation.structures.WNAbstractStructure;
import net.minecraft.world.biome.Biome;

public interface IWNChunkGenerator {
    public WNWorldContext getContext();

    public WNGridBiomeProvider getGridProvider();

    public void setContext(WNWorldContext context);

    public boolean hasStructure(Biome biomeIn, WNAbstractStructure structureIn);


}
