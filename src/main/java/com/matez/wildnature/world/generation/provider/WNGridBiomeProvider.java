package com.matez.wildnature.world.generation.provider;

import com.matez.wildnature.world.generation.chunk.WNWorldContext;
import com.matez.wildnature.world.generation.grid.Cell;
import com.matez.wildnature.world.generation.layer.grid.GridBiomeLayer;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.biome.provider.OverworldBiomeProviderSettings;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashSet;
import java.util.Set;

public class WNGridBiomeProvider extends BiomeProvider {
    private OverworldBiomeProviderSettings settings;
    private WNWorldContext context;
    private GridBiomeLayer layer;

    protected WNGridBiomeProvider(OverworldBiomeProviderSettings settings) {
        super(getBiomes());
        this.settings = settings;
        this.layer = new GridBiomeLayer(this);
    }

    public GridBiomeLayer getLayer() {
        return layer;
    }

    public void setContext(WNWorldContext context) {
        this.context = context;
    }

    public WNWorldContext getContext() {
        return context;
    }

    private static Set<Biome> getBiomes(){
        Set<Biome> biomeSet = new HashSet<>();
        for (Biome biome : ForgeRegistries.BIOMES) {
            if(BiomeDictionary.getTypes(biome).contains(BiomeDictionary.Type.OVERWORLD)) {
                biomeSet.add(biome);
            }
        }
        return biomeSet;
    }

    public Cell getNoiseCell(int x, int z){
        return context.getHeightmap().apply(new Cell(), x, z);
    }

    public Biome getNoiseBiome(int x, int y, int z, boolean fakeBiomes) {
        return layer.getBiome(x,z,fakeBiomes);
    }

    public Biome getNoiseBiome(Cell cell, int x, int y, int z) {
        return layer.getBiome(cell, x,z,false);
    }

    public Biome getNoiseBiome(Cell cell, int x, int y, int z, boolean fakeBiomes) {
        return layer.getBiome(cell, x,z,fakeBiomes);
    }

    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        return layer.getBiome(x,z,false);
    }
}
