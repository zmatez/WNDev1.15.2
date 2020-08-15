package com.matez.wildnature.world.gen.undergroundBiomes.biomes;

import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.world.gen.undergroundBiomes.setup.URBiome;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;

import javax.annotation.Nullable;
import java.util.Random;

public class SkeletonRiver extends URBiome {
    public SkeletonRiver(String name, @Nullable Biome.Category category, @Nullable Biome.TempCategory tempCategory, int rarity, float fogDensity) {
        super(name, category,tempCategory, rarity, fogDensity,0x000000,0x000000);
    }

    @Override
    public BlockState getElevationBlock(long seed,Random rand, BlockPos pos) {
        /*this.elevationNoise.setSeed((int)seed);
        double enoise = this.elevationNoise.getValue(pos.getX(),pos.getY(),pos.getZ());
        if(enoise>0.49){
            return Blocks.BONE_BLOCK.getDefaultState();
        }else{
            if(enoise<0.44){
                return WNBlocks.BASALT_ROCK.getDefaultState();
            }else{
                return WNBlocks.SLATE_ROCK.getDefaultState();
            }
        }*/
        return Blocks.BONE_BLOCK.getDefaultState();
    }



    @Override
    public int getNoiseHeight(double noise, double minNoise, double maxNoise, int minHeight, int maxHeight, int maxHeightIfCavern, double cavernWhenNoise, Random random,long seed, BlockPos pos) {
        this.elevationNoise.setSeed((int)random.nextInt());
        double enoise = this.elevationNoise.getValue(pos.getX(),pos.getY(),pos.getZ());
        int oldNoise = super.getNoiseHeight(noise, minNoise, maxNoise, minHeight, maxHeight,maxHeightIfCavern,cavernWhenNoise, random,seed,pos);

        if(enoise>0.49) {
            if(Utilities.rint(0,8,random)==0){
                return Utilities.rint(0,2,random);
            }else {
                return Utilities.rint((int) Math.round((double) oldNoise / 4.5), oldNoise, random);
            }
        }
        return oldNoise;
    }

}
