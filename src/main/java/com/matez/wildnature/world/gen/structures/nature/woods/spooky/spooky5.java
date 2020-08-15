package com.matez.wildnature.world.gen.structures.nature.woods.spooky;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class spooky5 extends SchemFeature {
    public spooky5() {
        super();

    }


    @Override
    public Set<BlockPos> setBlocks() {

        Block(-1, 3, -2, "minecraft:dark_oak_leaves[distance=3,persistent=true]");
        Block(0, 3, -2, "minecraft:dark_oak_leaves[distance=2,persistent=true]");
        Block(1, 3, -2, "minecraft:dark_oak_leaves[distance=2,persistent=true]");
        Block(2, 3, -2, "minecraft:dark_oak_leaves[distance=3,persistent=true]");
        Block(0, 1, -1, "minecraft:dark_oak_log[axis=z]");
        Block(0, 2, -1, "minecraft:dark_oak_leaves[distance=1,persistent=true]");
        Block(1, 2, -1, "minecraft:cobweb");
        Block(-1, 3, -1, "minecraft:dark_oak_leaves[distance=2,persistent=true]");
        Block(0, 3, -1, "minecraft:dark_oak_leaves[distance=1,persistent=true]");
        Block(1, 3, -1, "minecraft:dark_oak_leaves[distance=1,persistent=true]");
        Block(2, 3, -1, "minecraft:dark_oak_leaves[distance=2,persistent=true]");
        Block(0, 1, 0, "minecraft:dark_oak_log[axis=y]");
        Block(1, 1, 0, "minecraft:dark_oak_log[axis=y]");
        Block(2, 1, 0, "wildnature:lightning_bug[facing=down]");
        Block(0, 2, 0, "minecraft:dark_oak_log[axis=y]");
        Block(1, 2, 0, "minecraft:dark_oak_log[axis=y]");
        Block(2, 2, 0, "minecraft:dark_oak_log[axis=x]");
        Block(3, 2, 0, "minecraft:dark_oak_leaves[distance=1,persistent=true]");
        Block(-2, 3, 0, "minecraft:dark_oak_leaves[distance=2,persistent=true]");
        Block(-1, 3, 0, "minecraft:dark_oak_leaves[distance=1,persistent=true]");
        Block(0, 3, 0, "minecraft:dark_oak_log[axis=y]");
        Block(1, 3, 0, "minecraft:dark_oak_log[axis=y]");
        Block(2, 3, 0, "minecraft:dark_oak_leaves[distance=1,persistent=true]");
        Block(3, 3, 0, "minecraft:dark_oak_leaves[distance=2,persistent=true]");
        Block(0, 4, 0, "minecraft:dark_oak_leaves[distance=1,persistent=true]");
        Block(1, 4, 0, "minecraft:dark_oak_leaves[distance=1,persistent=true]");
        Block(0, 5, 0, "minecraft:cobweb");
        Block(-1, 1, 1, "minecraft:dark_oak_log[axis=x]");
        Block(0, 1, 1, "minecraft:dark_oak_log[axis=y]");
        Block(1, 1, 1, "minecraft:dark_oak_log[axis=y]");
        Block(0, 2, 1, "minecraft:dark_oak_log[axis=y]");
        Block(1, 2, 1, "minecraft:dark_oak_log[axis=y]");
        Block(2, 2, 1, "minecraft:cobweb");
        Block(-2, 3, 1, "minecraft:dark_oak_leaves[distance=2,persistent=true]");
        Block(-1, 3, 1, "minecraft:dark_oak_leaves[distance=1,persistent=true]");
        Block(0, 3, 1, "minecraft:dark_oak_log[axis=y]");
        Block(1, 3, 1, "minecraft:dark_oak_log[axis=y]");
        Block(2, 3, 1, "minecraft:dark_oak_leaves[distance=1,persistent=true]");
        Block(3, 3, 1, "minecraft:dark_oak_leaves[distance=2,persistent=true]");
        Block(0, 4, 1, "minecraft:dark_oak_leaves[distance=1,persistent=true]");
        Block(1, 4, 1, "minecraft:dark_oak_leaves[distance=1,persistent=true]");
        Block(2, 4, 1, "minecraft:cobweb");
        Block(1, 5, 1, "minecraft:dark_oak_leaves[distance=2,persistent=true]");
        Block(0, 2, 2, "wildnature:lightning_bug[facing=south]");
        Block(-2, 3, 2, "minecraft:dark_oak_leaves[distance=3,persistent=true]");
        Block(-1, 3, 2, "minecraft:dark_oak_leaves[distance=2,persistent=true]");
        Block(0, 3, 2, "minecraft:dark_oak_leaves[distance=1,persistent=true]");
        Block(1, 3, 2, "minecraft:dark_oak_log[axis=z]");
        Block(2, 3, 2, "minecraft:dark_oak_leaves[distance=1,persistent=true]");
        Block(3, 3, 2, "minecraft:dark_oak_leaves[distance=2,persistent=true]");
        Block(1, 4, 2, "minecraft:dark_oak_leaves[distance=1,persistent=true]");
        Block(1, 2, 3, "minecraft:dark_oak_leaves[distance=2,persistent=true]");
        Block(-1, 3, 3, "minecraft:dark_oak_leaves[distance=3,persistent=true]");
        Block(0, 3, 3, "minecraft:dark_oak_leaves[distance=2,persistent=true]");
        Block(1, 3, 3, "minecraft:dark_oak_leaves[distance=1,persistent=true]");
        Block(2, 3, 3, "minecraft:dark_oak_leaves[distance=2,persistent=true]");
        Block(0, 3, 4, "minecraft:dark_oak_leaves[distance=3,persistent=true]");
        Block(1, 3, 4, "minecraft:dark_oak_leaves[distance=2,persistent=true]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}