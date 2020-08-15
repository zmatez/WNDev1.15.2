package com.matez.wildnature.world.gen.feature.features;

import com.matez.wildnature.other.Utilities;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.function.Function;

public class CandyCaneFeature extends Feature<NoFeatureConfig> {
    public CandyCaneFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i49915_1_) {
        super(p_i49915_1_);
        setRegistryName("wildnature","candy_cane_feature");
    }

    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        if(!worldIn.getDimension().isSurfaceWorld()){
            return false;
        }
        if(worldIn.isAirBlock(pos.down())){
            return false;
        }

        if(worldIn.getBlockState(pos.down()).isSolid()){
            BlockState oldBlock = null;
            BlockPos posBlock = pos;
            for(int i = 0; i < Utilities.rint(5,8); i++){
                BlockState b = getNextBlock(oldBlock,rand);
                worldIn.setBlockState(posBlock,b,2);
                oldBlock = b;
                posBlock = posBlock.up();
            }
            posBlock = posBlock.down();
            Direction d = Direction.byHorizontalIndex(Utilities.rint(0,3));
            posBlock = posBlock.offset(d,1);
            for(int i = 0; i < 2; i++){
                BlockState b = getNextBlock(oldBlock,rand);
                worldIn.setBlockState(posBlock,b,2);
                oldBlock = b;
                posBlock = posBlock.offset(d,1);
            }
            posBlock = posBlock.offset(d,-1);

            worldIn.setBlockState(posBlock.down(),getNextBlock(oldBlock,rand),2);
            return true;
        }

        return false;
    }

    private BlockState getNextBlock(@Nullable BlockState old, Random rand){
        BlockState firstBlock = Blocks.SNOW_BLOCK.getDefaultState();
        BlockState secondBlock = Blocks.RED_TERRACOTTA.getDefaultState();

        if(old==null){
            return Utilities.rint(0,1,rand) == 0 ? firstBlock : secondBlock;
        }else{
            if(old.getBlock()==firstBlock.getBlock()){
                return secondBlock;
            }else{
                return firstBlock;

            }
        }
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