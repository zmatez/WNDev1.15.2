package com.matez.wildnature.world.generation.layer.grid;

import com.matez.wildnature.util.noise.NoiseUtil;
import com.matez.wildnature.world.generation.chunk.terrain.Terrain;
import com.matez.wildnature.world.generation.grid.Cell;
import com.matez.wildnature.world.generation.provider.WNGridBiomeProvider;
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

        return get(cell,terrain, cell.biomeCellIdentity);
    }

    public Biome[] filterBiomes(Cell cell, Terrain terrain) {
        List<Biome> filter = new ArrayList<>();
        if(terrain.getCategory() == Terrain.Category.OCEAN){
            filter.add(Biomes.OCEAN);
        }else{
            filter.add(Biomes.PLAINS);
        }

        return filter.toArray(new Biome[0]);
    }

    public Biome get(Cell cell, Terrain terrain, float identity) {
        Biome[] filtered = filterBiomes(cell,terrain);
        int index = NoiseUtil.round(identity * (filtered.length - 1));
        return filtered[index];
    }
}
