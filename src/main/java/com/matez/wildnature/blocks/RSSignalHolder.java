package com.matez.wildnature.blocks;

import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.render.IRenderLayer;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class RSSignalHolder extends RedstoneDiodeBlock implements IRenderLayer {

   private Item item;
   public static final BooleanProperty HOLD = BooleanProperty.create("hold");
   public static final BooleanProperty TO_CHANGE = BooleanProperty.create("to_change");
   public RSSignalHolder(Properties properties, Item.Properties builder, ResourceLocation regName) {
      super(properties);

      this.setRegistryName(regName);



      this.setDefaultState(this.stateContainer.getBaseState().with(HORIZONTAL_FACING, Direction.NORTH).with(POWERED, Boolean.valueOf(false)).with(HOLD,false).with(TO_CHANGE,false));
      item = new BlockItem(this,builder).setRegistryName(regName);

      WNBlocks.BLOCKS.add(this);
      WNBlocks.ITEMBLOCKS.add(item);
   }

   public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
      return ActionResultType.PASS;
   }


   public int getWeakPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
      if (!blockState.get(HOLD)) {
         return 0;
      } else {
         return blockState.get(HORIZONTAL_FACING) == side ? this.getActiveSignal(blockAccess, pos, blockState) : 0;
      }
   }

   @Override
   public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
      super.neighborChanged(state, worldIn, pos, blockIn, fromPos, isMoving);

   }


   public BlockState getStateForPlacement(BlockItemUseContext context) {
      BlockState blockstate = super.getStateForPlacement(context);
      return blockstate;
   }

   /**
    * Update the provided state given the provided neighbor facing and neighbor state, returning a new state.
    * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
    * returns its solidified counterpart.
    * Note that this method should ideally consider only the specific face passed in.
    */
   public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
      return !worldIn.isRemote() && facing.getAxis() != stateIn.get(HORIZONTAL_FACING).getAxis() ? stateIn : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
   }

   public boolean isLocked(IWorldReader worldIn, BlockPos pos, BlockState state) {
      return false;
   }

   protected boolean isAlternateInput(BlockState state) {
      return isDiode(state);
   }

   @Override
   protected int getDelay(BlockState p_196346_1_) {
      return 0;
   }

   @OnlyIn(Dist.CLIENT)
   public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
      if (stateIn.get(POWERED)) {
         Direction direction = stateIn.get(HORIZONTAL_FACING);
         double d0 = (double)((float)pos.getX() + 0.5F) + (double)(rand.nextFloat() - 0.5F) * 0.2D;
         double d1 = (double)((float)pos.getY() + 0.4F) + (double)(rand.nextFloat() - 0.5F) * 0.2D;
         double d2 = (double)((float)pos.getZ() + 0.5F) + (double)(rand.nextFloat() - 0.5F) * 0.2D;
         float f = -5.0F;


         f = f / 16.0F;
         double d3 = (double)(f * (float)direction.getXOffset());
         double d4 = (double)(f * (float)direction.getZOffset());
         worldIn.addParticle(RedstoneParticleData.REDSTONE_DUST, d0 + d3, d1, d2 + d4, 0.0D, 0.0D, 0.0D);
      }
   }

   private int nextTick = 0;


   @Override
   public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
      super.tick(state, worldIn, pos, random);
      if(shouldBePowered(worldIn,pos,state)) {
         worldIn.setBlockState(pos,worldIn.getBlockState(pos).with(TO_CHANGE,true));
      }else if(worldIn.getBlockState(pos).get(TO_CHANGE)){
         changePower(state, worldIn, pos);
         worldIn.setBlockState(pos,worldIn.getBlockState(pos).with(TO_CHANGE,false));
      }
   }

   protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
      builder.add(HORIZONTAL_FACING, POWERED,HOLD,TO_CHANGE);
   }



   public void changePower(BlockState state,World world,BlockPos pos){
      if(!state.get(HOLD)){
         world.setBlockState(pos,state.with(HOLD,true));
      }else{
         world.setBlockState(pos,state.with(HOLD,false));
      }

      world.notifyNeighbors(pos,state.getBlock());
   }

   public boolean isPowered(World world, BlockPos pos, BlockState state){
      Direction direction = state.get(HORIZONTAL_FACING);
      BlockPos blockpos = pos.offset(direction);
      int i = world.getRedstonePower(blockpos, direction);
      if(i>0){
         return true;
      }
      return false;
   }

}