package com.matez.wildnature.world.gen.structures.nature.woods.shrubs;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class large_bush_shrub3 extends SchemFeature {
    public large_bush_shrub3() {
        super();
    }

    @Override
    public Set<BlockPos> setBlocks() {

        Block(-1, 3, -3, "wildnature:large_bush_leaves[distance=7,persistent=true]");
        Block(-1, 1, -2, "wildnature:large_bush_leaves[distance=7,persistent=true]");
        Block(0, 1, -2, "wildnature:large_bush_leaves[distance=7,persistent=true]");
        Block(1, 1, -2, "wildnature:large_bush_leaves[distance=7,persistent=true]");
        Block(-1, 2, -2, "wildnature:large_bush_leaves[distance=7,persistent=true]");
        Block(0, 2, -2, "wildnature:large_bush_leaves[distance=7,persistent=true]");
        Block(-1, 3, -2, "wildnature:large_bush_leaves[distance=7,persistent=true]");
        Block(-2, 1, -1, "wildnature:large_bush_leaves[distance=7,persistent=true]");
        Block(-1, 1, -1, "wildnature:large_bush_leaves[distance=7,persistent=true]");
        Block(0, 1, -1, "wildnature:large_bush_leaves[distance=7,persistent=true]");
        Block(1, 1, -1, "wildnature:large_bush_leaves[distance=7,persistent=true]");
        Block(2, 1, -1, "wildnature:large_bush_leaves[distance=7,persistent=true]");
        Block(-1, 2, -1, "wildnature:large_bush_leaves[distance=7,persistent=true]");
        Block(-1, 1, 0, "wildnature:large_bush_leaves[distance=7,persistent=true]");
        Block(0, 1, 0, "wildnature:large_bush_leaves[distance=7,persistent=true]");
        Block(1, 1, 0, "wildnature:large_bush_leaves[distance=7,persistent=true]");
        Block(2, 1, 0, "wildnature:large_bush_leaves[distance=7,persistent=true]");
        Block(-1, 2, 0, "wildnature:large_bush_leaves[distance=7,persistent=true]");
        Block(0, 2, 0, "wildnature:large_bush_leaves[distance=7,persistent=true]");
        Block(1, 2, 0, "wildnature:large_bush_leaves[distance=7,persistent=true]");
        Block(0, 3, 0, "wildnature:large_bush_leaves[distance=7,persistent=true]");
        Block(1, 3, 0, "wildnature:large_bush_leaves[distance=7,persistent=true]");
        Block(1, 1, 1, "wildnature:large_bush_leaves[distance=7,persistent=true]");
        Block(1, 3, 1, "wildnature:large_bush_leaves[distance=7,persistent=true]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     https://wildnaturemod.com
        return super.setBlocks();
    }
}