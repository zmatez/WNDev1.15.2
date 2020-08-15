package com.matez.wildnature.blocks;

import com.matez.wildnature.blocks.boundingboxes.IBoundingBox;
import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.render.IRenderLayer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
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

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StoneSpikeBlock extends BlockBase implements IWaterLoggable, IRenderLayer {
    private IBoundingBox box;
    public static final  EnumProperty<StoneSpikeType> type = EnumProperty.create("type", StoneSpikeType.class);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public StoneSpikeBlock(Properties properties, Item.Properties builder, ResourceLocation regName,IBoundingBox box) {
        super(properties, builder, regName);
        this.setDefaultState(this.getStateContainer().getBaseState().with(type,StoneSpikeType.STALAGMITE).with(WATERLOGGED,false));
        this.box=box;
        this.box.SHAPE = box.generateShape();
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        if(state.get(type)==StoneSpikeType.STALACTITE){
            return box.getUpShape();
        }else if(state.get(type)==StoneSpikeType.STALAGMITE){
            return box.getDownShape();
        }
        return null;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return getShape(state,worldIn,pos,context);
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(type).add(WATERLOGGED);
    }

    public IFluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }

    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (stateIn.get(WATERLOGGED)) {
            worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
        }

        return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockPos blockpos = context.getPos();
        Direction direction = context.getFace();
        IFluidState ifluidstate = context.getWorld().getFluidState(blockpos);
        BlockState blockstate1 = this.getDefaultState().with(WATERLOGGED, Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER));

        if(direction==Direction.UP){
            blockstate1=blockstate1.with(type,StoneSpikeType.STALAGMITE);
        }else if(direction==Direction.DOWN){
            blockstate1=blockstate1.with(type,StoneSpikeType.STALACTITE);
        }

        return blockstate1;
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        return state.get(type)==StoneSpikeType.STALAGMITE ? worldIn.getBlockState(pos.down()).isSolid() : worldIn.getBlockState(pos.up()).isSolid();
    }

    @Override
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        if(stateIn.get(type)==StoneSpikeType.STALACTITE){
            int x = Utilities.rint(0,50);
            if(x==0){
                //worldIn.addParticle();
            }

        }
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        boolean silkTouch = false;
        List<ItemStack> list = new ArrayList<>();
        list.add(new ItemStack(Item.getItemFromBlock(Blocks.COBBLESTONE), 1));


        return list;
    }
}
