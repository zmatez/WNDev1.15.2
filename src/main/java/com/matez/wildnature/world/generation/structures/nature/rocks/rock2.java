package com.matez.wildnature.world.generation.structures.nature.rocks;

import com.matez.wildnature.world.generation.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class rock2 extends SchemFeature {
    public rock2() {
        super();
        terrainIncrease = 1;
    }

    @Override
    public Set<BlockPos> setBlocks() {

        Block(0, 1, 0, "minecraft:stone");
        Block(0, 2, 0, "minecraft:andesite_slab[type=bottom,waterlogged=false]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}