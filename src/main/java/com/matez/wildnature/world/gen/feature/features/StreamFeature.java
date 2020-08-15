package com.matez.wildnature.world.gen.feature.features;

import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.world.gen.biomes.layer.WNLayerUtil;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.function.Function;

public class StreamFeature extends Feature<NoFeatureConfig> {
    public StreamFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i49915_1_) {
        super(p_i49915_1_);
        setRegistryName("wildnature","stream_feature");
    }

    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        if(!worldIn.getDimension().isSurfaceWorld()){
            return false;
        }
        if(worldIn.isAirBlock(pos.down())){
            return false;
        }
        if(worldIn.getBlockState(pos.down()).isSolid()){
            try {
                BlockPos p = pos.down();
                Direction d = Direction.byHorizontalIndex(Utilities.rint(0, 3));
                for (int i = 0; i < 200; i++) {
                    worldIn.setBlockState(p, Blocks.WATER.getDefaultState(), 2);
                    Direction jd = d;
                    if (Utilities.rint(0, 2) == 0) {
                        jd = Direction.byHorizontalIndex(Utilities.rint(0, 3));
                        if (jd == d.getOpposite()) {
                            jd = d;
                        }
                    }
                    p = p.offset(jd);
                    if (!worldIn.getBlockState(p).isSolid()) {
                        if (!worldIn.getBlockState(p.down()).isSolid()) {
                            return false;
                        } else {
                            p = p.down();
                        }
                    }

                    if (WNLayerUtil.isShallowOcean(Registry.BIOME.getId(worldIn.getBiome(p)))) {
                        return false;
                    }


                }
            }catch (Exception e){

            }

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