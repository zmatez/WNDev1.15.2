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

    public int subBiomeCellX;
    public int subBiomeCellZ;
    public float subBiomeCellEdge;
    public float subBiomeCellIdentity;

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

        cellTemparature = other.cellTemparature;
        temparature = other.temparature;
        cellMoisture = other.cellMoisture;
        moisture = other.moisture;
    }

}
