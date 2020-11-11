package com.matez.wildnature.world.generation.chunk.terrain.terrains.land.shores;

import com.matez.wildnature.world.generation.biome.setup.BiomeGroup;
import com.matez.wildnature.world.generation.chunk.terrain.Terrain;
import net.minecraftforge.common.BiomeDictionary;

public class ShoresTerrain extends Terrain {
    public ShoresTerrain() {
        super("shore", new TerrainBuilder()
                .terrainCategory(Category.SHORE)
        );
    }

    @Override
    public BiomeGroup[] getBiomeGroups() {
        return BiomeGroup.guess(Category.SHORE,new BiomeDictionary.Type[]{}, new BiomeDictionary.Type[]{});
    }
}
