package com.matez.wildnature.util.noise.domain;

import com.matez.wildnature.world.generation.noise.fastNoise.FastNoise;

public class Warp {

    /**
     * Based on: http://www.nolithius.com/articles/world-generation/world-generation-techniques-domain-warping
     * /2 after getPerlin() will smooth the overall effect a bit btw (in case you need that).
     */

    private final FastNoise x;
    private final FastNoise z;
    private final float power;

    public Warp(FastNoise x, FastNoise z, float power) {
        this.x = x;
        this.z = z;
        this.power = power;
    }

    public float getOffsetX(float x, float z) {
        return this.x.GetPerlin(x, z) * this.power;
    }

    public float getOffsetZ(float x, float z) {
        return this.z.GetPerlin(x, z) * this.power;
    }

}
