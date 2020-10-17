package com.matez.wildnature.world.gen.structures.nature.woods.oaklands;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class oaklands_oak3 extends SchemFeature {
    public oaklands_oak3() {
        super();

    }


    @Override
    public Set<BlockPos> setBlocks() {

        Block(-1, 1, -1, LOG);
        Block(0, 5, -1, LEAVES);
        Block(-1, 6, -1, LEAVES);
        Block(0, 6, -1, LEAVES);
        Block(1, 6, -1, LEAVES);
        Block(-1, 7, -1, LEAVES);
        Block(0, 7, -1, LEAVES);
        Block(1, 7, -1, LEAVES);
        Block(0, 8, -1, LEAVES);
        Block(-1, 1, 0, LOG);
        Block(0, 1, 0, LOG);
        Block(1, 1, 0, LOG);
        Block(-1, 2, 0, LOG);
        Block(0, 2, 0, LOG);
        Block(-1, 3, 0, LOG);
        Block(0, 3, 0, LOG);
        Block(0, 4, 0, LOG);
        Block(-1, 5, 0, LEAVES);
        Block(0, 5, 0, LOG);
        Block(1, 5, 0, LEAVES);
        Block(-1, 6, 0, LEAVES);
        Block(0, 6, 0, LOG);
        Block(1, 6, 0, LEAVES);
        Block(-1, 7, 0, LEAVES);
        Block(0, 7, 0, LOG);
        Block(1, 7, 0, LEAVES);
        Block(-1, 8, 0, LEAVES);
        Block(0, 8, 0, LOG);
        Block(1, 8, 0, LEAVES);
        Block(0, 9, 0, LEAVES);
        Block(0, 10, 0, LEAVES);
        Block(0, 1, 1, LOG);
        Block(0, 2, 1, LOG);
        Block(0, 5, 1, LEAVES);
        Block(-1, 6, 1, LEAVES);
        Block(0, 6, 1, LEAVES);
        Block(1, 6, 1, LEAVES);
        Block(-1, 7, 1, LEAVES);
        Block(0, 7, 1, LEAVES);
        Block(1, 7, 1, LEAVES);
        Block(0, 8, 1, LEAVES);
        Block(0, 1, 2, LOG);

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}