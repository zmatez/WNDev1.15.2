package com.matez.wildnature.world.generation.layer.grid;

import com.matez.wildnature.util.noise.NoiseUtil;
import com.matez.wildnature.world.generation.chunk.terrain.Terrain;
import com.matez.wildnature.world.generation.grid.Cell;
import com.matez.wildnature.world.generation.provider.WNGridBiomeProvider;
import com.matez.wildnature.world.generation.transformer.BiomeTransformer;
import com.matez.wildnature.world.generation.transformer.transformers.MainBiomeTransformer;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;

import java.util.ArrayList;
import java.util.List;

public class GridBiomeLayer {
    private WNGridBiomeProvider provider;
    private ArrayList<Biome> biomes = new ArrayList<>();
    public GridBiomeLayer(WNGridBiomeProvider provider){
        this.provider = provider;
    }

    public Biome getBiome(int x, int z){
        Cell cell = provider.getNoiseCell(x,z);
        Terrain terrain = provider.getNoiseTerrain(cell, x,z);

        return get(cell,terrain);
    }

    public Biome filterBiomes(Cell cell, Terrain terrain) {
        Biome biome = applyTransformers(cell,terrain);

        return biome;
    }

    private final BiomeTransformer mainBiomeTransformer = new MainBiomeTransformer();

    public Biome applyTransformers(Cell cell, Terrain terrain){
        Biome biome = Biomes.OCEAN;
        biome = mainBiomeTransformer.apply(biome,cell,terrain);

        return biome;
    }

    public Biome get(Cell cell, Terrain terrain) {
        return filterBiomes(cell,terrain);
    }
}
