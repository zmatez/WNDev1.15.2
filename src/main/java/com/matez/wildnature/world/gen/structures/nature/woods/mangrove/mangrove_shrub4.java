package com.matez.wildnature.world.gen.structures.nature.woods.mangrove;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.IWorldGenerationReader;

import java.util.Set;

public class mangrove_shrub4 extends SchemFeature {
    public mangrove_shrub4() {
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

        Block(0, 1, -1, "wildnature:mangrove_branch[down=false,east=false,north=false,south=true,up=true,waterlogged=false,west=false]");
        Block(0, 2, -1, "wildnature:mangrove_branch[down=true,east=false,north=false,south=true,up=true,waterlogged=false,west=false]");
        Block(0, 3, -1, "wildnature:mangrove_branch[down=true,east=true,north=false,south=true,up=true,waterlogged=false,west=false]");
        Block(1, 3, -1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(0, 4, -1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-1, 1, 0, "wildnature:mangrove_branch[down=false,east=true,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(0, 1, 0, "wildnature:mangrove_branch[down=true,east=true,north=true,south=false,up=true,waterlogged=false,west=true]");
        Block(1, 1, 0, "wildnature:mangrove_branch[down=false,east=false,north=false,south=false,up=true,waterlogged=false,west=true]");
        Block(-1, 2, 0, "wildnature:mangrove_branch[down=true,east=true,north=false,south=true,up=true,waterlogged=false,west=false]");
        Block(0, 2, 0, "wildnature:mangrove_branch[down=true,east=true,north=true,south=false,up=true,waterlogged=false,west=true]");
        Block(1, 2, 0, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-1, 3, 0, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(0, 3, 0, "wildnature:mangrove_branch[down=true,east=false,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(0, 4, 0, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-1, 2, 1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(0, 3, 1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-1, 4, 1, "wildnature:mangrove_leaves[distance=7,persistent=true]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}