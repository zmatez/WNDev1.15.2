package com.matez.wildnature.world.gen.feature.features;

import com.matez.wildnature.blocks.BelladonnaBlock;
import com.matez.wildnature.blocks.CropBase;
import com.matez.wildnature.blocks.FloweringBushBase;
import com.matez.wildnature.blocks.YuccaBlock;
import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.world.gen.feature.configs.BlockWeightListConfig;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.block.TallFlowerBlock;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;
import java.util.function.Function;

public class PlantFeature extends Feature<BlockWeightListConfig> {
    public PlantFeature(Function<Dynamic<?>, ? extends BlockWeightListConfig> p_i49869_1_) {
        super(p_i49869_1_);
        setRegistryName("wildnature","wn_plant_feature");
    }

    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, BlockWeightListConfig config) {
        if(!worldIn.getDimension().isSurfaceWorld()){
            return false;
        }
        BlockState state = Utilities.getWeighBlock(config.list);
        if(state!=null) {
            for (BlockState blockstate = worldIn.getBlockState(pos); (blockstate.isAir() || blockstate.isIn(BlockTags.LEAVES)) && pos.getY() > 0; blockstate = worldIn.getBlockState(pos)) {
                pos = pos.down();
            }

            int i = 0;

            for (int j = 0; j < 128; ++j) {
                BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
                try {
                    if (worldIn.isAirBlock(blockpos) && state.isValidPosition(worldIn, blockpos)) {
                        if(state.getProperties().contains(FloweringBushBase.FLOWERING)){
                            if(!state.get(FloweringBushBase.FLOWERING)){
                                if(Utilities.rint(0,1)==0){
                                    state = state.with(FloweringBushBase.FLOWERING,true);
                                }
                            }else{
                                if(Utilities.rint(0,3)==0){
                                    state = state.with(FloweringBushBase.FLOWERING,false);
                                }
                            }
                        }
                        if(state.getBlock() instanceof CropBase){
                            IntegerProperty property = ((CropBase)state.getBlock()).getAge();
                            if(property==null){
                                property = ((CropBase)state.getBlock()).getAgeProperty();
                            }
                            state = state.with(property,Utilities.rint(1,((CropBase)state.getBlock()).getMaxAge()));
                        }
                        if(state.getBlock() instanceof DoublePlantBlock){
                            if(worldIn.getBlockState(pos.up()).isAir()){
                                if(state.getBlock() instanceof BelladonnaBlock){
                                    state = state.with(BelladonnaBlock.STAGE,Utilities.rint(2,3));
                                }
                                if(state.getBlock() instanceof YuccaBlock){
                                    ((YuccaBlock)state.getBlock()).setBlock(worldIn,pos, Utilities.rint(0, 1) == 0);
                                }else {
                                    worldIn.setBlockState(blockpos, state.with(TallFlowerBlock.HALF, DoubleBlockHalf.LOWER), 2);
                                    worldIn.setBlockState(blockpos.up(), state.with(TallFlowerBlock.HALF, DoubleBlockHalf.UPPER), 2);
                                    if(state.getBlock() instanceof BelladonnaBlock){
                                        break;
                                    }
                                }
                            }
                        }else {
                            worldIn.setBlockState(blockpos, state, 2);
                        }
                        ++i;
                    }
                } catch (NullPointerException e) {
                }
            }

            return i > 0;
        }
        return false;
    }


}
