package com.matez.wildnature.world.generation.structures.nature.rocks;

import com.matez.wildnature.util.config.CommonConfig;
import com.matez.wildnature.util.other.Utilities;
import com.matez.wildnature.world.generation.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class gneiss_rock extends SchemFeature {
    public gneiss_rock() {
        super();
        terrainIncrease = 1;
    }

    @Override
    public Set<BlockPos> setBlocks() {
        if (Utilities.rint(0, CommonConfig.rockFormationChance.get()) == 0) {

            Block(0, 4, -2, "wildnature:gneiss");
            Block(0, 5, -2, "wildnature:gneiss");
            Block(0, 1, -1, "minecraft:stone_stairs[facing=south,half=bottom,shape=straight,waterlogged=false]");
            Block(0, 3, -1, "wildnature:gneiss");
            Block(0, 4, -1, "wildnature:gneiss_cobble");
            Block(-1, 5, -1, "wildnature:gneiss_stairs[facing=south,half=top,shape=straight,waterlogged=false]");
            Block(0, 5, -1, "minecraft:stone");
            Block(-1, 1, 0, "wildnature:gneiss_cobble");
            Block(0, 1, 0, "wildnature:gneiss");
            Block(1, 1, 0, "wildnature:gneiss_stairs[facing=west,half=bottom,shape=straight,waterlogged=false]");
            Block(0, 2, 0, "wildnature:gneiss_stairs[facing=north,half=top,shape=straight,waterlogged=false]");
            Block(-1, 3, 0, "wildnature:gneiss");
            Block(0, 3, 0, "wildnature:gneiss");
            Block(-1, 4, 0, "wildnature:gneiss");
            Block(0, 4, 0, "wildnature:gneiss");
            Block(1, 4, 0, "wildnature:gneiss_stairs[facing=west,half=top,shape=straight,waterlogged=false]");
            Block(-1, 5, 0, "wildnature:gneiss_cobble");
            Block(0, 5, 0, "wildnature:gneiss");
            Block(1, 5, 0, "wildnature:gneiss_cobble");
            Block(0, 1, 1, "minecraft:stone");
            Block(0, 3, 1, "wildnature:gneiss_cobble");
            Block(-1, 4, 1, "minecraft:stone_stairs[facing=north,half=top,shape=straight,waterlogged=false]");
            Block(0, 4, 1, "wildnature:gneiss");
            Block(-1, 5, 1, "wildnature:gneiss");
            Block(0, 5, 1, "wildnature:gneiss");
            Block(0, 1, 2, "wildnature:gneiss_stairs[facing=north,half=bottom,shape=straight,waterlogged=false]");
            Block(0, 5, 2, "wildnature:gneiss_cobble");
        }
//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}