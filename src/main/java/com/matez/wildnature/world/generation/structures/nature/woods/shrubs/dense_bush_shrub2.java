package com.matez.wildnature.world.generation.structures.nature.woods.shrubs;

import com.matez.wildnature.world.generation.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class dense_bush_shrub2 extends SchemFeature {
    public dense_bush_shrub2() {
        super();
    }


    @Override
    public Set<BlockPos> setBlocks() {

        Block(-2, 1, -2, "wildnature:dense_bush_leaves[distance=7,persistent=true]");
        Block(-1, 1, -2, "wildnature:dense_bush_leaves[distance=7,persistent=true]");
        Block(0, 1, -2, "wildnature:dense_bush_leaves[distance=7,persistent=true]");
        Block(1, 1, -2, "wildnature:dense_bush_leaves[distance=7,persistent=true]");
        Block(0, 2, -2, "wildnature:dense_bush_leaves[distance=7,persistent=true]");
        Block(-2, 1, -1, "wildnature:dense_bush_leaves[distance=7,persistent=true]");
        Block(-1, 1, -1, "wildnature:dense_bush_leaves[distance=7,persistent=true]");
        Block(0, 1, -1, "wildnature:dense_bush_leaves[distance=7,persistent=true]");
        Block(1, 1, -1, "wildnature:dense_bush_leaves[distance=7,persistent=true]");
        Block(2, 1, -1, "wildnature:dense_bush_leaves[distance=7,persistent=true]");
        Block(-1, 2, -1, "wildnature:dense_bush_leaves[distance=7,persistent=true]");
        Block(-1, 1, 0, "wildnature:dense_bush_leaves[distance=7,persistent=true]");
        Block(0, 1, 0, "wildnature:dense_bush_leaves[distance=7,persistent=true]");
        Block(2, 1, 0, "wildnature:dense_bush_leaves[distance=7,persistent=true]");
        Block(0, 2, 0, "wildnature:dense_bush_leaves[distance=7,persistent=true]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     https://wildnaturemod.com
        return super.setBlocks();
    }
}