package com.matez.wildnature.world.generation.chunk.generation.noise.config;

import com.matez.wildnature.world.generation.chunk.generation.noise.NoiseProcessor;

public class NoiseProcessorConfig {
    private final NoiseProcessor processor;
    private final double factor;
    public NoiseProcessorConfig(NoiseProcessor processor, double factor){
        this.processor = processor;
        this.factor = factor;
    }

    public double getFactor() {
        return factor;
    }

    public NoiseProcessor getProcessor() {
        return processor;
    }
}
