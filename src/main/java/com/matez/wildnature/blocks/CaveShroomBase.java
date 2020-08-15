package com.matez.wildnature.blocks;

import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.lists.WNItems;
import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.registry.ParticleRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
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

public class CaveShroomBase extends MushroomBase {
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);
    protected static final VoxelShape SHAPER = Block.makeCuboidShape(2.0D, 16.0D, 2.0D, 14.0D, 3.0D, 14.0D);

    private boolean reversed = false;
    public CaveShroomBase(Properties properties, Item.Properties builder, ResourceLocation regName, boolean reversed) {
        super(properties, builder, regName);
        this.reversed=reversed;
    }

    @Override
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        int max = 7;
        if(Utilities.rint(0,4)==0) {
            if (reversed) {
                if (this == WNBlocks.HANGING_GLOWING_SLIMESHROOM_BLUE) {
                    for(int i = 0; i < max; i++) {
                        worldIn.addParticle(ParticleRegistry.SLIMESHROOM_BLUE, pos.getX() + 0.5 + Utilities.rdoub(-0.1,0.1), pos.getY() + 0.85 + Utilities.rdoub(-0.1,0.1), pos.getZ() + 0.5 + Utilities.rdoub(-0.1,0.1), 0.01, 0.1, 0.01);
                    }
                } else if (this == WNBlocks.HANGING_GLOWING_SLIMESHROOM_GREEN) {
                    for (int i = 0; i < max; i++) {
                        worldIn.addParticle(ParticleRegistry.SLIMESHROOM_GREEN, pos.getX() + 0.5, pos.getY() + 0.85 + Utilities.rdoub(-0.1, 0.1), pos.getZ() + 0.5 + Utilities.rdoub(-0.1, 0.1), 0.01, 0.1, 0.01);
                    }
                }
            } else {
                if (this == WNBlocks.GLOWING_SLIMESHROOM_BLUE) {
                    for (int i = 0; i < max; i++) {
                        worldIn.addParticle(ParticleRegistry.SLIMESHROOM_BLUE, pos.getX() + 0.5 + Utilities.rdoub(-0.1, 0.1), pos.getY() + 0.6 + Utilities.rdoub(-0.1, 0.1), pos.getZ() + 0.5 + Utilities.rdoub(-0.1, 0.1), 0.01, 0.1, 0.01);
                    }
                }else if (this == WNBlocks.GLOWING_SLIMESHROOM_GREEN) {
                    for (int i = 0; i < max; i++) {
                        worldIn.addParticle(ParticleRegistry.SLIMESHROOM_GREEN, pos.getX() + 0.5 + Utilities.rdoub(-0.1, 0.1), pos.getY() + 0.6 + Utilities.rdoub(-0.1, 0.1), pos.getZ() + 0.5 + Utilities.rdoub(-0.1, 0.1), 0.01, 0.1, 0.01);
                    }
                }
            }
        }
    }

    @Override
    public boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        Block block = state.getBlock();
        //Main.LOGGER.info("VALID: " + block.getTranslationKey() + " " + ((BlockTags.getCollection().getOrCreate(new ResourceLocation("forge","stone")).contains(block) || block == Blocks.GRAVEL || block == Blocks.PACKED_ICE)&& ((IWorldReader)worldIn).getLightSubtracted(pos, 0) < 10));
        return ((BlockTags.getCollection().getOrCreate(new ResourceLocation("forge","stone")).contains(block) || block == Blocks.GRAVEL || block == Blocks.PACKED_ICE)&& ((IWorldReader)worldIn).getLightSubtracted(pos, 0) <= 10);
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
            return isValidGround(worldIn.getBlockState(blockpos), worldIn, blockpos) && worldIn.getLightSubtracted(pos, 0) < 10;
        }
        BlockPos blockpos = pos.down();
        return isValidGround(worldIn.getBlockState(blockpos), worldIn, blockpos) && worldIn.getLightSubtracted(pos, 0) < 10;
    }



    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> l = new ArrayList<>();

        if(state.getBlock()== WNBlocks.GLOWING_SLIMESHROOM_GREEN || state.getBlock()== WNBlocks.HANGING_GLOWING_SLIMESHROOM_GREEN || state.getBlock()==WNBlocks.GLOW_SHROOM
                || state.getBlock()==WNBlocks.GLOWING_SHADOWSHROOM  || state.getBlock()==WNBlocks.DRAGON_SHROOM  || state.getBlock()==WNBlocks.GRAVITYSHROOM
                || state.getBlock()==WNBlocks.JELLYSHROOM  || state.getBlock()==WNBlocks.TUBESHROOM || state.getBlock()==WNBlocks.SUNSHROOM){
            l.add(new ItemStack(WNItems.GLOWSHROOM_DUST,Utilities.rint(0,1)));
            return l;
        }

        if(state.getBlock()==WNBlocks.MAGMA_SHROOM){
            l.add(new ItemStack(Items.FIRE_CHARGE,Utilities.rint(0,1)));
            return l;
        }

        if(state.getBlock()== WNBlocks.GLOWING_SLIMESHROOM_BLUE || state.getBlock()== WNBlocks.HANGING_GLOWING_SLIMESHROOM_BLUE || state.getBlock()==WNBlocks.ICE_SHROOM){
            l.add(new ItemStack(WNItems.ICESHROOM_DUST,Utilities.rint(0,1)));
            return l;
        }

        if(Utilities.rint(0,4)==0) {
            l.add(new ItemStack(this.getItem(), 1));
        }


        return super.getDrops(state, builder);
    }
}
