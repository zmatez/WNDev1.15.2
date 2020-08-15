package com.matez.wildnature.blocks;

import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.render.IRenderLayer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneDiodeBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.*;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class RSPulsarBlock extends RedstoneDiodeBlock implements IRenderLayer {

   private Item item;
   public static final IntegerProperty SPEED = IntegerProperty.create("speed", 1, 10);
   public static final BooleanProperty POWER = BooleanProperty.create("power");
   public RSPulsarBlock(Properties properties, Item.Properties builder, ResourceLocation regName) {
      super(properties);

      this.setRegistryName(regName);



      this.setDefaultState(this.stateContainer.getBaseState().with(HORIZONTAL_FACING, Direction.NORTH).with(POWERED, Boolean.valueOf(false)).with(SPEED,1).with(POWER,false));
      item = new BlockItem(this,builder).setRegistryName(regName);

      WNBlocks.BLOCKS.add(this);
      WNBlocks.ITEMBLOCKS.add(item);
   }

   public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
      int speed = state.get(SPEED)+1;
      if(speed>=11){
         speed=1;
      }
      worldIn.setBlockState(pos,state.with(SPEED,speed));
      return ActionResultType.SUCCESS;
   }

   @Override
   protected int getActiveSignal(IBlockReader worldIn, BlockPos pos, BlockState state) {
      return state.get(POWER) ? 0:15;
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
   protected int getDelay(BlockState state) {
      return state.get(SPEED)*state.get(SPEED);
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




   @Override
   public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
      changePower(worldIn,pos,state);
      super.tick(state, worldIn, pos, random);
      if(shouldBePowered(worldIn,pos,state)){
         worldIn.getPendingBlockTicks().scheduleTick(pos, this, this.getDelay(state), TickPriority.NORMAL);
      }else{
         worldIn.setBlockState(pos,worldIn.getBlockState(pos).with(POWER,false));
      }
   }

   protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
      builder.add(HORIZONTAL_FACING, POWERED, SPEED, POWER);
   }



   public void changePower(World world, BlockPos pos, BlockState state){
      if(shouldBePowered(world,pos,state)){
         if(!world.getBlockState(pos).get(POWER)){
            world.setBlockState(pos,world.getBlockState(pos).with(POWER,true));
         }else{
            world.setBlockState(pos,world.getBlockState(pos).with(POWER,false));
         }
      }

      world.notifyNeighbors(pos,state.getBlock());
   }


}