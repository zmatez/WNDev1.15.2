package com.matez.wildnature.world.generation.transformer.transformers;

import com.matez.wildnature.world.generation.biome.registry.WNBiomes;
import com.matez.wildnature.world.generation.biome.setup.grid.BiomeGroup;
import com.matez.wildnature.world.generation.biome.setup.grid.SubBiome;
import com.matez.wildnature.world.generation.chunk.terrain.Terrain;
import com.matez.wildnature.world.generation.grid.Cell;
import com.matez.wildnature.world.generation.heightmap.modules.RiverGenerator;
import com.matez.wildnature.world.generation.transformer.BiomeTransformer;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.common.BiomeDictionary;

public class RiverTransformer extends BiomeTransformer {

    public static BiomeGroup rivers = BiomeGroup.SingleBuilder.configure("river", WNBiomes.River);

    @Override
    protected BiomeGroup bgApply(BiomeGroup oldBiomeGroup, TempCategory tempCategory, WetCategory wetCategory, Cell cell, Terrain terrain, Terrain.Category category, float identity) {
        if(category != Terrain.Category.OCEAN && category != Terrain.Category.DEEP_OCEAN && category != Terrain.Category.SEA){
            if (RiverGenerator.isRiver(cell)) {
                return rivers;
            }
        }
        return oldBiomeGroup;
    }
}
