package com.matez.wildnature.blocks;

import com.matez.wildnature.Main;
import com.matez.wildnature.compatibility.WNLoot;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.SoundType;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootContext;

import java.util.ArrayList;
import java.util.List;

public class BranchBase extends VWallBlock {
    public BranchBase(Properties properties, Item.Properties builder, ResourceLocation regName, Block logBlock) {
        super(properties.sound(SoundType.WOOD), builder, regName);
    }

    @Override
    public boolean func_220113_a(BlockState p_220113_1_, boolean p_220113_2_, Direction p_220113_3_) {
        Block block = p_220113_1_.getBlock();
        boolean flag = block instanceof BranchBase || block instanceof LeavesBlock;
        return !cannotAttach(block) && p_220113_2_ || flag;
    }

    @Override
    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        IFluidState ifluidstate = worldIn.getFluidState(pos);
        BlockPos blockpos1 = pos.north();
        BlockPos blockpos2 = pos.east();
        BlockPos blockpos3 = pos.south();
        BlockPos blockpos4 = pos.west();
        BlockPos blockpos5 = pos.up();
        BlockPos blockpos6 = pos.down();
        BlockState blockstate = worldIn.getBlockState(blockpos1);
        BlockState blockstate1 = worldIn.getBlockState(blockpos2);
        BlockState blockstate2 = worldIn.getBlockState(blockpos3);
        BlockState blockstate3 = worldIn.getBlockState(blockpos4);
        BlockState blockstate4 = worldIn.getBlockState(blockpos5);
        BlockState blockstate5 = worldIn.getBlockState(blockpos6);
        boolean flag = this.func_220113_a(blockstate, blockstate.isSolidSide(worldIn, blockpos1, Direction.SOUTH), Direction.SOUTH);
        boolean flag1 = this.func_220113_a(blockstate1, blockstate1.isSolidSide(worldIn, blockpos2, Direction.WEST), Direction.WEST);
        boolean flag2 = this.func_220113_a(blockstate2, blockstate2.isSolidSide(worldIn, blockpos3, Direction.NORTH), Direction.NORTH);
        boolean flag3 = this.func_220113_a(blockstate3, blockstate3.isSolidSide(worldIn, blockpos4, Direction.EAST), Direction.EAST);
        boolean flag4 = this.func_220113_a(blockstate4, blockstate4.isSolidSide(worldIn, blockpos5, Direction.UP), Direction.UP);
        boolean flag5 = this.func_220113_a(blockstate5, blockstate5.isSolidSide(worldIn, blockpos6, Direction.DOWN), Direction.DOWN);
        worldIn.setBlockState(pos, this.getDefaultState().with(UP, Boolean.valueOf(flag4)).with(DOWN, Boolean.valueOf(flag5)).with(NORTH, Boolean.valueOf(flag)).with(EAST, Boolean.valueOf(flag1)).with(SOUTH, Boolean.valueOf(flag2)).with(WEST, Boolean.valueOf(flag3)).with(WATERLOGGED, Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER)));

    }

    public void neighborChanged(BlockState state, IWorld worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        IFluidState ifluidstate = worldIn.getFluidState(pos);
        BlockPos blockpos1 = pos.north();
        BlockPos blockpos2 = pos.east();
        BlockPos blockpos3 = pos.south();
        BlockPos blockpos4 = pos.west();
        BlockPos blockpos5 = pos.up();
        BlockPos blockpos6 = pos.down();
        BlockState blockstate = worldIn.getBlockState(blockpos1);
        BlockState blockstate1 = worldIn.getBlockState(blockpos2);
        BlockState blockstate2 = worldIn.getBlockState(blockpos3);
        BlockState blockstate3 = worldIn.getBlockState(blockpos4);
        BlockState blockstate4 = worldIn.getBlockState(blockpos5);
        BlockState blockstate5 = worldIn.getBlockState(blockpos6);
        boolean flag = this.func_220113_a(blockstate, blockstate.isSolidSide(worldIn, blockpos1, Direction.SOUTH), Direction.SOUTH);
        boolean flag1 = this.func_220113_a(blockstate1, blockstate1.isSolidSide(worldIn, blockpos2, Direction.WEST), Direction.WEST);
        boolean flag2 = this.func_220113_a(blockstate2, blockstate2.isSolidSide(worldIn, blockpos3, Direction.NORTH), Direction.NORTH);
        boolean flag3 = this.func_220113_a(blockstate3, blockstate3.isSolidSide(worldIn, blockpos4, Direction.EAST), Direction.EAST);
        boolean flag4 = this.func_220113_a(blockstate4, blockstate4.isSolidSide(worldIn, blockpos5, Direction.UP), Direction.UP);
        boolean flag5 = this.func_220113_a(blockstate5, blockstate5.isSolidSide(worldIn, blockpos6, Direction.DOWN), Direction.DOWN);
        worldIn.setBlockState(pos, this.getDefaultState().with(UP, Boolean.valueOf(flag4)).with(DOWN, Boolean.valueOf(flag5)).with(NORTH, Boolean.valueOf(flag)).with(EAST, Boolean.valueOf(flag1)).with(SOUTH, Boolean.valueOf(flag2)).with(WEST, Boolean.valueOf(flag3)).with(WATERLOGGED, Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER)),19);

    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> list = new ArrayList<>();
        if(WNLoot.isSilkTouch(builder)){
            list.add(new ItemStack(Item.getItemFromBlock(this), 1));
        }else {
            String log = getRegistryName().getPath().toString().replace("branch","log");
            list.add(new ItemStack(Main.getBlockByID("wildnature:"+log), 1));
        }

        return list;
    }

    @Override
    public BlockState rotate(BlockState state, Rotation direction) {
        BlockState b = this.getDefaultState().with(WATERLOGGED,state.get(WATERLOGGED));
        if(direction.equals(Rotation.CLOCKWISE_90)){
            b=b.with(EAST,state.get(NORTH));
            b=b.with(SOUTH,state.get(EAST));
            b=b.with(WEST,state.get(SOUTH));
            b=b.with(NORTH,state.get(WEST));
        }else if(direction.equals(Rotation.COUNTERCLOCKWISE_90)){
            b=b.with(NORTH,state.get(EAST));
            b=b.with(EAST,state.get(SOUTH));
            b=b.with(SOUTH,state.get(WEST));
            b=b.with(WEST,state.get(NORTH));
        }else{
            BlockState b1 = b;
            b1=b1.with(EAST,state.get(NORTH));
            b1=b1.with(SOUTH,state.get(EAST));
            b1=b1.with(WEST,state.get(SOUTH));
            b1=b1.with(NORTH,state.get(WEST));

            b=b1;

            b=b.with(EAST,b1.get(NORTH));
            b=b.with(SOUTH,b1.get(EAST));
            b=b.with(WEST,b1.get(SOUTH));
            b=b.with(NORTH,b1.get(WEST));
        }
        b = b.with(UP,state.get(UP)).with(DOWN,state.get(DOWN));
        return b;
    }

}
