package com.matez.wildnature.world.generation.structures.nature.woods.fallen;

import com.matez.wildnature.world.generation.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class fallen_ebony2 extends SchemFeature {
    public fallen_ebony2() {
        super();

        terrainIncrease = 1;
    }


    @Override
    public Set<BlockPos> setBlocks() {

        Block(1, 1, -2, "wildnature:ebony_leaves[distance=1,persistent=true]");
        Block(2, 1, -2, "wildnature:ebony_log[axis=x]");
        Block(3, 1, -2, "wildnature:ebony_leaves[distance=1,persistent=true]");
        Block(-2, 1, -1, "wildnature:ebony_log[axis=z]");
        Block(1, 1, -1, "wildnature:ebony_log[axis=z]");
        Block(1, 2, -1, "wildnature:ebony_leaves[distance=1,persistent=true]");
        Block(-2, 1, 0, "wildnature:ebony_log[axis=x]");
        Block(-1, 1, 0, "wildnature:ebony_log[axis=x]");
        Block(0, 1, 0, "wildnature:ebony_log[axis=x]");
        Block(1, 1, 0, "wildnature:ebony_log[axis=x]");
        Block(2, 1, 0, "wildnature:ebony_leaves[distance=1,persistent=true]");
        Block(-2, 1, 1, "wildnature:ebony_log[axis=z]");
        Block(1, 1, 1, "wildnature:ebony_log[axis=z]");
        Block(3, 1, 1, "wildnature:ebony_log[axis=x]");
        Block(-2, 2, 1, "wildnature:ebony_log[axis=y]");
        Block(1, 2, 1, "wildnature:ebony_leaves[distance=1,persistent=true]");
        Block(3, 1, 2, "wildnature:ebony_leaves[distance=1,persistent=true]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}