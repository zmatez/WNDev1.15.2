package com.matez.wildnature.world.generation.structures.nature.rocks;

import com.matez.wildnature.world.generation.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

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