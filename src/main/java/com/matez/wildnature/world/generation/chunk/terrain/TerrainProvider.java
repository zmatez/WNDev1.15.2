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
            Terrain.Category category = getCategoryFromContinent(cell.cellContinent);
            if(terrain.getTerrainCategory() == category){
                filter.add(terrain);
            }
        }
        if(filter.isEmpty()){
            WN.LOGGER.warn("Terrain list is empty - continent: " + cell.cellContinent + " | Applying " + terrains.get(0).getName());
            filter.add(terrains.get(0));
        }

        return filter.toArray(new Terrain[0]);
    }
    
    public static Terrain.Category getCategoryFromContinent(float cellContinent){
        if (cellContinent >= 0.95F) {
            return Terrain.Category.MOUNTAINS;
        } else if (cellContinent >= 0.88F && cellContinent < 0.95F) {
            return Terrain.Category.HIGHLANDS;
        } else if (cellContinent >= 0.53F && cellContinent < 0.88F) {
            return Terrain.Category.MIDLANDS;
        } else if (cellContinent >= 0.30F && cellContinent < 0.53F) {
            return Terrain.Category.LOWLANDS;
        } else if (cellContinent >= 0.15F && cellContinent < 0.3F) {
            return Terrain.Category.SHORE;
        } else if (cellContinent >= 0.1F && cellContinent < 0.15F) {
            return Terrain.Category.SEA;
        } else if(cellContinent >= 0.05F && cellContinent < 0.1F){
            return Terrain.Category.OCEAN;
        }else{
            return Terrain.Category.DEEP_OCEAN;
        }
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