package com.matez.wildnature.world.gen.structures.nature.woods.mangrove;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.IWorldGenerationReader;

import java.util.Set;

public class mangrove4 extends SchemFeature {
    public mangrove4() {
        super();

    }


    public boolean canGrowTree(IWorldGenerationReader world, BlockPos pos, net.minecraftforge.common.IPlantable sapling) {
        return super.canGrowTree(world, pos, getSapling()) || isWater(world, pos);
    }


    @Override
    public Set<BlockPos> setBlocks() {

        Block(0, 8, -3, "wildnature:mangrove_branch[down=false,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(0, 9, -3, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(2, 9, -3, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(1, 10, -3, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(2, 10, -3, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-1, 1, -2, "wildnature:mangrove_branch[down=false,east=true,north=false,south=false,up=false,waterlogged=false,west=false]");
        Block(0, 1, -2, "wildnature:mangrove_log[axis=y]");
        Block(1, 1, -2, "wildnature:mangrove_branch[down=false,east=true,north=false,south=false,up=true,waterlogged=false,west=true]");
        Block(2, 1, -2, "wildnature:mangrove_branch[down=false,east=false,north=false,south=false,up=false,waterlogged=false,west=true]");
        Block(0, 2, -2, "wildnature:mangrove_log[axis=y]");
        Block(1, 2, -2, "wildnature:mangrove_branch[down=true,east=false,north=false,south=false,up=false,waterlogged=false,west=true]");
        Block(0, 3, -2, "wildnature:mangrove_log[axis=y]");
        Block(0, 4, -2, "wildnature:mangrove_log[axis=y]");
        Block(0, 5, -2, "wildnature:mangrove_log[axis=y]");
        Block(0, 6, -2, "wildnature:mangrove_wood");
        Block(2, 6, -2, "wildnature:mangrove_branch[down=false,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(2, 7, -2, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(2, 8, -2, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(0, 9, -2, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(2, 9, -2, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(3, 9, -2, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-1, 10, -2, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(0, 10, -2, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(1, 10, -2, "wildnature:mangrove_wood");
        Block(2, 10, -2, "wildnature:mangrove_branch[down=true,east=true,north=true,south=true,up=false,waterlogged=false,west=true]");
        Block(3, 10, -2, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(1, 11, -2, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(0, 1, -1, "wildnature:mangrove_branch[down=false,east=false,north=true,south=false,up=true,waterlogged=false,west=false]");
        Block(0, 2, -1, "wildnature:mangrove_branch[down=true,east=false,north=true,south=false,up=false,waterlogged=false,west=false]");
        Block(0, 7, -1, "wildnature:mangrove_wood");
        Block(-1, 8, -1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(0, 8, -1, "wildnature:mangrove_log[axis=y]");
        Block(1, 8, -1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(2, 8, -1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-3, 9, -1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-1, 9, -1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(0, 9, -1, "wildnature:mangrove_wood");
        Block(1, 9, -1, "wildnature:mangrove_branch[down=true,east=false,north=false,south=true,up=false,waterlogged=false,west=true]");
        Block(-2, 10, -1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(2, 10, -1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(4, 10, -1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-3, 11, -1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-2, 11, -1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(0, 11, -1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-3, 12, -1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-2, 1, 0, "wildnature:mangrove_branch[down=false,east=true,north=false,south=true,up=false,waterlogged=false,west=false]");
        Block(-1, 1, 0, "wildnature:mangrove_log[axis=y]");
        Block(1, 1, 0, "wildnature:mangrove_log[axis=y]");
        Block(2, 1, 0, "wildnature:mangrove_branch[down=false,east=false,north=false,south=false,up=false,waterlogged=false,west=true]");
        Block(-1, 2, 0, "wildnature:mangrove_log[axis=y]");
        Block(1, 2, 0, "wildnature:mangrove_log[axis=y]");
        Block(-1, 3, 0, "wildnature:mangrove_log[axis=y]");
        Block(0, 3, 0, "wildnature:mangrove_branch[down=false,east=true,north=false,south=true,up=false,waterlogged=false,west=true]");
        Block(1, 3, 0, "wildnature:mangrove_log[axis=y]");
        Block(-1, 4, 0, "wildnature:mangrove_wood");
        Block(1, 4, 0, "wildnature:mangrove_log[axis=y]");
        Block(-1, 5, 0, "wildnature:mangrove_branch[down=true,east=false,north=false,south=false,up=false,waterlogged=false,west=false]");
        Block(0, 5, 0, "wildnature:mangrove_wood");
        Block(1, 5, 0, "wildnature:mangrove_wood");
        Block(0, 6, 0, "wildnature:mangrove_log[axis=y]");
        Block(0, 7, 0, "wildnature:mangrove_log[axis=y]");
        Block(0, 8, 0, "wildnature:mangrove_wood");
        Block(1, 8, 0, "wildnature:mangrove_wood");
        Block(3, 8, 0, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-4, 9, 0, "wildnature:mangrove_branch[down=false,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(-2, 9, 0, "wildnature:mangrove_branch[down=false,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(-1, 9, 0, "wildnature:mangrove_wood");
        Block(0, 9, 0, "wildnature:mangrove_branch[down=true,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(1, 9, 0, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(2, 9, 0, "wildnature:mangrove_wood");
        Block(3, 9, 0, "wildnature:mangrove_branch[down=true,east=true,north=false,south=true,up=true,waterlogged=false,west=true]");
        Block(4, 9, 0, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-4, 10, 0, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-3, 10, 0, "wildnature:mangrove_branch[down=false,east=true,north=false,south=true,up=false,waterlogged=false,west=true]");
        Block(-2, 10, 0, "wildnature:mangrove_branch[down=true,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(-1, 10, 0, "wildnature:mangrove_branch[down=true,east=true,north=false,south=true,up=true,waterlogged=false,west=true]");
        Block(0, 10, 0, "wildnature:mangrove_wood");
        Block(1, 10, 0, "wildnature:mangrove_branch[down=true,east=true,north=false,south=false,up=true,waterlogged=false,west=true]");
        Block(2, 10, 0, "wildnature:mangrove_branch[down=true,east=false,north=false,south=false,up=true,waterlogged=false,west=true]");
        Block(3, 10, 0, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-2, 11, 0, "wildnature:mangrove_branch[down=true,east=true,north=true,south=false,up=true,waterlogged=false,west=false]");
        Block(-1, 11, 0, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(0, 11, 0, "wildnature:mangrove_branch[down=true,east=true,north=true,south=true,up=false,waterlogged=false,west=true]");
        Block(1, 11, 0, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(2, 11, 0, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-2, 12, 0, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-2, 1, 1, "wildnature:mangrove_branch[down=false,east=false,north=true,south=true,up=false,waterlogged=false,west=false]");
        Block(0, 1, 1, "wildnature:mangrove_branch[down=false,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(0, 2, 1, "wildnature:mangrove_branch[down=true,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(0, 3, 1, "wildnature:mangrove_branch[down=true,east=true,north=true,south=false,up=false,waterlogged=false,west=false]");
        Block(1, 3, 1, "wildnature:mangrove_branch[down=false,east=false,north=true,south=true,up=false,waterlogged=false,west=true]");
        Block(-1, 5, 1, "wildnature:mangrove_wood");
        Block(2, 6, 1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(0, 7, 1, "wildnature:mangrove_wood");
        Block(2, 7, 1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(1, 8, 1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(2, 8, 1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-2, 9, 1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-1, 9, 1, "wildnature:mangrove_branch[down=false,east=false,north=false,south=true,up=true,waterlogged=false,west=false]");
        Block(0, 9, 1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(2, 9, 1, "wildnature:mangrove_branch[down=true,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(3, 9, 1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-3, 10, 1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-2, 10, 1, "wildnature:mangrove_branch[down=true,east=true,north=true,south=false,up=false,waterlogged=false,west=true]");
        Block(-1, 10, 1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(0, 10, 1, "wildnature:mangrove_branch[down=true,east=false,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(2, 10, 1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(0, 11, 1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(1, 11, 1, "wildnature:mangrove_wood");
        Block(2, 11, 1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(1, 12, 1, "wildnature:mangrove_branch[down=true,east=true,north=false,south=true,up=true,waterlogged=false,west=false]");
        Block(2, 12, 1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(1, 13, 1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-2, 1, 2, "wildnature:mangrove_log[axis=y]");
        Block(-1, 1, 2, "wildnature:mangrove_branch[down=false,east=false,north=false,south=false,up=false,waterlogged=false,west=true]");
        Block(1, 1, 2, "wildnature:mangrove_branch[down=false,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(-2, 2, 2, "wildnature:mangrove_log[axis=y]");
        Block(1, 2, 2, "wildnature:mangrove_branch[down=true,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(-2, 3, 2, "wildnature:mangrove_log[axis=y]");
        Block(1, 3, 2, "wildnature:mangrove_branch[down=true,east=false,north=true,south=false,up=false,waterlogged=false,west=false]");
        Block(-2, 4, 2, "wildnature:mangrove_wood");
        Block(-2, 5, 2, "wildnature:mangrove_branch[down=true,east=false,north=false,south=false,up=false,waterlogged=false,west=false]");
        Block(0, 6, 2, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-2, 7, 2, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-1, 7, 2, "wildnature:mangrove_branch[down=false,east=true,north=false,south=false,up=true,waterlogged=false,west=true]");
        Block(0, 7, 2, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-2, 8, 2, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-1, 8, 2, "wildnature:mangrove_wood");
        Block(0, 8, 2, "wildnature:mangrove_branch[down=true,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(-2, 9, 2, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-1, 9, 2, "wildnature:mangrove_branch[down=true,east=false,north=true,south=false,up=true,waterlogged=false,west=false]");
        Block(0, 9, 2, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(2, 9, 2, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-1, 10, 2, "wildnature:mangrove_branch[down=true,east=true,north=true,south=true,up=false,waterlogged=false,west=false]");
        Block(0, 10, 2, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(0, 11, 2, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(1, 11, 2, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(2, 11, 2, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(1, 12, 2, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(2, 12, 2, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-2, 9, 3, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(0, 9, 3, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-2, 10, 3, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-1, 10, 3, "wildnature:mangrove_leaves[distance=7,persistent=true]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}