package com.matez.wildnature.world.gen.structures.nature.woods.beech;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class beech6 extends SchemFeature {
    public beech6() {
        super();

        this.terrainIncrease = 1;
    }


    @Override
    public Set<BlockPos> setBlocks() {

        Block(0, 13, -2, "wildnature:beech_leaves[distance=7,persistent=true]");
        Block(0, 12, -1, "wildnature:beech_leaves[distance=7,persistent=true]");
        Block(-1, 13, -1, "wildnature:beech_leaves[distance=7,persistent=true]");
        Block(0, 13, -1, "wildnature:beech_branch[down=true,east=true,north=true,south=true,up=false,waterlogged=false,west=true]");
        Block(1, 13, -1, "wildnature:beech_leaves[distance=7,persistent=true]");
        Block(0, 1, 0, "wildnature:beech_branch[down=true,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(0, 2, 0, "wildnature:beech_branch[down=true,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(0, 3, 0, "wildnature:beech_branch[down=true,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(0, 4, 0, "wildnature:beech_branch[down=true,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(0, 5, 0, "wildnature:beech_branch[down=true,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(0, 6, 0, "wildnature:beech_branch[down=true,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(0, 7, 0, "wildnature:beech_branch[down=true,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(0, 8, 0, "wildnature:beech_branch[down=true,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(0, 9, 0, "wildnature:beech_branch[down=true,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(0, 10, 0, "wildnature:beech_branch[down=true,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(0, 11, 0, "wildnature:beech_branch[down=true,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(-1, 12, 0, "wildnature:beech_branch[down=false,east=true,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(0, 12, 0, "wildnature:beech_branch[down=true,east=false,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(-1, 13, 0, "wildnature:beech_leaves[distance=7,persistent=true]");
        Block(0, 13, 0, "wildnature:beech_branch[down=true,east=true,north=true,south=false,up=true,waterlogged=false,west=true]");
        Block(1, 13, 0, "wildnature:beech_branch[down=false,east=false,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(0, 14, 0, "wildnature:beech_branch[down=true,east=true,north=false,south=true,up=true,waterlogged=false,west=false]");
        Block(1, 14, 0, "wildnature:beech_leaves[distance=7,persistent=true]");
        Block(0, 15, 0, "wildnature:beech_leaves[distance=7,persistent=true]");
        Block(0, 12, 1, "wildnature:beech_leaves[distance=7,persistent=true]");
        Block(1, 13, 1, "wildnature:beech_leaves[distance=7,persistent=true]");
        Block(-1, 14, 1, "wildnature:beech_leaves[distance=7,persistent=true]");
        Block(0, 14, 1, "wildnature:beech_branch[down=false,east=false,north=true,south=true,up=false,waterlogged=false,west=true]");
        Block(0, 14, 2, "wildnature:beech_leaves[distance=7,persistent=true]");
        Block(0, 15, 2, "wildnature:beech_leaves[distance=7,persistent=true]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}