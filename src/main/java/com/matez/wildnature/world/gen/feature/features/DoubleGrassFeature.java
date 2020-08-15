package com.matez.wildnature.world.gen.feature.features;

import com.matez.wildnature.world.gen.feature.configs.BlockFeatureConfig;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;
import java.util.function.Function;

public class DoubleGrassFeature extends Feature<BlockFeatureConfig> {
   public DoubleGrassFeature(Function<Dynamic<?>, ? extends BlockFeatureConfig> p_i49884_1_) {
      super(p_i49884_1_);
      setRegistryName("wildnature","double_grass_feature");
   }

   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, BlockFeatureConfig config) {
      if(!worldIn.getDimension().isSurfaceWorld()){
         return false;
      }
      boolean flag = false;

      for(int i = 0; i < 128; ++i) {
         BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
         if (worldIn.isAirBlock(blockpos) && blockpos.getY() < worldIn.getWorld().getDimension().getHeight() - 2 && config.state.isValidPosition(worldIn, blockpos)) {
            worldIn.setBlockState(blockpos,config.state.with(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER),2);
            worldIn.setBlockState(blockpos.up(),config.state.with(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER),2);
            flag = true;
         }
      }

      return flag;
   }
}