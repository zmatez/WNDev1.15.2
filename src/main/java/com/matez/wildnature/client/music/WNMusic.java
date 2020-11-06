package com.matez.wildnature.client.music;


import com.matez.wildnature.client.sounds.SoundRegistry;
import net.minecraft.client.audio.ISound;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;

import java.util.ArrayList;
import java.util.Arrays;

public class WNMusic {
    public static ArrayList<MusicType> musicTypes = new ArrayList<>();

    public WNMusic() {
        System.out.println("Registering Ambient Music Module");
        new MusicType(null, DimensionType.OVERWORLD, Biome.RainType.NONE,DayTime.NONE,MusicPosition.UNDERGROUND,0,1, SoundRegistry.CAVE1);

        System.out.println("Registered musics for " + musicTypes.size() + " biomes.");
    }

    public static class MusicType {
        private Biome biome;
        private DimensionType dimension;
        private Biome.RainType rainType;
        private DayTime dayTime;
        private MusicPosition position;
        private int repeatDelay = 0;
        private double volume = 0;
        private ArrayList<SoundEvent> soundEvents;

        public MusicType(Biome biome, DimensionType dimension, Biome.RainType type, DayTime dayTime, MusicPosition position, int repeatDelay, double volume, SoundEvent... events) {
            this.biome = biome;
            this.dimension = dimension;
            this.rainType = type;
            this.dayTime = dayTime;
            this.position = position;
            this.repeatDelay = repeatDelay;
            this.volume = volume;
            this.soundEvents = new ArrayList<>(Arrays.asList(events));
            WNMusic.musicTypes.add(this);
        }

        public double getVolume() {
            return volume;
        }

        public Biome getBiome() {
            return biome;
        }

        public DimensionType getDimension() {
            return dimension;
        }

        public boolean canPlayAnywhere(DimensionType dimension){
            return biome == null && this.dimension == dimension;
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

        public MusicPosition getPosition() {
            return position;
        }

        public boolean contains(ISound sound) {
            if (sound == null) {
                return false;
            }
            for (SoundEvent e : soundEvents) {
                if (e.getName() == sound.getSoundLocation()) {
                    return true;
                }
            }
            return false;
        }

        public static void applySameAs(DimensionType dimension, Biome biome, Biome as, Biome.RainType type, DayTime dayTime, MusicPosition position, int repeatDelay, double volume) {
            for (MusicType m : musicTypes) {
                Biome b = m.getBiome();
                if (b == biome) {
                    new MusicType(as, dimension, type, dayTime, position, repeatDelay, volume, (SoundEvent[]) m.getSoundEvents().toArray());
                }
            }
        }
    }

    public enum DayTime {
        DAY(),
        NIGHT(),
        NONE()
    }

    public enum MusicPosition {
        UNDERGROUND(),
        UNDERWATER(),
        SURFACE(),
        NONE()
    }

}
