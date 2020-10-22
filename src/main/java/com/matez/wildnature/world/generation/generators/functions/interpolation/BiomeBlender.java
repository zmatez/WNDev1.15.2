package com.matez.wildnature.world.generation.generators.functions.interpolation;

import com.matez.wildnature.world.generation.biomes.setup.BiomeVariants;
import it.unimi.dsi.fastutil.objects.Object2DoubleMap;
import net.minecraft.world.biome.Biome;

import java.util.function.Function;

public class BiomeBlender {
    public static double[] smoothLerp(Object2DoubleMap<Biome> weightMap1, Function<Biome, BiomeVariants> variantAccessor){
        // Based on total weight of all biomes included, calculate heights of a couple important groups
        double totalHeight = 0;
        double totalHeightVariation = 0;

        for (Object2DoubleMap.Entry<Biome> entry : weightMap1.object2DoubleEntrySet()) {
            BiomeVariants variants = variantAccessor.apply(entry.getKey());
            double weight = entry.getDoubleValue();
            double height = weight * getDepth(entry.getKey());
            double heightVariation = weight * getScale(entry.getKey());


            totalHeight += height;
            totalHeightVariation += heightVariation;
        }

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
        return biome.getScale();
    }
}
