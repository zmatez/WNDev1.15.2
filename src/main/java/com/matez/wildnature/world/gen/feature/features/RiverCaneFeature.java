package com.matez.wildnature.world.gen.feature.features;

import com.matez.wildnature.blocks.RiverCaneBush;
import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.lists.WNBlocks;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.function.Function;

public class RiverCaneFeature extends Feature<NoFeatureConfig> {
   public RiverCaneFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i51446_1_) {
      super(p_i51446_1_);
      setRegistryName("wildnature","river_cane_feature");
   }

   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
      if(!worldIn.getDimension().isSurfaceWorld()){
         return false;
      }
      int i = 0;
      int xzDiff = 8;
      int yDiff = 6;
      for(int j = 0; j < CommonConfig.riverCaneDensity.get(); ++j) {
         BlockPos blockpos = pos.add(rand.nextInt(xzDiff) - rand.nextInt(xzDiff), rand.nextInt(yDiff) - rand.nextInt(yDiff), rand.nextInt(xzDiff) - rand.nextInt(xzDiff));
         if (worldIn.isAirBlock(blockpos)) {
            int k = 2 + rand.nextInt(rand.nextInt(3) + 1);
            for(int l = 0; l < k; ++l) {
               if (Blocks.SUGAR_CANE.getDefaultState().isValidPosition(worldIn, blockpos)) {
                  worldIn.setBlockState(blockpos.up(l), Blocks.SUGAR_CANE.getDefaultState(), 2);
                  ++i;
               }
            }
         }
         if (worldIn.getBlockState(blockpos).getBlock()==Blocks.WATER) {
            int k = 2 + rand.nextInt(rand.nextInt(7) + 1);
            for(int l = 0; l < k; ++l) {
               if (WNBlocks.RIVER_CANE.getDefaultState().isValidPosition(worldIn, blockpos)) {
                  if(worldIn.getBlockState(blockpos.up(l)).getBlock()==Blocks.WATER){
                     worldIn.setBlockState(blockpos.up(l), WNBlocks.RIVER_CANE.getDefaultState().with(RiverCaneBush.WATERLOGGED,true), 2);
                  }else {
                     worldIn.setBlockState(blockpos.up(l), WNBlocks.RIVER_CANE.getDefaultState(), 2);
                  }
                  ++i;
               }
            }
         }
      }

      return i > 0;
   }
}