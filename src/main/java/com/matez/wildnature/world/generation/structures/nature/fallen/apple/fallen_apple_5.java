package com.matez.wildnature.world.generation.structures.nature.fallen.apple;

import com.matez.wildnature.world.generation.structures.nature.fallen.FallenSchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class fallen_apple_5 extends FallenSchemFeature {


    @Override
    public Set<BlockPos> setBlocks() {

        Block(2, 1, -2, "wildnature:apple_leaves[distance=7,persistent=true,stage=6]");
        Block(-1, 1, -1, "minecraft:vine[east=true,north=false,south=false,up=false,west=false]");
        Block(0, 1, -1, "wildnature:apple_leaves[distance=7,persistent=true,stage=5]");
        Block(1, 1, -1, "wildnature:apple_leaves[distance=6,persistent=true,stage=1]");
        Block(2, 1, -1, "minecraft:vine[east=false,north=false,south=true,up=false,west=false]");
        Block(1, 2, -1, "minecraft:vine[east=false,north=false,south=true,up=false,west=false]");
        Block(-1, 1, 0, "wildnature:apple_leaves[distance=5,persistent=true,stage=5]");
        Block(0, 1, 0, "wildnature:rosaceae_branch[down=true,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(1, 1, 0, "wildnature:apple_leaves[distance=5,persistent=true,stage=6]");
        Block(2, 1, 0, "wildnature:apple_leaves[distance=6,persistent=true,stage=2]");
        Block(-1, 2, 0, "minecraft:vine[east=true,north=false,south=false,up=false,west=false]");
        Block(0, 2, 0, "wildnature:apple_leaves[distance=5,persistent=true,stage=2]");
        Block(1, 2, 0, "wildnature:apple_leaves[distance=4,persistent=true,stage=1]");
        Block(-1, 1, 1, "wildnature:apple_leaves[distance=4,persistent=true,stage=3]");
        Block(0, 1, 1, "wildnature:rosaceae_branch[down=false,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(1, 1, 1, "wildnature:apple_leaves[distance=4,persistent=true,stage=4]");
        Block(2, 1, 1, "wildnature:rosaceae_branch[down=false,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(3, 1, 1, "wildnature:apple_leaves[distance=7,persistent=true,stage=2]");
        Block(0, 2, 1, "wildnature:apple_leaves[distance=4,persistent=true,stage=1]");
        Block(1, 2, 1, "wildnature:apple_leaves[distance=3,persistent=true,stage=6]");
        Block(2, 2, 1, "wildnature:apple_leaves[distance=4,persistent=true,stage=2]");
        Block(3, 2, 1, "minecraft:vine[east=false,north=false,south=false,up=false,west=true]");
        Block(-2, 1, 2, "minecraft:vine[east=true,north=false,south=false,up=false,west=false]");
        Block(-1, 1, 2, "wildnature:apple_leaves[distance=3,persistent=true,stage=3]");
        Block(0, 1, 2, "wildnature:apple_leaves[distance=2,persistent=true,stage=6]");
        Block(1, 1, 2, "wildnature:rosaceae_branch[down=false,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(2, 1, 2, "wildnature:rosaceae_branch[down=false,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(3, 1, 2, "wildnature:apple_leaves[distance=7,persistent=true,stage=3]");
        Block(1, 2, 2, "wildnature:apple_leaves[distance=2,persistent=true,stage=2]");
        Block(2, 2, 2, "wildnature:apple_leaves[distance=3,persistent=true,stage=6]");
        Block(3, 2, 2, "minecraft:vine[east=false,north=false,south=false,up=false,west=true]");
        Block(0, 1, 3, "wildnature:apple_leaves[distance=1,persistent=true,stage=4]");
        Block(1, 1, 3, "wildnature:rosaceae_log[axis=z]");
        Block(2, 1, 3, "wildnature:apple_leaves[distance=1,persistent=true,stage=4]");
        Block(3, 1, 3, "minecraft:vine[east=false,north=true,south=false,up=false,west=true]");
        Block(0, 2, 3, "minecraft:vine[east=true,north=false,south=false,up=false,west=false]");
        Block(1, 2, 3, "wildnature:apple_leaves[distance=1,persistent=true,stage=5]");
        Block(2, 2, 3, "minecraft:vine[east=false,north=true,south=false,up=false,west=false]");
        Block(0, 1, 4, "wildnature:apple_leaves[distance=1,persistent=true,stage=3]");
        Block(1, 1, 4, "wildnature:rosaceae_log[axis=z]");
        Block(2, 1, 4, "minecraft:vine[east=false,north=true,south=false,up=false,west=true]");
        Block(1, 1, 5, "minecraft:vine[east=false,north=true,south=true,up=false,west=false]");
        Block(0, 0, 6, "wildnature:rosaceae_log[axis=y]");
        Block(1, 0, 6, "wildnature:rosaceae_log[axis=y]");
        Block(2, 0, 6, "wildnature:rosaceae_branch[down=true,east=false,north=false,south=false,up=false,waterlogged=false,west=true]");
        Block(0, 1, 6, "wildnature:apple_leaves[distance=1,persistent=true,stage=3]");
        Block(1, 1, 6, "wildnature:rosaceae_log[axis=y]");
        Block(2, 1, 6, "minecraft:vine[east=false,north=false,south=false,up=false,west=true]");
        Block(0, 1, 7, "minecraft:vine[east=false,north=true,south=false,up=false,west=false]");
        Block(1, 1, 7, "minecraft:vine[east=false,north=true,south=false,up=false,west=false]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     https://wildnaturemod.com
        return super.setBlocks();
    }
}