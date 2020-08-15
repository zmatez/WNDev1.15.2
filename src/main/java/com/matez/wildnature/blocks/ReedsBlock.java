package com.matez.wildnature.blocks;

import com.matez.wildnature.lists.WNBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.IPlantable;

import javax.annotation.Nullable;

public class ReedsBlock extends BushBase implements IWaterLoggable {
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public static final EnumProperty<REEDS_HALF> REED_HALF = EnumProperty.create("half", REEDS_HALF.class);

    public ReedsBlock(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties, builder, regName);
    }

    public ReedsBlock(Properties properties, Item.Properties builder, ResourceLocation regName, boolean newProperties) {
        super(properties, builder, regName, newProperties);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(REED_HALF, WATERLOGGED);
    }


    public ReedsBlock(Properties properties, @Nullable Item.Properties builder, String drop, int min, int max, int exp, ResourceLocation regName) {
        super(properties, builder, drop, min, max, exp, regName);
    }

    public void placeAt(IWorld worldIn, BlockPos pos, int flags) {
        IFluidState ifluidstate = worldIn.getFluidState(pos);
        IFluidState ifluidstate2 = worldIn.getFluidState(pos.up());
        IFluidState ifluidstate3 = worldIn.getFluidState(pos.up(2));
        worldIn.setBlockState(pos, this.getDefaultState().with(REED_HALF, REEDS_HALF.BOTTOM).with(WATERLOGGED, Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER)), flags);
        worldIn.setBlockState(pos.up(), this.getDefaultState().with(REED_HALF, REEDS_HALF.MEDIUM).with(WATERLOGGED, Boolean.valueOf(ifluidstate2.getFluid() == Fluids.WATER)), flags);
        worldIn.setBlockState(pos.up(2), this.getDefaultState().with(REED_HALF, REEDS_HALF.TOP).with(WATERLOGGED, Boolean.valueOf(ifluidstate3.getFluid() == Fluids.WATER)), flags);
    }

    @Override
    public void onBlockPlacedBy(World p_180633_1_, BlockPos p_180633_2_, BlockState p_180633_3_, @Nullable LivingEntity p_180633_4_, ItemStack p_180633_5_) {
        placeAt(p_180633_1_,p_180633_2_,2);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockPos blockpos = context.getPos();
        if (isValidPosition(WNBlocks.REEDS.getDefaultState().with(REED_HALF, REEDS_HALF.BOTTOM), context.getWorld(), context.getPos())) {

            IFluidState ifluidstate = context.getWorld().getFluidState(blockpos);
            return blockpos.getY() < context.getWorld().getDimension().getHeight() - 2 && context.getWorld().getBlockState(blockpos.up()).isReplaceable(context) && context.getWorld().getBlockState(blockpos.up(2)).isReplaceable(context) ? this.getDefaultState().with(WATERLOGGED, Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER)) : null;
        }
        return null;
    }


    public void harvestBlock(World worldIn, PlayerEntity player, BlockPos pos, BlockState state, @Nullable TileEntity te, ItemStack stack) {
        super.harvestBlock(worldIn, player, pos, Blocks.AIR.getDefaultState(), te, stack);
    }

    public IFluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }

    /**
     * Called before the Block is set to air in the world. Called regardless of if the player's tool can actually collect
     * this block
     */
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        REEDS_HALF doubleblockhalf = state.get(REED_HALF);
        BlockPos bottomPos = doubleblockhalf == REEDS_HALF.BOTTOM ? pos : doubleblockhalf == REEDS_HALF.MEDIUM ? pos.down() : pos.down(2);
        BlockPos mediumPos = bottomPos.up();
        BlockPos topPos = bottomPos.up(2);
        if(worldIn.getBlockState(bottomPos).getBlock() instanceof ReedsBlock && worldIn.getBlockState(mediumPos).getBlock() instanceof ReedsBlock && worldIn.getBlockState(topPos).getBlock() instanceof ReedsBlock) {
            worldIn.setBlockState(bottomPos, Blocks.AIR.getDefaultState(), 35);
            worldIn.setBlockState(mediumPos, Blocks.AIR.getDefaultState(), 35);
            worldIn.playEvent(player, 2001, mediumPos, Block.getStateId(worldIn.getBlockState(mediumPos)));
            worldIn.setBlockState(topPos, Blocks.AIR.getDefaultState(), 35);
            worldIn.playEvent(player, 2001, topPos, Block.getStateId(worldIn.getBlockState(mediumPos)));
            if (!worldIn.isRemote && !player.isCreative()) {
                spawnDrops(state, worldIn, pos, (TileEntity) null, player, player.getHeldItemMainhand());
                spawnDrops(worldIn.getBlockState(mediumPos), worldIn, mediumPos, (TileEntity) null, player, player.getHeldItemMainhand());
                spawnDrops(worldIn.getBlockState(topPos), worldIn, topPos, (TileEntity) null, player, player.getHeldItemMainhand());
            }
        }

        super.onBlockHarvested(worldIn, bottomPos, worldIn.getBlockState(bottomPos), player);
    }

    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (stateIn.get(WATERLOGGED)) {
            worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
        }

        return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        if(state.getBlock()==Blocks.WATER) {
            if(worldIn.getBlockState(pos.up()).getBlock()==Blocks.AIR || worldIn.getBlockState(pos.up(2)).getBlock()==Blocks.AIR || worldIn.getBlockState(pos.up(3)).getBlock()==Blocks.AIR) {
                BlockPos blockpos = pos.down();
                BlockState blockstate = worldIn.getBlockState(blockpos);
                Block block = blockstate.getBlock();
                if(block != Blocks.MAGMA_BLOCK && (block == this || blockstate.isSolidSide(worldIn, blockpos, Direction.UP))){
                    if(worldIn.getBlockState(blockpos).getBlock() instanceof ReedsBlock){
                        if(state.get(REED_HALF)==REEDS_HALF.TOP){
                            return worldIn.getBlockState(blockpos).get(REED_HALF)==REEDS_HALF.MEDIUM;
                        }else if(state.get(REED_HALF) == REEDS_HALF.MEDIUM){
                            return worldIn.getBlockState(blockpos).get(REED_HALF)==REEDS_HALF.BOTTOM;

                        }
                    }
                    if(!(worldIn.getBlockState(blockpos.up()).getBlock() instanceof ReedsBlock) && !(worldIn.getBlockState(blockpos.up(2)).getBlock() instanceof ReedsBlock) && !(worldIn.getBlockState(blockpos.up(3)).getBlock() instanceof ReedsBlock)) {
                        if (state.getBlock() == this) //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
                            return worldIn.getBlockState(blockpos).canSustainPlant(worldIn, blockpos, Direction.UP, this);
                        return this.isValidGround(worldIn.getBlockState(blockpos), worldIn, blockpos);
                    }
                }
            }
            return false;
        }else{
            if(worldIn.getBlockState(pos.up()).getBlock()==Blocks.AIR || worldIn.getBlockState(pos.up(2)).getBlock()==Blocks.AIR || worldIn.getBlockState(pos.up(3)).getBlock()==Blocks.AIR) {

                BlockPos blockpos = pos.down();
                if (worldIn.getBlockState(blockpos).getBlock() instanceof ReedsBlock) {
                    if (state.get(REED_HALF) == REEDS_HALF.TOP) {
                        return worldIn.getBlockState(blockpos).get(REED_HALF) == REEDS_HALF.MEDIUM;
                    } else if (state.get(REED_HALF) == REEDS_HALF.MEDIUM) {
                        return worldIn.getBlockState(blockpos).get(REED_HALF) == REEDS_HALF.BOTTOM;

                    }
                }
                if (state.getBlock() == this) //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
                    return worldIn.getBlockState(blockpos).canSustainPlant(worldIn, blockpos, Direction.UP, this);
                return this.isValidGround(worldIn.getBlockState(blockpos), worldIn, blockpos);
            }
            return false;
        }
    }

    @Override
    public boolean canSustainPlant(BlockState p_canSustainPlant_1_, IBlockReader p_canSustainPlant_2_, BlockPos p_canSustainPlant_3_, Direction p_canSustainPlant_4_, IPlantable p_canSustainPlant_5_) {
        BlockState plant = p_canSustainPlant_5_.getPlant(p_canSustainPlant_2_, p_canSustainPlant_3_.offset(p_canSustainPlant_4_));

        if(plant.getBlock() == this){
            return true;
        }
        return super.canSustainPlant(p_canSustainPlant_1_, p_canSustainPlant_2_, p_canSustainPlant_3_, p_canSustainPlant_4_, p_canSustainPlant_5_);
    }

    /**
     * Get the OffsetType for this Block. Determines if the model is rendered slightly offset.
     */
    public Block.OffsetType getOffsetType() {
        return Block.OffsetType.XZ;
    }

    /**
     */
    @OnlyIn(Dist.CLIENT)
    public long getPositionRandom(BlockState state, BlockPos pos) {
        return MathHelper.getCoordinateRandom(pos.getX(), pos.down(state.get(REED_HALF) == REEDS_HALF.BOTTOM ? 0 : 1).getY(), pos.getZ());
    }

    public enum REEDS_HALF implements IStringSerializable {
        TOP,
        MEDIUM,
        BOTTOM;

        private REEDS_HALF() {
        }

        public String toString() {
            return this.getName();
        }

        public String getName() {
            return this == TOP ? "top" : this == MEDIUM ? "middle" : "bottom";
        }
    }
}
