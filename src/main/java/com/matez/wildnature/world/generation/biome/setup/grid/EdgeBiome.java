package com.matez.wildnature.world.generation.biome.setup.grid;

import net.minecraft.world.biome.Biome;

import java.util.ArrayList;

public class EdgeBiome {
    private static ArrayList<EdgeBiome> edgeBiomes = new ArrayList<>();
    public static void register(Biome edge, BiomeGroup... matchingBiomes){
        edgeBiomes.add(new EdgeBiome(edge, matchingBiomes));
    }

    public static ArrayList<EdgeBiome> getEdgeBiomes() {
        return edgeBiomes;
    }

    private Biome edge;
    private BiomeGroup[] matchingBiomes;
    private EdgeBiome(Biome edge, BiomeGroup... matchingBiomes){
        this.edge = edge;
        this.matchingBiomes = matchingBiomes;
    }

    public Biome getEdge() {
        return edge;
    }

    public BiomeGroup[] getMatchingBiomes() {
        return matchingBiomes;
    }
}
