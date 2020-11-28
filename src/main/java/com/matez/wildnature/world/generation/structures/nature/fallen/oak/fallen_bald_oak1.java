package com.matez.wildnature.world.generation.structures.nature.fallen.oak;

import com.matez.wildnature.world.generation.structures.nature.fallen.FallenSchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class fallen_bald_oak1 extends FallenSchemFeature {

    @Override
    public Set<BlockPos> setBlocks() {

        Block(0, 0, -6, "minecraft:oak_log[axis=y]");
        Block(0, 0, -5, "minecraft:oak_log[axis=y]");
        Block(1, 0, -5, "minecraft:oak_log[axis=y]");
        Block(0, 1, -5, "minecraft:oak_log[axis=y]");
        Block(1, 1, -5, "minecraft:snow[layers=3]");
        Block(0, 2, -5, "minecraft:snow[layers=1]");
        Block(0, 1, -3, "minecraft:oak_log[axis=z]");
        Block(0, 2, -3, "minecraft:snow[layers=1]");
        Block(0, 1, -2, "minecraft:oak_log[axis=z]");
        Block(0, 1, -1, "minecraft:oak_log[axis=z]");
        Block(1, 1, -1, "minecraft:oak_log[axis=x]");
        Block(2, 1, -1, "minecraft:oak_log[axis=x]");
        Block(0, 2, -1, "minecraft:oak_log[axis=y]");
        Block(1, 2, -1, "minecraft:snow[layers=3]");
        Block(2, 2, -1, "minecraft:snow[layers=1]");
        Block(0, 3, -1, "minecraft:snow[layers=1]");
        Block(-2, 1, 0, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(-1, 1, 0, "minecraft:oak_log[axis=x]");
        Block(0, 1, 0, "minecraft:oak_log[axis=z]");
        Block(3, 1, 0, "minecraft:oak_log[axis=z]");
        Block(-2, 2, 0, "minecraft:snow[layers=1]");
        Block(0, 2, 0, "minecraft:snow[layers=3]");
        Block(3, 2, 0, "minecraft:snow[layers=1]");
        Block(-2, 1, 1, "minecraft:oak_log[axis=z]");
        Block(0, 1, 1, "minecraft:oak_log[axis=z]");
        Block(3, 1, 1, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(-2, 2, 1, "minecraft:snow[layers=2]");
        Block(0, 2, 1, "minecraft:oak_log[axis=y]");
        Block(3, 2, 1, "minecraft:snow[layers=2]");
        Block(0, 3, 1, "minecraft:snow[layers=1]");
        Block(0, 1, 2, "minecraft:oak_log[axis=z]");
        Block(0, 2, 2, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(-1, 1, 3, "minecraft:oak_log[axis=z]");
        Block(1, 1, 3, "minecraft:oak_log[axis=z]");
        Block(-1, 2, 3, "minecraft:snow[layers=3]");
        Block(1, 2, 3, "minecraft:snow[layers=1]");
        Block(-1, 1, 4, "minecraft:oak_log[axis=z]");
        Block(0, 1, 4, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(1, 1, 4, "minecraft:oak_log[axis=z]");
        Block(-1, 2, 4, "minecraft:snow[layers=2]");
        Block(1, 2, 4, "minecraft:oak_log[axis=y]");
        Block(1, 3, 4, "minecraft:snow[layers=1]");
        Block(-1, 1, 5, "minecraft:oak_log[axis=z]");
        Block(1, 1, 5, "minecraft:oak_log[axis=z]");
        Block(2, 1, 5, "minecraft:oak_log[axis=x]");
        Block(1, 2, 5, "minecraft:snow[layers=3]");
        Block(2, 2, 5, "minecraft:snow[layers=1]");
        Block(1, 1, 6, "minecraft:oak_log[axis=z]");
        Block(3, 1, 6, "minecraft:oak_log[axis=z]");
        Block(-2, 1, 7, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(-1, 1, 7, "minecraft:oak_log[axis=x]");
        Block(0, 1, 7, "minecraft:oak_log[axis=x]");
        Block(1, 1, 7, "minecraft:oak_log[axis=z]");
        Block(3, 1, 7, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(-1, 2, 7, "minecraft:snow[layers=3]");
        Block(0, 2, 7, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(1, 2, 7, "minecraft:oak_log[axis=y]");
        Block(3, 2, 7, "minecraft:snow[layers=1]");
        Block(0, 3, 7, "minecraft:snow[layers=1]");
        Block(1, 3, 7, "minecraft:snow[layers=2]");
        Block(-2, 1, 8, "minecraft:oak_log[axis=x]");
        Block(1, 1, 8, "minecraft:oak_log[axis=z]");
        Block(-2, 2, 8, "minecraft:snow[layers=1]");
        Block(1, 2, 8, "minecraft:snow[layers=3]");
        Block(1, 1, 9, "minecraft:oak_log[axis=z]");
        Block(1, 2, 9, "minecraft:snow[layers=1]");
        Block(2, 1, 10, "minecraft:oak_log[axis=z]");
        Block(2, 1, 11, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(2, 2, 11, "minecraft:snow[layers=1]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     https://wildnaturemod.com
        return super.setBlocks();
    }
}