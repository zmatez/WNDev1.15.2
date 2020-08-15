package com.matez.wildnature.world.gen.structures.nature.rocks;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Set;
import java.util.function.Function;

public class rock8 extends SchemFeature {
    public rock8() {
        super();
        terrainIncrease = 1;
    }

    @Override
    public Set<BlockPos> setBlocks() {

        Block(-1, 0, -1, "wildnature:limestone");
        Block(0, 0, -1, "minecraft:stone");
        Block(-1, 1, -1, "minecraft:stone");
        Block(0, 1, -1, "minecraft:stone");
        Block(-1, 2, -1, "minecraft:stone_slab[type=bottom,waterlogged=false]");
        Block(0, 2, -1, "minecraft:stone");
        Block(0, 3, -1, "wildnature:slate");
        Block(0, 4, -1, "minecraft:coal_ore");
        Block(0, 5, -1, "wildnature:gneiss");
        Block(0, 6, -1, "minecraft:andesite_stairs[facing=south,half=bottom,shape=straight,waterlogged=false]");
        Block(-2, 0, 0, "minecraft:stone_slab[type=bottom,waterlogged=false]");
        Block(-1, 0, 0, "minecraft:stone");
        Block(1, 0, 0, "minecraft:stone");
        Block(-1, 1, 0, "minecraft:stone_stairs[facing=east,half=top,shape=straight,waterlogged=false]");
        Block(0, 1, 0, "minecraft:stone");
        Block(1, 1, 0, "minecraft:iron_ore");
        Block(0, 2, 0, "minecraft:stone");
        Block(1, 2, 0, "minecraft:stone");
        Block(0, 3, 0, "minecraft:iron_ore");
        Block(1, 3, 0, "wildnature:slate");
        Block(0, 4, 0, "minecraft:cobblestone");
        Block(1, 4, 0, "minecraft:stone");
        Block(0, 5, 0, "minecraft:iron_ore");
        Block(1, 5, 0, "minecraft:andesite_slab[type=bottom,waterlogged=false]");
        Block(0, 6, 0, "wildnature:marble");
        Block(0, 7, 0, "minecraft:stone_stairs[facing=north,half=bottom,shape=straight,waterlogged=false]");
        Block(-2, 0, 1, "wildnature:limestone");
        Block(-1, 0, 1, "minecraft:cobblestone");
        Block(0, 0, 1, "minecraft:stone");
        Block(1, 0, 1, "minecraft:stone");
        Block(2, 0, 1, "minecraft:stone_stairs[facing=west,half=bottom,shape=straight,waterlogged=false]");
        Block(-1, 1, 1, "minecraft:stone");
        Block(0, 1, 1, "minecraft:stone");
        Block(1, 1, 1, "minecraft:stone");
        Block(-1, 2, 1, "minecraft:coal_ore");
        Block(0, 2, 1, "minecraft:stone");
        Block(1, 2, 1, "minecraft:cobblestone");
        Block(-1, 3, 1, "minecraft:stone_stairs[facing=east,half=bottom,shape=straight,waterlogged=false]");
        Block(0, 3, 1, "minecraft:stone");
        Block(0, 4, 1, "minecraft:stone_slab[type=bottom,waterlogged=false]");
        Block(0, 0, 2, "wildnature:slate");
        Block(0, 1, 2, "minecraft:stone_stairs[facing=north,half=bottom,shape=straight,waterlogged=false]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}