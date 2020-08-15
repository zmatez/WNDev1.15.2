package com.matez.wildnature.world.gen.feature.features;

import com.matez.wildnature.Main;
import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.function.Function;

public class PebbleFeature extends Feature<NoFeatureConfig> {
   public PebbleFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i51438_1_) {
      super(p_i51438_1_);
       setRegistryName("wildnature","pebble_feature");
   }

   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
       if(!worldIn.getDimension().isSurfaceWorld()){
           return false;
       }
       if(worldIn.getBlockState(pos).isAir()) {
           if (worldIn.getBlockState(pos.down()).isSolid()) {
               worldIn.setBlockState(pos, Main.getBlockByID("wildnature:pebble").getDefaultState(), 2);
               return true;
           }
       }
       return false;

   }
}