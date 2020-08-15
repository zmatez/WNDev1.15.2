package com.matez.wildnature.world.gen.feature.features;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.CornPlant;
import com.matez.wildnature.other.Utilities;
import com.mojang.datafixers.Dynamic;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.common.IPlantable;

import java.util.Random;
import java.util.function.Function;

public class CornFeature extends Feature<NoFeatureConfig> {
    public CornFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i49915_1_) {
        super(p_i49915_1_);
        setRegistryName("wildnature","corn_feature");
    }

    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        if(!worldIn.getDimension().isSurfaceWorld()){
            return false;
        }
        if(worldIn.isAirBlock(pos.down())){
            return false;
        }
        if(worldIn.getBlockState(pos.down()).canSustainPlant(worldIn,pos,Direction.UP,(IPlantable)Main.getBlockByID("wildnature.corn_bush").getDefaultState().with(CornPlant.STAGE,1))){
            int stage = Utilities.rint(1,2);
            worldIn.setBlockState(pos, Main.getBlockByID("wildnature:corn_bush").getDefaultState().with(CornPlant.STAGE, stage),2);
            worldIn.setBlockState(pos.up(), Main.getBlockByID("wildnature:corn_bush").getDefaultState().with(CornPlant.STAGE, stage),2);
            worldIn.setBlockState(pos.up(2), Main.getBlockByID("wildnature:corn_bush").getDefaultState().with(CornPlant.STAGE, stage),2);
            worldIn.setBlockState(pos.up(3), Main.getBlockByID("wildnature:corn_bush").getDefaultState().with(CornPlant.STAGE, stage),2);
            worldIn.setBlockState(pos.up(4), Main.getBlockByID("wildnature:corn_bush").getDefaultState().with(CornPlant.STAGE, 0),2);


            return true;
        }

        return false;
    }


}
      /*while(true) {
         label50: {
            if (pos.getY() > 3) {
               if (worldIn.isAirBlock(pos.down())) {
                  break label50;
               }

               Block block = worldIn.getBlockState(pos.down()).getBlock();
               if (block != Blocks.GRASS_BLOCK && !Block.isDirt(block) && !Block.isRock(block)) {
                  break label50;
               }
            }

            if (pos.getY() <= 3) {
               return false;
            }

            int i1 = config.startRadius;

            for(int i = 0; i1 >= 0 && i < 3; ++i) {
               int j = i1 + rand.nextInt(2);
               int k = i1 + rand.nextInt(2);
               int l = i1 + rand.nextInt(2);
               float f = (float)(j + k + l) * 0.333F + 0.5F;

               for(BlockPos blockpos : BlockPos.getAllInBoxMutable(pos.add(-j, -k, -l), pos.add(j, k, l))) {
                  if (blockpos.distanceSq(pos) <= (double)(f * f)) {
                     worldIn.setBlockState(blockpos, config.state, 4);
                  }
               }

               pos = pos.add(-(i1 + 1) + rand.nextInt(2 + i1 * 2), 0 - rand.nextInt(2), -(i1 + 1) + rand.nextInt(2 + i1 * 2));
            }

            return true;
         }

         pos = pos.down();
      }*/