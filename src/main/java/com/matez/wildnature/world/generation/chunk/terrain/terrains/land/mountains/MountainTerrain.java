package com.matez.wildnature.world.generation.chunk.terrain.terrains.land.mountains;

import com.matez.wildnature.world.generation.biome.setup.grid.BiomeGroup;
import com.matez.wildnature.world.generation.chunk.terrain.Terrain;
import net.minecraftforge.common.BiomeDictionary;

public class MountainTerrain extends Terrain {
    public MountainTerrain() {
        super("mountain", new TerrainBuilder()
                .terrainCategory(Category.MOUNTAINS)
        );
    }

    @Override
    public BiomeGroup[] getBiomeGroups() {
        return BiomeGroup.guess(Category.MOUNTAINS,new BiomeDictionary.Type[]{}, new BiomeDictionary.Type[]{});
    }
}
