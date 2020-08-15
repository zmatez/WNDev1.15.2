package com.matez.wildnature.world.gen.structures.nature.woods.spooky;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class spooky15 extends SchemFeature {
    public spooky15() {
        super();

    }


    @Override
    public Set<BlockPos> setBlocks() {

        Block(0, 1, -2, "minecraft:dark_oak_leaves[distance=2,persistent=true]");
        Block(0, 2, -2, "minecraft:cobweb");
        Block(-1, 1, -1, "minecraft:dark_oak_leaves[distance=2,persistent=true]");
        Block(0, 1, -1, "minecraft:dark_oak_leaves[distance=1,persistent=true]");
        Block(1, 1, -1, "minecraft:dark_oak_leaves[distance=2,persistent=true]");
        Block(-1, 2, -1, "wildnature:lightning_bug[facing=north]");
        Block(0, 2, -1, "minecraft:dark_oak_leaves[distance=2,persistent=true]");
        Block(-2, 1, 0, "minecraft:dark_oak_leaves[distance=2,persistent=true]");
        Block(-1, 1, 0, "minecraft:dark_oak_leaves[distance=1,persistent=true]");
        Block(0, 1, 0, "minecraft:dark_oak_log[axis=y]");
        Block(1, 1, 0, "minecraft:dark_oak_leaves[distance=1,persistent=true]");
        Block(-1, 2, 0, "minecraft:dark_oak_leaves[distance=2,persistent=true]");
        Block(0, 2, 0, "minecraft:dark_oak_leaves[distance=1,persistent=true]");
        Block(0, 1, 1, "minecraft:dark_oak_leaves[distance=1,persistent=true]");
        Block(1, 1, 1, "minecraft:dark_oak_leaves[distance=2,persistent=true]");
        Block(1, 2, 1, "minecraft:cobweb");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}