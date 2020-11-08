package com.matez.wildnature.world.generation.grid;

// Note:
// - float values between 0-1
public class Cell {

    public float value;

    //HeightMaps
    public float cellContinent; // the continent height indentity
    public float continentValue; // the continent height tile value

    public int cellX;
    public int cellZ;
    public float cellEdge;
    public float cellIdentity;

    //Variable Cell Data
    public float cellTemparature = 0.5f;
    public float temparature = 0.5f;
    public float cellMoisture = 0.5f;
    public float moisture = 0.5f;

    //public Terrain.Category terrain = Terrain.Category.VOID;

    public void copy(Cell other) {
        value = other.value;
        cellContinent = other.cellContinent;
        continentValue = other.continentValue;

        cellX = other.cellX;
        cellZ = other.cellZ;
        cellIdentity = other.cellIdentity;
        cellEdge = other.cellEdge;

        cellTemparature = other.cellTemparature;
        temparature = other.temparature;
        cellMoisture = other.cellMoisture;
        moisture = other.moisture;

        //terrain = other.terrain;
    }

}
