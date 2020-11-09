package com.matez.wildnature.world.generation.heightmap;

import com.matez.wildnature.world.generation.chunk.WNWorldContext;
import com.matez.wildnature.world.generation.chunk.terrain.TerrainProvider;
import com.matez.wildnature.world.generation.grid.BiomeMap;
import com.matez.wildnature.world.generation.grid.Cell;
import com.matez.wildnature.world.generation.grid.TerrainMap;
import com.matez.wildnature.world.generation.heightmap.modules.ContinentGenerator;
import com.matez.wildnature.world.generation.maps.ClimateMap;

public class WNHeightMap {
    private final WNWorldContext context;
    private final long seed;
    private final ContinentGenerator continentGenerator;
    private final Cell cell;
    public final TerrainMap terrainMap;
    public final BiomeMap biomeMap;
    private final TerrainProvider terrainProvider;
    private final ClimateMap climateMap;

    public WNHeightMap(WNWorldContext context){
        this.context = context;
        this.seed = context.getSeed();
        this.cell = context.getCell();
        this.continentGenerator = new ContinentGenerator(seed);
        this.terrainMap = new TerrainMap(seed);
        this.biomeMap = new BiomeMap(seed);

        this.terrainProvider = context.getTerrainProvider();
        this.climateMap = new ClimateMap();
    }

    public void applyContinent(Cell cell, int dx, int dz){
        cell.continentValue = continentGenerator.generateContinent(dx, dz);
        cell.cellContinent = continentGenerator.generateContinent(cell.terrainCellX, cell.terrainCellZ);
    }

    public void applyClimate(Cell cell, float x, float z) {
        climateMap.apply(cell, x, z);
    }

    public void apply(Cell cell, int dx, int dz){
        terrainMap.apply(cell, dx, dz);
        biomeMap.apply(cell,dx,dz);

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
