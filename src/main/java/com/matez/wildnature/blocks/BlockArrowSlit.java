package com.matez.wildnature.blocks;

import com.matez.wildnature.lists.WNBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.*;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

import javax.annotation.Nullable;

public class BlockArrowSlit extends Block implements IWaterLoggable {
    protected static final VoxelShape NORTH_SHAPE_R = Block.makeCuboidShape(0.0D, 0.0D, 9.0D, 4.0D, 16.0D, 16.0D);
    protected static final VoxelShape NORTH_SHAPE_L = Block.makeCuboidShape(12.0D, 0.0D, 9.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape NORTH_SHAPE = VoxelShapes.or(NORTH_SHAPE_L, VoxelShapes.or(NORTH_SHAPE_R));
    protected static final VoxelShape SOUTH_SHAPE_R =  Block.makeCuboidShape(12.0D, 0.0D, 0.0D, 16.0D, 16.0D, 7.0D);
    protected static final VoxelShape SOUTH_SHAPE_L =  Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 4.0D, 16.0D, 7.0D);
    private static final VoxelShape SOUTH_SHAPE = VoxelShapes.or(SOUTH_SHAPE_L, VoxelShapes.or(SOUTH_SHAPE_R));
    protected static final VoxelShape EAST_SHAPE_R = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 7.0D, 16.0D, 4.0D);
    protected static final VoxelShape EAST_SHAPE_L = Block.makeCuboidShape(0.0D, 0.0D, 12.0D, 7.0D, 16.0D, 16.0D);
    private static final VoxelShape EAST_SHAPE = VoxelShapes.or(EAST_SHAPE_L, VoxelShapes.or(EAST_SHAPE_R));
    protected static final VoxelShape WEST_SHAPE_R = Block.makeCuboidShape(9.0D, 0.0D, 0.0D, 16.0D, 16.0D, 4.0D);
    protected static final VoxelShape WEST_SHAPE_L = Block.makeCuboidShape(9.0D, 0.0D, 12.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape WEST_SHAPE = VoxelShapes.or(WEST_SHAPE_L, VoxelShapes.or(WEST_SHAPE_R));
    public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;;

    public Item item;


    public BlockArrowSlit(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties);

        this.setRegistryName(regName);
        item = new BlockItem(this,builder).setRegistryName(regName);


        WNBlocks.BLOCKS.add(this);
        WNBlocks.ITEMBLOCKS.add(item);

    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

        switch((Direction)state.get(FACING))
        {
            case NORTH:
                return NORTH_SHAPE;
            case SOUTH:
                return SOUTH_SHAPE;
            case WEST:
                return WEST_SHAPE;
            case EAST:
                return EAST_SHAPE;
            default:
                return SOUTH_SHAPE;
        }
    }

    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if ((Boolean)stateIn.get(WATERLOGGED)) {
            worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
        }
        return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        BlockPos blockpos = context.getPos();
        IFluidState ifluidstate = context.getWorld().getFluidState(blockpos);

        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite()).with(WATERLOGGED, Boolean.valueOf(Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER)));
    }

    @SuppressWarnings("deprecation")
    public IFluidState getFluidState(BlockState state)
    {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(FACING, WATERLOGGED);
    }
}