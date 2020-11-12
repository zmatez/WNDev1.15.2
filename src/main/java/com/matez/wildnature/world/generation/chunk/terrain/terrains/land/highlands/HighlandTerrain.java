package com.matez.wildnature.world.generation.chunk.terrain.terrains.land.highlands;

import com.matez.wildnature.world.generation.biome.setup.grid.BiomeGroup;
import com.matez.wildnature.world.generation.chunk.terrain.Terrain;
import net.minecraftforge.common.BiomeDictionary;

public class HighlandTerrain extends Terrain {
    public HighlandTerrain() {
        super("highland", new TerrainBuilder()
                .terrainCategory(Category.HIGHLANDS)
        );
    }

    @Override
    public BiomeGroup[] getBiomeGroups() {
        return BiomeGroup.guess(Category.HIGHLANDS,new BiomeDictionary.Type[]{}, new BiomeDictionary.Type[]{});
    }
}
