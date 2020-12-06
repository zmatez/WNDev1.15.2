package com.matez.wildnature.world.generation.heightmap;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.world.generation.chunk.WNWorldContext;
import com.matez.wildnature.world.generation.grid.maps.*;
import com.matez.wildnature.world.generation.grid.Cell;
import com.matez.wildnature.world.generation.heightmap.modules.ContinentGenerator;
import com.matez.wildnature.world.generation.heightmap.modules.RiverGenerator;
import com.matez.wildnature.world.generation.maps.ClimateMap;

/*
Idea for GridMap comes from TerraForged. However it was bit modified, still, apply method is the same

 * MIT License
 *
 * Copyright (c) 2020 TerraForged
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
public class WNHeightMap {
    private final WNWorldContext context;
    private final long seed;
    private final ContinentGenerator continentGenerator;
    private final RiverGenerator riverGenerator;
    private final Cell cell;

    //maps
    public final GridMap biomeMap;
    public final GridMap undergroundBiomeMap;
    public final GridMap subBiomeMap;
    public final GridMap smallIslandMap;
    public final GridMap bigIslandMap;

    private final ClimateMap climateMap;

    public WNHeightMap(WNWorldContext context) {
        this.context = context;
        this.seed = context.getSeed();
        this.cell = context.getCell();
        WN.LOGGER.debug("Created WNHeightMap with seed " + seed);
        this.continentGenerator = new ContinentGenerator(seed);
        this.riverGenerator = new RiverGenerator(seed);

        this.biomeMap = new BiomeMap(seed);
        this.undergroundBiomeMap = new UndergroundBiomeMap(seed);
        this.subBiomeMap = new SubBiomeMap(seed);
        this.smallIslandMap = new SmallIslandMap(seed);
        this.bigIslandMap = new BigIslandMap(seed);

        this.climateMap = new ClimateMap(seed);

        WN.LOGGER.debug("Created heightMap with seed " + (int)seed);
    }

    public void applyContinent(Cell cell, int dx, int dz) {
        cell.continentValue = continentGenerator.generateContinent(dx, dz);
        cell.cellContinent = continentGenerator.generateContinent(cell.biomeCellX, cell.biomeCellZ);
    }

    public void applyClimate(Cell cell, float x, float z) {
        climateMap.apply(cell, x, z);
    }

    public void applyRiver(Cell cell, int x, int z) {
        riverGenerator.generate(cell,x,z);
    }


    /**
     * Applies identifies in cell for all specified maps.
     */
    public void apply(Cell cell, int dx, int dz) {
        biomeMap.apply(cell, dx, dz);
        undergroundBiomeMap.apply(cell, dx, dz);
        subBiomeMap.apply(cell, dx, dz);
        smallIslandMap.apply(cell,dx,dz);
        bigIslandMap.apply(cell,dx,dz);

        applyContinent(cell, dx, dz);
        applyClimate(cell, dx, dz);
        applyRiver(cell,dx,dz);
    }

    public ClimateMap getClimateMap() {
        return climateMap;
    }

    public ContinentGenerator getContinent() {
        return continentGenerator;
    }

}
