package com.matez.wildnature.world.generation.grid.maps;

import com.matez.wildnature.world.generation.noise.fastNoise.FastNoise;

public class SmallIslandMap extends GridMap {
    public SmallIslandMap(long seed) {
        super(seed, 250);
    }

    @Override
    public FastNoise getWarpX() {
        FastNoise noise = new FastNoise();
        return noise;
    }

    @Override
    public FastNoise getWarpY() {
        FastNoise noise = new FastNoise();
        return noise;
    }

    @Override
    public CellValues applyOutput() {
        return ((cell, cellIdentity, cellEdge, cellX, cellZ) -> {
            cell.smallIslandCellIdentity = cellIdentity;
            cell.smallIslandCellEdge = cellEdge;
            cell.smallIslandCellX = cellX;
            cell.smallIslandCellZ = cellZ;
        });
    }
}
