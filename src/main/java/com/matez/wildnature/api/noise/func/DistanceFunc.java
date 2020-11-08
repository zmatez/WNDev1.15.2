package com.matez.wildnature.api.noise.func;

public enum DistanceFunc {
    EUCLIDEAN {
        @Override
        public float apply(float vecX, float vecY) {
            return vecX * vecX + vecY * vecY;
        }
    },
    MANHATTAN {
        @Override
        public float apply(float vecX, float vecY) {
            return Math.abs(vecX) + Math.abs(vecY);
        }
    },
    NATURAL {
        @Override
        public float apply(float vecX, float vecY) {
            return (Math.abs(vecX) + Math.abs(vecY)) + (vecX * vecX + vecY * vecY);
        }
    },
    ;

    public abstract float apply(float vecX, float vecY);
}
