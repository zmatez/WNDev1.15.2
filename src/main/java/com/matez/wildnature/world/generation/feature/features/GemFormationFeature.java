package com.matez.wildnature.world.generation.feature.features;

import com.matez.wildnature.common.blocks.FormationBase;
import com.matez.wildnature.common.blocks.FormationVerticalBase;
import com.matez.wildnature.common.blocks.FormationWallBase;
import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.world.generation.feature.configs.BlockVeinFeatureConfig;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;
import java.util.function.Function;

public class GemFormationFeature extends Feature<BlockVeinFeatureConfig> {
   private static final Direction[] DIRECTIONS = new Direction[]{
           Direction.WEST,
           Direction.EAST,
           Direction.SOUTH,
           Direction.NORTH
   };
   public GemFormationFeature(Function<Dynamic<?>, ? extends BlockVeinFeatureConfig> p_i51438_1_) {
      super(p_i51438_1_);
      setRegistryName("wildnature","gem_formation_feature");
   }

   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, BlockVeinFeatureConfig config) {
      if(!worldIn.getDimension().isSurfaceWorld()){
         return false;
      }
      if(config.state.getBlock() instanceof FormationBase) {
         if (worldIn.getBlockState(pos).isAir() || worldIn.getBlockState(pos).getBlock() == Blocks.WATER ) {
            boolean waterlogged = worldIn.getFluidState(pos).getFluid() == Fluids.WATER || worldIn.getFluidState(pos).getFluid() == Fluids.FLOWING_WATER;
            if(config.state.getBlock() instanceof FormationVerticalBase){
               if (worldIn.getBlockState(pos.down()).isSolid() && config.state.getBlock() != WNBlocks.MALACHITE_FORMATION) {
                  worldIn.setBlockState(pos, config.state.with(FormationBase.WATERLOGGED,waterlogged), 2);
                  return true;
               } else if (worldIn.getBlockState(pos.up()).isSolid()) {
                  worldIn.setBlockState(pos, config.state.with(FormationBase.WATERLOGGED,waterlogged), 2);
                  return true;
               }
            }else {
               if(config.state.getBlock() instanceof FormationWallBase) {
                  Direction wall = null;
                  for (Direction direction : DIRECTIONS) {
                     if (worldIn.getBlockState(pos.offset(direction)).isSolid()) {
                        wall = direction;
                        break;
                     }
                  }
                  if (wall != null) {
                     worldIn.setBlockState(pos, config.state.with(FormationWallBase.FACING,wall).with(FormationBase.WATERLOGGED,waterlogged), 2);
                     return true;
                  }
               }
            }

         }
      }
      return false;

   }
}