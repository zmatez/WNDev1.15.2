package com.matez.wildnature.world.gen.feature.features;

import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.world.gen.feature.configs.BlockWeightListConfig;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;
import java.util.function.Function;

public class MushroomFeature extends Feature<BlockWeightListConfig> {
    public MushroomFeature(Function<Dynamic<?>, ? extends BlockWeightListConfig> p_i49869_1_) {
        super(p_i49869_1_);
        setRegistryName("wildnature","mushroom_feature");
    }

    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, BlockWeightListConfig config) {
        if(!worldIn.getDimension().isSurfaceWorld()){
            return false;
        }
        BlockState state = Utilities.getWeighBlock(config.list);
        if(state==null){
            return false;
        }
        for(BlockState blockstate = worldIn.getBlockState(pos); (blockstate.isAir() || pos.getY() > 0); blockstate = worldIn.getBlockState(pos)) {
            pos = pos.down();
        }

        int i = 0;

        for(int j = 0; j < 32; ++j) {
            BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
            try {
                if (worldIn.isAirBlock(blockpos) && state.isValidPosition(worldIn, blockpos)) {
                    worldIn.setBlockState(blockpos, state, 2);
                    ++i;
                }
            }catch(NullPointerException e){}
        }

        return i > 0;
    }


}
