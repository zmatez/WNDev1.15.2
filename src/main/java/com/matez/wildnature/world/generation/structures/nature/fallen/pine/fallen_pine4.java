package com.matez.wildnature.world.generation.structures.nature.fallen.pine;

import com.matez.wildnature.world.generation.structures.nature.fallen.FallenSchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class fallen_pine4 extends FallenSchemFeature {


    @Override
    public Set<BlockPos> setBlocks() {

        Block(0, 1, -10, "minecraft:vine[east=false,north=false,south=true,up=false,west=false]");
        Block(0, 0, -9, "wildnature:pine_log[axis=y]");
        Block(0, 1, -9, "wildnature:pine_log[axis=y]");
        Block(1, 1, -9, "minecraft:vine[east=false,north=false,south=false,up=false,west=true]");
        Block(0, 1, -8, "minecraft:vine[east=false,north=false,south=true,up=false,west=false]");
        Block(-1, 1, -7, "minecraft:vine[east=true,north=false,south=false,up=false,west=false]");
        Block(0, 1, -7, "wildnature:pine_log[axis=z]");
        Block(-1, 1, -6, "minecraft:vine[east=true,north=false,south=false,up=false,west=false]");
        Block(0, 1, -6, "wildnature:pine_log[axis=z]");
        Block(1, 1, -6, "minecraft:vine[east=false,north=false,south=false,up=false,west=true]");
        Block(0, 1, -5, "minecraft:vine[east=false,north=true,south=true,up=false,west=false]");
        Block(-1, 1, -4, "minecraft:vine[east=true,north=false,south=false,up=false,west=false]");
        Block(0, 1, -4, "wildnature:pine_log[axis=z]");
        Block(-1, 1, -3, "minecraft:vine[east=true,north=false,south=false,up=false,west=false]");
        Block(0, 1, -3, "wildnature:pine_log[axis=z]");
        Block(1, 1, -3, "wildnature:pine_leaves[distance=1,persistent=true,stage=0]");
        Block(-1, 1, -2, "wildnature:pine_leaves[distance=1,persistent=true,stage=0]");
        Block(0, 1, -2, "wildnature:pine_log[axis=z]");
        Block(1, 1, -2, "minecraft:vine[east=false,north=false,south=false,up=false,west=true]");
        Block(-1, 1, -1, "minecraft:vine[east=true,north=false,south=false,up=false,west=false]");
        Block(0, 1, -1, "wildnature:pine_log[axis=z]");
        Block(1, 1, -1, "wildnature:pine_leaves[distance=1,persistent=true,stage=0]");
        Block(0, 2, -1, "wildnature:pine_leaves[distance=1,persistent=true,stage=0]");
        Block(-2, 1, 0, "wildnature:pine_leaves[distance=2,persistent=true,stage=0]");
        Block(-1, 1, 0, "wildnature:pine_leaves[distance=1,persistent=true,stage=0]");
        Block(0, 1, 0, "wildnature:pine_log[axis=z]");
        Block(1, 1, 0, "minecraft:vine[east=false,north=false,south=false,up=false,west=true]");
        Block(-1, 2, 0, "wildnature:pine_leaves[distance=2,persistent=true,stage=0]");
        Block(0, 2, 0, "wildnature:pine_leaves[distance=1,persistent=true,stage=0]");
        Block(-1, 1, 1, "wildnature:pine_leaves[distance=1,persistent=true,stage=0]");
        Block(0, 1, 1, "wildnature:pine_log[axis=z]");
        Block(1, 1, 1, "wildnature:pine_leaves[distance=1,persistent=true,stage=0]");
        Block(0, 2, 1, "wildnature:pine_leaves[distance=1,persistent=true,stage=0]");
        Block(1, 2, 1, "wildnature:pine_leaves[distance=2,persistent=true,stage=0]");
        Block(-1, 1, 2, "wildnature:pine_leaves[distance=1,persistent=true,stage=0]");
        Block(0, 1, 2, "wildnature:pine_log[axis=z]");
        Block(1, 1, 2, "wildnature:pine_leaves[distance=1,persistent=true,stage=0]");
        Block(-1, 2, 2, "wildnature:pine_leaves[distance=2,persistent=true,stage=0]");
        Block(-1, 1, 3, "wildnature:pine_leaves[distance=2,persistent=true,stage=0]");
        Block(0, 1, 3, "wildnature:pine_leaves[distance=1,persistent=true,stage=0]");
        Block(1, 1, 3, "minecraft:vine[east=false,north=false,south=false,up=false,west=true]");
        Block(0, 2, 3, "wildnature:pine_leaves[distance=2,persistent=true,stage=0]");
        Block(0, 1, 4, "wildnature:pine_leaves[distance=2,persistent=true,stage=0]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     https://wildnaturemod.com
        return super.setBlocks();
    }
}