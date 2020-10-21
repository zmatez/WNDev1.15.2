package com.matez.wildnature.world.gen.generators.functions.interpolation;

import com.matez.wildnature.world.gen.biomes.setup.BiomeVariants;
import com.matez.wildnature.world.gen.chunk.generation.ChunkArraySampler;
import it.unimi.dsi.fastutil.objects.Object2DoubleMap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

import java.util.function.Function;

public class BiomeBlender {
    public static double[] smoothLerp(Object2DoubleMap<Biome> weightMap1, Function<Biome, BiomeVariants> variantAccessor){
        // Based on total weight of all biomes included, calculate heights of a couple important groups
        // Rivers and shores are seperated in order to force cliff generation
        double totalHeight = 0;
        double totalHeightVariation = 0;

        double maxNormalWeight = 0, maxRiverWeight = 0, maxShoreWeight = 0;
        for (Object2DoubleMap.Entry<Biome> entry : weightMap1.object2DoubleEntrySet()) {
            BiomeVariants variants = variantAccessor.apply(entry.getKey());
            double weight = entry.getDoubleValue();
            double height = weight * getDepth(entry.getKey());
            double heightVariation = weight * getScale(entry.getKey());


            totalHeight += height;
            totalHeightVariation += heightVariation;
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
        return new double[]{totalHeight,totalHeightVariation};
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

    private static double getScale(Biome biome){
        return biome.getScale()/4;
    }
}
