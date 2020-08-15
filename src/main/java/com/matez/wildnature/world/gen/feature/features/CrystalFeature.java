package com.matez.wildnature.world.gen.feature.features;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.GlowingCrystalBase;
import com.matez.wildnature.other.Utilities;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.function.Function;

public class CrystalFeature extends Feature<NoFeatureConfig> {
   public CrystalFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i51438_1_) {
      super(p_i51438_1_);
      setRegistryName("wildnature","crystal_feature");
   }

   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
      if(!worldIn.getDimension().isSurfaceWorld()){
         return false;
      }
      if(worldIn.getBlockState(pos).isAir()) {
         if (worldIn.getBlockState(pos.down()).isSolid()) {
            worldIn.setBlockState(pos, getRandomCrystal().with(GlowingCrystalBase.FACING, Direction.UP), 2);
            return true;
         } else if (worldIn.getBlockState(pos.up()).isSolid()) {
            worldIn.setBlockState(pos, getRandomCrystal().with(GlowingCrystalBase.FACING, Direction.DOWN), 2);
            return true;
         }
      }
      return false;

   }

   private BlockState getRandomCrystal(){
      BlockState b1 = Main.getBlockByID("wildnature:glowing_crystal_blue").getDefaultState();
      BlockState b2 = Main.getBlockByID("wildnature:glowing_crystal_red").getDefaultState();
      BlockState b3 = Main.getBlockByID("wildnature:glowing_crystal_purple").getDefaultState();
      BlockState b4 = Main.getBlockByID("wildnature:glowing_crystal_orange").getDefaultState();
      BlockState b5 = Main.getBlockByID("wildnature:glowing_crystal_white").getDefaultState();

      switch (Utilities.rint(0,4)){
         case 0:
            return b1;
         case 1:
            return b2;
         case 2:
            return b3;
         case 3:
            return b4;
         case 4:
            return b5;
      }
      return b5;
   }
}