package com.matez.wildnature.world.generation.layer.grid;

import com.matez.wildnature.util.noise.NoiseUtil;
import com.matez.wildnature.world.generation.biome.setup.BiomeGroup;
import com.matez.wildnature.world.generation.chunk.terrain.Terrain;
import com.matez.wildnature.world.generation.grid.Cell;
import com.matez.wildnature.world.generation.provider.WNGridBiomeProvider;
import com.matez.wildnature.world.generation.transformer.BiomeTransformer;
import com.matez.wildnature.world.generation.transformer.transformers.MainBiomeTransformer;
import com.matez.wildnature.world.generation.transformer.transformers.MainSubbiomeTransformer;
import com.matez.wildnature.world.generation.transformer.transformers.ShoreTransformer;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;

import java.util.ArrayList;
import java.util.List;

public class GridBiomeLayer {
    private WNGridBiomeProvider provider;
    public GridBiomeLayer(WNGridBiomeProvider provider){
        this.provider = provider;
    }

    /**
     * Get biomes at certain position, applying transformers
     * @param x
     * @param z
     * @return
     */
    public Biome getBiome(int x, int z){
        Cell cell = provider.getNoiseCell(x,z);
        Terrain terrain = provider.getNoiseTerrain(cell, x,z);

        return get(x,z, cell,terrain);
    }

    public Biome filterBiomes(int x, int z, Cell cell, Terrain terrain) {
        int directionMove = 15;
        Cell northCell = provider.getNoiseCell(x + directionMove,z), southCell = provider.getNoiseCell(x - directionMove,z), eastCell = provider.getNoiseCell(x,z + directionMove), westCell = provider.getNoiseCell(x,z - directionMove);
        Terrain northTerrain = provider.getNoiseTerrain(northCell, x + directionMove,z), southTerrain = provider.getNoiseTerrain(southCell, x - directionMove,z), eastTerrain = provider.getNoiseTerrain(eastCell, x,z + directionMove), westTerrain = provider.getNoiseTerrain(westCell, x,z - directionMove);

        Biome biome = applyTransformers(x,z, cell,northCell, southCell, eastCell, westCell,terrain,northTerrain,southTerrain,eastTerrain,westTerrain);

        return biome;
    }

    //BiomeTransformers here
    private final BiomeTransformer mainBiomeTransformer = new MainBiomeTransformer();
    private final BiomeTransformer mainSubBiomeTransformer = new MainSubbiomeTransformer();
    private final BiomeTransformer shoreTransformer = new ShoreTransformer();

    /**
     * Used to apply biomes from biome/subbiome maps
     * Directional Cells are used to determine nearby biomes. For example for edge transformers (to produce Beaches)
     * @return final biome
     */
    public Biome applyTransformers(int x, int z, Cell cell, Cell northCell, Cell southCell, Cell eastCell, Cell westCell, Terrain terrain, Terrain northTerrain, Terrain southTerrain, Terrain eastTerrain, Terrain westTerrain){
        BiomeGroup biomeGroup = null, northBiomeGroup, southBiomeGroup, westBiomeGroup, eastBiomeGroup;

        //Gets BiomeGroup (so baseBiome + all subbiomes) to filter terrain later. Uses BiomeMap. BiomeGroups are registered in WNBiomes by BiomeTerrain.
        biomeGroup = mainBiomeTransformer.apply(cell,terrain);
        if(northCell == cell && northTerrain == terrain){
            northBiomeGroup = biomeGroup;
        }else {
            northBiomeGroup = mainBiomeTransformer.apply(northCell, northTerrain);
        }
        if(southCell == cell && southTerrain == terrain){
            southBiomeGroup = biomeGroup;
        }else {
            southBiomeGroup = mainBiomeTransformer.apply(southCell, southTerrain);
        }
        if(eastCell == cell && eastTerrain == terrain){
            eastBiomeGroup = biomeGroup;
        }else {
            eastBiomeGroup = mainBiomeTransformer.apply(eastCell, eastTerrain);
        }
        if(westCell == cell && westTerrain == terrain){
            westBiomeGroup = biomeGroup;
        }else {
            westBiomeGroup = mainBiomeTransformer.apply(westCell, westTerrain);
        }

        //Gets final Biome from BiomeGroup. Uses SubbiomeMap
        Biome biome = mainSubBiomeTransformer.apply(biomeGroup,cell,terrain);
        Biome northBiome, southBiome, eastBiome, westBiome;
        if(biomeGroup == northBiomeGroup){
            northBiome = biome;
        }else{
            northBiome = mainSubBiomeTransformer.apply(northBiomeGroup,northCell,northTerrain);;
        }
        if(biomeGroup == southBiomeGroup){
            southBiome = biome;
        }else{
            southBiome = mainSubBiomeTransformer.apply(southBiomeGroup,southCell,southTerrain);;
        }
        if(biomeGroup == eastBiomeGroup){
            eastBiome = biome;
        }else{
            eastBiome = mainSubBiomeTransformer.apply(eastBiomeGroup,eastCell,eastTerrain);;
        }
        if(biomeGroup == westBiomeGroup){
            westBiome = biome;
        }else{
            westBiome = mainSubBiomeTransformer.apply(westBiomeGroup,westCell,westTerrain);;
        }

        //Applies beaches to ocean edges (W.I.P)
        biome = shoreTransformer.apply(biome,northBiome,southBiome,eastBiome,westBiome,cell,terrain);


        return biome;
    }

    public Biome get(int x, int z, Cell cell, Terrain terrain) {
        return filterBiomes(x,z, cell,terrain);
    }
}
