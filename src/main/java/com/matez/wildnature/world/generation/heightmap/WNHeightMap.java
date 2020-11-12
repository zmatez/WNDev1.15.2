package com.matez.wildnature.world.generation.heightmap;

import com.matez.wildnature.world.generation.chunk.WNWorldContext;
import com.matez.wildnature.world.generation.chunk.terrain.TerrainProvider;
import com.matez.wildnature.world.generation.grid.maps.*;
import com.matez.wildnature.world.generation.grid.Cell;
import com.matez.wildnature.world.generation.heightmap.modules.ContinentGenerator;
import com.matez.wildnature.world.generation.maps.ClimateMap;

public class WNHeightMap {
    private final WNWorldContext context;
    private final long seed;
    private final ContinentGenerator continentGenerator;
    private final Cell cell;

    //maps
    public final GridMap terrainMap;
    public final GridMap biomeMap;
    public final GridMap subBiomeMap;
    public final GridMap smallIslandMap;
    public final GridMap bigIslandMap;

    private final TerrainProvider terrainProvider;
    private final ClimateMap climateMap;

    public WNHeightMap(WNWorldContext context) {
        this.context = context;
        this.seed = context.getSeed();
        this.cell = context.getCell();
        this.continentGenerator = new ContinentGenerator(seed);

        this.terrainMap = new TerrainMap(seed);
        this.biomeMap = new BiomeMap(seed);
        this.subBiomeMap = new SubBiomeMap(seed);
        this.smallIslandMap = new SmallIslandMap(seed);
        this.bigIslandMap = new BigIslandMap(seed);

        this.terrainProvider = context.getTerrainProvider();
        this.climateMap = new ClimateMap();
    }

    public void applyContinent(Cell cell, int dx, int dz) {
        cell.continentValue = continentGenerator.generateContinent(dx, dz);
        cell.cellContinent = continentGenerator.generateContinent(cell.terrainCellX, cell.terrainCellZ);
    }

    public void applyClimate(Cell cell, float x, float z) {
        climateMap.apply(cell, x, z);
    }

    /**
     * Applies identifies in cell for all specified maps.
     */
    public void apply(Cell cell, int dx, int dz) {
        terrainMap.apply(cell, dx, dz);
        biomeMap.apply(cell, dx, dz);
        subBiomeMap.apply(cell, dx, dz);
        smallIslandMap.apply(cell,dx,dz);
        bigIslandMap.apply(cell,dx,dz);

        applyContinent(cell, dx, dz);
        applyClimate(cell, dx, dz);
    }

    public ClimateMap getClimateMap() {
        return climateMap;
    }

    public ContinentGenerator getContinent() {
        return continentGenerator;
    }

}
