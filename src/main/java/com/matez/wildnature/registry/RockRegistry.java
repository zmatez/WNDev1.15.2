package com.matez.wildnature.registry;

import com.matez.wildnature.Main;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.blocks.RockBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class RockRegistry {

    public Block[] rocks;

    public RockRegistry(){
        rocks = new Block[]{
                WNBlocks.BASALT_ROCK = new RockBase(Block.Properties.create(Material.ROCK), new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("basalt"),3),
                WNBlocks.CONGLOMERATE_ROCK = new RockBase(Block.Properties.create(Material.ROCK),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("conglomerate"),2),
                WNBlocks.GNEISS_ROCK = new RockBase(Block.Properties.create(Material.ROCK),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("gneiss"),1),
                WNBlocks.LIMESTONE_ROCK = new RockBase(Block.Properties.create(Material.ROCK),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("limestone"),2),
                WNBlocks.MARBLE_ROCK = new RockBase(Block.Properties.create(Material.ROCK),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("marble"),1),
                WNBlocks.PEGMATITE_ROCK = new RockBase(Block.Properties.create(Material.ROCK),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("pegmatite"),3),
                WNBlocks.SLATE_ROCK= new RockBase(Block.Properties.create(Material.ROCK),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("slate"),1),

        };
    }

    public Block[] getRocks() {
        return rocks;
    }
}
