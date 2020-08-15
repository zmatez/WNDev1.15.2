package com.matez.wildnature.world.gen.structures.nature.woods.oak;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class bald_oak_3 extends SchemFeature {
    public bald_oak_3() {
        super();

    }


    @Override
    public Set<BlockPos> setBlocks() {

        Block(1, 10, -2, "minecraft:oak_log[axis=x]");
        Block(1, 11, -2, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(0, 1, -1, "minecraft:oak_log[axis=y]");
        Block(2, 5, -1, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(1, 6, -1, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(2, 6, -1, "minecraft:oak_log[axis=z]");
        Block(0, 8, -1, "minecraft:oak_log[axis=z]");
        Block(1, 8, -1, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(0, 10, -1, "minecraft:oak_log[axis=z]");
        Block(0, 1, 0, "minecraft:oak_log[axis=y]");
        Block(1, 1, 0, "minecraft:oak_log[axis=y]");
        Block(0, 2, 0, "minecraft:oak_log[axis=y]");
        Block(1, 2, 0, "minecraft:oak_log[axis=y]");
        Block(0, 3, 0, "minecraft:oak_log[axis=y]");
        Block(0, 4, 0, "minecraft:oak_log[axis=y]");
        Block(1, 4, 0, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(-2, 5, 0, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(-1, 5, 0, "minecraft:oak_log[axis=x]");
        Block(0, 5, 0, "minecraft:oak_log[axis=y]");
        Block(-1, 6, 0, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(0, 6, 0, "minecraft:oak_log[axis=y]");
        Block(1, 6, 0, "minecraft:oak_log[axis=x]");
        Block(0, 7, 0, "minecraft:oak_log[axis=y]");
        Block(-1, 8, 0, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(0, 8, 0, "minecraft:oak_log[axis=y]");
        Block(-2, 9, 0, "minecraft:oak_log[axis=x]");
        Block(-1, 9, 0, "minecraft:oak_log[axis=x]");
        Block(0, 9, 0, "minecraft:oak_log[axis=y]");
        Block(3, 9, 0, "minecraft:oak_leaves[distance=7,persistent=true]");
        Block(-2, 10, 0, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(0, 10, 0, "minecraft:oak_log[axis=y]");
        Block(1, 10, 0, "minecraft:oak_log[axis=x]");
        Block(2, 10, 0, "minecraft:oak_log[axis=x]");
        Block(0, 11, 0, "minecraft:oak_log[axis=y]");
        Block(2, 11, 0, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(0, 0, 1, "minecraft:oak_log[axis=y]");
        Block(0, 1, 1, "minecraft:oak_log[axis=y]");
        Block(0, 2, 1, "minecraft:oak_log[axis=y]");
        Block(-2, 5, 1, "minecraft:oak_log[axis=z]");
        Block(2, 6, 1, "minecraft:oak_leaves[distance=7,persistent=true]");
        Block(0, 8, 1, "minecraft:oak_log[axis=z]");
        Block(-3, 9, 1, "minecraft:oak_leaves[distance=7,persistent=true]");
        Block(-3, 5, 2, "minecraft:oak_leaves[distance=7,persistent=true]");
        Block(0, 8, 2, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(1, 8, 2, "minecraft:oak_log[axis=x]");
        Block(1, 9, 2, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(2, 8, 3, "minecraft:oak_leaves[distance=7,persistent=true]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}