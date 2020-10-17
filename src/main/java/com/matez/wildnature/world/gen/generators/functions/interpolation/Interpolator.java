package com.matez.wildnature.world.gen.generators.functions.interpolation;

import com.matez.wildnature.world.gen.biomes.setup.BiomeVariants;
import com.matez.wildnature.world.gen.chunk.generation.ChunkArraySampler;
import it.unimi.dsi.fastutil.objects.Object2DoubleMap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

import java.util.function.Function;

public class Interpolator {
    public static double smoothLerp(int x, int z, BiomeProvider biomeProvider, Object2DoubleMap<Biome> weightMap16, Object2DoubleMap<Biome> weightMap4, Object2DoubleMap<Biome> weightMap1){
        // Group biomes at different distances. This has the effect of making some biome transitions happen over larger distances than others.
        // This is used to make most land biomes blend at maximum distance, while allowing biomes such as rivers to blend at short distances, creating better cliffs as river biomes are smaller width than other biomes.
        Function<Biome, BiomeVariants> variantAccessor = BiomeVariants::getVariantsFor;
        ChunkArraySampler.reduceGroupedWeightMap(weightMap4, weightMap16, variantAccessor.andThen(BiomeVariants::getLargeGroup), BiomeVariants.LargeGroup.SIZE);
        ChunkArraySampler.reduceGroupedWeightMap(weightMap1, weightMap4, variantAccessor.andThen(BiomeVariants::getSmallGroup), BiomeVariants.SmallGroup.SIZE);

        // Based on total weight of all biomes included, calculate heights of a couple important groups
        // Rivers and shores are seperated in order to force cliff generation
        double totalHeight = 0, riverHeight = 0, shoreHeight = 0;
        double riverWeight = 0, shoreWeight = 0;
        Biome biomeAt = null, normalBiomeAt = null, riverBiomeAt = null, shoreBiomeAt = null;
        double maxNormalWeight = 0, maxRiverWeight = 0, maxShoreWeight = 0;
        for (Object2DoubleMap.Entry<Biome> entry : weightMap1.object2DoubleEntrySet()) {
            BiomeVariants variants = variantAccessor.apply(entry.getKey());
            double weight = entry.getDoubleValue();
            double height = weight * getDepth(entry.getKey());//
            totalHeight += height;
            if (variants == BiomeVariants.RIVER) {
                riverHeight += height;
                riverWeight += weight;
                if (maxRiverWeight < weight) {
                    riverBiomeAt = entry.getKey();
                    maxRiverWeight = weight;
                }
            } else if (variants == BiomeVariants.SHORE) {
                shoreHeight += height;
                shoreWeight += weight;
                if (maxShoreWeight < weight) {
                    shoreBiomeAt = entry.getKey();
                    maxShoreWeight = weight;
                }
            } else if (maxNormalWeight < weight) {
                normalBiomeAt = entry.getKey();
                maxNormalWeight = weight;
            }
        }

        double actualHeight = totalHeight;
            /*if (riverWeight > 0.6 && riverBiomeAt != null) {
                // River bottom / shore
                double aboveWaterDelta = actualHeight - riverHeight / riverWeight;
                if (aboveWaterDelta > 0) {
                    if (aboveWaterDelta > 20) {
                        aboveWaterDelta = 20;
                    }
                    double adjustedAboveWaterDelta = 0.02 * aboveWaterDelta * (40 - aboveWaterDelta) - 0.48;
                    actualHeight = riverHeight / riverWeight + adjustedAboveWaterDelta;
                }
                biomeAt = riverBiomeAt; // Use river surface for the bottom of the river + small shore beneath cliffs
            } else if (riverWeight > 0 && normalBiomeAt != null) {
                double adjustedRiverWeight = 0.6 * riverWeight;
                actualHeight = (totalHeight - riverHeight) * ((1 - adjustedRiverWeight) / (1 - riverWeight)) + riverHeight * (adjustedRiverWeight / riverWeight);

                biomeAt = normalBiomeAt;
            } else if (normalBiomeAt != null) {
                biomeAt = normalBiomeAt;
            }

            if ((shoreWeight > 0.6 || maxShoreWeight > maxNormalWeight) && shoreBiomeAt != null) {
                // Flatten beaches above a threshold, creates cliffs where the beach ends
                double aboveWaterDelta = actualHeight - shoreHeight / shoreWeight;
                if (aboveWaterDelta > 0) {
                    if (aboveWaterDelta > 20) {
                        aboveWaterDelta = 20;
                    }
                    double adjustedAboveWaterDelta = 0.02 * aboveWaterDelta * (40 - aboveWaterDelta) - 0.48;
                    actualHeight = shoreHeight / shoreWeight + adjustedAboveWaterDelta;
                }
                biomeAt = shoreBiomeAt;
            }*/

        //Objects.requireNonNull(biomeAt, "Biome should not be null!");
        return actualHeight;
    }

    private static int getDepth(Biome biome){
        int max = 230; //about 180Y
        int min = 40; //about 21Y
        int baseValue = 75; //about 65Y

        float depth = baseValue * (biome.getDepth() > 0 ? biome.getDepth() + 1 : biome.getDepth() - 1);
        depth = Math.min(depth,max);
        depth = Math.max(depth,min);
        return Math.round(depth);
    }
}
