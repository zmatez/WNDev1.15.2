package com.matez.wildnature.common.blocks;

import com.matez.wildnature.common.blocks.boundingboxes.FormationBig;
import com.matez.wildnature.common.blocks.boundingboxes.IBoundingBox;
import com.matez.wildnature.common.compatibility.WNLoot;
import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.other.Utilities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
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
import net.minecraft.world.storage.loot.LootContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FormationBase extends BlockBase {
    public static final EnumProperty<FormationType> TYPE = EnumProperty.create("type", FormationType.class);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public final int bigRarity;
    protected static final VoxelShape UP = Block.makeCuboidShape(2.0D, 0D, 2.0D, 14.0D, 8.0D, 14.0D);
    protected static final VoxelShape DOWN = Block.makeCuboidShape(2.0D, 8.0D, 2.0D, 14.0D, 16.0D, 14.0D);
    protected static final VoxelShape NORTH = Block.makeCuboidShape(2.0D, 2.0D, 8.0D, 14.0D, 14.0D, 16.0D);
    protected static final VoxelShape SOUTH = Block.makeCuboidShape(2.0D, 2.0D, 0.0D, 14.0D, 14.0D, 8.0D);
    protected static final VoxelShape EAST = Block.makeCuboidShape(8.0D, 2.0D, 2.0D, 0.0D, 14.0D, 14.0D);
    protected static final VoxelShape WEST = Block.makeCuboidShape(8.0D, 2.0D, 2.0D, 16.0D, 14.0D, 14.0D);

    public FormationBase(Properties properties, Item.Properties builder, ResourceLocation regName, int bigRarity) {
        super(properties.notSolid(), builder, regName);
        this.setDefaultState(this.getStateContainer().getBaseState().with(TYPE,FormationType.SMALL).with(WATERLOGGED,false));
        this.bigRarity = bigRarity;
    }

    public FormationBase(Properties properties, ResourceLocation regName, int bigRarity) {
        super(properties.notSolid(), regName);
        this.setDefaultState(this.getStateContainer().getBaseState().with(TYPE,FormationType.SMALL).with(WATERLOGGED,false));
        this.bigRarity = bigRarity;
    }

    private String dropSmall, dropBig;
    private int minSmall, maxSmall, minBig, maxBig, expSmall, expBig;
    public FormationBase(Properties properties, Item.Properties builder, String dropSmall, String dropBig, int minSmall, int maxSmall, int minBig, int maxBig, int expSmall, int expBig, ResourceLocation regName, int bigRarity) {
        super(properties.notSolid(), builder, dropSmall, minSmall, maxSmall, expSmall, regName);
        this.dropSmall = dropSmall;
        this.dropBig = dropBig;
        this.minSmall = minSmall;
        this.maxSmall = maxSmall;
        this.minBig = minBig;
        this.maxBig = maxBig;
        this.expSmall = expSmall;
        this.expBig = expBig;
        this.setDefaultState(this.getStateContainer().getBaseState().with(TYPE,FormationType.SMALL).with(WATERLOGGED,false));
        this.bigRarity = bigRarity;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return getShape(state,worldIn,pos,context);
    }


    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(TYPE,WATERLOGGED);
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

    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockPos blockpos = context.getPos();
        IFluidState ifluidstate = context.getWorld().getFluidState(blockpos);
        BlockState blockstate1 = this.getDefaultState().with(WATERLOGGED, Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER));
        CompoundNBT nbt = context.getItem().getOrCreateTag();
        if(context.getPlayer() != null){
            if(context.getPlayer().isCreative() && !nbt.contains("formationType")){
                return getFormationVariant(blockstate1);
            }else if(nbt.contains("formationType")){
                return blockstate1.with(TYPE, nbt.getString("formationType").equals("big") ? FormationType.BIG : FormationType.SMALL);
            }
        }
        return blockstate1;
    }

    public BlockState getFormationVariant(BlockState baseState){
        return bigRarity == 0 ? baseState.with(TYPE,FormationType.SMALL) : (Utilities.rint(0,bigRarity) == 0 ? baseState.with(TYPE,FormationType.BIG) : baseState.with(TYPE,FormationType.SMALL));
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        if(WNLoot.isBrokenByPickaxe(builder)) {
            if (drop != null) {
                List<ItemStack> list = new ArrayList<>();
                if (WNLoot.isSilkTouch(builder)) {
                    ItemStack stack = new ItemStack(Item.getItemFromBlock(this), 1);
                    stack.getOrCreateTag().putString("formationType", state.get(TYPE).getName());
                    list.add(stack);
                } else {
                    int min = 0;
                    int max = 0;
                    String drop = "";
                    if (state.get(TYPE) == FormationType.SMALL) {
                        min = minSmall;
                        max = maxSmall;
                        drop = dropSmall;
                    } else {
                        min = minBig;
                        max = maxBig;
                        drop = dropBig;
                    }
                    list.add(new ItemStack(WN.getItemByID(drop), Utilities.rint(min, max) + Utilities.rint(0, WNLoot.getFortune(builder))));
                }
                return list;
            } else {
                boolean silkTouch = false;
                List<ItemStack> list = super.getDrops(state, builder);
                if (list.isEmpty() && !silkTouch) {
                    list.add(new ItemStack(item, 1));
                }

                return list;
            }
        }
        return Collections.emptyList();
    }

    @Override
    public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch) {
        int exp = 0;
        if(state.get(TYPE) == FormationType.SMALL){
            exp = expSmall;
        }else{
            exp = expBig;
        }
        return exp;
    }
}
