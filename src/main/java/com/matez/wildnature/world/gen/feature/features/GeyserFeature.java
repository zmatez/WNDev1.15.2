package com.matez.wildnature.world.gen.feature.features;

import com.matez.wildnature.blocks.GeyserBlock;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.other.Utilities;
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

public class GeyserFeature extends Feature<NoFeatureConfig> {
   public GeyserFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i51438_1_) {
      super(p_i51438_1_);
       setRegistryName("wildnature","geyser_feature");
   }

   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
       if(!worldIn.getDimension().isSurfaceWorld()){
           return false;
       }
       if(worldIn.getBlockState(pos.up()).isAir() && (worldIn.getBlockState(pos).isSolid() || worldIn.getBlockState(pos.down()).isSolid())) {
           worldIn.setBlockState(pos.down(3), WNBlocks.GEYSER.getDefaultState().with(GeyserBlock.RUNNING,false).with(GeyserBlock.LOAD, Utilities.rint(1,4)), 2);
           worldIn.setBlockState(pos.down(2), Blocks.WATER.getDefaultState(), 2);
           worldIn.setBlockState(pos.down(1), Blocks.WATER.getDefaultState(), 2);

           return true;
       }
       return false;

   }
}