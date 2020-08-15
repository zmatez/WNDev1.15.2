package com.matez.wildnature.world.gen.structures.nature.rocks;

import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Set;
import java.util.function.Function;

public class basalt_rock extends SchemFeature {
    public basalt_rock() {
        super();
        terrainIncrease = 1;
    }

    @Override
    public Set<BlockPos> setBlocks() {

        if (Utilities.rint(0, CommonConfig.rockFormationChance.get()) == 0) {

            Block(-1, 1, -2, "wildnature:basalt");
            Block(0, 1, -2, "wildnature:basalt");
            Block(-1, 2, -2, "wildnature:basalt");
            Block(0, 2, -2, "wildnature:basalt");
            Block(-1, 3, -2, "wildnature:basalt");
            Block(0, 3, -2, "wildnature:basalt_cobble");
            Block(0, 4, -2, "wildnature:basalt");
            Block(0, 5, -2, "wildnature:basalt_stairs[facing=south,half=bottom,shape=straight,waterlogged=false]");
            Block(0, 1, -1, "wildnature:basalt_cobble");
            Block(1, 1, -1, "wildnature:basalt_cobble");
            Block(2, 1, -1, "wildnature:basalt");
            Block(0, 2, -1, "wildnature:basalt");
            Block(1, 2, -1, "wildnature:basalt");
            Block(2, 2, -1, "wildnature:basalt");
            Block(0, 3, -1, "wildnature:basalt");
            Block(1, 3, -1, "wildnature:basalt_stairs[facing=south,half=bottom,shape=straight,waterlogged=false]");
            Block(2, 3, -1, "wildnature:basalt");
            Block(0, 4, -1, "wildnature:basalt");
            Block(2, 4, -1, "wildnature:basalt");
            Block(0, 5, -1, "wildnature:basalt");
            Block(2, 5, -1, "wildnature:basalt_stairs[facing=west,half=bottom,shape=straight,waterlogged=false]");
            Block(0, 6, -1, "wildnature:basalt");
            Block(0, 7, -1, "wildnature:basalt");
            Block(0, 8, -1, "wildnature:basalt_stairs[facing=west,half=bottom,shape=straight,waterlogged=false]");
            Block(-1, 1, 0, "wildnature:basalt");
            Block(0, 1, 0, "wildnature:basalt");
            Block(1, 1, 0, "wildnature:basalt");
            Block(-1, 2, 0, "wildnature:basalt");
            Block(0, 2, 0, "wildnature:basalt");
            Block(1, 2, 0, "wildnature:basalt");
            Block(-1, 3, 0, "wildnature:basalt");
            Block(0, 3, 0, "wildnature:basalt_stairs[facing=north,half=top,shape=straight,waterlogged=false]");
            Block(1, 3, 0, "wildnature:basalt");
            Block(-1, 4, 0, "wildnature:basalt_stairs[facing=east,half=bottom,shape=straight,waterlogged=false]");
            Block(0, 4, 0, "wildnature:basalt");
            Block(1, 4, 0, "wildnature:basalt");
            Block(0, 5, 0, "wildnature:basalt_stairs[facing=west,half=bottom,shape=straight,waterlogged=false]");
            Block(1, 5, 0, "wildnature:basalt");
            Block(1, 6, 0, "wildnature:basalt");
            Block(1, 7, 0, "wildnature:basalt_stairs[facing=north,half=bottom,shape=straight,waterlogged=false]");
            Block(-2, 1, 1, "wildnature:basalt");
            Block(-1, 1, 1, "wildnature:basalt");
            Block(1, 1, 1, "wildnature:basalt");
            Block(2, 1, 1, "wildnature:basalt");
            Block(-2, 2, 1, "wildnature:basalt");
            Block(-1, 2, 1, "wildnature:basalt_cobble");
            Block(1, 2, 1, "wildnature:basalt_cobble");
            Block(2, 2, 1, "wildnature:basalt");
            Block(-1, 3, 1, "wildnature:basalt");
            Block(2, 3, 1, "wildnature:basalt");
            Block(-1, 4, 1, "wildnature:basalt");
            Block(2, 4, 1, "wildnature:basalt");
            Block(-1, 5, 1, "wildnature:basalt_stairs[facing=north,half=bottom,shape=straight,waterlogged=false]");
            Block(-1, 1, 2, "wildnature:basalt");
        }

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}