package com.matez.wildnature.world.generation.feature.features;

import com.matez.wildnature.common.blocks.JellyShroomBlock;
import com.matez.wildnature.world.generation.feature.configs.BlockFeatureConfig;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;
import java.util.function.Function;

public class JellyshroomFeature extends Feature<BlockFeatureConfig> {
   public JellyshroomFeature(Function<Dynamic<?>, ? extends BlockFeatureConfig> p_i49908_1_) {
      super(p_i49908_1_);
      setRegistryName("wildnature","jellyshroom_feature");
   }

   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, BlockFeatureConfig config) {
      if(!worldIn.getDimension().isSurfaceWorld()){
         return false;
      }
      int i = 0;
      BlockState blockstate = config.state;

      for(int j = 0; j < 8; ++j) {
         BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
         if ((worldIn.isAirBlock(blockpos) || worldIn.getFluidState(blockpos).getFluid()== Fluids.WATER) && (!worldIn.getDimension().isNether() || blockpos.getY() < worldIn.getWorld().getDimension().getHeight()) && blockstate.isValidPosition(worldIn, blockpos)) {
            worldIn.setBlockState(blockpos, blockstate.with(JellyShroomBlock.WATERLOGGED,worldIn.getFluidState(blockpos).getFluid()==Fluids.WATER), 2);

            ++i;
         }
      }

      return i > 0;
   }
}