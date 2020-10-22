package com.matez.wildnature.world.generation.undergroundBiomes.biomes;

import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.world.generation.undergroundBiomes.setup.URBiome;
import com.matez.wildnature.world.generation.undergroundBiomes.setup.URBiomeBuilders;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;

import javax.annotation.Nullable;
import java.util.Random;

public class IcyRiver extends URBiome {
    public IcyRiver(String name, @Nullable Biome.Category category, @Nullable Biome.TempCategory tempCategory, int rarity, float fogDensity, int waterColor, int waterFogColor) {
        super(name, category,tempCategory, rarity, fogDensity,waterColor,waterFogColor);
        elevationNoise.setFrequency(0.1);
    }

    @Override
    public BlockState getElevationBlock(long seed,Random rand, BlockPos pos) {
        return URBiomeBuilders.QUADRUPLE_NOISE.build(Blocks.STONE.getDefaultState(),WNBlocks.GNEISS.getDefaultState(),Blocks.PACKED_ICE.getDefaultState(),WNBlocks.MARBLE.getDefaultState(),seed,rand,pos,elevationNoise);
    }


}
