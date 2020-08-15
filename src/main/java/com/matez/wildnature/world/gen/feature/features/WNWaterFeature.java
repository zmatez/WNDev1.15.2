package com.matez.wildnature.world.gen.feature.features;

import com.matez.wildnature.other.Utilities;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.CountConfig;

import java.util.Random;
import java.util.function.Function;

public class WNWaterFeature extends Feature<CountConfig> {
   public WNWaterFeature(Function<Dynamic<?>, ? extends CountConfig> p_i49908_1_) {
      super(p_i49908_1_);
      setRegistryName("wildnature","water_feature");
   }

   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, CountConfig config) {
      int i = 0;
      for (int j = 0; j < config.count; ++j) {
         BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
         if (worldIn.isAirBlock(blockpos.up()) && worldIn.getBlockState(blockpos).isSolid() && !Utilities.isUnsolidBlockNear(worldIn,blockpos)) {
            worldIn.setBlockState(blockpos, Blocks.WATER.getDefaultState(), 2);
            ++i;
         }
      }

      return i > 0;
   }
}