package com.matez.wildnature.world.gen.feature.features;

import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.world.gen.feature.configs.StructureWeightListConfig;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.function.Function;

public class StructureFeature extends Feature<StructureWeightListConfig> {
    public StructureFeature(Function<Dynamic<?>, ? extends StructureWeightListConfig> p_i49869_1_) {
        super(p_i49869_1_);
        setRegistryName("wildnature","structure_feature");
    }

    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, StructureWeightListConfig config) {
        if(!worldIn.getDimension().isSurfaceWorld()){
            return false;
        }
        SchemFeature feature = (SchemFeature)Utilities.getWeightedEntry(config.list);
        return feature != null && feature.place(worldIn, generator, rand, pos, new NoFeatureConfig());
    }
}
