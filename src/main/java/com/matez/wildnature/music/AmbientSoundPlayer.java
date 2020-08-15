package com.matez.wildnature.music;

import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.customizable.CommonConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.SimpleSound;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.ArrayList;

public class AmbientSoundPlayer{
    private World world;
    private Minecraft client;
    private ISound currentMusic;
    private AmbientMusic.BiomeMusic currentBiomeMusic;
    private PlayerEntity entity;
    private Biome currentBiome, oldBiome;
    private AmbientMusic.DayTime currentDayTime = AmbientMusic.DayTime.NONE;
    private Biome.RainType currentRainType = Biome.RainType.NONE;
    private int tps = 20;
    private boolean isDay = true;
    private boolean isRaining = false;
    public AmbientSoundPlayer(Minecraft client){
        System.out.println("Registering Ambient Sound Player");
        this.client=client;
    }



    @SubscribeEvent
    public void playerTick(TickEvent.PlayerTickEvent event){
        world = event.player.getEntityWorld();
        entity = event.player;
        isDay = !(world.getDayTime()>=13800&&world.getDayTime()<22500);


        if(client !=null){
            currentBiome=world.getBiome(entity.getPosition());
            isRaining=world.isRaining();

            if(isDay){
                currentDayTime= AmbientMusic.DayTime.DAY;
            }else{
                currentDayTime= AmbientMusic.DayTime.NIGHT;
            }
            if(isRaining){
                currentRainType= Biome.RainType.RAIN;
            }else{
                currentRainType= Biome.RainType.NONE;
            }

            if(oldBiome==null){
                oldBiome=currentBiome;
            }else{
                if(currentBiome!=oldBiome){
                    System.out.println("Play for: " + currentBiome.getRegistryName());
                    AmbientMusic.BiomeMusic music = getValidSound(currentBiome);
                    if(music!=null) {
                        ArrayList<SoundEvent> soundEvents = music.getSoundEvents();
                        if (soundEvents != null) {
                            stopAndPlaySoundToPlayer(soundEvents.get(Utilities.rint(0, soundEvents.size() - 1)), music.getRepeatDelay(),music.getVolume());
                        }
                    }
                    oldBiome=currentBiome;
                }
            }

            if(this.currentBiomeMusic!=null) {
                if (!this.client.getSoundHandler().isPlaying(this.currentMusic) && !this.currentBiomeMusic.contains(this.currentMusic)) {
                    //music stopped
                    this.currentMusic = null;
                    AmbientMusic.BiomeMusic music = getValidSound(currentBiome);
                    if (music != null) {
                        ArrayList<SoundEvent> soundEvents = music.getSoundEvents();
                        if (soundEvents != null) {
                            stopAndPlaySoundToPlayer(soundEvents.get(Utilities.rint(0, soundEvents.size() - 1)), music.getRepeatDelay(),music.getVolume());
                        }
                    }
                }

                /*if(currentBiomeMusic.getDayTime()!=AmbientMusic.DayTime.NONE && currentBiomeMusic.getDayTime()!=currentDayTime){
                    if(currentBiomeMusic.getDayTime()==AmbientMusic.DayTime.DAY && !isDay){
                        this.currentMusic = null;
                        AmbientMusic.BiomeMusic music = getValidSound(currentBiome);
                        if (music != null) {
                            ArrayList<SoundEvent> soundEvents = music.getSoundEvents();
                            if (soundEvents != null) {
                                stopAndPlaySoundToPlayer(soundEvents.get(Utilities.rint(0, soundEvents.size() - 1)), music.getRepeatDelay(),music.getVolume());
                            }
                        }
                    }
                }

                if(currentBiomeMusic.getDayTime()!=AmbientMusic.DayTime.NONE && currentBiomeMusic.getDayTime()!=currentDayTime){
                    if(currentBiomeMusic.getDayTime()==AmbientMusic.DayTime.NIGHT && isDay){
                        this.currentMusic = null;
                        AmbientMusic.BiomeMusic music = getValidSound(currentBiome);
                        if (music != null) {
                            ArrayList<SoundEvent> soundEvents = music.getSoundEvents();
                            if (soundEvents != null) {
                                stopAndPlaySoundToPlayer(soundEvents.get(Utilities.rint(0, soundEvents.size() - 1)), music.getRepeatDelay(),music.getVolume());
                            }
                        }
                    }
                }

                if(currentBiomeMusic.getRainType()!=currentRainType){
                    this.currentMusic = null;
                    AmbientMusic.BiomeMusic music = getValidSound(currentBiome);
                    if (music != null) {
                        ArrayList<SoundEvent> soundEvents = music.getSoundEvents();
                        if (soundEvents != null) {
                            stopAndPlaySoundToPlayer(soundEvents.get(Utilities.rint(0, soundEvents.size() - 1)), music.getRepeatDelay(),music.getVolume());
                        }
                    }
                }*/
            }

            /*if(currentBiomeMusic!=null){
                if(currentBiomeMusic.getDayTime()!= AmbientMusic.DayTime.NONE && currentBiomeMusic.getDayTime()!=currentDayTime){
                    if(currentBiomeMusic.getDayTime()== AmbientMusic.DayTime.DAY && !isDay){
                        //stop the music for
                        AmbientMusic.BiomeMusic music = getValidSound(currentBiome);
                        if(music!=null) {
                            ArrayList<SoundEvent> soundEvents = music.getSoundEvents();
                            if (soundEvents != null) {
                                stopAndPlaySoundToPlayer(soundEvents.get(Utilities.rint(0, soundEvents.size() - 1)), music.getRepeatDelay(),music.getVolume());
                            }
                        }
                    }
                    if(currentBiomeMusic.getDayTime()== AmbientMusic.DayTime.NIGHT && isDay){
                        //stop the music for the day and play for the night
                        AmbientMusic.BiomeMusic music = getValidSound(currentBiome);
                        if(music!=null) {
                            ArrayList<SoundEvent> soundEvents = music.getSoundEvents();
                            if (soundEvents != null) {
                                stopAndPlaySoundToPlayer(soundEvents.get(Utilities.rint(0, soundEvents.size() - 1)), music.getRepeatDelay(),music.getVolume());
                            }
                        }
                    }
                }

                if(currentBiomeMusic.getRainType()!= Biome.RainType.NONE  && currentBiomeMusic.getRainType()!=currentRainType){
                    if(isRaining){
                        AmbientMusic.BiomeMusic music = getValidSound(currentBiome);
                        if(music!=null) {
                            ArrayList<SoundEvent> soundEvents = music.getSoundEvents();
                            if (soundEvents != null) {
                                stopAndPlaySoundToPlayer(soundEvents.get(Utilities.rint(0, soundEvents.size() - 1)), music.getRepeatDelay(),music.getVolume());
                            }
                        }
                    }
                }
            }*/

        }


    }

    public AmbientMusic.BiomeMusic getValidSound(Biome b){
        AmbientMusic.BiomeMusic m = null;
        System.out.println("Searching music: day = " + isDay + " raining = " + isRaining);
        for(int i = 0; i<AmbientMusic.biomeMusics.size(); i++){
            if(AmbientMusic.biomeMusics.get(i).getBiome()==b){
                AmbientMusic.BiomeMusic mm = AmbientMusic.biomeMusics.get(i);
                if(isDay&&mm.getDayTime()== AmbientMusic.DayTime.NIGHT){
                    continue;
                }
                if(!isDay&&mm.getDayTime()== AmbientMusic.DayTime.DAY){
                    continue;
                }

                if(isRaining&&mm.getRainType()!= Biome.RainType.NONE){
                    continue;
                }

                System.out.println("Found sound: " + AmbientMusic.biomeMusics.get(i).getSoundEvents().get(0).getName() + " " + AmbientMusic.biomeMusics.get(i).getBiome().getRegistryName());
                m=AmbientMusic.biomeMusics.get(i);
                break;
            }
        }

        currentBiomeMusic=m;
        if(m!=null) {
            currentRainType = currentBiomeMusic.getRainType();
            currentDayTime = currentBiomeMusic.getDayTime();
        }else{
            stop();
            currentRainType = null;
            currentDayTime = null;
        }
        return m;
    }

    public void stopAndPlaySoundToPlayer(SoundEvent event, int repeatDelay, double volume){
        if(event!=null){
            System.out.println("playing: " + event.getName());
            play(event, repeatDelay, volume);
            System.out.println("is playing? " + this.client.getSoundHandler().isPlaying(currentMusic));
        }


    }

    public void play(SoundEvent event, int repeatDelay, double volume) {
        ISound sound = ambient(event,(float)(CommonConfig.ambientSoundsVolume.get()+0F),repeatDelay);
        System.out.println("PLAYING: " + sound.getSoundLocation() + " " + currentBiomeMusic.getBiome().getRegistryName());
        this.client.getSoundHandler().play(sound);
        this.currentMusic=sound;
    }

    public void stop() {
        try{
            System.out.println("stopping: " + currentMusic.getSoundLocation());
            this.client.getSoundHandler().stop(this.currentMusic);
            this.currentMusic = null;
        }catch (Exception e){
            System.out.println("cannot stop");

        }


    }

    public static SimpleSound ambient(SoundEvent soundIn, float volumeIn, int repeatDelay) {
        return new SimpleSound(soundIn.getName(), SoundCategory.AMBIENT, volumeIn, 1, false, repeatDelay, ISound.AttenuationType.NONE, 0.0F, 0.0F, 0.0F, true);
    }

}
