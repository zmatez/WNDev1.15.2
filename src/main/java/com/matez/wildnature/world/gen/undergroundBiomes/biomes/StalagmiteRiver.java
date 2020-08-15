package com.matez.wildnature.world.gen.undergroundBiomes.biomes;

import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.world.gen.undergroundBiomes.setup.URBiome;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;

import javax.annotation.Nullable;
import java.util.Random;

public class StalagmiteRiver extends URBiome {
    public StalagmiteRiver(String name, @Nullable Biome.Category category, @Nullable Biome.TempCategory tempCategory, int rarity, float fogDensity, int waterColor, int waterFogColor) {
        super(name, category, tempCategory, rarity, fogDensity, waterColor, waterFogColor);
    }

    @Override
    public int getNoiseHeight(double noise, double minNoise, double maxNoise, int minHeight, int maxHeight, int maxHeightIfCavern, double cavernWhenNoise, Random random, long seed, BlockPos pos) {
        this.elevationNoise.setSeed((int)random.nextInt());
        double enoise = this.elevationNoise.getValue(pos.getX(),pos.getY(),pos.getZ());
        int oldNoise = super.getNoiseHeight(noise, minNoise, maxNoise, minHeight, maxHeight,maxHeightIfCavern,cavernWhenNoise, random,seed,pos);

        if(enoise>0.54) {
            if(Utilities.rint(0,8,random)==0){
                return Utilities.rint(0,2,random);
            }else {
                return Utilities.rint((int) Math.round((double) oldNoise / Utilities.rdoub(1.5,3.5)), oldNoise, random);
            }
        }
        return oldNoise;
    }
}
