package com.matez.wildnature.world.generation.structures.utils;

import com.matez.wildnature.util.other.WeightedList;
import com.matez.wildnature.world.generation.structures.WNAbstractStructure;

import java.util.Random;

public class StructureEntry {
    private WeightedList<WNAbstractStructure> structures = new WeightedList<>();
    private int spawnChance;
    public StructureEntry(int spawnChance){
        this.spawnChance = spawnChance;
    }

    public StructureEntry add(WNAbstractStructure structure, int weight){
        structures.add(structure,weight);
        return this;
    }

    public WNAbstractStructure getWeightedEntry(){
        return structures.getWeightedEntry();
    }

    public WNAbstractStructure getWeightedEntry(Random random){
        return structures.getWeightedEntry(random);
    }

    public boolean hasStructure(WNAbstractStructure structure){
        for (WNAbstractStructure object : structures.getObjects()) {
            if(object == structure){
                return true;
            }
        }
        return false;
    }

    public int getSpawnChance() {
        return spawnChance;
    }
}
