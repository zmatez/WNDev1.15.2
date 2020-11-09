package com.matez.wildnature.world.generation.chunk.terrain.terrains;

import com.matez.wildnature.world.generation.chunk.terrain.Terrain;
import com.matez.wildnature.world.generation.geology.GeoConfig;
import com.matez.wildnature.world.generation.noise.fastNoise.FastNoise;
import net.minecraft.block.Block;

import java.util.Arrays;
import java.util.List;

public class PlainTerrain extends Terrain {

    static final Category CATEGORY = Category.LOWLANDS;
    static final float TEMPERATURE = 0.8F;
    static final float MOISTURE = 0.4F;

    public PlainTerrain() {
        super(CATEGORY, TEMPERATURE, MOISTURE);
    }

}
