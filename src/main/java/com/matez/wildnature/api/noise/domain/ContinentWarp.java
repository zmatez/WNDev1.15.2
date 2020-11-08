package com.matez.wildnature.api.noise.domain;

import com.matez.wildnature.util.noise.Vec2f;
import com.matez.wildnature.world.generation.noise.fastNoise.FastNoise;

public class ContinentWarp {

    private final FastNoise x;
    private final FastNoise y;

    public ContinentWarp(FastNoise x, FastNoise y) {
        this.x = x;
        this.y = y;
    }

    public float getOffsetX(float x, float y) {
        return new Vec2f(this.x.GetPerlin(x, y), this.x.GetPerlin(x, y) + new Vec2f(2f, 1.3f).length()).length();
    }

    public float getOffsetY(float x, float y) {
        float xoffset = getOffsetX(x, y);
        return new Vec2f(this.y.GetPerlin(x, y) + 4.0f*xoffset + new Vec2f(1.7f, 9.2f).length(), this.y.GetPerlin(x, y) + 4.0f*xoffset + new Vec2f(8.3f, 2.8f).length()).length();
    }

}
