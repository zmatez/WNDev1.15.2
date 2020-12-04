package com.matez.wildnature.world.generation.transformer;

import com.google.common.collect.ArrayListMultimap;
import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.noise.NoiseUtil;
import com.matez.wildnature.util.other.Utilities;
import com.matez.wildnature.world.generation.biome.setup.grid.BiomeGroup;
import com.matez.wildnature.world.generation.terrain.Terrain;
import com.matez.wildnature.world.generation.grid.Cell;
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
    public BiomeGroup bgApply(Cell cell, Terrain terrain) {
        return bgApply(TempCategory.getFromTemperature(-1, 1, cell.temparature), WetCategory.getFromMoisture(-1, 1, cell.moisture), cell, terrain, terrain.getTerrainCategory(), cell.biomeCellIdentity);
    }
    protected BiomeGroup bgApply(TempCategory tempCategory, WetCategory wetCategory, Cell cell, Terrain terrain, Terrain.Category category, float identity) {
        return null;
    }

    /**
     * Replaces biomeGroup to another if needs to (used for islands)
     *
     * @return biome group
     */
    public BiomeGroup bgApply(BiomeGroup oldBiomeGroup, Cell cell, Terrain terrain) {
        return bgApply(oldBiomeGroup, TempCategory.getFromTemperature(-0.1f, 1, oldBiomeGroup.getBaseBiome().getDefaultTemperature()), WetCategory.getFromMoisture(0, 1, oldBiomeGroup.getBaseBiome().getDownfall()), cell, terrain, terrain.getTerrainCategory(), cell.subBiomeCellIdentity);
    }
    protected BiomeGroup bgApply(BiomeGroup oldBiomeGroup, TempCategory tempCategory, WetCategory wetCategory, Cell cell, Terrain terrain, Terrain.Category category, float identity) {
        return oldBiomeGroup;
    }

    /**
     * For lake biomes
     */
    public BiomeGroup bgApply(int x, int z, BiomeGroup oldBiomeGroup, Cell cell, Terrain terrain) {
        return bgApply(x,z,oldBiomeGroup, TempCategory.getFromTemperature(-0.1f, 1, oldBiomeGroup.getBaseBiome().getDefaultTemperature()), WetCategory.getFromMoisture(0, 1, oldBiomeGroup.getBaseBiome().getDownfall()), cell, terrain, terrain.getTerrainCategory(), cell.subBiomeCellIdentity);
    }
    protected BiomeGroup bgApply(int x, int z, BiomeGroup oldBiomeGroup, TempCategory tempCategory, WetCategory wetCategory, Cell cell, Terrain terrain, Terrain.Category category, float identity) {
        return oldBiomeGroup;
    }

    /**
     * Gets Biome from weighted biome list from BiomeGroup (baseBiome * 10, subBiome * subBiome weight). Uses SubBiomeMap
     *
     * @return Biome
     */
    public Biome apply(BiomeGroup oldBiomeGroup, Cell cell, Terrain terrain) {
        return apply(oldBiomeGroup, TempCategory.getFromTemperature(-0.1f, 1, oldBiomeGroup.getBaseBiome().getDefaultTemperature()), WetCategory.getFromMoisture(0, 1, oldBiomeGroup.getBaseBiome().getDownfall()), cell, terrain, terrain.getTerrainCategory(), cell.subBiomeCellIdentity);
    }
    protected Biome apply(BiomeGroup oldBiomeGroup, TempCategory tempCategory, WetCategory wetCategory, Cell cell, Terrain terrain, Terrain.Category category, float identity) {
        return oldBiomeGroup.getBaseBiome();
    }

    //Not used anytime yet
    public Biome apply(Biome oldBiome, Cell cell, Terrain terrain) {
        return apply(oldBiome, TempCategory.getFromTemperature(-0.1f, 1, oldBiome.getDefaultTemperature()), WetCategory.getFromMoisture(0, 1, oldBiome.getDownfall()), cell, terrain, terrain.getTerrainCategory(), cell.subBiomeCellIdentity);
    }
    protected Biome apply(Biome oldBiome, TempCategory tempCategory, WetCategory wetCategory, Cell cell, Terrain terrain, Terrain.Category category, float identity) {
        return oldBiome;
    }

    /**
     * Used for edge biomes
     *
     * @return
     */
    public Biome apply(Biome oldBiome, BiomeGroup oldCenterBiomeGroup, BiomeGroup oldNorthBiomeGroup, BiomeGroup oldSouthBiomeGroup, BiomeGroup oldEastBiomeGroup, BiomeGroup oldWestBiomeGroup, Cell cell, Terrain terrain) {
        return apply(oldBiome, oldCenterBiomeGroup, oldNorthBiomeGroup, oldSouthBiomeGroup, oldEastBiomeGroup, oldWestBiomeGroup, TempCategory.getFromTemperature(-0.1f, 1, oldBiome.getDefaultTemperature()), WetCategory.getFromMoisture(0, 1, oldBiome.getDownfall()), cell, terrain, terrain.getTerrainCategory(), cell.subBiomeCellIdentity);
    }
    protected Biome apply(Biome oldBiome, BiomeGroup oldCenterBiomeGroup, BiomeGroup oldNorthBiomeGroup, BiomeGroup oldSouthBiomeGroup, BiomeGroup oldEastBiomeGroup, BiomeGroup oldWestBiomeGroup, TempCategory tempCategory, WetCategory wetCategory, Cell cell, Terrain terrain, Terrain.Category category, float identity) {
        return oldCenterBiomeGroup.getBaseBiome();
    }

    /**
     * Used for edge biomes, shores etc
     *
     * @return
     */
    public BiomeGroup apply(BiomeGroup oldBiomeGroup, BiomeGroup northBiomeGroup, BiomeGroup southBiomeGroup, BiomeGroup eastBiomeGroup, BiomeGroup westBiomeGroup, Cell cell, Terrain terrain) {
        return apply(oldBiomeGroup, northBiomeGroup, southBiomeGroup, eastBiomeGroup, westBiomeGroup, TempCategory.getFromTemperature(-0.1f, 1, oldBiomeGroup.getBaseBiome().getDefaultTemperature()), WetCategory.getFromMoisture(0, 1, oldBiomeGroup.getBaseBiome().getDownfall()), cell, terrain, terrain.getTerrainCategory(), cell.subBiomeCellIdentity);
    }
    protected BiomeGroup apply(BiomeGroup oldBiomeGroup, BiomeGroup northBiomeGroup, BiomeGroup southBiomeGroup, BiomeGroup eastBiomeGroup, BiomeGroup westBiomeGroup, TempCategory tempCategory, WetCategory wetCategory, Cell cell, Terrain terrain, Terrain.Category category, float identity) {
        return oldBiomeGroup;
    }

    /**
     * Used for shores
     *
     * @return
     */
    public Biome apply(Biome oldCenterBiome, Biome oldNorthBiome, Biome oldSouthBiome, Biome oldEastBiome, Biome oldWestBiome, Cell cell, Terrain terrain) {
        return apply(oldCenterBiome, oldNorthBiome, oldSouthBiome, oldEastBiome, oldWestBiome, TempCategory.getFromTemperature(-0.1f, 1, oldCenterBiome.getDefaultTemperature()), WetCategory.getFromMoisture(0, 1, oldCenterBiome.getDownfall()), cell, terrain, terrain.getTerrainCategory(), cell.subBiomeCellIdentity);
    }
    protected Biome apply(Biome oldCenterBiome, Biome oldNorthBiome, Biome oldSouthBiome, Biome oldEastBiome, Biome oldWestBiome, TempCategory tempCategory, WetCategory wetCategory, Cell cell, Terrain terrain, Terrain.Category category, float identity) {
        return oldCenterBiome;
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
            TempCategory biomeTempCategory = TempCategory.getFromTemperature(-0.1f, 1f, biomeGroup.getBaseBiome().getDownfall());
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
    public static List<BiomeGroup> getBiomesByTemperatureAndMoisture(List<BiomeGroup> filter, Terrain.Category category, TempCategory tempCategory, WetCategory wetCategory) {
        ArrayListMultimap<Integer, BiomeGroup> multimap = getBiomesByTemperatureAndMoisture(filter,tempCategory,wetCategory);
        List<BiomeGroup> groups = new ArrayList<>(multimap.get(0));
        if (!groups.isEmpty() && (category == Terrain.Category.DEEP_OCEAN || category == Terrain.Category.OCEAN || category == Terrain.Category.SEA)) {
            return groups;
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

    public static List<BiomeGroup> getBiomesByTemperatureAndMoisture(Terrain terrain, TempCategory tempCategory, WetCategory wetCategory){
        return terrain.getClimaticBiomeGroups(tempCategory,wetCategory);
    }
}
