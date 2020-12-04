package com.matez.wildnature.common.registry.blocks;

import com.matez.wildnature.common.blocks.FormationVerticalBase;
import com.matez.wildnature.common.blocks.FormationWallBase;
import com.matez.wildnature.init.WN;
import com.matez.wildnature.common.blocks.BlockBase;
import com.matez.wildnature.common.blocks.SaltOreBlock;
import com.matez.wildnature.util.config.CommonConfig;
import com.matez.wildnature.client.tabs.WNTabs;
import com.matez.wildnature.util.lists.WNBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;

public class OreRegistry {

    public Block[] ores;

    public OreRegistry(){
        ores = new Block[]{
                WNBlocks.AMBER_ORE= new BlockBase(Block.Properties.create(Material.ROCK).harvestTool(ToolType.SHOVEL).hardnessAndResistance(1.5F,0.5F).harvestLevel(CommonConfig.amberOreHarvestLevel.get()).sound(SoundType.SAND),new Item.Properties().group(WNTabs.CAVES), ("wildnature:amber_shard"),1,3,15, WN.RegistryEvents.location("amber_ore")),
                WNBlocks.SALT_ORE= new SaltOreBlock(Block.Properties.create(Material.ROCK),new Item.Properties().group(WNTabs.CAVES), WN.RegistryEvents.location("salt_ore")),

                WNBlocks.TIN_ORE= new BlockBase(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3F).harvestLevel(CommonConfig.tinOreHarvestLevel.get()),new Item.Properties().group(WNTabs.CAVES), "wildnature:tin_raw",1,1,3, WN.RegistryEvents.location("tin_ore")),
                WNBlocks.COPPER_ORE= new BlockBase(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3F).harvestLevel(CommonConfig.copperOreHarvestLevel.get()),new Item.Properties().group(WNTabs.CAVES), WN.RegistryEvents.location("copper_ore")),
                WNBlocks.SILVER_ORE= new BlockBase(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3F).harvestLevel(CommonConfig.silverOreHarvestLevel.get()),new Item.Properties().group(WNTabs.CAVES), WN.RegistryEvents.location("silver_ore")),

                WNBlocks.SAPPHIRE_FORMATION = new FormationWallBase(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3F).harvestLevel(CommonConfig.sapphireOreHarvestLevel.get()),new Item.Properties().group(WNTabs.CAVES), ("wildnature:sapphire_raw"), ("wildnature:sapphire_raw"),1,1,1,3,6,10, WN.RegistryEvents.location("sapphire_formation"),16),
                WNBlocks.RUBY_FORMATION = new FormationWallBase(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3F).harvestLevel(CommonConfig.rubyOreHarvestLevel.get()),new Item.Properties().group(WNTabs.CAVES), ("wildnature:ruby_raw"),("wildnature:ruby_raw"),1,1,1,3,6,10, WN.RegistryEvents.location("ruby_formation"),15),
                WNBlocks.MALACHITE_FORMATION = new FormationVerticalBase(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3F).harvestLevel(CommonConfig.malachiteOreHarvestLevel.get()),new Item.Properties().group(WNTabs.CAVES), ("wildnature:malachite_raw"),("wildnature:malachite_raw"),1,2,1,2,15,15, WN.RegistryEvents.location("malachite_formation"),18),
                WNBlocks.AMETHYST_FORMATION = new FormationVerticalBase(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3F).harvestLevel(CommonConfig.amethystOreHarvestLevel.get()),new Item.Properties().group(WNTabs.CAVES), ("wildnature:amethyst_raw"),("wildnature:amethyst_shard"),1,2,4,10, 13,22, WN.RegistryEvents.location("amethyst_formation"),22),

                WNBlocks.TIN_BLOCK= new BlockBase(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL),new Item.Properties().group(WNTabs.CAVES), WN.RegistryEvents.location("tin_block")),
                WNBlocks.COPPER_BLOCK= new BlockBase(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL),new Item.Properties().group(WNTabs.CAVES), WN.RegistryEvents.location("copper_block")),
                WNBlocks.STEEL_BLOCK= new BlockBase(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL),new Item.Properties().group(WNTabs.CAVES), WN.RegistryEvents.location("steel_block")),
                WNBlocks.BRONZE_BLOCK= new BlockBase(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL),new Item.Properties().group(WNTabs.CAVES), WN.RegistryEvents.location("bronze_block")),
                WNBlocks.AMETHYST_BLOCK= new BlockBase(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL),new Item.Properties().group(WNTabs.CAVES), WN.RegistryEvents.location("amethyst_block")),
                WNBlocks.SAPPHIRE_BLOCK= new BlockBase(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL),new Item.Properties().group(WNTabs.CAVES), WN.RegistryEvents.location("sapphire_block")),
                WNBlocks.MALACHITE_BLOCK= new BlockBase(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL),new Item.Properties().group(WNTabs.CAVES), WN.RegistryEvents.location("malachite_block")),
                WNBlocks.SILVER_BLOCK= new BlockBase(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL),new Item.Properties().group(WNTabs.CAVES), WN.RegistryEvents.location("silver_block")),
                WNBlocks.AMBER_BLOCK= new BlockBase(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL),new Item.Properties().group(WNTabs.CAVES), WN.RegistryEvents.location("amber_block")),
                WNBlocks.RUBY_BLOCK= new BlockBase(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL),new Item.Properties().group(WNTabs.CAVES), WN.RegistryEvents.location("ruby_block")),
        };
    }

    public Block[] getOres() {
        return ores;
    }
}
