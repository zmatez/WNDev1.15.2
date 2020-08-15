package com.matez.wildnature.world.gen.structures.nature.woods.citrus;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class citrus1 extends SchemFeature {
    public citrus1() {
        super();

    }


    @Override
    public Set<BlockPos> setBlocks() {

        Block(0, 2, -2, LEAVES);
        Block(0, 2, -1, "wildnature:citrus_log[axis=z]");
        Block(1, 2, -1, LEAVES);
        Block(-1, 3, -1, LEAVES);
        Block(0, 3, -1, LEAVES);
        Block(0, 1, 0, "wildnature:citrus_log[axis=y]");
        Block(0, 2, 0, "wildnature:citrus_log[axis=y]");
        Block(-1, 3, 0, LEAVES);
        Block(0, 3, 0, "wildnature:citrus_log[axis=y]");
        Block(1, 3, 0, LEAVES);
        Block(0, 4, 0, LEAVES);
        Block(1, 4, 0, LEAVES);
        Block(1, 2, 1, LEAVES);
        Block(-1, 3, 1, LEAVES);
        Block(0, 3, 1, LEAVES);

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}