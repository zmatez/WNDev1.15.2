package com.matez.wildnature.blocks;

import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.render.IRenderLayer;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootContext;

import java.util.List;
import java.util.Random;

public class LightningBugBlock extends EndRodBlock implements IRenderLayer {
    private static final double height = 16D;
    protected static final VoxelShape UP = Block.makeCuboidShape(4.0D, 0D, 4.0D, 12.0D, 1.0D, 12.0D);
    protected static final VoxelShape DOWN = Block.makeCuboidShape(4.0D, 15.0D, 4.0D, 12.0D, 16.0D, 12.0D);
    protected static final VoxelShape NORTH = Block.makeCuboidShape(4.0D, 4.0D, 15.0D, 12.0D, 12.0D, 16.0D);
    protected static final VoxelShape SOUTH = Block.makeCuboidShape(4.0D, 4.0D, 0.0D, 12.0D, 12.0D, 1.0D);
    protected static final VoxelShape EAST = Block.makeCuboidShape(1.0D, 4.0D, 4.0D, 0.0D, 12.0D, 12.0D);
    protected static final VoxelShape WEST = Block.makeCuboidShape(15.0D, 4.0D, 4.0D, 16.0D, 12.0D, 12.0D);

    private Item item;

    public LightningBugBlock(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties.hardnessAndResistance(1.4F,0.4F).sound(SoundType.SWEET_BERRY_BUSH).lightValue(8));


        this.setRegistryName(regName);
        item = new BlockItem(this,builder).setRegistryName(regName);


        WNBlocks.BLOCKS.add(this);
        WNBlocks.ITEMBLOCKS.add(item);

    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        Direction direction = state.get(FACING);
        BlockState wall = worldIn.getBlockState(pos.offset(direction.getOpposite()));
        if(wall.isIn(BlockTags.LEAVES)||wall.isIn(BlockTags.LOGS)){
            return true;
        }
        return false;
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> list = super.getDrops(state, builder);
        if(list.isEmpty()){
            list.add(new ItemStack(item, 1));
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

    /**
     * Gets the render layer this block will render on. SOLID for solid blocks, CUTOUT or CUTOUT_MIPPED for on-off
     * transparency (glass, reeds), TRANSLUCENT for fully blended transparency (stained glass)
     */


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

    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        BlockPos stay = null;
        if(true){
            return stateIn;
        }

        int f = stateIn.get(FACING).getIndex();
        if(f==0){
            stay = currentPos.up();
        }else if(f==1){
            stay = currentPos.down();
        }else if(f==2){
            stay = currentPos.south();
        }else if(f==3){
            stay = currentPos.north();
        }else if(f==4){
            stay = currentPos.east();
        }else if(f==5){
            stay = currentPos.west();
        }


        if(stay!=null) {
            BlockState downstate = worldIn.getBlockState(stay);
            if (!isSolid(downstate)) {
                return Blocks.AIR.getDefaultState();
            } else {
                return stateIn;
            }
        }else{
            return stateIn;
        }
    }


}
