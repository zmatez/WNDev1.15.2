package com.matez.wildnature.world.generation.grid.maps;

import com.matez.wildnature.world.generation.noise.fastNoise.FastNoise;

public class SubBiomeMap extends GridMap {
    public SubBiomeMap(long seed) {
        super(seed, 500);
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
            cell.subBiomeCellIdentity = cellIdentity;
            cell.subBiomeCellEdge = cellEdge;
            cell.subBiomeCellX = cellX;
            cell.subBiomeCellZ = cellZ;
        });
    }
}
