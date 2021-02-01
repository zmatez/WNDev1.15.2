package com.matez.wildnature.world.generation.geology;

import com.matez.wildnature.world.generation.noise.fastNoise.FastNoiseLite;

import java.util.List;

public class GeoGeneratorConfig {

    public Type type;
    public FastNoiseLite noise;
    public List<GeoLayerConfig> geoLayers;

    public GeoGeneratorConfig(Type type,
                              FastNoiseLite noise,
                              List<GeoLayerConfig> geoLayers
    ){
        this.type = type;
        this.noise = noise;
        this.geoLayers = geoLayers;
    }

    public enum Type{
        basic, random;
    }

}