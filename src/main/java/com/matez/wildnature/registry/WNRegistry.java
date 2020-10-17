package com.matez.wildnature.registry;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;

public class WNRegistry {
    public static void registerBlocks(final RegistryEvent.Register<Block> event, Block... blocks){
        event.getRegistry().registerAll(blocks);
    }

    public static void registerItems(final RegistryEvent.Register<Item> event, Item... item){
        event.getRegistry().registerAll(item);
    }
}
