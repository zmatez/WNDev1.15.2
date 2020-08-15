package com.matez.wildnature.world.gen.structures.nature.woods.spruce;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class spruce4 extends SchemFeature {
    public spruce4() {
        super();

    }


    @Override
    public Set<BlockPos> setBlocks() {

        Block(-1, 3, -1, "minecraft:spruce_leaves[distance=2,persistent=true]");
        Block(0, 3, -1, "minecraft:spruce_leaves[distance=1,persistent=true]");
        Block(1, 3, -1, "minecraft:spruce_leaves[distance=2,persistent=true]");
        Block(-1, 4, -1, "minecraft:spruce_leaves[distance=2,persistent=true]");
        Block(0, 4, -1, "minecraft:spruce_leaves[distance=1,persistent=true]");
        Block(1, 4, -1, "minecraft:spruce_leaves[distance=2,persistent=true]");
        Block(0, 5, -1, "minecraft:spruce_leaves[distance=1,persistent=true]");
        Block(-1, 6, -1, "minecraft:spruce_leaves[distance=2,persistent=true]");
        Block(0, 6, -1, "minecraft:spruce_leaves[distance=1,persistent=true]");
        Block(1, 6, -1, "minecraft:spruce_leaves[distance=2,persistent=true]");
        Block(0, 7, -1, "minecraft:spruce_leaves[distance=1,persistent=true]");
        Block(-1, 1, 0, "minecraft:spruce_log[axis=x]");
        Block(0, 1, 0, "minecraft:spruce_log[axis=y]");
        Block(0, 2, 0, "minecraft:spruce_log[axis=y]");
        Block(-1, 3, 0, "minecraft:spruce_leaves[distance=1,persistent=true]");
        Block(0, 3, 0, "minecraft:spruce_log[axis=y]");
        Block(1, 3, 0, "minecraft:spruce_leaves[distance=1,persistent=true]");
        Block(-2, 4, 0, "minecraft:spruce_leaves[distance=2,persistent=true]");
        Block(-1, 4, 0, "minecraft:spruce_leaves[distance=1,persistent=true]");
        Block(0, 4, 0, "minecraft:spruce_log[axis=y]");
        Block(1, 4, 0, "minecraft:spruce_leaves[distance=1,persistent=true]");
        Block(2, 4, 0, "minecraft:spruce_leaves[distance=2,persistent=true]");
        Block(-1, 5, 0, "minecraft:spruce_leaves[distance=1,persistent=true]");
        Block(0, 5, 0, "minecraft:spruce_log[axis=y]");
        Block(1, 5, 0, "minecraft:spruce_leaves[distance=1,persistent=true]");
        Block(-1, 6, 0, "minecraft:spruce_leaves[distance=1,persistent=true]");
        Block(0, 6, 0, "minecraft:spruce_log[axis=y]");
        Block(1, 6, 0, "minecraft:spruce_leaves[distance=1,persistent=true]");
        Block(-1, 7, 0, "minecraft:spruce_leaves[distance=1,persistent=true]");
        Block(0, 7, 0, "minecraft:spruce_log[axis=y]");
        Block(1, 7, 0, "minecraft:spruce_leaves[distance=1,persistent=true]");
        Block(0, 8, 0, "minecraft:spruce_leaves[distance=1,persistent=true]");
        Block(0, 1, 1, "minecraft:spruce_log[axis=z]");
        Block(-1, 3, 1, "minecraft:spruce_leaves[distance=2,persistent=true]");
        Block(0, 3, 1, "minecraft:spruce_leaves[distance=1,persistent=true]");
        Block(1, 3, 1, "minecraft:spruce_leaves[distance=2,persistent=true]");
        Block(-1, 4, 1, "minecraft:spruce_leaves[distance=2,persistent=true]");
        Block(0, 4, 1, "minecraft:spruce_leaves[distance=1,persistent=true]");
        Block(1, 4, 1, "minecraft:spruce_leaves[distance=2,persistent=true]");
        Block(0, 5, 1, "minecraft:spruce_leaves[distance=1,persistent=true]");
        Block(-1, 6, 1, "minecraft:spruce_leaves[distance=2,persistent=true]");
        Block(0, 6, 1, "minecraft:spruce_leaves[distance=1,persistent=true]");
        Block(1, 6, 1, "minecraft:spruce_leaves[distance=2,persistent=true]");
        Block(0, 7, 1, "minecraft:spruce_leaves[distance=1,persistent=true]");
        Block(0, 4, 2, "minecraft:spruce_leaves[distance=2,persistent=true]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}