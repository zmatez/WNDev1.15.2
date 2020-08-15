package com.matez.wildnature.blocks;

import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.lists.WNItems;
import com.matez.wildnature.other.Utilities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CaveBush extends BushBase {
    private boolean reversed = false;
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);
    protected static final VoxelShape SHAPER = Block.makeCuboidShape(2.0D, 16.0D, 2.0D, 14.0D, 3.0D, 14.0D);
    public CaveBush(Properties properties, Item.Properties builder, ResourceLocation regName, boolean reversed) {
        super(properties, builder, regName);
        this.reversed=reversed;
        //if true, its hanging
    }

    @Override
    public void animateTick(BlockState state, World world, BlockPos pos, Random random) {
        if(reversed){
            if(state.getBlock()==WNBlocks.STALACTITE){
                if(Utilities.rint(0,8,random)==0){
                    world.addParticle(ParticleTypes.DRIPPING_WATER,pos.getX()+0.5+Utilities.rdoub(-0.3,0.3),pos.getY()+0.6+Utilities.rdoub(0.0,0.1),pos.getZ()+0.5+Utilities.rdoub(-0.3,0.3),0,0,0);
                }
            }
        }
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        if(reversed){
            return SHAPER;
        }
        return SHAPE;
    }
    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        if(reversed){
            BlockPos blockpos = pos.up();
            return isValidGround(worldIn.getBlockState(blockpos), worldIn, blockpos);
        }
        BlockPos blockpos = pos.down();
        return isValidGround(worldIn.getBlockState(blockpos), worldIn, blockpos);
    }
    @Override
    public boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        Block block = state.getBlock();
        //Main.LOGGER.info("VALID: " + block.getTranslationKey() + " " + ((BlockTags.getCollection().getOrCreate(new ResourceLocation("forge","stone")).contains(block) || block == Blocks.GRAVEL || block == Blocks.PACKED_ICE)&& ((IWorldReader)worldIn).getLightSubtracted(pos, 0) < 10));
        return ((BlockTags.getCollection().getOrCreate(new ResourceLocation("forge","stone")).contains(block) || block == Blocks.GRAVEL || block == Blocks.PACKED_ICE)&& ((IWorldReader)worldIn).getLightSubtracted(pos, 0) <= 10);
    }




    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> l = new ArrayList<>();
        if(state.getBlock()== WNBlocks.ROOTS || state.getBlock()== WNBlocks.LARGE_ROOT){
            l.add(new ItemStack(Items.STICK,Utilities.rint(1,3)));
            return l;
        }
        if(state.getBlock()== WNBlocks.GLOW_SHROOM || state.getBlock()== WNBlocks.LARGE_GLOWSHROOM){
            l.add(new ItemStack(WNItems.GLOWSHROOM_DUST,Utilities.rint(0,2)));
            return l;
        }
        if(state.getBlock()== WNBlocks.ICE_SHROOM){
            l.add(new ItemStack(WNItems.ICESHROOM_DUST,Utilities.rint(0,1)));
            return l;
        }
        if(state.getBlock()== WNBlocks.MAGMA_SHROOM){
            l.add(new ItemStack(Items.FIRE_CHARGE,Utilities.rint(0,3)==0 ? 1 : 0));
            return l;
        }
        if(state.getBlock()== WNBlocks.STONE_GRASS || state.getBlock()== WNBlocks.ICE_GRASS|| state.getBlock()== WNBlocks.STALACTITE|| state.getBlock()== WNBlocks.STALAGMITE|| state.getBlock()== WNBlocks.LARGE_STALAGMITE|| state.getBlock()== WNBlocks.LARGE_STALACTITE|| state.getBlock()== WNBlocks.ICYCLE|| state.getBlock()== WNBlocks.LARGE_ICYCLE){
            if(Utilities.rint(0,7)==0){
                l.add(new ItemStack(Item.getItemFromBlock(state.getBlock()),1));
            }

            return l;
        }


        return super.getDrops(state, builder);
    }
}
