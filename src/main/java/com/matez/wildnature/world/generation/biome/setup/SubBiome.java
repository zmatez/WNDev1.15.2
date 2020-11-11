package com.matez.wildnature.world.generation.biome.setup;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

public class SubBiome {
    private final Biome biome;
    private final int weight;
    private BiomeDictionary.Type[] addionalTypes;

    public SubBiome(Biome biome, int weight, BiomeDictionary.Type... addionalTypes){
        this.biome = biome;
        this.weight = weight;
        this.addionalTypes = addionalTypes;
    }

    public Biome getBiome() {
        return biome;
    }

    public int getWeight() {
        return weight;
    }

    public BiomeDictionary.Type[] getAddionalTypes() {
        return addionalTypes;
    }
}
