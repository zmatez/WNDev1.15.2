package com.matez.wildnature.world.gen.structures.nature.woods.oaklands;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class oaklands_shrub1 extends SchemFeature {
    public oaklands_shrub1() {
        super();

    }


    @Override
    public Set<BlockPos> setBlocks() {

        Block(-1, 1, -2, LEAVES);
        Block(1, 1, -2, LEAVES);
        Block(2, 1, -2, LEAVES);
        Block(-1, 2, -2, LEAVES);
        Block(0, 2, -2, LEAVES);
        Block(1, 2, -2, LEAVES);
        Block(0, 3, -2, LEAVES);
        Block(1, 3, -2, LEAVES);
        Block(-3, 1, -1, LEAVES);
        Block(1, 1, -1, LEAVES);
        Block(-2, 2, -1, LEAVES);
        Block(-1, 2, -1, LEAVES);
        Block(0, 2, -1, LEAVES);
        Block(1, 2, -1, LEAVES);
        Block(2, 2, -1, LEAVES);
        Block(-2, 3, -1, LEAVES);
        Block(-1, 3, -1, LEAVES);
        Block(0, 3, -1, LEAVES);
        Block(1, 3, -1, LEAVES);
        Block(2, 3, -1, LEAVES);
        Block(0, 4, -1, LEAVES);
        Block(1, 4, -1, LEAVES);
        Block(-3, 1, 0, LEAVES);
        Block(-2, 1, 0, LEAVES);
        Block(-1, 1, 0, LOG);
        Block(0, 1, 0, LOG);
        Block(2, 1, 0, LEAVES);
        Block(3, 1, 0, LEAVES);
        Block(-2, 2, 0, LEAVES);
        Block(-1, 2, 0, LEAVES);
        Block(0, 2, 0, LOG);
        Block(1, 2, 0, LEAVES);
        Block(2, 2, 0, LEAVES);
        Block(-2, 3, 0, LEAVES);
        Block(-1, 3, 0, LEAVES);
        Block(0, 3, 0, LOG);
        Block(1, 3, 0, LEAVES);
        Block(2, 3, 0, LEAVES);
        Block(-2, 4, 0, LEAVES);
        Block(-1, 4, 0, LEAVES);
        Block(0, 4, 0, LEAVES);
        Block(1, 4, 0, LEAVES);
        Block(-2, 1, 1, LEAVES);
        Block(-1, 1, 1, LEAVES);
        Block(0, 1, 1, LEAVES);
        Block(-2, 2, 1, LEAVES);
        Block(-1, 2, 1, LEAVES);
        Block(0, 2, 1, LEAVES);
        Block(1, 2, 1, LEAVES);
        Block(2, 2, 1, LEAVES);
        Block(-2, 3, 1, LEAVES);
        Block(-1, 3, 1, LEAVES);
        Block(0, 3, 1, LEAVES);
        Block(1, 3, 1, LEAVES);
        Block(2, 3, 1, LEAVES);
        Block(0, 4, 1, LEAVES);
        Block(-1, 1, 2, LEAVES);
        Block(0, 1, 2, LEAVES);
        Block(1, 1, 2, LEAVES);
        Block(-1, 2, 2, LEAVES);
        Block(0, 2, 2, LEAVES);
        Block(1, 2, 2, LEAVES);
        Block(-1, 3, 2, LEAVES);
        Block(0, 3, 2, LEAVES);
        Block(1, 3, 2, LEAVES);
        Block(0, 4, 2, LEAVES);
        Block(-1, 1, 3, LEAVES);
        Block(0, 1, 3, LEAVES);

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}