package com.matez.wildnature.world.generation.structures.nature.fallen.jungle;

import com.matez.wildnature.world.generation.structures.nature.fallen.FallenSchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class fallen_jungle_1 extends FallenSchemFeature {
    

    @Override
    public Set<BlockPos> setBlocks() {

Block(-2,1,-2,"minecraft:jungle_leaves[distance=7,persistent=true]");
Block(1,1,-2,"minecraft:jungle_leaves[distance=4,persistent=true]");
Block(3,1,-2,"minecraft:jungle_leaves[distance=7,persistent=true]");
Block(4,1,-2,"minecraft:vine[east=false,north=false,south=false,up=false,west=true]");
Block(-1,1,-1,"minecraft:jungle_leaves[distance=3,persistent=true]");
Block(0,1,-1,"minecraft:jungle_leaves[distance=2,persistent=true]");
Block(1,1,-1,"minecraft:jungle_leaves[distance=3,persistent=true]");
Block(2,1,-1,"minecraft:jungle_leaves[distance=4,persistent=true]");
Block(3,1,-1,"minecraft:vine[east=false,north=true,south=false,up=false,west=true]");
Block(1,2,-1,"minecraft:jungle_leaves[distance=4,persistent=true]");
Block(-2,1,0,"minecraft:jungle_leaves[distance=3,persistent=true]");
Block(-1,1,0,"minecraft:jungle_leaves[distance=2,persistent=true]");
Block(0,1,0,"minecraft:jungle_leaves[distance=1,persistent=true]");
Block(1,1,0,"minecraft:jungle_leaves[distance=2,persistent=true]");
Block(2,1,0,"minecraft:jungle_leaves[distance=3,persistent=true]");
Block(3,1,0,"minecraft:vine[east=false,north=false,south=false,up=false,west=true]");
Block(-1,2,0,"minecraft:jungle_leaves[distance=3,persistent=true]");
Block(0,2,0,"minecraft:jungle_leaves[distance=2,persistent=true]");
Block(-2,1,1,"minecraft:jungle_leaves[distance=2,persistent=true]");
Block(-1,1,1,"minecraft:jungle_leaves[distance=1,persistent=true]");
Block(0,1,1,"minecraft:jungle_log[axis=z]");
Block(1,1,1,"minecraft:jungle_leaves[distance=1,persistent=true]");
Block(2,1,1,"minecraft:vine[east=false,north=true,south=false,up=false,west=false]");
Block(-1,2,1,"minecraft:jungle_leaves[distance=2,persistent=true]");
Block(0,2,1,"minecraft:jungle_leaves[distance=1,persistent=true]");
Block(1,2,1,"minecraft:jungle_leaves[distance=2,persistent=true]");
Block(0,1,2,"minecraft:jungle_log[axis=z]");
Block(0,2,2,"minecraft:vine[east=false,north=true,south=false,up=false,west=false]");
Block(-1,1,3,"minecraft:jungle_leaves[distance=7,persistent=true]");
Block(0,1,4,"minecraft:jungle_log[axis=z]");
Block(1,1,4,"minecraft:vine[east=false,north=false,south=false,up=false,west=true]");
Block(-1,1,5,"minecraft:vine[east=true,north=false,south=false,up=false,west=false]");
Block(0,1,5,"minecraft:jungle_log[axis=z]");
Block(1,1,5,"minecraft:vine[east=false,north=false,south=false,up=false,west=true]");
Block(0,1,6,"minecraft:vine[east=false,north=true,south=false,up=false,west=false]");
Block(0,0,7,"minecraft:jungle_log[axis=y]");
Block(-1,1,7,"minecraft:vine[east=true,north=false,south=false,up=false,west=false]");
Block(0,1,7,"minecraft:jungle_log[axis=y]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     https://wildnaturemod.com
return super.setBlocks();
    }
}