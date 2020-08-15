package com.matez.wildnature.world.gen.feature.features;

import com.matez.wildnature.blocks.ReedsBlock;
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

public class ReedsFeature extends Feature<NoFeatureConfig> {
   public ReedsFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i51446_1_) {
      super(p_i51446_1_);
      setRegistryName("wildnature","reeds_feature");
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
         if ((worldIn.getBlockState(blockpos).getBlock()==Blocks.WATER ||
                 worldIn.getBlockState(blockpos.down().north()).getBlock()==Blocks.WATER ||
                 worldIn.getBlockState(blockpos.down().east()).getBlock()==Blocks.WATER ||
                 worldIn.getBlockState(blockpos.down().south()).getBlock()==Blocks.WATER ||
                 worldIn.getBlockState(blockpos.down().west()).getBlock()==Blocks.WATER) && WNBlocks.REEDS.isValidPosition(WNBlocks.REEDS.getDefaultState(),worldIn,blockpos)) {
            ((ReedsBlock)WNBlocks.REEDS).placeAt(worldIn,blockpos,2);
            ++i;
         }

      }

      return i > 0;
   }
}