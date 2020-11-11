package com.matez.wildnature.world.generation.chunk.terrain.terrains.seas;

import com.matez.wildnature.world.generation.biome.setup.BiomeGroup;
import com.matez.wildnature.world.generation.chunk.terrain.Terrain;
import net.minecraft.world.biome.Biomes;

public class SeaTerrain extends Terrain {
    public SeaTerrain() {
        super("sea", new TerrainBuilder()
                .terrainCategory(Category.SEA)
        );
    }

    @Override
    public BiomeGroup[] getBiomeGroups() {
        return new BiomeGroup.Builder()
                .add(Biomes.LUKEWARM_OCEAN)/*temporary biome*/
                .build();
    }
}
