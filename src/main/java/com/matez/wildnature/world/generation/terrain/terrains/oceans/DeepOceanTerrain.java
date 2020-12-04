package com.matez.wildnature.world.generation.terrain.terrains.oceans;

import com.matez.wildnature.world.generation.biome.registry.WNBiomes;
import com.matez.wildnature.world.generation.biome.setup.grid.BiomeGroup;
import com.matez.wildnature.world.generation.terrain.Terrain;

public class DeepOceanTerrain extends Terrain {
    public DeepOceanTerrain() {
        super("deep_ocean", new TerrainBuilder()
                .terrainCategory(Category.DEEP_OCEAN)
        );
    }

    @Override
    public BiomeGroup[] getBiomeGroups() {
        return new BiomeGroup[]{
                WNBiomes.DEEP_OCEAN,
                WNBiomes.DEEP_COLD_OCEAN,
                WNBiomes.DEEP_FROZEN_OCEAN,
                WNBiomes.DEEP_LUKEWARM_OCEAN,
                WNBiomes.DEEP_WARM_OCEAN
        };
    }
}
