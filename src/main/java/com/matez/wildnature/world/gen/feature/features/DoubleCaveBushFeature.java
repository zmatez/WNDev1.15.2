package com.matez.wildnature.world.gen.feature.features;

import com.matez.wildnature.world.gen.feature.configs.ReverseBushConfig;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;
import java.util.function.Function;

public class DoubleCaveBushFeature extends Feature<ReverseBushConfig> {
   public DoubleCaveBushFeature(Function<Dynamic<?>, ? extends ReverseBushConfig> p_i49908_1_) {
      super(p_i49908_1_);
      setRegistryName("wildnature","double_cave_bush_feature");
   }

   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, ReverseBushConfig config) {
      if(!worldIn.getDimension().isSurfaceWorld()){
         return false;
      }
      int i = 0;
      BlockState blockstate = config.state;

      for(int j = 0; j < 8; ++j) {
         BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
         if (worldIn.isAirBlock(blockpos) && (!worldIn.getDimension().isNether() || blockpos.getY() < worldIn.getWorld().getDimension().getHeight()) && blockstate.isValidPosition(worldIn, blockpos) && blockstate.getBlock() instanceof DoublePlantBlock) {
            if(config.reverse){
               worldIn.setBlockState(blockpos, blockstate.with(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER), 2);
               worldIn.setBlockState(blockpos.down(), blockstate.with(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER), 2);
            }else {
               worldIn.setBlockState(blockpos, blockstate.with(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER), 2);
               worldIn.setBlockState(blockpos.up(), blockstate.with(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER), 2);
            }
            ++i;
         }
      }

      return i > 0;
   }
}