package com.matez.wildnature.world.generation.grid.maps;

import com.matez.wildnature.world.generation.noise.fastNoise.FastNoise;

public class BiomeMap extends GridMap {
    public BiomeMap(long seed) {
        super(seed, 2000);
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
            cell.biomeCellIdentity = cellIdentity;
            cell.biomeCellEdge = cellEdge;
            cell.biomeCellX = cellX;
            cell.biomeCellZ = cellZ;
        });
    }
}
