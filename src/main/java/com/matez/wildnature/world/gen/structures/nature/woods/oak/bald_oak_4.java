package com.matez.wildnature.world.gen.structures.nature.woods.oak;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class bald_oak_4 extends SchemFeature {
    public bald_oak_4() {
        super();

    }


    @Override
    public Set<BlockPos> setBlocks() {

        Block(-1, 4, -3, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(3, 10, -3, "minecraft:oak_leaves[distance=7,persistent=true]");
        Block(-1, 4, -2, "minecraft:oak_log[axis=z]");
        Block(2, 7, -2, "minecraft:oak_leaves[distance=7,persistent=true]");
        Block(-1, 10, -2, "minecraft:oak_leaves[distance=7,persistent=true]");
        Block(1, 10, -2, "minecraft:oak_log[axis=x]");
        Block(2, 10, -2, "minecraft:oak_log[axis=x]");
        Block(-1, 1, -1, "minecraft:oak_log[axis=y]");
        Block(3, 3, -1, "minecraft:oak_leaves[distance=7,persistent=true]");
        Block(0, 4, -1, "minecraft:oak_log[axis=z]");
        Block(2, 4, -1, "minecraft:oak_leaves[distance=7,persistent=true]");
        Block(-2, 7, -1, "minecraft:oak_leaves[distance=7,persistent=true]");
        Block(0, 7, -1, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(3, 7, -1, "minecraft:oak_log[axis=x]");
        Block(0, 10, -1, "minecraft:oak_log[axis=z]");
        Block(-1, 1, 0, "minecraft:oak_log[axis=y]");
        Block(0, 1, 0, "minecraft:oak_log[axis=y]");
        Block(1, 1, 0, "minecraft:oak_log[axis=y]");
        Block(-1, 2, 0, "minecraft:oak_log[axis=y]");
        Block(0, 2, 0, "minecraft:oak_log[axis=y]");
        Block(0, 3, 0, "minecraft:oak_log[axis=y]");
        Block(1, 3, 0, "minecraft:oak_log[axis=x]");
        Block(2, 3, 0, "minecraft:oak_log[axis=x]");
        Block(0, 4, 0, "minecraft:oak_log[axis=y]");
        Block(-1, 5, 0, "minecraft:oak_log[axis=x]");
        Block(0, 5, 0, "minecraft:oak_log[axis=y]");
        Block(0, 6, 0, "minecraft:oak_log[axis=y]");
        Block(-1, 7, 0, "minecraft:oak_log[axis=x]");
        Block(0, 7, 0, "minecraft:oak_log[axis=y]");
        Block(1, 7, 0, "minecraft:oak_log[axis=x]");
        Block(2, 7, 0, "minecraft:oak_log[axis=x]");
        Block(0, 8, 0, "minecraft:oak_log[axis=y]");
        Block(0, 9, 0, "minecraft:oak_log[axis=y]");
        Block(0, 10, 0, "minecraft:oak_log[axis=y]");
        Block(0, 11, 0, "minecraft:oak_log[axis=y]");
        Block(0, 1, 1, "minecraft:oak_log[axis=y]");
        Block(0, 2, 1, "minecraft:oak_log[axis=y]");
        Block(3, 3, 1, "minecraft:oak_log[axis=x]");
        Block(0, 4, 1, "minecraft:oak_log[axis=z]");
        Block(-2, 5, 1, "minecraft:oak_log[axis=z]");
        Block(-1, 7, 1, "minecraft:oak_log[axis=z]");
        Block(1, 7, 1, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(3, 7, 1, "minecraft:oak_leaves[distance=7,persistent=true]");
        Block(-1, 9, 1, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(0, 9, 1, "minecraft:oak_log[axis=z]");
        Block(0, 4, 2, "minecraft:oak_log[axis=z]");
        Block(-2, 7, 2, "minecraft:oak_log[axis=x]");
        Block(0, 9, 2, "minecraft:oak_log[axis=z]");
        Block(1, 4, 3, "minecraft:oak_log[axis=z]");
        Block(-3, 7, 3, "minecraft:oak_leaves[distance=7,persistent=true]");
        Block(-1, 9, 3, "minecraft:oak_log[axis=z]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}