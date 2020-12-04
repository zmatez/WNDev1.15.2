package com.matez.wildnature.world.generation.terrain.terrains.land.lowlands;

import com.matez.wildnature.world.generation.biome.setup.grid.BiomeGroup;
import com.matez.wildnature.world.generation.terrain.Terrain;
import net.minecraftforge.common.BiomeDictionary;

public class LowlandTerrain extends Terrain {
    public LowlandTerrain() {
        super("lowland", new TerrainBuilder()
                .terrainCategory(Category.LOWLANDS)
        );
    }

    @Override
    public BiomeGroup[] getBiomeGroups() {
        return BiomeGroup.guess(Category.LOWLANDS,new BiomeDictionary.Type[]{}, new BiomeDictionary.Type[]{}, true);
    }
}
