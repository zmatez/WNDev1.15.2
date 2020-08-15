package com.matez.wildnature.world.gen.structures.nature.rocks;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Set;
import java.util.function.Function;

public class big_rock_7 extends SchemFeature {
    public big_rock_7() {
        super();
        terrainIncrease = 1;
    }

    @Override
    public Set<BlockPos> setBlocks() {

        Block(-5, 1, -5, "minecraft:stone");
        Block(-5, 2, -5, "minecraft:stone");
        Block(-5, 1, -4, "minecraft:stone");
        Block(-2, 1, -4, "minecraft:stone");
        Block(0, 1, -4, "minecraft:stone");
        Block(1, 1, -4, "minecraft:stone");
        Block(-5, 1, -3, "minecraft:stone");
        Block(-2, 1, -3, "minecraft:stone");
        Block(0, 1, -3, "minecraft:stone");
        Block(1, 1, -3, "minecraft:stone");
        Block(2, 1, -3, "minecraft:stone");
        Block(3, 1, -3, "minecraft:stone");
        Block(-5, 2, -3, "minecraft:stone");
        Block(-2, 2, -3, "minecraft:stone");
        Block(0, 2, -3, "minecraft:stone");
        Block(0, 3, -3, "minecraft:stone");
        Block(-4, 1, -2, "minecraft:stone");
        Block(-3, 1, -2, "minecraft:stone");
        Block(-2, 1, -2, "minecraft:stone");
        Block(-1, 1, -2, "minecraft:stone");
        Block(0, 1, -2, "minecraft:stone");
        Block(1, 1, -2, "minecraft:stone");
        Block(2, 1, -2, "minecraft:stone");
        Block(3, 1, -2, "minecraft:stone");
        Block(0, 2, -2, "minecraft:stone");
        Block(1, 2, -2, "minecraft:stone");
        Block(0, 3, -2, "minecraft:stone");
        Block(0, 4, -2, "minecraft:stone");
        Block(0, 5, -2, "minecraft:stone");
        Block(-5, 1, -1, "minecraft:stone");
        Block(-4, 1, -1, "minecraft:stone");
        Block(-3, 1, -1, "minecraft:stone");
        Block(-2, 1, -1, "minecraft:stone");
        Block(-1, 1, -1, "minecraft:stone");
        Block(0, 1, -1, "minecraft:stone");
        Block(1, 1, -1, "minecraft:stone");
        Block(2, 1, -1, "minecraft:stone");
        Block(3, 1, -1, "minecraft:stone");
        Block(-3, 2, -1, "minecraft:stone");
        Block(-2, 2, -1, "minecraft:stone");
        Block(2, 2, -1, "minecraft:stone");
        Block(-2, 3, -1, "minecraft:stone");
        Block(-3, 1, 0, "minecraft:stone");
        Block(-2, 1, 0, "minecraft:stone");
        Block(-1, 1, 0, "minecraft:stone");
        Block(0, 1, 0, "minecraft:stone");
        Block(1, 1, 0, "minecraft:stone");
        Block(2, 1, 0, "minecraft:stone");
        Block(-2, 2, 0, "minecraft:stone");
        Block(-2, 3, 0, "minecraft:stone");
        Block(-2, 4, 0, "minecraft:stone");
        Block(-2, 5, 0, "minecraft:stone");
        Block(-1, 1, 1, "minecraft:stone");
        Block(0, 1, 1, "minecraft:stone");
        Block(1, 1, 1, "minecraft:stone");
        Block(2, 1, 1, "minecraft:stone");
        Block(3, 1, 1, "minecraft:stone");
        Block(1, 2, 1, "minecraft:stone");
        Block(1, 3, 1, "minecraft:stone");
        Block(-2, 1, 2, "minecraft:stone");
        Block(-1, 1, 2, "minecraft:stone");
        Block(0, 1, 2, "minecraft:stone");
        Block(1, 1, 2, "minecraft:stone");
        Block(2, 1, 2, "minecraft:stone");
        Block(3, 1, 2, "minecraft:stone");
        Block(0, 2, 2, "minecraft:stone");
        Block(1, 2, 2, "minecraft:stone");
        Block(2, 2, 2, "minecraft:stone");
        Block(1, 3, 2, "minecraft:stone");
        Block(1, 4, 2, "minecraft:stone");
        Block(1, 5, 2, "minecraft:stone");
        Block(-1, 1, 3, "minecraft:stone");
        Block(0, 1, 3, "minecraft:stone");
        Block(1, 1, 3, "minecraft:stone");
        Block(2, 1, 3, "minecraft:stone");
        Block(3, 1, 3, "minecraft:stone");
        Block(1, 1, 4, "minecraft:stone");
        Block(2, 1, 4, "minecraft:stone");
        Block(3, 1, 4, "minecraft:stone");
        Block(1, 1, 5, "minecraft:stone");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}