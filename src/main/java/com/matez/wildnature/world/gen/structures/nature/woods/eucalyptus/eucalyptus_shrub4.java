package com.matez.wildnature.world.gen.structures.nature.woods.eucalyptus;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class eucalyptus_shrub4 extends SchemFeature {
    public eucalyptus_shrub4() {
        super();

    }


    @Override
    public Set<BlockPos> setBlocks() {

        Block(1, 1, -3, "wildnature:eucalyptus_leaves[distance=2,persistent=true]");
        Block(2, 1, -3, "wildnature:eucalyptus_leaves[distance=1,persistent=true]");
        Block(3, 1, -3, "wildnature:eucalyptus_leaves[distance=2,persistent=true]");
        Block(2, 2, -3, "wildnature:eucalyptus_leaves[distance=2,persistent=true]");
        Block(1, 1, -2, "wildnature:eucalyptus_leaves[distance=1,persistent=true]");
        Block(2, 1, -2, "wildnature:eucalyptus_log[axis=y]");
        Block(3, 1, -2, "wildnature:eucalyptus_leaves[distance=1,persistent=true]");
        Block(1, 2, -2, "wildnature:eucalyptus_leaves[distance=2,persistent=true]");
        Block(2, 2, -2, "wildnature:eucalyptus_leaves[distance=1,persistent=true]");
        Block(3, 2, -2, "wildnature:eucalyptus_leaves[distance=2,persistent=true]");
        Block(0, 1, -1, "wildnature:eucalyptus_leaves[distance=3,persistent=true]");
        Block(1, 1, -1, "wildnature:eucalyptus_leaves[distance=2,persistent=true]");
        Block(2, 1, -1, "wildnature:eucalyptus_branch[down=false,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(3, 1, -1, "wildnature:eucalyptus_leaves[distance=2,persistent=true]");
        Block(2, 2, -1, "wildnature:eucalyptus_leaves[distance=2,persistent=true]");
        Block(-1, 1, 0, "wildnature:eucalyptus_leaves[distance=2,persistent=true]");
        Block(0, 1, 0, "wildnature:eucalyptus_leaves[distance=3,persistent=true]");
        Block(1, 1, 0, "wildnature:eucalyptus_leaves[distance=3,persistent=true]");
        Block(2, 1, 0, "wildnature:eucalyptus_leaves[distance=4,persistent=true]");
        Block(3, 1, 0, "wildnature:eucalyptus_leaves[distance=3,persistent=true]");
        Block(0, 2, 0, "wildnature:eucalyptus_leaves[distance=4,persistent=true]");
        Block(-2, 1, 1, "wildnature:eucalyptus_leaves[distance=2,persistent=true]");
        Block(-1, 1, 1, "wildnature:eucalyptus_leaves[distance=1,persistent=true]");
        Block(0, 1, 1, "wildnature:eucalyptus_branch[down=false,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(1, 1, 1, "wildnature:eucalyptus_branch[down=false,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(2, 1, 1, "wildnature:eucalyptus_leaves[distance=5,persistent=true]");
        Block(-1, 2, 1, "wildnature:eucalyptus_leaves[distance=2,persistent=true]");
        Block(0, 2, 1, "wildnature:eucalyptus_branch[down=true,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(1, 2, 1, "wildnature:eucalyptus_leaves[distance=7,persistent=true]");
        Block(0, 3, 1, "wildnature:eucalyptus_leaves[distance=7,persistent=true]");
        Block(-2, 1, 2, "wildnature:eucalyptus_leaves[distance=1,persistent=true]");
        Block(-1, 1, 2, "wildnature:eucalyptus_log[axis=y]");
        Block(0, 1, 2, "wildnature:eucalyptus_branch[down=false,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(1, 1, 2, "wildnature:eucalyptus_leaves[distance=7,persistent=true]");
        Block(-1, 2, 2, "wildnature:eucalyptus_leaves[distance=1,persistent=true]");
        Block(0, 2, 2, "wildnature:eucalyptus_leaves[distance=2,persistent=true]");
        Block(-2, 1, 3, "wildnature:eucalyptus_leaves[distance=2,persistent=true]");
        Block(-1, 1, 3, "wildnature:eucalyptus_leaves[distance=1,persistent=true]");
        Block(0, 1, 3, "wildnature:eucalyptus_leaves[distance=2,persistent=true]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}