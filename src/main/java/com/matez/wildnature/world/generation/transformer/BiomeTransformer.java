package com.matez.wildnature.world.generation.transformer;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.noise.NoiseUtil;
import com.matez.wildnature.util.other.Utilities;
import com.matez.wildnature.world.generation.biome.setup.grid.BiomeGroup;
import com.matez.wildnature.world.generation.chunk.terrain.Terrain;
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
        return bgApply(oldBiomeGroup, TempCategory.getFromTemperature(-1, 1, cell.temparature), WetCategory.getFromMoisture(-1, 1, cell.moisture), cell, terrain, terrain.getTerrainCategory(), cell.subBiomeCellIdentity);
    }
    protected BiomeGroup bgApply(BiomeGroup oldBiomeGroup, TempCategory tempCategory, WetCategory wetCategory, Cell cell, Terrain terrain, Terrain.Category category, float identity) {
        return oldBiomeGroup;
    }

    /**
     * Gets Biome from weighted biome list from BiomeGroup (baseBiome * 10, subBiome * subBiome weight). Uses SubBiomeMap
     *
     * @return Biome
     */
    public Biome apply(BiomeGroup oldBiomeGroup, Cell cell, Terrain terrain) {
        return apply(oldBiomeGroup, TempCategory.getFromTemperature(-1, 1, cell.temparature), WetCategory.getFromMoisture(-1, 1, cell.moisture), cell, terrain, terrain.getTerrainCategory(), cell.subBiomeCellIdentity);
    }
    protected Biome apply(BiomeGroup oldBiomeGroup, TempCategory tempCategory, WetCategory wetCategory, Cell cell, Terrain terrain, Terrain.Category category, float identity) {
        return oldBiomeGroup.getBaseBiome();
    }

    //Not used anytime yet
    public Biome apply(Biome oldBiome, Cell cell, Terrain terrain) {
        return apply(oldBiome, TempCategory.getFromTemperature(-1, 1, cell.temparature), WetCategory.getFromMoisture(-1, 1, cell.moisture), cell, terrain, terrain.getTerrainCategory(), cell.subBiomeCellIdentity);
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
        return apply(oldBiome, oldCenterBiomeGroup, oldNorthBiomeGroup, oldSouthBiomeGroup, oldEastBiomeGroup, oldWestBiomeGroup, TempCategory.getFromTemperature(-1, 1, cell.temparature), WetCategory.getFromMoisture(-1, 1, cell.moisture), cell, terrain, terrain.getTerrainCategory(), cell.subBiomeCellIdentity);
    }
    protected Biome apply(Biome oldBiome, BiomeGroup oldCenterBiomeGroup, BiomeGroup oldNorthBiomeGroup, BiomeGroup oldSouthBiomeGroup, BiomeGroup oldEastBiomeGroup, BiomeGroup oldWestBiomeGroup, TempCategory tempCategory, WetCategory wetCategory, Cell cell, Terrain terrain, Terrain.Category category, float identity) {
        return oldCenterBiomeGroup.getBaseBiome();
    }

    /**
     * Used for shores
     *
     * @return
     */
    public Biome apply(Biome oldCenterBiome, Biome oldNorthBiome, Biome oldSouthBiome, Biome oldEastBiome, Biome oldWestBiome, Cell cell, Terrain terrain) {
        return apply(oldCenterBiome, oldNorthBiome, oldSouthBiome, oldEastBiome, oldWestBiome, TempCategory.getFromTemperature(-1, 1, cell.temparature), WetCategory.getFromMoisture(-1, 1, cell.moisture), cell, terrain, terrain.getTerrainCategory(), cell.subBiomeCellIdentity);
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
            } else if (scaled > 0.6 && scaled <= 1) {
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

        public static WetCategory getFromMoisture(float min, float max, float moisture) {
            float scaled = Utilities.scaleBetween(moisture, -1, 1, min, max);
            if (scaled < -1) {
                scaled = -1;
            } else if (scaled > 1) {
                scaled = 1;
            }
            if (scaled >= -1 && scaled < -0.35) {
                return WET;
            } else if (scaled >= -0.35 && scaled <= 0.35) {
                return TEMPERATE;
            } else if (scaled > 0.35 && scaled <= 1) {
                return DRY;
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
    public static List<Biome> getBiomesByTemperature(List<Biome> filter, TempCategory category, boolean canBeEmpty) {
        List<Biome> biomes = new ArrayList<>();
        for (Biome biome : filter) {
            TempCategory biomeCategory = TempCategory.getFromTemperature(-0.1f, 1, biome.getDefaultTemperature());
            if (biomeCategory == category) {
                biomes.add(biome);
            }
        }
        return biomes;
    }

    /**
     * Gets a valid biome list by a temp category
     *
     * @param filter   biomes to be filtered
     * @param category moisture
     * @return filtered biomes from @param filter
     */
    public static List<Biome> getBiomesByMoisture(List<Biome> filter, WetCategory category, boolean canBeEmpty) {
        List<Biome> biomes = new ArrayList<>();
        for (Biome biome : filter) {
            WetCategory biomeCategory = WetCategory.getFromMoisture(0, 1, biome.getDownfall());
            if (biomeCategory == category) {
                biomes.add(biome);
            }
        }
        return biomes;
    }

    /**
     * Gets a valid biome list by a temp category
     *
     * @param filter       biomes to be filtered
     * @param tempCategory temperature
     * @param wetCategory  moisture
     * @return filtered biomes from @param filter
     */
    public static List<Biome> getBiomesByTemperatureAndMoisture(List<Biome> filter, TempCategory tempCategory, WetCategory wetCategory, boolean canBeEmpty) {
        List<Biome> biomesTemp = getBiomesByTemperature(filter, tempCategory, canBeEmpty);
        List<Biome> biomesMoist = getBiomesByMoisture(filter, wetCategory, canBeEmpty);
        List<Biome> biomes = new ArrayList<>();
        for (Biome biome1 : biomesTemp) {
            for (Biome biome2 : biomesMoist) {
                if (biome1 == biome2) {
                    if (!biomes.contains(biome1)) {
                        biomes.add(biome1);
                    }
                }
            }
        }

        return biomes;
    }
}
