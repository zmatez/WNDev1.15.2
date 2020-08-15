package com.matez.wildnature.world.gen.structures.nature.woods.glowing_cave_oak;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.IWorldGenerationReader;

import java.util.Set;

public class glowing_cave_oak_1 extends SchemFeature {
    public glowing_cave_oak_1() {
        super();

    }


    public boolean canGrowTree(IWorldGenerationReader world, BlockPos pos, net.minecraftforge.common.IPlantable sapling) {
        return super.canGrowTree(world, pos, getSapling()) || isWater(world, pos);
    }

    @Override
    public Set<BlockPos> setBlocks() {

        Block(-1, 12, -3, LEAVES);
        Block(0, 12, -3, LEAVES);
        Block(1, 12, -3, LEAVES);
        Block(-2, 9, -2, LEAVES);
        Block(-2, 10, -2, LEAVES);
        Block(0, 10, -2, LEAVES);
        Block(-2, 11, -2, LEAVES);
        Block(0, 11, -2, LEAVES);
        Block(-3, 12, -2, LEAVES);
        Block(-2, 12, -2, LEAVES);
        Block(-1, 12, -2, LEAVES);
        Block(0, 12, -2, LEAVES);
        Block(1, 12, -2, LEAVES);
        Block(2, 12, -2, LEAVES);
        Block(3, 12, -2, LEAVES);
        Block(4, 12, -2, LEAVES);
        Block(0, 1, -1, "wildnature:glowing_cave_oak_log[axis=y]");
        Block(1, 1, -1, "wildnature:glowing_cave_oak_log[axis=y]");
        Block(0, 2, -1, "wildnature:glowing_cave_oak_log[axis=y]");
        Block(1, 2, -1, "wildnature:glowing_cave_oak_log[axis=y]");
        Block(1, 3, -1, "wildnature:glowing_cave_oak_log[axis=y]");
        Block(1, 10, -1, LEAVES);
        Block(0, 11, -1, LEAVES);
        Block(1, 11, -1, LEAVES);
        Block(2, 11, -1, LEAVES);
        Block(3, 11, -1, "wildnature:glowing_cave_oak_log[axis=y]");
        Block(4, 11, -1, LEAVES);
        Block(-3, 12, -1, LEAVES);
        Block(-2, 12, -1, LEAVES);
        Block(-1, 12, -1, LEAVES);
        Block(0, 12, -1, LEAVES);
        Block(1, 12, -1, LEAVES);
        Block(2, 12, -1, LEAVES);
        Block(3, 12, -1, LEAVES);
        Block(4, 12, -1, LEAVES);
        Block(-2, 13, -1, LEAVES);
        Block(-1, 13, -1, LEAVES);
        Block(0, 13, -1, LEAVES);
        Block(1, 13, -1, LEAVES);
        Block(2, 13, -1, LEAVES);
        Block(-1, 1, 0, "wildnature:glowing_cave_oak_log[axis=y]");
        Block(0, 1, 0, "wildnature:glowing_cave_oak_log[axis=y]");
        Block(1, 1, 0, "wildnature:glowing_cave_oak_log[axis=y]");
        Block(0, 2, 0, "wildnature:glowing_cave_oak_log[axis=y]");
        Block(1, 2, 0, "wildnature:glowing_cave_oak_log[axis=y]");
        Block(0, 3, 0, "wildnature:glowing_cave_oak_log[axis=y]");
        Block(1, 3, 0, "wildnature:glowing_cave_oak_log[axis=y]");
        Block(0, 4, 0, "wildnature:glowing_cave_oak_log[axis=y]");
        Block(1, 4, 0, "wildnature:glowing_cave_oak_log[axis=y]");
        Block(0, 5, 0, "wildnature:glowing_cave_oak_log[axis=y]");
        Block(0, 6, 0, "wildnature:glowing_cave_oak_log[axis=y]");
        Block(0, 7, 0, "wildnature:glowing_cave_oak_log[axis=y]");
        Block(0, 8, 0, "wildnature:glowing_cave_oak_log[axis=y]");
        Block(0, 9, 0, "wildnature:glowing_cave_oak_log[axis=y]");
        Block(1, 9, 0, LEAVES);
        Block(-2, 10, 0, LEAVES);
        Block(-1, 10, 0, "wildnature:glowing_cave_oak_log[axis=x]");
        Block(0, 10, 0, "wildnature:glowing_cave_oak_log[axis=y]");
        Block(1, 10, 0, "wildnature:glowing_cave_oak_log[axis=x]");
        Block(2, 10, 0, "wildnature:glowing_cave_oak_log[axis=x]");
        Block(-3, 11, 0, LEAVES);
        Block(-2, 11, 0, "wildnature:glowing_cave_oak_log[axis=y]");
        Block(-1, 11, 0, LEAVES);
        Block(0, 11, 0, "wildnature:glowing_cave_oak_log[axis=y]");
        Block(1, 11, 0, LEAVES);
        Block(2, 11, 0, LEAVES);
        Block(-4, 12, 0, LEAVES);
        Block(-3, 12, 0, LEAVES);
        Block(-2, 12, 0, LEAVES);
        Block(-1, 12, 0, LEAVES);
        Block(0, 12, 0, LEAVES);
        Block(1, 12, 0, LEAVES);
        Block(2, 12, 0, LEAVES);
        Block(3, 12, 0, LEAVES);
        Block(4, 12, 0, LEAVES);
        Block(-3, 13, 0, LEAVES);
        Block(-2, 13, 0, LEAVES);
        Block(-1, 13, 0, LEAVES);
        Block(0, 13, 0, LEAVES);
        Block(1, 13, 0, LEAVES);
        Block(2, 13, 0, LEAVES);
        Block(0, 1, 1, "wildnature:glowing_cave_oak_log[axis=y]");
        Block(0, 2, 1, "wildnature:glowing_cave_oak_log[axis=y]");
        Block(0, 3, 1, "wildnature:glowing_cave_oak_log[axis=y]");
        Block(0, 9, 1, "wildnature:glowing_cave_oak_log[axis=z]");
        Block(-1, 10, 1, LEAVES);
        Block(0, 10, 1, LEAVES);
        Block(2, 10, 1, LEAVES);
        Block(-2, 11, 1, LEAVES);
        Block(-1, 11, 1, LEAVES);
        Block(0, 11, 1, LEAVES);
        Block(2, 11, 1, LEAVES);
        Block(-4, 12, 1, LEAVES);
        Block(-3, 12, 1, LEAVES);
        Block(-2, 12, 1, LEAVES);
        Block(-1, 12, 1, LEAVES);
        Block(0, 12, 1, LEAVES);
        Block(1, 12, 1, LEAVES);
        Block(2, 12, 1, LEAVES);
        Block(3, 12, 1, LEAVES);
        Block(4, 12, 1, LEAVES);
        Block(-4, 13, 1, LEAVES);
        Block(-3, 13, 1, LEAVES);
        Block(-2, 13, 1, LEAVES);
        Block(-1, 13, 1, LEAVES);
        Block(0, 13, 1, LEAVES);
        Block(1, 13, 1, LEAVES);
        Block(2, 13, 1, LEAVES);
        Block(-1, 14, 1, LEAVES);
        Block(0, 14, 1, LEAVES);
        Block(1, 14, 1, LEAVES);
        Block(0, 9, 2, "wildnature:glowing_cave_oak_log[axis=z]");
        Block(-4, 11, 2, LEAVES);
        Block(-1, 11, 2, LEAVES);
        Block(0, 11, 2, LEAVES);
        Block(-4, 12, 2, LEAVES);
        Block(-3, 12, 2, LEAVES);
        Block(-2, 12, 2, LEAVES);
        Block(-1, 12, 2, LEAVES);
        Block(0, 12, 2, LEAVES);
        Block(1, 12, 2, LEAVES);
        Block(2, 12, 2, LEAVES);
        Block(3, 12, 2, LEAVES);
        Block(-3, 13, 2, LEAVES);
        Block(-2, 13, 2, LEAVES);
        Block(-1, 13, 2, LEAVES);
        Block(0, 13, 2, LEAVES);
        Block(1, 13, 2, LEAVES);
        Block(2, 13, 2, LEAVES);
        Block(0, 14, 2, LEAVES);
        Block(1, 14, 2, LEAVES);
        Block(0, 10, 3, "wildnature:glowing_cave_oak_log[axis=y]");
        Block(-3, 12, 3, LEAVES);
        Block(-2, 12, 3, LEAVES);
        Block(-1, 12, 3, LEAVES);
        Block(0, 12, 3, LEAVES);
        Block(1, 12, 3, LEAVES);
        Block(2, 12, 3, LEAVES);
        Block(3, 12, 3, LEAVES);
        Block(-2, 13, 3, LEAVES);
        Block(-1, 13, 3, LEAVES);
        Block(0, 13, 3, LEAVES);
        Block(1, 13, 3, LEAVES);
        Block(-1, 14, 3, LEAVES);
        Block(0, 14, 3, LEAVES);
        Block(-1, 11, 4, LEAVES);
        Block(0, 11, 4, "wildnature:glowing_cave_oak_log[axis=y]");
        Block(-3, 12, 4, LEAVES);
        Block(-2, 12, 4, LEAVES);
        Block(-1, 12, 4, LEAVES);
        Block(0, 12, 4, LEAVES);
        Block(1, 12, 4, LEAVES);
        Block(2, 12, 4, LEAVES);
        Block(3, 12, 4, LEAVES);
        Block(-2, 13, 4, LEAVES);
        Block(-1, 13, 4, LEAVES);
        Block(0, 13, 4, LEAVES);
        Block(0, 14, 4, LEAVES);
        Block(0, 11, 5, LEAVES);
        Block(-2, 12, 5, LEAVES);
        Block(-1, 12, 5, LEAVES);
        Block(0, 12, 5, LEAVES);
        Block(1, 12, 5, LEAVES);
        Block(-1, 12, 6, LEAVES);

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}