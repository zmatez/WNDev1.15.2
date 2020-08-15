package com.matez.wildnature.blocks;

import com.matez.wildnature.lists.WNItems;
import com.matez.wildnature.other.Utilities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootContext;

import java.util.List;

public class TomatoPlant extends CropBase {
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 2.0D, 14.0D), Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 4.0D, 14.0D), Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 6.0D, 14.0D), Block.makeCuboidShape(0.2D, 0.0D, 0.2D, 14.0D, 8.0D, 14.0D), Block.makeCuboidShape(0.2D, 0.0D, 0.2D, 14.0D, 10.0D, 14.0D), Block.makeCuboidShape(0.2D, 0.0D, 0.2D, 14.0D, 10.0D, 14.0D), Block.makeCuboidShape(0.2D, 0.0D, 0.2D, 14.0D, 10.0D, 14.0D), Block.makeCuboidShape(0.2D, 0.0D, 0.2D, 14.0D, 10.0D, 14.0D)};

    public TomatoPlant(Properties properties,  ResourceLocation regName) {
        super(properties, null, regName);
    }

    protected IItemProvider getSeedsItem() {
        return WNItems.TOMATO_SEEDS;
    }
    protected int getBonemealAgeIncrease(World worldIn) {
        return MathHelper.nextInt(worldIn.rand, 1, 3);
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE_BY_AGE[state.get(this.getAgeProperty())];
    }


    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(state.get(AGE)==7){
            worldIn.setBlockState(pos,worldIn.getBlockState(pos).with(AGE,4));
            spawnAsEntity(worldIn,pos,new ItemStack(WNItems.TOMATO, Utilities.rint(1,4)));
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
            if(state.get(AGE)==7) {
                list.add(new ItemStack(WNItems.TOMATO, Utilities.rint(1, 4)));
                if(Utilities.rint(0,2)==0) {
                    list.add(new ItemStack(WNItems.TOMATO_SEEDS, Utilities.rint(1, 3)));
                }
            }else{
                list.add(new ItemStack(WNItems.TOMATO_SEEDS, 1));
            }
        }

        return list;
    }
}
