package com.matez.wildnature.blocks;

import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.render.IRenderLayer;
import net.minecraft.block.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;

public class VWallBlock extends SixWayBlock implements IWaterLoggable, IRenderLayer {
   public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

   private Item item;
   public VWallBlock(Block.Properties properties, Item.Properties builder, ResourceLocation regName) {
      super(0.25F,properties);
      this.setDefaultState(this.stateContainer.getBaseState().with(UP, Boolean.valueOf(true)).with(NORTH, Boolean.valueOf(false)).with(EAST, Boolean.valueOf(false)).with(SOUTH, Boolean.valueOf(false)).with(WEST, Boolean.valueOf(false)).with(WATERLOGGED, Boolean.valueOf(false)));
      this.setRegistryName(regName);
      item = new BlockItem(this,builder).setRegistryName(regName);


      WNBlocks.BLOCKS.add(this);
      WNBlocks.ITEMBLOCKS.add(item);
   }


   @Override
   public RenderType getRenderLayer() {
      return RenderType.getCutout();
   }

   public IFluidState getFluidState(BlockState state) {
      return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
   }

   public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
      return false;
   }

   public boolean func_220113_a(BlockState p_220113_1_, boolean p_220113_2_, Direction p_220113_3_) {
      Block block = p_220113_1_.getBlock();
      boolean flag = block instanceof VWallBlock;
      return !cannotAttach(block) && p_220113_2_ || flag;
   }

   public BlockState getStateForPlacement(BlockItemUseContext context) {
      IWorldReader iworldreader = context.getWorld();
      BlockPos blockpos = context.getPos();
      IFluidState ifluidstate = context.getWorld().getFluidState(context.getPos());
      BlockPos blockpos1 = blockpos.north();
      BlockPos blockpos2 = blockpos.east();
      BlockPos blockpos3 = blockpos.south();
      BlockPos blockpos4 = blockpos.west();
      BlockPos blockpos5 = blockpos.up();
      BlockPos blockpos6 = blockpos.down();
      BlockState blockstate = iworldreader.getBlockState(blockpos1);
      BlockState blockstate1 = iworldreader.getBlockState(blockpos2);
      BlockState blockstate2 = iworldreader.getBlockState(blockpos3);
      BlockState blockstate3 = iworldreader.getBlockState(blockpos4);
      BlockState blockstate4 = iworldreader.getBlockState(blockpos5);
      BlockState blockstate5 = iworldreader.getBlockState(blockpos6);
      boolean flag = this.func_220113_a(blockstate, blockstate.isSolidSide(iworldreader, blockpos1, Direction.SOUTH), Direction.SOUTH);
      boolean flag1 = this.func_220113_a(blockstate1, blockstate1.isSolidSide(iworldreader, blockpos2, Direction.WEST), Direction.WEST);
      boolean flag2 = this.func_220113_a(blockstate2, blockstate2.isSolidSide(iworldreader, blockpos3, Direction.NORTH), Direction.NORTH);
      boolean flag3 = this.func_220113_a(blockstate3, blockstate3.isSolidSide(iworldreader, blockpos4, Direction.EAST), Direction.EAST);
      boolean flag4 = this.func_220113_a(blockstate4, blockstate4.isSolidSide(iworldreader, blockpos5, Direction.UP), Direction.UP);
      boolean flag5 = this.func_220113_a(blockstate5, blockstate5.isSolidSide(iworldreader, blockpos6, Direction.DOWN), Direction.DOWN);
      return this.getDefaultState().with(UP, Boolean.valueOf(flag4)).with(DOWN, Boolean.valueOf(flag5)).with(NORTH, Boolean.valueOf(flag)).with(EAST, Boolean.valueOf(flag1)).with(SOUTH, Boolean.valueOf(flag2)).with(WEST, Boolean.valueOf(flag3)).with(WATERLOGGED, Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER));
   }

   /**
    * Update the provided state given the provided neighbor facing and neighbor state, returning a new state.
    * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
    * returns its solidified counterpart.
    * Note that this method should ideally consider only the specific face passed in.
    */
   public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
      if (stateIn.get(WATERLOGGED)) {
         worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
      }

      Direction direction = facing.getOpposite();
      boolean flag = facing == Direction.NORTH ? this.func_220113_a(facingState, facingState.isSolidSide(worldIn, facingPos, direction), direction) : stateIn.get(NORTH);
      boolean flag1 = facing == Direction.EAST ? this.func_220113_a(facingState, facingState.isSolidSide(worldIn, facingPos, direction), direction) : stateIn.get(EAST);
      boolean flag2 = facing == Direction.SOUTH ? this.func_220113_a(facingState, facingState.isSolidSide(worldIn, facingPos, direction), direction) : stateIn.get(SOUTH);
      boolean flag3 = facing == Direction.WEST ? this.func_220113_a(facingState, facingState.isSolidSide(worldIn, facingPos, direction), direction) : stateIn.get(WEST);
      boolean flag4 = facing == Direction.UP ? this.func_220113_a(facingState, facingState.isSolidSide(worldIn, facingPos, direction), direction) : stateIn.get(UP);
      boolean flag5 = facing == Direction.DOWN ? this.func_220113_a(facingState, facingState.isSolidSide(worldIn, facingPos, direction), direction) : stateIn.get(DOWN);
      return stateIn.with(UP, Boolean.valueOf(flag4)).with(DOWN, Boolean.valueOf(flag5)).with(NORTH, Boolean.valueOf(flag)).with(EAST, Boolean.valueOf(flag1)).with(SOUTH, Boolean.valueOf(flag2)).with(WEST, Boolean.valueOf(flag3));

   }

   protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
      builder.add(UP, DOWN, NORTH, EAST, WEST, SOUTH, WATERLOGGED);
   }

   @Override
   public boolean isTransparent(BlockState state) {
      return false;
   }
}