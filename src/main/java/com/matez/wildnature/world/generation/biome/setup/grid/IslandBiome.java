package com.matez.wildnature.world.generation.biome.setup.grid;

import com.matez.wildnature.world.generation.biome.registry.WNBiomes;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import java.util.ArrayList;

public class IslandBiome {
    public static int RARITY_BIG = 4;
    public static int RARITY_SMALL = 2;
    private static ArrayList<IslandBiome> islandBiomes = new ArrayList<>();
    public static void register(BiomeGroup islandBiome, int weight, IslandType type, Biome[] oceans, BiomeDictionary.Type... types){
        islandBiomes.add(new IslandBiome(islandBiome,weight,type,oceans));
        WNBiomes.register(islandBiome,false,types);
    }

    public static void register(BiomeGroup islandBiome, int weight, Biome[] oceans, BiomeDictionary.Type... types){
        islandBiomes.add(new IslandBiome(islandBiome,weight,IslandType.BIG,oceans));
        islandBiomes.add(new IslandBiome(islandBiome,weight,IslandType.SMALL,oceans));
        WNBiomes.register(islandBiome,false,types);
    }

    public static ArrayList<IslandBiome> getIslandBiomes() {
        return islandBiomes;
    }

    private BiomeGroup islandBiome;
    private IslandType type;
    private Biome[] oceans;
    private int weight;
    private IslandBiome(BiomeGroup islandBiome, int weight, IslandType type, Biome... oceans){
        this.islandBiome = islandBiome;
        this.weight = weight;
        this.type = type;
        this.oceans = oceans;
    }

    public BiomeGroup getIslandBiome() {
        return islandBiome;
    }

    public Biome[] getOceans() {
        return oceans;
    }

    public IslandType getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    public enum IslandType{
        SMALL,
        BIG
    }
}
