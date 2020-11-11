package com.matez.wildnature.world.generation.chunk.terrain.terrains.land.midlands;

import com.matez.wildnature.world.generation.biome.setup.BiomeGroup;
import com.matez.wildnature.world.generation.chunk.terrain.Terrain;
import net.minecraftforge.common.BiomeDictionary;

public class MidlandTerrain extends Terrain {
    public MidlandTerrain() {
        super("midlands", new TerrainBuilder()
                .terrainCategory(Category.MIDLANDS)
        );
    }

    @Override
    public BiomeGroup[] getBiomeGroups() {
        return BiomeGroup.guess(Category.MIDLANDS,new BiomeDictionary.Type[]{}, new BiomeDictionary.Type[]{});
    }
}
