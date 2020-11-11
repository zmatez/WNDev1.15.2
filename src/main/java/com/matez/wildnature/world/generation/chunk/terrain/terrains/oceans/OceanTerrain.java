package com.matez.wildnature.world.generation.chunk.terrain.terrains.oceans;

import com.matez.wildnature.world.generation.biome.setup.BiomeGroup;
import com.matez.wildnature.world.generation.chunk.terrain.Terrain;
import com.matez.wildnature.world.generation.transformer.BiomeTransformer;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;

public class OceanTerrain extends Terrain {
    public OceanTerrain() {
        super("ocean", new TerrainBuilder()
                .terrainCategory(Category.OCEAN)
        );
    }

    @Override
    public BiomeGroup[] getBiomeGroups() {
        return new BiomeGroup.Builder()
                .add(Biomes.OCEAN)
                .add(Biomes.COLD_OCEAN)
                .add(Biomes.FROZEN_OCEAN)
                .add(Biomes.LUKEWARM_OCEAN)
                .add(Biomes.WARM_OCEAN)
                .build();
    }
}
