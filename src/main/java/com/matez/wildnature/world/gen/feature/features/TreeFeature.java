package com.matez.wildnature.world.gen.feature.features;

import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.world.gen.feature.configs.TreeWeightListConfig;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.function.Function;

public class TreeFeature extends Feature<TreeWeightListConfig> {
    public TreeFeature(Function<Dynamic<?>, ? extends TreeWeightListConfig> p_i49869_1_) {
        super(p_i49869_1_);
        setRegistryName("wildnature","tree_feature");
    }

    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, TreeWeightListConfig config) {
        if(!worldIn.getDimension().isSurfaceWorld()){
            return false;
        }
        SchemFeature feature = Utilities.getWeighTree(config.list);
        return feature != null && feature.place(worldIn, generator, rand, pos, new NoFeatureConfig());
    }
}
