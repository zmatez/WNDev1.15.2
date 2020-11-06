package com.matez.wildnature.world.generation.structures.nature.fallen.forsythia;

import com.matez.wildnature.world.generation.structures.nature.fallen.FallenSchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class fallen_forsythia_4 extends FallenSchemFeature {
    

    @Override
    public Set<BlockPos> setBlocks() {

Block(-1,1,-3,"minecraft:vine[east=false,north=false,south=true,up=false,west=false]");
Block(0,1,-3,"minecraft:vine[east=false,north=false,south=true,up=false,west=false]");
Block(-2,1,-2,"minecraft:vine[east=true,north=false,south=true,up=false,west=false]");
Block(-1,1,-2,"wildnature:forsythia_leaves[distance=2,flowering=true,persistent=true]");
Block(0,1,-2,"wildnature:forsythia_leaves[distance=3,flowering=true,persistent=true]");
Block(1,1,-2,"wildnature:forsythia_leaves[distance=4,flowering=true,persistent=true]");
Block(-4,0,-1,"wildnature:rosaceae_log[axis=y]");
Block(-4,1,-1,"wildnature:rosaceae_branch[down=true,east=false,north=false,south=true,up=false,waterlogged=false,west=false]");
Block(-3,1,-1,"minecraft:vine[east=true,north=false,south=true,up=false,west=false]");
Block(-2,1,-1,"wildnature:forsythia_leaves[distance=1,flowering=true,persistent=true]");
Block(-1,1,-1,"wildnature:forsythia_leaves[distance=1,flowering=true,persistent=true]");
Block(0,1,-1,"wildnature:forsythia_leaves[distance=2,flowering=true,persistent=true]");
Block(1,1,-1,"wildnature:forsythia_leaves[distance=3,flowering=true,persistent=true]");
Block(2,1,-1,"wildnature:forsythia_leaves[distance=4,flowering=true,persistent=true]");
Block(3,1,-1,"minecraft:vine[east=false,north=false,south=true,up=false,west=true]");
Block(-1,2,-1,"wildnature:forsythia_leaves[distance=2,flowering=true,persistent=true]");
Block(0,2,-1,"wildnature:forsythia_leaves[distance=3,flowering=true,persistent=true]");
Block(-6,0,0,"wildnature:rosaceae_branch[down=true,east=false,north=false,south=false,up=false,waterlogged=false,west=false]");
Block(-5,1,0,"wildnature:rosaceae_branch[down=false,east=true,north=false,south=false,up=false,waterlogged=false,west=false]");
Block(-4,1,0,"wildnature:rosaceae_log[axis=x]");
Block(-3,1,0,"wildnature:rosaceae_log[axis=x]");
Block(-2,1,0,"wildnature:rosaceae_log[axis=x]");
Block(-1,1,0,"wildnature:rosaceae_log[axis=x]");
Block(0,1,0,"wildnature:forsythia_leaves[distance=1,flowering=true,persistent=true]");
Block(1,1,0,"wildnature:forsythia_leaves[distance=2,flowering=true,persistent=true]");
Block(2,1,0,"wildnature:forsythia_leaves[distance=3,flowering=true,persistent=true]");
Block(3,1,0,"wildnature:forsythia_leaves[distance=4,flowering=true,persistent=true]");
Block(4,1,0,"minecraft:vine[east=false,north=false,south=false,up=false,west=true]");
Block(-1,2,0,"wildnature:forsythia_leaves[distance=1,flowering=true,persistent=true]");
Block(0,2,0,"wildnature:forsythia_leaves[distance=2,flowering=true,persistent=true]");
Block(1,2,0,"wildnature:forsythia_leaves[distance=3,flowering=true,persistent=true]");
Block(-5,0,1,"wildnature:rosaceae_branch[down=true,east=false,north=false,south=false,up=false,waterlogged=false,west=false]");
Block(-3,1,1,"wildnature:rosaceae_branch[down=false,east=true,north=true,south=false,up=false,waterlogged=false,west=false]");
Block(-2,1,1,"wildnature:forsythia_leaves[distance=1,flowering=true,persistent=true]");
Block(-1,1,1,"wildnature:forsythia_leaves[distance=1,flowering=true,persistent=true]");
Block(0,1,1,"wildnature:rosaceae_branch[down=false,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
Block(1,1,1,"wildnature:forsythia_leaves[distance=3,flowering=true,persistent=true]");
Block(2,1,1,"wildnature:forsythia_leaves[distance=4,flowering=true,persistent=true]");
Block(3,1,1,"minecraft:vine[east=false,north=true,south=false,up=false,west=false]");
Block(0,2,1,"wildnature:forsythia_leaves[distance=3,flowering=true,persistent=true]");
Block(-1,1,2,"wildnature:forsythia_leaves[distance=2,flowering=true,persistent=true]");
Block(0,1,2,"wildnature:forsythia_leaves[distance=3,flowering=true,persistent=true]");
Block(1,1,2,"wildnature:forsythia_leaves[distance=4,flowering=true,persistent=true]");
Block(2,1,3,"wildnature:forsythia_leaves[distance=7,flowering=true,persistent=true]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     https://wildnaturemod.com
return super.setBlocks();
    }
}