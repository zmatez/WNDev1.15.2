package com.matez.wildnature.world.gen.feature.features;

import com.matez.wildnature.blocks.FloweringBushBase;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.other.Utilities;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.function.Function;

public class MarigoldFeature extends Feature<NoFeatureConfig> {
   public MarigoldFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i49876_1_) {
      super(p_i49876_1_);
      setRegistryName("wildnature","marigold_feature");
   }

   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
      if(!worldIn.getDimension().isSurfaceWorld()){
         return false;
      }
      int i = 0;

      for(int j = 0; j < 512; ++j) {
         BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
         int x = blockpos.getX();
         String lastXNum = (("" + x).charAt((""+x).length()-1)+"");

         if(Utilities.isStringEqual(lastXNum,"2","3","4","8","9")) {
            BlockState state = WNBlocks.MARIGOLD_ORANGE.getDefaultState().with(FloweringBushBase.FLOWERING,true);
            if (worldIn.isAirBlock(blockpos) && blockpos.getY() < 255 && state.isValidPosition(worldIn, blockpos)) {
               worldIn.setBlockState(blockpos, state, 2);
               ++i;
            }
         }else if(Utilities.isStringEqual(lastXNum,"1","5","6","7")) {
            BlockState state = WNBlocks.MARIGOLD_YELLOW.getDefaultState().with(FloweringBushBase.FLOWERING,true);
            if (worldIn.isAirBlock(blockpos) && blockpos.getY() < 255 && state.isValidPosition(worldIn, blockpos)) {
               worldIn.setBlockState(blockpos, state, 2);
               ++i;
            }
         }
      }

      return i > 0;
   }


}