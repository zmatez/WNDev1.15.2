package com.matez.wildnature.world.gen.feature.features;

import com.matez.wildnature.Main;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.function.Function;

public class CattailFeature extends Feature<NoFeatureConfig> {
   public CattailFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i51446_1_) {
      super(p_i51446_1_);
      setRegistryName("wildnature","cattail_feature");
   }

   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
      if(!worldIn.getDimension().isSurfaceWorld()){
         return false;
      }
      int i = 0;

      for(int j = 0; j < 60; ++j) {
         BlockPos blockpos = pos.add(rand.nextInt(4) - rand.nextInt(4), 0, rand.nextInt(4) - rand.nextInt(4));
         if (worldIn.isAirBlock(blockpos) && worldIn.getBlockState(blockpos.down()).isSolid()) {
            BlockPos blockpos1 = blockpos.down();
            if (worldIn.getFluidState(blockpos1.west()).isTagged(FluidTags.WATER) || worldIn.getFluidState(blockpos1.east()).isTagged(FluidTags.WATER) || worldIn.getFluidState(blockpos1.north()).isTagged(FluidTags.WATER) || worldIn.getFluidState(blockpos1.south()).isTagged(FluidTags.WATER)) {
               worldIn.setBlockState(blockpos, Main.getBlockByID("wildnature:cattail").getDefaultState().with(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER), 2);
               worldIn.setBlockState(blockpos.up(), Main.getBlockByID("wildnature:cattail").getDefaultState().with(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER), 2);

            }
         }
      }

      return i > 0;
   }
}