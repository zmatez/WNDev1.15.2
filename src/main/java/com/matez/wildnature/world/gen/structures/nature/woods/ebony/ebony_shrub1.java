package com.matez.wildnature.world.gen.structures.nature.woods.ebony;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class ebony_shrub1 extends SchemFeature {
    public ebony_shrub1() {
        super();

    }


    @Override
    public Set<BlockPos> setBlocks() {

        Block(1, 1, -2, "wildnature:ebony_leaves[distance=7,persistent=true]");
        Block(-1, 1, -1, "wildnature:ebony_leaves[distance=7,persistent=true]");
        Block(0, 2, -1, "wildnature:ebony_leaves[distance=7,persistent=true]");
        Block(0, 3, -1, "wildnature:ebony_leaves[distance=7,persistent=true]");
        Block(-1, 1, 0, "wildnature:ebony_leaves[distance=7,persistent=true]");
        Block(0, 1, 0, "wildnature:ebony_branch[down=true,east=true,north=false,south=false,up=true,waterlogged=false,west=true]");
        Block(1, 1, 0, "wildnature:ebony_leaves[distance=7,persistent=true]");
        Block(-2, 2, 0, "wildnature:ebony_leaves[distance=7,persistent=true]");
        Block(-1, 2, 0, "wildnature:ebony_leaves[distance=7,persistent=true]");
        Block(0, 2, 0, "wildnature:ebony_branch[down=true,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(1, 2, 0, "wildnature:ebony_leaves[distance=7,persistent=true]");
        Block(-1, 3, 0, "wildnature:ebony_leaves[distance=7,persistent=true]");
        Block(0, 3, 0, "wildnature:ebony_leaves[distance=7,persistent=true]");
        Block(-1, 1, 1, "wildnature:ebony_leaves[distance=7,persistent=true]");
        Block(1, 1, 1, "wildnature:ebony_leaves[distance=7,persistent=true]");
        Block(0, 2, 1, "wildnature:ebony_leaves[distance=7,persistent=true]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}