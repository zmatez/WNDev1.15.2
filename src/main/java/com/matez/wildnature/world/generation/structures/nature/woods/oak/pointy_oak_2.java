package com.matez.wildnature.world.generation.structures.nature.woods.oak;

import com.matez.wildnature.world.generation.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class pointy_oak_2 extends SchemFeature {
    public pointy_oak_2() {
        super();

    }


    @Override
    public Set<BlockPos> setBlocks() {

        Block(0, 1, -1, "minecraft:oak_log[axis=z]");
        Block(0, 3, -1, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(-1, 4, -1, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(0, 4, -1, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(1, 4, -1, "minecraft:oak_leaves[distance=2,persistent=true]");
        Block(0, 5, -1, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(-1, 1, 0, "minecraft:oak_log[axis=x]");
        Block(0, 1, 0, "minecraft:oak_log[axis=y]");
        Block(0, 2, 0, "minecraft:oak_log[axis=y]");
        Block(-1, 3, 0, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(0, 3, 0, "minecraft:oak_log[axis=y]");
        Block(1, 3, 0, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(-2, 4, 0, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(-1, 4, 0, "minecraft:oak_log[axis=x]");
        Block(0, 4, 0, "minecraft:oak_log[axis=y]");
        Block(1, 4, 0, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(2, 4, 0, "minecraft:oak_leaves[distance=2,persistent=true]");
        Block(-1, 5, 0, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(0, 5, 0, "minecraft:oak_log[axis=y]");
        Block(1, 5, 0, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(0, 6, 0, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(0, 1, 1, "minecraft:oak_log[axis=z]");
        Block(0, 3, 1, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(-2, 4, 1, "minecraft:oak_leaves[distance=2,persistent=true]");
        Block(-1, 4, 1, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(0, 4, 1, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(1, 4, 1, "minecraft:oak_leaves[distance=2,persistent=true]");
        Block(-1, 5, 1, "minecraft:oak_leaves[distance=2,persistent=true]");
        Block(0, 5, 1, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(-1, 4, 2, "minecraft:oak_leaves[distance=2,persistent=true]");
        Block(0, 4, 2, "minecraft:oak_leaves[distance=2,persistent=true]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}