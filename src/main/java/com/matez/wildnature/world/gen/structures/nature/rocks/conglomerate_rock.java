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

public class conglomerate_rock extends SchemFeature {
    public conglomerate_rock() {
        super();
        terrainIncrease = 1;
    }

    @Override
    public Set<BlockPos> setBlocks() {
        if (Utilities.rint(0, CommonConfig.rockFormationChance.get()) == 0) {

            Block(-1, 1, -3, "wildnature:conglomerate");
            Block(0, 1, -3, "wildnature:conglomerate");
            Block(-1, 2, -3, "wildnature:conglomerate_slab[type=bottom,waterlogged=false]");
            Block(0, 4, -3, "wildnature:conglomerate");
            Block(0, 5, -3, "wildnature:conglomerate");
            Block(0, 6, -3, "wildnature:conglomerate_slab[type=bottom,waterlogged=false]");
            Block(-2, 1, -2, "wildnature:conglomerate_slab[type=bottom,waterlogged=false]");
            Block(-1, 1, -2, "wildnature:conglomerate");
            Block(0, 1, -2, "wildnature:conglomerate");
            Block(-1, 2, -2, "wildnature:conglomerate");
            Block(0, 2, -2, "wildnature:conglomerate");
            Block(1, 2, -2, "wildnature:conglomerate");
            Block(0, 3, -2, "wildnature:conglomerate");
            Block(1, 3, -2, "wildnature:conglomerate");
            Block(0, 4, -2, "wildnature:conglomerate");
            Block(0, 5, -2, "wildnature:conglomerate");
            Block(-1, 1, -1, "wildnature:conglomerate");
            Block(0, 1, -1, "wildnature:conglomerate");
            Block(1, 1, -1, "wildnature:conglomerate_slab[type=bottom,waterlogged=false]");
            Block(-1, 2, -1, "wildnature:conglomerate");
            Block(0, 2, -1, "wildnature:conglomerate");
            Block(1, 2, -1, "wildnature:conglomerate_slab[type=top,waterlogged=false]");
            Block(-1, 3, -1, "wildnature:conglomerate");
            Block(0, 3, -1, "wildnature:conglomerate");
            Block(1, 3, -1, "wildnature:conglomerate");
            Block(0, 4, -1, "wildnature:conglomerate");
            Block(1, 4, -1, "wildnature:conglomerate");
            Block(0, 5, -1, "wildnature:conglomerate_slab[type=bottom,waterlogged=false]");
            Block(1, 5, -1, "wildnature:conglomerate");
            Block(1, 6, -1, "wildnature:conglomerate_slab[type=bottom,waterlogged=false]");
            Block(-1, 1, 0, "wildnature:conglomerate");
            Block(0, 1, 0, "wildnature:conglomerate");
            Block(-1, 2, 0, "wildnature:conglomerate");
            Block(0, 2, 0, "wildnature:conglomerate");
            Block(-1, 3, 0, "wildnature:conglomerate_slab[type=bottom,waterlogged=false]");
            Block(0, 3, 0, "wildnature:conglomerate");
            Block(1, 3, 0, "wildnature:conglomerate");
            Block(0, 4, 0, "wildnature:conglomerate");
            Block(1, 4, 0, "wildnature:conglomerate");
            Block(1, 5, 0, "wildnature:conglomerate");
            Block(-1, 1, 1, "wildnature:conglomerate");
            Block(0, 1, 1, "wildnature:conglomerate");
            Block(1, 1, 1, "wildnature:conglomerate_slab[type=bottom,waterlogged=false]");
            Block(0, 2, 1, "wildnature:conglomerate");
            Block(0, 3, 1, "wildnature:conglomerate_slab[type=bottom,waterlogged=false]");
            Block(0, 4, 1, "wildnature:conglomerate");
            Block(0, 5, 1, "wildnature:conglomerate_slab[type=bottom,waterlogged=false]");
            Block(0, 1, 2, "wildnature:conglomerate");
            Block(0, 2, 2, "wildnature:conglomerate_slab[type=bottom,waterlogged=false]");
        }
//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}