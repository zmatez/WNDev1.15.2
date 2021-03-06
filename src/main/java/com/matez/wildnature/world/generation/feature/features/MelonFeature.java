package com.matez.wildnature.world.generation.feature.features;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.GrassBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.function.Function;

public class MelonFeature extends Feature<NoFeatureConfig> {
   public MelonFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i51479_1_) {
      super(p_i51479_1_);
      setRegistryName("wildnature","melon_feature");
   }

   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
      for(int i = 0; i < 64; ++i) {
         BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
         BlockState blockstate = Blocks.MELON.getDefaultState();
         if (worldIn.getBlockState(blockpos).getMaterial().isReplaceable() && worldIn.getBlockState(blockpos.down()).getBlock() instanceof GrassBlock) {
            worldIn.setBlockState(blockpos, blockstate, 2);
         }
      }

      return true;
   }
}