package com.matez.wildnature.world.generation.structures.nature.fallen.dead;

import com.matez.wildnature.world.generation.structures.nature.fallen.FallenSchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class fallen_dead1 extends FallenSchemFeature {

    @Override
    public Set<BlockPos> setBlocks() {

        Block(0, 0, -2, "minecraft:oak_log[axis=y]");
        Block(0, 1, -1, "minecraft:oak_log[axis=z]");
        Block(-2, 1, 0, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(-1, 1, 0, "minecraft:oak_log[axis=x]");
        Block(0, 1, 0, "minecraft:oak_log[axis=z]");
        Block(1, 1, 0, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(0, 1, 1, "minecraft:oak_log[axis=z]");
        Block(1, 1, 1, "minecraft:oak_log[axis=x]");
        Block(0, 2, 1, "minecraft:oak_leaves[distance=1,persistent=true]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     https://wildnaturemod.com
        return super.setBlocks();
    }
}