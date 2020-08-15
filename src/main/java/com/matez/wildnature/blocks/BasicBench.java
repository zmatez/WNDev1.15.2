package com.matez.wildnature.blocks;

import com.matez.wildnature.render.IRenderLayer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

public class BasicBench extends HorizontalBase implements IRenderLayer {

    public static final EnumProperty<ConnectingFurnitureType> PART = EnumProperty.create("part", ConnectingFurnitureType.class);

    public BasicBench(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties.notSolid(), builder, regName);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(PART, ConnectingFurnitureType.MIDDLE));

    }

    public BasicBench(Properties properties, Item.Properties builder, String drop, int min, int max, int exp, ResourceLocation regName) {
        super(properties, builder, drop, min, max, exp, regName);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(PART, ConnectingFurnitureType.MIDDLE));

    }

    @Override
    public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return false;
    }

    @Override
    public RenderType getRenderLayer() {
        return RenderType.getCutout();
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return makeCuboidShape(0, 0, 0, 16, 11, 16);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        BlockState state = super.getStateForPlacement(context);
        return this.getBenchState(state, context.getWorld(), context.getPos(), state.get(FACING));
    }

    @Override
    public BlockState updatePostPlacement(BlockState state, Direction direction, BlockState newState, IWorld world, BlockPos pos, BlockPos newPos)
    {
        return this.getBenchState(state, world, pos, state.get(FACING));
    }

    private BlockState getBenchState(BlockState state, IWorld world, BlockPos pos, Direction dir) {
        boolean left = this.isBench(world, pos, dir.rotateY(), dir);
        boolean right = this.isBench(world, pos, dir.rotateYCCW(), dir);
        if (left && right) {
            return (BlockState)state.with(PART, ConnectingFurnitureType.MIDDLE);
        } else if (left) {
            return (BlockState)state.with(PART, ConnectingFurnitureType.LEFT);
        } else {
            return right ? (BlockState)state.with(PART, ConnectingFurnitureType.RIGHT) : (BlockState)state.with(PART, ConnectingFurnitureType.MIDDLE);
        }
    }

    private boolean isBench(IWorld world, BlockPos source, Direction direction, Direction targetDirection)
    {
        BlockState state = world.getBlockState(source.offset(direction));
        if(state.getBlock() == this)
        {
            Direction sofaDirection = state.get(FACING);
            return sofaDirection.equals(targetDirection);
        }
        return false;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(FACING, PART);
    }

    public enum ConnectingFurnitureType implements IStringSerializable {
        LEFT("left"),
        MIDDLE("middle"),
        RIGHT("right");

        private final String name;

        private ConnectingFurnitureType(String name) {
            this.name = name;
        }

        public String toString() {
            return this.name;
        }

        public String getName() {
            return this.name;
        }
    }


}
