package com.matez.wildnature.world.generation.transformer;

import com.google.common.collect.ArrayListMultimap;
import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.noise.NoiseUtil;
import com.matez.wildnature.util.other.Utilities;
import com.matez.wildnature.world.generation.biome.registry.WNBiomes;
import com.matez.wildnature.world.generation.biome.setup.grid.BiomeGroup;
import com.matez.wildnature.world.generation.grid.Cell;
import com.matez.wildnature.world.generation.transformer.transformers.MainBiomeTransformer;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class BiomeTransformer {
    /**
     * Gets BiomeGroup from BiomeMap (biomeCellIdentity)
     *
     * @return biome group
     */
    public BiomeGroup bgApply(Cell cell) {
        return bgApply(TempCategory.getFromTemperature(-1, 1, cell.cellTemparature), WetCategory.getFromMoisture(-1, 1, cell.cellMoisture), cell, getCategoryFromContinent(cell.cellContinent), cell.biomeCellIdentity);
    }
    protected BiomeGroup bgApply(TempCategory tempCategory, WetCategory wetCategory, Cell cell, MainBiomeTransformer.TerrainCategory category, float identity) {
        return null;
    }

    /**
     * Replaces biomeGroup to another if needs to (used for islands)
     *
     * @return biome group
     */
    public BiomeGroup bgApply(BiomeGroup oldBiomeGroup, Cell cell) {
        return bgApply(oldBiomeGroup, TempCategory.getFromTemperature(-0.1f, 1, oldBiomeGroup.getBaseBiome().getDefaultTemperature()), WetCategory.getFromMoisture(0, 1, oldBiomeGroup.getBaseBiome().getDownfall()), cell, getCategoryFromContinent(cell.continentValue), cell.subBiomeCellIdentity);
    }
    protected BiomeGroup bgApply(BiomeGroup oldBiomeGroup, TempCategory tempCategory, WetCategory wetCategory, Cell cell, MainBiomeTransformer.TerrainCategory category, float identity) {
        return oldBiomeGroup;
    }

    /**
     * For lake biomes
     */
    public BiomeGroup bgApply(int x, int z, BiomeGroup oldBiomeGroup, Cell cell) {
        return bgApply(x,z,oldBiomeGroup, TempCategory.getFromTemperature(-0.1f, 1, oldBiomeGroup.getBaseBiome().getDefaultTemperature()), WetCategory.getFromMoisture(0, 1, oldBiomeGroup.getBaseBiome().getDownfall()), cell, getCategoryFromContinent(cell.continentValue), cell.subBiomeCellIdentity);
    }
    protected BiomeGroup bgApply(int x, int z, BiomeGroup oldBiomeGroup, TempCategory tempCategory, WetCategory wetCategory, Cell cell, MainBiomeTransformer.TerrainCategory category, float identity) {
        return oldBiomeGroup;
    }

    /**
     * Gets Biome from weighted biome list from BiomeGroup (baseBiome * 10, subBiome * subBiome weight). Uses SubBiomeMap
     *
     * @return Biome
     */
    public Biome apply(BiomeGroup oldBiomeGroup, Cell cell) {
        return apply(oldBiomeGroup, TempCategory.getFromTemperature(-0.1f, 1, oldBiomeGroup.getBaseBiome().getDefaultTemperature()), WetCategory.getFromMoisture(0, 1, oldBiomeGroup.getBaseBiome().getDownfall()), cell, getCategoryFromContinent(cell.continentValue), cell.subBiomeCellIdentity);
    }
    protected Biome apply(BiomeGroup oldBiomeGroup, TempCategory tempCategory, WetCategory wetCategory, Cell cell, MainBiomeTransformer.TerrainCategory category, float identity) {
        return oldBiomeGroup.getBaseBiome();
    }

    /**
     * Used for edge biomes, shores etc
     *
     * @return
     */
    public BiomeGroup apply(BiomeGroup oldBiomeGroup, BiomeGroup northBiomeGroup, BiomeGroup southBiomeGroup, BiomeGroup eastBiomeGroup, BiomeGroup westBiomeGroup, Cell cell) {
        return apply(oldBiomeGroup, northBiomeGroup, southBiomeGroup, eastBiomeGroup, westBiomeGroup, TempCategory.getFromTemperature(-0.1f, 1, oldBiomeGroup.getBaseBiome().getDefaultTemperature()), WetCategory.getFromMoisture(0, 1, oldBiomeGroup.getBaseBiome().getDownfall()), cell, getCategoryFromContinent(cell.continentValue), cell.subBiomeCellIdentity);
    }
    protected BiomeGroup apply(BiomeGroup oldBiomeGroup, BiomeGroup northBiomeGroup, BiomeGroup southBiomeGroup, BiomeGroup eastBiomeGroup, BiomeGroup westBiomeGroup, TempCategory tempCategory, WetCategory wetCategory, Cell cell, MainBiomeTransformer.TerrainCategory category, float identity) {
        return oldBiomeGroup;
    }

    /**
     * Used for shores
     *
     * @return
     */
    public Biome apply(Biome oldCenterBiome, Biome oldNorthBiome, Biome oldSouthBiome, Biome oldEastBiome, Biome oldWestBiome, Cell cell) {
        return apply(oldCenterBiome, oldNorthBiome, oldSouthBiome, oldEastBiome, oldWestBiome, TempCategory.getFromTemperature(-0.1f, 1, oldCenterBiome.getDefaultTemperature()), WetCategory.getFromMoisture(0, 1, oldCenterBiome.getDownfall()), cell, getCategoryFromContinent(cell.continentValue), cell.subBiomeCellIdentity);
    }
    protected Biome apply(Biome oldCenterBiome, Biome oldNorthBiome, Biome oldSouthBiome, Biome oldEastBiome, Biome oldWestBiome, TempCategory tempCategory, WetCategory wetCategory, Cell cell, MainBiomeTransformer.TerrainCategory category, float identity) {
        return oldCenterBiome;
    }


    public static MainBiomeTransformer.TerrainCategory getCategoryFromContinent(float cellContinent){
        if (cellContinent >= 0.75F) {
            return MainBiomeTransformer.TerrainCategory.HIGHLANDS;
        } else if (cellContinent >= 0.4F && cellContinent < 0.75F) {
            return MainBiomeTransformer.TerrainCategory.MIDLANDS;
        } else if (cellContinent >= 0.1F && cellContinent < 0.4F) {
            return MainBiomeTransformer.TerrainCategory.LOWLANDS;
        } else if(cellContinent >= 0.05F && cellContinent < 0.1F){
            return MainBiomeTransformer.TerrainCategory.OCEAN;
        }else{
            return MainBiomeTransformer.TerrainCategory.DEEP_OCEAN;
        }
    }

    /**
     * Gets biome from specified identity (mostly SubBiomeIdentity)
     */
    public Biome getBiome(List<Biome> filteredBiomes, float identity) {
        if (!filteredBiomes.isEmpty()) {
            Biome[] filtered = filteredBiomes.toArray(new Biome[0]);
            int index = NoiseUtil.round(identity * (filtered.length - 1));
            return filtered[index];
        } else {
            WN.LOGGER.warn("BiomeTransformer returned empty array. That shouldn't happen!");
        }
        return Biomes.OCEAN;
    }

    /**
     * Gets biome group from specified identity (mostly BiomeIdentity)
     */
    public BiomeGroup getBiomeGroup(List<BiomeGroup> filteredBiomes, float identity) {
        if (!filteredBiomes.isEmpty()) {
            BiomeGroup[] filtered = filteredBiomes.toArray(new BiomeGroup[0]);
            int index = NoiseUtil.round(identity * (filtered.length - 1));
            return filtered[index];
        } else {
            WN.LOGGER.warn("BiomeTransformer returned empty array. That shouldn't happen!");
        }
        return null;
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

        public static TempCategory getFromTemperature(float min, float max, float temperature) {
            float scaled = Utilities.scaleBetween(temperature, -1, 1, min, max);
            if (scaled < -1) {
                scaled = -1;
            } else if (scaled > 1) {
                scaled = 1;
            }
            if (scaled >= -1 && scaled < -0.6) {
                return ICY;
            } else if (scaled >= -0.6 && scaled < -0.2) {
                return COLD;
            } else if (scaled >= -0.2 && scaled <= 0.2) {
                return TEMPERATE;
            } else if (scaled > 0.2 && scaled <= 0.6) {
                return WARM;
            } else if (scaled > 0.6) {
                return HOT;
            }
            return TEMPERATE;
        }
    }

    public static enum WetCategory {
        DRY("dry"),
        TEMPERATE("temperate"),
        WET("wet");

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

        public static WetCategory getFromMoisture(float min, float max, float moisture) {
            float scaled = Utilities.scaleBetween(moisture, -1, 1, min, max);
            if (scaled < -1) {
                scaled = -1;
            } else if (scaled > 1) {
                scaled = 1;
            }
            if (scaled >= -1 && scaled < -0.35) {
                return DRY;
            } else if (scaled >= -0.35 && scaled <= 0.35) {
                return TEMPERATE;
            } else if (scaled > 0.35 && scaled <= 1) {
                return WET;
            }
            return TEMPERATE;
        }
    }

    /**
     * Gets a valid biome list by a temp category
     *
     * @param filter   biomes to be filtered
     * @param category temperature
     * @return filtered biomes from @param filter
     */
    public static ArrayListMultimap<Integer, BiomeGroup> getBiomesByTemperature(List<BiomeGroup> filter, TempCategory category) {
        ArrayListMultimap<Integer, BiomeGroup> multimap = ArrayListMultimap.create();
        for (BiomeGroup biomeGroup : filter) {
            TempCategory biomeCategory = TempCategory.getFromTemperature(-0.1f, 1f, biomeGroup.getBaseBiome().getDownfall());
            int distance = Math.abs(Math.min(category.ordinal(),biomeCategory.ordinal()) - Math.max(category.ordinal(),biomeCategory.ordinal()));
            multimap.put(distance,biomeGroup);
        }


        return multimap;
    }

    /**
     * Gets a valid biome list by a wet category
     *
     * @param filter   biomes to be filtered
     * @param category moisture
     * @return filtered biomes from @param filter
     */
    public static ArrayListMultimap<Integer, BiomeGroup> getBiomesByMoisture(List<BiomeGroup> filter, WetCategory category) {
        ArrayListMultimap<Integer, BiomeGroup> multimap = ArrayListMultimap.create();
        for (BiomeGroup biomeGroup : filter) {
            WetCategory biomeCategory = WetCategory.getFromMoisture(0f, 1f, biomeGroup.getBaseBiome().getDownfall());
            int distance = Math.abs(Math.min(category.ordinal(),biomeCategory.ordinal()) - Math.max(category.ordinal(),biomeCategory.ordinal()));
            multimap.put(distance,biomeGroup);
        }


        return multimap;
    }

    /**
     * Gets a valid biome list by a temp and wet category
     *
     * @param filter   biomes to be filtered
     * @param tempCategory temperature
     * @param wetCategory moisture
     * @return filtered biomes from @param filter
     */
    public static ArrayListMultimap<Integer, BiomeGroup> getBiomesByTemperatureAndMoisture(List<BiomeGroup> filter, TempCategory tempCategory, WetCategory wetCategory) {
        ArrayListMultimap<Integer, BiomeGroup> multimap = ArrayListMultimap.create();
        for (BiomeGroup biomeGroup : filter) {
            TempCategory biomeTempCategory = TempCategory.getFromTemperature(-0.1f, 1f, biomeGroup.getBaseBiome().getDefaultTemperature());
            WetCategory biomeWetCategory = WetCategory.getFromMoisture(0f, 1f, biomeGroup.getBaseBiome().getDownfall());
            int tempDistance = Math.abs(Math.min(tempCategory.ordinal(),biomeTempCategory.ordinal()) - Math.max(tempCategory.ordinal(),biomeTempCategory.ordinal()));
            int wetDistance = Math.abs(Math.min(wetCategory.ordinal(),biomeWetCategory.ordinal()) - Math.max(wetCategory.ordinal(),biomeWetCategory.ordinal()));
            multimap.put(tempDistance + wetDistance,biomeGroup);
        }


        return multimap;
    }

    /**
     * Gets a valid biome list by a temp category
     *
     * @param filter       biomes to be filtered
     * @param tempCategory temperature
     * @param wetCategory  moisture
     * @return filtered biomes from @param filter
     */
    public static List<BiomeGroup> getBiomesByTemperatureAndMoisture(List<BiomeGroup> filter, MainBiomeTransformer.TerrainCategory category, TempCategory tempCategory, WetCategory wetCategory) {
        ArrayListMultimap<Integer, BiomeGroup> multimap = getBiomesByTemperatureAndMoisture(filter,tempCategory,wetCategory);
        List<BiomeGroup> groups = new ArrayList<>(multimap.get(0));
        if ((category == MainBiomeTransformer.TerrainCategory.DEEP_OCEAN || category == MainBiomeTransformer.TerrainCategory.OCEAN)) {
            List<BiomeGroup> oceans = new ArrayList<>();
            if(tempCategory == TempCategory.ICY){
                if(category == MainBiomeTransformer.TerrainCategory.OCEAN){
                    oceans.add(WNBiomes.FROZEN_OCEAN);
                }else {
                    oceans.add(WNBiomes.DEEP_FROZEN_OCEAN);
                }
            }else if(tempCategory == TempCategory.COLD){
                if(category == MainBiomeTransformer.TerrainCategory.OCEAN){
                    oceans.add(WNBiomes.COLD_OCEAN);
                }else {
                    oceans.add(WNBiomes.DEEP_COLD_OCEAN);
                }
            }else if(tempCategory == TempCategory.TEMPERATE){
                if(category == MainBiomeTransformer.TerrainCategory.OCEAN){
                    oceans.add(WNBiomes.OCEAN);
                }else {
                    oceans.add(WNBiomes.DEEP_OCEAN);
                }
            }else if(tempCategory == TempCategory.WARM){
                if(category == MainBiomeTransformer.TerrainCategory.OCEAN){
                    oceans.add(WNBiomes.LUKEWARM_OCEAN);
                }else {
                    oceans.add(WNBiomes.DEEP_LUKEWARM_OCEAN);
                }
            }else {
                if(category == MainBiomeTransformer.TerrainCategory.OCEAN){
                    oceans.add(WNBiomes.WARM_OCEAN);
                }else {
                    oceans.add(WNBiomes.DEEP_WARM_OCEAN);
                }
            }
            return oceans.isEmpty() ? groups : oceans;
        }
        int i = 0;
        while(groups.size() < Math.min(filter.size(), 5)){
            i++;
            List<BiomeGroup> newGroups = new ArrayList<>(multimap.get(i));
            for(int j = 0; j < newGroups.size() && groups.size() <  Math.min(filter.size(), 8); j++){
                groups.add(newGroups.get(j));
            }
        }

        return groups;
    }
}
