package com.matez.wildnature.world.gen.structures.dungeons.easter;

import com.matez.wildnature.Main;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Set;
import java.util.function.Function;

public class estatue1 extends SchemFeature {
    @Override
    public Set<BlockPos> setBlocks() {

Block(-1,2,-3,"minecraft:andesite_wall[east=false,north=false,south=true,up=true,waterlogged=false,west=false]");
Block(0,2,-3,"minecraft:stone_stairs[facing=south,half=top,shape=straight,waterlogged=false]");
Block(1,2,-3,"minecraft:andesite_wall[east=false,north=false,south=true,up=true,waterlogged=false,west=false]");
Block(-1,3,-3,"minecraft:andesite_wall[east=true,north=false,south=true,up=true,waterlogged=false,west=false]");
Block(0,3,-3,"minecraft:stone");
Block(1,3,-3,"minecraft:andesite_wall[east=false,north=false,south=true,up=true,waterlogged=false,west=true]");
Block(-1,4,-3,"minecraft:stone_stairs[facing=east,half=bottom,shape=outer_right,waterlogged=false]");
Block(0,4,-3,"minecraft:stone_stairs[facing=south,half=bottom,shape=straight,waterlogged=false]");
Block(1,4,-3,"minecraft:stone_stairs[facing=west,half=bottom,shape=outer_left,waterlogged=false]");
Block(-1,1,-2,"minecraft:stone_stairs[facing=south,half=top,shape=outer_left,waterlogged=false]");
Block(0,1,-2,"minecraft:stone_stairs[facing=south,half=top,shape=straight,waterlogged=false]");
Block(1,1,-2,"minecraft:stone_stairs[facing=south,half=top,shape=outer_right,waterlogged=false]");
Block(-1,2,-2,"minecraft:stone");
Block(0,2,-2,"minecraft:stone");
Block(1,2,-2,"minecraft:stone");
Block(-1,3,-2,"minecraft:stone");
Block(0,3,-2,"minecraft:redstone_wire[east=none,north=none,power=0,south=side,west=none]");
Block(1,3,-2,"minecraft:stone");
Block(-1,4,-2,"minecraft:stone_stairs[facing=east,half=bottom,shape=straight,waterlogged=false]");
Block(0,4,-2,"minecraft:daylight_detector[inverted=true,power=0]");
Block(1,4,-2,"minecraft:stone_stairs[facing=west,half=bottom,shape=straight,waterlogged=false]");
Block(0,5,-2,"wildnature:gneiss_cobble_trapdoor[facing=south,half=bottom,open=false,powered=false,waterlogged=false]");
Block(-1,1,-1,"minecraft:stone_stairs[facing=east,half=top,shape=straight,waterlogged=false]");
Block(0,1,-1,"minecraft:stone");
Block(1,1,-1,"minecraft:stone_stairs[facing=west,half=top,shape=straight,waterlogged=false]");
Block(-1,2,-1,"minecraft:stone");
Block(0,2,-1,"minecraft:stone");
Block(1,2,-1,"minecraft:stone");
Block(-2,3,-1,"minecraft:stone_stairs[facing=east,half=top,shape=straight,waterlogged=false]");
Block(-1,3,-1,"minecraft:stone");
Block(0,3,-1,"wildnature:rs_proximity_sensor[facing=north,power=0,powered=false]");
Block(1,3,-1,"minecraft:stone");
Block(2,3,-1,"minecraft:stone_stairs[facing=west,half=top,shape=straight,waterlogged=false]");
Block(-1,4,-1,"minecraft:stone_stairs[facing=east,half=bottom,shape=straight,waterlogged=false]");
Block(0,4,-1,"minecraft:stone_stairs[facing=south,half=top,shape=straight,waterlogged=false]");
Block(1,4,-1,"minecraft:stone_stairs[facing=west,half=bottom,shape=straight,waterlogged=false]");
Block(-1,1,0,"minecraft:stone_stairs[facing=east,half=top,shape=straight,waterlogged=false]");
Block(0,1,0,"minecraft:stone");
Block(1,1,0,"minecraft:stone_stairs[facing=west,half=top,shape=straight,waterlogged=false]");
Block(-2,2,0,"minecraft:stone_stairs[facing=east,half=top,shape=straight,waterlogged=false]");
Block(-1,2,0,"minecraft:stone");
Block(0,2,0,"wildnature:stone_lamp[lit=false]");
Block(1,2,0,"minecraft:stone");
Block(2,2,0,"minecraft:stone_stairs[facing=west,half=top,shape=straight,waterlogged=false]");
Block(-2,3,0,"minecraft:stone_stairs[facing=north,half=bottom,shape=straight,waterlogged=false]");
Block(-1,3,0,"minecraft:stone_stairs[facing=west,half=bottom,shape=outer_right,waterlogged=false]");
Block(0,3,0,"wildnature:stone_lamp[lit=false]");
Block(1,3,0,"minecraft:stone_stairs[facing=east,half=bottom,shape=outer_left,waterlogged=false]");
Block(2,3,0,"minecraft:stone_stairs[facing=north,half=bottom,shape=straight,waterlogged=false]");
Block(-1,4,0,"minecraft:stone_stairs[facing=east,half=bottom,shape=outer_left,waterlogged=false]");
Block(0,4,0,"minecraft:stone_stairs[facing=north,half=bottom,shape=straight,waterlogged=false]");
Block(1,4,0,"minecraft:stone_stairs[facing=west,half=bottom,shape=outer_right,waterlogged=false]");
Block(-1,1,1,"minecraft:stone_stairs[facing=north,half=top,shape=outer_right,waterlogged=false]");
Block(0,1,1,"minecraft:stone_stairs[facing=north,half=top,shape=straight,waterlogged=false]");
Block(1,1,1,"minecraft:stone_stairs[facing=north,half=top,shape=outer_left,waterlogged=false]");
Block(-1,2,1,"minecraft:stone_stairs[facing=east,half=bottom,shape=straight,waterlogged=false]");
Block(0,2,1,"minecraft:stone_slab[type=top,waterlogged=false]");
Block(1,2,1,"minecraft:stone_stairs[facing=west,half=bottom,shape=straight,waterlogged=false]");
Block(0,3,1,"minecraft:stone_stairs[facing=north,half=bottom,shape=straight,waterlogged=false]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
return super.setBlocks();
    }
}