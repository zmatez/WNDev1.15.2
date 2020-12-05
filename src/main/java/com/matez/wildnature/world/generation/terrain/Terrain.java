/*
 *
 * MIT License
 *
 * Copyright (c) 2020 TerraForged
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.matez.wildnature.world.generation.terrain;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.world.generation.biome.setup.grid.BiomeGroup;
import com.matez.wildnature.world.generation.noise.fastNoise.FastNoise;
import com.matez.wildnature.world.generation.transformer.BiomeTransformer;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public abstract class Terrain {
    private final String name;
    private final Category terrainCategory;
    protected BiomeGroup[] weightedBiomeGroups;
    protected LinkedHashMap<BiomeTransformer.TempCategory, LinkedHashMap<BiomeTransformer.WetCategory, List<BiomeGroup>>> climaticBiomeGroups = new LinkedHashMap<>();
    //protected GeoConfig geoConfig;
    //protected GeoManager geoManager;

    public Terrain(String name, TerrainBuilder builder){
        this.name = name;
        this.terrainCategory = builder.getTerrainCategory();
    }

    /**
     * Init of terrain
     */
    public void init(long seed){
        initWeightedBiomeGroups();
        initClimaticBiomeGroups();
        //initGeology(seed);
    }

    public String getName() {
        return name;
    }

    public Terrain.Category getTerrainCategory(){
        return terrainCategory;
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
        WN.LOGGER.debug("Init weighted biome groups for terrain: " + getName());
        ArrayList<BiomeGroup> biomeGroups = new ArrayList<>();
        for (BiomeGroup biomeGroup : getBiomeGroups()) {
            for(int i = 0; i < biomeGroup.getWeight(); i++){
                biomeGroups.add(biomeGroup);
            }
        }
        weightedBiomeGroups = biomeGroups.toArray(new BiomeGroup[0]);
        WN.LOGGER.debug("Initialized terrain weighted biome groups: " + weightedBiomeGroups.hashCode());
    }

    /**
     * Initializes climatic array from weighted array. This is used to get final biome in MainBiomeTransformer based on temperature and moisture. See method getClimaticBiomeGroups
     */
    private void initClimaticBiomeGroups(){
        WN.LOGGER.debug("Init climatic biome groups for terrain: " + getName());
        for (BiomeTransformer.TempCategory tempValue : BiomeTransformer.TempCategory.values()) {
            LinkedHashMap<BiomeTransformer.WetCategory, List<BiomeGroup>> wetGroups = new LinkedHashMap<>();
            for (BiomeTransformer.WetCategory wetValue : BiomeTransformer.WetCategory.values()) {
                List<BiomeGroup> biomeGroups = BiomeTransformer.getBiomesByTemperatureAndMoisture(Arrays.asList(getWeightedBiomeGroups()),getTerrainCategory(),tempValue,wetValue);
                wetGroups.put(wetValue,biomeGroups);
            }
            climaticBiomeGroups.put(tempValue,wetGroups);
        }
        WN.LOGGER.debug("Initialized terrain weighted biome groups for terrain: " + getName());
    }

    /*private void initGeology(long seed){
        WN.LOGGER.debug("Init geology for terrain: " + getName());
        geoManager = new GeoManager(seed, getGeoConfig(seed));
        WN.LOGGER.debug("Initialized geology for terrain: " + getName());
    }

    private GeoConfig getGeoConfig(long seed){
        List<Block> sedimentary = Arrays.asList(
                WNBlocks.LIMESTONE,
                WNBlocks.MARBLE,
                WNBlocks.GNEISS,
                Blocks.STONE,
                Blocks.STONE,
                Blocks.STONE,
                Blocks.STONE,
                Blocks.DIORITE
        );

        List<Block> carbonate = Arrays.asList(
                WNBlocks.BASALT,
                Blocks.DIORITE,
                Blocks.GRANITE,
                Blocks.STONE,
                Blocks.STONE,
                Blocks.STONE,
                Blocks.STONE,
                WNBlocks.GNEISS
        );

        FastNoise selectorNoise = new FastNoise((int)seed);

        return new GeoConfig(
                GeoConfig.Type.RANDOM, selectorNoise,
                sedimentary, 5, 4, 4,
                carbonate, 33, 8, 30
        );
    }

    public GeoConfig getGeoConfig() {
        return geoConfig;
    }

    public GeoManager getGeoManager() {
        return geoManager;
    }*/

    public List<BiomeGroup> getClimaticBiomeGroups(BiomeTransformer.TempCategory tempCategory, BiomeTransformer.WetCategory wetCategory){
        return climaticBiomeGroups.get(tempCategory).get(wetCategory);
    }

    public LinkedHashMap<BiomeTransformer.TempCategory, LinkedHashMap<BiomeTransformer.WetCategory, List<BiomeGroup>>> getClimaticBiomeGroups(){
        return climaticBiomeGroups;
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

    protected void unload(){
        this.weightedBiomeGroups = null;
        this.climaticBiomeGroups = null;
    }

    /**
     * TerrainBuilder - used for constructing each terrain class
     * note: tempCategory and wetCategory are deprecated atm, they do nothing
     */
    public static class TerrainBuilder{
        private Category terrainCategory;

        public TerrainBuilder terrainCategory(Category terrainCategory){
            this.terrainCategory = terrainCategory;
            return this;
        }

        private Category getTerrainCategory() {
            return terrainCategory;
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