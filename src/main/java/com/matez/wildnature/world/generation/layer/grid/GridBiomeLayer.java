package com.matez.wildnature.world.generation.layer.grid;

import com.matez.wildnature.world.generation.biome.registry.WNBiomes;
import com.matez.wildnature.world.generation.biome.setup.grid.BiomeGroup;
import com.matez.wildnature.world.generation.biome.setup.grid.IslandBiome;
import com.matez.wildnature.world.generation.grid.Cell;
import com.matez.wildnature.world.generation.provider.WNGridBiomeProvider;
import com.matez.wildnature.world.generation.transformer.BiomeTransformer;
import com.matez.wildnature.world.generation.transformer.transformers.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.Heightmap;

import java.util.ArrayList;

public class GridBiomeLayer {
    public static ArrayList<BiomeGroup> OCEANS;
    private WNGridBiomeProvider provider;

    public GridBiomeLayer(WNGridBiomeProvider provider) {
        this.provider = provider;
        OCEANS = new ArrayList<>();
        OCEANS.add(WNBiomes.OCEAN);
        OCEANS.add(WNBiomes.COLD_OCEAN);
        OCEANS.add(WNBiomes.FROZEN_OCEAN);
        OCEANS.add(WNBiomes.LUKEWARM_OCEAN);
        OCEANS.add(WNBiomes.WARM_OCEAN);
        OCEANS.add(WNBiomes.DEEP_OCEAN);
        OCEANS.add(WNBiomes.DEEP_COLD_OCEAN);
        OCEANS.add(WNBiomes.DEEP_FROZEN_OCEAN);
        OCEANS.add(WNBiomes.DEEP_LUKEWARM_OCEAN);
        OCEANS.add(WNBiomes.DEEP_WARM_OCEAN);
    }

    /**
     * Get biomes at certain position, applying transformers
     *
     * @param x
     * @param z
     * @return
     */
    public Biome getBiome(int x, int z, boolean fakeBiomes) {
        Cell cell = provider.getNoiseCell(x, z);
        Biome b = get(x, z, cell, fakeBiomes);
        cell = null;
        return b;
    }

    public Biome getBiome(Cell cell, int x, int z, boolean fakeBiomes) {
        return get(x, z, cell,fakeBiomes);
    }

    public Biome filterBiomes(int x, int z, Cell cell, boolean fakeBiomes) {

        int directionMove = 16;

        Cell northCell = provider.getNoiseCell(x + directionMove, z).copy();
        Cell southCell = provider.getNoiseCell(x - directionMove, z).copy();
        Cell eastCell = provider.getNoiseCell(x, z + directionMove).copy();
        Cell westCell = provider.getNoiseCell(x, z - directionMove).copy();


        //Cell bigIslandOldCenterCell = provider.getNoiseCell(cell.bigIslandCellX,cell.bigIslandCellZ).copy(), smallIslandOldCenterCell = provider.getNoiseCell(cell.smallIslandCellX,cell.smallIslandCellZ).copy();
        //Terrain bigIslandOldCenterTerrain = provider.getNoiseTerrain(bigIslandOldCenterCell), smallIslandOldCenterTerrain = provider.getNoiseTerrain(smallIslandOldCenterCell);
        //TODO make islands have only one biome on each

        Biome biome = applyTransformers(x, z, cell, northCell, southCell, eastCell, westCell,fakeBiomes);

        northCell = null;
        southCell = null;
        eastCell = null;
        westCell = null;
        return biome;
    }

    //BiomeTransformers here
    private final BiomeTransformer mainBiomeTransformer = new MainBiomeTransformer();
    private final BiomeTransformer mainSubBiomeTransformer = new MainSubbiomeTransformer();
    private final BiomeTransformer shoreTransformer = new ShoreTransformer();
    private final BiomeTransformer edgeTransformer = new EdgeTransformer();
    private final BiomeTransformer smallIslandTransformer = new IslandTransformer(IslandBiome.IslandType.SMALL);
    private final BiomeTransformer bigIslandTransformer = new IslandTransformer(IslandBiome.IslandType.BIG);
    private final BiomeTransformer riverTransformer = new RiverTransformer();
    private final BiomeTransformer riverValleyTransformer = new RiverValleyTransformer();
    /**
     * Used to apply biomes from biome/subbiome maps
     * Directional Cells are used to determine nearby biomes. For example for edge transformers (to produce Beaches)
     *
     * @return final biome
     */
    public Biome applyTransformers(int x, int z, Cell cell, Cell northCell, Cell southCell, Cell eastCell, Cell westCell, boolean fakeBiomes) {
        BiomeGroup biomeGroup = null, northBiomeGroup, southBiomeGroup, westBiomeGroup, eastBiomeGroup;
        //Gets BiomeGroup (so baseBiome + all subbiomes) to filter terrain later. Uses BiomeMap. BiomeGroups are registered in WNBiomes by BiomeTerrain.
        biomeGroup = mainBiomeTransformer.bgApply(cell);

        if (northCell == cell) {
            northBiomeGroup = biomeGroup;
        } else {
            northBiomeGroup = mainBiomeTransformer.bgApply(northCell);
        }
        if (southCell == cell) {
            southBiomeGroup = biomeGroup;
        } else {
            southBiomeGroup = mainBiomeTransformer.bgApply(southCell);
        }
        if (eastCell == cell) {
            eastBiomeGroup = biomeGroup;
        } else {
            eastBiomeGroup = mainBiomeTransformer.bgApply(eastCell);
        }
        if (westCell == cell) {
            westBiomeGroup = biomeGroup;
        } else {
            westBiomeGroup = mainBiomeTransformer.bgApply(westCell);
        }

        /*if (bigIslandOldCenterCell == cell && bigIslandOldCenterTerrain == terrain) {
            bigIslandCenterBiomeGroup = biomeGroup;
        } else {
            bigIslandCenterBiomeGroup = mainBiomeTransformer.bgApply(bigIslandOldCenterCell, bigIslandOldCenterTerrain);
        }
        if (smallIslandOldCenterCell == cell && smallIslandOldCenterTerrain == terrain) {
            smallIslandCenterBiomeGroup = biomeGroup;
        } else {
            smallIslandCenterBiomeGroup = mainBiomeTransformer.bgApply(smallIslandOldCenterCell, smallIslandOldCenterTerrain);
        }*/


        biomeGroup = bigIslandTransformer.bgApply(biomeGroup, cell);

        northBiomeGroup = bigIslandTransformer.bgApply(northBiomeGroup, northCell);
        southBiomeGroup = bigIslandTransformer.bgApply(southBiomeGroup, southCell);
        eastBiomeGroup = bigIslandTransformer.bgApply(eastBiomeGroup, eastCell);
        westBiomeGroup = bigIslandTransformer.bgApply(westBiomeGroup, westCell);

        biomeGroup = edgeTransformer.apply(biomeGroup,northBiomeGroup,southBiomeGroup,eastBiomeGroup,westBiomeGroup,cell);
        biomeGroup = shoreTransformer.apply(biomeGroup,northBiomeGroup,southBiomeGroup,eastBiomeGroup,westBiomeGroup,cell);

        biomeGroup = smallIslandTransformer.bgApply(biomeGroup, cell);

        if(fakeBiomes) {
            biomeGroup = riverValleyTransformer.bgApply(biomeGroup, cell);
        }
        biomeGroup = riverTransformer.bgApply(biomeGroup,cell);




        //Gets final Biome from transformed BiomeGroup. Uses SubbiomeMap
        Biome biome = mainSubBiomeTransformer.apply(biomeGroup, cell);
        return biome;
    }

    public Biome get(int x, int z, Cell cell, boolean fakeBiomes) {
        return filterBiomes(x, z, cell.copy(), fakeBiomes);
    }

    public static Biome applyHeightmapBiome(Biome biome, BlockPos pos, IWorld world, int div){
        return applyHeightmapBiome(biome,pos,world.getChunk(pos),world.getSeaLevel(),div);
    }

    public static Biome applyHeightmapBiome(Biome biome, BlockPos pos, IChunk chunk, int seaLevel, int div){
        if(biome.getDepth() > 0 &&
        biome.getCategory() != Biome.Category.BEACH &&
        biome.getCategory() != Biome.Category.SWAMP){
            if(chunk.getTopBlockY(Heightmap.Type.OCEAN_FLOOR_WG,pos.getX()/div,pos.getZ()/div)<(seaLevel-2)){
                BiomeTransformer.TempCategory category = BiomeTransformer.TempCategory.getFromTemperature(-0.1f,1f,biome.getDefaultTemperature());
                if(category == BiomeTransformer.TempCategory.ICY){
                    return WNBiomes.FrozenLake;
                }else if(category == BiomeTransformer.TempCategory.COLD){
                    return WNBiomes.ColdLake;
                }else if(category == BiomeTransformer.TempCategory.TEMPERATE){
                    return WNBiomes.WarmLake;
                }else if(category == BiomeTransformer.TempCategory.WARM){
                    return WNBiomes.WarmLake;
                }else if(category == BiomeTransformer.TempCategory.HOT){
                    return WNBiomes.WarmLake;
                }
            }
        }
        return biome;
    }

    public BiomeTransformer getMainBiomeTransformer() {
        return mainBiomeTransformer;
    }
}
