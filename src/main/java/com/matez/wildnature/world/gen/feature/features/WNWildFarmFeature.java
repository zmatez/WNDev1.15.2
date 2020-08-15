package com.matez.wildnature.world.gen.feature.features;

import com.matez.wildnature.blocks.CropBase;
import com.matez.wildnature.blocks.EggPlant;
import com.matez.wildnature.blocks.GreenBeansBush;
import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.world.gen.feature.FeatureRegistry;
import com.matez.wildnature.world.gen.feature.configs.BlockFeatureConfig;
import com.matez.wildnature.world.gen.feature.configs.WNBlobConfig;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.*;
import net.minecraft.state.properties.DoubleBlockHalf;
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

public class WNWildFarmFeature extends Feature<BlockFeatureConfig> {

   public WNWildFarmFeature(Function<Dynamic<?>, ? extends BlockFeatureConfig> p_i51438_1_) {
      super(p_i51438_1_);
       setRegistryName("wildnature","wild_farm_feature");
   }

   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, BlockFeatureConfig config) {
        BlockState cropState = config.state;
       if(!worldIn.getDimension().isSurfaceWorld()){
           return false;
       }
       if(worldIn.getBlockState(pos).canSustainPlant(worldIn,pos.down(), Direction.UP,(IPlantable)Blocks.OAK_SAPLING)) {
            WNBlobFeature feature = (WNBlobFeature) FeatureRegistry.BLOB_FEATURE;
            feature.place(worldIn,generator,rand,pos,new WNBlobConfig(Blocks.FARMLAND.getDefaultState().with(FarmlandBlock.MOISTURE,7),Utilities.rint(1,2),true,false));

            feature.getFilledBlocks().forEach(blockPos -> {
                if(!worldIn.getBlockState(blockPos.up()).isSolid()){
                    worldIn.setBlockState(blockPos.up(),Blocks.AIR.getDefaultState(),2);
                }
            });

            BlockState crop = null;
           if(cropState.getBlock() instanceof CropBase) {
               crop = cropState.with(((CropBase) cropState.getBlock()).getAgeProperty(), Utilities.rint(((CropBase) cropState.getBlock()).getMaxAge() - 1, ((CropBase) cropState.getBlock()).getMaxAge()));
           }else{
               crop = cropState;
           }

           int water = 0;
           int fence = 2;
           for(int j = 0; j < 256; ++j) {
               BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
               if (worldIn.isAirBlock(blockpos) && (!worldIn.getDimension().isNether() || blockpos.getY() < worldIn.getWorld().getDimension().getHeight())) {
                   if(crop.isValidPosition(worldIn, blockpos) && worldIn.getBlockState(blockpos.down()).getBlock()==Blocks.FARMLAND) {
                       if(!worldIn.getBlockState(blockpos).isSolid() && !(worldIn.getBlockState(blockpos).getBlock() instanceof CropsBlock)){
                           worldIn.setBlockState(blockpos,Blocks.AIR.getDefaultState(),2);
                       }

                       if (Utilities.rint(0, water) == 0 && !Utilities.isBlockNear(worldIn,blockpos.down(),Blocks.AIR)) {
                           water++;
                           worldIn.setBlockState(blockpos.down(), Blocks.WATER.getDefaultState(), 2);
                       } else {
                           if(cropState.getBlock() instanceof CropBase) {
                               crop = cropState.with(((CropBase) cropState.getBlock()).getAgeProperty(), Utilities.rint(((CropBase) cropState.getBlock()).getMaxAge() - 1, ((CropBase) cropState.getBlock()).getMaxAge()));
                           }else{
                               crop = cropState;
                           }

                           if(crop.getBlock() instanceof EggPlant){
                               worldIn.setBlockState(blockpos, crop.with(EggPlant.HALF, DoubleBlockHalf.LOWER), 2);
                               if(crop.get(EggPlant.AGE)!=0 && crop.get(EggPlant.AGE)!=1) {
                                   worldIn.setBlockState(blockpos.up(), crop.with(EggPlant.HALF, DoubleBlockHalf.UPPER), 2);
                               }
                           }else if(crop.getBlock() instanceof GreenBeansBush){
                               FeatureRegistry.GREEN_BEAN_FEATURE.place(worldIn,generator,rand,blockpos,new NoFeatureConfig());
                           }else {
                               worldIn.setBlockState(blockpos, crop, 2);
                           }
                       }
                   }else if(worldIn.getBlockState(blockpos.down()).getBlock() instanceof GrassBlock && Utilities.isBlockNear(worldIn,blockpos.down(),Blocks.FARMLAND)){
                       if (Utilities.rint(0, (int)fence/2) == 0 && CommonConfig.vegeFarmFence.get()) {
                           fence++;
                           worldIn.setBlockState(blockpos, Blocks.OAK_FENCE.getDefaultState(), 2);
                           if(Utilities.rint(0,1)==0){
                               worldIn.setBlockState(blockpos.up(), Blocks.TORCH.getDefaultState(), 2);
                           }
                       }
                   }
               }
           }


           return true;
       }
       return false;

   }

   private BlockPos water(BlockPos pos, IWorld world, Random rand){
       BlockPos waterPos = pos;
       switch (Utilities.rint(1,4,rand)){
           case 1:
               waterPos=pos.east();
               break;
           case 2:
               waterPos=pos.west();
               break;
           case 3:
               waterPos=pos.south();
               break;
           case 4:
               waterPos=pos.north();
               break;
       }

       if(world.getBlockState(waterPos.down()).isSolid()){
           if(world.getBlockState(waterPos.north()).isSolid()){
               if(world.getBlockState(waterPos.south()).isSolid()){
                   if(world.getBlockState(waterPos.east()).isSolid()){
                       if(world.getBlockState(waterPos.west()).isSolid()){
                            return waterPos;
                       }
                   }
               }
           }
       }
       return null;
   }
}