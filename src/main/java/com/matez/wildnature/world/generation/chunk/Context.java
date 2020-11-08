package com.matez.wildnature.world.generation.chunk;

import com.matez.wildnature.world.generation.grid.Cell;

public class Context {

    public final int seed;
    //public final Levels levels;
    //public final YGHeightmap heightmap;
    public final Cell cell;
    //public final TerrainProvider terrainProvider;

    public Context(int seed){
        this.seed = seed;
        this.cell = new Cell();
        //this.terrainProvider = new TerrainProvider(this, new TerrainRegistery());
        //this.levels = new Levels();
        //this.heightmap = new YGHeightmap(this);
    }

    private Context(Context src) {
        this.seed = src.seed;
        this.cell = src.cell;
        //this.terrainProvider = src.terrainProvider;
        //this.levels = src.levels;
        //this.heightmap = src.heightmap;
    }

}
