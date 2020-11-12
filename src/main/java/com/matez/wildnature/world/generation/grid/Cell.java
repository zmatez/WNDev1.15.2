package com.matez.wildnature.world.generation.grid;

// Note:
// - float values between 0-1
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

    public void copy(Cell other) {
        value = other.value;
        cellContinent = other.cellContinent;
        continentValue = other.continentValue;

        terrainCellX = other.terrainCellX;
        terrainCellZ = other.terrainCellZ;
        terrainCellIdentity = other.terrainCellIdentity;
        terrainCellEdge = other.terrainCellEdge;

        biomeCellX = other.biomeCellX;
        biomeCellZ = other.biomeCellZ;
        biomeCellIdentity = other.biomeCellIdentity;
        biomeCellEdge = other.biomeCellEdge;

        subBiomeCellX = other.subBiomeCellX;
        subBiomeCellZ = other.subBiomeCellZ;
        subBiomeCellIdentity = other.subBiomeCellIdentity;
        subBiomeCellEdge = other.subBiomeCellEdge;
        
        smallIslandCellX = other.smallIslandCellX;
        smallIslandCellZ = other.smallIslandCellZ;
        smallIslandCellIdentity = other.smallIslandCellIdentity;
        smallIslandCellEdge = other.smallIslandCellEdge;

        bigIslandCellX = other.bigIslandCellX;
        bigIslandCellZ = other.bigIslandCellZ;
        bigIslandCellIdentity = other.bigIslandCellIdentity;
        bigIslandCellEdge = other.bigIslandCellEdge;

        cellTemparature = other.cellTemparature;
        temparature = other.temparature;
        cellMoisture = other.cellMoisture;
        moisture = other.moisture;
    }

}
