package com.matez.wildnature.world.generation.structures.nature.fallen.palm;

import com.matez.wildnature.world.generation.structures.nature.fallen.FallenSchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class fallen_palm3 extends FallenSchemFeature {


    @Override
    public Set<BlockPos> setBlocks() {

        Block(-1, 0, -10, "wildnature:palm_log[axis=y]");
        Block(-2, 0, -9, "wildnature:palm_log[axis=y]");
        Block(-1, 0, -9, "wildnature:palm_log[axis=y]");
        Block(-2, 1, -8, "wildnature:palm_log[axis=z]");
        Block(-1, 1, -8, "wildnature:palm_log[axis=z]");
        Block(0, 1, -8, "minecraft:vine[east=false,north=false,south=false,up=false,west=true]");
        Block(-1, 2, -8, "wildnature:palm_log[axis=z]");
        Block(-2, 1, -7, "wildnature:palm_log[axis=z]");
        Block(-1, 1, -7, "wildnature:palm_log[axis=z]");
        Block(-1, 1, -6, "wildnature:palm_log[axis=z]");
        Block(-2, 1, -5, "minecraft:vine[east=true,north=false,south=false,up=false,west=false]");
        Block(-1, 1, -5, "wildnature:palm_log[axis=z]");
        Block(-1, 1, -4, "wildnature:palm_log[axis=z]");
        Block(0, 1, -3, "wildnature:palm_log[axis=z]");
        Block(0, 1, -2, "wildnature:palm_log[axis=z]");
        Block(0, 1, -1, "wildnature:palm_log[axis=z]");
        Block(1, 1, -1, "minecraft:vine[east=false,north=false,south=false,up=false,west=true]");
        Block(0, 1, 0, "wildnature:palm_log[axis=z]");
        Block(-2, 1, 1, "wildnature:palm_leaves[distance=7,persistent=true]");
        Block(0, 1, 1, "minecraft:vine[east=true,north=false,south=false,up=false,west=false]");
        Block(1, 1, 1, "wildnature:palm_log[axis=z]");
        Block(-1, 1, 2, "wildnature:palm_leaves[distance=2,persistent=true]");
        Block(0, 1, 2, "wildnature:palm_leaves[distance=1,persistent=true]");
        Block(1, 1, 2, "wildnature:palm_log[axis=z]");
        Block(2, 1, 2, "wildnature:palm_leaves[distance=1,persistent=true]");
        Block(3, 1, 2, "wildnature:palm_leaves[distance=2,persistent=true]");
        Block(1, 2, 2, "wildnature:palm_leaves[distance=1,persistent=true]");
        Block(2, 2, 2, "wildnature:palm_leaves[distance=2,persistent=true]");
        Block(0, 1, 3, "wildnature:palm_leaves[distance=2,persistent=true]");
        Block(1, 1, 3, "wildnature:palm_leaves[distance=1,persistent=true]");
        Block(2, 1, 3, "wildnature:palm_leaves[distance=2,persistent=true]");
        Block(3, 1, 3, "wildnature:palm_leaves[distance=3,persistent=true]");
        Block(4, 1, 3, "wildnature:palm_leaves[distance=4,persistent=true]");
        Block(1, 2, 3, "wildnature:palm_leaves[distance=2,persistent=true]");
        Block(-1, 1, 4, "wildnature:palm_leaves[distance=4,persistent=true]");
        Block(0, 1, 4, "wildnature:palm_leaves[distance=3,persistent=true]");
        Block(1, 1, 4, "wildnature:palm_leaves[distance=2,persistent=true]");
        Block(3, 1, 4, "wildnature:palm_leaves[distance=4,persistent=true]");
        Block(-2, 1, 5, "wildnature:palm_leaves[distance=7,persistent=true]");
        Block(1, 1, 5, "wildnature:palm_leaves[distance=3,persistent=true]");
        Block(4, 1, 5, "wildnature:palm_leaves[distance=7,persistent=true]");
        Block(2, 1, 6, "wildnature:palm_leaves[distance=7,persistent=true]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     https://wildnaturemod.com
        return super.setBlocks();
    }
}