package com.matez.wildnature.world.gen.structures.nature.woods.mangrove;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.IWorldGenerationReader;

import java.util.Set;

public class mangrove_shrub5 extends SchemFeature {
    public mangrove_shrub5() {
        super();

    }


    @Override
    public boolean canGrowTree(IWorldGenerationReader world, BlockPos pos, net.minecraftforge.common.IPlantable sapling) {
        if (!super.canGrowTree(world, pos.down(), getSapling()) && !isWater(world, pos.down())) {
            return false;
        }

        return !isWater(world, pos.up(1));
    }

    @Override
    public Set<BlockPos> setBlocks() {

        Block(1, 1, -1, "wildnature:mangrove_log[axis=y]");
        Block(1, 2, -1, "wildnature:mangrove_log[axis=y]");
        Block(1, 3, -1, "wildnature:mangrove_fence[east=false,north=false,south=false,waterlogged=false,west=false]");
        Block(1, 4, -1, "wildnature:mangrove_fence[east=false,north=false,south=false,waterlogged=false,west=false]");
        Block(-1, 1, 0, "wildnature:mangrove_log[axis=y]");
        Block(-1, 2, 0, "wildnature:mangrove_log[axis=y]");
        Block(-1, 3, 0, "wildnature:mangrove_log[axis=y]");
        Block(1, 3, 0, "wildnature:ebony_leaves[distance=7,persistent=true]");
        Block(-1, 4, 0, "wildnature:mangrove_fence[east=false,north=false,south=false,waterlogged=false,west=false]");
        Block(-1, 5, 0, "wildnature:mangrove_fence[east=false,north=false,south=false,waterlogged=false,west=false]");
        Block(-1, 6, 0, "wildnature:ebony_leaves[distance=7,persistent=true]");
        Block(1, 1, 1, "wildnature:mangrove_log[axis=y]");
        Block(1, 2, 1, "wildnature:mangrove_log[axis=y]");
        Block(-1, 3, 1, "wildnature:ebony_leaves[distance=7,persistent=true]");
        Block(1, 3, 1, "wildnature:mangrove_log[axis=y]");
        Block(1, 4, 1, "wildnature:mangrove_fence[east=false,north=false,south=false,waterlogged=false,west=false]");
        Block(1, 4, 2, "wildnature:ebony_leaves[distance=7,persistent=true]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}