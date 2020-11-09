package com.matez.wildnature.world.generation.layer.cell;

import com.matez.wildnature.world.generation.heightmap.modules.ContinentGenerator;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IAreaTransformer0;
import net.minecraftforge.common.BiomeManager;

public class WNContinentLayer implements IAreaTransformer0 {
    public int apply(INoiseRandom random, int x, int z) {
        float continentValue = new ContinentGenerator(1000L).generateContinent(x*4, z*4);

        if (continentValue > 0.99) {
            return 133; //RED
        }
        else if (continentValue > 0.90) {
            return 3; //Mountain
        }
        if (continentValue > 0.80) {
            return 35; //HighLands
        }
        else if (continentValue > 0.55){
            return 1; //MidLands
        }
        else if (continentValue > 0.3){
            return 134; //LowLands
        }
        else if (continentValue > 0.24){
            return 26; //beach
        }
        else if (continentValue > 0.16){
            return 0; //Sea
        }
        else if (continentValue > 0.1){
            return 44; //Ocean
        }else {
            return 46; //Deep Ocean
        }
    }

}
