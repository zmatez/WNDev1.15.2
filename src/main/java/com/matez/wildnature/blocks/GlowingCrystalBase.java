package com.matez.wildnature.blocks;

import com.matez.wildnature.compatibility.WNLoot;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.render.IRenderLayer;
import net.minecraft.block.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.*;
import net.minecraft.world.storage.loot.LootContext;

import java.util.List;
import java.util.Random;

public class GlowingCrystalBase extends EndRodBlock implements IRenderLayer {
    private static final double height = 16D;
    protected static final VoxelShape SHAPE0 = Block.makeCuboidShape(4.0D, 16D, 4.0D, 12.0D, 6.0D, 12.0D);
    protected static final VoxelShape SHAPE1 = Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 10.0D, 12.0D);
    protected static final VoxelShape SHAPE2 = Block.makeCuboidShape(4.0D, 4.0D, 6.0D, 12.0D, 12.0D, 16.0D);
    protected static final VoxelShape SHAPE3 = Block.makeCuboidShape(4.0D, 4.0D, 0.0D, 12.0D, 12.0D, 10.0D);
    protected static final VoxelShape SHAPE4 = Block.makeCuboidShape(6.0D, 4.0D, 4.0D, 16.0D, 12.0D, 12.0D);
    protected static final VoxelShape SHAPE5 = Block.makeCuboidShape(10.0D, 4.0D, 4.0D, 0.0D, 12.0D, 12.0D);

    private Item item;

    public GlowingCrystalBase(Block.Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties.hardnessAndResistance(1.4F,0.4F).sound(SoundType.GLASS).lightValue(8));


        this.setRegistryName(regName);
        item = new BlockItem(this,builder).setRegistryName(regName);


        WNBlocks.BLOCKS.add(this);
        WNBlocks.ITEMBLOCKS.add(item);

    }

    @Override
    public RenderType getRenderLayer() {
        return RenderType.getTranslucent();
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> list = super.getDrops(state, builder);
        if(list.isEmpty() && Utilities.rint(0,1)==0){
            list.add(new ItemStack(item, 1+Utilities.rint(0,WNLoot.getFortune(builder))));
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
                return SHAPE0;
            case 1://up
                return SHAPE1;
            case 2://north
                return SHAPE2;
            case 3://south
                return SHAPE3;
            case 4://west
                return SHAPE4;
            case 5://east
                return SHAPE5;
        }
        //System.out.println("FACING: " + state.get(FACING).getIndex());
        return SHAPE0;
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

    @Override
    public BlockState getStateForPlacement(BlockState state, Direction facing, BlockState state2, IWorld world, BlockPos pos1, BlockPos pos2, Hand hand) {
        if(state2.isSolid()){
            return state;
        }

        return null;
    }
}
