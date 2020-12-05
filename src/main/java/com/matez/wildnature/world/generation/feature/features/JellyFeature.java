package com.matez.wildnature.world.generation.feature.features;

import com.matez.wildnature.common.blocks.JellyBlock;
import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.util.other.Utilities;
import com.matez.wildnature.world.generation.structures.nature.SchemFeature;
import com.matez.wildnature.world.generation.structures.nature.woods.jelly.*;
import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.function.Function;

public class JellyFeature extends Feature<NoFeatureConfig> {
   public JellyFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
      super(configFactoryIn);
      setRegistryName("wildnature","jelly_feature");
   }

   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
      for(int i = 0; i < 10; ++i) {
         BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
         if (worldIn.getSeaLevel() - 10 > blockpos.getY()) {
            int type = Utilities.rint(0,11,rand);
            SchemFeature feature = null;
            switch (type){
               case 0:
                  feature = new jelly1();
                  break;
               case 1:
                  feature = new jelly2();
                  break;
               case 2:
                  feature = new jelly3();
                  break;
               case 3:
                  feature = new jelly4();
                  break;
               case 4:
                  feature = new jelly5();
                  break;
               case 5:
                  feature = new jelly6();
                  break;
               case 6:
                  feature = new jelly7();
                  break;
               case 7:
                  feature = new jelly8();
                  break;
               case 8:
                  feature = new jelly9();
                  break;
               case 9:
                  feature = new jelly10();
                  break;
               case 10:
                  feature = new jelly11();
                  break;
               case 11:
                  feature = new jelly12();
                  break;
            }
            if(feature != null && feature.canGrowTree(worldIn,pos,SchemFeature.sapling)){
               int blocks = Utilities.rint(0,6);
               feature.setCustomLog(WNBlocks.JELLY_BLUE_BLOCK.getDefaultState().with(JellyBlock.WATERLOGGED,true));
               switch (blocks){
                  case 0:
                     feature.setCustomLeaf(WNBlocks.JELLY_WHITE_BLOCK.getDefaultState().with(JellyBlock.WATERLOGGED,true));
                     break;
                  case 1:
                  case 2:
                     feature.setCustomLeaf(WNBlocks.JELLY_RED_BLOCK.getDefaultState().with(JellyBlock.WATERLOGGED,true));
                     break;
                  case 3:
                  case 4:
                     feature.setCustomLeaf(WNBlocks.JELLY_PINK_BLOCK.getDefaultState().with(JellyBlock.WATERLOGGED,true));
                     break;
                  case 5:
                  case 6:
                     feature.setCustomLeaf(WNBlocks.JELLY_ORANGE_BLOCK.getDefaultState().with(JellyBlock.WATERLOGGED,true));
                     break;
               }
               feature.place(worldIn, generator, rand, pos, config);
               return true;
            }
         }
      }

      return true;
   }
}