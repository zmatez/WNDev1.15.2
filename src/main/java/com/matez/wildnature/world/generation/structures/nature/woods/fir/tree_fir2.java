package com.matez.wildnature.world.generation.structures.nature.woods.fir;

import com.matez.wildnature.world.generation.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class tree_fir2 extends SchemFeature {
    public tree_fir2() {
        super();

    }


    @Override
    public Set<BlockPos> setBlocks() {


        Block(-1, 3, 0, LEAVES);
        Block(-1, 4, -1, LEAVES);
        Block(-1, 4, 0, LEAVES);
        Block(-1, 4, 1, LEAVES);
        Block(-1, 5, -1, LEAVES);
        Block(-1, 5, 0, LOG);
        Block(-1, 5, 1, LEAVES);
        Block(-1, 6, 0, LEAVES);
        Block(0, 1, 0, LOG);
        Block(0, 2, 0, LOG);
        Block(0, 3, -1, LOG);
        Block(0, 3, 0, LOG);
        Block(0, 3, 1, LEAVES);
        Block(0, 4, -2, LEAVES);
        Block(0, 4, -1, LEAVES);
        Block(0, 4, 0, LOG);
        Block(0, 4, 1, LOG);
        Block(0, 4, 2, LEAVES);
        Block(0, 5, -1, LEAVES);
        Block(0, 5, 0, LOG);
        Block(0, 5, 1, LEAVES);
        Block(0, 6, -1, LEAVES);
        Block(0, 6, 0, LOG);
        Block(0, 6, 1, LEAVES);
        Block(0, 7, 0, LOG);
        Block(0, 7, 1, LEAVES);
        Block(0, 8, 0, LEAVES);
        Block(0, 9, 0, LEAVES);
        Block(1, 3, 0, LEAVES);
        Block(1, 4, -1, LEAVES);
        Block(1, 4, 0, LEAVES);
        Block(1, 5, 0, LEAVES);
        Block(1, 5, 1, LEAVES);
        Block(1, 6, 0, LEAVES);
        Block(1, 7, 0, LEAVES);

//   wildnature mod 2019/07/30 20:54:46
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
//
//     File generated automatically

        return super.setBlocks();
    }
}
