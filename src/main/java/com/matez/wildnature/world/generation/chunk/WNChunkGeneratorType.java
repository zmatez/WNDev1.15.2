package com.matez.wildnature.world.generation.chunk;

import com.matez.wildnature.world.generation.biomes.setup.WNGenSettings;
import com.matez.wildnature.world.generation.chunk.generation.WNSimplexChunkGenerator;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.*;

import java.util.function.Supplier;

public class WNChunkGeneratorType {
    public static ChunkGeneratorType<WNGenSettings, WNChunkGeneratorOverworld> WILDNATURE;
    public static ChunkGeneratorType<WNGenSettings, WNSimplexChunkGenerator> SIMPLEX_TEST;

    public WNChunkGeneratorType(){
        WILDNATURE = register("wildnature", WNChunkGeneratorOverworld::new, WNGenSettings::new,true);
        SIMPLEX_TEST = register("wildnature-simplex", WNSimplexChunkGenerator::new, WNGenSettings::new, true);
    }

    private static <C extends GenerationSettings, T extends ChunkGenerator<C>> ChunkGeneratorType<C, T> register(String key, IChunkGeneratorFactory<C, T> factoryIn, Supplier<C> settingsIn, boolean canUseForBuffet) {
        return Registry.register(Registry.CHUNK_GENERATOR_TYPE, key, new ChunkGeneratorType<>(factoryIn, canUseForBuffet, settingsIn));
    }


}
