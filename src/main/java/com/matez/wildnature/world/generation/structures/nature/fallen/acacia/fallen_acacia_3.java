package com.matez.wildnature.world.generation.structures.nature.fallen.acacia;

import com.matez.wildnature.world.generation.structures.nature.fallen.FallenSchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class fallen_acacia_3 extends FallenSchemFeature {
    

    @Override
    public Set<BlockPos> setBlocks() {

Block(1,1,-3,"minecraft:vine[east=false,north=false,south=true,up=false,west=false]");
Block(2,1,-3,"minecraft:acacia_leaves[distance=6,persistent=true]");
Block(3,1,-3,"minecraft:vine[east=false,north=false,south=true,up=false,west=true]");
Block(0,1,-2,"minecraft:acacia_leaves[distance=3,persistent=true]");
Block(1,1,-2,"minecraft:acacia_leaves[distance=4,persistent=true]");
Block(2,1,-2,"minecraft:acacia_leaves[distance=5,persistent=true]");
Block(3,1,-2,"minecraft:acacia_leaves[distance=6,persistent=true]");
Block(-1,1,-1,"minecraft:acacia_leaves[distance=3,persistent=true]");
Block(0,1,-1,"minecraft:acacia_leaves[distance=2,persistent=true]");
Block(1,1,-1,"minecraft:acacia_leaves[distance=3,persistent=true]");
Block(2,1,-1,"minecraft:acacia_leaves[distance=4,persistent=true]");
Block(3,1,-1,"minecraft:acacia_leaves[distance=5,persistent=true]");
Block(0,2,-1,"minecraft:vine[east=false,north=false,south=true,up=false,west=false]");
Block(1,2,-1,"minecraft:acacia_leaves[distance=4,persistent=true]");
Block(2,2,-1,"minecraft:acacia_leaves[distance=5,persistent=true]");
Block(-1,1,0,"minecraft:acacia_leaves[distance=2,persistent=true]");
Block(0,1,0,"minecraft:acacia_leaves[distance=1,persistent=true]");
Block(1,1,0,"minecraft:acacia_leaves[distance=2,persistent=true]");
Block(2,1,0,"minecraft:acacia_leaves[distance=3,persistent=true]");
Block(3,1,0,"minecraft:acacia_leaves[distance=4,persistent=true]");
Block(-1,2,0,"minecraft:vine[east=true,north=false,south=true,up=false,west=false]");
Block(0,2,0,"minecraft:acacia_leaves[distance=2,persistent=true]");
Block(1,2,0,"minecraft:acacia_leaves[distance=3,persistent=true]");
Block(2,2,0,"minecraft:acacia_leaves[distance=4,persistent=true]");
Block(3,2,0,"minecraft:vine[east=false,north=false,south=false,up=false,west=true]");
Block(-2,1,1,"minecraft:acacia_leaves[distance=2,persistent=true]");
Block(-1,1,1,"minecraft:acacia_leaves[distance=1,persistent=true]");
Block(0,1,1,"minecraft:acacia_log[axis=z]");
Block(1,1,1,"minecraft:acacia_leaves[distance=1,persistent=true]");
Block(2,1,1,"minecraft:acacia_leaves[distance=2,persistent=true]");
Block(-2,2,1,"minecraft:vine[east=true,north=false,south=false,up=false,west=false]");
Block(-1,2,1,"minecraft:acacia_leaves[distance=2,persistent=true]");
Block(0,2,1,"minecraft:acacia_leaves[distance=1,persistent=true]");
Block(-1,1,2,"minecraft:acacia_leaves[distance=1,persistent=true]");
Block(0,1,2,"minecraft:acacia_log[axis=z]");
Block(1,1,2,"minecraft:acacia_leaves[distance=1,persistent=true]");
Block(-1,2,2,"minecraft:vine[east=false,north=true,south=false,up=false,west=false]");
Block(0,2,2,"minecraft:vine[east=false,north=true,south=false,up=false,west=false]");
Block(0,1,3,"minecraft:acacia_log[axis=z]");
Block(-1,1,4,"minecraft:acacia_log[axis=z]");
Block(-2,1,5,"minecraft:vine[east=true,north=false,south=false,up=false,west=false]");
Block(-1,1,5,"minecraft:acacia_log[axis=z]");
Block(-1,1,6,"minecraft:vine[east=false,north=true,south=true,up=false,west=false]");
Block(-1,0,7,"minecraft:acacia_log[axis=y]");
Block(-2,1,7,"minecraft:vine[east=true,north=false,south=false,up=false,west=false]");
Block(-1,1,7,"minecraft:acacia_log[axis=y]");
Block(0,1,7,"minecraft:vine[east=false,north=false,south=false,up=false,west=true]");
Block(-1,1,8,"minecraft:vine[east=false,north=true,south=false,up=false,west=false]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     https://wildnaturemod.com
return super.setBlocks();
    }
}