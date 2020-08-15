package com.matez.wildnature.world.gen.structures.nature.woods.dead;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class dead1 extends SchemFeature {
    public dead1() {
        super();

    }


    @Override
    public Set<BlockPos> setBlocks() {

        Block(0, 4, -1, "minecraft:oak_log[axis=y]");
        Block(1, 4, -1, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(0, 1, 0, "minecraft:oak_log[axis=y]");
        Block(0, 2, 0, "minecraft:oak_log[axis=y]");
        Block(1, 2, 0, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(-1, 3, 0, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(0, 3, 0, "minecraft:oak_log[axis=y]");
        Block(0, 2, 1, "minecraft:oak_log[axis=z]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}