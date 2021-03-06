package com.matez.wildnature.world.generation.structures.nature.woods.shrubs;

import com.matez.wildnature.world.generation.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class shrub3 extends SchemFeature {
    public shrub3() {
        super();

    }


    @Override
    public Set<BlockPos> setBlocks() {

        Block(1, 2, -2, "minecraft:dark_oak_leaves[distance=4,persistent=true]");
        Block(0, 3, -2, "minecraft:dark_oak_leaves[distance=2,persistent=true]");
        Block(1, 3, -2, "minecraft:dark_oak_leaves[distance=3,persistent=true]");
        Block(0, 4, -2, "minecraft:dark_oak_leaves[distance=2,persistent=true]");
        Block(0, 2, -1, "minecraft:dark_oak_leaves[distance=1,persistent=true]");
        Block(-1, 3, -1, "minecraft:dark_oak_leaves[distance=2,persistent=true]");
        Block(0, 3, -1, "minecraft:dark_oak_leaves[distance=1,persistent=true]");
        Block(2, 3, -1, "minecraft:dark_oak_leaves[distance=7,persistent=true]");
        Block(-1, 4, -1, "minecraft:dark_oak_leaves[distance=2,persistent=true]");
        Block(0, 4, -1, "minecraft:dark_oak_leaves[distance=1,persistent=true]");
        Block(0, 5, -1, "minecraft:dark_oak_leaves[distance=2,persistent=true]");
        Block(1, 5, -1, "minecraft:dark_oak_leaves[distance=3,persistent=true]");
        Block(0, 1, 0, "minecraft:dark_oak_log[axis=y]");
        Block(-2, 2, 0, "minecraft:dark_oak_leaves[distance=2,persistent=true]");
        Block(-1, 2, 0, "minecraft:dark_oak_leaves[distance=1,persistent=true]");
        Block(0, 2, 0, "minecraft:dark_oak_log[axis=y]");
        Block(1, 2, 0, "minecraft:dark_oak_leaves[distance=1,persistent=true]");
        Block(2, 2, 0, "minecraft:dark_oak_leaves[distance=2,persistent=true]");
        Block(-2, 3, 0, "minecraft:dark_oak_leaves[distance=3,persistent=true]");
        Block(0, 3, 0, "minecraft:dark_oak_log[axis=y]");
        Block(1, 3, 0, "minecraft:dark_oak_leaves[distance=1,persistent=true]");
        Block(-1, 4, 0, "minecraft:dark_oak_leaves[distance=1,persistent=true]");
        Block(0, 4, 0, "minecraft:dark_oak_log[axis=y]");
        Block(1, 4, 0, "minecraft:dark_oak_leaves[distance=1,persistent=true]");
        Block(-2, 5, 0, "minecraft:dark_oak_leaves[distance=7,persistent=true]");
        Block(0, 5, 0, "minecraft:dark_oak_leaves[distance=1,persistent=true]");
        Block(0, 6, 0, "minecraft:dark_oak_leaves[distance=2,persistent=true]");
        Block(0, 2, 1, "minecraft:dark_oak_leaves[distance=1,persistent=true]");
        Block(-1, 3, 1, "minecraft:dark_oak_leaves[distance=7,persistent=true]");
        Block(1, 3, 1, "minecraft:dark_oak_leaves[distance=2,persistent=true]");
        Block(0, 4, 1, "minecraft:dark_oak_leaves[distance=1,persistent=true]");
        Block(-1, 2, 2, "minecraft:dark_oak_leaves[distance=3,persistent=true]");
        Block(0, 2, 2, "minecraft:dark_oak_leaves[distance=2,persistent=true]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}