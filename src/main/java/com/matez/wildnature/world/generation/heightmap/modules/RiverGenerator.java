package com.matez.wildnature.world.generation.heightmap.modules;

import com.matez.wildnature.util.other.Utilities;
import com.matez.wildnature.world.generation.chunk.terrain.Terrain;
import com.matez.wildnature.world.generation.chunk.terrain.TerrainProvider;
import com.matez.wildnature.world.generation.grid.Cell;

public class RiverGenerator {
    public void generate(Cell cell){
        float continent = cell.continentValue; //mountains = small rivers | lowlands = big rivers
        float edgeRiverValley = Utilities.scaleBetween(ContinentGenerator.continentMaxValue - continent, 0.1F,0.3F,ContinentGenerator.continentMinValue,ContinentGenerator.continentMaxValue);
        float edgeRiver = Utilities.scaleBetween(ContinentGenerator.continentMaxValue - continent, 0.05F,0.1F,ContinentGenerator.continentMinValue,ContinentGenerator.continentMaxValue);
        Terrain.Category category = TerrainProvider.getCategoryFromContinent(continent);
        if(category != Terrain.Category.DEEP_OCEAN && category != Terrain.Category.OCEAN){
            float edge = cell.biomeCellEdge;
            if(edge < edgeRiverValley){
                cell.riverValleyValue = Utilities.scaleBetween(edge, 0F,1F,0F,0.2F);
                if(edge < edgeRiver){
                    cell.riverValue = Utilities.scaleBetween(edge, 0F,1F,0F,0.05F);
                }
            }
        }else{
            cell.riverValleyValue = 0;
            cell.riverValue = 0;
        }
    }
}
