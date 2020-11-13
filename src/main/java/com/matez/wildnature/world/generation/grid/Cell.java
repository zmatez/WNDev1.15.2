package com.matez.wildnature.world.generation.grid;

// Note:
// - float values between 0-1
/*
Idea for Cell comes from TerraForged.

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
public class Cell {
    public float value;

    //HeightMaps
    public float cellContinent; // the continent height indentity
    public float continentValue; // the continent height tile value

    //terrain
    public int terrainCellX;
    public int terrainCellZ;
    public float terrainCellEdge;
    public float terrainCellIdentity;

    //biomeGroups
    public int biomeCellX;
    public int biomeCellZ;
    public float biomeCellEdge;
    public float biomeCellIdentity;

    //subBiomeGroups
    public int subBiomeCellX;
    public int subBiomeCellZ;
    public float subBiomeCellEdge;
    public float subBiomeCellIdentity;

    //smallIslands
    public int smallIslandCellX;
    public int smallIslandCellZ;
    public float smallIslandCellEdge;
    public float smallIslandCellIdentity;

    //bigIslands
    public int bigIslandCellX;
    public int bigIslandCellZ;
    public float bigIslandCellEdge;
    public float bigIslandCellIdentity;
    
    public float cellTemparature;
    public float temparature;
    public float cellMoisture;
    public float moisture;
}
