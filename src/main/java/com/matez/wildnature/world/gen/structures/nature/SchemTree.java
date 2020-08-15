package com.matez.wildnature.world.gen.structures.nature;

import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.other.TreeWeighList;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.trees.Tree;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Random;

public class SchemTree {

    private TreeWeighList weighList;
    public SchemTree(TreeWeighList weight){
        weighList = weight;
    }

    @Nullable
    public SchemFeature getTreeFeature(Random random) {
        return Utilities.getWeighTree(weighList,random);
    }

    public boolean spawn(ServerWorld worldIn, BlockPos pos, BlockState blockUnder, Random random) {
        SchemFeature abstracttreefeature = this.getTreeFeature(random);
        if (abstracttreefeature == null) {
            return false;
        } else {
            worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 4);
            if (abstracttreefeature.place(worldIn, worldIn.getChunkProvider().getChunkGenerator(), random, pos, IFeatureConfig.NO_FEATURE_CONFIG)) {
                return true;
            } else {
                return false;
            }
        }
    }
}
