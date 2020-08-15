package com.matez.wildnature.world.gen.structures.nature.woods.eucalyptus;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class eucalyptus_shrub5 extends SchemFeature {
    public eucalyptus_shrub5() {
        super();

    }


    @Override
    public Set<BlockPos> setBlocks() {

        Block(0, 1, -2, "wildnature:eucalyptus_leaves[distance=2,persistent=true]");
        Block(1, 1, -2, "wildnature:eucalyptus_leaves[distance=3,persistent=true]");
        Block(-1, 1, -1, "wildnature:eucalyptus_leaves[distance=2,persistent=true]");
        Block(0, 1, -1, "wildnature:eucalyptus_leaves[distance=1,persistent=true]");
        Block(1, 1, -1, "wildnature:eucalyptus_leaves[distance=2,persistent=true]");
        Block(2, 1, -1, "wildnature:eucalyptus_leaves[distance=3,persistent=true]");
        Block(0, 2, -1, "wildnature:eucalyptus_leaves[distance=2,persistent=true]");
        Block(1, 2, -1, "wildnature:eucalyptus_leaves[distance=3,persistent=true]");
        Block(-1, 1, 0, "wildnature:eucalyptus_leaves[distance=1,persistent=true]");
        Block(0, 1, 0, "wildnature:eucalyptus_log[axis=y]");
        Block(1, 1, 0, "wildnature:eucalyptus_leaves[distance=1,persistent=true]");
        Block(0, 2, 0, "wildnature:eucalyptus_leaves[distance=1,persistent=true]");
        Block(1, 2, 0, "wildnature:eucalyptus_leaves[distance=2,persistent=true]");
        Block(-1, 1, 1, "wildnature:eucalyptus_leaves[distance=2,persistent=true]");
        Block(0, 1, 1, "wildnature:eucalyptus_leaves[distance=1,persistent=true]");
        Block(1, 1, 1, "wildnature:eucalyptus_leaves[distance=2,persistent=true]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}