package com.matez.wildnature.world.gen.feature.features;

import com.matez.wildnature.blocks.CaveStarBlock;
import com.matez.wildnature.blocks.LichenBlock;
import com.matez.wildnature.lists.WNBlocks;
import com.mojang.datafixers.Dynamic;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.CountConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Function;

public class WNLichenFeature extends Feature<CountConfig> {
   private ArrayList<Direction> allowedDirections = new ArrayList<>();

   public WNLichenFeature(Function<Dynamic<?>, ? extends CountConfig> p_i49908_1_) {
      super(p_i49908_1_);
      allowedDirections.addAll(Arrays.asList(Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST));
      allowedDirections.add(Direction.DOWN);
      setRegistryName("wildnature","lichen_feature");
   }

   private int bound = 1, boundY = 2;

   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, CountConfig config) {
      int i = 0;
      if(!worldIn.getDimension().isSurfaceWorld()){
         return false;
      }

      for(int j = 0; j < 64; ++j) {
         for (Direction allowedDirection : allowedDirections) {
            BlockPos blockpos = pos.add(rand.nextInt(bound) - rand.nextInt(bound), rand.nextInt(boundY) - rand.nextInt(boundY), rand.nextInt(bound) - rand.nextInt(bound));
            BlockPos checkPos = blockpos.offset(allowedDirection);
            if (worldIn.isAirBlock(blockpos) &&  checkPos.getY() < worldIn.getWorld().getDimension().getHeight() && worldIn.getBlockState(checkPos).isSolid() && worldIn.getBlockState(checkPos).isIn(BlockTags.LOGS)) {
               worldIn.setBlockState(blockpos, WNBlocks.LICHEN.getDefaultState().with(LichenBlock.FACING, allowedDirection.getOpposite()), 2);
               ++i;
            }
         }
      }

      return i>0;
   }
}