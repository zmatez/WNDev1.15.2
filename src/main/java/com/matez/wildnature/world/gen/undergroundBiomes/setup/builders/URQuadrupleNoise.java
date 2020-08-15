package com.matez.wildnature.world.gen.undergroundBiomes.setup.builders;

import com.matez.wildnature.world.gen.noise.sponge.module.source.Perlin;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nullable;
import java.util.Random;

public class URQuadrupleNoise {

    public static BlockState build(BlockState block1, BlockState block2, BlockState block3,BlockState block4, long seed, Random rand, BlockPos pos, @Nullable Perlin noise){
        assert noise!=null;
        noise.setSeed((int)seed);
        double enoise = noise.getValue(pos.getX(),pos.getY(),pos.getZ());

        if(enoise<0.465){
            return block1;
        }else if(enoise>=0.455 && enoise<0.50){
            return block2;
        }else if(enoise>=0.50 && enoise<0.56){
            return block3;
        }else{
            return block4;
        }
    }

    public static BlockState buildUnderwater(BlockState block1, BlockState block2, BlockState block3,BlockState block4, long seed, Random rand, BlockPos pos, @Nullable Perlin noise){
        return build(block1,block2,block3,block4,seed,rand,pos,noise);
    }

}
