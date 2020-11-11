package com.matez.wildnature.world.generation.transformer.transformers;

import com.google.common.collect.ImmutableSet;
import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.config.CommonConfig;
import com.matez.wildnature.world.generation.biome.setup.BiomeGroup;
import com.matez.wildnature.world.generation.biome.setup.EnumBiomes;
import com.matez.wildnature.world.generation.chunk.terrain.Terrain;
import com.matez.wildnature.world.generation.generators.functions.interpolation.BiomeBlender;
import com.matez.wildnature.world.generation.grid.Cell;
import com.matez.wildnature.world.generation.transformer.BiomeTransformer;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.common.BiomeManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainBiomeTransformer extends BiomeTransformer {
    @Override
    protected BiomeGroup apply(TempCategory tempCategory, WetCategory wetCategory, Cell cell, Terrain terrain, Terrain.Category category, float identity) {
        return getBiomeGroup(Arrays.asList(terrain.getWeightedBiomeGroups()), identity);
    }
}
