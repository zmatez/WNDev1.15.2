package com.matez.wildnature.world.gen.structures.nature.woods.willow;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class pointy_willow_1 extends SchemFeature {
    public pointy_willow_1() {
        super();

    }


    @Override
    public Set<BlockPos> setBlocks() {

        Block(-1, 6, -2, "wildnature:willow_leaves[distance=2,persistent=true]");
        Block(0, 6, -2, "wildnature:willow_leaves[distance=1,persistent=true]");
        Block(0, 7, -2, "wildnature:willow_branch[down=true,east=false,north=false,south=true,up=true,waterlogged=false,west=false]");
        Block(0, 8, -2, "wildnature:willow_leaves[distance=1,persistent=true]");
        Block(0, 0, -1, "wildnature:willow_log[axis=y]");
        Block(0, 1, -1, "wildnature:willow_log[axis=y]");
        Block(0, 2, -1, "wildnature:willow_log[axis=y]");
        Block(0, 3, -1, "wildnature:willow_log[axis=y]");
        Block(1, 4, -1, "wildnature:willow_branch[down=false,east=false,north=false,south=true,up=true,waterlogged=false,west=false]");
        Block(1, 5, -1, "wildnature:willow_branch[down=true,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(-2, 6, -1, "wildnature:willow_leaves[distance=4,persistent=true]");
        Block(0, 6, -1, "wildnature:willow_log[axis=y]");
        Block(1, 6, -1, "wildnature:willow_leaves[distance=1,persistent=true]");
        Block(-2, 7, -1, "wildnature:willow_leaves[distance=3,persistent=true]");
        Block(0, 7, -1, "wildnature:willow_log[axis=y]");
        Block(-2, 8, -1, "wildnature:willow_leaves[distance=2,persistent=true]");
        Block(-1, 8, -1, "wildnature:willow_leaves[distance=1,persistent=true]");
        Block(0, 8, -1, "wildnature:willow_log[axis=y]");
        Block(1, 8, -1, "wildnature:willow_leaves[distance=1,persistent=true]");
        Block(0, 9, -1, "wildnature:willow_leaves[distance=1,persistent=true]");
        Block(-1, 1, 0, "wildnature:willow_log[axis=y]");
        Block(0, 1, 0, "wildnature:willow_log[axis=y]");
        Block(0, 2, 0, "wildnature:willow_log[axis=y]");
        Block(-1, 3, 0, "wildnature:willow_leaves[distance=1,persistent=true]");
        Block(0, 3, 0, "wildnature:willow_log[axis=y]");
        Block(0, 4, 0, "wildnature:willow_log[axis=y]");
        Block(1, 4, 0, "wildnature:willow_branch[down=false,east=false,north=true,south=false,up=false,waterlogged=false,west=true]");
        Block(-2, 5, 0, "wildnature:willow_branch[down=false,east=true,north=false,south=true,up=true,waterlogged=false,west=false]");
        Block(-1, 5, 0, "wildnature:willow_branch[down=false,east=true,north=false,south=true,up=false,waterlogged=false,west=true]");
        Block(0, 5, 0, "wildnature:willow_log[axis=y]");
        Block(-3, 6, 0, "wildnature:willow_leaves[distance=7,persistent=true]");
        Block(-2, 6, 0, "wildnature:willow_branch[down=true,east=false,north=true,south=false,up=true,waterlogged=false,west=true]");
        Block(0, 6, 0, "wildnature:willow_leaves[distance=1,persistent=true]");
        Block(-2, 7, 0, "wildnature:willow_branch[down=true,east=false,north=true,south=false,up=false,waterlogged=false,west=false]");
        Block(0, 8, 0, "wildnature:willow_leaves[distance=1,persistent=true]");
        Block(-1, 3, 1, "wildnature:willow_leaves[distance=2,persistent=true]");
        Block(0, 3, 1, "wildnature:willow_branch[down=false,east=false,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(0, 4, 1, "wildnature:willow_leaves[distance=1,persistent=true]");
        Block(-2, 5, 1, "wildnature:willow_leaves[distance=3,persistent=true]");
        Block(-1, 5, 1, "wildnature:willow_leaves[distance=2,persistent=true]");
        Block(0, 5, 1, "wildnature:willow_leaves[distance=1,persistent=true]");
        Block(0, 6, 1, "wildnature:willow_leaves[distance=2,persistent=true]");
        Block(0, 3, 2, "wildnature:willow_branch[down=false,east=true,north=true,south=false,up=false,waterlogged=false,west=false]");
        Block(1, 3, 2, "wildnature:willow_branch[down=false,east=false,north=false,south=true,up=true,waterlogged=false,west=true]");
        Block(1, 4, 2, "wildnature:willow_branch[down=true,east=false,north=false,south=true,up=false,waterlogged=false,west=false]");
        Block(1, 3, 3, "wildnature:willow_leaves[distance=7,persistent=true]");
        Block(1, 4, 3, "wildnature:willow_leaves[distance=7,persistent=true]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}