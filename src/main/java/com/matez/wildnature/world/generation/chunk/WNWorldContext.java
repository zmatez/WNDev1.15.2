package com.matez.wildnature.world.generation.chunk;

import com.matez.wildnature.world.generation.chunk.terrain.TerrainProvider;
import com.matez.wildnature.world.generation.grid.Cell;

public class WNWorldContext {
    public final long seed;
    //public final Levels levels;
    //public final  heightmap;
    public final Cell cell;
    public final TerrainProvider terrainProvider;

    public WNWorldContext(long seed){
        this.seed = seed;
        this.cell = new Cell();
        this.terrainProvider = new TerrainProvider(this);
        //this.levels = new Levels();
        //this.heightmap = new YGHeightmap(this);
    }

    private WNWorldContext(WNWorldContext src) {
        this.seed = src.seed;
        this.cell = src.cell;
        this.terrainProvider = src.terrainProvider;
        //this.levels = src.levels;
        //this.heightmap = src.heightmap;
    }


}
