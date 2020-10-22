package com.matez.wildnature.world.generation.feature.features;

import com.matez.wildnature.init.Main;
import com.matez.wildnature.util.config.CommonConfig;
import com.matez.wildnature.util.other.Utilities;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BeehiveBlock;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.tags.BlockTags;
import net.minecraft.tileentity.BeehiveTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.CountConfig;

import java.util.Random;
import java.util.function.Function;

public class WNBeehiveFeature extends Feature<CountConfig> {
   public WNBeehiveFeature(Function<Dynamic<?>, ? extends CountConfig> p_i49908_1_) {
      super(p_i49908_1_);
      setRegistryName("wildnature","beehive_feature");
   }

   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, CountConfig config) {
      if (!worldIn.getDimension().isSurfaceWorld()) {
         return false;
      }

      boolean placed = false;
      if (Utilities.rint(0, CommonConfig.beehiveRarity.get()) == 0) {
         if ((worldIn.isAirBlock(pos.down())) && !(worldIn.isAirBlock(pos.up()))) {
            if (worldIn.getBlockState(pos).getBlock().isIn(BlockTags.LEAVES)) {
               for (Direction generateDirection : BeehiveBlock.GENERATE_DIRECTIONS) {
                  if (worldIn.isAirBlock(pos.offset(generateDirection))) {
                     Main.LOGGER.debug("Bee nest set at " + pos);
                     worldIn.setBlockState(pos, Blocks.BEE_NEST.getDefaultState().with(BeehiveBlock.FACING, generateDirection), 2);
                     TileEntity tileentity = worldIn.getTileEntity(pos);
                     if (tileentity instanceof BeehiveTileEntity) {
                        BeehiveTileEntity beehivetileentity = (BeehiveTileEntity) tileentity;
                        int j = 2 + rand.nextInt(2);

                        for (int k = 0; k < j; ++k) {
                           BeeEntity beeentity = new BeeEntity(EntityType.BEE, worldIn.getWorld());
                           beehivetileentity.tryEnterHive(beeentity, false, rand.nextInt(599));
                        }
                     }
                     placed = true;
                     break;
                  }
               }
            }
         }
      }

      return placed;
   }
}