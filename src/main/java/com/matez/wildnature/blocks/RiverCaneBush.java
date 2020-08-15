package com.matez.wildnature.blocks;

import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.other.Utilities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraftforge.common.IPlantable;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class RiverCaneBush extends BushBase implements IWaterLoggable {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);

    public RiverCaneBush(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties, builder, regName);
        setDefaultState(this.getDefaultState().with(WATERLOGGED,false));

    }


    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
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

    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        if(state.getBlock()==Blocks.WATER) {
            if(worldIn.getBlockState(pos.up()).getBlock()==Blocks.AIR || worldIn.getBlockState(pos.up(2)).getBlock()==Blocks.AIR || worldIn.getBlockState(pos.up(3)).getBlock()==Blocks.AIR || worldIn.getBlockState(pos.up(4)).getBlock()==Blocks.AIR || worldIn.getBlockState(pos.up(5)).getBlock()==Blocks.AIR) {
                BlockPos blockpos = pos.down();
                BlockState blockstate = worldIn.getBlockState(blockpos);
                Block block = blockstate.getBlock();
                return block != Blocks.MAGMA_BLOCK && (block == this || blockstate.isSolidSide(worldIn, blockpos, Direction.UP));
            }
            return false;
        }else{
            return super.isValidPosition(state,worldIn,pos);
        }
    }

    @Override
    public boolean canSustainPlant(BlockState p_canSustainPlant_1_, IBlockReader p_canSustainPlant_2_, BlockPos p_canSustainPlant_3_, Direction p_canSustainPlant_4_, IPlantable p_canSustainPlant_5_) {
        BlockState plant = p_canSustainPlant_5_.getPlant(p_canSustainPlant_2_, p_canSustainPlant_3_.offset(p_canSustainPlant_4_));

        if(plant.getBlock() == this){
            return true;
        }
        return super.canSustainPlant(p_canSustainPlant_1_, p_canSustainPlant_2_, p_canSustainPlant_3_, p_canSustainPlant_4_, p_canSustainPlant_5_);
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        ArrayList<ItemStack> l = new ArrayList<>();
        if(Utilities.rint(0, CommonConfig.flowerDropChance.get())==0){
            l.add(new ItemStack(getItem(),1));
            return l;
        }else{
            l.add(new ItemStack(Items.STICK,Utilities.rint(0,2)));
            return l;
        }
    }
}
