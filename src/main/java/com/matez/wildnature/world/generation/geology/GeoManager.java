package com.matez.wildnature.world.generation.geology;

import com.matez.wildnature.util.noise.NoiseUtil;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

import java.util.Random;

public class GeoManager {

    private final GeoGenerator generator;
    private final GeoConfig config;
    private final Random random;

    public GeoManager(int seed, GeoConfig geoConfig){

        //Retrieving the config for the current terrain.
        this.config = geoConfig;

        //Creating the GeoGenerator
        this.generator = new GeoGenerator(config);
        this.random = new Random();
        random.setSeed(seed);

    }

    public Random getRandom(){
        return random;
    }

    /**
     * This creates the data, use get to get the produced list.
     * @param dx x Coord
     * @param dy TerrainHeight
     * @param dz Z Coord
     */
    public void applyStrata(int dx, int dy, int dz){

        float index = getIndex(dx, dz);

        if(config.noiseOffset){
            dy += generator.noiseOffset(index, dy);
        }

        if(config.type == GeoConfig.Type.RANDOM){
            generator.generateRandomLayers(random, index);
        }
        if(config.type == GeoConfig.Type.INDEX){
            generator.generateIndexLayers(random, index);
        }
        if(config.type == GeoConfig.Type.MOUNTAIN){
            generator.generateMountainLayers(random, index, dy);
        }

        generator.generateStrata(dy);

    }

    //Re-Ranged FastNoiseOutput for selecting purposes.
    public float getIndex(int dx, int dz){
        float index = config.selectorNoise.GetPerlin(dx, dz);
        return NoiseUtil.range(index, -1, 1,0,1);
    }

    public GeoGenerator getGenerator(){
        return generator;
    }

    /**
     * This is the function within the decoration iterations.
     * @param iy 1-terraineheight iterations.
     * @return Replaces solid (aka stone)
     */
    public BlockState get(int iy){
        if(iy < generator.blockState.size()) { //placing index at zero instead of one
            return generator.blockState.get(iy);
        }else{
            return Blocks.BEDROCK.getDefaultState();
        }
    }

}
