/*
 *
 * MIT License
 *
 * Copyright (c) 2020 TerraForged
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.matez.wildnature.util.noise.domain;

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
