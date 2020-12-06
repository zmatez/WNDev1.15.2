package com.matez.wildnature.world.generation.terrain.terrains.oceans;

import com.matez.wildnature.world.generation.biome.registry.WNBiomes;
import com.matez.wildnature.world.generation.biome.setup.grid.BiomeGroup;
import com.matez.wildnature.world.generation.terrain.Terrain;

public class OceanTerrain extends Terrain {
    public OceanTerrain() {
        super("ocean", new TerrainBuilder()
                .terrainCategory(Category.OCEAN)
        );
    }

    @Override
    public BiomeGroup[] getBiomeGroups() {
        return new BiomeGroup[]{
                WNBiomes.OCEAN,
                WNBiomes.COLD_OCEAN,
                WNBiomes.FROZEN_OCEAN,
                WNBiomes.LUKEWARM_OCEAN,
                WNBiomes.WARM_OCEAN
        };
    }
}