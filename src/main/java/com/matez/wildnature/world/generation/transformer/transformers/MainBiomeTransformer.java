package com.matez.wildnature.world.generation.transformer.transformers;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.world.generation.biome.registry.WNBiomes;
import com.matez.wildnature.world.generation.biome.setup.grid.BiomeGroup;
import com.matez.wildnature.world.generation.grid.Cell;
import com.matez.wildnature.world.generation.transformer.BiomeTransformer;
import net.minecraftforge.common.BiomeDictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class MainBiomeTransformer extends BiomeTransformer {
    protected LinkedHashMap<TerrainCategory, BiomeGroup[]> weightedBiomeGroups = new LinkedHashMap<>();
    protected LinkedHashMap<TerrainCategory, LinkedHashMap<BiomeTransformer.TempCategory, LinkedHashMap<WetCategory, List<BiomeGroup>>>> climaticBiomeGroups = new LinkedHashMap<>();
    public MainBiomeTransformer(){
        initWeightedBiomeGroups();
        initClimaticBiomeGroups();
    }

    /**
     * Initializes biome groups - creates a weighted array (each entry * it's weight) and saves to weightedBiomeGroups
     */
    private void initWeightedBiomeGroups(){
        WN.LOGGER.debug("Init weighted biome groups");
        for (TerrainCategory value : TerrainCategory.values()) {
            ArrayList<BiomeGroup> biomeGroups = new ArrayList<>();
            for (BiomeGroup biomeGroup : getBiomeGroups(value)) {
                for(int i = 0; i < biomeGroup.getWeight(); i++){
                    biomeGroups.add(biomeGroup);
                }
            }
            WN.LOGGER.debug("--- " + value.getName() + " - " + biomeGroups.size() + " entries.");
            weightedBiomeGroups.put(value,biomeGroups.toArray(new BiomeGroup[0]));
        }

        WN.LOGGER.debug("Initialized terrain weighted biome groups: " + weightedBiomeGroups.hashCode());
    }

    private BiomeGroup[] getBiomeGroups(TerrainCategory category){
        if(category == TerrainCategory.DEEP_OCEAN){
            return new BiomeGroup[]{
                    WNBiomes.DEEP_OCEAN,
                    WNBiomes.DEEP_COLD_OCEAN,
                    WNBiomes.DEEP_FROZEN_OCEAN,
                    WNBiomes.DEEP_LUKEWARM_OCEAN,
                    WNBiomes.DEEP_WARM_OCEAN
            };
        }else if(category == TerrainCategory.OCEAN){
            return new BiomeGroup[]{
                    WNBiomes.OCEAN,
                    WNBiomes.COLD_OCEAN,
                    WNBiomes.FROZEN_OCEAN,
                    WNBiomes.LUKEWARM_OCEAN,
                    WNBiomes.WARM_OCEAN
            };
        }else{
            return BiomeGroup.guess(category,new BiomeDictionary.Type[]{}, new BiomeDictionary.Type[]{}, false);
        }
    }

    /**
     * Initializes climatic array from weighted array. This is used to get final biome in MainBiomeTransformer based on temperature and moisture. See method getClimaticBiomeGroups
     */
    private void initClimaticBiomeGroups(){
        WN.LOGGER.debug("Init climatic biome groups... ");
        for (TerrainCategory value : TerrainCategory.values()) {
            WN.LOGGER.debug("--- initializing " + value.getName());
            LinkedHashMap<TempCategory, LinkedHashMap<BiomeTransformer.WetCategory, List<BiomeGroup>>> tempGroups = new LinkedHashMap<>();
            for (BiomeTransformer.TempCategory tempValue : BiomeTransformer.TempCategory.values()) {
                LinkedHashMap<BiomeTransformer.WetCategory, List<BiomeGroup>> wetGroups = new LinkedHashMap<>();
                for (BiomeTransformer.WetCategory wetValue : BiomeTransformer.WetCategory.values()) {
                    List<BiomeGroup> biomeGroups = BiomeTransformer.getBiomesByTemperatureAndMoisture(Arrays.asList(weightedBiomeGroups.get(value)),value,tempValue,wetValue);
                    wetGroups.put(wetValue,biomeGroups);
                    WN.LOGGER.debug("----- adding " + biomeGroups.size() + " biomes with temp " + tempValue.getName() + " and moist " + wetValue.getName());
                }
                tempGroups.put(tempValue,wetGroups);
            }
            climaticBiomeGroups.put(value,tempGroups);
        }
        WN.LOGGER.debug("Initialized terrain weighted biome groups");
    }

    public List<BiomeGroup> getClimaticBiomeGroups(TerrainCategory category, BiomeTransformer.TempCategory tempCategory, BiomeTransformer.WetCategory wetCategory){
        return climaticBiomeGroups.get(category).get(tempCategory).get(wetCategory);
    }

    public enum TerrainCategory {
        DEEP_OCEAN("deep_ocean",0),
        OCEAN("ocean",1),
        LOWLANDS("lowlands",2),
        MIDLANDS("midlands",3),
        HIGHLANDS("highlands",4);

        private String name;
        private int index;
        TerrainCategory(String name, int index){
            this.name = name;
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public int getIndex() {
            return index;
        }

        public static TerrainCategory getByIndex(int index){
            for (TerrainCategory value : values()) {
                if(value.getIndex() == index){
                    return value;
                }
            }
            return null;
        }
    }


    @Override
    protected BiomeGroup bgApply(TempCategory tempCategory, WetCategory wetCategory, Cell cell, TerrainCategory category, float identity) {
        return getBiomeGroup(getClimaticBiomeGroups(category,tempCategory,wetCategory), identity);
    }
}
