package com.matez.wildnature.world.generation.chunk.terrain;

import com.matez.wildnature.world.generation.grid.Cell;

public abstract class Terrain {
    public Terrain.Category category;
    public Terrain terrain;
    public float temparature;
    public float moisture;

    public Terrain(Category category){
        this.category = category;
        this.terrain = this;
    }

    public enum Category {
        VOID,
        OCEAN,
        SEA,
        SHORE,
        LOWLANDS,
        MIDLANDS,
        HIGHLANDS,
        MOUNTAINS
    }

    public Terrain.Category getCategory(){
        return category;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    //public abstract GeoConfig getConfig(int seed);

    public void apply(Cell cell, float dx, float dy){
        //cell.value = TerrainModule(369).GetValue(dx, dy);
    }

    //Used for forming cliffs.
    public boolean edgeDistortion(){
        return false;
    }

}