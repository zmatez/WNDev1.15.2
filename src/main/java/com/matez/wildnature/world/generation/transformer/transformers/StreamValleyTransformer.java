package com.matez.wildnature.world.generation.transformer.transformers;

import com.matez.wildnature.world.generation.biome.registry.WNBiomes;
import com.matez.wildnature.world.generation.biome.setup.grid.BiomeGroup;
import com.matez.wildnature.world.generation.biome.setup.grid.SubBiome;
import com.matez.wildnature.world.generation.grid.Cell;
import com.matez.wildnature.world.generation.heightmap.modules.RiverGenerator;
import com.matez.wildnature.world.generation.layer.grid.GridBiomeLayer;
import com.matez.wildnature.world.generation.transformer.BiomeTransformer;
import net.minecraft.world.biome.Biome;

public class StreamValleyTransformer extends BiomeTransformer {

    @Override
    protected Biome apply(Biome oldBiome, TempCategory tempCategory, WetCategory wetCategory, Cell cell, MainBiomeTransformer.TerrainCategory category, float identity) {
        if(!isOcean(oldBiome)){

        }
        return oldBiome;
    }

    private boolean isOcean(Biome oldBiome){
        for (BiomeGroup ocean : GridBiomeLayer.OCEANS) {
            if(ocean.getBaseBiome() == oldBiome){
                return true;
            }else{
                for (SubBiome subBiome : ocean.getSubBiomes()) {
                    if(subBiome.getBiome() == oldBiome){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
