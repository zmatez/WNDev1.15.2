package com.matez.wildnature.world.gen.structures.nature.rocks;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Set;
import java.util.function.Function;

public class rock6 extends SchemFeature {
    public rock6() {
        super();
        terrainIncrease = 1;
    }

    @Override
    public Set<BlockPos> setBlocks() {

        Block(1, 0, -1, "minecraft:stone_slab[type=bottom,waterlogged=false]");
        Block(-1, 1, -1, "minecraft:stone");
        Block(0, 1, -1, "minecraft:stone_stairs[facing=south,half=top,shape=straight,waterlogged=false]");
        Block(-1, 2, -1, "minecraft:stone_slab[type=bottom,waterlogged=false]");
        Block(0, 2, -1, "minecraft:stone");
        Block(0, 3, -1, "minecraft:coal_ore");
        Block(0, 4, -1, "minecraft:cobblestone_slab[type=bottom,waterlogged=false]");
        Block(-1, 1, 0, "minecraft:andesite_stairs[facing=north,half=bottom,shape=straight,waterlogged=false]");
        Block(0, 1, 0, "minecraft:stone");
        Block(1, 1, 0, "minecraft:cobblestone");
        Block(0, 2, 0, "minecraft:coal_ore");
        Block(1, 2, 0, "minecraft:stone_stairs[facing=west,half=bottom,shape=straight,waterlogged=false]");
        Block(0, 3, 0, "wildnature:slate");
        Block(0, 1, 1, "minecraft:stone");
        Block(1, 1, 1, "minecraft:stone_stairs[facing=west,half=bottom,shape=straight,waterlogged=false]");
        Block(0, 2, 1, "minecraft:andesite");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}