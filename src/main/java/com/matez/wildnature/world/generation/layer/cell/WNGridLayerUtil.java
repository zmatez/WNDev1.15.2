package com.matez.wildnature.world.generation.layer.cell;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.LazyAreaLayerContext;
import net.minecraft.world.gen.OverworldGenSettings;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.layer.EdgeBiomeLayer;
import net.minecraft.world.gen.layer.Layer;
import net.minecraft.world.gen.layer.traits.IAreaTransformer1;

import java.util.function.LongFunction;

public class WNGridLayerUtil {
    protected static final int WARM_OCEAN = Registry.BIOME.getId(Biomes.WARM_OCEAN);
    protected static final int LUKEWARM_OCEAN = Registry.BIOME.getId(Biomes.LUKEWARM_OCEAN);
    protected static final int OCEAN = Registry.BIOME.getId(Biomes.OCEAN);
    protected static final int COLD_OCEAN = Registry.BIOME.getId(Biomes.COLD_OCEAN);
    protected static final int FROZEN_OCEAN = Registry.BIOME.getId(Biomes.FROZEN_OCEAN);
    protected static final int DEEP_WARM_OCEAN = Registry.BIOME.getId(Biomes.DEEP_WARM_OCEAN);
    protected static final int DEEP_LUKEWARM_OCEAN = Registry.BIOME.getId(Biomes.DEEP_LUKEWARM_OCEAN);
    protected static final int DEEP_OCEAN = Registry.BIOME.getId(Biomes.DEEP_OCEAN);
    protected static final int DEEP_COLD_OCEAN = Registry.BIOME.getId(Biomes.DEEP_COLD_OCEAN);
    protected static final int DEEP_FROZEN_OCEAN = Registry.BIOME.getId(Biomes.DEEP_FROZEN_OCEAN);

    public static <T extends IArea, C extends IExtendedNoiseRandom<T>> IAreaFactory<T> repeat(long seed, IAreaTransformer1 parent, IAreaFactory<T> p_202829_3_, int count, LongFunction<C> contextFactory) {
        IAreaFactory<T> iareafactory = p_202829_3_;

        for (int i = 0; i < count; ++i) {
            iareafactory = parent.apply(contextFactory.apply(seed + (long) i), iareafactory);
        }

        return iareafactory;
    }

    public static <T extends IArea, C extends IExtendedNoiseRandom<T>> IAreaFactory<T> createBiomeLayer(WorldType worldType, OverworldGenSettings settings, LongFunction<C> contextFactory) {
        IAreaFactory<T> layer = new WNContinentLayer().apply(contextFactory.apply(1L));
        layer = EdgeBiomeLayer.INSTANCE.apply(contextFactory.apply(1L), layer);
        return layer;
    }

    public static Layer createLayer(long seed, WorldType worldType, OverworldGenSettings settings) {
        IAreaFactory<LazyArea> iareafactory = createBiomeLayer(worldType, settings, (seedModifier) -> {
            return new LazyAreaLayerContext(25, seed, seedModifier);
        });
        return new Layer(iareafactory);
    }

    protected static boolean isOcean(int biomeIn) {
        return biomeIn == WARM_OCEAN || biomeIn == LUKEWARM_OCEAN || biomeIn == OCEAN || biomeIn == COLD_OCEAN || biomeIn == FROZEN_OCEAN || biomeIn == DEEP_WARM_OCEAN || biomeIn == DEEP_LUKEWARM_OCEAN || biomeIn == DEEP_OCEAN || biomeIn == DEEP_COLD_OCEAN || biomeIn == DEEP_FROZEN_OCEAN;
    }

    protected static boolean isShallowOcean(int biomeIn) {
        return biomeIn == WARM_OCEAN || biomeIn == LUKEWARM_OCEAN || biomeIn == OCEAN || biomeIn == COLD_OCEAN || biomeIn == FROZEN_OCEAN;
    }
}
