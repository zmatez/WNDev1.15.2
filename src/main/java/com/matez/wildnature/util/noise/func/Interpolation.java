package com.matez.wildnature.util.noise.func;

import com.matez.wildnature.util.noise.NoiseUtil;

public enum Interpolation{

    LINEAR {
        public float apply(float f) {
            return f;
        }
    },
    CURVEH {
        public float apply(float f) {
            return NoiseUtil.interpHermite(f);
        }
    },
    CURVEQ {
        public float apply(float f) {
            return NoiseUtil.interpQuintic(f);
        }
    },;

    public abstract float apply(float f);

}
