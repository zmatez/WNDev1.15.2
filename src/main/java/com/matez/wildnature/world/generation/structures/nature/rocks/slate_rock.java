package com.matez.wildnature.world.generation.structures.nature.rocks;

import com.matez.wildnature.util.config.CommonConfig;
import com.matez.wildnature.util.other.Utilities;
import com.matez.wildnature.world.generation.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

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