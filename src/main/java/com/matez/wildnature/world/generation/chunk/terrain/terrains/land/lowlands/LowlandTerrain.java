package com.matez.wildnature.world.generation.chunk.terrain.terrains.land.lowlands;

import com.matez.wildnature.world.generation.biome.setup.BiomeGroup;
import com.matez.wildnature.world.generation.chunk.terrain.Terrain;
import net.minecraftforge.common.BiomeDictionary;

public class LowlandTerrain extends Terrain {
    public LowlandTerrain() {
        super("lowland", new TerrainBuilder()
                .terrainCategory(Category.LOWLANDS)
        );
    }

    @Override
    public BiomeGroup[] getBiomeGroups() {
        return BiomeGroup.guess(Category.LOWLANDS,new BiomeDictionary.Type[]{}, new BiomeDictionary.Type[]{});
    }
}
