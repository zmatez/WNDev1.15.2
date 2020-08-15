package com.matez.wildnature.blocks;

import com.matez.wildnature.Main;
import com.matez.wildnature.compatibility.WNLoot;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.other.Utilities;
import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootContext;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class BlockBase extends Block {
    public Item item;

    private static Properties Properties(Properties properties){
        return properties;
    }

    public BlockBase(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(Properties(properties));

        this.setRegistryName(regName);
        item = new BlockItem(this,builder).setRegistryName(regName);


        WNBlocks.BLOCKS.add(this);
        WNBlocks.ITEMBLOCKS.add(item);

    }

    public BlockBase(Properties properties, ResourceLocation regName) {
        super(Properties(properties));

        this.setRegistryName(regName);

        WNBlocks.BLOCKS.add(this);
    }

    private String drop;
    private int min = 1;
    private int max = 1;
    private int exp = 0;

    public BlockBase(Properties properties, Item.Properties builder, String drop, int min, int max, int exp, ResourceLocation regName) {
        super(Properties(properties));

        this.setRegistryName(regName);
        item = new BlockItem(this,builder).setRegistryName(regName);

        this.drop=drop;
        this.min=min;
        this.max=max;
        this.exp = exp;

        WNBlocks.BLOCKS.add(this);
        WNBlocks.ITEMBLOCKS.add(item);

    }

    public Item getItem() {
        return item;
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        if(drop!=null){
            List<ItemStack> list = new ArrayList<>();
            if(WNLoot.isSilkTouch(builder)){
                list.add(new ItemStack(Item.getItemFromBlock(this), 1));
            }else {
                list.add(new ItemStack(Main.getItemByID(drop), Utilities.rint(min,max) + Utilities.rint(0, WNLoot.getFortune(builder))));
            }
            return list;
        }else {
            boolean silkTouch = false;
            List<ItemStack> list = super.getDrops(state, builder);
            if (list.isEmpty() && !silkTouch) {
                list.add(new ItemStack(item, 1));
            }

            return list;
        }
    }
}
