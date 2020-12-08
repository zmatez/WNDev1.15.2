package com.matez.wildnature.world.generation.grid.maps;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.noise.domain.Warp;
import com.matez.wildnature.util.noise.func.DistanceFunc;
import com.matez.wildnature.util.noise.func.EdgeFunc;
import com.matez.wildnature.util.noise.NoiseUtil;
import com.matez.wildnature.util.noise.Vec2f;
import com.matez.wildnature.util.other.Utilities;
import com.matez.wildnature.world.generation.grid.Cell;
import com.matez.wildnature.world.generation.noise.fastNoise.FastNoise;

import java.util.Random;

/*
Idea for GridMap comes from TerraForged. However it was bit modified, still, apply method is the same

 * MIT License
 *
 * Copyright (c) 2020 TerraForged
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
public abstract class GridMap{
    protected final float frequency;
    protected final int gridScale;

    private final float edgeMin;
    private final float edgeMax;
    private final float edgeRange;
    private final int seed;
    private final FastNoise warpX;
    private final FastNoise warpY;
    private final Warp warp;

    private int xMove, zMove;


    /**
     * Used to produce terrains
     * @param seed world seed
     */
    public GridMap(long seed, int gridScale, float frequency){
        this.gridScale = gridScale;
        this.frequency = frequency;

        edgeMin = 0F;
        edgeMax = 1F;
        edgeRange = edgeMax - edgeMin;

        this.seed = (int)seed;

        this.warpX = getWarpX();
        this.warpY = getWarpY();

        this.warp = new Warp(warpX, warpY, 64); //Warping too intense will bring back your old lerping issue as blobs off cells will be placed in other cells.
        Random random = new Random(seed);
        xMove = Utilities.rint(-100_000,100_000,random);
        zMove = Utilities.rint(-100_000,100_000,random);
        WN.LOGGER.debug("Continent move: " + xMove + " " + zMove);
        WN.LOGGER.debug("Loaded GridMap " + this.getClass().getSimpleName() + " with seed " + this.seed + " and move " + xMove + " " + zMove);

    }

    public GridMap(long seed, int gridScale){
        this(seed,gridScale,1F / gridScale * 4);
    }

    public abstract FastNoise getWarpX();

    public abstract FastNoise getWarpY();

    public abstract CellValues applyOutput();

    public void apply(Cell cell, float x, float z) {
        float ox = warp.getOffsetX(xMove + x, zMove + z);
        float oz = warp.getOffsetZ(xMove + x, zMove + z);

        float px = xMove + x + ox;
        float py = zMove + z + oz;

        px *= frequency;
        py *= frequency;

        int cellX = 0;
        int cellY = 0;

        int xr = NoiseUtil.round(px);
        int yr = NoiseUtil.round(py);
        float edgeDistance = 999999.0F;
        float edgeDistance2 = 999999.0F;
        float valueDistance = 999999.0F;
        DistanceFunc dist = DistanceFunc.NATURAL;
        Vec2f center = NoiseUtil.CELL_2D[NoiseUtil.hash2D(seed, xr, yr) & 255];

        for (int dy = -1; dy <= 1; dy++) {
            for (int dx = -1; dx <= 1; dx++) {
                int xi = xr + dx;
                int yi = yr + dy;
                Vec2f vec = NoiseUtil.CELL_2D[NoiseUtil.hash2D(seed, xi, yi) & 255];

                float vecX = xi - px + vec.x;
                float vecY = yi - py + vec.y;

                float distance = dist.apply(vecX, vecY);

                if (distance < valueDistance) {
                    valueDistance = distance;
                    cellX = xi;
                    cellY = yi;
                    center = vec;
                }

                if (distance < edgeDistance2) {
                    edgeDistance2 = Math.max(edgeDistance, distance);
                } else {
                    edgeDistance2 = Math.max(edgeDistance, edgeDistance2);
                }

                edgeDistance = Math.min(edgeDistance, distance);
            }
        }

        applyOutput().apply(cell,
                cellValue(seed, cellX, cellY),
                edgeValue(edgeDistance, edgeDistance2),
                (int) ((cellX + center.x) / frequency),
                (int) ((cellY + center.y) / frequency)
                );
    }

    private float cellValue(int seed, int cellX, int cellY) {
        float value = NoiseUtil.valCoord2D(seed, cellX, cellY);
        return NoiseUtil.map(value, -1, 1, 2);
    }

    private float edgeValue(float distance, float distance2) {
        EdgeFunc edge = EdgeFunc.DISTANCE_2_DIV;
        float value = edge.apply(distance, distance2);
        float edgeValue = 1 - NoiseUtil.map(value, edge.min(), edge.max(), edge.range());

        edgeValue = NoiseUtil.pow(edgeValue, 1.5F);

        if (edgeValue < edgeMin) {
            return 0F;
        }
        if (edgeValue > edgeMax) {
            return 1F;
        }

        return (edgeValue - edgeMin) / edgeRange;
    }


    public static interface CellValues{
        public void apply(Cell cell, float cellIdentity, float cellEdge, int cellX, int cellZ);
    }
}
