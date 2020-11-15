package com.matez.wildnature.world.generation.generators.functions.interpolation;

import com.matez.wildnature.util.other.Utilities;
import com.matez.wildnature.world.generation.biome.setup.BiomeVariants;
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
        double totalHeight = 0, shoreHeight = 0;
        double shoreWeight = 0;
        double totalScale = 0;
        double maxNormalWeight = 0, maxShoreWeight = 0;

        Biome normalBiomeAt = null, shoreBiomeAt = null;

        //Thanks to AlcatrazEscapee for providing this code. See GitHub at: https://github.com/TerraFirmaCraft/TerraFirmaCraft/
        for (Object2DoubleMap.Entry<LerpConfiguration> entry : weightMap1.object2DoubleEntrySet()) {
            BiomeVariants variants = variantAccessor.apply(entry.getKey());
            LerpConfiguration configuration = entry.getKey();

            Biome biome = configuration.getBiome();
            double weight = entry.getDoubleValue();
            double height = weight * getDepth(configuration.getDepth());
            double scale = weight * getScale(configuration.getScale());

            if (variants == BiomeVariants.SHORE) {
                shoreHeight += height;
                shoreWeight += weight;
                if (maxShoreWeight < weight) {
                    shoreBiomeAt = biome;
                    maxShoreWeight = weight;
                }
            }else if (maxNormalWeight < weight) {
                maxNormalWeight = weight;
            }

            totalHeight += height;
            totalScale += scale;

            double actualHeight = totalHeight;

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
            }

            totalHeight = actualHeight;
        }

        return new double[]{totalHeight, totalScale};
    }

    private static double scaleBetween(double unscaledNum, double minAllowed, double maxAllowed, double min, double max) {
        return (maxAllowed - minAllowed) * (unscaledNum - min) / (max - min) + minAllowed;
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
