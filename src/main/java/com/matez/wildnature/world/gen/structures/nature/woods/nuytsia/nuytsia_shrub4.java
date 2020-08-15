package com.matez.wildnature.world.gen.structures.nature.woods.nuytsia;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;


public class nuytsia_shrub4 extends SchemFeature {
    public nuytsia_shrub4() {
        super();

    }


    @Override
    public Set<BlockPos> setBlocks() {

        Block(0, 1, -1, "wildnature:nuytsia_leaves[distance=1,persistent=true]");
        Block(1, 1, -1, "wildnature:nuytsia_leaves[distance=2,persistent=true]");
        Block(-1, 1, 0, "wildnature:nuytsia_leaves[distance=1,persistent=true]");
        Block(0, 1, 0, "wildnature:rosaceae_log[axis=y]");
        Block(1, 1, 0, "wildnature:rosaceae_branch[down=false,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(2, 1, 0, "wildnature:nuytsia_leaves[distance=7,persistent=true]");
        Block(3, 1, 0, "wildnature:nuytsia_leaves[distance=7,persistent=true]");
        Block(0, 2, 0, "wildnature:nuytsia_leaves[distance=1,persistent=true]");
        Block(1, 2, 0, "wildnature:nuytsia_leaves[distance=2,persistent=true]");
        Block(0, 1, 1, "wildnature:nuytsia_leaves[distance=1,persistent=true]");
        Block(1, 1, 1, "wildnature:nuytsia_leaves[distance=2,persistent=true]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}