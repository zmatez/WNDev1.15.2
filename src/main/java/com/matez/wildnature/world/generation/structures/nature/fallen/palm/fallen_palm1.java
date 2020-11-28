package com.matez.wildnature.world.generation.structures.nature.fallen.palm;

import com.matez.wildnature.world.generation.structures.nature.fallen.FallenSchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class fallen_palm1 extends FallenSchemFeature {


    @Override
    public Set<BlockPos> setBlocks() {

        Block(1, 0, -9, "wildnature:palm_log[axis=y]");
        Block(1, 1, -8, "wildnature:palm_log[axis=z]");
        Block(1, 1, -7, "wildnature:palm_log[axis=z]");
        Block(1, 1, -6, "wildnature:palm_log[axis=z]");
        Block(1, 1, -5, "wildnature:palm_log[axis=z]");
        Block(1, 1, -4, "wildnature:palm_log[axis=z]");
        Block(0, 1, -3, "wildnature:palm_log[axis=z]");
        Block(0, 1, -2, "wildnature:palm_log[axis=z]");
        Block(0, 1, -1, "wildnature:palm_log[axis=z]");
        Block(-4, 1, 0, "wildnature:palm_leaves[distance=6,persistent=true]");
        Block(-3, 1, 0, "wildnature:palm_leaves[distance=5,persistent=true]");
        Block(-2, 1, 0, "wildnature:palm_leaves[distance=4,persistent=true]");
        Block(0, 1, 0, "wildnature:palm_log[axis=z]");
        Block(1, 1, 0, "wildnature:palm_leaves[distance=1,persistent=true]");
        Block(3, 1, 0, "wildnature:palm_leaves[distance=5,persistent=true]");
        Block(4, 1, 0, "wildnature:palm_leaves[distance=6,persistent=true]");
        Block(-3, 1, 1, "wildnature:palm_leaves[distance=4,persistent=true]");
        Block(-2, 1, 1, "wildnature:palm_leaves[distance=3,persistent=true]");
        Block(-1, 1, 1, "wildnature:palm_leaves[distance=2,persistent=true]");
        Block(0, 1, 1, "wildnature:palm_leaves[distance=1,persistent=true]");
        Block(1, 1, 1, "wildnature:palm_leaves[distance=2,persistent=true]");
        Block(2, 1, 1, "wildnature:palm_leaves[distance=3,persistent=true]");
        Block(3, 1, 1, "wildnature:palm_leaves[distance=4,persistent=true]");
        Block(-2, 2, 1, "wildnature:palm_leaves[distance=4,persistent=true]");
        Block(-1, 2, 1, "wildnature:palm_leaves[distance=3,persistent=true]");
        Block(1, 2, 1, "wildnature:palm_leaves[distance=3,persistent=true]");
        Block(2, 2, 1, "wildnature:palm_leaves[distance=4,persistent=true]");
        Block(-2, 1, 2, "wildnature:palm_leaves[distance=4,persistent=true]");
        Block(-1, 1, 2, "wildnature:palm_leaves[distance=3,persistent=true]");
        Block(0, 1, 2, "wildnature:palm_leaves[distance=2,persistent=true]");
        Block(1, 1, 2, "wildnature:palm_leaves[distance=3,persistent=true]");
        Block(2, 1, 2, "wildnature:palm_leaves[distance=4,persistent=true]");
        Block(-1, 2, 2, "wildnature:palm_leaves[distance=4,persistent=true]");
        Block(0, 2, 2, "wildnature:palm_leaves[distance=3,persistent=true]");
        Block(-3, 1, 3, "wildnature:palm_leaves[distance=6,persistent=true]");
        Block(-2, 1, 3, "wildnature:palm_leaves[distance=5,persistent=true]");
        Block(0, 1, 3, "wildnature:palm_leaves[distance=3,persistent=true]");
        Block(2, 1, 3, "wildnature:palm_leaves[distance=5,persistent=true]");
        Block(3, 1, 3, "wildnature:palm_leaves[distance=6,persistent=true]");
        Block(-4, 1, 4, "wildnature:palm_leaves[distance=7,persistent=true]");
        Block(-3, 1, 4, "wildnature:palm_leaves[distance=7,persistent=true]");
        Block(-1, 1, 4, "wildnature:palm_leaves[distance=7,persistent=true]");
        Block(3, 1, 4, "wildnature:palm_leaves[distance=7,persistent=true]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     https://wildnaturemod.com
        return super.setBlocks();
    }
}