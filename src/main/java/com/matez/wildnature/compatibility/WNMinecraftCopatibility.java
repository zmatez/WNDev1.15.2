package com.matez.wildnature.compatibility;

import com.google.common.collect.Maps;
import com.matez.wildnature.Main;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.lists.WNItems;
import com.matez.wildnature.registry.WoodRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.FireBlock;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Items;
import net.minecraft.item.ShovelItem;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public class WNMinecraftCopatibility {

    public static void init(){
        for (String logType : WoodRegistry.logTypes) {
            Block b = Registry.BLOCK.getOrDefault(new ResourceLocation("wildnature",logType + "_log"));
            Block s = Registry.BLOCK.getOrDefault(new ResourceLocation("wildnature",logType + "_stripped_log"));
            Block bw = Registry.BLOCK.getOrDefault(new ResourceLocation("wildnature",logType + "_wood"));
            Block sw = Registry.BLOCK.getOrDefault(new ResourceLocation("wildnature",logType + "_stripped_wood"));
            if(b!=Blocks.AIR){
                registerStrippable(b,s);
                registerStrippable(bw,sw);
            }
        }

        for (String logType : WoodRegistry.logTypes) {
            Block[] b = new Block[]{
                    Registry.BLOCK.getOrDefault(new ResourceLocation("wildnature",logType + "_log")),
                    Registry.BLOCK.getOrDefault(new ResourceLocation("wildnature",logType + "_stripped_log")),
                    Registry.BLOCK.getOrDefault(new ResourceLocation("wildnature",logType + "_wood")),
                    Registry.BLOCK.getOrDefault(new ResourceLocation("wildnature",logType + "_stripped_wood")),
                    Registry.BLOCK.getOrDefault(new ResourceLocation("wildnature",logType + "_branch")),
                    Registry.BLOCK.getOrDefault(new ResourceLocation("wildnature",logType + "_fence")),
                    Registry.BLOCK.getOrDefault(new ResourceLocation("wildnature",logType + "_log_fence")),
                    Registry.BLOCK.getOrDefault(new ResourceLocation("wildnature",logType + "_planks")),
                    Registry.BLOCK.getOrDefault(new ResourceLocation("wildnature",logType + "_parquet")),
                    Registry.BLOCK.getOrDefault(new ResourceLocation("wildnature",logType + "_slab_planks")),
                    Registry.BLOCK.getOrDefault(new ResourceLocation("wildnature",logType + "_slab_parquet")),
                    Registry.BLOCK.getOrDefault(new ResourceLocation("wildnature",logType + "_stairs_planks")),
                    Registry.BLOCK.getOrDefault(new ResourceLocation("wildnature",logType + "_stairs_parquet")),
                    Registry.BLOCK.getOrDefault(new ResourceLocation("wildnature",logType + "_fence_gate")),
                    Registry.BLOCK.getOrDefault(new ResourceLocation("wildnature",logType + "_log_fence_gate")),
                    Registry.BLOCK.getOrDefault(new ResourceLocation("wildnature",logType + "_door")),
                    Registry.BLOCK.getOrDefault(new ResourceLocation("wildnature",logType + "_trapdoor")),
                    Registry.BLOCK.getOrDefault(new ResourceLocation("wildnature",logType + "_pressure_plate")),
                    Registry.BLOCK.getOrDefault(new ResourceLocation("wildnature",logType + "_button")),
                    Registry.BLOCK.getOrDefault(new ResourceLocation("wildnature",logType + "_log_pressure_plate")),
                    Registry.BLOCK.getOrDefault(new ResourceLocation("wildnature",logType + "_log_button"))
            };
            for (Block block : b) {
                registerFlammable(block,30,60);
            }

        }

        registerGrassPath(WNBlocks.BROWN_GRASS_BLOCK,WNBlocks.BROWN_GRASS_PATH);
        registerGrassPath(WNBlocks.MOLD_GRASS_BLOCK,WNBlocks.MOLD_GRASS_PATH);
        registerGrassPath(WNBlocks.DESERT_GRASS_BLOCK,WNBlocks.DESERT_GRASS_PATH);
        registerGrassPath(WNBlocks.DRIED_GRASS_BLOCK,WNBlocks.DRIED_GRASS_PATH);
        registerGrassPath(WNBlocks.TROPICAL_GRASS_BLOCK,WNBlocks.TROPICAL_GRASS_PATH);

        registerFarmland("brown",WNBlocks.BROWN_FARMLAND);
        registerFarmland("mold",WNBlocks.MOLD_FARMLAND);
        registerFarmland("desert",WNBlocks.DESERT_FARMLAND);
        registerFarmland("dried",WNBlocks.DRIED_FARMLAND);
        registerFarmland("tropical",WNBlocks.TROPICAL_FARMLAND);

        WNBlocks.LEAVES.forEach(block -> {
            registerFlammable(block,5,5);
        });

        WNBlocks.PLANTS.forEach(block -> {
            registerCompostable(0.65F,block);
        });

        WNBlocks.SAPLINGS.forEach(block -> {
            registerCompostable(0.3F,block);
        });

        WNBlocks.MUSHROOMS.forEach(block -> {
            registerCompostable(0.8F,block);
        });
        WNItems.FOOD.forEach(block -> {
            registerCompostable(0.65F,block);
        });
        WNBlocks.CROPS.forEach(block -> {
            registerCompostable(0.65F,block);
        });
    }

    public static void registerStrippable(Block log, Block stripped_log) {
        if(log==Blocks.AIR){
            return;
        }
        AxeItem.BLOCK_STRIPPING_MAP = Maps.newHashMap(AxeItem.BLOCK_STRIPPING_MAP);
        AxeItem.BLOCK_STRIPPING_MAP.put(log, stripped_log);
    }

    public static void registerGrassPath(Block grass, Block path) {
        if(grass==Blocks.AIR){
            return;
        }
        ShovelItem.SHOVEL_LOOKUP = Maps.newHashMap(ShovelItem.SHOVEL_LOOKUP);
        ShovelItem.SHOVEL_LOOKUP.put(grass, path.getDefaultState());
    }

    public static void registerFarmland(String dirt, Block farmland) {
        if(farmland==Blocks.AIR){
            return;
        }

        Block db = Main.getBlockByID("wildnature:"+dirt+"_dirt");
        Block dp = Main.getBlockByID("wildnature:"+dirt+"_grass_path");
        Block dg = Main.getBlockByID("wildnature:"+dirt+"_grass_block");

        HoeItem.HOE_LOOKUP = Maps.newHashMap(HoeItem.HOE_LOOKUP);
        HoeItem.HOE_LOOKUP.put(db, farmland.getDefaultState());
        HoeItem.HOE_LOOKUP = Maps.newHashMap(HoeItem.HOE_LOOKUP);
        HoeItem.HOE_LOOKUP.put(dp, farmland.getDefaultState());
        HoeItem.HOE_LOOKUP = Maps.newHashMap(HoeItem.HOE_LOOKUP);
        HoeItem.HOE_LOOKUP.put(dg, farmland.getDefaultState());
    }


    public static void registerCompostable(float chance, IItemProvider itemIn) {
        if(itemIn.asItem()!= Items.AIR) {
            ComposterBlock.CHANCES.put(itemIn.asItem(), chance);
        }
    }

    public static void registerFlammable(Block blockIn, int encouragement, int flammability) {
        if(blockIn==Blocks.AIR){
            return;
        }
        FireBlock fireblock = (FireBlock) Blocks.FIRE;
        fireblock.setFireInfo(blockIn, encouragement, flammability);
    }

}
