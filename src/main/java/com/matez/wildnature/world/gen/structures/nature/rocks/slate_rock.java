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

public class slate_rock extends SchemFeature {
    public slate_rock() {
        super();
        terrainIncrease = 1;
    }

    @Override
    public Set<BlockPos> setBlocks() {
        if (Utilities.rint(0, CommonConfig.rockFormationChance.get()) == 0) {

            Block(0, 0, -5, "wildnature:slate_slab[type=bottom,waterlogged=false]");
            Block(-1, 0, -4, "wildnature:slate_slab[type=bottom,waterlogged=false]");
            Block(0, 0, -4, "wildnature:slate_slab[type=bottom,waterlogged=false]");
            Block(-2, 0, -3, "wildnature:slate");
            Block(-1, 0, -3, "wildnature:slate");
            Block(0, 0, -3, "wildnature:slate");
            Block(1, 0, -3, "wildnature:slate");
            Block(0, 1, -3, "wildnature:slate_slab[type=bottom,waterlogged=false]");
            Block(-2, 1, -2, "wildnature:slate_slab[type=double,waterlogged=false]");
            Block(-1, 1, -2, "wildnature:slate_slab[type=bottom,waterlogged=false]");
            Block(0, 1, -2, "wildnature:slate_slab[type=bottom,waterlogged=false]");
            Block(1, 1, -2, "wildnature:slate_slab[type=double,waterlogged=false]");
            Block(2, 1, -2, "wildnature:slate_slab[type=top,waterlogged=false]");
            Block(-2, 1, -1, "wildnature:slate_slab[type=top,waterlogged=false]");
            Block(-1, 1, -1, "wildnature:slate");
            Block(0, 1, -1, "wildnature:slate");
            Block(1, 1, -1, "wildnature:slate");
            Block(2, 1, -1, "wildnature:slate_slab[type=top,waterlogged=false]");
            Block(-1, 2, -1, "wildnature:slate_slab[type=bottom,waterlogged=false]");
            Block(1, 2, -1, "wildnature:slate_slab[type=bottom,waterlogged=false]");
            Block(-1, 1, 0, "wildnature:slate_slab[type=top,waterlogged=false]");
            Block(0, 1, 0, "wildnature:slate");
            Block(1, 1, 0, "wildnature:slate_slab[type=top,waterlogged=false]");
            Block(-1, 2, 0, "wildnature:slate_slab[type=bottom,waterlogged=false]");
            Block(0, 2, 0, "wildnature:slate_slab[type=double,waterlogged=false]");
            Block(1, 2, 0, "wildnature:slate_slab[type=double,waterlogged=false]");
            Block(2, 2, 0, "wildnature:slate_slab[type=bottom,waterlogged=false]");
            Block(-1, 2, 1, "wildnature:slate_slab[type=double,waterlogged=false]");
            Block(0, 2, 1, "wildnature:slate_slab[type=double,waterlogged=false]");
            Block(1, 2, 1, "wildnature:slate_slab[type=bottom,waterlogged=false]");
            Block(-1, 2, 2, "wildnature:slate_slab[type=top,waterlogged=false]");
            Block(0, 2, 2, "wildnature:slate_slab[type=top,waterlogged=false]");
            Block(1, 2, 2, "wildnature:slate_slab[type=top,waterlogged=false]");
            Block(0, 3, 2, "wildnature:slate_slab[type=bottom,waterlogged=false]");
            Block(1, 2, 3, "wildnature:slate_slab[type=top,waterlogged=false]");
            Block(0, 3, 3, "wildnature:slate_slab[type=bottom,waterlogged=false]");
        }
//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}