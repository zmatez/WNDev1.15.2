package com.matez.wildnature.world.generation.chunk.terrain.terrains.oceans;

import com.matez.wildnature.world.generation.biome.setup.BiomeGroup;
import com.matez.wildnature.world.generation.biome.setup.SubBiome;
import com.matez.wildnature.world.generation.chunk.terrain.Terrain;
import com.matez.wildnature.world.generation.transformer.BiomeTransformer;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;

public class DeepOceanTerrain extends Terrain {
    public DeepOceanTerrain() {
        super("deep_ocean", new TerrainBuilder()
                .terrainCategory(Category.DEEP_OCEAN)
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
