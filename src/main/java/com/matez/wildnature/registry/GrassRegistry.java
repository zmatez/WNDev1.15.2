package com.matez.wildnature.registry;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.*;
import com.matez.wildnature.lists.WNBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;


public class GrassRegistry {
    Block[] grass;
    public GrassRegistry(){
        grass = new Block[]{
                WNBlocks.BROWN_GRASS_BLOCK = new GrassBase(Block.Properties.create(Material.ORGANIC, MaterialColor.GREEN).sound(SoundType.PLANT).hardnessAndResistance(0.6F).harvestTool(ToolType.SHOVEL), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("brown_grass_block"),"wildnature:brown_dirt"),
                WNBlocks.MOLD_GRASS_BLOCK = new GrassBase(Block.Properties.create(Material.ORGANIC, MaterialColor.GREEN).sound(SoundType.PLANT).hardnessAndResistance(0.6F).harvestTool(ToolType.SHOVEL), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("mold_grass_block"),"wildnature:mold_dirt"),
                WNBlocks.TROPICAL_GRASS_BLOCK = new GrassBase(Block.Properties.create(Material.ORGANIC, MaterialColor.GREEN).sound(SoundType.PLANT).hardnessAndResistance(0.6F).harvestTool(ToolType.SHOVEL), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("tropical_grass_block"),"wildnature:tropical_dirt"),
                WNBlocks.DESERT_GRASS_BLOCK = new GrassBase(Block.Properties.create(Material.ORGANIC, MaterialColor.GREEN).sound(SoundType.PLANT).hardnessAndResistance(0.6F).harvestTool(ToolType.SHOVEL), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("desert_grass_block"),"wildnature:desert_dirt"),
                WNBlocks.DRIED_GRASS_BLOCK = new GrassBase(Block.Properties.create(Material.ORGANIC, MaterialColor.GREEN).sound(SoundType.PLANT).hardnessAndResistance(0.6F).harvestTool(ToolType.SHOVEL), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("dried_grass_block"),"wildnature:dried_dirt"),
                WNBlocks.OVERGROWN_STONE = new GrassBase(Block.Properties.create(Material.ORGANIC, MaterialColor.GREEN).sound(SoundType.STONE).harvestLevel(1).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("overgrown_stone"),"minecraft:cobblestone"),
                WNBlocks.ALGAE_BLOCK = new AlgaeBlock(Block.Properties.create(Material.ORGANIC, MaterialColor.GREEN).sound(SoundType.WET_GRASS).hardnessAndResistance(0.6F).harvestTool(ToolType.SHOVEL), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("algae_block"),"minecraft:dirt"),

                WNBlocks.BROWN_PODZOL = new PodzolBase(Block.Properties.create(Material.ORGANIC, MaterialColor.BROWN).sound(SoundType.PLANT).hardnessAndResistance(0.5F).harvestTool(ToolType.SHOVEL), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("brown_podzol"),"wildnature:brown_dirt"),
                WNBlocks.BROWN_MYCELIUM = new MyceliumBase(Block.Properties.create(Material.ORGANIC, MaterialColor.LIGHT_GRAY).sound(SoundType.PLANT).hardnessAndResistance(0.6F).harvestTool(ToolType.SHOVEL), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("brown_mycelium"),"wildnature:brown_dirt"),

                WNBlocks.BROWN_GRASS_PATH = new GrassPathBase(Block.Properties.create(Material.EARTH, MaterialColor.YELLOW).sound(SoundType.PLANT).hardnessAndResistance(0.6F).harvestTool(ToolType.SHOVEL), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("brown_grass_path"),"wildnature:brown_dirt"),
                WNBlocks.MOLD_GRASS_PATH = new GrassPathBase(Block.Properties.create(Material.EARTH, MaterialColor.YELLOW).sound(SoundType.PLANT).hardnessAndResistance(0.6F).harvestTool(ToolType.SHOVEL), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("mold_grass_path"),"wildnature:mold_dirt"),
                WNBlocks.TROPICAL_GRASS_PATH = new GrassPathBase(Block.Properties.create(Material.EARTH, MaterialColor.YELLOW).sound(SoundType.PLANT).hardnessAndResistance(0.6F).harvestTool(ToolType.SHOVEL), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("tropical_grass_path"),"twildnature:ropical_dirt"),
                WNBlocks.DESERT_GRASS_PATH = new GrassPathBase(Block.Properties.create(Material.EARTH, MaterialColor.YELLOW).sound(SoundType.PLANT).hardnessAndResistance(0.6F).harvestTool(ToolType.SHOVEL), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("desert_grass_path"),"wildnature:desert_dirt"),
                WNBlocks.DRIED_GRASS_PATH = new GrassPathBase(Block.Properties.create(Material.EARTH, MaterialColor.YELLOW).sound(SoundType.PLANT).hardnessAndResistance(0.6F).harvestTool(ToolType.SHOVEL), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("dried_grass_path"),"wildnature:dried_dirt"),

                WNBlocks.BROWN_DIRT = new DirtBase(Block.Properties.create(Material.EARTH, MaterialColor.BROWN).sound(SoundType.GROUND).hardnessAndResistance(0.5F).harvestTool(ToolType.SHOVEL), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("brown_dirt")),
                WNBlocks.MOLD_DIRT = new DirtBase(Block.Properties.create(Material.EARTH, MaterialColor.BROWN).sound(SoundType.GROUND).hardnessAndResistance(0.5F).harvestTool(ToolType.SHOVEL), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("mold_dirt")),
                WNBlocks.TROPICAL_DIRT = new DirtBase(Block.Properties.create(Material.EARTH, MaterialColor.RED).sound(SoundType.GROUND).hardnessAndResistance(0.5F).harvestTool(ToolType.SHOVEL), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("tropical_dirt")),
                WNBlocks.DESERT_DIRT = new DirtBase(Block.Properties.create(Material.EARTH, MaterialColor.YELLOW).sound(SoundType.GROUND).hardnessAndResistance(0.5F).harvestTool(ToolType.SHOVEL), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("desert_dirt")),
                WNBlocks.DRIED_DIRT = new DirtBase(Block.Properties.create(Material.EARTH, MaterialColor.LIGHT_GRAY).sound(SoundType.GROUND).hardnessAndResistance(0.5F).harvestTool(ToolType.SHOVEL), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("dried_dirt")),

                WNBlocks.BROWN_FARMLAND = new FarmlandBase(Block.Properties.create(Material.EARTH, MaterialColor.BROWN).sound(SoundType.GROUND).hardnessAndResistance(0.6F).harvestTool(ToolType.SHOVEL), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("brown_farmland"),"wildnature:brown_dirt"),
                WNBlocks.MOLD_FARMLAND = new FarmlandBase(Block.Properties.create(Material.EARTH, MaterialColor.BROWN).sound(SoundType.GROUND).hardnessAndResistance(0.6F).harvestTool(ToolType.SHOVEL), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("mold_farmland"),"wildnature:mold_dirt"),
                WNBlocks.TROPICAL_FARMLAND = new FarmlandBase(Block.Properties.create(Material.EARTH, MaterialColor.RED).sound(SoundType.GROUND).hardnessAndResistance(0.6F).harvestTool(ToolType.SHOVEL), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("tropical_farmland"),"wildnature:tropical_dirt"),
                WNBlocks.DESERT_FARMLAND = new FarmlandBase(Block.Properties.create(Material.EARTH, MaterialColor.YELLOW).sound(SoundType.GROUND).hardnessAndResistance(0.6F).harvestTool(ToolType.SHOVEL), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("desert_farmland"),"wildnature:desert_dirt"),
                WNBlocks.DRIED_FARMLAND = new FarmlandBase(Block.Properties.create(Material.EARTH, MaterialColor.LIGHT_GRAY).sound(SoundType.GROUND).hardnessAndResistance(0.6F).harvestTool(ToolType.SHOVEL), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("dried_farmland"),"wildnature:dried_dirt"),


                WNBlocks.SAND_RED_FULL = new SandBase(Block.Properties.create(Material.SAND, MaterialColor.RED).harvestTool(ToolType.SHOVEL), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("sand_red_full")),
                WNBlocks.SAND_RED_HALF = new SandBase(Block.Properties.create(Material.SAND, MaterialColor.RED).harvestTool(ToolType.SHOVEL), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("sand_red_half")),
                WNBlocks.SAND_RED_SLIGHT = new SandBase(Block.Properties.create(Material.SAND, MaterialColor.RED).harvestTool(ToolType.SHOVEL), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("sand_red_slight")),
                WNBlocks.SAND_BROWN_FULL = new SandBase(Block.Properties.create(Material.SAND, MaterialColor.BROWN).harvestTool(ToolType.SHOVEL), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("sand_brown_full")),
                WNBlocks.SAND_BROWN_HALF = new SandBase(Block.Properties.create(Material.SAND, MaterialColor.BROWN).harvestTool(ToolType.SHOVEL), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("sand_brown_half")),
                WNBlocks.SAND_BROWN_SLIGHT = new SandBase(Block.Properties.create(Material.SAND, MaterialColor.BROWN).harvestTool(ToolType.SHOVEL), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("sand_brown_slight")),
                WNBlocks.WHITE_SAND = new SandBase(Block.Properties.create(Material.SAND, MaterialColor.WHITE_TERRACOTTA).harvestTool(ToolType.SHOVEL), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("sand_white")),
                WNBlocks.FOREST_SAND = new SandBase(Block.Properties.create(Material.SAND, MaterialColor.YELLOW).harvestTool(ToolType.SHOVEL), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("forest_sand")),
                WNBlocks.QUICKSAND = new SandBase(Block.Properties.create(Material.SAND, MaterialColor.YELLOW_TERRACOTTA).harvestTool(ToolType.SHOVEL), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("quicksand")),

                WNBlocks.WHITE_SANDSTONE = new BlockBase(Block.Properties.create(Material.ROCK, MaterialColor.WHITE_TERRACOTTA).hardnessAndResistance(0.8F,0.5F), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("white_sandstone")),
                WNBlocks.CRACKED_SANDSTONE = new BlockBase(Block.Properties.create(Material.ROCK, MaterialColor.YELLOW_TERRACOTTA).hardnessAndResistance(0.8F,0.5F), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("cracked_sandstone")),
                WNBlocks.SALT_BLOCK = new BlockBase(Block.Properties.create(Material.ROCK, MaterialColor.WHITE_TERRACOTTA).hardnessAndResistance(0.8F,0.5F), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("salt_block")),

                WNBlocks.MUD = new MudBlock(Block.Properties.create(Material.EARTH, MaterialColor.BROWN).sound(SoundType.SLIME).hardnessAndResistance(1.2F,0.3F).harvestTool(ToolType.SHOVEL).doesNotBlockMovement(), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("mud")),



        };
    }

    public Block[] getGrass() {
        return grass;
    }
}
