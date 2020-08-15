package com.matez.wildnature.world.gen.structures.nature.woods.fallen;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class fallen_pointy_birch4 extends SchemFeature {
    public fallen_pointy_birch4() {
        super();

        terrainIncrease = 1;
    }


    @Override
    public Set<BlockPos> setBlocks() {

        Block(1, 1, -1, "minecraft:birch_leaves[distance=1,persistent=true]");
        Block(0, 1, 0, "minecraft:birch_log[axis=x]");
        Block(1, 1, 0, "minecraft:birch_log[axis=x]");
        Block(2, 1, 0, "minecraft:birch_log[axis=x]");
        Block(2, 2, 0, "minecraft:birch_leaves[distance=1,persistent=true]");
        Block(-3, 1, 1, "minecraft:birch_log[axis=x]");
        Block(-2, 1, 1, "minecraft:birch_log[axis=x]");
        Block(-1, 1, 1, "minecraft:birch_log[axis=x]");
        Block(1, 1, 1, "minecraft:birch_log[axis=z]");
        Block(1, 2, 1, "minecraft:birch_leaves[distance=1,persistent=true]");
        Block(3, 1, 2, "minecraft:birch_leaves[distance=7,persistent=true]");
        Block(1, 1, 3, "minecraft:birch_leaves[distance=7,persistent=true]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}