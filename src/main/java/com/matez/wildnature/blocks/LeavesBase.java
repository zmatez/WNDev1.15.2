package com.matez.wildnature.blocks;

import com.matez.wildnature.Main;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.render.IRenderLayer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.SoundType;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;
import java.util.List;

public class LeavesBase extends LeavesBlock implements IRenderLayer {
    private Item item;

    private static Properties Properties(Properties properties){
        properties.sound(SoundType.PLANT);
        properties.hardnessAndResistance(0.2F);
        properties.notSolid();
        return properties;
    }


    @Override
    public RenderType getRenderLayer() {
        return RenderType.getCutoutMipped();
    }

    public Item getItem() {
        return item;
    }

    public LeavesBase(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(Properties(properties));
        this.setRegistryName(regName);
        item = new BlockItem(this,builder).setRegistryName(regName);

        WNBlocks.LEAVES.add(this);
        WNBlocks.BLOCKS.add(this);
        WNBlocks.ITEMBLOCKS.add(item);
    }


    @Override
    public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
        if(worldIn.getBlockState(pos.up()).getBlock()instanceof LeavesBase){
            return 0;
        }else{
            return 1;
        }
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> list = super.getDrops(state, builder);
        if(list.isEmpty() && Utilities.rint(0,12)==0 && !item.getRegistryName().toString().contains("wildnature:wild")){
            list.add(new ItemStack(Main.getItemByID(item.getRegistryName().toString().replace("leaves","sapling"))));
        }


        return list;
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

    public static void leafContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(DISTANCE, PERSISTENT);
    }




}
