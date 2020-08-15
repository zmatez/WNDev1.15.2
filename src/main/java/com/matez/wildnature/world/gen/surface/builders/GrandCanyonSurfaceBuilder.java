package com.matez.wildnature.world.gen.surface.builders;

import com.matez.wildnature.world.gen.noise.bukkit.SimplexOctaveGenerator;
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

public class GrandCanyonSurfaceBuilder extends SurfaceBuilder<CanyonSurfaceBuilderConfig> {
    private final static RidgedMulti ridgedMultiNoise = new RidgedMulti();
    private final static Perlin heightNoise = new Perlin();
    public static SimplexOctaveGenerator crackNoise;

    public GrandCanyonSurfaceBuilder(Function<Dynamic<?>, ? extends CanyonSurfaceBuilderConfig> p_i51312_1_) {
        super(p_i51312_1_);
        ridgedMultiNoise.setFrequency(0.01);
        ridgedMultiNoise.setOctaveCount(1);
        ridgedMultiNoise.setLacunarity(0.0);
        heightNoise.setFrequency(0.03);
        heightNoise.setOctaveCount(2);
        heightNoise.setLacunarity(0.0);
        heightNoise.setPersistence(-0.4);
        setRegistryName("wildnature", "grand_canyon_surface_builder");
    }

    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, CanyonSurfaceBuilderConfig config) {
        ridgedMultiNoise.setSeed((int) seed);
        heightNoise.setSeed((int) seed);
        int realY = startHeight;
        int realY1 = startHeight;
        int realY2 = startHeight;
        int realY3 = startHeight;
        int realY4 = startHeight;
        int realY5 = startHeight;
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

        if (vnoise >= 0.45 && vnoise <= 2) {
            BlockPos pos = new BlockPos(x, seaLevel + 90 + hvar, z);
            int height = getNoiseHeight(vnoise, 0.45, 0.625, 20, 60, 17, 0.63, random, seed, pos);
            realY = realY - height;
            int startPointY = -height / 2;//pos.y - startPointY -> block being set
            for (int a = pos.getY() - startPointY; a > pos.getY() - height; a--) {
                if (a >= seaLevel) {
                    chunkIn.setBlockState(new BlockPos(pos.getX(), a, pos.getZ()), Blocks.AIR.getDefaultState(), false);
                } else {
                    chunkIn.setBlockState(new BlockPos(pos.getX(), a, pos.getZ()), Blocks.WATER.getDefaultState(), false);
                }
            }

            if (vnoise >= 0.48) {
                BlockPos pos2 = new BlockPos(x, seaLevel + 60 + hvar, z);
                int height2 = getNoiseHeight(vnoise, 0.48, 0.625, 15, 40, 17, 0.63, random, seed, pos);
                realY1 = realY1 - height2;
                int startPointY2 = -height2 / 2;//pos.y - startPointY -> block being set
                for (int a = pos2.getY() - startPointY2; a > pos2.getY() - height2; a--) {
                    if (a >= seaLevel) {
                        chunkIn.setBlockState(new BlockPos(pos2.getX(), a, pos2.getZ()), Blocks.AIR.getDefaultState(), false);
                    } else {
                        chunkIn.setBlockState(new BlockPos(pos2.getX(), a, pos2.getZ()), Blocks.WATER.getDefaultState(), false);

                    }

                }
            }

            if (vnoise >= 0.51) {
                BlockPos pos2 = new BlockPos(x, seaLevel + 35 + hvar, z);
                int height2 = getNoiseHeight(vnoise, 0.51, 0.625, 10, 25, 17, 0.63, random, seed, pos);
                realY2 = realY2 - height2;
                int startPointY2 = -height2 / 2;//pos.y - startPointY -> block being set
                for (int a = pos2.getY() - startPointY2; a > pos2.getY() - height2; a--) {
                    if (a >= seaLevel) {
                        chunkIn.setBlockState(new BlockPos(pos2.getX(), a, pos2.getZ()), Blocks.AIR.getDefaultState(), false);
                    } else {
                        chunkIn.setBlockState(new BlockPos(pos2.getX(), a, pos2.getZ()), Blocks.WATER.getDefaultState(), false);

                    }

                }
            }

            if (vnoise >= 0.54) {
                BlockPos pos2 = new BlockPos(x, seaLevel + 25 + hvar, z);
                int height2 = getNoiseHeight(vnoise, 0.54, 0.625, 6, 15, 17, 0.63, random, seed, pos);
                realY3 = realY3 - height2;
                int startPointY2 = -height2 / 2;//pos.y - startPointY -> block being set
                for (int a = pos2.getY() - startPointY2; a > pos2.getY() - height2; a--) {
                    if (a >= seaLevel) {
                        chunkIn.setBlockState(new BlockPos(pos2.getX(), a, pos2.getZ()), Blocks.AIR.getDefaultState(), false);
                    } else {
                        chunkIn.setBlockState(new BlockPos(pos2.getX(), a, pos2.getZ()), Blocks.WATER.getDefaultState(), false);

                    }

                }
            }

            if (vnoise >= 0.57) {
                BlockPos pos2 = new BlockPos(x, seaLevel + 8 + hvar, z);
                int height2 = getNoiseHeight(vnoise, 0.57, 0.625, 1, 13, 17, 0.63, random, seed, pos);
                realY5 = realY5 - height2;
                int startPointY2 = -height2 / 2;//pos.y - startPointY -> block being set
                for (int a = pos2.getY() - startPointY2; a > pos2.getY() - height2; a--) {
                    if (a >= seaLevel) {
                        chunkIn.setBlockState(new BlockPos(pos2.getX(), a, pos2.getZ()), Blocks.AIR.getDefaultState(), false);
                    } else {
                        chunkIn.setBlockState(new BlockPos(pos2.getX(), a, pos2.getZ()), Blocks.WATER.getDefaultState(), false);

                    }

                }
            }

            if (vnoise >= 0.58) {
                BlockPos pos2 = new BlockPos(x, seaLevel + hvar, z);
                int height2 = getNoiseHeight(vnoise, 0.58, 0.625, 0, 10, 17, 0.63, random, seed, pos);
                realY4 = realY4 - height2;
                int startPointY2 = -height2 / 2;//pos.y - startPointY -> block being set
                for (int a = pos2.getY() - startPointY2; a > pos2.getY() - height2; a--) {
                    if (a >= seaLevel) {
                        chunkIn.setBlockState(new BlockPos(pos2.getX(), a, pos2.getZ()), Blocks.AIR.getDefaultState(), false);
                    } else {
                        chunkIn.setBlockState(new BlockPos(pos2.getX(), a, pos2.getZ()), Blocks.WATER.getDefaultState(), false);

                    }

                }
            }
        }
        config.getConfig().setSeed(seed);
        config.getConfig().buildSurface(random, chunkIn, biomeIn, x, z, realY, noise, defaultBlock, defaultFluid, seaLevel, seed, config);
        config.getConfig().buildSurface(random, chunkIn, biomeIn, x, z, realY1, noise, defaultBlock, defaultFluid, seaLevel, seed, config);
        config.getConfig().buildSurface(random, chunkIn, biomeIn, x, z, realY2, noise, defaultBlock, defaultFluid, seaLevel, seed, config);
        config.getConfig().buildSurface(random, chunkIn, biomeIn, x, z, realY3, noise, defaultBlock, defaultFluid, seaLevel, seed, config);
        config.getConfig().buildSurface(random, chunkIn, biomeIn, x, z, realY4, noise, defaultBlock, defaultFluid, seaLevel, seed, config);
        config.getConfig().buildSurface(random, chunkIn, biomeIn, x, z, realY5, noise, defaultBlock, defaultFluid, seaLevel, seed, config);

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
