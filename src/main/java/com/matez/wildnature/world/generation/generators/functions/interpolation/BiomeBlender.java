package com.matez.wildnature.world.generation.generators.functions.interpolation;

import com.matez.wildnature.util.other.Utilities;
import com.matez.wildnature.world.generation.biome.setup.BiomeVariants;
import com.matez.wildnature.world.generation.biome.setup.WNBiome;
import com.matez.wildnature.world.generation.chunk.generation.landscape.ChunkLandscape;
import com.matez.wildnature.world.generation.chunk.generation.noise.NoiseProcessor;
import com.matez.wildnature.world.generation.noise.fastNoise.FastNoise;
import it.unimi.dsi.fastutil.objects.Object2DoubleMap;
import net.minecraft.world.biome.Biome;

import java.util.LinkedHashMap;
import java.util.function.Function;

public class BiomeBlender {
    //seed -9156151490331591379
    // /tp 1985 200 -1235 - ocean
    // /tp 2160 130 -915 - shore

    public static FastNoise fastNoise;

    static {
        fastNoise = new FastNoise();
        fastNoise.SetFractalOctaves(5);
        fastNoise.SetFractalType(FastNoise.FractalType.FBM);
        fastNoise.SetFractalGain(2f);
        fastNoise.SetFractalLacunarity(2);
    }

    public static double[] smoothLerp(int x, int z, ChunkLandscape landscape, Object2DoubleMap<LerpConfiguration> weightMap1, Function<LerpConfiguration, BiomeVariants> variantAccessor) {
        // Based on total weight of all biomes included, calculate heights of a couple important groups
        double totalHeight = 0;
        double totalScale = 0;
        double totalNoiseFactor = 0;
        double totalFreqModifier = 0;
        double totalHilliness = 0;
        double totalFrequencyMin = 0;
        double totalFrequencyMax = 0;

        //Thanks to AlcatrazEscapee for providing this code. See GitHub at: https://github.com/TerraFirmaCraft/TerraFirmaCraft/
        for (Object2DoubleMap.Entry<LerpConfiguration> entry : weightMap1.object2DoubleEntrySet()) {
            BiomeVariants variants = variantAccessor.apply(entry.getKey());
            LerpConfiguration configuration = entry.getKey();

            Biome biome = configuration.getBiome();
            double weight = entry.getDoubleValue();
            double height = weight * getDepth(configuration.getDepth());
            double scale = weight * getScale(configuration.getScale());
            double noiseFactor = weight * (biome == landscape.biome ? 1 : 0);
            double freqModifier = 0;
            double hilliness = 0;
            double frequencyMin = 0;
            double frequencyMax = 0;
            if(biome instanceof WNBiome){
                frequencyMin = weight * ((WNBiome)biome).getFrequencyMin();
                frequencyMax = weight * ((WNBiome)biome).getFrequencyMax();
                freqModifier = weight * ((WNBiome)biome).getFreqModifier();
                hilliness = weight * ((WNBiome)biome).getHilliness();
            }else{
                frequencyMin = weight * (-biome.getScale() * 0.6);
                frequencyMax = weight * (biome.getScale() * 1.3);
                freqModifier = weight * 1;
                hilliness = weight * 1;
            }

            totalHeight += height;
            totalScale += scale;
            totalNoiseFactor += noiseFactor;
            totalFreqModifier += freqModifier;
            totalHilliness += hilliness;
            totalFrequencyMin += frequencyMin;
            totalFrequencyMax += frequencyMax;
        }

        return new double[]{totalHeight, totalScale, totalNoiseFactor, totalFreqModifier, totalHilliness, Math.min(totalFrequencyMin,totalFrequencyMax), Math.max(totalFrequencyMin,totalFrequencyMax)};
    }

    private static double lerp(double a, double b, double alpha) {
        return a + alpha * (b - a);
    }

    public static double modifyDepth(double weight, double depth, int x, int z) {
        double factor = (depth / 256) * (weight * 3);
        double fractal = fastNoise.GetSimplexFractal(x, z);
        double scaledFractal = fractal * 20;
        return depth + (scaledFractal * factor);
    }

    public static double getDepth(float depth) {
        int seaLevel = 63;
        int maxHeight = 230;
        int minHeight = 10;
        if (depth > 0) {
            return Utilities.scaleBetween(depth, seaLevel, maxHeight, 0, 2);
        } else {
            return Utilities.scaleBetween(depth, minHeight, seaLevel, -2, 0);
        }
    }

    public static double getScale(float scale) {
        return scale * 7;
    }

    public static class BlendOutput {
        private final double height, scale;
        private final LinkedHashMap<NoiseProcessor, Double> configs;

        public BlendOutput(double height, double scale, LinkedHashMap<NoiseProcessor, Double> configs) {
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

        public double getFactorFor(NoiseProcessor processor) {
            if (configs.containsKey(processor)) {
                return configs.get(processor);
            }
            return 0.0;
        }
    }
}
