package com.matez.wildnature.blocks;

import com.matez.wildnature.gui.tileEntities.ParticleGeneratorTileEntity;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.command.arguments.ParticleArgument;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.*;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.Random;

public class ParticleGeneratorBlock extends BlockBase {
   public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
   private Item item;
   private ParticleGeneratorTileEntity tileEntity = new ParticleGeneratorTileEntity();
   public ParticleGeneratorBlock(Properties properties, Item.Properties builder, ResourceLocation regName) {
      super(properties,builder,regName);

      this.setDefaultState(this.stateContainer.getBaseState().with(POWERED, Boolean.valueOf(false)));
   }

   @Nullable
   public BlockState getStateForPlacement(BlockItemUseContext context) {
      return this.getDefaultState().with(POWERED, Boolean.valueOf(context.getWorld().isBlockPowered(context.getPos())));
   }

   public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
      if (!worldIn.isRemote) {
         boolean flag = state.get(POWERED);
         if (flag != worldIn.isBlockPowered(pos)) {
            if (flag) {
               worldIn.getPendingBlockTicks().scheduleTick(pos, this, 4);
            } else {
               worldIn.setBlockState(pos, state.cycle(POWERED), 2);
            }
         }

      }
   }

   public void tick(BlockState state, World worldIn, BlockPos pos, Random random) {
      if (!worldIn.isRemote) {
         if (state.get(POWERED) && !worldIn.isBlockPowered(pos)) {
            worldIn.setBlockState(pos, state.cycle(POWERED), 2);
         }

      }

      try {
         for (int i = 0; i<tileEntity.count; i++)
            worldIn.addParticle(ParticleArgument.parseParticle(new StringReader(tileEntity.particle)), tileEntity.blockPosDecoder(tileEntity.posX+"",tileEntity.getPos().getX())+0.5D, tileEntity.blockPosDecoder(tileEntity.posY+"",tileEntity.getPos().getY()), tileEntity.blockPosDecoder(tileEntity.posZ+"",tileEntity.getPos().getZ())+0.5D, tileEntity.deltaX, tileEntity.deltaY, tileEntity.deltaZ);
      } catch (CommandSyntaxException ex) {

      }
   }

   @Override
   public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
      /*if(stateIn.get(POWERED)){
         try {
            worldIn.getServer().getWorld(worldIn.getDimension().getType()).spawnParticle(ParticleArgument.parseParticle(new StringReader(tileEntity.particle)), tileEntity.blockPosDecoder(tileEntity.posX+"",tileEntity.getPos().getX()), tileEntity.blockPosDecoder(tileEntity.posY+"",tileEntity.getPos().getY()), tileEntity.blockPosDecoder(tileEntity.posZ+"",tileEntity.getPos().getZ()), tileEntity.count, tileEntity.deltaX, tileEntity.deltaY, tileEntity.deltaZ, tileEntity.speed);

         }catch(Exception e){
            System.out.println("particleRes = " + tileEntity.particle + " posX = " + tileEntity.posX + " posY = " + tileEntity.posY + " posZ = " + tileEntity.posZ + " deltaX = " + tileEntity.deltaX + " deltaY = " + tileEntity.deltaY + " deltaZ = " + tileEntity.deltaZ + " speed = " + tileEntity.speed + " count = " + tileEntity.count);


         }
      }*/
   }

   @Override
   public boolean hasTileEntity(BlockState state) {
      return true;
   }

   @Nullable
   @Override
   public TileEntity createTileEntity(BlockState state, IBlockReader world) {
      return tileEntity;
   }

   protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
      builder.add(POWERED);
   }

   @Override
   public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult result) {
      if (!world.isRemote) {
         TileEntity tileEntity = world.getTileEntity(pos);
         if (tileEntity instanceof INamedContainerProvider) {
            NetworkHooks.openGui((ServerPlayerEntity) player, (INamedContainerProvider) tileEntity, tileEntity.getPos());
         } else {
            throw new IllegalStateException("Our named container provider is missing!");
         }
         return ActionResultType.SUCCESS;
      }
      return super.onBlockActivated(state, world, pos, player, hand, result);
   }


}