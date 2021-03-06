package com.matez.wildnature.world.generation.structures.nature.fallen.birch;

import com.matez.wildnature.world.generation.structures.nature.fallen.FallenSchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class fallen_seasonal_birch3 extends FallenSchemFeature {

    @Override
    public Set<BlockPos> setBlocks() {

        Block(0, 0, -5, "minecraft:birch_log[axis=y]");
        Block(0, 1, -5, "minecraft:vine[east=false,north=false,south=true,up=false,west=false]");
        Block(-1, 1, -4, "minecraft:vine[east=true,north=false,south=false,up=false,west=false]");
        Block(0, 1, -4, "minecraft:birch_log[axis=z]");
        Block(0, 1, -3, "minecraft:birch_log[axis=z]");
        Block(0, 2, -3, "minecraft:vine[east=false,north=false,south=true,up=false,west=false]");
        Block(-1, 1, -2, "wildnature:maple_yellow_leaves[distance=1,persistent=true]");
        Block(0, 1, -2, "minecraft:birch_log[axis=z]");
        Block(1, 1, -2, "wildnature:maple_yellow_leaves[distance=1,persistent=true]");
        Block(2, 1, -2, "minecraft:vine[east=false,north=false,south=true,up=false,west=false]");
        Block(0, 2, -2, "wildnature:maple_yellow_leaves[distance=1,persistent=true]");
        Block(1, 2, -2, "minecraft:vine[east=false,north=false,south=false,up=false,west=true]");
        Block(-2, 1, -1, "minecraft:vine[east=true,north=false,south=false,up=false,west=false]");
        Block(-1, 1, -1, "wildnature:maple_yellow_leaves[distance=1,persistent=true]");
        Block(0, 1, -1, "minecraft:birch_log[axis=z]");
        Block(1, 1, -1, "wildnature:maple_yellow_leaves[distance=1,persistent=true]");
        Block(2, 1, -1, "wildnature:maple_yellow_leaves[distance=2,persistent=true]");
        Block(0, 2, -1, "wildnature:maple_yellow_leaves[distance=1,persistent=true]");
        Block(1, 2, -1, "wildnature:maple_yellow_leaves[distance=2,persistent=true]");
        Block(-2, 1, 0, "wildnature:maple_yellow_leaves[distance=2,persistent=true]");
        Block(-1, 1, 0, "wildnature:maple_yellow_leaves[distance=1,persistent=true]");
        Block(0, 1, 0, "minecraft:birch_log[axis=z]");
        Block(1, 1, 0, "wildnature:maple_yellow_leaves[distance=1,persistent=true]");
        Block(2, 1, 0, "wildnature:rosevine_yellow[east=false,flowering=true,north=false,south=false,up=false,west=true]");
        Block(-1, 2, 0, "wildnature:maple_yellow_leaves[distance=2,persistent=true]");
        Block(0, 2, 0, "wildnature:maple_yellow_leaves[distance=1,persistent=true]");
        Block(-2, 1, 1, "wildnature:maple_yellow_leaves[distance=2,persistent=true]");
        Block(-1, 1, 1, "wildnature:maple_yellow_leaves[distance=1,persistent=true]");
        Block(0, 1, 1, "minecraft:birch_log[axis=z]");
        Block(1, 1, 1, "wildnature:maple_yellow_leaves[distance=1,persistent=true]");
        Block(-2, 2, 1, "minecraft:vine[east=true,north=false,south=false,up=false,west=false]");
        Block(-1, 2, 1, "wildnature:maple_yellow_leaves[distance=2,persistent=true]");
        Block(0, 2, 1, "wildnature:maple_yellow_leaves[distance=1,persistent=true]");
        Block(1, 2, 1, "minecraft:vine[east=false,north=false,south=false,up=false,west=true]");
        Block(-2, 1, 2, "minecraft:vine[east=false,north=true,south=false,up=false,west=false]");
        Block(-1, 1, 2, "wildnature:maple_yellow_leaves[distance=2,persistent=true]");
        Block(0, 1, 2, "wildnature:maple_yellow_leaves[distance=1,persistent=true]");
        Block(0, 2, 2, "wildnature:maple_yellow_leaves[distance=2,persistent=true]");
        Block(0, 1, 3, "wildnature:maple_yellow_leaves[distance=2,persistent=true]");
        Block(1, 1, 3, "wildnature:maple_yellow_leaves[distance=3,persistent=true]");
        Block(0, 1, 4, "wildnature:maple_yellow_leaves[distance=3,persistent=true]");
        Block(1, 1, 4, "minecraft:vine[east=false,north=false,south=false,up=false,west=true]");
        Block(0, 1, 5, "minecraft:vine[east=false,north=true,south=false,up=false,west=false]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     https://wildnaturemod.com
        return super.setBlocks();
    }
}