package com.matez.wildnature.world.generation.terrain.terrains.land.midlands;

import com.matez.wildnature.world.generation.biome.setup.grid.BiomeGroup;
import com.matez.wildnature.world.generation.terrain.Terrain;
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
