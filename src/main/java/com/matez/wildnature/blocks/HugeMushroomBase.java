package com.matez.wildnature.blocks;

import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.lists.WNItems;
import com.matez.wildnature.other.Utilities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SixWayBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HugeMushroomBase extends BlockBase {
    public static final BooleanProperty NORTH;
    public static final BooleanProperty EAST;
    public static final BooleanProperty SOUTH;
    public static final BooleanProperty WEST;
    public static final BooleanProperty UP;
    public static final BooleanProperty DOWN;
    private static final Map<Direction, BooleanProperty> field_196462_B;

    public HugeMushroomBase(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties, builder, regName);
        this.setDefaultState((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.stateContainer.getBaseState()).with(NORTH, true)).with(EAST, true)).with(SOUTH, true)).with(WEST, true)).with(UP, true)).with(DOWN, true));

    }

    public HugeMushroomBase(Properties properties, Item.Properties builder, String drop, int min, int max, int exp, ResourceLocation regName) {
        super(properties, builder, drop, min, max, exp, regName);
    }


    public BlockState getStateForPlacement(BlockItemUseContext p_196258_1_) {
        IBlockReader lvt_2_1_ = p_196258_1_.getWorld();
        BlockPos lvt_3_1_ = p_196258_1_.getPos();
        return (BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.getDefaultState().with(DOWN, this != lvt_2_1_.getBlockState(lvt_3_1_.down()).getBlock())).with(UP, this != lvt_2_1_.getBlockState(lvt_3_1_.up()).getBlock())).with(NORTH, this != lvt_2_1_.getBlockState(lvt_3_1_.north()).getBlock())).with(EAST, this != lvt_2_1_.getBlockState(lvt_3_1_.east()).getBlock())).with(SOUTH, this != lvt_2_1_.getBlockState(lvt_3_1_.south()).getBlock())).with(WEST, this != lvt_2_1_.getBlockState(lvt_3_1_.west()).getBlock());
    }

    public BlockState updatePostPlacement(BlockState p_196271_1_, Direction p_196271_2_, BlockState p_196271_3_, IWorld p_196271_4_, BlockPos p_196271_5_, BlockPos p_196271_6_) {
        return p_196271_3_.getBlock() == this ? (BlockState)p_196271_1_.with((IProperty)field_196462_B.get(p_196271_2_), false) : super.updatePostPlacement(p_196271_1_, p_196271_2_, p_196271_3_, p_196271_4_, p_196271_5_, p_196271_6_);
    }

    public BlockState rotate(BlockState p_185499_1_, Rotation p_185499_2_) {
        return (BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)p_185499_1_.with((IProperty)field_196462_B.get(p_185499_2_.rotate(Direction.NORTH)), p_185499_1_.get(NORTH))).with((IProperty)field_196462_B.get(p_185499_2_.rotate(Direction.SOUTH)), p_185499_1_.get(SOUTH))).with((IProperty)field_196462_B.get(p_185499_2_.rotate(Direction.EAST)), p_185499_1_.get(EAST))).with((IProperty)field_196462_B.get(p_185499_2_.rotate(Direction.WEST)), p_185499_1_.get(WEST))).with((IProperty)field_196462_B.get(p_185499_2_.rotate(Direction.UP)), p_185499_1_.get(UP))).with((IProperty)field_196462_B.get(p_185499_2_.rotate(Direction.DOWN)), p_185499_1_.get(DOWN));
    }

    public BlockState mirror(BlockState p_185471_1_, Mirror p_185471_2_) {
        return (BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)p_185471_1_.with((IProperty)field_196462_B.get(p_185471_2_.mirror(Direction.NORTH)), p_185471_1_.get(NORTH))).with((IProperty)field_196462_B.get(p_185471_2_.mirror(Direction.SOUTH)), p_185471_1_.get(SOUTH))).with((IProperty)field_196462_B.get(p_185471_2_.mirror(Direction.EAST)), p_185471_1_.get(EAST))).with((IProperty)field_196462_B.get(p_185471_2_.mirror(Direction.WEST)), p_185471_1_.get(WEST))).with((IProperty)field_196462_B.get(p_185471_2_.mirror(Direction.UP)), p_185471_1_.get(UP))).with((IProperty)field_196462_B.get(p_185471_2_.mirror(Direction.DOWN)), p_185471_1_.get(DOWN));
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(new IProperty[]{UP, DOWN, NORTH, EAST, SOUTH, WEST});
    }

    static {
        NORTH = SixWayBlock.NORTH;
        EAST = SixWayBlock.EAST;
        SOUTH = SixWayBlock.SOUTH;
        WEST = SixWayBlock.WEST;
        UP = SixWayBlock.UP;
        DOWN = SixWayBlock.DOWN;
        field_196462_B = SixWayBlock.FACING_TO_PROPERTY_MAP;
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> l = new ArrayList<>();
        if (state.getBlock() == WNBlocks.GLOWSHROOM_BLOCK || state.getBlock() == WNBlocks.GLOWSHROOM_STEM) {
            l.add(new ItemStack(WNItems.GLOWSHROOM_DUST, Utilities.rint(1, 2)));
            if(Utilities.rint(0,3)==0) {
                l.add(new ItemStack(Items.GLOWSTONE_DUST, 1));
            }
            if(Utilities.rint(0,3)==0) {
                l.add(new ItemStack(this.getItem(), 1));
            }
            return l;
        }
        return super.getDrops(state,builder);
    }
}