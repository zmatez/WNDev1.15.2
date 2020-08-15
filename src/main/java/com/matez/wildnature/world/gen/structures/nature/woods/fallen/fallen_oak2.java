package com.matez.wildnature.world.gen.structures.nature.woods.fallen;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class fallen_oak2 extends SchemFeature {
    public fallen_oak2() {
        super();

        terrainIncrease = 1;
    }


    @Override
    public Set<BlockPos> setBlocks() {

        Block(-2, 1, -1, "minecraft:vine[east=false,north=false,south=true,up=false,west=false]");
        Block(-1, 1, -1, "minecraft:vine[east=false,north=false,south=true,up=false,west=false]");
        Block(0, 1, -1, "minecraft:vine[east=false,north=false,south=true,up=false,west=false]");
        Block(-4, 1, 0, "minecraft:vine[east=true,north=false,south=false,up=false,west=false]");
        Block(-3, 1, 0, "minecraft:oak_log[axis=x]");
        Block(-2, 1, 0, "minecraft:oak_log[axis=x]");
        Block(-1, 1, 0, "minecraft:oak_log[axis=x]");
        Block(0, 1, 0, "minecraft:oak_log[axis=x]");
        Block(1, 1, 0, "minecraft:oak_log[axis=x]");
        Block(2, 1, 0, "minecraft:oak_log[axis=x]");
        Block(0, 2, 0, "minecraft:vine[east=true,north=false,south=false,up=false,west=false]");
        Block(1, 2, 0, "minecraft:oak_log[axis=y]");
        Block(2, 2, 0, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(0, 1, 1, "minecraft:oak_log[axis=z]");
        Block(1, 1, 1, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(2, 1, 1, "minecraft:vine[east=false,north=false,south=true,up=false,west=false]");
        Block(1, 2, 1, "minecraft:vine[east=false,north=true,south=false,up=false,west=false]");
        Block(0, 1, 2, "minecraft:vine[east=true,north=false,south=false,up=false,west=false]");
        Block(1, 1, 2, "minecraft:oak_log[axis=x]");
        Block(2, 1, 2, "minecraft:oak_log[axis=x]");
        Block(2, 0, 3, "minecraft:vine[east=false,north=true,south=false,up=false,west=false]");
        Block(1, 1, 3, "minecraft:oak_leaves[distance=1,persistent=true]");
        Block(2, 1, 3, "minecraft:vine[east=false,north=true,south=false,up=false,west=false]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}