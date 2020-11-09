package com.matez.wildnature.world.generation.transformer;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.noise.NoiseUtil;
import com.matez.wildnature.util.other.Utilities;
import com.matez.wildnature.world.generation.chunk.terrain.Terrain;
import com.matez.wildnature.world.generation.grid.Cell;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.layer.Layer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class BiomeTransformer {
    public Biome apply(Biome oldBiome, Cell cell, Terrain terrain){
        return apply(oldBiome, TempCategory.getFromTemperature(-1,1,cell.temparature), WetCategory.getFromMoisture(-1,1,cell.moisture), cell, terrain, terrain.category, cell.biomeCellIdentity);
    }

    protected abstract Biome apply(Biome oldBiome, TempCategory tempCategory, WetCategory wetCategory, Cell cell, Terrain terrain, Terrain.Category category, float identity);

    public Biome get(List<Biome> filteredBiomes, float identity) {
        if(!filteredBiomes.isEmpty()) {
            Biome[] filtered = filteredBiomes.toArray(new Biome[0]);
            int index = NoiseUtil.round(identity * (filtered.length - 1));
            return filtered[index];
        }else{
            WN.LOGGER.warn("BiomeTransformer returned empty array. That shouldn't happen!");
        }
        return Biomes.OCEAN;
    }

    public static enum TempCategory {
        ICY("icy"),
        COLD("cold"),
        TEMPERATE("temperate"),
        WARM("warm"),
        HOT("hot");

        private static final Map<String, TempCategory> BY_NAME = Arrays.stream(values()).collect(Collectors.toMap(TempCategory::getName, (p_222356_0_) -> {
            return p_222356_0_;
        }));

        private final String name;

        private TempCategory(String nameIn) {
            this.name = nameIn;
        }

        public String getName() {
            return this.name;
        }

        public static TempCategory getFromTemperature(float min, float max, float temperature){
            float scaled = Utilities.scaleBetween(temperature,-1,1,min,max);
            if(scaled < -1){
                scaled = -1;
            }else if(scaled > 1){
                scaled = 1;
            }
            if(scaled >= -1 && scaled < -0.6){
                return ICY;
            }else if(scaled >= -0.6  && scaled < -0.2){
                return COLD;
            }else if(scaled >= -0.2  && scaled <= 0.2){
                return TEMPERATE;
            }else if(scaled > 0.2  && scaled <= 0.6){
                return WARM;
            }else if(scaled > 0.6  && scaled <= 1){
                return HOT;
            }
            return TEMPERATE;
        }
    }

    public static enum WetCategory {
        WET("wet"),
        TEMPERATE("temperate"),
        DRY("dry");

        private static final Map<String, WetCategory> BY_NAME = Arrays.stream(values()).collect(Collectors.toMap(WetCategory::getName, (p_222356_0_) -> {
            return p_222356_0_;
        }));

        private final String name;

        private WetCategory(String nameIn) {
            this.name = nameIn;
        }

        public String getName() {
            return this.name;
        }

        public static WetCategory getFromMoisture(float min, float max, float moisture){
            float scaled = Utilities.scaleBetween(moisture,-1,1,min,max);
            if(scaled < -1){
                scaled = -1;
            }else if(scaled > 1){
                scaled = 1;
            }
            if(scaled >= -1 && scaled < -0.35){
                return WET;
            }else if(scaled >= -0.35  && scaled <= 0.35){
                return TEMPERATE;
            }else if(scaled > 0.35 && scaled <= 1){
                return DRY;
            }
            return TEMPERATE;
        }
    }

    /**
     * Gets a valid biome list by a temp category
     * @param filter biomes to be filtered
     * @param category temperature
     * @return filtered biomes from @param filter
     */
    public static List<Biome> getBiomesByTemperature(List<Biome> filter, TempCategory category){
        List<Biome> biomes = new ArrayList<>();
        for (Biome biome : filter) {
            TempCategory biomeCategory = TempCategory.getFromTemperature(-0.1f,1,biome.getDefaultTemperature());
            if(biomeCategory == category){
                biomes.add(biome);
            }
        }
        return biomes;
    }

    /**
     * Gets a valid biome list by a temp category
     * @param filter biomes to be filtered
     * @param category moisture
     * @return filtered biomes from @param filter
     */
    public static List<Biome> getBiomesByMoisture(List<Biome> filter, WetCategory category){
        List<Biome> biomes = new ArrayList<>();
        for (Biome biome : filter) {
            WetCategory biomeCategory = WetCategory.getFromMoisture(0,1,biome.getDownfall());
            if(biomeCategory == category){
                biomes.add(biome);
            }
        }
        return biomes;
    }

    /**
     * Gets a valid biome list by a temp category
     * @param filter biomes to be filtered
     * @param tempCategory temperature
     * @param wetCategory moisture
     * @return filtered biomes from @param filter
     */
    public static List<Biome> getBiomesByTemperatureAndMoisture(List<Biome> filter, TempCategory tempCategory, WetCategory wetCategory){
        List<Biome> biomesTemp = getBiomesByTemperature(filter,tempCategory);
        List<Biome> biomesMoist = getBiomesByMoisture(filter,wetCategory);
        List<Biome> biomes = new ArrayList<>();
        for (Biome biome1 : biomesTemp) {
            for (Biome biome2 : biomesMoist) {
                if(biome1 == biome2){
                    if(!biomes.contains(biome1)){
                        biomes.add(biome1);
                    }
                }
            }
        }

        return biomes;
    }
}
