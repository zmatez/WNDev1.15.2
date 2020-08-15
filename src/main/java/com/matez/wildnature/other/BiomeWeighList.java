package com.matez.wildnature.other;

import net.minecraft.world.biome.Biome;

import java.util.ArrayList;

public class BiomeWeighList {

    protected ArrayList<Biome> Biomes;
    protected ArrayList<Integer> weigh;

    public BiomeWeighList(){
        Biomes  = new ArrayList<>();
        weigh  = new ArrayList<>();
    }

    public ArrayList<Biome> getNormalArrayList(){
        ArrayList<Biome> states = new ArrayList<>();
        int x = 0;
        while(x<this.size()){
            int a = this.getWeighList().get(x);
            int z = 0;
            while(z<a){
                states.add(this.getBiomeList().get(x));
                z++;
            }
            x++;
        }


        return states;
    }

    public void add(Biome Biome, Integer iWeigh){


        Biomes.add(Biome);
        weigh.add(iWeigh);
    }

    public void remove(Biome Biome, Integer iWeigh){
        Biomes.remove(Biome);
        weigh.remove(iWeigh);
    }

    public void remove(Biome Biome){
        weigh.remove(weigh.get(Biomes.indexOf(Biome)));
        Biomes.remove(Biome);
    }

    public void clear(){
        weigh.clear();
        Biomes.clear();
    }

    public Integer size(){

        if(checkIfEquals()){
            return Biomes.size();
        }else{
            return -99999;
        }

    }


    public boolean checkIfEquals(){
        if(Biomes.size()==weigh.size()){
            return true;
        }else{
            return false;
        }
    }

    public ArrayList<Integer> getWeighList(){
        return weigh;
    }

    public ArrayList<Biome> getBiomeList(){
        return Biomes;
    }

}