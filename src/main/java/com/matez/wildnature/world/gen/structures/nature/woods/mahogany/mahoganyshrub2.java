package com.matez.wildnature.world.gen.structures.nature.woods.mahogany;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class mahoganyshrub2 extends SchemFeature {
    public mahoganyshrub2() {
        super();

    }


    @Override
    public Set<BlockPos> setBlocks() {

        Block(0, 2, -1, "wildnature:mahogany_leaves[distance=7,persistent=true]");
        Block(1, 2, -1, "wildnature:mahogany_leaves[distance=7,persistent=true]");
        Block(-1, 3, -1, "wildnature:mahogany_leaves[distance=7,persistent=true]");
        Block(0, 3, -1, "wildnature:mahogany_leaves[distance=7,persistent=true]");
        Block(-1, 4, -1, "wildnature:mahogany_leaves[distance=7,persistent=true]");
        Block(1, 4, -1, "wildnature:mahogany_leaves[distance=7,persistent=true]");
        Block(0, 5, -1, "wildnature:mahogany_leaves[distance=7,persistent=true]");
        Block(0, 1, 0, "wildnature:mahogany_branch[down=true,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(-1, 2, 0, "wildnature:mahogany_branch[down=false,east=true,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(0, 2, 0, "wildnature:mahogany_branch[down=true,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(1, 2, 0, "wildnature:mahogany_branch[down=false,east=false,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(-1, 3, 0, "wildnature:mahogany_branch[down=true,east=true,north=true,south=true,up=true,waterlogged=false,west=false]");
        Block(0, 3, 0, "wildnature:mahogany_leaves[distance=7,persistent=true]");
        Block(1, 3, 0, "wildnature:mahogany_leaves[distance=7,persistent=true]");
        Block(-1, 4, 0, "wildnature:mahogany_leaves[distance=7,persistent=true]");
        Block(0, 4, 0, "wildnature:mahogany_branch[down=true,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(1, 4, 0, "wildnature:mahogany_leaves[distance=7,persistent=true]");
        Block(-1, 5, 0, "wildnature:mahogany_leaves[distance=7,persistent=true]");
        Block(1, 5, 0, "wildnature:mahogany_leaves[distance=7,persistent=true]");
        Block(0, 6, 0, "wildnature:mahogany_leaves[distance=7,persistent=true]");
        Block(1, 6, 0, "wildnature:mahogany_branch[down=true,east=false,north=false,south=false,up=false,waterlogged=false,west=true]");
        Block(0, 7, 0, "wildnature:mahogany_leaves[distance=7,persistent=true]");
        Block(0, 2, 1, "wildnature:mahogany_branch[down=false,east=true,north=true,south=false,up=true,waterlogged=false,west=false]");
        Block(1, 2, 1, "wildnature:mahogany_leaves[distance=7,persistent=true]");
        Block(-1, 3, 1, "wildnature:mahogany_leaves[distance=7,persistent=true]");
        Block(0, 3, 1, "wildnature:mahogany_branch[down=true,east=true,north=true,south=false,up=true,waterlogged=false,west=true]");
        Block(1, 3, 1, "wildnature:mahogany_leaves[distance=7,persistent=true]");
        Block(-1, 4, 1, "wildnature:mahogany_branch[down=true,east=true,north=true,south=false,up=false,waterlogged=false,west=false]");
        Block(0, 4, 1, "wildnature:mahogany_leaves[distance=7,persistent=true]");
        Block(0, 5, 1, "wildnature:mahogany_leaves[distance=7,persistent=true]");
        Block(1, 5, 1, "wildnature:mahogany_leaves[distance=7,persistent=true]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}