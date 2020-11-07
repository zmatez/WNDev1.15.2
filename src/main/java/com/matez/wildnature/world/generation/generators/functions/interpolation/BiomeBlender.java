package com.matez.wildnature.world.generation.generators.functions.interpolation;

import com.matez.wildnature.world.generation.biome.setup.BiomeVariants;
import com.matez.wildnature.world.generation.noise.fastNoise.FastNoise;
import it.unimi.dsi.fastutil.objects.Object2DoubleMap;
import net.minecraft.world.biome.Biome;

import java.util.function.Function;

public class BiomeBlender {
    //seed -9156151490331591379
    // /tp 1985 200 -1235 - ocean
    // /tp 2160 130 -915 - shore

    public static FastNoise fastNoise;
    static{
        fastNoise = new FastNoise();
        fastNoise.SetFractalOctaves(5);
        fastNoise.SetFractalType(FastNoise.FractalType.FBM);
        fastNoise.SetFractalGain(2f);
        fastNoise.SetFractalLacunarity(2);
    }

    public static double[] smoothLerp(int x, int z, Biome biomeIn, Object2DoubleMap<LerpConfiguration> weightMap1, Function<LerpConfiguration, BiomeVariants> variantAccessor){
        // Based on total weight of all biomes included, calculate heights of a couple important groups
        double totalHeight = 0;
        double totalScale = 0;
        double totalNoiseFactor = 0;
        double totalNoiseFactorFix = 0;
        double biomeInWeight = 0;
        double biomeOutWeight = 0;
        int amountIn = 0;
        int amountOut = 0;
        for (Object2DoubleMap.Entry<LerpConfiguration> entry : weightMap1.object2DoubleEntrySet()) {
            BiomeVariants variants = variantAccessor.apply(entry.getKey());
            LerpConfiguration configuration = entry.getKey();
            Biome biome = configuration.getBiome();

            double weight = entry.getDoubleValue();
            double height = weight * modifyDepth(weight, getDepth(configuration.getDepth()),x,z);
            double scale = weight * getScale(configuration.getScale());


            totalHeight += height;
            totalScale += scale;

            if(biome == biomeIn){
                biomeInWeight += weight;
                amountIn ++;
            }else{
                biomeOutWeight += weight;
                amountOut ++;
            }
        }

        double maxValue = biomeInWeight + biomeOutWeight;

        totalNoiseFactor = scaleBetween(Math.max(biomeInWeight, biomeOutWeight), 0, 1, 0.5, maxValue);

        return new double[]{totalHeight,totalScale, totalNoiseFactor};
    }

    private static double scaleBetween(double unscaledNum, double minAllowed, double maxAllowed, double min, double max) {
        return (maxAllowed - minAllowed) * (unscaledNum - min) / (max - min) + minAllowed;
    }

    public static double modifyDepth(double weight, double depth, int x, int z){
        double factor = (depth/256) * (weight * 3);
        double fractal = fastNoise.GetSimplexFractal(x,z);
        double scaledFractal = fractal * 20;
        return depth + (scaledFractal * factor);
    }

    public static double getDepth(float depth){
        int max = 200; //about 170Y
        int min = 40; //about 21Y
        int baseValue = 75; //about 65Y

        float sampledDepth = baseValue * (depth > 0 ? depth + 1 : depth - 1);
        sampledDepth = Math.min(sampledDepth,max);
        sampledDepth = Math.max(sampledDepth,min);
        return sampledDepth;
    }

    public static double getScale(float scale){
        return scale*7;
    }
}
