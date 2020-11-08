package com.matez.wildnature.world.generation.grid;

// Note:
// - float values between 0-1
public class Cell {
    public float value;

    //HeightMaps
    public float cellContinent; // the continent height indentity
    public float continentValue; // the continent height tile value

    public int terrainCellX;
    public int terrainCellZ;
    public float terrainCellEdge;
    public float terrainCellIdentity;

    public int biomeCellX;
    public int biomeCellZ;
    public float biomeCellEdge;
    public float biomeCellIdentity;

    public float cellTemparature = 0.5f;
    public float temparature = 0.5f;
    public float cellMoisture = 0.5f;
    public float moisture = 0.5f;

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

        cellTemparature = other.cellTemparature;
        temparature = other.temparature;
        cellMoisture = other.cellMoisture;
        moisture = other.moisture;
    }

}
