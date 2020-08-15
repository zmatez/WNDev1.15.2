package com.matez.wildnature.world.gen.structures.nature.rocks;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Set;
import java.util.function.Function;

public class rock3 extends SchemFeature {
    public rock3() {
        super();
        terrainIncrease = 1;
    }

    @Override
    public Set<BlockPos> setBlocks() {

        Block(-1, 1, -1, "minecraft:stone_stairs[facing=east,half=bottom,shape=straight,waterlogged=false]");
        Block(0, 1, -1, "minecraft:andesite");
        Block(1, 0, 0, "minecraft:andesite_stairs[facing=west,half=bottom,shape=straight,waterlogged=false]");
        Block(-1, 1, 0, "wildnature:marble");
        Block(0, 1, 0, "minecraft:stone");
        Block(-1, 2, 0, "minecraft:cobblestone_slab[type=bottom,waterlogged=false]");
        Block(0, 2, 0, "wildnature:slate");
        Block(0, 1, 1, "minecraft:stone_stairs[facing=north,half=top,shape=straight,waterlogged=false]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}