package com.matez.wildnature.blocks;

import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.render.IRenderLayer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.IProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import java.util.Random;

public class CropBase extends CropsBlock implements IRenderLayer {

    private Item item;
    public CropBase(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties);

        this.setRegistryName(regName);
        if(builder!=null) {
            item = new BlockItem(this, builder).setRegistryName(regName);
            WNBlocks.ITEMBLOCKS.add(item);
        }

        WNBlocks.BLOCKS.add(this);
        WNBlocks.CROPS.add(this);
    }

    public IntegerProperty getAge(){
        return AGE;
    }

    @Override
    public boolean ticksRandomly(BlockState p_149653_1_) {
        return true;
    }

    @Override
    public void onBlockHarvested(World world, BlockPos pos, BlockState state, PlayerEntity entity) {
        if(entity.inventory.getCurrentItem().getItem()== Items.SHEARS && !entity.abilities.isCreativeMode){
            spawnAsEntity(world,pos,new ItemStack(Item.getItemFromBlock(state.getBlock())));
            world.playSound((double)pos.getX(),(double)pos.getY(),(double)pos.getZ(),this.getSoundType(state,world,pos,entity).getBreakSound(), SoundCategory.BLOCKS,this.getSoundType(state,world,pos,entity).pitch,this.getSoundType(state,world,pos,entity).volume,false);
            super.onBlockHarvested(world,pos,state,entity);
        }else{
            super.onBlockHarvested(world,pos,state,entity);
        }
    }

    public boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        Block block = state.getBlock();
        if(!CommonConfig.vegeGrassSpawn.get()) {
            return block == Blocks.FARMLAND;
        }
        return block == Blocks.GRASS_BLOCK || block == Blocks.DIRT || block == Blocks.COARSE_DIRT || block == Blocks.PODZOL || block == Blocks.FARMLAND;

    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        return super.isValidPosition(state, worldIn, pos);
    }
}
