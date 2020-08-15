package com.matez.wildnature.blocks;

import java.util.List;
import java.util.Random;

import com.matez.wildnature.Main;
import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.render.IRenderLayer;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.GameRules;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootContext;

public class FarmlandBase extends FarmlandBlock implements IRenderLayer {
   public Item item;

   protected static final VoxelShape SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D);

   private String dirt = Blocks.DIRT.getRegistryName().toString();

   public FarmlandBase(Properties properties, Item.Properties builder, ResourceLocation regName, String dirtBlock) {
      super(properties);
      this.setDefaultState(this.stateContainer.getBaseState().with(MOISTURE, Integer.valueOf(0)));
      this.setRegistryName(regName);
      item = new BlockItem(this,builder).setRegistryName(regName);

      dirt=dirtBlock;

      WNBlocks.BLOCKS.add(this);
      WNBlocks.ITEMBLOCKS.add(item);
      
   }

   @Override
   public boolean ticksRandomly(BlockState state) {
      return true;
   }

   @Override
   public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing, net.minecraftforge.common.IPlantable plantable) {
      BlockState plant = plantable.getPlant(world, pos.offset(facing));
      net.minecraftforge.common.PlantType type = plantable.getPlantType(world, pos.offset(facing));
      try {
         if (plant.getBlock() instanceof BushBlock && Utilities.isValidGroundFor(plant,Blocks.FARMLAND.getDefaultState().with(FarmlandBlock.MOISTURE,state.get(MOISTURE)), world, pos)) {
            return true;
         }
      }catch (Exception e){
      }




      return false;
   }

   /**
    * Update the provided state given the provided neighbor facing and neighbor state, returning a new state.
    * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
    * returns its solidified counterpart.
    * Note that this method should ideally consider only the specific face passed in.
    */
   public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
      if (facing == Direction.UP && !stateIn.isValidPosition(worldIn, currentPos)) {
         worldIn.getPendingBlockTicks().scheduleTick(currentPos, this, 1);
      }

      return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
   }

   public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
      BlockState blockstate = worldIn.getBlockState(pos.up());
      return !blockstate.getMaterial().isSolid() || blockstate.getBlock() instanceof FenceGateBlock;
   }

   public BlockState getStateForPlacement(BlockItemUseContext context) {
      return !this.getDefaultState().isValidPosition(context.getWorld(), context.getPos()) ? Main.getBlockByID(dirt).getDefaultState() : super.getStateForPlacement(context);
   }

   public boolean func_220074_n(BlockState state) {
      return true;
   }

   public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
      return SHAPE;
   }

   public void tick(BlockState state, World worldIn, BlockPos pos, Random random) {
      if (!state.isValidPosition(worldIn, pos)) {
         turnToDirt(state, worldIn, pos);
      } else {
         int i = state.get(MOISTURE);
         if (!hasWater(worldIn, pos) && !worldIn.isRainingAt(pos.up())) {
            if (i > 0) {
               worldIn.setBlockState(pos, state.with(MOISTURE, Integer.valueOf(i - 1)), 2);
            } else if (!hasCrops(worldIn, pos)) {
               turnToDirt(state, worldIn, pos);
            }
         } else if (i < 7) {
            worldIn.setBlockState(pos, state.with(MOISTURE, Integer.valueOf(7)), 2);
         }

      }
   }

   /**
    * Block's chance to react to a living entity falling on it.
    */
   public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
      if (!worldIn.isRemote && net.minecraftforge.common.ForgeHooks.onFarmlandTrample(worldIn, pos, Main.getBlockByID(dirt).getDefaultState(), fallDistance, entityIn)) { // Forge: Move logic to Entity#canTrample
         turnToDirt(worldIn.getBlockState(pos), worldIn, pos);
      }

      super.onFallenUpon(worldIn, pos, entityIn, fallDistance);
   }

   public String getDirt() {
      return dirt;
   }

   public static void turnToDirt(BlockState state, World worldIn, BlockPos pos) {
      if(state.getBlock() instanceof FarmlandBase) {
         worldIn.setBlockState(pos, nudgeEntitiesWithNewState(state, Main.getBlockByID(((FarmlandBase) state.getBlock()).getDirt()).getDefaultState(), worldIn, pos));
      }
   }

   private boolean hasCrops(IBlockReader worldIn, BlockPos pos) {
      BlockState state = worldIn.getBlockState(pos.up());
      return state.getBlock() instanceof net.minecraftforge.common.IPlantable && canSustainPlant(state, worldIn, pos, Direction.UP, (net.minecraftforge.common.IPlantable)state.getBlock());
   }

   private static boolean hasWater(IWorldReader worldIn, BlockPos pos) {
      for(BlockPos blockpos : BlockPos.getAllInBoxMutable(pos.add(-4, 0, -4), pos.add(4, 1, 4))) {
         if (worldIn.getFluidState(blockpos).isTagged(FluidTags.WATER)) {
            return true;
         }
      }

      return net.minecraftforge.common.FarmlandWaterManager.hasBlockWaterTicket(worldIn, pos);
   }

   protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
      builder.add(MOISTURE);
   }

   public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
      return false;
   }

   @Override
   public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
      boolean silkTouch = false;
      List<ItemStack> list = super.getDrops(state, builder);
      if(list.isEmpty() && !silkTouch){
         list.add(new ItemStack(Main.getBlockByID(dirt), 1));
      }

      return list;
   }

}