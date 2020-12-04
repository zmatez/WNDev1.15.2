package com.matez.wildnature.client.music;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.other.Utilities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.MusicTicker;
import net.minecraft.client.audio.SimpleSound;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.ArrayList;
import java.util.Random;

public class WNMusicPlayer extends MusicTicker {
    private Minecraft client;
    private static World world;
    private static PlayerEntity player;

    private WNMusic.MusicType currentMusicType;

    private Biome currentBiome, oldBiome;
    private DimensionType currentDimension, oldDimension;

    private WNMusic.DayTime currentDayTime = WNMusic.DayTime.NONE;
    private Biome.RainType currentRainType = Biome.RainType.NONE;
    private WNMusic.MusicPosition currentMusicPosition = WNMusic.MusicPosition.NONE;

    private int musicSeed = 0;
    private int timeUntilNextMusic;

    private Random random = new Random();
    private boolean playingWNMusic = false;

    public WNMusicPlayer(Minecraft client) {
        super(client);
        this.client = client;
        System.out.println("Registering WildNature Music Player");
    }

    @Override
    public void tick() {
        updateVariables();

        MusicTicker.MusicType musicticker$musictype = this.client.getAmbientMusicType();
        if (this.currentMusic != null) {
            if (!musicticker$musictype.getSound().getName().equals(this.currentMusic.getSoundLocation()) && !playingWNMusic) {
                this.client.getSoundHandler().stop(this.currentMusic);
                this.timeUntilNextMusic = MathHelper.nextInt(this.random, 0, musicticker$musictype.getMinDelay() / 2);
            }

            if (!this.client.getSoundHandler().isPlaying(this.currentMusic)) {
                this.currentMusic = null;
                this.timeUntilNextMusic = Math.min(MathHelper.nextInt(this.random, musicticker$musictype.getMinDelay(), musicticker$musictype.getMaxDelay()), this.timeUntilNextMusic);
            }
        }

        this.timeUntilNextMusic = Math.min(this.timeUntilNextMusic, musicticker$musictype.getMaxDelay());
        if (this.currentMusic == null && this.timeUntilNextMusic-- <= 0) {
            playingWNMusic = Utilities.rint(0,1,random) == 0;

            if(playingWNMusic){
                WNMusic.MusicType typeToPlay = getValidSound();
                if(typeToPlay != null){
                    ArrayList<SoundEvent> soundEvents = typeToPlay.getSoundEvents();
                    SoundEvent soundEvent = null;
                    if(!soundEvents.isEmpty()){
                        if(soundEvents.size() == 1){
                            soundEvent = soundEvents.get(0);
                        }else{
                            Random random = new Random(musicSeed);
                            soundEvent = soundEvents.get(Utilities.rint(0,soundEvents.size()-1, random));
                        }
                        stopAndPlay(typeToPlay, soundEvent,0,1);
                        playingWNMusic = true;
                    }else{
                        playingWNMusic = false;
                    }
                }else{
                    playingWNMusic = false;
                }
            }
            if(!playingWNMusic) {
                this.play(musicticker$musictype);
            }
        }
    }

    @SubscribeEvent
    public static void playerTick(TickEvent.PlayerTickEvent event) {
        world = event.player.getEntityWorld();
        player = event.player;
        if(!(Minecraft.getInstance().musicTicker instanceof WNMusicPlayer)){
            Minecraft.getInstance().musicTicker = new WNMusicPlayer(Minecraft.getInstance());
        }

    }

    private void updateVariables(){
        if(!(world.getDayTime() >= 13800 && world.getDayTime() < 22500)){
            //day
            currentDayTime = WNMusic.DayTime.DAY;
        }else{
            //night
            currentDayTime = WNMusic.DayTime.NIGHT;
        }

        currentDimension = world.getDimension().getType();
        currentBiome = world.getBiome(player.getPosition());

        if(player.getPosition().getY() > world.getSeaLevel() - 5){
            currentMusicPosition = WNMusic.MusicPosition.SURFACE;
        }else{
            if(BiomeDictionary.hasType(currentBiome, BiomeDictionary.Type.OCEAN)){
                currentMusicPosition = WNMusic.MusicPosition.UNDERWATER;
            }else{
                currentMusicPosition = WNMusic.MusicPosition.UNDERGROUND;
            }
        }
    }

    public WNMusic.MusicType getValidSound() {
        ArrayList<WNMusic.MusicType> validMusicTypes = new ArrayList<>();
        for (WNMusic.MusicType musicType : WNMusic.musicTypes) {
            if(musicType.getDimension() == currentDimension || musicType.getDimension() == null){
                if(musicType.getBiome() == currentBiome || musicType.getBiome() == null){
                    if(musicType.getDayTime() == currentDayTime || musicType.getDayTime() == WNMusic.DayTime.NONE){
                        if(musicType.getRainType() == currentRainType || musicType.getRainType() == Biome.RainType.NONE){
                            if(musicType.getPosition() == currentMusicPosition || musicType.getPosition() == WNMusic.MusicPosition.NONE){
                                validMusicTypes.add(musicType);
                            }
                        }
                    }
                }
            }
        }

        if(validMusicTypes.isEmpty()){
            return null;
        }else if(validMusicTypes.size() == 1){
            return validMusicTypes.get(0);
        }
        Random random = new Random(musicSeed);
        return validMusicTypes.get(Utilities.rint(0,validMusicTypes.size()-1, random));
    }

    public void stopAndPlay(WNMusic.MusicType type, SoundEvent event, int repeatDelay, double volume) {
        if(currentMusic != null){
            stop();
        }
        if (event != null) {
            play(type, event, repeatDelay, volume);
        }
    }

    public void play(WNMusic.MusicType type, SoundEvent event, int repeatDelay, double volume) {
        ISound sound = musicSound(event, (float) (volume), repeatDelay);
        this.client.getSoundHandler().play(sound);
        this.currentMusic = sound;
        this.currentMusicType = type;
    }

    public void stop() {
        musicSeed++;
        this.client.getSoundHandler().stop(this.currentMusic);
        this.currentMusic = null;
    }

    public static SimpleSound musicSound(SoundEvent soundIn, float volumeIn, int repeatDelay) {
        return new SimpleSound(soundIn.getName(), SoundCategory.MUSIC, volumeIn, 1, false, repeatDelay, ISound.AttenuationType.NONE, 0.0F, 0.0F, 0.0F, true);
    }

}
