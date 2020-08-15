package com.matez.wildnature.blocks.config;

import com.matez.wildnature.customizable.CommonConfig;

public class ConfigSettings {

    //biome
    public static int biomeSize = 15;
    public static int riverSize = 4;

    //river
    public static boolean spawnRivers = true;//TODO spawnRivers config
    public static float riverDepth = 0;
    public static int riverWaterColor = 0x3F76E4;
    public static int riverWaterFogColor = 0x004B48;//003D4B;
    public static int muddyWaterColor = 0x7898E4;
    public static int muddyWaterFogColor = 0x344226;
    public static int coldWaterColor = 0x1843C4;
    public static int coldWaterFogColor = 0x004B48;//004B6A;
    public static int greenWaterColor = 0x22BF52;
    public static int greenWaterFogColor = 0x2E3A17;


    public static int biomeGroupSpawningSize = 1;//bigger biomes = lower number
    public static int biomeGroupChance = 0;

    public static int floweringChance = 15;

    public static void applyCfgs(){
        riverDepth= CommonConfig.riverDepth.get().floatValue();
        biomeGroupSpawningSize= CommonConfig.biomeGroupSpawningSize.get();;
        biomeGroupChance = CommonConfig.biomeGroupChance.get();


    }



}
