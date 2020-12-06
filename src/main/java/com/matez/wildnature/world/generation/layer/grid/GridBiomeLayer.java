package com.matez.wildnature.world.generation.layer.grid;

import com.matez.wildnature.world.generation.biome.registry.WNBiomes;
import com.matez.wildnature.world.generation.biome.setup.grid.BiomeGroup;
import com.matez.wildnature.world.generation.biome.setup.grid.IslandBiome;
import com.matez.wildnature.world.generation.terrain.Terrain;
import com.matez.wildnature.world.generation.grid.Cell;
import com.matez.wildnature.world.generation.provider.WNGridBiomeProvider;
import com.matez.wildnature.world.generation.transformer.BiomeTransformer;
import com.matez.wildnature.world.generation.transformer.transformers.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.Heightmap;

public class GridBiomeLayer {
    private WNGridBiomeProvider provider;

    public GridBiomeLayer(WNGridBiomeProvider provider) {
        this.provider = provider;
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
        Terrain terrain = provider.getNoiseTerrain(cell, x, z);

        return get(x, z, cell, terrain, fakeBiomes);
    }

    public Biome getBiome(Cell cell, Terrain terrain, int x, int z, boolean fakeBiomes) {
        return get(x, z, cell, terrain,fakeBiomes);
    }

    public Biome filterBiomes(int x, int z, Cell cell, Terrain terrain, boolean fakeBiomes) {

        int directionMove = 16;

        Cell northCell = provider.getNoiseCell(x + directionMove, z).copy();
        Cell southCell = provider.getNoiseCell(x - directionMove, z).copy();
        Cell eastCell = provider.getNoiseCell(x, z + directionMove).copy();
        Cell westCell = provider.getNoiseCell(x, z - directionMove).copy();

        Terrain northTerrain = provider.getNoiseTerrain(northCell, x + directionMove, z);
        Terrain southTerrain = provider.getNoiseTerrain(southCell, x - directionMove, z);
        Terrain eastTerrain = provider.getNoiseTerrain(eastCell, x, z + directionMove);
        Terrain westTerrain = provider.getNoiseTerrain(westCell, x, z - directionMove);

        //Cell bigIslandOldCenterCell = provider.getNoiseCell(cell.bigIslandCellX,cell.bigIslandCellZ).copy(), smallIslandOldCenterCell = provider.getNoiseCell(cell.smallIslandCellX,cell.smallIslandCellZ).copy();
        //Terrain bigIslandOldCenterTerrain = provider.getNoiseTerrain(bigIslandOldCenterCell), smallIslandOldCenterTerrain = provider.getNoiseTerrain(smallIslandOldCenterCell);
        //TODO make islands have only one biome on each

        Biome biome = applyTransformers(x, z, cell, northCell, southCell, eastCell, westCell, terrain, northTerrain, southTerrain, eastTerrain, westTerrain,fakeBiomes);

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
    public Biome applyTransformers(int x, int z, Cell cell, Cell northCell, Cell southCell, Cell eastCell, Cell westCell, Terrain terrain, Terrain northTerrain, Terrain southTerrain, Terrain eastTerrain, Terrain westTerrain, boolean fakeBiomes) {
        BiomeGroup biomeGroup = null, northBiomeGroup, southBiomeGroup, westBiomeGroup, eastBiomeGroup;
        //Gets BiomeGroup (so baseBiome + all subbiomes) to filter terrain later. Uses BiomeMap. BiomeGroups are registered in WNBiomes by BiomeTerrain.
        biomeGroup = mainBiomeTransformer.bgApply(cell, terrain);

        if (northCell == cell && northTerrain == terrain) {
            northBiomeGroup = biomeGroup;
        } else {
            northBiomeGroup = mainBiomeTransformer.bgApply(northCell, northTerrain);
        }
        if (southCell == cell && southTerrain == terrain) {
            southBiomeGroup = biomeGroup;
        } else {
            southBiomeGroup = mainBiomeTransformer.bgApply(southCell, southTerrain);
        }
        if (eastCell == cell && eastTerrain == terrain) {
            eastBiomeGroup = biomeGroup;
        } else {
            eastBiomeGroup = mainBiomeTransformer.bgApply(eastCell, eastTerrain);
        }
        if (westCell == cell && westTerrain == terrain) {
            westBiomeGroup = biomeGroup;
        } else {
            westBiomeGroup = mainBiomeTransformer.bgApply(westCell, westTerrain);
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

        biomeGroup = smallIslandTransformer.bgApply(biomeGroup, cell, terrain);
        biomeGroup = bigIslandTransformer.bgApply(biomeGroup, cell, terrain);

        northBiomeGroup = smallIslandTransformer.bgApply(northBiomeGroup, northCell, northTerrain);
        northBiomeGroup = bigIslandTransformer.bgApply(northBiomeGroup, northCell, northTerrain);
        southBiomeGroup = smallIslandTransformer.bgApply(southBiomeGroup, southCell, southTerrain);
        southBiomeGroup = bigIslandTransformer.bgApply(southBiomeGroup, southCell, southTerrain);
        eastBiomeGroup = smallIslandTransformer.bgApply(eastBiomeGroup, eastCell, eastTerrain);
        eastBiomeGroup = bigIslandTransformer.bgApply(eastBiomeGroup, eastCell, eastTerrain);
        westBiomeGroup = smallIslandTransformer.bgApply(westBiomeGroup, westCell, westTerrain);
        westBiomeGroup = bigIslandTransformer.bgApply(westBiomeGroup, westCell, westTerrain);

        biomeGroup = edgeTransformer.apply(biomeGroup,northBiomeGroup,southBiomeGroup,eastBiomeGroup,westBiomeGroup,cell,terrain);
        biomeGroup = shoreTransformer.apply(biomeGroup,northBiomeGroup,southBiomeGroup,eastBiomeGroup,westBiomeGroup,cell,terrain);

        if(fakeBiomes) {
            biomeGroup = riverValleyTransformer.bgApply(biomeGroup, cell, terrain);
        }
        biomeGroup = riverTransformer.bgApply(biomeGroup,cell,terrain);




        //Gets final Biome from transformed BiomeGroup. Uses SubbiomeMap
        Biome biome = mainSubBiomeTransformer.apply(biomeGroup, cell, terrain);
        return biome;
    }

    public Biome get(int x, int z, Cell cell, Terrain terrain, boolean fakeBiomes) {
        return filterBiomes(x, z, cell.copy(), terrain, fakeBiomes);
    }

    public static Biome applyHeightmapBiome(Biome biome, BlockPos pos, IWorld world, int div){
        if(biome.getDepth() > 0 &&
        biome.getCategory() != Biome.Category.BEACH &&
        biome.getCategory() != Biome.Category.SWAMP){
            if(world.getChunk(pos).getTopBlockY(Heightmap.Type.OCEAN_FLOOR_WG,pos.getX()/div,pos.getZ()/div)<(world.getSeaLevel()-2)){
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
}
