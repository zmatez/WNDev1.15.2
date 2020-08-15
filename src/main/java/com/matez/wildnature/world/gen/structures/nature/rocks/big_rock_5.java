package com.matez.wildnature.world.gen.structures.nature.rocks;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Set;
import java.util.function.Function;

public class big_rock_5 extends SchemFeature {
    public big_rock_5() {
        super();
        terrainIncrease = 1;
    }

    @Override
    public Set<BlockPos> setBlocks() {

        Block(0, 1, -6, "minecraft:stone");
        Block(1, 1, -6, "minecraft:stone");
        Block(2, 1, -6, "minecraft:stone");
        Block(1, 2, -6, "minecraft:stone");
        Block(-1, 1, -5, "minecraft:stone");
        Block(0, 1, -5, "minecraft:stone");
        Block(1, 1, -5, "minecraft:stone");
        Block(2, 1, -5, "minecraft:stone");
        Block(3, 1, -5, "minecraft:stone");
        Block(1, 2, -5, "minecraft:stone");
        Block(2, 2, -5, "minecraft:stone");
        Block(1, 3, -5, "minecraft:stone");
        Block(1, 4, -5, "minecraft:stone");
        Block(0, 1, -4, "minecraft:stone");
        Block(1, 1, -4, "minecraft:stone");
        Block(1, 4, -4, "minecraft:stone");
        Block(1, 5, -4, "minecraft:stone");
        Block(1, 1, -3, "minecraft:stone");
        Block(2, 1, -3, "minecraft:stone");
        Block(1, 4, -3, "minecraft:stone");
        Block(1, 5, -3, "minecraft:stone");
        Block(-3, 1, -2, "minecraft:stone");
        Block(-2, 1, -2, "minecraft:stone");
        Block(-1, 1, -2, "minecraft:stone");
        Block(0, 1, -2, "minecraft:stone");
        Block(1, 1, -2, "minecraft:stone");
        Block(2, 1, -2, "minecraft:stone");
        Block(0, 2, -2, "minecraft:stone");
        Block(1, 2, -2, "minecraft:stone");
        Block(2, 2, -2, "minecraft:stone");
        Block(1, 3, -2, "minecraft:stone");
        Block(2, 3, -2, "minecraft:stone");
        Block(1, 4, -2, "minecraft:stone");
        Block(2, 4, -2, "minecraft:stone");
        Block(1, 5, -2, "minecraft:stone");
        Block(-2, 1, -1, "minecraft:stone");
        Block(-1, 1, -1, "minecraft:stone");
        Block(0, 1, -1, "minecraft:stone");
        Block(1, 1, -1, "minecraft:stone");
        Block(2, 1, -1, "minecraft:stone");
        Block(3, 1, -1, "minecraft:stone");
        Block(-1, 2, -1, "minecraft:stone");
        Block(0, 2, -1, "minecraft:stone");
        Block(1, 2, -1, "minecraft:stone");
        Block(1, 3, -1, "minecraft:stone");
        Block(1, 4, -1, "minecraft:stone");
        Block(-3, 1, 0, "minecraft:stone");
        Block(-2, 1, 0, "minecraft:stone");
        Block(-1, 1, 0, "minecraft:stone");
        Block(0, 1, 0, "minecraft:stone");
        Block(1, 1, 0, "minecraft:stone");
        Block(2, 1, 0, "minecraft:stone");
        Block(-1, 2, 0, "minecraft:stone");
        Block(0, 2, 0, "minecraft:stone");
        Block(1, 3, 0, "minecraft:stone");
        Block(1, 4, 0, "minecraft:stone");
        Block(-4, 1, 1, "minecraft:stone");
        Block(-3, 1, 1, "minecraft:stone");
        Block(-2, 1, 1, "minecraft:stone");
        Block(-1, 1, 1, "minecraft:stone");
        Block(0, 1, 1, "minecraft:stone");
        Block(1, 1, 1, "minecraft:stone");
        Block(2, 1, 1, "minecraft:stone");
        Block(3, 1, 1, "minecraft:stone");
        Block(-2, 2, 1, "minecraft:stone");
        Block(-1, 2, 1, "minecraft:stone");
        Block(0, 2, 1, "minecraft:stone");
        Block(1, 2, 1, "minecraft:stone");
        Block(2, 2, 1, "minecraft:stone");
        Block(-1, 3, 1, "minecraft:stone");
        Block(0, 3, 1, "minecraft:stone");
        Block(1, 3, 1, "minecraft:stone");
        Block(2, 3, 1, "minecraft:stone");
        Block(-1, 4, 1, "minecraft:stone");
        Block(0, 4, 1, "minecraft:stone");
        Block(1, 4, 1, "minecraft:stone");
        Block(0, 5, 1, "minecraft:stone");
        Block(1, 5, 1, "minecraft:stone");
        Block(0, 6, 1, "minecraft:stone");
        Block(1, 6, 1, "minecraft:stone");
        Block(0, 7, 1, "minecraft:stone");
        Block(1, 7, 1, "minecraft:stone");
        Block(0, 8, 1, "minecraft:stone");
        Block(1, 8, 1, "minecraft:stone");
        Block(0, 9, 1, "minecraft:stone");
        Block(1, 9, 1, "minecraft:stone");
        Block(1, 10, 1, "minecraft:stone");
        Block(-3, 1, 2, "minecraft:stone");
        Block(-2, 1, 2, "minecraft:stone");
        Block(-1, 1, 2, "minecraft:stone");
        Block(0, 1, 2, "minecraft:stone");
        Block(1, 1, 2, "minecraft:stone");
        Block(2, 1, 2, "minecraft:stone");
        Block(3, 1, 2, "minecraft:stone");
        Block(-3, 2, 2, "minecraft:stone");
        Block(-2, 2, 2, "minecraft:stone");
        Block(-1, 2, 2, "minecraft:stone");
        Block(0, 2, 2, "minecraft:stone");
        Block(1, 2, 2, "minecraft:stone");
        Block(2, 2, 2, "minecraft:stone");
        Block(-1, 3, 2, "minecraft:stone");
        Block(0, 3, 2, "minecraft:stone");
        Block(1, 3, 2, "minecraft:stone");
        Block(2, 3, 2, "minecraft:stone");
        Block(0, 4, 2, "minecraft:stone");
        Block(1, 4, 2, "minecraft:stone");
        Block(0, 5, 2, "minecraft:stone");
        Block(1, 5, 2, "minecraft:stone");
        Block(1, 6, 2, "minecraft:stone");
        Block(1, 7, 2, "minecraft:stone");
        Block(-3, 1, 3, "minecraft:stone");
        Block(-2, 1, 3, "minecraft:stone");
        Block(-1, 1, 3, "minecraft:stone");
        Block(0, 1, 3, "minecraft:stone");
        Block(1, 1, 3, "minecraft:stone");
        Block(2, 1, 3, "minecraft:stone");
        Block(3, 1, 3, "minecraft:stone");
        Block(-1, 2, 3, "minecraft:stone");
        Block(0, 2, 3, "minecraft:stone");
        Block(1, 2, 3, "minecraft:stone");
        Block(2, 2, 3, "minecraft:stone");
        Block(0, 3, 3, "minecraft:stone");
        Block(2, 3, 3, "minecraft:stone");
        Block(0, 4, 3, "minecraft:stone");
        Block(-3, 1, 4, "minecraft:stone");
        Block(-1, 1, 4, "minecraft:stone");
        Block(0, 1, 4, "minecraft:stone");
        Block(1, 1, 4, "minecraft:stone");
        Block(2, 1, 4, "minecraft:stone");
        Block(3, 1, 4, "minecraft:stone");
        Block(0, 2, 4, "minecraft:stone");
        Block(1, 2, 4, "minecraft:stone");
        Block(0, 3, 4, "minecraft:stone");
        Block(-1, 1, 5, "minecraft:stone");
        Block(1, 1, 5, "minecraft:stone");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}