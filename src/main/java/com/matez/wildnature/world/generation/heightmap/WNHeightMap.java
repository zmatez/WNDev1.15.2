package com.matez.wildnature.world.generation.heightmap;

import com.matez.wildnature.world.generation.chunk.WNWorldContext;
import com.matez.wildnature.world.generation.chunk.terrain.TerrainProvider;
import com.matez.wildnature.world.generation.grid.Cell;
import com.matez.wildnature.world.generation.grid.TerrainMap;
import com.matez.wildnature.world.generation.heightmap.modules.ContinentGenerator;

public class WNHeightMap {
    private final WNWorldContext context;
    private final long seed;
    private final ContinentGenerator continentGenerator;
    private final Cell cell;
    public final TerrainMap terrainMap;
    private final TerrainProvider terrainProvider;
    private final ClimateMap climateMap;

    public WNHeightMap(WNWorldContext context){
        this.context = context;
        this.seed = context.seed;
        this.cell = context.cell;
        this.continentGenerator = new ContinentGenerator(seed);
        this.terrainMap = new TerrainMap(seed);

        terrainProvider = context.terrainProvider;
        this.climateMap = new ClimateMap();
    }

    public void applyContinent(Cell cell, int dx, int dz){
        cell.continentValue = continentGenerator.generateContinent(dx, dz);
        cell.cellContinent = continentGenerator.generateContinent(cell.cellX, cell.cellZ);
    }

    public void applyClimate(Cell cell, float x, float z) {
        climateMap.apply(cell, x, z);
    }

    public void apply(Cell cell, int dx, int dz){
        terrainMap.apply(cell, dx, dz);
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
