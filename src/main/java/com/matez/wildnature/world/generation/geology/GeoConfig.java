package com.matez.wildnature.world.generation.geology;

import com.matez.wildnature.util.noise.NoiseUtil;
import com.matez.wildnature.world.generation.noise.fastNoise.FastNoise;
import net.minecraft.block.Block;

import java.util.List;

public class GeoConfig {

    public int minLayers;
    public int maxLayers;
    public int minDepth;
    public int maxDepth;
    public final List<Block> sedimentary;
    public final List<Block> carbonate;
    public final FastNoise selectorNoise;
    public final Type type;
    public final boolean noiseOffset;

    public GeoConfig(int minLayers, int maxLayers, int minDepth, int maxDepth, List<Block> sedimentary, List<Block> carbonate, FastNoise selectorNoise, GeoConfig.Type type, boolean noiseOffset) {
        this.minLayers = minLayers;
        this.maxLayers = maxLayers;
        this.minDepth = minDepth;
        this.maxDepth = maxDepth;
        this.sedimentary = sedimentary;
        this.carbonate = carbonate;
        this.selectorNoise = selectorNoise;
        this.type = type;
        this.noiseOffset = noiseOffset;
    }

    public enum Type {
        RANDOM,
        INDEX,
        MOUNTAIN
    }

    public int getLayers(float index) {
        int range = maxLayers - minLayers;
        return minLayers + NoiseUtil.round(index * range);
    }

    public int getDepth(float index) {
        int range = maxDepth - minDepth;
        return minDepth + NoiseUtil.round(index * range);
    }

    public List<Block> getSedimentary(){
        return sedimentary;
    }

    public List<Block> getCarbonate(){
        return carbonate;
    }

    public FastNoise getSelectorNoise(){
        return selectorNoise;
    }

}