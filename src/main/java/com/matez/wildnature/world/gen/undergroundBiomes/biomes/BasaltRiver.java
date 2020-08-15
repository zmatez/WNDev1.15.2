package com.matez.wildnature.world.gen.undergroundBiomes.biomes;

import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.world.gen.undergroundBiomes.setup.URBiome;
import com.matez.wildnature.world.gen.undergroundBiomes.setup.URBiomeBuilders;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;

import javax.annotation.Nullable;
import java.util.Random;

public class BasaltRiver extends URBiome {
    public BasaltRiver(String name, @Nullable Biome.Category category, @Nullable Biome.TempCategory tempCategory, int rarity, float fogDensity) {
        super(name, category,tempCategory, rarity, fogDensity,0x000000,0x000000);
        elevationNoise.setFrequency(0.1);
    }

    @Override
    public BlockState getElevationBlock(long seed,Random rand, BlockPos pos) {
        return URBiomeBuilders.TRIPLE_NOISE.build(Blocks.STONE.getDefaultState(),WNBlocks.BASALT_ROCK.getDefaultState(),WNBlocks.SLATE_ROCK.getDefaultState(),seed,rand,pos,elevationNoise);
    }


}
