package com.matez.wildnature.world.generation.grid.maps;

import com.matez.wildnature.util.noise.domain.Warp;
import com.matez.wildnature.util.noise.func.DistanceFunc;
import com.matez.wildnature.util.noise.func.EdgeFunc;
import com.matez.wildnature.util.noise.NoiseUtil;
import com.matez.wildnature.util.noise.Vec2f;
import com.matez.wildnature.world.generation.grid.Cell;
import com.matez.wildnature.world.generation.noise.fastNoise.FastNoise;

public class TerrainMap extends GridMap{
    public TerrainMap(long seed) {
        super(seed, 10_000);
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
            cell.terrainCellIdentity = cellIdentity;
            cell.terrainCellEdge = cellEdge;
            cell.terrainCellX = cellX;
            cell.terrainCellZ = cellZ;
        });
    }
}
