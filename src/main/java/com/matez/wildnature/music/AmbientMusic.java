package com.matez.wildnature.music;


import net.minecraft.client.audio.ISound;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;

import java.util.ArrayList;
import java.util.Arrays;

public class AmbientMusic  {
    public static ArrayList<BiomeMusic> biomeMusics = new ArrayList<>();
    public AmbientMusic(){
        System.out.println("Registering Ambient Music Module");
        //new BiomeMusic(Main.getBiomeByID("wildnature:deciduous_forest"), Biome.RainType.NONE,DayTime.DAY,0, SoundRegistry.DENSEFOREST_DAY_0);

       // new BiomeMusic(Main.getBiomeByID("wildnature:deciduous_forest"), Biome.RainType.NONE,DayTime.DAY,0,1F, SoundRegistry.DENSEFOREST_DAY_0, SoundRegistry.DENSEFOREST_DAY_1, SoundRegistry.DENSEFOREST_DAY_2, SoundRegistry.DENSEFOREST_DAY_3, SoundRegistry.DENSEFOREST_DAY_4);
//        new BiomeMusic(Main.getBiomeByID("wildnature:deciduous_forest"), Biome.RainType.NONE,DayTime.NIGHT,0,1F, SoundRegistry.DENSEFOREST_NIGHT_0);


        System.out.println("Registered musics for " + biomeMusics.size() + " biomes.");
    }

    public static class BiomeMusic{
        private Biome biome;
        private Biome.RainType rainType;
        private DayTime dayTime;
        private int repeatDelay =0;
        private double volume=0;
        private ArrayList<SoundEvent> soundEvents;
        public BiomeMusic(Biome biome, Biome.RainType type,DayTime dayTime, int repeatDelay, double volume, SoundEvent... events){
            this.biome=biome;
            this.rainType=type;
            this.dayTime=dayTime;
            this.repeatDelay=repeatDelay;
            this.volume=volume;
            this.soundEvents=new ArrayList<>(Arrays.asList(events));
            AmbientMusic.biomeMusics.add(this);
        }

        public double getVolume() {
            return volume;
        }

        public Biome getBiome() {
            return biome;
        }

        public ArrayList<SoundEvent> getSoundEvents() {
            return soundEvents;
        }

        public Biome.RainType getRainType() {
            return rainType;
        }

        public int getRepeatDelay() {
            return repeatDelay;
        }

        public DayTime getDayTime() {
            return dayTime;
        }

        public boolean contains(ISound sound){
            if(sound==null){
                return false;
            }
            for (SoundEvent e : soundEvents){
                if(e.getName()==sound.getSoundLocation()){
                    return true;
                }
            }
            return false;
        }

        public static void applySameAs(Biome biome, Biome as, Biome.RainType type,DayTime dayTime, int repeatDelay, double volume){
            for (BiomeMusic m : biomeMusics){
                Biome b = m.getBiome();
                if(b==biome){
                    new BiomeMusic(as,type,dayTime,repeatDelay,volume,(SoundEvent[])m.getSoundEvents().toArray());
                }
            }
        }
    }

    public enum DayTime{
        DAY(),
        NIGHT(),
        NONE()
    }

    public enum MusicPosition{
        CAVES(),
        SURFACE(),
        NONE()
    }

}
