package com.matez.wildnature.world.generation.grid.maps;

import com.matez.wildnature.world.generation.noise.fastNoise.FastNoise;

public class BigIslandMap extends GridMap {
    public BigIslandMap(long seed) {
        super(seed, 750);
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
            cell.bigIslandCellIdentity = cellIdentity;
            cell.bigIslandCellEdge = cellEdge;
            cell.bigIslandCellX = cellX;
            cell.bigIslandCellZ = cellZ;
        });
    }
}
