package com.matez.wildnature.blocks;

import com.matez.wildnature.items.PsylocybinShroomItem;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.render.IRenderLayer;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.storage.loot.LootContext;

import java.util.List;

public class MushroomBase extends MushroomBlock implements IRenderLayer {
    public Item item;

    public MushroomBase(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties.doesNotBlockMovement().sound(SoundType.PLANT).hardnessAndResistance(0.1F,0F).tickRandomly());

        this.setRegistryName(regName);
        if(this==WNBlocks.PSILOCYBIN_MUSHROOM){
            item = new PsylocybinShroomItem(this, builder.food(new Food.Builder().hunger(2).saturation(6).setAlwaysEdible().build())).setRegistryName(regName);
        }else {
            item = new BlockItem(this, builder).setRegistryName(regName);
        }

        WNBlocks.MUSHROOMS.add(this);
        WNBlocks.BLOCKS.add(this);
        WNBlocks.ITEMBLOCKS.add(item);
    }

    public Item getItem() {
        return item;
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        boolean silkTouch = false;
        List<ItemStack> list = super.getDrops(state, builder);
        if(list.isEmpty() && !silkTouch){
            list.add(new ItemStack(item, 1));
        }

        return list;
    }

    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.down();
        BlockState blockstate = worldIn.getBlockState(blockpos);
        Block block = blockstate.getBlock();
        if (block != Blocks.MYCELIUM && block != Blocks.PODZOL && block != WNBlocks.BROWN_PODZOL&& block != WNBlocks.BROWN_MYCELIUM) {
            return worldIn.getLightSubtracted(pos, 0) < 13 && blockstate.canSustainPlant(worldIn, blockpos, net.minecraft.util.Direction.UP, this);
        } else {
            return true;
        }
    }

    public boolean needsPostProcessing(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return true;
    }


}
