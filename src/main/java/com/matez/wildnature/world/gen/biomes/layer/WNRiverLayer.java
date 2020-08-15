package com.matez.wildnature.world.gen.biomes.layer;

import com.matez.wildnature.world.gen.biomes.setup.WNBiomes;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.ICastleTransformer;

public class WNRiverLayer implements ICastleTransformer {
    public static WNRiverLayer INSTANCE = new WNRiverLayer();

    public static final int RIVER = Registry.BIOME.getId(WNBiomes.River);

    public int apply(INoiseRandom context, int north, int west, int south, int east, int center) {
        int i = riverFilter(center);
        return i == riverFilter(east) && i == riverFilter(north) && i == riverFilter(west) && i == riverFilter(south) ? -1 : RIVER;
    }

    private static int riverFilter(int i) {
        int size = 2;
        return i >= size ? size + (i & 1) : i;
    }
}
