package com.matez.wildnature.world.generation.chunk.terrain;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.world.generation.biome.setup.grid.BiomeGroup;
import com.matez.wildnature.world.generation.transformer.BiomeTransformer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public abstract class Terrain {
    private final String name;
    private final Category terrainCategory;
    private final BiomeTransformer.TempCategory tempCategory; //used nowhere
    private final BiomeTransformer.WetCategory wetCategory; //used nowhere
    public float temparature; //used nowhere
    public float moisture; //used nowhere
    public BiomeGroup[] weightedBiomeGroups;
    public LinkedHashMap<BiomeTransformer.TempCategory, LinkedHashMap<BiomeTransformer.WetCategory, List<BiomeGroup>>> climaticBiomeGroups = new LinkedHashMap<>();

    public Terrain(String name, TerrainBuilder builder){
        this.name = name;
        this.terrainCategory = builder.getTerrainCategory();
        this.tempCategory = builder.getTempCategory();
        this.wetCategory = builder.getWetCategory();
    }

    /**
     * Init of terrain
     */
    public void init(){
        initWeightedBiomeGroups();
        initClimaticBiomeGroups();
    }

    public String getName() {
        return name;
    }

    public Terrain.Category getTerrainCategory(){
        return terrainCategory;
    }

    @Deprecated
    public BiomeTransformer.TempCategory getTempCategory() {
        return tempCategory;
    }

    @Deprecated
    public BiomeTransformer.WetCategory getWetCategory() {
        return wetCategory;
    }

    /**
     * @return BiomeGroups for certain Terrain (base biome + all subbiomes)
     */
    public BiomeGroup[] getBiomeGroups(){
        return new BiomeGroup[0];
    }

    /**
     * Initializes biome groups - creates a weighted array (each entry * it's weight) and saves to weightedBiomeGroups
     */
    private void initWeightedBiomeGroups(){
        WN.LOGGER.debug("Init weighted biome groups");
        ArrayList<BiomeGroup> biomeGroups = new ArrayList<>();
        for (BiomeGroup biomeGroup : getBiomeGroups()) {
            for(int i = 0; i < biomeGroup.getWeight(); i++){
                biomeGroups.add(biomeGroup);
            }
        }
        weightedBiomeGroups = biomeGroups.toArray(new BiomeGroup[0]);
        WN.LOGGER.debug("Initialized terrain weighted biome groups: " + weightedBiomeGroups.hashCode());
    }

    private void initClimaticBiomeGroups(){
        WN.LOGGER.debug("Init climatic biome groups");
        for (BiomeTransformer.TempCategory tempValue : BiomeTransformer.TempCategory.values()) {
            LinkedHashMap<BiomeTransformer.WetCategory, List<BiomeGroup>> wetGroups = new LinkedHashMap<>();
            for (BiomeTransformer.WetCategory wetValue : BiomeTransformer.WetCategory.values()) {
                List<BiomeGroup> biomeGroups = BiomeTransformer.getBiomesByTemperatureAndMoisture(Arrays.asList(getWeightedBiomeGroups()),getTerrainCategory(),tempValue,wetValue);
                wetGroups.put(wetValue,biomeGroups);
            }
            climaticBiomeGroups.put(tempValue,wetGroups);
        }
        WN.LOGGER.debug("Initialized terrain weighted biome groups for category: " + getTerrainCategory().getName());
    }

    public List<BiomeGroup> getClimaticBiomeGroups(BiomeTransformer.TempCategory tempCategory, BiomeTransformer.WetCategory wetCategory){
        return climaticBiomeGroups.get(tempCategory).get(wetCategory);
    }

    /**
     * @return Biome groups (base biome + subbiomes), as a weighted array (see initWeightedBiomeGroups method)
     */
    public BiomeGroup[] getWeightedBiomeGroups(){
        if(weightedBiomeGroups == null){
            WN.LOGGER.fatal("WeightedBiomeGroups is null: " + terrainCategory + " " + getName());
        }
        return weightedBiomeGroups;
    }

    /**
     * TerrainBuilder - used for constructing each terrain class
     * note: tempCategory and wetCategory are deprecated atm, they do nothing
     */
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
        LOWLANDS("lowlands",3),
        MIDLANDS("midlands",4),
        HIGHLANDS("highlands",5),
        MOUNTAINS("mountains",6);

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