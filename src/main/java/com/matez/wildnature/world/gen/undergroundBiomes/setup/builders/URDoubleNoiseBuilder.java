package com.matez.wildnature.world.gen.undergroundBiomes.setup.builders;

import com.matez.wildnature.world.gen.noise.sponge.module.source.Perlin;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nullable;
import java.util.Random;

public class URDoubleNoiseBuilder {

    public static BlockState build(BlockState block1, BlockState block2, long seed, Random rand, BlockPos pos, @Nullable Perlin noise){
        assert noise!=null;
        noise.setSeed((int)seed);
        double enoise = noise.getValue(pos.getX(),pos.getY(),pos.getZ());
        if(enoise<0.49){
            return block1;
        }else{
            return block2;
        }
    }

    public static BlockState buildUnderwater(BlockState block1, BlockState block2, long seed, Random rand, BlockPos pos, @Nullable Perlin noise){
        return build(block1,block2,seed,rand,pos,noise);
    }

}
