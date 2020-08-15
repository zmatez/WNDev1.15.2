package com.matez.wildnature.world.gen.undergroundBiomes.setup;

import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.world.gen.undergroundBiomes.setup.builders.URDefaultBiomeBuilder;
import com.matez.wildnature.world.gen.noise.sponge.module.source.Perlin;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;

import javax.annotation.Nullable;
import java.util.Random;

public class URBiome {

    public Biome.Category category;
    public Biome.TempCategory tempCategory;
    public String name;
    public int waterColor, waterFogColor;
    public int rarity;
    public float fogDensity;
    public Perlin elevationNoise = new Perlin();
    public URBiome(String name, @Nullable Biome.Category category, @Nullable Biome.TempCategory tempCategory, int rarity, float fogDensity, int waterColor, int waterFogColor){
        this.name=name;
        this.category=category;
        this.tempCategory=tempCategory;
        this.rarity=rarity;
        this.fogDensity=fogDensity;
        this.waterColor=waterColor;
        this.waterFogColor=waterFogColor;
        this.elevationNoise.setFrequency(0.1);
        this.elevationNoise.setLacunarity(0.0);
        this.elevationNoise.setPersistence(0.0);
        this.elevationNoise.setOctaveCount(1);
    }

    public Biome.TempCategory getTempCategory() {
        return tempCategory;
    }

    public int getWaterFogColor() {
        return waterFogColor;
    }

    public int getWaterColor() {
        return waterColor;
    }

    public String getName() {
        return name;
    }

    public int getRarity() {
        return rarity;
    }

    public Biome.Category getCategory() {
        return category;
    }

    public float getFogDensity() {
        return fogDensity;
    }

    public BlockState getElevationBlock(long seed, Random rand, BlockPos pos){
        return URDefaultBiomeBuilder.build(seed,rand,pos,elevationNoise);
    }

    public BlockState getUnderwaterBlock(long seed, Random rand, BlockPos pos){
        return getElevationBlock(seed,rand,pos);
    }

    public void elevate(BlockPos pos, int a, IChunk chunkIn, Random random, long seed){
        if (chunkIn.getBlockState(new BlockPos(pos.getX(), a, pos.getZ())).getBlock()==Blocks.STONE) {
            if(a>10) {
                chunkIn.setBlockState(new BlockPos(pos.getX(), a, pos.getZ()), this.getElevationBlock(seed,random,pos), false);
            }else if(a==10){
                if(Utilities.rint(0,1)==0){
                    chunkIn.setBlockState(new BlockPos(pos.getX(), a, pos.getZ()), this.getElevationBlock(seed,random,pos), false);
                }else{
                    chunkIn.setBlockState(new BlockPos(pos.getX(), a, pos.getZ()), this.getUnderwaterBlock(seed,random,pos), false);
                }
            }else{
                chunkIn.setBlockState(new BlockPos(pos.getX(), a, pos.getZ()), this.getUnderwaterBlock(seed,random,pos), false);
            }
        }
    }

    public int getNoiseHeight(double noise, double minNoise, double maxNoise, int minHeight, int maxHeight, int maxHeightIfCavern, double cavernWhenNoise, Random random, long seed, BlockPos pos){
        return calculateHeightByCenter(noise,minNoise,maxNoise,minHeight,maxHeight,maxHeightIfCavern,cavernWhenNoise);
    }



    /**
     *
     * @param noise actual noise, example: 29.23141283 (?%)
     * @param minNoise minimal noise, example: 28.0 (its 0%)
     * @param maxNoise maximal noise, example: 29.999999 (its 100%)
     * @param minHeight min height example: 1
     * @param maxHeight max height example: 6
     * @return
     */
    public int calculateHeightByCenter(double noise, double minNoise, double maxNoise, int minHeight, int maxHeight, int maxHeightIfCavern, double cavernWhenNoise){
        double noiseCenter = ((maxNoise-minNoise)/2)+minNoise;//28.99999995
        double noisePercent = 0;

        if(noiseCenter>noise) {
            noisePercent = calculatePercent(noise, minNoise, noiseCenter);
        }else if(noiseCenter<noise){
            if(noise>cavernWhenNoise){
                noisePercent = calculatePercent(noise, maxHeightIfCavern, noiseCenter);
            }else {
                noisePercent = calculatePercent(noise, maxHeight, noiseCenter);
            }
        }else{
            noisePercent = 1;
        }

        int maxHeightCalc = maxHeight-minHeight;//5
        double height = maxHeightCalc*noisePercent;//3.05

        return (int)Math.round(height)+minHeight;//4.05 - returns 4
    }

    private double calculatePercent(double noise, double minNoise, double maxNoise) {
        double maxNoiseCalc = maxNoise - minNoise;//1.999999
        double noiseCalc = noise - minNoise;//1.23141283
        return noiseCalc / maxNoiseCalc;//0.61(%)
    }

    /**
     *
     * @param noise actual noise, example: 29.23141283 (?%)
     * @param minNoise minimal noise, example: 28.0 (its 0%)
     * @param maxNoise maximal noise, example: 29.999999 (its 100%)
     * @param minHeight min height example: 1
     * @param maxHeight max height example: 6
     * @return
     */
    /*private int calculateHeight(double noise, double minNoise, double maxNoise, int minHeight, int maxHeight){
        double maxNoiseCalc = maxNoise-minNoise;//1.999999
        double noiseCalc = noise-minNoise;//1.23141283
        double noisePercent = noiseCalc/maxNoiseCalc;//0.61(%)

        int maxHeightCalc = maxHeight-minHeight;//5
        double height = maxHeightCalc*noisePercent;//3.05

        return (int)Math.round(height)+minHeight;//4.05 - returns 4
    }*/
}
