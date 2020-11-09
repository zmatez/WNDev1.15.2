package com.matez.wildnature.world.generation.maps;


import com.matez.wildnature.util.noise.NoiseUtil;

public class Temparature{

    private final float frequency;

    public Temparature(float frequency) {
        this.frequency = frequency;
    }

    public float getValue(float x, float y) {
        y *= frequency;

        final float noise;
        noise = NoiseUtil.sin(y);

        return NoiseUtil.map(noise, -1, 1, 2);
    }

}
