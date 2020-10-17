package com.matez.wildnature.world.gen.generators.carves;

import com.matez.wildnature.commands.LocatePath;
import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.world.gen.noise.OpenSimplex2S;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraftforge.common.BiomeDictionary;

public class PathGenerator {
    private final OpenSimplex2S pathNoise;
    public PathGenerator(IWorld worldIn){
        this.pathNoise =new OpenSimplex2S(worldIn.getSeed());
    }

    public void generate(int x, int y, int z, Biome biome, IChunk chunkIn){
        if(CommonConfig.generatePaths.get()) {
            double[] noises = getPathNoise(x,z,0.005, 0.01, 0.001,50,1);
            double vnoise = noises[0];
            double cnoise = noises[1];

            if (vnoise != 1) {
                if (BiomeDictionary.getTypes(biome).contains(BiomeDictionary.Type.FOREST) && BiomeDictionary.getTypes(biome).contains(BiomeDictionary.Type.DENSE)) {
                    int pathY = y;
                    //double amountToPushTerrainDownBy = 1 - vnoise / threshold;
                    Block theme = biome.getSurfaceBuilderConfig().getTop().getBlock();

                    BlockState b = chunkIn.getBlockState(new BlockPos(x, y - 1, z));
                    Block toPlace = null;
                    if (b.getBlock() == WNBlocks.MOLD_GRASS_BLOCK) {
                        toPlace = WNBlocks.MOLD_GRASS_PATH;
                    } else if (b.getBlock() == WNBlocks.BROWN_GRASS_BLOCK) {
                        toPlace = WNBlocks.BROWN_GRASS_PATH;
                    } else if (b.getBlock() == WNBlocks.DRIED_GRASS_BLOCK) {
                        toPlace = WNBlocks.DRIED_GRASS_PATH;
                    } else if (b.getBlock() == WNBlocks.DESERT_GRASS_BLOCK) {
                        toPlace = WNBlocks.DESERT_GRASS_PATH;
                    } else if (b.getBlock() == WNBlocks.TROPICAL_GRASS_BLOCK) {
                        toPlace = WNBlocks.TROPICAL_GRASS_PATH;
                    } else if (b.getBlock() == WNBlocks.BROWN_PODZOL) {
                        toPlace = WNBlocks.BROWN_GRASS_PATH;
                    } else if (b.getBlock() == Blocks.GRASS_BLOCK) {
                        toPlace = Blocks.GRASS_PATH;
                    } else if (b.getBlock() == Blocks.PODZOL) {
                        if (theme == WNBlocks.MOLD_GRASS_BLOCK) {
                            toPlace = WNBlocks.MOLD_GRASS_PATH;
                        } else if (theme == WNBlocks.BROWN_GRASS_BLOCK) {
                            toPlace = WNBlocks.BROWN_GRASS_PATH;
                        } else if (theme == WNBlocks.DRIED_GRASS_BLOCK) {
                            toPlace = WNBlocks.DRIED_GRASS_PATH;
                        } else if (theme == WNBlocks.DESERT_GRASS_BLOCK) {
                            toPlace = WNBlocks.DESERT_GRASS_PATH;
                        } else if (theme == WNBlocks.TROPICAL_GRASS_BLOCK) {
                            toPlace = WNBlocks.TROPICAL_GRASS_PATH;
                        } else if (theme == WNBlocks.BROWN_PODZOL) {
                            toPlace = WNBlocks.BROWN_GRASS_PATH;
                        } else {
                            toPlace = Blocks.GRASS_PATH;
                        }
                    } else if (b.getBlock() == Blocks.COARSE_DIRT) {
                        if (theme == WNBlocks.MOLD_GRASS_BLOCK) {
                            toPlace = WNBlocks.MOLD_GRASS_PATH;
                        } else if (theme == WNBlocks.BROWN_GRASS_BLOCK) {
                            toPlace = WNBlocks.BROWN_GRASS_PATH;
                        } else if (theme == WNBlocks.DRIED_GRASS_BLOCK) {
                            toPlace = WNBlocks.DRIED_GRASS_PATH;
                        } else if (theme == WNBlocks.DESERT_GRASS_BLOCK) {
                            toPlace = WNBlocks.DESERT_GRASS_PATH;
                        } else if (theme == WNBlocks.TROPICAL_GRASS_BLOCK) {
                            toPlace = WNBlocks.TROPICAL_GRASS_PATH;
                        } else if (theme == WNBlocks.BROWN_PODZOL) {
                            toPlace = WNBlocks.BROWN_GRASS_PATH;
                        } else {
                            toPlace = Blocks.GRASS_PATH;
                        }
                    }

                    if (toPlace != null) {
                        if (Utilities.rint(0, 5) != 0) {
                            chunkIn.setBlockState(new BlockPos(x, pathY - 1, z), toPlace.getDefaultState(), false);
                        }
                        if (Utilities.rint(0, 15) == 0) {
                            chunkIn.setBlockState(new BlockPos(x, pathY - 1, z), Blocks.GRAVEL.getDefaultState(), false);
                        }
                        if (Utilities.rint(0, 30) == 0) {
                            LocatePath.paths.add(new BlockPos(x, pathY, z));
                        }
                    }

                }
            }
        }
    }

    /**
     *
     * @param x x
     * @param z z
     * @param freq frequency, def 0.005
     * @param threshold def 0.01
     * @param noiseMultiplier def 50
     * @return noise, centerNoise
     */
    private double[] getPathNoise(int x, int z, double freq, double threshold, double centerThreshold, double noiseMultiplier, double centerNoiseMultiplier){
        OpenSimplex2S.Values2D1 results = new OpenSimplex2S.Values2D1();
        pathNoise.noise2(x* freq, z* freq, results);

        double slope = Math.sqrt(results.dx*results.dx + results.dy*results.dy);
        double estDistanceToZero = Math.abs(results.value / slope);
        double vnoise = 1;
        if (estDistanceToZero < threshold) {
            vnoise = -(estDistanceToZero*noiseMultiplier);
        };
        double cnoise = 1;
        if (estDistanceToZero < centerThreshold) {
            cnoise = -(estDistanceToZero*centerNoiseMultiplier);
        };
        return new double[]{vnoise,cnoise};
    }

}
