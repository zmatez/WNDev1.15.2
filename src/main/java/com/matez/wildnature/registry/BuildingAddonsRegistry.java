package com.matez.wildnature.registry;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.*;
import com.matez.wildnature.blocks.boundingboxes.*;
import com.matez.wildnature.lists.WNBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;

public class BuildingAddonsRegistry {

    Block[] block;

    public BuildingAddonsRegistry() {
        block = new Block[]{

                //WNBlocks.BASALT_VERTICAL_SLAB_BRICKS_CHISELED = new BlockSlabVertical(Block.Properties.create(Material.GLASS).hardnessAndResistance(1.5F, 6.0F), new Item.Properties().group(Main.WILDNATURE_BUILDING_GROUP), Main.RegistryEvents.location("basalt_vertical_slab_bricks_chiseled")),
        };
    }

    public Block[] getBlock() {
        return block;
    }
}
