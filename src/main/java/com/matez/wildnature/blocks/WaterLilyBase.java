package com.matez.wildnature.blocks;

import com.matez.wildnature.entity.type.animal.duck.AbstractDuckEntity;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.render.IRenderLayer;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.ArrayList;
import java.util.List;

public class WaterLilyBase extends LilyPadBlock implements IRenderLayer {
   protected static final VoxelShape LILY_PAD_AABB = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 1.5D, 15.0D);

   public WaterLilyBase(Properties properties, ResourceLocation regName) {
      super(properties.sound(SoundType.PLANT));
      this.setRegistryName(regName);


      WNBlocks.BLOCKS.add(this);
   }

   public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
      super.onEntityCollision(state, worldIn, pos, entityIn);
      if (entityIn instanceof BoatEntity) {
         worldIn.destroyBlock(new BlockPos(pos), true);
      } else if(!(entityIn instanceof AbstractDuckEntity)){
         //entityIn.setMotionMultiplier(state, new Vec3d(0.5,1,0.5));
      }

   }


   public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
      return LILY_PAD_AABB;
   }

   protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
      IFluidState ifluidstate = worldIn.getFluidState(pos);
      return ifluidstate.getFluid() == Fluids.WATER || state.getMaterial() == Material.ICE;
   }

   public Block.OffsetType getOffsetType() {
      return Block.OffsetType.XZ;
   }

   @OnlyIn(Dist.CLIENT)
   public long getPositionRandom(BlockState state, BlockPos pos) {
      return MathHelper.getCoordinateRandom(pos.getX(), pos.getY(), pos.getZ());
   }

   @Override
   public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
      List<ItemStack> l = new ArrayList<>();

      if(Utilities.rint(0,4)==0) {
         l.add(new ItemStack(this.asItem(), 1));
      }
      return l;
   }
}