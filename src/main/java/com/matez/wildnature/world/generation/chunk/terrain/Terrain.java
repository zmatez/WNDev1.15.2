package com.matez.wildnature.world.generation.chunk.terrain;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.world.generation.biome.setup.BiomeGroup;
import com.matez.wildnature.world.generation.transformer.BiomeTransformer;

import java.util.ArrayList;

public abstract class Terrain {
    private final String name;
    private final Category terrainCategory;
    private final BiomeTransformer.TempCategory tempCategory;
    private final BiomeTransformer.WetCategory wetCategory;
    public float temparature;
    public float moisture;
    public BiomeGroup[] weightedBiomeGroups;

    public Terrain(String name, TerrainBuilder builder){
        this.name = name;
        this.terrainCategory = builder.getTerrainCategory();
        this.tempCategory = builder.getTempCategory();
        this.wetCategory = builder.getWetCategory();
    }

    public void init(){
        initWeightedBiomeGroups();
    }

    public String getName() {
        return name;
    }

    public Terrain.Category getTerrainCategory(){
        return terrainCategory;
    }

    public BiomeTransformer.TempCategory getTempCategory() {
        return tempCategory;
    }

    public BiomeTransformer.WetCategory getWetCategory() {
        return wetCategory;
    }

    public BiomeGroup[] getBiomeGroups(){
        return new BiomeGroup[0];
    }

    private void initWeightedBiomeGroups(){
        WN.LOGGER.debug("Init weighted biome groups");
        ArrayList<BiomeGroup> biomeGroups = new ArrayList<>();
        for (BiomeGroup biomeGroup : getBiomeGroups()) {
            for(int i = 0; i < biomeGroup.getWeight(); i++){
                biomeGroups.add(biomeGroup);
            }
        }
        weightedBiomeGroups = biomeGroups.toArray(new BiomeGroup[0]);
        WN.LOGGER.debug("Inited: " + weightedBiomeGroups.hashCode());
    }

    public BiomeGroup[] getWeightedBiomeGroups(){
        if(weightedBiomeGroups == null){
            WN.LOGGER.fatal("WeightedBiomeGroups is null!");
        }
        return weightedBiomeGroups;
    }

    public static class TerrainBuilder{
        private Category terrainCategory;
        private BiomeTransformer.TempCategory tempCategory;
        private BiomeTransformer.WetCategory wetCategory;

        public TerrainBuilder terrainCategory(Category terrainCategory){
            this.terrainCategory = terrainCategory;
            return this;
        }

        public TerrainBuilder tempCategory(BiomeTransformer.TempCategory tempCategory){
            this.tempCategory = tempCategory;
            return this;
        }

        public TerrainBuilder wetCategory(BiomeTransformer.WetCategory wetCategory){
            this.wetCategory = wetCategory;
            return this;
        }

        private BiomeTransformer.TempCategory getTempCategory() {
            return tempCategory;
        }

        private Category getTerrainCategory() {
            return terrainCategory;
        }

        private BiomeTransformer.WetCategory getWetCategory() {
            return wetCategory;
        }
    }

    public enum Category {
        DEEP_OCEAN("deep_ocean",0),
        OCEAN("ocean",1),
        SEA("sea",2),
        SHORE("shore",3),
        LOWLANDS("lowlands",4),
        MIDLANDS("midlands",5),
        HIGHLANDS("highlands",6),
        MOUNTAINS("mountains",7);

        private String name;
        private int index;
        Category(String name, int index){
            this.name = name;
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public int getIndex() {
            return index;
        }

        public static Category getByIndex(int index){
            for (Category value : values()) {
                if(value.getIndex() == index){
                    return value;
                }
            }
            return null;
        }
    }
}