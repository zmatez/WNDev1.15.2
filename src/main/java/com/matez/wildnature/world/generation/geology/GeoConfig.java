package com.matez.wildnature.world.generation.geology;

import com.matez.wildnature.util.noise.NoiseUtil;
import com.matez.wildnature.world.generation.noise.fastNoise.FastNoise;
import net.minecraft.block.Block;

import java.util.List;

public class GeoConfig {

    public final Type type;
    public final FastNoise selectorNoise;
    public final List<Block> sedimentary;
    public int sedimentaryLayers;
    public int sedimentaryDepth;
    public int sedimentaryOffset;
    public final List<Block> carbonate;
    public int carbonateLayers;
    public int carbonateDepth;
    public int carbonateOffset;

    //While configuring make sure:
    //LayerSize-Offset is not below 0
    //Depth-Offset is not below 0
    //SelectorNoise can't fall below 0 if it is used for indexing Lists.
    public GeoConfig(
            GeoConfig.Type type, FastNoise selectorNoise,
            List<Block> sedimentary, int sedimentaryLayers, int sedimentaryDepth, int sedimentaryOffset,
            List<Block> carbonate, int carbonateLayers, int carbonateDepth, int carbonateOffset
    ){
        this.type = type;
        this.selectorNoise = selectorNoise;
        this.sedimentary = sedimentary;
        this.sedimentaryLayers = sedimentaryLayers;
        this.sedimentaryDepth = sedimentaryDepth;
        this.sedimentaryOffset = sedimentaryOffset;
        this.carbonate = carbonate;
        this.carbonateLayers = carbonateLayers;
        this.carbonateDepth = carbonateDepth;
        this.carbonateOffset = carbonateOffset;
    }

    public enum Type {
        RANDOM,
        INDEX,
        MOUNTAIN
    }

    public int getLayers(float index) {
        return NoiseUtil.round((sedimentaryLayers + index*sedimentaryOffset) + (carbonateLayers + index*carbonateOffset));
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