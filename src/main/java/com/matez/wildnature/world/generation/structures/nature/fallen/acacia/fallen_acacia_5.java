package com.matez.wildnature.world.generation.structures.nature.fallen.acacia;

import com.matez.wildnature.world.generation.structures.nature.fallen.FallenSchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class fallen_acacia_5 extends FallenSchemFeature {


    @Override
    public Set<BlockPos> setBlocks() {

Block(0,1,-3,"minecraft:acacia_leaves[distance=7,persistent=true]");
Block(1,1,-3,"minecraft:vine[east=false,north=false,south=false,up=false,west=true]");
Block(2,1,-3,"minecraft:acacia_leaves[distance=2,persistent=true]");
Block(-4,1,-2,"minecraft:acacia_leaves[distance=7,persistent=true]");
Block(-3,1,-2,"minecraft:vine[east=false,north=false,south=false,up=false,west=true]");
Block(-2,1,-2,"minecraft:acacia_leaves[distance=4,persistent=true]");
Block(1,1,-2,"minecraft:acacia_leaves[distance=2,persistent=true]");
Block(2,1,-2,"minecraft:acacia_leaves[distance=1,persistent=true]");
Block(3,1,-2,"minecraft:acacia_leaves[distance=2,persistent=true]");
Block(-2,2,-2,"minecraft:vine[east=false,north=false,south=true,up=false,west=false]");
Block(2,2,-2,"minecraft:acacia_leaves[distance=2,persistent=true]");
Block(-3,1,-1,"minecraft:acacia_leaves[distance=4,persistent=true]");
Block(-2,1,-1,"minecraft:acacia_leaves[distance=3,persistent=true]");
Block(-1,1,-1,"minecraft:acacia_leaves[distance=2,persistent=true]");
Block(0,1,-1,"minecraft:acacia_leaves[distance=1,persistent=true]");
Block(1,1,-1,"minecraft:acacia_leaves[distance=1,persistent=true]");
Block(2,1,-1,"minecraft:acacia_log[axis=z]");
Block(3,1,-1,"minecraft:acacia_leaves[distance=1,persistent=true]");
Block(-2,2,-1,"minecraft:acacia_leaves[distance=4,persistent=true]");
Block(1,2,-1,"minecraft:acacia_leaves[distance=2,persistent=true]");
Block(2,2,-1,"minecraft:acacia_leaves[distance=1,persistent=true]");
Block(3,2,-1,"minecraft:vine[east=false,north=false,south=false,up=false,west=true]");
Block(-3,1,0,"minecraft:acacia_leaves[distance=3,persistent=true]");
Block(-2,1,0,"minecraft:acacia_leaves[distance=2,persistent=true]");
Block(-1,1,0,"minecraft:acacia_leaves[distance=1,persistent=true]");
Block(0,1,0,"minecraft:acacia_log[axis=x]");
Block(1,1,0,"minecraft:acacia_log[axis=x]");
Block(2,1,0,"minecraft:acacia_log[axis=x]");
Block(-2,2,0,"minecraft:acacia_leaves[distance=3,persistent=true]");
Block(-1,2,0,"minecraft:acacia_leaves[distance=2,persistent=true]");
Block(0,2,0,"minecraft:acacia_leaves[distance=1,persistent=true]");
Block(1,2,0,"minecraft:acacia_leaves[distance=1,persistent=true]");
Block(-2,1,1,"minecraft:acacia_leaves[distance=3,persistent=true]");
Block(-1,1,1,"minecraft:acacia_leaves[distance=2,persistent=true]");
Block(0,1,1,"minecraft:acacia_leaves[distance=1,persistent=true]");
Block(1,1,1,"minecraft:acacia_leaves[distance=1,persistent=true]");
Block(2,1,1,"minecraft:vine[east=true,north=false,south=false,up=false,west=true]");
Block(3,1,1,"minecraft:acacia_log[axis=x]");
Block(4,1,1,"minecraft:acacia_log[axis=x]");
Block(-1,2,1,"minecraft:acacia_leaves[distance=3,persistent=true]");
Block(0,2,1,"minecraft:acacia_leaves[distance=2,persistent=true]");
Block(1,2,1,"minecraft:vine[east=false,north=false,south=false,up=false,west=true]");
Block(6,0,2,"minecraft:acacia_log[axis=y]");
Block(-1,1,2,"minecraft:acacia_leaves[distance=3,persistent=true]");
Block(0,1,2,"minecraft:acacia_leaves[distance=2,persistent=true]");
Block(4,1,2,"minecraft:vine[east=false,north=true,south=false,up=false,west=false]");
Block(6,1,2,"minecraft:acacia_log[axis=y]");
Block(0,2,2,"minecraft:vine[east=false,north=true,south=false,up=false,west=false]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     https://wildnaturemod.com
return super.setBlocks();
    }
}