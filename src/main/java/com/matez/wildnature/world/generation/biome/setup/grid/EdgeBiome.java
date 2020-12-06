package com.matez.wildnature.world.generation.biome.setup.grid;

import java.util.ArrayList;

public class EdgeBiome {
    private static final ArrayList<EdgeBiome> edgeBiomes = new ArrayList<>();
    public static void register(BiomeGroup edge, BiomeGroup... matchingBiomes){
        edgeBiomes.add(new EdgeBiome(edge, matchingBiomes));
        if(matchingBiomes.length == 0){
            throw new NullPointerException("Biome groups in EdgeBiome can't be empty");
        }
    }

    public static ArrayList<EdgeBiome> getEdgeBiomes() {
        return edgeBiomes;
    }

    private BiomeGroup edge;
    private BiomeGroup[] matchingBiomes;
    private EdgeBiome(BiomeGroup edge, BiomeGroup... matchingBiomes){
        this.edge = edge;
        this.matchingBiomes = matchingBiomes;
    }

    public BiomeGroup getEdge() {
        return edge;
    }

    public BiomeGroup[] getMatchingBiomes() {
        return matchingBiomes;
    }
}
