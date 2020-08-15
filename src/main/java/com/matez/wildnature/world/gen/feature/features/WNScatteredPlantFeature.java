package com.matez.wildnature.world.gen.feature.features;

import com.matez.wildnature.world.gen.feature.configs.BlockFeatureConfig;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.GrassBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;
import java.util.function.Function;

public class WNScatteredPlantFeature extends Feature<BlockFeatureConfig> {

   public WNScatteredPlantFeature(Function<Dynamic<?>, ? extends BlockFeatureConfig> configFactoryIn) {
      super(configFactoryIn);
      setRegistryName("wildnature","scattered_plant_feature");
   }

   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, BlockFeatureConfig config) {
      int i = 0;

      for(int j = 0; j < 64; ++j) {
         BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
         if (worldIn.isAirBlock(blockpos) && worldIn.getBlockState(blockpos.down()).getBlock() instanceof GrassBlock) {
            worldIn.setBlockState(blockpos, config.state, 2);
            ++i;
         }
      }

      return i > 0;
   }
}