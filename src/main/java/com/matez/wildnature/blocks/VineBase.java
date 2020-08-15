package com.matez.wildnature.blocks;

import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.lists.WNItems;
import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.render.IRenderLayer;
import net.minecraft.block.BlockState;
import net.minecraft.block.VineBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootContext;

import java.util.ArrayList;
import java.util.List;

public class VineBase extends VineBlock implements IRenderLayer {

    public Item item;
    public VineBase(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties);

        this.setRegistryName(regName);
        item = new BlockItem(this,builder).setRegistryName(regName);


        WNBlocks.BLOCKS.add(this);
        WNBlocks.ITEMBLOCKS.add(item);
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> l = new ArrayList<>();

        if (state.getBlock() == WNBlocks.GLOW_VINE) {
            l.add(new ItemStack(WNItems.GLOWSHROOM_DUST, Utilities.rint(0, 1)));
            l.add(new ItemStack(Items.STICK, Utilities.rint(0, 1)));
            return l;
        }
        return super.getDrops(state,builder);
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
}
