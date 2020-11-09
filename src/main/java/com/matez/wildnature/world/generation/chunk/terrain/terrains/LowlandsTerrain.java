package com.matez.wildnature.world.generation.chunk.terrain.terrains;

import com.matez.wildnature.world.generation.chunk.terrain.Terrain;
import com.matez.wildnature.world.generation.geology.GeoConfig;
import com.matez.wildnature.world.generation.noise.fastNoise.FastNoise;
import net.minecraft.block.Block;

import java.util.Arrays;
import java.util.List;

public class LowlandsTerrain extends Terrain {
    static final Category CATEGORY = Category.LOWLANDS;

    public LowlandsTerrain() {
        super(CATEGORY);
    }

}
