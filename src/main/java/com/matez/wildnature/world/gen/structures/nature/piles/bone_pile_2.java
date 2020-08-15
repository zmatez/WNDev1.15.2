package com.matez.wildnature.world.gen.structures.nature.piles;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import net.minecraft.util.math.BlockPos;

import java.util.Set;


public class bone_pile_2 extends SchemFeature {
    public bone_pile_2() {
        super();
        terrainIncrease = 1;
    }

    @Override
    public Set<BlockPos> setBlocks() {

        Block(0, 1, -1, "minecraft:coarse_dirt");
        Block(1, 1, -1, "minecraft:coarse_dirt");
        Block(2, 1, -1, "minecraft:coarse_dirt");
        Block(3, 1, -1, "minecraft:coarse_dirt");
        Block(-2, 1, 0, "minecraft:coarse_dirt");
        Block(-1, 1, 0, "minecraft:stone");
        Block(0, 1, 0, "minecraft:stone");
        Block(1, 1, 0, "minecraft:stone");
        Block(2, 1, 0, "minecraft:coarse_dirt");
        Block(3, 1, 0, "minecraft:stone");
        Block(-1, 2, 0, "wildnature:pebble");
        Block(0, 2, 0, "minecraft:stone");
        Block(1, 2, 0, "minecraft:stone");
        Block(2, 2, 0, "minecraft:stone");
        Block(3, 2, 0, "wildnature:pebble");
        Block(0, 3, 0, "minecraft:coarse_dirt");
        Block(1, 3, 0, "wildnature:lightning_bug[facing=east]");
        Block(2, 3, 0, "wildnature:pebble");
        Block(-3, 1, 1, "minecraft:stone");
        Block(-2, 1, 1, "minecraft:bone_block[axis=x]");
        Block(-1, 1, 1, "minecraft:stone");
        Block(0, 1, 1, "minecraft:bone_block[axis=z]");
        Block(1, 1, 1, "minecraft:coarse_dirt");
        Block(2, 1, 1, "minecraft:bone_block[axis=x]");
        Block(3, 1, 1, "minecraft:coarse_dirt");
        Block(-3, 2, 1, "wildnature:pebble");
        Block(-2, 2, 1, "minecraft:bone_block[axis=y]");
        Block(-1, 2, 1, "minecraft:coarse_dirt");
        Block(0, 2, 1, "minecraft:bone_block[axis=y]");
        Block(1, 2, 1, "minecraft:stone");
        Block(2, 2, 1, "minecraft:bone_block[axis=y]");
        Block(3, 2, 1, "minecraft:stone");
        Block(0, 3, 1, "minecraft:stone");
        Block(1, 3, 1, "wildnature:pebble");
        Block(2, 3, 1, "minecraft:coarse_dirt");
        Block(0, 4, 1, "wildnature:pebble");
        Block(-4, 1, 2, "minecraft:coarse_dirt");
        Block(-3, 1, 2, "minecraft:stone");
        Block(-2, 1, 2, "minecraft:stone");
        Block(-1, 1, 2, "minecraft:coarse_dirt");
        Block(0, 1, 2, "minecraft:stone");
        Block(1, 1, 2, "minecraft:stone");
        Block(2, 1, 2, "minecraft:coarse_dirt");
        Block(3, 1, 2, "minecraft:stone");
        Block(4, 1, 2, "minecraft:coarse_dirt");
        Block(-3, 2, 2, "wildnature:pebble");
        Block(-2, 2, 2, "minecraft:coarse_dirt");
        Block(-1, 2, 2, "minecraft:coarse_dirt");
        Block(0, 2, 2, "minecraft:coarse_dirt");
        Block(1, 2, 2, "minecraft:coarse_dirt");
        Block(2, 2, 2, "minecraft:stone");
        Block(3, 2, 2, "minecraft:stone");
        Block(-2, 3, 2, "minecraft:bone_block[axis=y]");
        Block(-1, 3, 2, "minecraft:stone");
        Block(0, 3, 2, "minecraft:bone_block[axis=y]");
        Block(1, 3, 2, "minecraft:coarse_dirt");
        Block(2, 3, 2, "minecraft:bone_block[axis=y]");
        Block(3, 3, 2, "wildnature:pebble");
        Block(-1, 4, 2, "wildnature:pebble");
        Block(0, 4, 2, "minecraft:coarse_dirt");
        Block(-3, 1, 3, "minecraft:coarse_dirt");
        Block(-2, 1, 3, "minecraft:bone_block[axis=x]");
        Block(-1, 1, 3, "minecraft:stone");
        Block(0, 1, 3, "minecraft:bone_block[axis=x]");
        Block(1, 1, 3, "minecraft:coarse_dirt");
        Block(2, 1, 3, "minecraft:bone_block[axis=x]");
        Block(3, 1, 3, "minecraft:coarse_dirt");
        Block(-2, 2, 3, "minecraft:bone_block[axis=y]");
        Block(-1, 2, 3, "minecraft:stone");
        Block(0, 2, 3, "minecraft:bone_block[axis=y]");
        Block(1, 2, 3, "minecraft:stone");
        Block(2, 2, 3, "minecraft:bone_block[axis=y]");
        Block(3, 2, 3, "minecraft:coarse_dirt");
        Block(0, 3, 3, "minecraft:coarse_dirt");
        Block(2, 3, 3, "minecraft:coarse_dirt");
        Block(3, 3, 3, "wildnature:lightning_bug[facing=up]");
        Block(-2, 1, 4, "minecraft:stone");
        Block(-1, 1, 4, "minecraft:coarse_dirt");
        Block(0, 1, 4, "minecraft:coarse_dirt");
        Block(1, 1, 4, "minecraft:stone");
        Block(2, 1, 4, "minecraft:coarse_dirt");
        Block(3, 1, 4, "minecraft:coarse_dirt");
        Block(-1, 2, 4, "minecraft:stone");
        Block(0, 2, 4, "minecraft:coarse_dirt");
        Block(1, 2, 4, "wildnature:pebble");
        Block(2, 2, 4, "minecraft:stone");
        Block(-1, 3, 4, "wildnature:pebble");
        Block(2, 3, 4, "wildnature:pebble");
        Block(2, 1, 5, "minecraft:stone");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
        return super.setBlocks();
    }
}