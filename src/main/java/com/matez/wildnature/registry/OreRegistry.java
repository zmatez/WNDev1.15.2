package com.matez.wildnature.registry;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.BlockBase;
import com.matez.wildnature.blocks.SaltOreBlock;
import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.lists.WNBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;

public class OreRegistry {

    public Block[] ores;

    public OreRegistry(){
        ores = new Block[]{
                WNBlocks.TIN_ORE= new BlockBase(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3F).harvestLevel(CommonConfig.tinOreHarvestLevel.get()),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("tin_ore")),
                WNBlocks.COPPER_ORE= new BlockBase(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3F).harvestLevel(1),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("copper_ore")),
                WNBlocks.AMETHYST_ORE= new BlockBase(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3F).harvestLevel(2),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), ("wildnature:amethyst_shard"),1,3,4, Main.RegistryEvents.location("amethyst_ore")),
                WNBlocks.SAPPHIRE_ORE= new BlockBase(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3F).harvestLevel(3),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), ("wildnature:sapphire_shard"),1,3,6, Main.RegistryEvents.location("sapphire_ore")),
                WNBlocks.MALACHITE_ORE= new BlockBase(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3F).harvestLevel(3),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), ("wildnature:malachite_shard"),1,3,8, Main.RegistryEvents.location("malachite_ore")),
                WNBlocks.SILVER_ORE= new BlockBase(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3F).harvestLevel(3),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("silver_ore")),
                WNBlocks.AMBER_ORE= new BlockBase(Block.Properties.create(Material.ROCK).harvestTool(ToolType.SHOVEL).hardnessAndResistance(1.5F,0.5F).harvestLevel(2).sound(SoundType.SAND),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), ("wildnature:amber_shard"),1,3,15, Main.RegistryEvents.location("amber_ore")),
                WNBlocks.RUBY_ORE= new BlockBase(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3F).harvestLevel(4),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), ("wildnature:ruby_shard"),1,3,25, Main.RegistryEvents.location("ruby_ore")),
                WNBlocks.SALT_ORE= new SaltOreBlock(Block.Properties.create(Material.ROCK),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("salt_ore")),

                WNBlocks.TIN_BLOCK= new BlockBase(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("tin_block")),
                WNBlocks.COPPER_BLOCK= new BlockBase(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("copper_block")),
                WNBlocks.STEEL_BLOCK= new BlockBase(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("steel_block")),
                WNBlocks.BRONZE_BLOCK= new BlockBase(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("bronze_block")),
                WNBlocks.AMETHYST_BLOCK= new BlockBase(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("amethyst_block")),
                WNBlocks.SAPPHIRE_BLOCK= new BlockBase(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("sapphire_block")),
                WNBlocks.MALACHITE_BLOCK= new BlockBase(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("malachite_block")),
                WNBlocks.SILVER_BLOCK= new BlockBase(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("silver_block")),
                WNBlocks.AMBER_BLOCK= new BlockBase(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("amber_block")),
                WNBlocks.RUBY_BLOCK= new BlockBase(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("ruby_block")),


        };
    }

    public Block[] getOres() {
        return ores;
    }
}
