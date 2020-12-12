package com.matez.wildnature.world.generation.geology;

import com.matez.wildnature.world.generation.noise.fastNoise.FastNoiseLite;

import java.util.List;

public class GeoGeneratorConfig {

    public Type type;
    public FastNoiseLite noise;
    public List<GeoLayerConfig> soil;
    public List<GeoLayerConfig> sedimentary;
    public List<GeoLayerConfig> carbonate;

    public GeoGeneratorConfig(Type type,
                              FastNoiseLite noise,
                              List<GeoLayerConfig> soil,
                              List<GeoLayerConfig> sedimentary,
                              List<GeoLayerConfig> carbonate
    ){
        this.type = type;
        this.noise = noise;
        this.soil = soil;
        this.sedimentary = sedimentary;
        this.carbonate = carbonate;
    }

    public enum Type{
        basic, random;
    }

}