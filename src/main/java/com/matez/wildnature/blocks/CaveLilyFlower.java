package com.matez.wildnature.blocks;

import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.lists.WNItems;
import com.matez.wildnature.other.Utilities;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootContext;

import java.util.ArrayList;
import java.util.List;

public class CaveLilyFlower extends CaveFloweringBushBase {
    public CaveLilyFlower(Properties properties, Item.Properties builder, ResourceLocation regName, boolean reversed) {
        super(properties, builder, regName, reversed);
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> l = new ArrayList<>();
        l.add(new ItemStack(WNItems.ICESHROOM_DUST, Utilities.rint(0, 3)));
        return l;
    }
}
