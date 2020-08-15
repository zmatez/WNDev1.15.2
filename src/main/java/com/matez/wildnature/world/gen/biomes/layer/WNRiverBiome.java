package com.matez.wildnature.world.gen.biomes.layer;

import com.matez.wildnature.world.gen.biomes.setup.WNBiomes;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.ICastleTransformer;

public class WNRiverBiome implements ICastleTransformer {
    public static WNRiverBiome INSTANCE = new WNRiverBiome();

    public static final int RIVER = Registry.BIOME.getId(WNBiomes.River);
    public static final int FARMLANDS = Registry.BIOME.getId(WNBiomes.Farmlands);

    public int apply(INoiseRandom context, int north, int west, int south, int east, int center) {
        int i = riverFilter(center);
        return i == riverFilter(east) && i == riverFilter(north) && i == riverFilter(west) && i == riverFilter(south) ? -1 : RIVER;
    }

    private static int riverFilter(int p_151630_0_) {
        int size = 2;
        return p_151630_0_ >= size ? size + (p_151630_0_ & 1) : p_151630_0_;
    }
}
