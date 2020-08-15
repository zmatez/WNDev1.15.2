package com.matez.wildnature.world.gen.structures.nature.woods.mangrove;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.IWorldGenerationReader;

import java.util.Set;

public class mangrove3 extends SchemFeature {
    public mangrove3() {
        super();

    }


    public boolean canGrowTree(IWorldGenerationReader world, BlockPos pos, net.minecraftforge.common.IPlantable sapling) {
        return super.canGrowTree(world, pos, getSapling()) || isWater(world, pos);
    }

    @Override
    public Set<BlockPos> setBlocks() {

        Block(0, 7, -4, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(0, 5, -3, "wildnature:mangrove_branch[down=false,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(0, 6, -3, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(1, 6, -3, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(0, 7, -3, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(1, 7, -3, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(2, 7, -3, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(3, 7, -3, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(1, 8, -3, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(1, 1, -2, "wildnature:mangrove_log[axis=y]");
        Block(2, 1, -2, "wildnature:mangrove_branch[down=false,east=false,north=false,south=false,up=false,waterlogged=false,west=true]");
        Block(1, 2, -2, "wildnature:mangrove_log[axis=y]");
        Block(1, 3, -2, "wildnature:mangrove_wood");
        Block(-2, 4, -2, "wildnature:mangrove_branch[down=false,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(-2, 5, -2, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-2, 6, -2, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-1, 6, -2, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(0, 6, -2, "wildnature:mangrove_branch[down=false,east=false,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(2, 6, -2, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(3, 6, -2, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-2, 7, -2, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-1, 7, -2, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(0, 7, -2, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(3, 7, -2, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(0, 8, -2, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(1, 8, -2, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(2, 8, -2, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(0, 1, -1, "wildnature:mangrove_branch[down=false,east=false,north=false,south=true,up=false,waterlogged=false,west=false]");
        Block(0, 3, -1, "wildnature:mangrove_wood");
        Block(0, 4, -1, "wildnature:mangrove_wood");
        Block(0, 5, -1, "wildnature:mangrove_branch[down=true,east=false,north=false,south=true,up=true,waterlogged=false,west=false]");
        Block(3, 5, -1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-1, 6, -1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(0, 6, -1, "wildnature:mangrove_branch[down=true,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
        Block(1, 6, -1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(3, 6, -1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-1, 7, -1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(0, 7, -1, "wildnature:mangrove_branch[down=true,east=true,north=true,south=true,up=false,waterlogged=false,west=true]");
        Block(1, 7, -1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(2, 7, -1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-1, 8, -1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(1, 8, -1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-3, 1, 0, "wildnature:mangrove_branch[down=false,east=true,north=false,south=false,up=false,waterlogged=false,west=false]");
        Block(-2, 1, 0, "wildnature:mangrove_log[axis=y]");
        Block(0, 1, 0, "wildnature:mangrove_log[axis=y]");
        Block(-2, 2, 0, "wildnature:mangrove_wood");
        Block(0, 2, 0, "wildnature:mangrove_log[axis=y]");
        Block(-1, 3, 0, "wildnature:mangrove_wood");
        Block(0, 3, 0, "wildnature:mangrove_log[axis=y]");
        Block(-1, 4, 0, "wildnature:mangrove_branch[down=true,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(0, 4, 0, "wildnature:mangrove_log[axis=y]");
        Block(-1, 5, 0, "wildnature:mangrove_wood");
        Block(0, 5, 0, "wildnature:mangrove_wood");
        Block(1, 5, 0, "wildnature:mangrove_branch[down=false,east=true,north=false,south=false,up=true,waterlogged=false,west=true]");
        Block(2, 5, 0, "wildnature:mangrove_branch[down=false,east=false,north=false,south=true,up=true,waterlogged=false,west=true]");
        Block(-2, 6, 0, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-1, 6, 0, "wildnature:mangrove_branch[down=true,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(0, 6, 0, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(1, 6, 0, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(2, 6, 0, "wildnature:mangrove_branch[down=true,east=false,north=false,south=true,up=true,waterlogged=false,west=true]");
        Block(-2, 7, 0, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-1, 7, 0, "wildnature:mangrove_branch[down=true,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(0, 7, 0, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(1, 7, 0, "wildnature:mangrove_branch[down=true,east=false,north=false,south=false,up=false,waterlogged=false,west=false]");
        Block(2, 7, 0, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(3, 7, 0, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-1, 8, 0, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(0, 8, 0, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(2, 8, 0, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(1, 1, 1, "wildnature:mangrove_log[axis=y]");
        Block(2, 1, 1, "wildnature:mangrove_branch[down=false,east=false,north=false,south=false,up=false,waterlogged=false,west=true]");
        Block(0, 2, 1, "wildnature:mangrove_wood");
        Block(1, 2, 1, "wildnature:mangrove_wood");
        Block(1, 3, 1, "wildnature:mangrove_branch[down=true,east=false,north=false,south=false,up=false,waterlogged=false,west=false]");
        Block(2, 4, 1, "wildnature:mangrove_branch[down=false,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(-3, 5, 1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(0, 5, 1, "wildnature:mangrove_branch[down=false,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(2, 5, 1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-3, 6, 1, "wildnature:mangrove_branch[down=true,east=true,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(-2, 6, 1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-1, 6, 1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(0, 6, 1, "wildnature:mangrove_branch[down=true,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
        Block(2, 6, 1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(3, 6, 1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-3, 7, 1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-2, 7, 1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(0, 7, 1, "wildnature:mangrove_branch[down=true,east=true,north=true,south=true,up=true,waterlogged=false,west=false]");
        Block(1, 7, 1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(0, 8, 1, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-2, 1, 2, "wildnature:mangrove_branch[down=false,east=true,north=false,south=false,up=false,waterlogged=false,west=false]");
        Block(-1, 1, 2, "wildnature:mangrove_log[axis=y]");
        Block(1, 1, 2, "wildnature:mangrove_branch[down=false,east=false,north=true,south=false,up=false,waterlogged=false,west=false]");
        Block(-1, 2, 2, "wildnature:mangrove_wood");
        Block(0, 5, 2, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(0, 6, 2, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(-2, 7, 2, "wildnature:mangrove_leaves[distance=7,persistent=true]");
        Block(0, 7, 2, "wildnature:mangrove_leaves[distance=7,persistent=true]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}