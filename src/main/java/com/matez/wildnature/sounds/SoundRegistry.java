package com.matez.wildnature.sounds;

import com.matez.wildnature.Main;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class SoundRegistry {
    public static SoundEvent PISTON_2s_OPEN = registerSound("block.piston.2s_open");
    public static SoundEvent PISTON_3s_OPEN = registerSound("block.piston.3s_open");
    public static SoundEvent PISTON_2s_CLOSE = registerSound("block.piston.2s_close");
    public static SoundEvent PISTON_3s_CLOSE = registerSound("block.piston.3s_close");
    public static SoundEvent STEAM_GENERATOR = registerSound("block.steam_generator");

    //ANIMAL
    public static SoundEvent DUCK_FLAP = registerSound("entity.duck.flap");
    public static SoundEvent DUCK_QUACK = registerSound("entity.duck.quack");
    public static SoundEvent DUCK_SCARED = registerSound("entity.duck.scared");
    public static SoundEvent DUCK_CHICK = registerSound("entity.duck.chick");

    public static SoundEvent DEER_BUCKGRUNT = registerSound("entity.deer.buckgrunt");
    public static SoundEvent DEER_DOEGRUNT = registerSound("entity.deer.doegrunt");
    public static SoundEvent DEER_SNORT = registerSound("entity.deer.snort");
    public static SoundEvent DEER_SNORT2 = registerSound("entity.deer.snort2");
    public static SoundEvent DEER_CONTACT = registerSound("entity.deer.contact");
    public static SoundEvent DEER_HURT = registerSound("entity.deer.hurt");
    public static SoundEvent DEER_DEATH = registerSound("entity.deer.death");


    public static SoundEvent BOAR_DEATH = registerSound("entity.boar.death");
    public static SoundEvent BOAR_SNORT = registerSound("entity.boar.snort");
    public static SoundEvent BOAR_SCARED = registerSound("entity.boar.scared");
    public static SoundEvent BOAR_OINK = registerSound("entity.boar.oink");

    public static SoundEvent DRAGONFLY_HURT = registerSound("entity.dragonfly.hurt");
    public static SoundEvent DRAGONFLY_FLAP = registerSound("entity.dragonfly.flap");

    //AMBIENT
    /*
    public static SoundEvent DENSEFOREST_DAY_0 = registerSound("ambient.denseforest_day_0");
    public static SoundEvent DENSEFOREST_DAY_1 = registerSound("ambient.denseforest_day_1");
    public static SoundEvent DENSEFOREST_DAY_2 = registerSound("ambient.denseforest_day_2");
    public static SoundEvent DENSEFOREST_DAY_3 = registerSound("ambient.denseforest_day_3");
    public static SoundEvent DENSEFOREST_DAY_4 = registerSound("ambient.denseforest_day_4");
    public static SoundEvent DENSEFOREST_NIGHT_0 = registerSound("ambient.denseforest_night_0");
    public static SoundEvent DENSEFOREST_OPENFIELD_DAY_0 = registerSound("ambient.denseforest_openfield_day_0");
    public static SoundEvent DENSEFOREST_OPENFIELD_DAY_1 = registerSound("ambient.denseforest_openfield_day_1");
    public static SoundEvent MOUNTAINS_0 = registerSound("ambient.denseforest_mountains_0");
    public static SoundEvent PLAINS_0 = registerSound("ambient.denseforest_plains_0");
    public static SoundEvent PLAINS_1 = registerSound("ambient.denseforest_plains_1");
    public static SoundEvent REDWOODFOREST_DAY_0 = registerSound("ambient.redwoodforest_day_0");*/

    public static SoundEvent[] register(){
        return new SoundEvent[]{
                PISTON_2s_OPEN,
                PISTON_3s_OPEN,
                PISTON_2s_CLOSE,
                PISTON_3s_CLOSE,
                STEAM_GENERATOR,
                DUCK_FLAP,
                DUCK_QUACK,
                DUCK_SCARED,
                DUCK_CHICK,
                DEER_BUCKGRUNT,
                DEER_DOEGRUNT,
                DEER_SNORT,
                DEER_SNORT2,
                DEER_CONTACT,
                DEER_HURT,
                DEER_DEATH
                /*DENSEFOREST_DAY_0,
                DENSEFOREST_DAY_1,
                DENSEFOREST_DAY_2,
                DENSEFOREST_DAY_3,
                DENSEFOREST_DAY_4,
                DENSEFOREST_NIGHT_0,
                DENSEFOREST_OPENFIELD_DAY_0,
                DENSEFOREST_OPENFIELD_DAY_1,
                MOUNTAINS_0,
                PLAINS_0,
                PLAINS_1,
                REDWOODFOREST_DAY_0*/


        };
    }

    private static SoundEvent registerSound(String soundName)
    {
        //soundID;//SoundEvent soundID = IRegistry.field_212633_v.func_212608_b(new ResourceLocation(soundName));
        final ResourceLocation soundID = Main.RegistryEvents.location(soundName);
        return new SoundEvent(soundID).setRegistryName(soundID);
    }
}
