package com.matez.wildnature.world.generation.chunk;

import com.matez.wildnature.world.generation.chunk.terrain.TerrainProvider;
import com.matez.wildnature.world.generation.grid.Cell;
import com.matez.wildnature.world.generation.heightmap.WNHeightMap;
import net.minecraft.world.storage.WorldInfo;

/*
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
public class WNWorldContext {
    private long seed;
    private final WNHeightMap heightmap;
    private final Cell cell;
    private final TerrainProvider terrainProvider;

    public WNWorldContext(long seed){
        this.seed = seed;
        this.cell = new Cell();
        this.terrainProvider = new TerrainProvider(this);
        this.heightmap = new WNHeightMap(this);
    }

    public WNWorldContext(WorldInfo info){
        this.cell = new Cell();
        this.terrainProvider = new TerrainProvider(this);
        this.heightmap = new WNHeightMap(this);
    }

    private WNWorldContext(WNWorldContext src) {
        this.seed = src.seed;
        this.cell = src.cell;
        this.terrainProvider = src.terrainProvider;
        this.heightmap = src.heightmap;
    }

    public TerrainProvider getTerrainProvider() {
        return terrainProvider;
    }

    public WNHeightMap getHeightmap() {
        return heightmap;
    }

    public Cell getCell() {
        return cell;
    }

    public long getSeed() {
        return seed;
    }
}
