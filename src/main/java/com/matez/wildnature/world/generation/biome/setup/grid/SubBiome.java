package com.matez.wildnature.world.generation.biome.setup.grid;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

public class SubBiome {
    private final Biome biome;
    private final int weight;
    private BiomeDictionary.Type[] addionalTypes;

    /**
     * @param biome specified biome
     * @param weight biome * weight later in weighted array (biome rarity)
     * @param addionalTypes biome dictionary types applied to BiomeGroup types (so biomegroup types + addionalTypes *only* for this biome)
     */
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
