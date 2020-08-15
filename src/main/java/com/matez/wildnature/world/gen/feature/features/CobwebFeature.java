package com.matez.wildnature.world.gen.feature.features;

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

public class CobwebFeature extends Feature<NoFeatureConfig> {
   public CobwebFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i51438_1_) {
      super(p_i51438_1_);
       setRegistryName("wildnature","cobweb_feature");
   }

   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
       if(!worldIn.getDimension().isSurfaceWorld()){
           return false;
       }
       if(worldIn.getBlockState(pos).isAir() && (worldIn.getBlockState(pos.down()).isSolid() || worldIn.getBlockState(pos.up()).isSolid())) {
           worldIn.setBlockState(pos, Blocks.COBWEB.getDefaultState(), 2);

           return true;
       }
       return false;

   }
}