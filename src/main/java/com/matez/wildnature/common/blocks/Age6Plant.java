package com.matez.wildnature.common.blocks;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.config.CommonConfig;
import com.matez.wildnature.util.other.Utilities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
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

import java.util.List;

public class Age6Plant extends CropBase {

    public static final IntegerProperty AGE = BlockStateProperties.AGE_0_5;
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 2.0D, 14.0D), Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 4.0D, 14.0D), Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 6.0D, 14.0D), Block.makeCuboidShape(0.2D, 0.0D, 0.2D, 14.0D, 8.0D, 14.0D), Block.makeCuboidShape(0.2D, 0.0D, 0.2D, 14.0D, 10.0D, 14.0D), Block.makeCuboidShape(0.2D, 0.0D, 0.2D, 14.0D, 10.0D, 14.0D)};

    private String drop;
    public Age6Plant(Properties properties, ResourceLocation regName, String drop) {
        super(properties, null, regName);
        this.drop=drop;
    }
    @Override
    protected IItemProvider getSeedsItem() {
        return WN.getItemByID(drop);
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
        return 5;
    }


    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(state.get(AGE)==getMaxAge()){
            worldIn.setBlockState(pos,worldIn.getBlockState(pos).with(AGE,getMaxAge()-Utilities.rint(1,2)));
            spawnAsEntity(worldIn, pos, new ItemStack(WN.getItemByID(drop), Utilities.rint(1, 2)));
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
            if(state.get(AGE)==getMaxAge()) {
                list.add(new ItemStack(WN.getItemByID(drop), Utilities.rint(1, 2)));

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
        if (state.getBlock() == this) //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
            return worldIn.getBlockState(blockpos).canSustainPlant(worldIn, blockpos, Direction.UP, this);
        return this.isValidGround(worldIn.getBlockState(blockpos), worldIn, blockpos);
    }

    public boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        Block block = state.getBlock();
        if(!CommonConfig.vegeGrassSpawn.get()) {
            return block == Blocks.FARMLAND;
        }
        return block == Blocks.GRASS_BLOCK || block == Blocks.DIRT || block == Blocks.COARSE_DIRT || block == Blocks.PODZOL || block == Blocks.FARMLAND;

    }

}
