package com.matez.wildnature.blocks;

import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.lists.WNItems;
import com.matez.wildnature.other.Utilities;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class CurrantPlant extends CropBase {

    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 4);
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 3.0D, 14.0D), Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 5.0D, 14.0D), Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 8.0D, 14.0D), Block.makeCuboidShape(0.2D, 0.0D, 0.2D, 14.0D, 10.0D, 14.0D), Block.makeCuboidShape(0.2D, 0.0D, 0.2D, 14.0D, 10.0D, 14.0D)};

    public CurrantPlant(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties, builder, regName);
    }

    @Override
    public IntegerProperty getAge() {
        return AGE;
    }

    @Override
    protected IItemProvider getSeedsItem() {
        if(this== WNBlocks.BUSH_BLACK_CURRANT){
            return this;
        }else if(this== WNBlocks.BUSH_RED_CURRANT){
            return this;
        }else{
            return this;
        }
    }
    @Override
    protected int getBonemealAgeIncrease(World worldIn) {
        return MathHelper.nextInt(worldIn.rand, 1, 2);
    }
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE_BY_AGE[state.get(this.getAgeProperty())];
    }
    @Override
    public int getMaxAge() {
        return 4;
    }


    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(state.get(AGE)==4){
            worldIn.setBlockState(pos,worldIn.getBlockState(pos).with(AGE,3));

            if(this== WNBlocks.BUSH_BLACK_CURRANT){
                spawnAsEntity(worldIn,pos,new ItemStack(WNItems.BLACK_CURRANT, Utilities.rint(1,2)));
            }else if(this== WNBlocks.BUSH_RED_CURRANT){
                spawnAsEntity(worldIn,pos,new ItemStack(WNItems.RED_CURRANT, Utilities.rint(1,2)));
            }else{
                spawnAsEntity(worldIn,pos,new ItemStack(WNItems.WHITE_CURRANT, Utilities.rint(1,2)));
            }
            worldIn.playSound((PlayerEntity)null, pos, SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);

            return ActionResultType.SUCCESS;
        }
        return ActionResultType.PASS;
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        boolean silkTouch = false;
        List<ItemStack> list = super.getDrops(state, builder);
        if(list.isEmpty() && !silkTouch){
            if(state.get(AGE)==5) {

                if(this== WNBlocks.BUSH_BLACK_CURRANT){
                    list.add(new ItemStack(WNItems.BLACK_CURRANT, Utilities.rint(1, 2)));
                }else if(this== WNBlocks.BUSH_RED_CURRANT){
                    list.add(new ItemStack(WNItems.RED_CURRANT, Utilities.rint(1, 2)));
                }else{
                    list.add(new ItemStack(WNItems.WHITE_CURRANT, Utilities.rint(1, 2)));
                }
            }
        }

        return list;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.down();
        return this.isValidGround(worldIn.getBlockState(blockpos), worldIn, blockpos);
    }

    public boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        Block block = state.getBlock();
        return block instanceof SnowyDirtBlock || block instanceof FarmlandBlock  || block instanceof PodzolBase;
    }

    public Block.OffsetType getOffsetType() {
        return Block.OffsetType.XZ;
    }

    @OnlyIn(Dist.CLIENT)
    public long getPositionRandom(BlockState state, BlockPos pos) {
        return MathHelper.getCoordinateRandom(pos.getX(), pos.getY(), pos.getZ());
    }

}
