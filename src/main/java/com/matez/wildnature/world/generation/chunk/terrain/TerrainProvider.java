package com.matez.wildnature.world.generation.chunk.terrain;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.noise.NoiseUtil;
import com.matez.wildnature.world.generation.chunk.WNWorldContext;
import com.matez.wildnature.world.generation.chunk.terrain.terrains.land.highlands.HighlandTerrain;
import com.matez.wildnature.world.generation.chunk.terrain.terrains.land.lowlands.LowlandTerrain;
import com.matez.wildnature.world.generation.chunk.terrain.terrains.land.midlands.MidlandTerrain;
import com.matez.wildnature.world.generation.chunk.terrain.terrains.land.mountains.MountainTerrain;
import com.matez.wildnature.world.generation.chunk.terrain.terrains.land.shores.ShoresTerrain;
import com.matez.wildnature.world.generation.chunk.terrain.terrains.oceans.DeepOceanTerrain;
import com.matez.wildnature.world.generation.chunk.terrain.terrains.oceans.OceanTerrain;
import com.matez.wildnature.world.generation.chunk.terrain.terrains.seas.SeaTerrain;
import com.matez.wildnature.world.generation.grid.Cell;

import java.util.ArrayList;
import java.util.List;

public class TerrainProvider {
    private final WNWorldContext context;
    private final List<Terrain> terrains = new ArrayList<>();
    private boolean init = false;
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
        register(new ShoresTerrain());
        register(new LowlandTerrain());
        register(new MidlandTerrain());
        register(new HighlandTerrain());
        register(new MountainTerrain());
    }

    private void register(Terrain terrain){
        terrains.add(terrain);
    }

    public void init(){
        for (Terrain terrain : terrains) {
            WN.LOGGER.info("Initializing terrain: " + terrain.getName());
            terrain.init();
        }
    }

    public Terrain[] filterTerrains(Cell cell) {
        List<Terrain> filter = new ArrayList<>();
        for (Terrain terrain : terrains) {
            if (cell.cellContinent >= 0.95F) {
                if (terrain.getTerrainCategory() == Terrain.Category.MOUNTAINS) {
                    filter.add(terrain);
                }
            } else if (cell.cellContinent >= 0.88F && cell.cellContinent < 0.95F) {
                if (terrain.getTerrainCategory() == Terrain.Category.HIGHLANDS) {
                    filter.add(terrain);
                }
            } else if (cell.cellContinent >= 0.53F && cell.cellContinent < 0.88F) {
                if (terrain.getTerrainCategory() == Terrain.Category.MIDLANDS) {
                    filter.add(terrain);
                }
            } else if (cell.cellContinent >= 0.30F && cell.cellContinent < 0.53F) {
                if (terrain.getTerrainCategory() == Terrain.Category.LOWLANDS) {
                    filter.add(terrain);
                }
            } else if (cell.cellContinent >= 0.15F && cell.cellContinent < 0.3F) {
                if (terrain.getTerrainCategory() == Terrain.Category.SHORE) {
                    filter.add(terrain);
                }
            } else if (cell.cellContinent >= 0.1F && cell.cellContinent < 0.15F) {
                if (terrain.getTerrainCategory() == Terrain.Category.SEA) {
                    filter.add(terrain);
                }
            } else if(cell.cellContinent >= 0.05F && cell.cellContinent < 0.1F){
                if (terrain.getTerrainCategory() == Terrain.Category.OCEAN) {
                    filter.add(terrain);
                }
            }else if(cell.cellContinent < 0.05F){
                if (terrain.getTerrainCategory() == Terrain.Category.DEEP_OCEAN) {
                    filter.add(terrain);
                }
            }
        }
        if(filter.isEmpty()){
            WN.LOGGER.warn("Terrain list is empty - continent: " + cell.cellContinent + " | Applying " + terrains.get(0).getName());
            filter.add(terrains.get(0));
        }

        return filter.toArray(new Terrain[0]);
    }

    public Terrain get(float identity) {
        if(!init){
            init();
            init = true;
        }

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