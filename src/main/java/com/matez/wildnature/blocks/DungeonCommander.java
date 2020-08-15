package com.matez.wildnature.blocks;

import java.util.Random;

import com.matez.wildnature.gui.tileEntities.DungeonCommanderTileEntity;
import com.matez.wildnature.Main;
import com.matez.wildnature.commands.DungeonCommanderLogic;
import com.matez.wildnature.lists.WNBlocks;
import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.CommandBlockLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DungeonCommander extends ContainerBlock {
   private Item item;
   private static final Logger LOGGER = LogManager.getLogger();

   public DungeonCommander(Properties properties, Item.Properties builder, ResourceLocation regName) {
      super(properties);

      item = new BlockItem(this,builder).setRegistryName(regName);
      this.setRegistryName(regName);

      WNBlocks.BLOCKS.add(this);
      WNBlocks.ITEMBLOCKS.add(item);
   }

   public TileEntity createNewTileEntity(IBlockReader worldIn) {
      DungeonCommanderTileEntity DungeonCommanderTileEntity = new DungeonCommanderTileEntity();
      return DungeonCommanderTileEntity;
   }

   public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
      if(worldIn.isBlockPowered(pos)){
         update(worldIn,state,pos);
      }
   }

   @Override
   public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
      if(worldIn.isBlockPowered(pos)){
         update(worldIn,state,pos);
      }
   }

   private void update(World worldIn, BlockState state, BlockPos pos){
      if (!worldIn.isRemote) {
         TileEntity tileentity = worldIn.getTileEntity(pos);
         if (tileentity instanceof DungeonCommanderTileEntity) {
            DungeonCommanderTileEntity DungeonCommanderTileEntity = (DungeonCommanderTileEntity)tileentity;
            DungeonCommanderLogic commandblocklogic = DungeonCommanderTileEntity.getDungeonCommanderLogic();
            this.execute(state, worldIn, pos, commandblocklogic, !StringUtils.isNullOrEmpty(commandblocklogic.getCommand()));



            worldIn.updateComparatorOutputLevel(pos, this);
         }

      }
   }



   private void execute(BlockState p_193387_1_, World p_193387_2_, BlockPos p_193387_3_, CommandBlockLogic p_193387_4_, boolean p_193387_5_) {
      if (p_193387_5_) {
         p_193387_4_.trigger(p_193387_2_);
      } else {
         p_193387_4_.setSuccessCount(0);
      }
   }

   /**
    * How many world ticks before ticking
    */
   public int tickRate(IWorldReader worldIn) {
      return 1;
   }

   public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
      TileEntity tileentity = worldIn.getTileEntity(pos);
      if (player.canUseCommandBlock() && !worldIn.isRemote) {
         //((DungeonCommanderTileEntity)tileentity).read(tileentity.getTileData());
         try {
            Main.proxy.getClient().openDungeonCommander((DungeonCommanderTileEntity) tileentity);
         }catch(Exception e){
            if(player instanceof ServerPlayerEntity && player.canUseCommandBlock() ) {
               ((DungeonCommanderTileEntity) tileentity).setSendToClient(true);
               SUpdateTileEntityPacket supdatetileentitypacket = tileentity.getUpdatePacket();
               if (supdatetileentitypacket != null) {
                  ((ServerPlayerEntity) player).connection.sendPacket(supdatetileentitypacket);
               }
               return ActionResultType.SUCCESS;
            }
         }
         return ActionResultType.SUCCESS;
      } else {
         if(worldIn.isRemote && player instanceof ServerPlayerEntity && player.canUseCommandBlock() ) {
            ((DungeonCommanderTileEntity) tileentity).setSendToClient(true);
            SUpdateTileEntityPacket supdatetileentitypacket = tileentity.getUpdatePacket();
            if (supdatetileentitypacket != null) {
               ((ServerPlayerEntity) player).connection.sendPacket(supdatetileentitypacket);
            }
            return ActionResultType.SUCCESS;
         }
         return ActionResultType.PASS;
      }
   }




   /**
    * @deprecated call via {@link #()} whenever possible. Implementing/overriding
    * is fine.
    */
   public boolean hasComparatorInputOverride(BlockState state) {
      return true;
   }

   /**
    * @deprecated call via {@link #(World,BlockPos)} whenever possible.
    * Implementing/overriding is fine.
    */
   public int getComparatorInputOverride(BlockState blockState, World worldIn, BlockPos pos) {
      TileEntity tileentity = worldIn.getTileEntity(pos);
      return tileentity instanceof DungeonCommanderTileEntity ? ((DungeonCommanderTileEntity)tileentity).getDungeonCommanderLogic().getSuccessCount() : 0;
   }

   /**
    * Called by ItemBlocks after a block is set in the world, to allow post-place logic
    */
   public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
      TileEntity tileentity = worldIn.getTileEntity(pos);
      if (tileentity instanceof DungeonCommanderTileEntity) {
         DungeonCommanderTileEntity DungeonCommanderTileEntity = (DungeonCommanderTileEntity)tileentity;
         DungeonCommanderLogic commandblocklogic = DungeonCommanderTileEntity.getDungeonCommanderLogic();
         if (stack.hasDisplayName()) {
            commandblocklogic.setName(stack.getDisplayName());
         }

         if (!worldIn.isRemote) {
            if (stack.getChildTag("BlockEntityTag") == null) {
               commandblocklogic.setTrackOutput(false);
            }
         }

      }
   }

   /**
    * The type of render function called. MODEL for mixed tesr and static model, MODELBLOCK_ANIMATED for TESR-only,
    * LIQUID for vanilla liquids, INVISIBLE to skip all rendering
    * @deprecated call via {@link #()} whenever possible. Implementing/overriding is fine.
    */
   public BlockRenderType getRenderType(BlockState state) {
      return BlockRenderType.MODEL;
   }




}