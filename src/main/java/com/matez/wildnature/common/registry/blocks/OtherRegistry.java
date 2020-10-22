package com.matez.wildnature.common.registry.blocks;

import com.matez.wildnature.init.Main;
import com.matez.wildnature.common.blocks.*;
import com.matez.wildnature.common.blocks.boundingboxes.*;
import com.matez.wildnature.client.tabs.WNTabs;
import com.matez.wildnature.util.lists.WNBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;

public class OtherRegistry {

    Block[] block;

    public OtherRegistry(){
        block = new Block[]{
                WNBlocks.GLOWING_CRYSTAL_BLUE = new GlowingCrystalBase(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().harvestTool(ToolType.PICKAXE),new Item.Properties().group(WNTabs.CAVES), Main.RegistryEvents.location("glowing_crystal_blue")),
                WNBlocks.GLOWING_CRYSTAL_ORANGE = new GlowingCrystalBase(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().harvestTool(ToolType.PICKAXE),new Item.Properties().group(WNTabs.CAVES), Main.RegistryEvents.location("glowing_crystal_orange")),
                WNBlocks.GLOWING_CRYSTAL_RED = new GlowingCrystalBase(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().harvestTool(ToolType.PICKAXE),new Item.Properties().group(WNTabs.CAVES), Main.RegistryEvents.location("glowing_crystal_red")),
                WNBlocks.GLOWING_CRYSTAL_PURPLE = new GlowingCrystalBase(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().harvestTool(ToolType.PICKAXE),new Item.Properties().group(WNTabs.CAVES), Main.RegistryEvents.location("glowing_crystal_purple")),
                WNBlocks.GLOWING_CRYSTAL_WHITE = new GlowingCrystalBase(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().harvestTool(ToolType.PICKAXE),new Item.Properties().group(WNTabs.CAVES), Main.RegistryEvents.location("glowing_crystal_white")),
                WNBlocks.PEBBLE = new PebbleBase(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).doesNotBlockMovement().hardnessAndResistance(1.2F,0.5F).harvestTool(ToolType.PICKAXE),new Item.Properties().group(WNTabs.CAVES), Main.RegistryEvents.location("pebble")),
                WNBlocks.STONE_SPIKE= new StoneSpikeBlock(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).doesNotBlockMovement(),new Item.Properties().group(WNTabs.CAVES), Main.RegistryEvents.location("stone_spike"),new StoneSpike()),

                WNBlocks.GEYSER = new GeyserBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F,6F).sound(SoundType.STONE),new Item.Properties().group(WNTabs.SURFACE), Main.RegistryEvents.location("geyser")),

                WNBlocks.RS_DELAY = new RSDelayBlock(Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0F).sound(SoundType.WOOD),new Item.Properties().group(ItemGroup.REDSTONE), Main.RegistryEvents.location("rs_delay")),
                WNBlocks.RS_PULSAR = new RSPulsarBlock(Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0F).sound(SoundType.WOOD),new Item.Properties().group(ItemGroup.REDSTONE), Main.RegistryEvents.location("rs_pulsar")),
                WNBlocks.RS_PROXIMITY_SENSOR = new RSProximitySensorBlock(Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0F).sound(SoundType.WOOD),new Item.Properties().group(ItemGroup.REDSTONE), Main.RegistryEvents.location("rs_proximity_sensor")),
                WNBlocks.RS_SIGNAL_HOLDER = new RSSignalHolder(Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0F).sound(SoundType.WOOD),new Item.Properties().group(ItemGroup.REDSTONE), Main.RegistryEvents.location("rs_signal_holder")),
                WNBlocks.RS_GATE_AND = new RSAndGate(Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0F).sound(SoundType.WOOD),new Item.Properties().group(ItemGroup.REDSTONE), Main.RegistryEvents.location("rs_gate_and")),

                WNBlocks.DUNGEON_LEVER = new LeverBase(Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0.5F).sound(SoundType.LANTERN),new Item.Properties().group(ItemGroup.REDSTONE), Main.RegistryEvents.location("dungeon_lever")),
                WNBlocks.DUNGEON_REDSTONE_TORCH = new RedstoneTorchBase(Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0F).sound(SoundType.LANTERN).lightValue(6), Main.RegistryEvents.location("dungeon_redstone_torch")),
                WNBlocks.DUNGEON_REDSTONE_TORCH_WALL = new RedstoneTorchWallBase(Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0F).sound(SoundType.LANTERN).lightValue(6), Main.RegistryEvents.location("dungeon_redstone_torch_wall")),
                WNBlocks.RS_PISTON1 = new CustomPistonBlock(true,Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0F).sound(SoundType.WOOD), Main.RegistryEvents.location("rs_piston1"), Main.RegistryEvents.location("rs_piston1_head"), Main.RegistryEvents.location("rs_piston1_moving")),
                WNBlocks.RS_PISTON1_HEAD = new CustomPistonHeadBlock(Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0F).sound(SoundType.WOOD), Main.RegistryEvents.location("rs_piston1_head"), Main.RegistryEvents.location("rs_piston1"), Main.RegistryEvents.location("rs_piston1_moving")),
                WNBlocks.RS_PISTON1_MOVING = new CustomMovingPistonBlock(Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0F).sound(SoundType.WOOD), Main.RegistryEvents.location("rs_piston1_moving")),
                WNBlocks.RS_DISPENSER = new BlockBase(Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(3F).sound(SoundType.STONE),new Item.Properties().group(ItemGroup.REDSTONE), Main.RegistryEvents.location("rs_dispenser")),
                WNBlocks.DUNGEON_COMMANDER = new DungeonCommander(Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(3F).sound(SoundType.STONE),new Item.Properties().group(ItemGroup.REDSTONE), Main.RegistryEvents.location("dungeon_commander")),
                WNBlocks.STEAM_GENERATOR = new SteamGeneratorBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(5F,6F).sound(SoundType.METAL),new Item.Properties().group(ItemGroup.REDSTONE), Main.RegistryEvents.location("rs_steam_generator")),
                WNBlocks.STEAM_GENERATOR2 = new SteamGeneratorBlock2(Block.Properties.create(Material.IRON).hardnessAndResistance(5F,6F).sound(SoundType.METAL),new Item.Properties().group(ItemGroup.REDSTONE), Main.RegistryEvents.location("rs_steam_generator2")),


                //WNBlocks.DUNGEON_HEART = new DungeonHeart(Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(10,100F).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE),new Item.Properties().group(WNTabs.CAVES), Main.RegistryEvents.location("dungeon_heart")),
                WNBlocks.DUNGEON_TORCH = new TorchBase(Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0F).sound(SoundType.LANTERN).lightValue(12), Main.RegistryEvents.location("dungeon_torch")),
                WNBlocks.DUNGEON_TORCH_WALL = new TorchWallBase(Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0F).sound(SoundType.LANTERN).lightValue(12), Main.RegistryEvents.location("dungeon_torch_wall")),
                WNBlocks.CRYSTAL_TORCH = new CrystalTorch(Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0F).sound(SoundType.LANTERN).lightValue(15), Main.RegistryEvents.location("crystal_torch")),
                WNBlocks.CRYSTAL_TORCH_WALL = new CrystalWallTorch(Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0F).sound(SoundType.LANTERN).lightValue(15), Main.RegistryEvents.location("crystal_torch_wall")),
                
                //CAKES
                WNBlocks.BLACK_CURRANT_CAKE = new CakeBase(Block.Properties.create(Material.CAKE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH),new Item.Properties().group(ItemGroup.FOOD), Main.RegistryEvents.location("black_currant_cake")),
                WNBlocks.CANDY_CAKE = new CakeBase(Block.Properties.create(Material.CAKE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH),new Item.Properties().group(ItemGroup.FOOD), Main.RegistryEvents.location("candy_cake")),
                WNBlocks.CARROT_CAKE = new CakeBase(Block.Properties.create(Material.CAKE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH),new Item.Properties().group(ItemGroup.FOOD), Main.RegistryEvents.location("carrot_cake")),
                WNBlocks.CHERRY_CAKE = new CakeBase(Block.Properties.create(Material.CAKE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH),new Item.Properties().group(ItemGroup.FOOD), Main.RegistryEvents.location("cherry_cake")),
                WNBlocks.CHOCO_CAKE = new CakeBase(Block.Properties.create(Material.CAKE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH),new Item.Properties().group(ItemGroup.FOOD), Main.RegistryEvents.location("choco_cake")),
                WNBlocks.CHOKEBERRY_CAKE = new CakeBase(Block.Properties.create(Material.CAKE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH),new Item.Properties().group(ItemGroup.FOOD), Main.RegistryEvents.location("chokeberry_cake")),
                WNBlocks.DARK_CHOCOLATE_CAKE = new CakeBase(Block.Properties.create(Material.CAKE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH),new Item.Properties().group(ItemGroup.FOOD), Main.RegistryEvents.location("dark_chocolate_cake")),
                WNBlocks.GRAPEFRUIT_CAKE = new CakeBase(Block.Properties.create(Material.CAKE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH),new Item.Properties().group(ItemGroup.FOOD), Main.RegistryEvents.location("grapefruit_cake")),
                WNBlocks.HAWTHORN_CAKE = new CakeBase(Block.Properties.create(Material.CAKE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH),new Item.Properties().group(ItemGroup.FOOD), Main.RegistryEvents.location("hawthorn_cake")),
                WNBlocks.KAMCHATKA_CAKE = new CakeBase(Block.Properties.create(Material.CAKE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH),new Item.Properties().group(ItemGroup.FOOD), Main.RegistryEvents.location("kamchatka_cake")),
                WNBlocks.LEMON_CAKE = new CakeBase(Block.Properties.create(Material.CAKE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH),new Item.Properties().group(ItemGroup.FOOD), Main.RegistryEvents.location("lemon_cake")),
                WNBlocks.MAZUREK = new CakeBase(Block.Properties.create(Material.CAKE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH),new Item.Properties().group(ItemGroup.FOOD), Main.RegistryEvents.location("mazurek")),
                WNBlocks.MILK_CHOCOLATE_CAKE = new CakeBase(Block.Properties.create(Material.CAKE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH),new Item.Properties().group(ItemGroup.FOOD), Main.RegistryEvents.location("milk_chocolate_cake")),
                WNBlocks.MINT_GOOSEBERRY_CAKE = new CakeBase(Block.Properties.create(Material.CAKE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH),new Item.Properties().group(ItemGroup.FOOD), Main.RegistryEvents.location("mint_gooseberry_cake")),
                WNBlocks.ORANGE_CAKE = new CakeBase(Block.Properties.create(Material.CAKE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH),new Item.Properties().group(ItemGroup.FOOD), Main.RegistryEvents.location("orange_cake")),
                WNBlocks.PINEAPPLE_CAKE = new CakeBase(Block.Properties.create(Material.CAKE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH),new Item.Properties().group(ItemGroup.FOOD), Main.RegistryEvents.location("pineapple_cake")),
                WNBlocks.QUINCE_CAKE = new CakeBase(Block.Properties.create(Material.CAKE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH),new Item.Properties().group(ItemGroup.FOOD), Main.RegistryEvents.location("quince_cake")),
                WNBlocks.RASPBERRY_CAKE = new CakeBase(Block.Properties.create(Material.CAKE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH),new Item.Properties().group(ItemGroup.FOOD), Main.RegistryEvents.location("raspberry_cake")),
                WNBlocks.STRAWBERRY_CAKE = new CakeBase(Block.Properties.create(Material.CAKE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH),new Item.Properties().group(ItemGroup.FOOD), Main.RegistryEvents.location("strawberry_cake")),
                WNBlocks.WHITE_CHOCOLATE_CAKE = new CakeBase(Block.Properties.create(Material.CAKE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH),new Item.Properties().group(ItemGroup.FOOD), Main.RegistryEvents.location("white_chocolate_cake")),
                WNBlocks.YEAST_DOUGH = new CakeBase(Block.Properties.create(Material.CAKE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH),new Item.Properties().group(ItemGroup.FOOD), Main.RegistryEvents.location("yeast_dough")),

                
                //SHELLS
                WNBlocks.COCKLESHELL = new ShellBlock(Block.Properties.create(Material.CORAL),new Item.Properties().group(WNTabs.UNDERWATER), Main.RegistryEvents.location("cockleshell")),
                WNBlocks.HORN_SHELL = new ShellBlock(Block.Properties.create(Material.CORAL),new Item.Properties().group(WNTabs.UNDERWATER), Main.RegistryEvents.location("horn_shell")),
                WNBlocks.LIONS_PAW = new ShellBlock(Block.Properties.create(Material.CORAL),new Item.Properties().group(WNTabs.UNDERWATER), Main.RegistryEvents.location("lions_paw")),
                WNBlocks.SAND_DOLLAR = new ShellBlock(Block.Properties.create(Material.CORAL),new Item.Properties().group(WNTabs.UNDERWATER), Main.RegistryEvents.location("sand_dollar")),
                WNBlocks.STAR_FISH = new ShellBlock(Block.Properties.create(Material.CORAL),new Item.Properties().group(WNTabs.UNDERWATER), Main.RegistryEvents.location("star_fish")),

                WNBlocks.JELLY_BLUE_BLOCK = new JellyBlock(Block.Properties.create(Material.CORAL, MaterialColor.LIGHT_BLUE_TERRACOTTA).slipperiness(0.95F).sound(SoundType.SLIME).lightValue(5),new Item.Properties().group(WNTabs.UNDERWATER), Main.RegistryEvents.location("jelly_blue_block")),
                WNBlocks.JELLY_ORANGE_BLOCK = new JellyBlock(Block.Properties.create(Material.CORAL, MaterialColor.ORANGE_TERRACOTTA).slipperiness(0.95F).sound(SoundType.SLIME).lightValue(9),new Item.Properties().group(WNTabs.UNDERWATER), Main.RegistryEvents.location("jelly_orange_block")),
                WNBlocks.JELLY_PINK_BLOCK = new JellyBlock(Block.Properties.create(Material.CORAL, MaterialColor.PINK_TERRACOTTA).slipperiness(0.95F).sound(SoundType.SLIME).lightValue(9),new Item.Properties().group(WNTabs.UNDERWATER), Main.RegistryEvents.location("jelly_pink_block")),
                WNBlocks.JELLY_RED_BLOCK = new JellyBlock(Block.Properties.create(Material.CORAL, MaterialColor.RED_TERRACOTTA).slipperiness(0.95F).sound(SoundType.SLIME).lightValue(7),new Item.Properties().group(WNTabs.UNDERWATER), Main.RegistryEvents.location("jelly_red_block")),
                WNBlocks.JELLY_WHITE_BLOCK = new JellyBlock(Block.Properties.create(Material.CORAL, MaterialColor.WHITE_TERRACOTTA).slipperiness(0.95F).sound(SoundType.SLIME).lightValue(13),new Item.Properties().group(WNTabs.UNDERWATER), Main.RegistryEvents.location("jelly_white_block")),

                WNBlocks.HYDROTHERMAL_VENT = new HydrothermalVent(Block.Properties.create(Material.SHULKER, MaterialColor.STONE).sound(SoundType.SCAFFOLDING),new Item.Properties().group(WNTabs.UNDERWATER), Main.RegistryEvents.location("hydrothermal_vent"))

        };
    }

    public Block[] getBlock() {
        return block;
    }
}
