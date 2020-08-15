package com.matez.wildnature.world.gen.structures.nature.woods.boreal;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class tree_bpine1 extends SchemFeature {
    public tree_bpine1() {
        super();

    }


    @Override
    public Set<BlockPos> setBlocks() {


        Block(-1, 5, 0, LEAVES);
        Block(-1, 6, 0, LEAVES);
        Block(-1, 7, 0, LEAVES);
        Block(-1, 12, 0, LEAVES);
        Block(0, 0, 0, DIRT);
        Block(0, 1, 0, LOG);
        Block(0, 2, 0, LOG);
        Block(0, 3, 0, LOG);
        Block(0, 4, 0, LOG);
        Block(0, 5, 0, LOG);
        Block(0, 6, -1, LEAVES);
        Block(0, 6, 0, LOG);
        Block(0, 6, 1, LEAVES);
        Block(0, 7, -1, LEAVES);
        Block(0, 7, 0, LOG);
        Block(0, 7, 1, LEAVES);
        Block(0, 8, -1, LEAVES);
        Block(0, 8, 0, LOG);
        Block(0, 8, 1, LEAVES);
        Block(0, 9, 0, LOG);
        Block(0, 10, 0, LOG);
        Block(0, 10, 1, LEAVES);
        Block(0, 11, 0, LOG);
        Block(0, 12, -1, LEAVES);
        Block(0, 12, 0, LOG);
        Block(0, 12, 1, LEAVES);
        Block(0, 13, 0, LEAVES);
        Block(1, 4, 0, LEAVES);
        Block(1, 5, 0, LEAVES);
        Block(1, 7, 0, LEAVES);
        Block(1, 8, 0, LEAVES);
        Block(1, 12, 0, LEAVES);

//   wildnature mod 2019/07/30 20:55:28
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
//
//     File generated automatically

        return super.setBlocks();
    }
}
