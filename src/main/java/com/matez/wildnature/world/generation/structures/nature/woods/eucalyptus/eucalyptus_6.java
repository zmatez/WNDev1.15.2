package com.matez.wildnature.world.generation.structures.nature.woods.eucalyptus;

import com.matez.wildnature.world.generation.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class eucalyptus_6 extends SchemFeature {
    public eucalyptus_6() {
        super();

    }


    @Override
    public Set<BlockPos> setBlocks() {

        Block(0, 5, -2, "wildnature:eucalyptus_leaves[distance=7,persistent=true]");
        Block(-1, 6, -2, "wildnature:eucalyptus_leaves[distance=7,persistent=true]");
        Block(0, 6, -2, "wildnature:eucalyptus_leaves[distance=7,persistent=true]");
        Block(1, 6, -2, "wildnature:eucalyptus_leaves[distance=7,persistent=true]");
        Block(0, 7, -2, "wildnature:eucalyptus_leaves[distance=7,persistent=true]");
        Block(-1, 5, -1, "wildnature:eucalyptus_leaves[distance=7,persistent=true]");
        Block(0, 5, -1, "wildnature:eucalyptus_branch[down=false,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(1, 5, -1, "wildnature:eucalyptus_leaves[distance=7,persistent=true]");
        Block(-1, 6, -1, "wildnature:eucalyptus_leaves[distance=7,persistent=true]");
        Block(0, 6, -1, "wildnature:eucalyptus_branch[down=true,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(1, 6, -1, "wildnature:eucalyptus_leaves[distance=7,persistent=true]");
        Block(-1, 7, -1, "wildnature:eucalyptus_leaves[distance=7,persistent=true]");
        Block(0, 7, -1, "wildnature:eucalyptus_leaves[distance=7,persistent=true]");
        Block(1, 7, -1, "wildnature:eucalyptus_leaves[distance=7,persistent=true]");
        Block(0, 1, 0, "wildnature:eucalyptus_log[axis=y]");
        Block(0, 2, 0, "wildnature:eucalyptus_log[axis=y]");
        Block(0, 3, 0, "wildnature:eucalyptus_log[axis=y]");
        Block(0, 4, 0, "wildnature:eucalyptus_branch[down=true,east=true,north=false,south=true,up=true,waterlogged=false,west=false]");
        Block(1, 4, 0, "wildnature:eucalyptus_leaves[distance=7,persistent=true]");
        Block(0, 5, 0, "wildnature:eucalyptus_branch[down=true,east=true,north=true,south=true,up=true,waterlogged=false,west=false]");
        Block(1, 5, 0, "wildnature:eucalyptus_leaves[distance=7,persistent=true]");
        Block(2, 5, 0, "wildnature:eucalyptus_leaves[distance=7,persistent=true]");
        Block(-1, 6, 0, "wildnature:eucalyptus_leaves[distance=7,persistent=true]");
        Block(0, 6, 0, "wildnature:eucalyptus_leaves[distance=7,persistent=true]");
        Block(1, 6, 0, "wildnature:eucalyptus_leaves[distance=7,persistent=true]");
        Block(0, 7, 0, "wildnature:eucalyptus_leaves[distance=7,persistent=true]");
        Block(0, 4, 1, "wildnature:eucalyptus_branch[down=false,east=true,north=true,south=false,up=true,waterlogged=false,west=false]");
        Block(1, 4, 1, "wildnature:eucalyptus_branch[down=false,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(2, 4, 1, "wildnature:eucalyptus_leaves[distance=7,persistent=true]");
        Block(0, 5, 1, "wildnature:eucalyptus_leaves[distance=7,persistent=true]");
        Block(1, 5, 1, "wildnature:eucalyptus_branch[down=true,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(2, 5, 1, "wildnature:eucalyptus_leaves[distance=7,persistent=true]");
        Block(0, 6, 1, "wildnature:eucalyptus_leaves[distance=7,persistent=true]");
        Block(1, 6, 1, "wildnature:eucalyptus_leaves[distance=7,persistent=true]");
        Block(2, 6, 1, "wildnature:eucalyptus_leaves[distance=7,persistent=true]");
        Block(1, 4, 2, "wildnature:eucalyptus_leaves[distance=7,persistent=true]");
        Block(0, 5, 2, "wildnature:eucalyptus_leaves[distance=7,persistent=true]");
        Block(1, 5, 2, "wildnature:eucalyptus_leaves[distance=7,persistent=true]");
        Block(2, 5, 2, "wildnature:eucalyptus_leaves[distance=7,persistent=true]");
        Block(1, 6, 2, "wildnature:eucalyptus_leaves[distance=7,persistent=true]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}