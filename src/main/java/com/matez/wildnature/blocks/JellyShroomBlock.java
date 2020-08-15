package com.matez.wildnature.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class JellyShroomBlock extends CaveShroomBase implements IWaterLoggable {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public JellyShroomBlock(Properties properties, Item.Properties builder, ResourceLocation regName, boolean reversed) {
        super(properties, builder, regName, reversed);
    }


    public void onFallenUpon(World p_180658_1_, BlockPos p_180658_2_, Entity p_180658_3_, float p_180658_4_) {
        if (p_180658_3_.isSuppressingBounce()) {
            super.onFallenUpon(p_180658_1_, p_180658_2_, p_180658_3_, p_180658_4_);
        } else {
            p_180658_3_.onLivingFall(p_180658_4_, 0.0F);
        }

    }

    public void onLanded(IBlockReader p_176216_1_, Entity p_176216_2_) {
        if (p_176216_2_.isSneaking()) {
            super.onLanded(p_176216_1_, p_176216_2_);
        } else {
            Vec3d lvt_3_1_ = p_176216_2_.getMotion();
            if (lvt_3_1_.y < 0.0D) {
                double lvt_4_1_ = p_176216_2_ instanceof LivingEntity ? 1.0D : 0.8D;
                p_176216_2_.setMotion(lvt_3_1_.x, -lvt_3_1_.y * lvt_4_1_, lvt_3_1_.z);
            }
        }

    }

    public void onEntityWalk(World p_176199_1_, BlockPos p_176199_2_, Entity p_176199_3_) {
        double lvt_4_1_ = Math.abs(p_176199_3_.getMotion().y);
        if (lvt_4_1_ < 0.1D && !p_176199_3_.isSneaking()) {
            double lvt_6_1_ = 0.4D + lvt_4_1_ * 0.2D;
            p_176199_3_.setMotion(p_176199_3_.getMotion().mul(lvt_6_1_, 1.0D, lvt_6_1_));
        }

        super.onEntityWalk(p_176199_1_, p_176199_2_, p_176199_3_);
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(WATERLOGGED);
    }

    public IFluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }

    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (stateIn.get(WATERLOGGED)) {
            worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
        }

        return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockPos blockpos = context.getPos();

        IFluidState ifluidstate = context.getWorld().getFluidState(blockpos);
        return this.getDefaultState().with(WATERLOGGED, Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER));
    }


}