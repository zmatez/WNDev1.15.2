package com.matez.wildnature.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;

public class FormationVerticalBase extends FormationBase {
    public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.Plane.VERTICAL);

    public FormationVerticalBase(Properties properties, Item.Properties builder, ResourceLocation regName, int bigRarity) {
        super(properties, builder, regName, bigRarity);
    }

    public FormationVerticalBase(Properties properties, ResourceLocation regName, int bigRarity) {
        super(properties, regName, bigRarity);
    }

    public FormationVerticalBase(Properties properties, Item.Properties builder, String dropSmall, String dropBig, int minSmall, int maxSmall, int minBig, int maxBig, int expSmall, int expBig, ResourceLocation regName, int bigRarity) {
        super(properties, builder, dropSmall, dropBig, minSmall, maxSmall, minBig, maxBig, expSmall, expBig, regName, bigRarity);
    }



    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch(state.get(FACING).getIndex()) {
            case 0://down
                return DOWN;
            case 1://up
                return UP;
        }
        //System.out.println("FACING: " + state.get(FACING).getIndex());
        return DOWN;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return getShape(state,worldIn,pos,context);
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockState state = super.getStateForPlacement(context);
        if(state==null){
            return null;
        }
        if(context.getFace()==Direction.UP){
            return state.with(FACING,Direction.UP);
        }else if(context.getFace()==Direction.DOWN){
            return state.with(FACING,Direction.DOWN);
        }
        return null;
    }

    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        BlockState state = super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);

        return isValidPosition(state,worldIn,currentPos) ? state : Blocks.AIR.getDefaultState();
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        Direction dir = state.get(FACING).getOpposite();
        return worldIn.getBlockState(pos.offset(dir)).isSolid();
    }
}
