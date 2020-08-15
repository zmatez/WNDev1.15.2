package com.matez.wildnature.world.gen.feature.features;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.StoneSpikeBlock;
import com.matez.wildnature.blocks.StoneSpikeType;
import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.function.Function;

public class StalagmiteFeature extends Feature<NoFeatureConfig> {
   public StalagmiteFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i51438_1_) {
      super(p_i51438_1_);
       setRegistryName("wildnature","stalagmite_feature");
   }

   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
       if(!worldIn.getDimension().isSurfaceWorld()){
           return false;
       }
       if(worldIn.getBlockState(pos).isAir()) {
           if (worldIn.getBlockState(pos.down()).isSolid()) {
               worldIn.setBlockState(pos, Main.getBlockByID("wildnature:stone_spike").getDefaultState().with(StoneSpikeBlock.type, StoneSpikeType.STALAGMITE), 2);
               return true;
           } else if (worldIn.getBlockState(pos.up()).isSolid()) {
               worldIn.setBlockState(pos, Main.getBlockByID("wildnature:stone_spike").getDefaultState().with(StoneSpikeBlock.type, StoneSpikeType.STALACTITE), 2);
               return true;
           }
       }
       return false;

   }
}