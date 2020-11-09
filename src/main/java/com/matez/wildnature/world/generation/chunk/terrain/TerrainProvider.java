package com.matez.wildnature.world.generation.chunk.terrain;

import com.matez.wildnature.util.noise.NoiseUtil;
import com.matez.wildnature.world.generation.chunk.WNWorldContext;
import com.matez.wildnature.world.generation.chunk.terrain.terrains.OceanTerrain;
import com.matez.wildnature.world.generation.chunk.terrain.terrains.PlainTerrain;
import com.matez.wildnature.world.generation.grid.Cell;

import java.util.ArrayList;
import java.util.List;

public class TerrainProvider {
    private final WNWorldContext context;
    private final List<Terrain> terrains = new ArrayList<>();
    public Terrain[] terrainIndex;

    public TerrainProvider(WNWorldContext context) {
        this.context = context;
        this.registerTerrains();
        this.terrainIndex = filterTerrains(context.getCell());
    }

    private void registerTerrains() {
        register(new PlainTerrain());
        register(new OceanTerrain());
    }

    private void register(Terrain terrain){
        terrains.add(terrain);
    }

    public Terrain[] filterTerrains(Cell cell) {
        List<Terrain> filter = new ArrayList<>();
        for (Terrain terrain : terrains) {
            if (cell.cellContinent > 0.95) {
                if (terrain.getCategory() == Terrain.Category.MOUNTAINS) {
                    filter.add(terrain);
                }
            } else if (cell.cellContinent > 0.85) {
                if (terrain.getCategory() == Terrain.Category.HIGHLANDS) {
                    filter.add(terrain);
                }
            } else if (cell.cellContinent > 0.48) {
                if (terrain.getCategory() == Terrain.Category.MIDLANDS) {
                    filter.add(terrain);
                }
            } else if (cell.cellContinent > 0.24) {
                if (terrain.getCategory() == Terrain.Category.LOWLANDS) {
                    filter.add(terrain);
                }
            } else if (cell.cellContinent > 0.12) {
                if (terrain.getCategory() == Terrain.Category.SHORE) {
                    filter.add(terrain);
                }
            } else if (cell.cellContinent > 0.05) {
                if (terrain.getCategory() == Terrain.Category.SEA) {
                    filter.add(terrain);
                }
            } else {
                if (terrain.getCategory() == Terrain.Category.OCEAN) {
                    filter.add(terrain);
                }
            }
        }
        if(filter.isEmpty()){
            filter.add(new PlainTerrain());
        }

        return filter.toArray(new Terrain[0]);
    }

    public Terrain get(float identity) {
        int index = NoiseUtil.round(identity * (terrainIndex.length - 1));
        return filterTerrains(context.getCell())[index];
    }

    public List<Terrain> getTerrains() {
        return terrains;
    }

    public TerrainProvider create() {
        return new TerrainProvider(context);
    }

}