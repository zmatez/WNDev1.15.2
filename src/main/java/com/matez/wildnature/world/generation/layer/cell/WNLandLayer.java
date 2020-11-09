package com.matez.wildnature.world.generation.layer.cell;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IAreaTransformer0;

public enum WNLandLayer implements IAreaTransformer0
{
    INSTANCE;

    public int apply(INoiseRandom random, int x, int z) {
        return 1;
    }
}
