package com.matez.wildnature.world.gen.feature.features;

import com.matez.wildnature.world.gen.feature.configs.BlockFeatureConfig;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;
import java.util.function.Function;

public class SlimeCaveBushFeature extends Feature<BlockFeatureConfig> {
   public SlimeCaveBushFeature(Function<Dynamic<?>, ? extends BlockFeatureConfig> p_i49908_1_) {
      super(p_i49908_1_);
      setRegistryName("wildnature","slime_cave_bush_feature");
   }

   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, BlockFeatureConfig config) {
      if(!worldIn.getDimension().isSurfaceWorld()){
         return false;
      }
      int i = 0;
      BlockState blockstate = config.state;

      for(int j = 0; j < 8; ++j) {
         BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
         if (worldIn.isAirBlock(blockpos) && (!worldIn.getDimension().isNether() || blockpos.getY() < worldIn.getWorld().getDimension().getHeight()) && blockstate.isValidPosition(worldIn, blockpos)) {
            Biome biome = worldIn.getBiome(pos);
            if (biome == Biomes.SWAMP && pos.getY() > 50 && pos.getY() < 70) {
               worldIn.setBlockState(blockpos, blockstate, 2);
               ++i;
            }

            ChunkPos chunkpos = new ChunkPos(pos);
            boolean flag = SharedSeedRandom.seedSlimeChunk(chunkpos.x, chunkpos.z, worldIn.getSeed(), 987234911L).nextInt(10) == 0;
            if (flag && pos.getY() < 40) {
               worldIn.setBlockState(blockpos, blockstate, 2);
               ++i;
            }

         }
      }

      return i > 0;
   }
}