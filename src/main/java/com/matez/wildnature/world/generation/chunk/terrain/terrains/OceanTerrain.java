package com.matez.wildnature.world.generation.chunk.terrain.terrains;

import com.matez.wildnature.world.generation.chunk.terrain.Terrain;

public class OceanTerrain extends Terrain {
    static final Category CATEGORY = Category.OCEAN;
    static final float TEMPERATURE = 0.8F;
    static final float MOISTURE = 0.4F;

    public OceanTerrain() {
        super(CATEGORY, TEMPERATURE, MOISTURE);
    }

}
