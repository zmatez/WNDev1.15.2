package com.matez.wildnature.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.Item;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class CattailBlock extends DoubleBushBase {
    public CattailBlock(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties.sound(SoundType.PLANT), builder, regName);
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        boolean flag =  super.isValidPosition(state, worldIn, pos);
        if(state.get(HALF)== DoubleBlockHalf.LOWER){
            if(worldIn.getBlockState(pos).getBlock()==Blocks.WATER || isNearWater(state,worldIn,pos)){
                return flag;
            }else{
                return false;
            }
        }else{
            return flag;
        }
    }

    public boolean isNearWater(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockState soil = worldIn.getBlockState(pos.down());
        if (soil.canSustainPlant(worldIn, pos.down(), Direction.UP, this)) return true;
        Block block = worldIn.getBlockState(pos.down()).getBlock();
        if (block == this) {
            return true;
        } else {
            if (block == Blocks.GRASS_BLOCK || block == Blocks.DIRT || block == Blocks.COARSE_DIRT || block == Blocks.PODZOL) {
                BlockPos blockpos = pos.down();

                for(Direction direction : Direction.Plane.HORIZONTAL) {
                    BlockState blockstate = worldIn.getBlockState(blockpos.offset(direction));
                    IFluidState ifluidstate = worldIn.getFluidState(blockpos.offset(direction));
                    if (ifluidstate.isTagged(FluidTags.WATER) || blockstate.getBlock() == Blocks.FROSTED_ICE) {
                        return true;
                    }
                }
            }

            return false;
        }
    }
}
