package com.matez.wildnature.world.gen.structures.nature.woods.ebony;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class ebony_shrub2 extends SchemFeature {
    public ebony_shrub2() {
        super();

    }


    @Override
    public Set<BlockPos> setBlocks() {

        Block(1, 2, -2, "wildnature:ebony_leaves[distance=7,persistent=true]");
        Block(0, 3, -2, "wildnature:ebony_leaves[distance=7,persistent=true]");
        Block(-1, 2, -1, "wildnature:ebony_leaves[distance=7,persistent=true]");
        Block(0, 2, -1, "wildnature:ebony_branch[down=false,east=true,north=false,south=true,up=true,waterlogged=false,west=true]");
        Block(1, 2, -1, "wildnature:ebony_leaves[distance=7,persistent=true]");
        Block(0, 3, -1, "wildnature:ebony_branch[down=true,east=false,north=true,south=true,up=true,waterlogged=false,west=false]");
        Block(0, 4, -1, "wildnature:ebony_leaves[distance=7,persistent=true]");
        Block(0, 1, 0, "wildnature:ebony_branch[down=true,east=true,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(1, 1, 0, "wildnature:ebony_branch[down=false,east=false,north=false,south=false,up=true,waterlogged=false,west=true]");
        Block(-2, 2, 0, "wildnature:ebony_leaves[distance=7,persistent=true]");
        Block(-1, 2, 0, "wildnature:ebony_branch[down=false,east=true,north=true,south=false,up=true,waterlogged=false,west=true]");
        Block(0, 2, 0, "wildnature:ebony_branch[down=true,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(1, 2, 0, "wildnature:ebony_leaves[distance=7,persistent=true]");
        Block(2, 2, 0, "wildnature:ebony_leaves[distance=7,persistent=true]");
        Block(-1, 3, 0, "wildnature:ebony_branch[down=true,east=true,north=false,south=true,up=true,waterlogged=false,west=false]");
        Block(0, 3, 0, "wildnature:ebony_leaves[distance=7,persistent=true]");
        Block(1, 3, 0, "wildnature:ebony_leaves[distance=7,persistent=true]");
        Block(-2, 4, 0, "wildnature:ebony_leaves[distance=7,persistent=true]");
        Block(-1, 4, 0, "wildnature:ebony_branch[down=true,east=true,north=false,south=false,up=true,waterlogged=false,west=true]");
        Block(0, 4, 0, "wildnature:ebony_leaves[distance=7,persistent=true]");
        Block(-1, 5, 0, "wildnature:ebony_leaves[distance=7,persistent=true]");
        Block(0, 2, 1, "wildnature:ebony_branch[down=false,east=false,north=true,south=true,up=false,waterlogged=false,west=false]");
        Block(-1, 3, 1, "wildnature:ebony_leaves[distance=7,persistent=true]");
        Block(1, 3, 1, "wildnature:ebony_leaves[distance=7,persistent=true]");
        Block(0, 1, 2, "wildnature:ebony_branch[down=false,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(-1, 2, 2, "wildnature:ebony_leaves[distance=7,persistent=true]");
        Block(0, 2, 2, "wildnature:ebony_branch[down=true,east=true,north=true,south=false,up=true,waterlogged=false,west=true]");
        Block(1, 2, 2, "wildnature:ebony_leaves[distance=7,persistent=true]");
        Block(2, 2, 2, "wildnature:ebony_leaves[distance=7,persistent=true]");
        Block(0, 3, 2, "wildnature:ebony_branch[down=true,east=false,north=false,south=true,up=true,waterlogged=false,west=false]");
        Block(0, 4, 2, "wildnature:ebony_leaves[distance=7,persistent=true]");
        Block(1, 2, 3, "wildnature:ebony_leaves[distance=7,persistent=true]");
        Block(0, 3, 3, "wildnature:ebony_leaves[distance=7,persistent=true]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}