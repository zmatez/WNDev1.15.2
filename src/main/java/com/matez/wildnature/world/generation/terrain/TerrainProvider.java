/*
 *
 * MIT License
 *
 * Copyright (c) 2020 TerraForged
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.matez.wildnature.world.generation.terrain;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.noise.NoiseUtil;
import com.matez.wildnature.world.generation.biome.setup.grid.BiomeGroup;
import com.matez.wildnature.world.generation.biome.setup.grid.SubBiome;
import com.matez.wildnature.world.generation.chunk.WNWorldContext;
import com.matez.wildnature.world.generation.terrain.terrains.land.highlands.HighlandTerrain;
import com.matez.wildnature.world.generation.terrain.terrains.land.lowlands.LowlandTerrain;
import com.matez.wildnature.world.generation.terrain.terrains.land.midlands.MidlandTerrain;
import com.matez.wildnature.world.generation.terrain.terrains.oceans.DeepOceanTerrain;
import com.matez.wildnature.world.generation.terrain.terrains.oceans.OceanTerrain;
import com.matez.wildnature.world.generation.terrain.terrains.seas.SeaTerrain;
import com.matez.wildnature.world.generation.grid.Cell;
import com.matez.wildnature.world.generation.transformer.BiomeTransformer;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

import java.util.ArrayList;
import java.util.List;

public class TerrainProvider {
    public static Terrain DEEP_OCEAN_TERRAIN = new DeepOceanTerrain();
    public static Terrain OCEAN_TERRAIN = new OceanTerrain();
    public static Terrain SEA_TERRAIN = new SeaTerrain();

    private final WNWorldContext context;
    private final List<Terrain> terrains = new ArrayList<>();
    public Terrain[] terrainIndex;

    public TerrainProvider(WNWorldContext context) {
        this.context = context;
        this.registerTerrains();
        this.terrainIndex = filterTerrains(context.getCell());
    }

    private void registerTerrains() {
        register(new DeepOceanTerrain());
        register(new OceanTerrain());
        register(new SeaTerrain());
        register(new LowlandTerrain());
        register(new MidlandTerrain());
        register(new HighlandTerrain());
    }

    private void register(Terrain terrain){
        terrains.add(terrain);
    }

    public void init(long seed){
        for (Terrain terrain : terrains) {
            WN.LOGGER.info("Initializing terrain: " + terrain.getName());
            terrain.init(seed);
        }
        ArrayList<Biome> spawnBiomes = new ArrayList<>();
        for (Terrain terrain : terrains) {
            terrain.climaticBiomeGroups.forEach(((tempCategory, wetCategoryListLinkedHashMap) -> {
                wetCategoryListLinkedHashMap.forEach((wetCategory, biomeGroups) -> {
                    for (BiomeGroup biomeGroup : biomeGroups) {
                        spawnBiomes.add(biomeGroup.getBaseBiome());
                        for (SubBiome subBiome : biomeGroup.getSubBiomes()) {
                            spawnBiomes.add(subBiome.getBiome());
                        }
                    }
                });
            }));
        }
        WN.LOGGER.debug("--- BIOME ERRORS: ");
        for (Biome biome : Registry.BIOME) {
            if(!spawnBiomes.contains(biome)){
                BiomeTransformer.TempCategory tempCategory = BiomeTransformer.TempCategory.getFromTemperature(-0.1f,1f,biome.getDefaultTemperature());
                BiomeTransformer.WetCategory wetCategory = BiomeTransformer.WetCategory.getFromMoisture(0,1f,biome.getDownfall());
                WN.LOGGER.debug("--- " + biome.getRegistryName() + " never gonna spawn - " + tempCategory.getName() + ":" + wetCategory.getName());
            }
        }
        WN.LOGGER.debug("------------------");

        spawnBiomes.clear();
    }

    public Terrain[] filterTerrains(Cell cell) {
        List<Terrain> filter = new ArrayList<>();
        Terrain.Category category = getCategoryFromContinent(cell.cellContinent);
        for (Terrain terrain : terrains) {
            if(terrain.getTerrainCategory() == category){
                filter.add(terrain);
            }
        }
        if(filter.isEmpty()){
            WN.LOGGER.warn("Terrain list is empty - continent: " + cell.cellContinent + ", category: " + category.getName() +" | Applying " + terrains.get(0).getName());
            filter.add(terrains.get(0));
        }

        return filter.toArray(new Terrain[0]);
    }
    
    public static Terrain.Category getCategoryFromContinent(float cellContinent){
        if (cellContinent >= 0.75F) {
            return Terrain.Category.HIGHLANDS;
        } else if (cellContinent >= 0.4F && cellContinent < 0.75F) {
            return Terrain.Category.MIDLANDS;
        } else if (cellContinent >= 0.15F && cellContinent < 0.4F) {
            return Terrain.Category.LOWLANDS;
        }else if (cellContinent >= 0.1F && cellContinent < 0.15F) {
            return Terrain.Category.SEA;
        } else if(cellContinent >= 0.05F && cellContinent < 0.1F){
            return Terrain.Category.OCEAN;
        }else{
            return Terrain.Category.DEEP_OCEAN;
        }
    }

    public Terrain get(long seed, float identity) {
        int index = NoiseUtil.round(identity * (terrainIndex.length - 1));
        return filterTerrains(context.getCell())[index];
    }

    public List<Terrain> getTerrains() {
        return terrains;
    }

    public TerrainProvider create() {
        return new TerrainProvider(context);
    }

    public void unload(){
        for (Terrain terrain : terrains) {
            WN.LOGGER.info("Unloading " + terrain.getName() + "...");
            terrain.unload();
            WN.LOGGER.info("Successfully unloaded " + terrain.getName());
        }
        terrains.clear();
    }

}