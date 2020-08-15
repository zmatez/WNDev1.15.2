package com.matez.wildnature.world.gen.structures.nature.woods.citrus;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class banana1 extends SchemFeature {

    public banana1() {
        super();

        this.terrainIncrease = 1;
    }


    @Override
    public Set<BlockPos> setBlocks() {

        Block(0, 6, -4, "wildnature:banana_leaves[distance=7,persistent=true]");
        Block(0, 7, -4, "wildnature:banana_leaves[distance=7,persistent=true]");
        Block(0, 7, -3, "wildnature:banana_leaves[distance=6,persistent=true]");
        Block(0, 8, -3, "wildnature:banana_leaves[distance=5,persistent=true]");
        Block(-1, 7, -2, "wildnature:banana_leaves[distance=7,persistent=true]");
        Block(0, 7, -2, "wildnature:palm_branch[down=false,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(1, 7, -2, "wildnature:banana_leaves[distance=7,persistent=true]");
        Block(0, 8, -2, "wildnature:banana_leaves[distance=4,persistent=true]");
        Block(0, 7, -1, "wildnature:banana_leaves[distance=2,persistent=true]");
        Block(2, 7, -1, "wildnature:banana_leaves[distance=7,persistent=true]");
        Block(0, 8, -1, "wildnature:banana_leaves[distance=3,persistent=true]");
        Block(0, 1, 0, "wildnature:palm_log[axis=y]");
        Block(0, 2, 0, "wildnature:palm_log[axis=y]");
        Block(0, 3, 0, "wildnature:palm_log[axis=y]");
        Block(0, 4, 0, "wildnature:palm_log[axis=y]");
        Block(0, 5, 0, "wildnature:palm_log[axis=y]");
        Block(4, 5, 0, "wildnature:banana_leaves[distance=7,persistent=true]");
        Block(0, 6, 0, "wildnature:palm_log[axis=y]");
        Block(2, 6, 0, "wildnature:banana_leaves[distance=7,persistent=true]");
        Block(3, 6, 0, "wildnature:banana_leaves[distance=7,persistent=true]");
        Block(4, 6, 0, "wildnature:banana_leaves[distance=7,persistent=true]");
        Block(-2, 7, 0, "wildnature:banana_leaves[distance=3,persistent=true]");
        Block(-1, 7, 0, "wildnature:banana_leaves[distance=2,persistent=true]");
        Block(0, 7, 0, "wildnature:banana_leaves[distance=1,persistent=true]");
        Block(1, 7, 0, "wildnature:banana_leaves[distance=2,persistent=true]");
        Block(2, 7, 0, "wildnature:palm_branch[down=true,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(3, 7, 0, "wildnature:banana_leaves[distance=7,persistent=true]");
        Block(-1, 8, 0, "wildnature:banana_leaves[distance=3,persistent=true]");
        Block(1, 8, 0, "wildnature:banana_leaves[distance=3,persistent=true]");
        Block(2, 8, 0, "wildnature:banana_leaves[distance=4,persistent=true]");
        Block(-4, 4, 1, "wildnature:banana_leaves[distance=7,persistent=true]");
        Block(-4, 5, 1, "wildnature:banana_leaves[distance=7,persistent=true]");
        Block(-3, 6, 1, "wildnature:banana_leaves[distance=7,persistent=true]");
        Block(0, 6, 1, "wildnature:palm_branch[down=false,east=false,north=true,south=true,up=true,waterlogged=false,west=false]");
        Block(-3, 7, 1, "wildnature:banana_leaves[distance=7,persistent=true]");
        Block(-2, 7, 1, "wildnature:palm_branch[down=false,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(-1, 7, 1, "wildnature:palm_branch[down=false,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(0, 7, 1, "wildnature:banana_leaves[distance=2,persistent=true]");
        Block(1, 7, 1, "wildnature:banana_leaves[distance=3,persistent=true]");
        Block(2, 7, 1, "wildnature:banana_leaves[distance=4,persistent=true]");
        Block(-2, 8, 1, "wildnature:banana_leaves[distance=5,persistent=true]");
        Block(-1, 8, 1, "wildnature:banana_leaves[distance=4,persistent=true]");
        Block(0, 6, 2, "wildnature:banana_leaves[distance=7,persistent=true]");
        Block(-2, 7, 2, "wildnature:banana_leaves[distance=7,persistent=true]");
        Block(-1, 7, 2, "wildnature:banana_leaves[distance=7,persistent=true]");
        Block(0, 5, 3, "wildnature:banana_leaves[distance=7,persistent=true]");
        Block(0, 6, 3, "wildnature:banana_leaves[distance=7,persistent=true]");
        Block(0, 4, 4, "wildnature:banana_leaves[distance=7,persistent=true]");
        Block(0, 5, 4, "wildnature:banana_leaves[distance=7,persistent=true]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}