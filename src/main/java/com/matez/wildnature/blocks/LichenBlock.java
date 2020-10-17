package com.matez.wildnature.blocks;

import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.lists.WNItems;
import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.render.IRenderLayer;
import net.minecraft.block.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.*;
import net.minecraft.world.storage.loot.LootContext;

import java.util.List;
import java.util.Random;

public class LichenBlock extends EndRodBlock implements IRenderLayer {
    private static final double height = 16D;
    protected static final VoxelShape UP = Block.makeCuboidShape(15.0D, 0D, 15.0D, 1, 1.0D, 1);
    protected static final VoxelShape DOWN = Block.makeCuboidShape(15, 15.0D, 15, 1, 16.0D, 1);
    protected static final VoxelShape NORTH = Block.makeCuboidShape(15, 15, 15.0D, 1, 1, 16.0D);
    protected static final VoxelShape SOUTH = Block.makeCuboidShape(15, 15, 0.0D, 1, 1, 1.0D);
    protected static final VoxelShape EAST = Block.makeCuboidShape(1.0D, 15, 15, 0.0D, 1, 1);
    protected static final VoxelShape WEST = Block.makeCuboidShape(15.0D, 15, 15, 16.0D, 1, 1);

    private Item item;

    public LichenBlock(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties.hardnessAndResistance(1.4F,0.4F).sound(SoundType.SWEET_BERRY_BUSH).lightValue(8));


        this.setRegistryName(regName);
        item = new BlockItem(this,builder).setRegistryName(regName);


        WNBlocks.BLOCKS.add(this);
        WNBlocks.ITEMBLOCKS.add(item);

    }

    @Override
    public RenderType getRenderLayer() {
        return RenderType.getCutoutMipped();
    }

    @Override
    public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
        return 0;
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> list = super.getDrops(state, builder);
        if(list.isEmpty()){
            if(Utilities.rint(0,5)==0) {
                list.add(new ItemStack(item, 1));
            }
        }

        return list;
    }

    public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0;
    }


    @Override
    public boolean isNormalCube(BlockState p_220081_1_, IBlockReader p_220081_2_, BlockPos p_220081_3_) {
        return false;
    }

    @Override
    public boolean isTransparent(BlockState p_220074_1_) {
        return true;
    }

    public boolean causesSuffocation(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return false;
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch(state.get(FACING).getIndex()) {
            case 0://down
                return DOWN;
            case 1://up
                return UP;
            case 2://north
                return NORTH;
            case 3://south
                return SOUTH;
            case 4://west
                return WEST;
            case 5://east
                return EAST;
        }
        //System.out.println("FACING: " + state.get(FACING).getIndex());
        return DOWN;
    }

    @Override
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {

    }

    @Override
    public void onNeighborChange(BlockState state, IWorldReader world, BlockPos pos, BlockPos neighbor) {

    }
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        return facing.getOpposite() == stateIn.get(FACING) && !stateIn.isValidPosition(worldIn, currentPos) ? Blocks.AIR.getDefaultState() : stateIn;
    }

    public BlockState getStateForPlacement(BlockItemUseContext context) {
        Direction dir = context.getFace();
        if(dir==Direction.DOWN){
            return null;
        }
        BlockState state = context.getWorld().getBlockState(context.getPos().offset(dir.getOpposite()));
        BlockState s = state.getBlock() == this && state.get(FACING) == dir ? (BlockState)this.getDefaultState().with(FACING, dir.getOpposite()) : (BlockState)this.getDefaultState().with(FACING, dir);
        if (s.isValidPosition(context.getWorld(), context.getPos())) {
            return s;
        }
        return null;
    }

    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        Direction direction = state.get(FACING);
        if(direction==Direction.DOWN){
            return false;
        }
        BlockPos blockpos = pos.offset(direction.getOpposite());
        BlockState blockstate = worldIn.getBlockState(blockpos);
        return blockstate.isSolidSide(worldIn, blockpos, direction);
    }

}
