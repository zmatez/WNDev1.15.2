package com.matez.wildnature.world.generation.generators.carves;

import com.matez.wildnature.common.commands.LocatePath;
import com.matez.wildnature.util.config.CommonConfig;
import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.util.other.Utilities;
import com.matez.wildnature.world.generation.grid.Cell;
import com.matez.wildnature.world.generation.noise.OpenSimplex2S;
import com.matez.wildnature.world.generation.noise.sponge.module.source.Perlin;
import com.matez.wildnature.world.generation.noise.sponge.module.source.RidgedMulti;
import com.matez.wildnature.world.generation.undergroundBiomes.setup.URBiome;
import com.matez.wildnature.world.generation.undergroundBiomes.setup.URBiomeManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraftforge.common.BiomeDictionary;

import java.util.Random;

public class UndergroundRiverGenerator {
    private final RidgedMulti ridgedMultiNoise;
    private static RidgedMulti ridgedMultiNoiseCopy;
    private final Perlin perlinNoise, biomeNoise;
    private IWorld world;
    private Random random;
    public UndergroundRiverGenerator(IWorld worldIn){
        this.ridgedMultiNoise =new RidgedMulti();
        ridgedMultiNoise.setSeed((int)worldIn.getSeed());
        ridgedMultiNoise.setFrequency(0.005);
        ridgedMultiNoise.setOctaveCount(1);
        ridgedMultiNoise.setLacunarity(0.0);
        ridgedMultiNoiseCopy = ridgedMultiNoise;
        this.perlinNoise = new Perlin();
        perlinNoise.setSeed((int)worldIn.getSeed());
        perlinNoise.setFrequency(0.1);
        perlinNoise.setOctaveCount(2);
        perlinNoise.setLacunarity(0.0);
        perlinNoise.setPersistence(-0.4);
        this.biomeNoise = new Perlin();
        biomeNoise.setSeed((int)worldIn.getSeed());
        biomeNoise.setFrequency(0.002);
        biomeNoise.setOctaveCount(2);
        biomeNoise.setLacunarity(0.0);
        biomeNoise.setPersistence(0.0);

        this.world = worldIn;
        this.random = new Random(worldIn.getSeed());
    }

    public static RidgedMulti getRidgedMultiNoiseCopy() {
        return ridgedMultiNoiseCopy;
    }

    public void generate(int x, int y, int z, Cell cell, Biome biome, IChunk chunkIn){
        if(CommonConfig.generateUndergroundRivers.get()) {
            URBiome riverBiome = URBiomeManager.getBiomeAt(chunkIn,new BlockPos(x,1,z),world.getSeed(),cell.undergroundBiomeCellIdentity);

            double vnoise = ridgedMultiNoise.getValue(x, 1, z);
            if (vnoise >= 0.60 && vnoise <= 2) {
                BlockPos pos = new BlockPos(x, 13, z);
                int height = riverBiome.getNoiseHeight(vnoise, 0.60,  0.625,1, 10,17,0.63,random,world.getSeed(),pos);
                if(height==10 || height==9){
                    double pnoise = perlinNoise.getValue(x, 1, z);
                    if(pnoise>=0.3){
                        height=height+1;
                        if(pnoise>=0.38){
                            height=height+1;
                        }
                    }else if(pnoise<0.16){
                        height=height-1;
                    }
                }
                int startPointY = -(int) height / 2;//pos.y - startPointY -> block being set
                for (int a = pos.getY() - startPointY; a > pos.getY() - height; a--) {
                    if (a > 10) {
                        chunkIn.setBlockState(new BlockPos(pos.getX(), a, pos.getZ()), Blocks.CAVE_AIR.getDefaultState(), false);
                    } else {
                        chunkIn.setBlockState(new BlockPos(pos.getX(), a, pos.getZ()), Blocks.WATER.getDefaultState(), false);

                    }

                }
            }

            if (vnoise >= 0.58 && vnoise <= 2) {
                BlockPos pos = new BlockPos(x, 13, z);
                if((riverBiome.getElevationBlock(world.getSeed(),random,pos).getBlock()!=Blocks.STONE || riverBiome.getUnderwaterBlock(world.getSeed(),random,pos).getBlock()!=Blocks.STONE)) {

                    int height = riverBiome.getNoiseHeight(vnoise, 0.59, 0.635, 1, 13,17,0.64,random,world.getSeed(),pos);
                    int startPointY = -(int) height / 2;//pos.y - startPointY -> block being set
                    for (int a = pos.getY() - startPointY; a > pos.getY() - height; a--) {
                        riverBiome.elevate(pos,a,chunkIn,random,world.getSeed());
                    }
                }
            }
        }
    }
}
