package com.matez.wildnature.world.generation.chunk.generation;

public interface IWNBiome {
    default LargeGroup getLargeGroup() {
        return LargeGroup.LAND;
    }

    default SmallGroup getMediumGroup() {
        return SmallGroup.BODY;
    }

    enum LargeGroup {
        LAND, OCEAN, RIVER, LAKE;

        public static final int SIZE = LargeGroup.values().length;
    }

    enum SmallGroup {
        BODY, RIVER;

        public static final int SIZE = SmallGroup.values().length;
    }
}
