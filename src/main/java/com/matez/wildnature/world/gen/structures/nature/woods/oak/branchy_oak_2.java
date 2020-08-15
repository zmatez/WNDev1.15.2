package com.matez.wildnature.world.gen.structures.nature.woods.oak;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class branchy_oak_2 extends SchemFeature {
    public branchy_oak_2() {
        super();

    }


    @Override
    public Set<BlockPos> setBlocks() {

        Block(-1, 4, -3, "minecraft:oak_leaves[distance=7,persistent=true]");
        Block(0, 4, -3, "minecraft:oak_leaves[distance=7,persistent=true]");
        Block(-1, 3, -2, "minecraft:oak_leaves[distance=7,persistent=true]");
        Block(0, 3, -2, "wildnature:oak_branch[down=false,east=false,north=false,south=true,up=true,waterlogged=false,west=true]");
        Block(-2, 4, -2, "minecraft:oak_leaves[distance=7,persistent=true]");
        Block(-1, 4, -2, "wildnature:oak_branch[down=true,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(0, 4, -2, "wildnature:oak_branch[down=true,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(1, 4, -2, "minecraft:oak_leaves[distance=7,persistent=true]");
        Block(-1, 5, -2, "minecraft:oak_leaves[distance=7,persistent=true]");
        Block(0, 5, -2, "minecraft:oak_leaves[distance=7,persistent=true]");
        Block(0, 3, -1, "wildnature:oak_branch[down=false,east=false,north=true,south=true,up=true,waterlogged=false,west=false]");
        Block(-2, 4, -1, "minecraft:oak_leaves[distance=7,persistent=true]");
        Block(-1, 4, -1, "minecraft:oak_leaves[distance=7,persistent=true]");
        Block(0, 4, -1, "minecraft:oak_leaves[distance=7,persistent=true]");
        Block(0, 5, -1, "minecraft:oak_leaves[distance=7,persistent=true]");
        Block(2, 5, -1, "minecraft:oak_leaves[distance=7,persistent=true]");
        Block(3, 5, -1, "minecraft:oak_leaves[distance=7,persistent=true]");
        Block(0, 1, 0, "wildnature:oak_branch[down=true,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(0, 2, 0, "wildnature:oak_branch[down=true,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(-2, 3, 0, "wildnature:oak_branch[down=false,east=true,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(-1, 3, 0, "wildnature:oak_branch[down=false,east=true,north=false,south=false,up=true,waterlogged=false,west=true]");
        Block(0, 3, 0, "wildnature:oak_branch[down=true,east=false,north=true,south=false,up=true,waterlogged=false,west=true]");
        Block(-3, 4, 0, "minecraft:oak_leaves[distance=7,persistent=true]");
        Block(-2, 4, 0, "wildnature:oak_branch[down=true,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(-1, 4, 0, "minecraft:oak_leaves[distance=7,persistent=true]");
        Block(0, 4, 0, "wildnature:oak_branch[down=true,east=true,north=true,south=false,up=true,waterlogged=false,west=true]");
        Block(1, 4, 0, "wildnature:oak_branch[down=false,east=true,north=false,south=false,up=true,waterlogged=false,west=true]");
        Block(2, 4, 0, "wildnature:oak_branch[down=false,east=false,north=false,south=true,up=true,waterlogged=false,west=true]");
        Block(-2, 5, 0, "minecraft:oak_leaves[distance=7,persistent=true]");
        Block(0, 5, 0, "minecraft:oak_leaves[distance=7,persistent=true]");
        Block(1, 5, 0, "minecraft:oak_leaves[distance=7,persistent=true]");
        Block(2, 5, 0, "wildnature:oak_branch[down=true,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(3, 5, 0, "minecraft:oak_leaves[distance=7,persistent=true]");
        Block(2, 6, 0, "minecraft:oak_leaves[distance=7,persistent=true]");
        Block(-3, 4, 1, "minecraft:oak_leaves[distance=7,persistent=true]");
        Block(-2, 4, 1, "minecraft:oak_leaves[distance=7,persistent=true]");
        Block(2, 4, 1, "minecraft:oak_leaves[distance=7,persistent=true]");
        Block(1, 5, 1, "minecraft:oak_leaves[distance=7,persistent=true]");
        Block(2, 5, 1, "minecraft:oak_leaves[distance=7,persistent=true]");
        Block(3, 5, 1, "minecraft:oak_leaves[distance=7,persistent=true]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}