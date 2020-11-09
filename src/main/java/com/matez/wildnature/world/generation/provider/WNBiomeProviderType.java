package com.matez.wildnature.world.generation.provider;

import com.matez.wildnature.world.generation.chunk.WNWorldContext;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.provider.*;
import net.minecraft.world.biome.provider.BiomeProviderType;
import net.minecraft.world.storage.WorldInfo;

import java.util.function.Function;

public class WNBiomeProviderType {
    public static BiomeProviderType<OverworldBiomeProviderSettings, WildNatureBiomeProvider> WILDNATURE;
    public static BiomeProviderType<OverworldBiomeProviderSettings, WNGridBiomeProvider> WILDNATURE_GRID;

    public WNBiomeProviderType(){
        WILDNATURE = register("wildnature", WildNatureBiomeProvider::new, OverworldBiomeProviderSettings::new);
        WILDNATURE_GRID = register("wildnature_grid", WNGridBiomeProvider::new, OverworldBiomeProviderSettings::new);
    }

    private static <C extends IBiomeProviderSettings, T extends BiomeProvider> BiomeProviderType<C, T> register(String key, Function<C, T> f, Function<WorldInfo, C> w) {
        return Registry.register(Registry.BIOME_SOURCE_TYPE, key,new BiomeProviderType<>(f, w));
    }
}
