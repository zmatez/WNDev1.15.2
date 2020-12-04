package com.matez.wildnature.world.generation.structures.nature.fallen.pine;

import com.matez.wildnature.world.generation.structures.nature.fallen.FallenSchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class fallen_mini_pine6 extends FallenSchemFeature {

    @Override
    public Set<BlockPos> setBlocks() {

        Block(-1, 1, -2, "wildnature:pine_leaves[distance=2,persistent=true]");
        Block(2, 1, -2, "wildnature:pine_leaves[distance=2,persistent=true]");
        Block(3, 1, -2, "minecraft:vine[east=false,north=false,south=true,up=false,west=false]");
        Block(-1, 2, -2, "minecraft:vine[east=false,north=false,south=true,up=false,west=false]");
        Block(2, 2, -2, "minecraft:vine[east=false,north=false,south=true,up=false,west=false]");
        Block(-3, 1, -1, "minecraft:vine[east=true,north=false,south=false,up=false,west=false]");
        Block(-2, 1, -1, "wildnature:pine_leaves[distance=1,persistent=true]");
        Block(-1, 1, -1, "wildnature:pine_leaves[distance=1,persistent=true]");
        Block(0, 1, -1, "wildnature:pine_leaves[distance=1,persistent=true]");
        Block(2, 1, -1, "wildnature:pine_leaves[distance=1,persistent=true]");
        Block(3, 1, -1, "wildnature:pine_leaves[distance=1,persistent=true]");
        Block(4, 1, -1, "minecraft:vine[east=false,north=false,south=true,up=false,west=false]");
        Block(-2, 2, -1, "minecraft:vine[east=true,north=false,south=false,up=false,west=false]");
        Block(-1, 2, -1, "wildnature:pine_leaves[distance=2,persistent=true]");
        Block(2, 2, -1, "wildnature:pine_leaves[distance=2,persistent=true]");
        Block(-4, 0, 0, "wildnature:pine_log[axis=y]");
        Block(-3, 1, 0, "wildnature:pine_log[axis=x]");
        Block(-2, 1, 0, "wildnature:pine_log[axis=x]");
        Block(-1, 1, 0, "wildnature:pine_log[axis=x]");
        Block(0, 1, 0, "wildnature:pine_log[axis=x]");
        Block(1, 1, 0, "wildnature:pine_log[axis=x]");
        Block(2, 1, 0, "wildnature:pine_log[axis=x]");
        Block(3, 1, 0, "wildnature:pine_log[axis=x]");
        Block(4, 1, 0, "wildnature:pine_leaves[distance=1,persistent=true]");
        Block(5, 1, 0, "minecraft:vine[east=false,north=false,south=false,up=false,west=true]");
        Block(-1, 2, 0, "wildnature:pine_leaves[distance=1,persistent=true]");
        Block(0, 2, 0, "wildnature:pine_leaves[distance=1,persistent=true]");
        Block(1, 2, 0, "minecraft:vine[east=false,north=false,south=false,up=false,west=true]");
        Block(2, 2, 0, "wildnature:pine_leaves[distance=1,persistent=true]");
        Block(3, 2, 0, "minecraft:vine[east=false,north=false,south=false,up=false,west=true]");
        Block(-3, 1, 1, "minecraft:vine[east=false,north=true,south=false,up=false,west=false]");
        Block(-2, 1, 1, "wildnature:pine_leaves[distance=1,persistent=true]");
        Block(-1, 1, 1, "wildnature:pine_leaves[distance=1,persistent=true]");
        Block(0, 1, 1, "wildnature:pine_leaves[distance=1,persistent=true]");
        Block(2, 1, 1, "wildnature:pine_leaves[distance=1,persistent=true]");
        Block(3, 1, 1, "wildnature:pine_leaves[distance=1,persistent=true]");
        Block(-2, 2, 1, "minecraft:vine[east=true,north=false,south=false,up=false,west=false]");
        Block(-1, 2, 1, "wildnature:pine_leaves[distance=2,persistent=true]");
        Block(-2, 1, 2, "minecraft:vine[east=false,north=true,south=false,up=false,west=false]");
        Block(-1, 1, 2, "minecraft:vine[east=false,north=true,south=false,up=false,west=false]");
        Block(0, 1, 2, "wildnature:pine_leaves[distance=2,persistent=true]");
        Block(1, 1, 2, "minecraft:vine[east=false,north=false,south=false,up=false,west=true]");
        Block(2, 1, 2, "wildnature:pine_leaves[distance=2,persistent=true]");
        Block(3, 1, 2, "minecraft:vine[east=false,north=true,south=false,up=false,west=false]");
        Block(0, 1, 3, "minecraft:vine[east=false,north=true,south=false,up=false,west=false]");
        Block(2, 1, 3, "minecraft:vine[east=false,north=true,south=false,up=false,west=false]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     https://wildnaturemod.com
        return super.setBlocks();
    }
}