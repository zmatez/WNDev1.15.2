package com.matez.wildnature.world.gen.undergroundBiomes.setup.builders;

import com.matez.wildnature.world.gen.noise.sponge.module.source.Perlin;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nullable;
import java.util.Random;

public class URDefaultBiomeBuilder {

    public static BlockState build(long seed, Random rand, BlockPos pos, @Nullable Perlin noise){
        return Blocks.STONE.getDefaultState();
    }

    public static BlockState buildUnderwater(long seed, Random rand, BlockPos pos, @Nullable Perlin noise){
        return build(seed,rand,pos,noise);
    }

}
