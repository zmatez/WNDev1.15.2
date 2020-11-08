package com.matez.wildnature.world.generation.generators.functions.interpolation;

import com.matez.wildnature.world.generation.biome.setup.BiomeVariants;
import com.matez.wildnature.world.generation.chunk.generation.landscape.ChunkLandscape;
import com.matez.wildnature.world.generation.chunk.generation.noise.NoiseProcessor;
import com.matez.wildnature.world.generation.chunk.generation.noise.config.NoiseProcessorConfig;
import com.matez.wildnature.world.generation.noise.fastNoise.FastNoise;
import it.unimi.dsi.fastutil.objects.Object2DoubleMap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;

import java.util.ArrayList;
import java.util.LinkedHashMap;
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

    public static BlendOutput smoothLerp(int x, int z, ChunkLandscape landscape, Object2DoubleMap<LerpConfiguration> weightMap1, Function<LerpConfiguration, BiomeVariants> variantAccessor){
        // Based on total weight of all biomes included, calculate heights of a couple important groups
        double totalHeight = 0;
        double totalScale = 0;

        double totalFactor = 0;
        LinkedHashMap<NoiseProcessor, Double> configs = new LinkedHashMap<>();

        for (Object2DoubleMap.Entry<LerpConfiguration> entry : weightMap1.object2DoubleEntrySet()) {
            BiomeVariants variants = variantAccessor.apply(entry.getKey());
            LerpConfiguration configuration = entry.getKey();
            Biome biome = configuration.getBiome();
            ChunkLandscape biomeLandscape = ChunkLandscape.getOrCreate(x, z, landscape.seed, landscape.sealevel, biome, landscape.chunk);;

            double weight = entry.getDoubleValue();
            double height = weight * modifyDepth(weight, getDepth(configuration.getDepth()),x,z);
            double scale = weight * getScale(configuration.getScale());

            totalHeight += height;
            totalScale += scale;



            totalFactor += weight * (biome == Biomes.MOUNTAINS ? 1 : -1);

            for (NoiseProcessor noiseProcessor1 : landscape.getValidNoiseProcessors()) {
                for (NoiseProcessor noiseProcessor2 : biomeLandscape.getValidNoiseProcessors()) {
                    double old1 = 0;
                    if(configs.containsKey(noiseProcessor1)){
                        old1 = configs.get(noiseProcessor1);
                    }

                    if(noiseProcessor2 == noiseProcessor1){
                        configs.put(noiseProcessor1, old1 + weight);
                    }else{
                        configs.put(noiseProcessor1, old1 - weight);
                    }
                }
            }
        }

        return new BlendOutput(totalHeight,totalScale,configs);
    }

    private static double scaleBetween(double unscaledNum, double minAllowed, double maxAllowed, double min, double max) {
        return (maxAllowed - minAllowed) * (unscaledNum - min) / (max - min) + minAllowed;
    }

    private static double lerp(double a, double b, double alpha) {
        return a + alpha * (b - a);
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

    public static class BlendOutput{
        private final double height, scale;
        private final LinkedHashMap<NoiseProcessor, Double> configs;
        public BlendOutput(double height, double scale, LinkedHashMap<NoiseProcessor, Double> configs){
            this.height = height;
            this.scale = scale;
            this.configs = configs;
        }

        public double getHeight() {
            return height;
        }

        public double getScale() {
            return scale;
        }

        public double getFactorFor(NoiseProcessor processor){
            if(configs.containsKey(processor)){
                return configs.get(processor);
            }
            return 0.0;
        }
    }
}
