package com.matez.wildnature.world.gen.undergroundBiomes.biomes;

import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.world.gen.undergroundBiomes.setup.URBiome;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;

import javax.annotation.Nullable;
import java.util.Random;

public class CrystalRiver extends URBiome {
    public CrystalRiver(String name, @Nullable Biome.Category category,@Nullable Biome.TempCategory tempCategory, int rarity, float fogDensity) {
        super(name, category,tempCategory, rarity, fogDensity,0x000000,0x000000);
    }

    @Override
    public BlockState getElevationBlock(long seed,Random rand, BlockPos pos) {
        if(Utilities.rint(0,1,rand)==0){
            return WNBlocks.MARBLE_ROCK.getDefaultState();
        }else{
            return WNBlocks.CONGLOMERATE_ROCK.getDefaultState();

        }
    }



    @Override
    public int getNoiseHeight(double noise, double minNoise, double maxNoise, int minHeight, int maxHeight, int maxHeightIfCavern, double cavernWhenNoise, Random random,long seed, BlockPos pos) {
        this.elevationNoise.setSeed((int)seed);
        int oldNoise = super.getNoiseHeight(noise, minNoise, maxNoise, minHeight, maxHeight,maxHeightIfCavern,cavernWhenNoise, random,seed,pos);

        if(Utilities.rint(0,1,random)==0){
            return Utilities.rint((int) Math.round((double) oldNoise / 3.333), oldNoise, random);
        }
        return oldNoise;
    }

}
