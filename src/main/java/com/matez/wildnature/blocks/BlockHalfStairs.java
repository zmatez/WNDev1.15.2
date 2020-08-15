package com.matez.wildnature.blocks;

import com.matez.wildnature.Main;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.lists.WNItems;
import com.matez.wildnature.render.IRenderLayer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.*;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import java.util.Objects;

public class BlockHalfStairs extends BlockBase implements IWaterLoggable, IRenderLayer {
    public static final EnumProperty<VariantType> VARIANT = EnumProperty.create("variant", VariantType.class);
    public static DirectionProperty FACING = DirectionalBlock.FACING;
    public static IntegerProperty TYPE = IntegerProperty.create("type", 0, 1);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public Item item;


    public BlockHalfStairs(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties,builder,regName);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(VARIANT, VariantType.TOP).with(TYPE, 0).with(WATERLOGGED, false));
    }


    @Override
    public RenderType getRenderLayer() {
        return RenderType.getCutout();
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {


        switch((Direction)state.get(FACING)){
        case NORTH: {
            switch (state.get(VARIANT)) {
                case TOP: {
                    switch (state.get(TYPE)) {
                        case 0: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 0, 12, 16, 16, 16), Block.makeCuboidShape(0, 8, 8, 16, 16, 12), IBooleanFunction.OR);
                        }
                        case 1: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 0, 4, 16, 16, 16), Block.makeCuboidShape(0, 8, 0, 16, 16, 12), IBooleanFunction.OR);
                        }
                        default: {
                            return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
                        }
                    }
                }
                case LEFT: {
                    switch (state.get(TYPE)) {
                        case 0: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 0, 12, 16, 16, 16), Block.makeCuboidShape(8, 0, 8, 16, 16, 12), IBooleanFunction.OR);
                        }
                        case 1: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 0, 4, 16, 16, 16), Block.makeCuboidShape(8, 0, 0, 16, 16, 12), IBooleanFunction.OR);
                        }
                        default: {
                            return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
                        }
                    }
                }
                case RIGHT: {
                    switch (state.get(TYPE)) {
                        case 0: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 0, 12, 16, 16, 16), Block.makeCuboidShape(0, 0, 8, 8, 16, 12), IBooleanFunction.OR);
                        }
                        case 1: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 0, 4, 16, 16, 16), Block.makeCuboidShape(0, 0, 0, 8, 16, 12), IBooleanFunction.OR);
                        }
                        default: {
                            return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
                        }
                    }
                }
                case BOTTOM: {
                    switch (state.get(TYPE)) {
                        case 0: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 0, 12, 16, 16, 16), Block.makeCuboidShape(0, 0, 8, 16, 8, 12), IBooleanFunction.OR);
                        }
                        case 1: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 0, 4, 16, 16, 16), Block.makeCuboidShape(0, 0, 0, 16, 8, 12), IBooleanFunction.OR);
                        }
                        default: {
                            return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
                        }
                    }
                }
                default: {
                    return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
                }
            }
        }
        case SOUTH: {
            switch (state.get(VARIANT)) {
                case TOP: {
                    switch (state.get(TYPE)) {
                        case 0: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 0, 0, 16, 16, 4), Block.makeCuboidShape(0, 8, 4, 16, 16, 8), IBooleanFunction.OR);
                        }
                        case 1: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 0, 0, 16, 16, 12), Block.makeCuboidShape(0, 8, 4, 16, 16, 16), IBooleanFunction.OR);
                        }
                        default: {
                            return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
                        }
                    }
                }
                case LEFT: {
                    switch (state.get(TYPE)) {
                        case 0: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 0, 0, 16, 16, 4), Block.makeCuboidShape(8, 0, 4, 16, 16, 8), IBooleanFunction.OR);
                        }
                        case 1: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 0, 0, 16, 16, 12), Block.makeCuboidShape(8, 0, 4, 16, 16, 16), IBooleanFunction.OR);
                        }
                        default: {
                            return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
                        }
                    }
                }
                case RIGHT: {
                    switch (state.get(TYPE)) {
                        case 0: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 0, 0, 16, 16, 4), Block.makeCuboidShape(0, 0, 4, 8, 16, 8), IBooleanFunction.OR);
                        }
                        case 1: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 0, 0, 16, 16, 12), Block.makeCuboidShape(0, 0, 4, 8, 16, 16), IBooleanFunction.OR);
                        }
                        default: {
                            return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
                        }
                    }
                }
                case BOTTOM: {
                    switch (state.get(TYPE)) {
                        case 0: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 0, 0, 16, 16, 4), Block.makeCuboidShape(0, 0, 4, 16, 8, 8), IBooleanFunction.OR);
                        }
                        case 1: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 0, 0, 16, 16, 12), Block.makeCuboidShape(0, 0, 4, 16, 8, 16), IBooleanFunction.OR);
                        }
                        default: {
                            return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
                        }
                    }
                }
                default: {
                    return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
                }
            }
        }
        case WEST: {
            switch (state.get(VARIANT)) {
                case TOP: {
                    switch (state.get(TYPE)) {
                        case 0: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(12, 0, 0, 16, 16, 16), Block.makeCuboidShape(8, 8, 0, 12, 16, 16), IBooleanFunction.OR);
                        }
                        case 1: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(4, 0, 0, 16, 16, 16), Block.makeCuboidShape(0, 8, 0, 12, 16, 16), IBooleanFunction.OR);
                        }
                        default: {
                            return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
                        }
                    }
                }
                case LEFT: {
                    switch (state.get(TYPE)) {
                        case 0: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(12, 0, 0, 16, 16, 16), Block.makeCuboidShape(8, 0, 8, 12, 16, 16), IBooleanFunction.OR);
                        }
                        case 1: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(4, 0, 0, 16, 16, 16), Block.makeCuboidShape(0, 0, 8, 12, 16, 16), IBooleanFunction.OR);
                        }
                        default: {
                            return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
                        }
                    }
                }
                case RIGHT: {
                    switch (state.get(TYPE)) {
                        case 0: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(12, 0, 0, 16, 16, 16), Block.makeCuboidShape(8, 0, 0, 12, 16, 8), IBooleanFunction.OR);
                        }
                        case 1: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(4, 0, 0, 16, 16, 16), Block.makeCuboidShape(0, 0, 0, 12, 16, 8), IBooleanFunction.OR);
                        }
                        default: {
                            return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
                        }
                    }
                }
                case BOTTOM: {
                    switch (state.get(TYPE)) {
                        case 0: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(12, 0, 0, 16, 16, 16), Block.makeCuboidShape(8, 0, 0, 12, 8, 16), IBooleanFunction.OR);
                        }
                        case 1: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(4, 0, 0, 16, 16, 16), Block.makeCuboidShape(0, 0, 0, 12, 8, 16), IBooleanFunction.OR);
                        }
                        default: {
                            return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
                        }
                    }
                }
                default: {
                    return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
                }
            }
        }
        case EAST: {
            switch (state.get(VARIANT)) {
                case TOP: {
                    switch (state.get(TYPE)) {
                        case 0: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 0, 0, 4, 16, 16), Block.makeCuboidShape(4, 8, 0, 8, 16, 16), IBooleanFunction.OR);
                        }
                        case 1: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 0, 0, 12, 16, 16), Block.makeCuboidShape(4, 8, 0, 16, 16, 16), IBooleanFunction.OR);
                        }
                        default: {
                            return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
                        }
                    }
                }
                case LEFT: {
                    switch (state.get(TYPE)) {
                        case 0: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 0, 0, 4, 16, 16), Block.makeCuboidShape(4, 0, 8, 8, 16, 16), IBooleanFunction.OR);
                        }
                        case 1: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 0, 0, 12, 16, 16), Block.makeCuboidShape(4, 0, 8, 16, 16, 16), IBooleanFunction.OR);
                        }
                        default: {
                            return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
                        }
                    }
                }
                case RIGHT: {
                    switch (state.get(TYPE)) {
                        case 0: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 0, 0, 4, 16, 16), Block.makeCuboidShape(4, 0, 0, 8, 16, 8), IBooleanFunction.OR);
                        }
                        case 1: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 0, 0, 12, 16, 16), Block.makeCuboidShape(4, 0, 0, 16, 16, 8), IBooleanFunction.OR);
                        }
                        default: {
                            return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
                        }
                    }
                }
                case BOTTOM: {
                    switch (state.get(TYPE)) {
                        case 0: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 0, 0, 4, 16, 16), Block.makeCuboidShape(4, 0, 0, 8, 8, 16), IBooleanFunction.OR);
                        }
                        case 1: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 0, 0, 12, 16, 16), Block.makeCuboidShape(4, 0, 0, 16, 8, 16), IBooleanFunction.OR);
                        }
                        default: {
                            return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
                        }
                    }
                }
                default: {
                    return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
                }
            }
        }
        case UP: {
            switch (state.get(VARIANT)) {
                case TOP: {
                    switch (state.get(TYPE)) {
                        case 0: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 0, 0, 16, 4, 16), Block.makeCuboidShape(0, 4, 8, 16, 8, 16), IBooleanFunction.OR);
                        }
                        case 1: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 0, 0, 16, 12, 16), Block.makeCuboidShape(0, 12, 8, 16, 16, 16), IBooleanFunction.OR);
                        }
                        default: {
                            return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
                        }
                    }
                }
                case LEFT: {
                    switch (state.get(TYPE)) {
                        case 0: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 0, 0, 16, 4, 16), Block.makeCuboidShape(8, 4, 0, 16, 8, 16), IBooleanFunction.OR);
                        }
                        case 1: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 0, 0, 16, 12, 16), Block.makeCuboidShape(8, 12, 0, 16, 16, 16), IBooleanFunction.OR);
                        }
                        default: {
                            return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
                        }
                    }
                }
                case RIGHT: {
                    switch (state.get(TYPE)) {
                        case 0: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 0, 0, 16, 4, 16), Block.makeCuboidShape(0, 4, 0, 8, 8, 16), IBooleanFunction.OR);
                        }
                        case 1: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 0, 0, 16, 12, 16), Block.makeCuboidShape(0, 12, 0, 8, 16, 16), IBooleanFunction.OR);
                        }
                        default: {
                            return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
                        }
                    }
                }
                case BOTTOM: {
                    switch (state.get(TYPE)) {
                        case 0: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 0, 0, 16, 4, 16), Block.makeCuboidShape(0, 4, 0, 16, 8, 8), IBooleanFunction.OR);
                        }
                        case 1: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 0, 0, 16, 12, 16), Block.makeCuboidShape(0, 12, 0, 16, 16, 8), IBooleanFunction.OR);
                        }
                        default: {
                            return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
                        }
                    }
                }
                default: {
                    return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
                }
            }
        }
        case DOWN: {
            switch (state.get(VARIANT)) {
                case TOP: {
                    switch (state.get(TYPE)) {
                        case 0: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 12, 0, 16, 16, 16), Block.makeCuboidShape(0, 8, 8, 16, 12, 16), IBooleanFunction.OR);
                        }
                        case 1: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 4, 0, 16, 16, 16), Block.makeCuboidShape(0, 0, 8, 16, 12, 16), IBooleanFunction.OR);
                        }
                        default: {
                            return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
                        }
                    }
                }
                case LEFT: {
                    switch (state.get(TYPE)) {
                        case 0: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 12, 0, 16, 16, 16), Block.makeCuboidShape(8, 8, 0, 16, 12, 16), IBooleanFunction.OR);
                        }
                        case 1: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 4, 0, 16, 16, 16), Block.makeCuboidShape(8, 0, 0, 16, 12, 16), IBooleanFunction.OR);
                        }
                        default: {
                            return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
                        }
                    }
                }
                case RIGHT: {
                    switch (state.get(TYPE)) {
                        case 0: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 12, 0, 16, 16, 16), Block.makeCuboidShape(0, 8, 0, 8, 12, 16), IBooleanFunction.OR);
                        }
                        case 1: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 4, 0, 16, 16, 16), Block.makeCuboidShape(0, 0, 0, 8, 12, 16), IBooleanFunction.OR);
                        }
                        default: {
                            return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
                        }
                    }
                }
                case BOTTOM: {
                    switch (state.get(TYPE)) {
                        case 0: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 12, 0, 16, 16, 16), Block.makeCuboidShape(0, 8, 0, 16, 12, 8), IBooleanFunction.OR);
                        }
                        case 1: {
                            return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 4, 0, 16, 16, 16), Block.makeCuboidShape(0, 0, 0, 16, 12, 8), IBooleanFunction.OR);
                        }
                        default: {
                            return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
                        }
                    }
                }
                default: {
                    return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
                }
            }
        }
        default:
            return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
    }
}

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {

        return this.getDefaultState().with(FACING, context.getFace()).with(VARIANT, getVariantDirection(context)).with(TYPE, 0);

    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity entity, Hand hand, BlockRayTraceResult rayTraceResult){

        return getTypeCycle(state, world, pos, entity, hand, rayTraceResult,1, TYPE);

    }

    public ActionResultType getTypeCycle(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult rayTraceResult, int setMaxType, IntegerProperty getProperty) {
        if(player.getHeldItem(handIn).getItem()== WNItems.CHISEL) {
            int currentType = (Integer)state.get(getProperty);
            int validType;
            if (currentType >= setMaxType) {
                validType = 0;
            } else {
                validType = currentType + 1;
            }

            world.setBlockState(pos, (BlockState)state.with(getProperty, validType));
            return ActionResultType.SUCCESS;
        } else {
            return ActionResultType.PASS;
        }
    }

    public static VariantType getVariantDirection(BlockItemUseContext context) {
        BlockPos pos = context.getPos();
        double hitX = context.getHitVec().getX() - (double)pos.getX();
        double hitZ = context.getHitVec().getZ() - (double)pos.getZ();
        double hitY = context.getHitVec().getY() - (double)pos.getY();
        Direction face = context.getFace();
        switch(face) {
            case NORTH:
            case SOUTH:
                if (hitX < 0.75D) {
                    if (hitX < 0.25D) {
                        return VariantType.RIGHT;
                    }

                    if (hitY < 0.5D) {
                        return VariantType.BOTTOM;
                    }

                    return VariantType.TOP;
                }

                return VariantType.LEFT;
            case WEST:
            case EAST:
                if (hitZ < 0.75D) {
                    if (hitZ < 0.25D) {
                        return VariantType.RIGHT;
                    }

                    if (hitY < 0.5D) {
                        return VariantType.BOTTOM;
                    }

                    return VariantType.TOP;
                }

                return VariantType.LEFT;
            case UP:
            case DOWN:
                if (hitX < 0.75D) {
                    if (hitX < 0.25D) {
                        return VariantType.RIGHT;
                    }

                    if (hitZ < 0.5D) {
                        return VariantType.BOTTOM;
                    }

                    return VariantType.TOP;
                }

                return VariantType.LEFT;
            default:
                return VariantType.RIGHT;
        }
    }

    @Override
    public boolean isReplaceable(BlockState state, BlockItemUseContext context) {
        if(Objects.requireNonNull(context.getPlayer()).isCreative()) {
            ItemStack itemStack = context.getItem();
            if (itemStack.getItem() == this.asItem()) {
                if (context.replacingClickedOnBlock()) {
                    return true;
                } else {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if ((Boolean)stateIn.get(WATERLOGGED)) {
            worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
        }
        return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    public IFluidState getFluidState(BlockState state)
    {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(FACING, WATERLOGGED).add(VARIANT).add(TYPE);
    }

    public enum VariantType implements IStringSerializable {
        TOP("top"),
        RIGHT("right"),
        LEFT("left"),
        BOTTOM("bottom");

        private String name;
        private VariantType(String name){
            this.name=name;
        }
        @Override
        public String getName() {
            return name;
        }

        public VariantType rotate(Rotation rot){
            if(rot==Rotation.CLOCKWISE_90){
                if(this==TOP){
                    return RIGHT;
                }else if(this==RIGHT){
                    return BOTTOM;
                }else if(this==BOTTOM){
                    return LEFT;
                }else if(this==LEFT){
                    return TOP;
                }
            }else if(rot==Rotation.CLOCKWISE_180){
                if(this==TOP){
                    return BOTTOM;
                }else if(this==RIGHT){
                    return LEFT;
                }else if(this==BOTTOM){
                    return TOP;
                }else if(this==LEFT){
                    return RIGHT;
                }
            }else if(rot==Rotation.COUNTERCLOCKWISE_90){
                if(this==TOP){
                    return LEFT;
                }else if(this==RIGHT){
                    return TOP;
                }else if(this==BOTTOM){
                    return RIGHT;
                }else if(this==LEFT){
                    return BOTTOM;
                }
            }
            return this;
        }
        /*public VariantType mirror(Mirror mir){
            if(mir==Mirror.FRONT_BACK){
                if(this==TOP){
                    return BOTTOM;
                }else if(this==RIGHT){
                    return LEFT;
                }else if(this==BOTTOM){
                    return TOP;
                }else if(this==LEFT){
                    return RIGHT;
                }
            }else if(mir==Mirror.LEFT_RIGHT){

            }*/
        }

    /**
     * Returns the blockstate with the given rotation from the passed blockstate. If inapplicable, returns the passed
     * blockstate.
     * @deprecated call via {@link #( Rotation )} whenever possible. Implementing/overriding is
     * fine.
     */
    public BlockState rotate(BlockState state, Rotation rot) {
        if(state.get(FACING)==Direction.UP || state.get(FACING)==Direction.DOWN){
            return state.with(VARIANT,state.get(VARIANT).rotate(rot));
        }
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    /**
     * Returns the blockstate with the given mirror of the passed blockstate. If inapplicable, returns the passed
     * blockstate.
     * @deprecated call via {@link #(Mirror)} whenever possible. Implementing/overriding is fine.
     */
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.with(FACING, mirrorIn.mirror(state.get(FACING)));
    }

    @Override
    public BlockState rotate(BlockState state, IWorld world, BlockPos pos, Rotation rot) {
        if(state.get(FACING)==Direction.UP || state.get(FACING)==Direction.DOWN){
            return state.with(VARIANT,state.get(VARIANT).rotate(rot));
        }
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }
}

