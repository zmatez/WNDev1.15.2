package com.matez.wildnature.world.generation.structures.nature;

import com.matez.wildnature.util.other.TreeWeighList;
import com.matez.wildnature.util.other.Utilities;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Random;

public class SchemTree {

    private final TreeWeighList weighList;

    public SchemTree(TreeWeighList weight) {
        weighList = weight;
    }

    @Nullable
    public SchemFeature getTreeFeature(Random random) {
        return Utilities.getWeighTree(weighList, random);
    }

    public boolean spawn(ServerWorld worldIn, BlockPos pos, BlockState blockUnder, Random random) {
        SchemFeature abstracttreefeature = this.getTreeFeature(random);
        if (abstracttreefeature == null) {
            return false;
        } else {
            worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 4);
            return abstracttreefeature.place(worldIn, worldIn.getChunkProvider().getChunkGenerator(), random, pos, IFeatureConfig.NO_FEATURE_CONFIG);
        }
    }


}
