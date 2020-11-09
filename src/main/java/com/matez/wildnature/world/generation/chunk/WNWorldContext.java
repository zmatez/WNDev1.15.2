package com.matez.wildnature.world.generation.chunk;

import com.matez.wildnature.world.generation.chunk.terrain.TerrainProvider;
import com.matez.wildnature.world.generation.grid.Cell;
import com.matez.wildnature.world.generation.heightmap.WNHeightMap;
import net.minecraft.world.storage.WorldInfo;

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
