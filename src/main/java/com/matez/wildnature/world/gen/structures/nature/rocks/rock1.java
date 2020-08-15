package com.matez.wildnature.world.gen.structures.nature.rocks;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Set;
import java.util.function.Function;

public class rock1 extends SchemFeature {
    public rock1() {
        super();
        terrainIncrease = 1;
    }

    @Override
    public Set<BlockPos> setBlocks() {

        Block(0, 1, 0, "minecraft:stone_slab[type=bottom,waterlogged=false]");
        Block(1, 1, 1, "minecraft:cobblestone_slab[type=bottom,waterlogged=false]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}