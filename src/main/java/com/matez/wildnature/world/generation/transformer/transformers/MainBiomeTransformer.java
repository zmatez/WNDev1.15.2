package com.matez.wildnature.world.generation.transformer.transformers;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.world.generation.chunk.terrain.Terrain;
import com.matez.wildnature.world.generation.generators.functions.interpolation.BiomeBlender;
import com.matez.wildnature.world.generation.grid.Cell;
import com.matez.wildnature.world.generation.transformer.BiomeTransformer;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager;

import java.util.ArrayList;
import java.util.List;

public class MainBiomeTransformer extends BiomeTransformer {
    public ArrayList<Biome> generationBiomes = new ArrayList<>();

    public MainBiomeTransformer(){
        for (BiomeManager.BiomeType value : BiomeManager.BiomeType.values()) {
            if(BiomeManager.getBiomes(value) != null) {
                for (BiomeManager.BiomeEntry biome : BiomeManager.getBiomes(value)) {
                    generationBiomes.add(biome.biome);
                }
            }
        }
        WN.LOGGER.info("Loaded MainBiomeTransformer. Biomes to spawn: " + generationBiomes.size());
    }

    @Override
    protected Biome apply(Biome oldBiome, TempCategory tempCategory, WetCategory wetCategory, Cell cell, Terrain terrain, Terrain.Category category, float identity) {
        return get(getBiomesByTerrain(generationBiomes,category),identity);
    }

    /**
     * Gets a valid biome list by a temp category
     * @param filter biomes to be filtered
     * @param category terrainCategory
     * @return filtered biomes from @param filter
     */
    public static List<Biome> getBiomesByTerrain(List<Biome> filter, Terrain.Category category){
        List<Biome> biomes = new ArrayList<>();
        for (Biome biome : filter) {
            float scale = biome.getScale();
            float depth = biome.getDepth();
            if(category == Terrain.Category.OCEAN){
                if(depth+scale < -0.3){
                    biomes.add(biome);
                }
            }else if(category == Terrain.Category.SEA){
                if(depth+scale < 0){
                    biomes.add(biome);
                }
            }else if(category == Terrain.Category.SHORE){
                if(depth+scale < 0.1){
                    biomes.add(biome);
                }
            }else if(category == Terrain.Category.LOWLANDS){
                if(depth+scale < 0.5){
                    biomes.add(biome);
                }
            }else if(category == Terrain.Category.MIDLANDS){
                if(depth+scale < 0.8){
                    biomes.add(biome);
                }
            }else if(category == Terrain.Category.HIGHLANDS){
                if(depth+scale < 1.3){
                    biomes.add(biome);
                }
            }else if(category == Terrain.Category.MOUNTAINS){
                if(depth+scale > 1.2){
                    biomes.add(biome);
                }
            }
        }
        return biomes;
    }
}
