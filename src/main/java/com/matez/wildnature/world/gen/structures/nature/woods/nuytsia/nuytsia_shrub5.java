package com.matez.wildnature.world.gen.structures.nature.woods.nuytsia;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;


public class nuytsia_shrub5 extends SchemFeature {
    public nuytsia_shrub5() {
        super();

    }


    @Override
    public Set<BlockPos> setBlocks() {

        Block(0, 3, -2, "wildnature:nuytsia_leaves[distance=7,persistent=true]");
        Block(1, 6, -2, "wildnature:nuytsia_leaves[distance=7,persistent=true]");
        Block(0, 2, -1, "wildnature:nuytsia_leaves[distance=1,persistent=true]");
        Block(-1, 3, -1, "wildnature:nuytsia_leaves[distance=7,persistent=true]");
        Block(0, 3, -1, "wildnature:rosaceae_branch[down=true,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(1, 3, -1, "wildnature:nuytsia_leaves[distance=7,persistent=true]");
        Block(0, 4, -1, "wildnature:nuytsia_leaves[distance=1,persistent=true]");
        Block(1, 5, -1, "wildnature:nuytsia_leaves[distance=7,persistent=true]");
        Block(0, 6, -1, "wildnature:nuytsia_leaves[distance=7,persistent=true]");
        Block(1, 6, -1, "wildnature:rosaceae_branch[down=true,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(2, 6, -1, "wildnature:nuytsia_leaves[distance=7,persistent=true]");
        Block(1, 7, -1, "wildnature:nuytsia_leaves[distance=7,persistent=true]");
        Block(0, 1, 0, "wildnature:rosaceae_log[axis=y]");
        Block(0, 2, 0, "wildnature:rosaceae_log[axis=y]");
        Block(0, 3, 0, "wildnature:rosaceae_log[axis=y]");
        Block(0, 4, 0, "wildnature:rosaceae_log[axis=y]");
        Block(0, 5, 0, "wildnature:rosaceae_branch[down=true,east=true,north=false,south=true,up=true,waterlogged=false,west=false]");
        Block(1, 5, 0, "wildnature:rosaceae_branch[down=false,east=false,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(0, 6, 0, "wildnature:nuytsia_leaves[distance=7,persistent=true]");
        Block(1, 6, 0, "wildnature:rosaceae_branch[down=true,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(2, 6, 0, "wildnature:nuytsia_leaves[distance=7,persistent=true]");
        Block(1, 7, 0, "wildnature:nuytsia_leaves[distance=7,persistent=true]");
        Block(0, 4, 1, "wildnature:nuytsia_leaves[distance=1,persistent=true]");
        Block(-1, 5, 1, "wildnature:nuytsia_leaves[distance=7,persistent=true]");
        Block(0, 5, 1, "wildnature:rosaceae_branch[down=true,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(1, 5, 1, "wildnature:nuytsia_leaves[distance=7,persistent=true]");
        Block(0, 6, 1, "wildnature:nuytsia_leaves[distance=7,persistent=true]");
        Block(1, 6, 1, "wildnature:nuytsia_leaves[distance=7,persistent=true]");
        Block(0, 4, 2, "wildnature:nuytsia_leaves[distance=2,persistent=true]");
        Block(-1, 5, 2, "wildnature:nuytsia_leaves[distance=7,persistent=true]");
        Block(0, 5, 2, "wildnature:rosaceae_branch[down=true,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(1, 5, 2, "wildnature:nuytsia_leaves[distance=7,persistent=true]");
        Block(0, 6, 2, "wildnature:nuytsia_leaves[distance=7,persistent=true]");
        Block(0, 5, 3, "wildnature:nuytsia_leaves[distance=7,persistent=true]");
        Block(0, 5, 4, "wildnature:nuytsia_leaves[distance=7,persistent=true]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}