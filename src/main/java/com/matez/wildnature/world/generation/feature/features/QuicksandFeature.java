package com.matez.wildnature.world.generation.feature.features;

import com.matez.wildnature.common.blocks.RiverCaneBush;
import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.config.CommonConfig;
import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.util.other.Utilities;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.placement.CountConfig;

import java.util.Random;
import java.util.function.Function;

public class QuicksandFeature extends Feature<CountConfig> {
   public QuicksandFeature(Function<Dynamic<?>, ? extends CountConfig> p_i51446_1_) {
      super(p_i51446_1_);
      setRegistryName("wildnature","quicksand_feature");
   }

   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, CountConfig config) {
      if(!worldIn.getDimension().isSurfaceWorld()){
         return false;
      }
      int xzDiff = 8;
      int yDiff = 6;
      for(int j = 0; j < config.count; ++j) {
         BlockPos blockpos = pos.add(rand.nextInt(xzDiff) - rand.nextInt(xzDiff), rand.nextInt(yDiff) - rand.nextInt(yDiff), rand.nextInt(xzDiff) - rand.nextInt(xzDiff));
         if (blockpos.getY() > worldIn.getSeaLevel() && (worldIn.isAirBlock(blockpos) || worldIn.getFluidState(blockpos).getFluid() == Fluids.WATER) && worldIn.getBlockState(blockpos.down()).isSolid()) {
            for(int k = 0; k < Utilities.rint(4,12,rand); k++){
               int width = Utilities.rint(4,8,rand)/2;
               int height = Utilities.rint(5,10,rand)/2;
               int depth = Utilities.rint(3,5,rand);

               for(int w = -width; w < width; w++){
                  for(int h = -height; h < height; h++){
                     for(int d = 0; d < depth; d++){
                        BlockPos p = new BlockPos(blockpos.getX() + w, blockpos.getY() - 1 - d, blockpos.getZ() + h);
                        if(worldIn.getBlockState(p).getBlock() == Blocks.SAND) {
                           worldIn.setBlockState(p, WNBlocks.QUICKSAND.getDefaultState(), 2);
                        }
                     }
                  }
               }
            }
            return true;
         }
      }

      return false;
   }
}