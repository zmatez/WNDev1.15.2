package com.matez.wildnature.world.generation.feature.features;

import com.matez.wildnature.common.blocks.CaveStarBlock;
import com.matez.wildnature.world.generation.feature.configs.BlockFeatureConfig;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Function;

public class CaveStarFeature extends Feature<BlockFeatureConfig> {
   private ArrayList<Direction> allowedDirections = new ArrayList<>();

   public CaveStarFeature(Function<Dynamic<?>, ? extends BlockFeatureConfig> p_i49908_1_) {
      super(p_i49908_1_);
      allowedDirections.addAll(Arrays.asList(Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST));
      allowedDirections.add(Direction.UP);
      setRegistryName("wildnature","cave_star_feature");
   }

   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, BlockFeatureConfig config) {
      if(!worldIn.getDimension().isSurfaceWorld()){
         return false;
      }
      int i = 0;
      BlockState blockstate = config.state;

      for(int j = 0; j < 64; ++j) {
         for (Direction allowedDirection : allowedDirections) {
            BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
            BlockPos checkPos = blockpos.offset(allowedDirection);
            if (worldIn.isAirBlock(blockpos) &&  checkPos.getY() < worldIn.getWorld().getDimension().getHeight() && worldIn.getBlockState(checkPos).isSolid()) {
               worldIn.setBlockState(blockpos, blockstate.with(CaveStarBlock.FACING,allowedDirection.getOpposite()), 2);
               ++i;
            }
         }
      }

      return i > 0;
   }
}