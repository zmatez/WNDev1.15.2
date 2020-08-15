package com.matez.wildnature.world.gen.feature.features;

import com.matez.wildnature.world.gen.feature.configs.BlockFeatureConfig;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;
import java.util.function.Function;

public class GrassFeature extends Feature<BlockFeatureConfig> {
   public GrassFeature(Function<Dynamic<?>, ? extends BlockFeatureConfig> p_i49869_1_) {
      super(p_i49869_1_);
      setRegistryName("wildnature","grass_feature");
   }

   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, BlockFeatureConfig config) {
      for(BlockState blockstate = worldIn.getBlockState(pos); (blockstate.isAir() || blockstate.isIn(BlockTags.LEAVES)) && pos.getY() > 0; blockstate = worldIn.getBlockState(pos)) {
         pos = pos.down();
      }

      int i = 0;

      for(int j = 0; j < 128; ++j) {
         BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
         if (worldIn.isAirBlock(blockpos) && config.state.isValidPosition(worldIn, blockpos)) {
            worldIn.setBlockState(blockpos, config.state, 2);
            ++i;
         }
      }

      return i > 0;
   }
}