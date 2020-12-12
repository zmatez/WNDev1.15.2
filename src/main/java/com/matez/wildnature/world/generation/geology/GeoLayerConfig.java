package com.matez.wildnature.world.generation.geology;

import net.minecraft.block.Block;

public class GeoLayerConfig {

    public Block block;
    public int depth;
    public int offset;
    public int weight;

    public GeoLayerConfig(Block block, int depth, int offset, int weight){
        this.block = block;
        this.depth = depth;
        this.offset = offset;
        this.weight = weight;
    }

}