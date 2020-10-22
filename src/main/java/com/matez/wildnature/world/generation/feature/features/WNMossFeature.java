package com.matez.wildnature.world.generation.feature.features;

import com.matez.wildnature.util.lists.WNBlocks;
import com.mojang.datafixers.Dynamic;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.CountConfig;

import java.util.Random;
import java.util.function.Function;

public class WNMossFeature extends Feature<CountConfig> {
   public WNMossFeature(Function<Dynamic<?>, ? extends CountConfig> p_i49908_1_) {
      super(p_i49908_1_);
      setRegistryName("wildnature","moss_feature");
   }

   private int bound = 3;

   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, CountConfig config) {
      int i = 0;
      if(!worldIn.getDimension().isSurfaceWorld()){
         return false;
      }

      for (int j = 0; j < config.count; ++j) {
         BlockPos blockpos = pos.add(rand.nextInt(bound) - rand.nextInt(bound), rand.nextInt(bound/2) - rand.nextInt(bound/2), rand.nextInt(bound) - rand.nextInt(bound));
         if (worldIn.isAirBlock(blockpos) && (!worldIn.getDimension().isNether() || blockpos.getY() < worldIn.getWorld().getDimension().getHeight()) && worldIn.getBlockState(blockpos.down()).isSolid() && !BlockTags.SAND.contains(worldIn.getBlockState(blockpos.down()).getBlock())) {
            worldIn.setBlockState(blockpos, WNBlocks.MOSS.getDefaultState(), 2);
            ++i;
         }
      }
      return i>0;
   }
}