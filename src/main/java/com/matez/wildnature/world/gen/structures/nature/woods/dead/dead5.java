package com.matez.wildnature.world.gen.structures.nature.woods.dead;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class dead5 extends SchemFeature {
    public dead5() {
        super();

    }


    @Override
    public Set<BlockPos> setBlocks() {

        Block(0, 5, -2, "minecraft:oak_log[axis=y]");
        Block(0, 2, -1, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(0, 4, -1, "minecraft:oak_log[axis=z]");
        Block(0, 5, -1, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(0, 1, 0, "minecraft:oak_log[axis=y]");
        Block(0, 2, 0, "minecraft:oak_log[axis=y]");
        Block(-1, 3, 0, "minecraft:oak_log[axis=x]");
        Block(0, 3, 0, "minecraft:oak_log[axis=y]");
        Block(0, 4, 0, "minecraft:oak_log[axis=y]");
        Block(0, 5, 0, "minecraft:oak_log[axis=y]");
        Block(-1, 6, 0, "minecraft:oak_log[axis=x]");
        Block(0, 6, 0, "minecraft:oak_log[axis=y]");
        Block(1, 4, 1, "minecraft:oak_log[axis=z]");
        Block(2, 4, 1, "minecraft:oak_leaves[distance=1,persistent=true]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}