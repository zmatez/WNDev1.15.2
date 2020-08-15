package com.matez.wildnature.world.gen.structures.nature.woods.mahogany;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class mahoganyshrub1 extends SchemFeature {
    public mahoganyshrub1() {
        super();

    }


    @Override
    public Set<BlockPos> setBlocks() {

        Block(-1, 1, -1, "wildnature:mahogany_leaves[distance=7,persistent=true]");
        Block(0, 1, -1, "wildnature:mahogany_leaves[distance=7,persistent=true]");
        Block(0, 1, 0, "wildnature:mahogany_branch[down=true,east=false,north=true,south=false,up=true,waterlogged=false,west=false]");
        Block(-1, 2, 0, "wildnature:mahogany_leaves[distance=7,persistent=true]");
        Block(0, 2, 0, "wildnature:mahogany_branch[down=true,east=true,north=false,south=true,up=true,waterlogged=false,west=true]");
        Block(1, 2, 0, "wildnature:mahogany_leaves[distance=7,persistent=true]");
        Block(0, 3, 0, "wildnature:mahogany_leaves[distance=7,persistent=true]");
        Block(1, 3, 0, "wildnature:mahogany_leaves[distance=7,persistent=true]");
        Block(1, 1, 1, "wildnature:mahogany_leaves[distance=7,persistent=true]");
        Block(0, 2, 1, "wildnature:mahogany_leaves[distance=7,persistent=true]");
        Block(-3, 0, 3, "minecraft:dirt");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}