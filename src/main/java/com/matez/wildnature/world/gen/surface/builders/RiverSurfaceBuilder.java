package com.matez.wildnature.world.gen.surface.builders;

import com.matez.wildnature.world.gen.noise.sponge.module.source.Perlin;
import com.matez.wildnature.world.gen.noise.sponge.module.source.RidgedMulti;
import com.matez.wildnature.world.gen.surface.configs.CanyonSurfaceBuilderConfig;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

import java.util.Random;
import java.util.function.Function;

public class RiverSurfaceBuilder extends SurfaceBuilder<CanyonSurfaceBuilderConfig> {
    private final static RidgedMulti ridgedMultiNoise = new RidgedMulti();
    private final static Perlin heightNoise = new Perlin();

    public RiverSurfaceBuilder(Function<Dynamic<?>, ? extends CanyonSurfaceBuilderConfig> p_i51312_1_) {
        super(p_i51312_1_);
        ridgedMultiNoise.setFrequency(0.01);
        ridgedMultiNoise.setOctaveCount(1);
        ridgedMultiNoise.setLacunarity(0.0);
        heightNoise.setFrequency(0.03);
        heightNoise.setOctaveCount(2);
        heightNoise.setLacunarity(0.0);
        heightNoise.setPersistence(-0.4);
        setRegistryName("wildnature", "river_surface_builder");
    }


    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, CanyonSurfaceBuilderConfig config) {
        ridgedMultiNoise.setSeed((int) seed);
        heightNoise.setSeed((int) seed);
        int realY = startHeight;
        double vnoise = ridgedMultiNoise.getValue(x, 1, z);
        double hnoise = heightNoise.getValue(x, 1, z);
        double hvar = 0;
        if (hnoise >= 0.2) {
            hvar = hvar + 1;
            if (hnoise >= 0.28) {
                hvar = hvar + 1;
            }
            if (hnoise >= 0.35) {
                hvar = hvar + 1;
            }
        } else if (hnoise < 0.18) {
            hvar = hvar - 1;
        }

        if (vnoise >= 0.50 && vnoise <= 2) {
            BlockPos pos = new BlockPos(x, seaLevel + 65 + hvar, z);
            int height = getNoiseHeight(vnoise, 0.50, 0.625, 10, 35, 17, 0.63, random, seed, pos);
            realY = realY - height;
            int startPointY = -height / 2;//pos.y - startPointY -> block being set
            for (int a = pos.getY() - startPointY; a > pos.getY() - height; a--) {
                if (a >= seaLevel) {
                    chunkIn.setBlockState(new BlockPos(pos.getX(), a, pos.getZ()), Blocks.AIR.getDefaultState(), false);
                } else {
                    chunkIn.setBlockState(new BlockPos(pos.getX(), a, pos.getZ()), Blocks.WATER.getDefaultState(), false);
                }
            }
        }
        config.getConfig().setSeed(seed);
        config.getConfig().buildSurface(random, chunkIn, biomeIn, x, z, realY, noise, defaultBlock, defaultFluid, seaLevel, seed, config);

    }

    public int getNoiseHeight(double noise, double minNoise, double maxNoise, int minHeight, int maxHeight, int maxHeightIfCavern, double cavernWhenNoise, Random random, long seed, BlockPos pos) {
        return calculateHeightByCenter(noise, minNoise, maxNoise, minHeight, maxHeight, maxHeightIfCavern, cavernWhenNoise);
    }

    private int calculateHeightByCenter(double noise, double minNoise, double maxNoise, int minHeight, int maxHeight, int maxHeightIfCavern, double cavernWhenNoise) {
        double noiseCenter = ((maxNoise - minNoise) / 2) + minNoise;//28.99999995
        double noisePercent = 0;

        if (noiseCenter > noise) {
            noisePercent = calculatePercent(noise, minNoise, noiseCenter);
        } else if (noiseCenter < noise) {
            if (noise > cavernWhenNoise) {
                noisePercent = calculatePercent(noise, maxHeightIfCavern, noiseCenter);
            } else {
                noisePercent = calculatePercent(noise, maxHeight, noiseCenter);
            }
        } else {
            noisePercent = 1;
        }

        int maxHeightCalc = maxHeight - minHeight;//5
        double height = maxHeightCalc * noisePercent;//3.05

        return (int) Math.round(height) + minHeight;//4.05 - returns 4
    }

    private double calculatePercent(double noise, double minNoise, double maxNoise) {
        double maxNoiseCalc = maxNoise - minNoise;//1.999999
        double noiseCalc = noise - minNoise;//1.23141283
        return noiseCalc / maxNoiseCalc;//0.61(%)
    }
}