package com.matez.wildnature.world.gen.biomes.terrain;

import com.matez.wildnature.Main;
import net.minecraft.world.biome.Biome;

import java.util.ArrayList;

public class BiomeTerrain {

    private ArrayList<Config> terrain = new ArrayList<>();

    public BiomeTerrain(){
        Main.LOGGER.info("Registering biome terrain...");
        //register(Biomes.MOUNTAINS,0.01D,10D,32);


        Main.LOGGER.info("Biome terrain registered.");
    }

    public ArrayList<Config> getTerrain() {
        return terrain;
    }

    public void register(Biome b, double smoothH, double smoothV, int repeat){
        Config c = new Config(b,smoothH,smoothV,repeat);
        terrain.add(c);
    }

    public static class Config{

        /**
         *
         * @param b biome
         * @param smoothH lower - smoother, higher - hillier
         * @param smoothV addional value, to test
         */

        private Biome biome;
        private double smoothH = 0.01D;
        private double smoothV = 1.0D;
        private int repeat = 16;
        public Config(Biome b, double smoothH, double smoothV, int repeat){
            this.biome=b;
            if(smoothH!=-9999){
                this.smoothH=smoothH;
            }
            if(smoothV!=-9999){
                this.smoothV=smoothV;
            }
            if(repeat!=-9999){
                this.repeat = repeat;
            }
        }

        public Biome getBiome() {
            return biome;
        }

        public double getSmoothH() {
            return smoothH;
        }

        public double getSmoothV() {
            return smoothV;
        }

        public int getRepeat() {
            return repeat;
        }
    }
}
