package com.matez.wildnature.world.generation.feature.features;

import com.matez.wildnature.util.other.Utilities;
import com.matez.wildnature.world.generation.feature.WNFeatures;
import com.matez.wildnature.world.generation.structures.nature.SchemFeature;
import com.matez.wildnature.world.generation.structures.nature.woods.jelly.*;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.function.Function;

public class JellyIslandFeature extends Feature<NoFeatureConfig> {
   public JellyIslandFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
      super(configFactoryIn);
      setRegistryName("wildnature","jelly_island_feature");
   }

   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
      for(int i = 0; i < 32; ++i) {
         BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
         if (worldIn.getSeaLevel() - 15 > blockpos.getY()) {
            if(worldIn.getChunk(blockpos).getTopBlockY(Heightmap.Type.OCEAN_FLOOR_WG,blockpos.getX(),blockpos.getZ()) > 30){
               return false;
            }
            int type = Utilities.rint(0,7,rand);
            SchemFeature feature = null;
            switch (type){
               case 0:
                  feature = new jelly_island1();
                  break;
               case 1:
                  feature = new jelly_island2();
                  break;
               case 2:
                  feature = new jelly_island3();
                  break;
               case 3:
                  feature = new jelly_island4();
                  break;
               case 4:
                  feature = new jelly_island5();
                  break;
               case 5:
                  feature = new jelly_island6();
                  break;
               case 6:
                  feature = new jelly_island7();
                  break;
               case 7:
                  feature = new jelly_island8();
                  break;
            }
            if(feature != null){
               feature.place(worldIn, generator, rand, blockpos, config);
               BlockPos jellyPos = new BlockPos(blockpos.getX(),worldIn.getChunk(blockpos).getTopBlockY(Heightmap.Type.OCEAN_FLOOR_WG,blockpos.getX(),blockpos.getZ()),blockpos.getZ());
               WNFeatures.JELLY_FEATURE.place(worldIn,generator,rand,jellyPos,config);
               return true;
            }
         }
      }

      return false;
   }
}