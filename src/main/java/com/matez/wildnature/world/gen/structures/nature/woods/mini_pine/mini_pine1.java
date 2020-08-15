package com.matez.wildnature.world.gen.structures.nature.woods.mini_pine;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;


public class mini_pine1 extends SchemFeature {
    public mini_pine1() {
        super();

    }


    @Override
    public Set<BlockPos> setBlocks() {

        Block(0, 2, -2, "wildnature:pine_leaves[distance=2,persistent=true,stage=0]");
        Block(-1, 2, -1, "wildnature:pine_leaves[distance=2,persistent=true,stage=0]");
        Block(0, 2, -1, "wildnature:pine_leaves[distance=1,persistent=true,stage=0]");
        Block(1, 2, -1, "wildnature:pine_leaves[distance=2,persistent=true,stage=0]");
        Block(-1, 3, -1, "wildnature:pine_leaves[distance=2,persistent=true,stage=0]");
        Block(0, 3, -1, "wildnature:pine_leaves[distance=1,persistent=true,stage=0]");
        Block(1, 3, -1, "wildnature:pine_leaves[distance=2,persistent=true,stage=0]");
        Block(0, 4, -1, "wildnature:pine_leaves[distance=1,persistent=true,stage=0]");
        Block(0, 1, 0, "minecraft:spruce_log[axis=y]");
        Block(-2, 2, 0, "wildnature:pine_leaves[distance=2,persistent=true,stage=0]");
        Block(-1, 2, 0, "wildnature:pine_leaves[distance=1,persistent=true,stage=0]");
        Block(0, 2, 0, "minecraft:spruce_log[axis=y]");
        Block(1, 2, 0, "wildnature:pine_leaves[distance=1,persistent=true,stage=0]");
        Block(2, 2, 0, "wildnature:pine_leaves[distance=2,persistent=true,stage=0]");
        Block(-1, 3, 0, "wildnature:pine_leaves[distance=1,persistent=true,stage=0]");
        Block(0, 3, 0, "minecraft:spruce_log[axis=y]");
        Block(1, 3, 0, "wildnature:pine_leaves[distance=1,persistent=true,stage=0]");
        Block(-1, 4, 0, "wildnature:pine_leaves[distance=1,persistent=true,stage=0]");
        Block(0, 4, 0, "minecraft:spruce_log[axis=y]");
        Block(1, 4, 0, "wildnature:pine_leaves[distance=1,persistent=true,stage=0]");
        Block(0, 5, 0, "wildnature:pine_leaves[distance=1,persistent=true,stage=0]");
        Block(0, 6, 0, "wildnature:pine_leaves[distance=2,persistent=true,stage=0]");
        Block(-1, 2, 1, "wildnature:pine_leaves[distance=2,persistent=true,stage=0]");
        Block(0, 2, 1, "wildnature:pine_leaves[distance=1,persistent=true,stage=0]");
        Block(1, 2, 1, "wildnature:pine_leaves[distance=2,persistent=true,stage=0]");
        Block(-1, 3, 1, "wildnature:pine_leaves[distance=2,persistent=true,stage=0]");
        Block(0, 3, 1, "wildnature:pine_leaves[distance=1,persistent=true,stage=0]");
        Block(1, 3, 1, "wildnature:pine_leaves[distance=2,persistent=true,stage=0]");
        Block(0, 4, 1, "wildnature:pine_leaves[distance=1,persistent=true,stage=0]");
        Block(0, 2, 2, "wildnature:pine_leaves[distance=2,persistent=true,stage=0]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}