package com.matez.wildnature.world.generation.structures.nature.fallen.beech;

import com.matez.wildnature.world.generation.structures.nature.fallen.FallenSchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class fallen_beech_thick1 extends FallenSchemFeature {


    @Override
    public Set<BlockPos> setBlocks() {

        Block(-1, 1, -2, "minecraft:vine[east=false,north=false,south=true,up=false,west=false]");
        Block(0, 1, -2, "minecraft:vine[east=true,north=false,south=false,up=false,west=false]");
        Block(1, 1, -2, "wildnature:beech_leaves[distance=7,persistent=true]");
        Block(2, 1, -2, "minecraft:vine[east=false,north=false,south=true,up=false,west=true]");
        Block(1, 2, -2, "minecraft:vine[east=false,north=false,south=true,up=false,west=false]");
        Block(-2, 1, -1, "minecraft:vine[east=true,north=false,south=true,up=false,west=false]");
        Block(-1, 1, -1, "wildnature:beech_leaves[distance=7,persistent=true]");
        Block(0, 1, -1, "wildnature:beech_leaves[distance=7,persistent=true]");
        Block(1, 1, -1, "wildnature:beech_branch[down=false,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(2, 1, -1, "wildnature:beech_leaves[distance=7,persistent=true]");
        Block(1, 2, -1, "wildnature:beech_leaves[distance=7,persistent=true]");
        Block(2, 2, -1, "minecraft:vine[east=false,north=false,south=false,up=false,west=true]");
        Block(-3, 1, 0, "minecraft:vine[east=true,north=false,south=false,up=false,west=false]");
        Block(-2, 1, 0, "wildnature:beech_leaves[distance=7,persistent=true]");
        Block(-1, 1, 0, "wildnature:beech_branch[down=false,east=true,north=true,south=true,up=false,waterlogged=false,west=true]");
        Block(0, 1, 0, "wildnature:beech_leaves[distance=7,persistent=true]");
        Block(1, 1, 0, "wildnature:beech_branch[down=false,east=true,north=true,south=true,up=false,waterlogged=false,west=true]");
        Block(2, 1, 0, "wildnature:beech_leaves[distance=7,persistent=true]");
        Block(3, 1, 0, "minecraft:vine[east=false,north=false,south=false,up=false,west=true]");
        Block(-1, 2, 0, "minecraft:vine[east=true,north=false,south=false,up=false,west=false]");
        Block(0, 2, 0, "wildnature:beech_leaves[distance=7,persistent=true]");
        Block(1, 2, 0, "minecraft:vine[east=false,north=false,south=false,up=false,west=true]");
        Block(-2, 1, 1, "minecraft:vine[east=true,north=true,south=false,up=false,west=false]");
        Block(-1, 1, 1, "wildnature:beech_leaves[distance=7,persistent=true]");
        Block(0, 1, 1, "wildnature:beech_branch[down=false,east=true,north=true,south=true,up=false,waterlogged=false,west=true]");
        Block(1, 1, 1, "wildnature:beech_leaves[distance=7,persistent=true]");
        Block(2, 1, 1, "minecraft:vine[east=false,north=true,south=false,up=false,west=true]");
        Block(0, 2, 1, "minecraft:vine[east=false,north=true,south=false,up=false,west=false]");
        Block(-1, 1, 2, "minecraft:vine[east=false,north=true,south=false,up=false,west=false]");
        Block(0, 1, 2, "wildnature:beech_branch[down=false,east=false,north=true,south=true,up=false,waterlogged=false,west=false]");
        Block(1, 1, 2, "minecraft:vine[east=false,north=true,south=false,up=false,west=false]");
        Block(0, 1, 3, "wildnature:beech_leaves[distance=7,persistent=true]");
        Block(1, 1, 3, "minecraft:vine[east=false,north=false,south=false,up=false,west=true]");
        Block(1, 1, 4, "minecraft:vine[east=false,north=false,south=true,up=false,west=false]");
        Block(0, 1, 5, "wildnature:beech_branch[down=false,east=true,north=false,south=true,up=false,waterlogged=false,west=false]");
        Block(1, 1, 5, "wildnature:beech_leaves[distance=7,persistent=true]");
        Block(2, 1, 5, "minecraft:vine[east=false,north=false,south=false,up=false,west=true]");
        Block(0, 1, 6, "wildnature:beech_branch[down=false,east=false,north=true,south=false,up=false,waterlogged=false,west=false]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     https://wildnaturemod.com
        return super.setBlocks();
    }
}