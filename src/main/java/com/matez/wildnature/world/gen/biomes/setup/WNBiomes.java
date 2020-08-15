package com.matez.wildnature.world.gen.biomes.setup;

import com.matez.wildnature.world.gen.biomes.biomes.*;
import com.matez.wildnature.world.gen.manager.WNBiomeManager;
import com.matez.wildnature.Main;
import com.matez.wildnature.customizable.CommonConfig;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class WNBiomes {
    public static ArrayList<Biome> biomes = new ArrayList<>();
    public static ArrayList<Biome> registerBiomes = new ArrayList<>();
    public static ArrayList<Biome> generatorBiomes = new ArrayList<>();
    public static ArrayList<BiomeToRegister> biomesToRegister = new ArrayList<>();
    public static ArrayList<String> biomesString = new ArrayList<String>();

    //RIVERS
    public static Biome River = new WNRiverBiome();
    public static Biome FrozenRiver = new WNFrozenRiverBiome();
    public static Biome AmazonRiver = new WNAmazonRiver();
    public static Biome NileRiver = new WNNileRiver();
    public static Biome CanyonRiver = new WNCanyonRiver();
    public static Biome IcelandRiver = new WNIcelandRiver();
    public static Biome DaintreeRiver = new WNDaintreeRiver();
    public static Biome TatraStream = new WNTatraStream();

    //-----------------------------------------------------

    //OAK
    public static Biome Oaklands = new WNOaklands("oaklands");
    public static Biome DenseOaklands = new WNDenseOaklands("dense_oaklands");
    public static Biome OakValley = new WNOakValley("oak_valley");
    public static Biome OaklandHills = new WNOaklandHills("oakland_hills");

    //POPLAR
    public static Biome PoplarForest = new WNPoplarForest("poplar_forest");
    public static Biome PoplarForestValley = new WNPoplarForestValley("poplar_forest_valley");
    public static Biome PoplarForestHills = new WNPoplarForestHills("poplar_forest_hills");

    //HIGH
    public static Biome HighForest = new WNHighForest("high_forest");
    public static Biome HighForestHills = new WNHighForestHills("high_forest_hills");
    public static Biome HighForestValley = new WNHighForestValley("high_forest_valley");
    public static Biome ForestedMountains = new WNForestedMountains("forested_cliffs");


    //ASPEN
    public static Biome AspenGrove = new WNAspenGrove("aspen_grove");
    public static Biome SnowyAspenGrove = new WNSnowyAspenGrove("snowy_aspen_grove");

    //BEECH
    public static Biome BeechForest = new WNBeechForest("beech_forest");
    public static Biome BeechForestHills = new WNBeechForestHills("beech_hills");
    public static Biome BeechValley = new WNBeechValley("beech_valley");

    public static Biome PurpleWoodland = new WNPurpleWoodland("purple_woodland");

    //ORCHARD
    public static Biome Orchard = new WNOrchard("orchard");
    public static Biome OrchardPlum = new WNOrchardPlum("orchard_plum");
    public static Biome CherryParadise = new WNCherryParadise("cherry_paradise");
    public static Biome CitrusOrchard = new WNCitrusOrchard("citrus_orchard");

    public static Biome VibrantForest = new WNVibrantForest("vibrant_forest");
    //MAPLE
    public static Biome MapleForest = new WNMapleForest("maple_forest");
    public static Biome AutumnalMapleForest = new WNAutumnalMapleForest("autumnal_maple_forest");

    //GRASSLANDS
    public static Biome Grasslands = new WNGrasslands("grasslands");
    public static Biome GrasslandsHills = new WNGrasslandsHills("grasslands_hills");
    public static Biome ForestedGrasslands = new WNForestedGrasslands("forested_grasslands");
    public static Biome ForestedGrasslandsHills = new WNForestedGrasslandsHills("forested_grasslands_hills");
    public static Biome Polders = new WNPolders("polders");
    public static Biome PoldersEdge = new WNPoldersEdge("polders_edge");
    public static Biome Shrublands = new WNShrublands("shrublands");
    public static Biome HillyShrublands = new WNHillyShrublands("hilly_shrublands");
    public static Biome Scrublands = new WNScrublands("scrublands");
    public static Biome HazelFields = new WNHazelFields("hazel_fields");

    public static Biome Fields = new WNFields("fields");
    public static Biome SunflowerFields = new WNSunflowerFields("sunflower_fields");
    public static Biome PoppyFields = new WNPoppyFields("poppy_fields");
    public static Biome ForestedFields = new WNForestedFields("forested_fields");

    public static Biome PrehistoricValley = new WNPrehistoricValley("prehistoric_valley");
    public static Biome ErodedFields = new WNErodedFields("eroded_fields");
    public static Biome ErodedHills = new WNErodedHills("eroded_hills");


    //PRAIRIE
    public static Biome Prairie = new WNPrairie("prairie");
    public static Biome PrairieHills = new WNPrairieHills("prairie_hills");
    public static Biome RapeseedField = new WNRapeseedField("rapeseed_field");
    public static Biome CornField = new WNCornField("corn_field");
    public static Biome CottonFields = new WNCottonFields("cotton_fields");


    //OUTBACK
    public static Biome Outback = new WNOutback("outback");
    public static Biome WoodedOutback = new WNWoodedOutback("wooded_outback");

    //TATRA
    public static Biome TatraFoothills = new WNTatraFoothills("tatra_foothills");//edge biome
    public static Biome TatraLowerForest = new WNTatraLowerForest("tatra_lower_forest");
    public static Biome TatraUpperForest = new WNTatraUpperForest("tatra_upper_forest");
    public static Biome TatraMountains = new WNTatraMountains("tatra_mountains");//basic biome
    public static Biome TatraGreenedPeak = new WNTatraGreenedPeak("tatra_greened_peak");
    public static Biome TatraRedPeak = new WNTatraRedPeak("tatra_red_peak");
    public static Biome TatraKasprowyPeak = new WNTatraKasprowyPeak("tatra_kasprowy_peak");

    public static Biome ChocholowskaGlade = new WNTatraChocholowskaGlade("tatra_chocholowska_glade");
    public static Biome FireweedValley = new WNTatraFireweedValley("tatra_fireweed_valley");
    public static Biome CracowGorge = new WNCracowGorge("cracow_gorge");
    public static Biome MorskieOko = new WNMorskieOko("morskie_oko");
    public static Biome Giewont = new WNGiewont("giewont");

    //snowy:
    public static Biome SnowyTatraFoothills = new WNSnowyTatraFoothills("snowy_tatra_foothills");//edge biome
    public static Biome SnowyTatraLowerForest = new WNSnowyTatraLowerForest("snowy_tatra_lower_forest");
    public static Biome SnowyTatraUpperForest = new WNSnowyTatraUpperForest("snowy_tatra_upper_forest");
    public static Biome SnowyTatraMountains = new WNSnowyTatraMountains("snowy_tatra_mountains");//basic biome
    public static Biome SnowyTatraKasprowyPeak = new WNSnowyTatraKasprowyPeak("snowy_tatra_kasprowy_peak");

    public static Biome SnowyChocholowskaGlade = new WNSnowyTatraChocholowskaGlade("snowy_tatra_chocholowska_glade");
    public static Biome SnowyFireweedValley = new WNTatraFireweedValley("snowy_tatra_fireweed_valley");
    public static Biome SnowyCracowGorge = new WNSnowyCracowGorge("snowy_cracow_gorge");
    public static Biome FrozenMorskieOko = new WNFrozenMorskieOko("frozen_morskie_oko");
    public static Biome SnowyGiewont = new WNSnowyGiewont("snowy_giewont");

    public static Biome Rysy = new WNRysy("rysy");
    //BIALOWIEZA
    public static Biome BialowiezaForest = new WNBialowiezaForest("bialowieza_forest");
    public static Biome BialowiezaMarsh = new WNBialowiezaMarsh("bialowieza_marsh");
    public static Biome BialowiezaForestS = new WNSnowyBialowiezaForest("snowy_bialowieza_forest");
    public static Biome BialowiezaMarshS = new WNBialowiezaFrozenMarsh("bialowieza_frozen_marsh");

    //CLIFFS
    public static Biome SnowyMountains = new WNSnowedMountains("snowy_mountains");
    public static Biome Glacier = new WNGlacier("glacier");
    public static Biome Himalayas = new WNHimalayas("himalayas");
    public static Biome OvergrownCliffs = new WNOvergrownCliffs("overgrown_cliffs");
    public static Biome MahoganyCliffs = new WNMahoganyCliffs("mahogany_cliffs");

    //BOG
    public static Biome Bog = new WNBog("bog");

    //BOREAL
    public static Biome BorealForest = new WNBorealForest("boreal_forest");
    public static Biome BorealForestHills = new WNBorealForestHill("boreal_forest_hills");
    public static Biome BorealValley = new WNBorealValley("boreal_valley");
    public static Biome SnowyBorealForest = new WNSnowyBorealForest("snowy_boreal_forest");
    public static Biome SnowyBorealForestHills = new WNSnowyBorealForestHill("snowy_boreal_forest_hills");
    public static Biome SnowyBorealValley = new WNSnowyBorealValley("snowy_boreal_valley");
    public static Biome SeasonalTaiga = new WNSeasonalTaiga("seasonal_taiga");
    public static Biome PineMixedForest = new WNPineMixedForest("pine_mixed_forest");
    public static Biome TemperatePineMixedForest = new WNTemperatePineMixedForest("temperate_pine_mixed_forest");
    public static Biome PineMixedMarsh = new WNPineMixedMarsh("pine_mixed_marsh");
    public static Biome Moor = new WNMoor("moor");
    public static Biome DenseMoor = new WNDenseMoor("dense_moor");

    public static Biome TucholaForest = new WNTucholaForest("tuchola_forest");
    public static Biome DenseTucholaForest = new WNDenseTucholaForest("dense_tuchola_forest");
    public static Biome TucholaForestHill = new WNTucholaForestHill("tuchola_forest_hill");
    public static Biome TucholaValley = new WNTucholaValley("tuchola_valley");
    public static Biome SnowyTucholaForest = new WNSnowyTucholaForest("snowy_tuchola_forest");
    public static Biome SnowyDenseTucholaForest = new WNSnowyDenseTucholaForest("snowy_dense_tuchola_forest");
    public static Biome SnowyTucholaForestHill = new WNSnowyTucholaForestHill("snowy_tuchola_forest_hill");
    public static Biome SnowyTucholaValley = new WNSnowyTucholaValley("snowy_tuchola_valley");

    public static Biome Taiga = new WNTaiga("taiga");
    public static Biome TaigaHills = new WNTaigaHills("taiga_hills");
    public static Biome TaigaValley = new WNTaigaValley("taiga_valley");
    public static Biome TaigaClearing = new WNTaigaClearing("taiga_clearing");
    public static Biome WetTaiga = new WNWetTaiga("wet_taiga");
    public static Biome TaigaMarsh = new WNTaigaMarsh("taiga_marsh");
    public static Biome BerryTaiga = new WNBerryTaiga("berry_taiga");
    public static Biome RockyTaiga = new WNRockyTaiga("rocky_taiga");

    public static Biome ColdTaiga = new WNColdTaiga("cold_taiga");
    public static Biome ColdTaigaHills = new WNColdTaigaHills("cold_taiga_hills");
    public static Biome ColdTaigaValley = new WNColdTaigaValley("cold_taiga_valley");
    public static Biome ColdTaigaClearing = new WNColdTaigaClearing("cold_taiga_clearing");
    public static Biome FrozenTaiga = new WNFrozenTaiga("frozen_taiga");
    public static Biome ColdTaigaMarsh = new WNColdTaigaMarsh("cold_taiga_marsh");
    public static Biome ColdBerryTaiga = new WNColdBerryTaiga("cold_berry_taiga");
    public static Biome ColdRockyTaiga = new WNColdRockyTaiga("cold_rocky_taiga");


    //HIGHLANDS
    public static Biome Highlands = new WNHighlands("highlands");

    //RAINFOREST
    public static Biome Rainforest = new WNRainforest("rainforest");
    public static Biome RainforestHills = new WNRainforestHills("rainforest_hills");
    public static Biome RainforestMoor = new WNRainforestMoor("rainforest_moor");

    //SAFARI
    public static Biome Safari = new WNSafari("safari");
    public static Biome SafariHills = new WNSafariHills("safari_hills");
    public static Biome BaobabSavanna = new WNBaobabSavanna("baobab_savanna");
    public static Biome GiantSavanna = new WNGiantSavanna("giant_savanna");

    //REDWOOD
    public static Biome RedwoodForest = new WNRedwoodForest("redwood_forest");
    public static Biome RedwoodHills = new WNRedwoodHills("redwood_hills");
    public static Biome OldRedwoodForest = new WNOldRedwoodForest("old_redwood_forest");
    public static Biome SequoiaForest = new WNSequoiaForest("sequoia_forest");
    public static Biome SequoiaHills = new WNSequoiaHills("sequoia_hills");
    public static Biome SequoiaValley = new WNSequoiaValley("sequoia_valley");
    public static Biome CedarForest = new WNCedarForest("cedar_fields");
    public static Biome SnowyCedarForest = new WNSnowyCedarForest("snowy_cedar_fields");
    public static Biome TemperateCedarScrubs = new WNTemperateCedarScrubs("temperate_cedar_scrubs");
    public static Biome TemperateRedwoodScrubs = new WNTemperateRedwoodScrubs("temperate_redwood_scrubs");
    public static Biome CypressFields = new WNCypressFields("cypress_fields");
    public static Biome CypressHills = new WNCypressHills("cypress_hills");

    //GREENWOOD
    public static Biome Greenwood = new WNGreenwood("greenwood");
    public static Biome GreenwoodHills = new WNGreenwoodHills("greenwood_hills");
    public static Biome GreenwoodValley = new WNGreenwoodValley("greenwood_valley");
    public static Biome RoofedForest = new WNRoofedForest("roofed_forest");
    public static Biome RoofedValley = new WNRoofedValley("roofed_valley");


    //CHRISTMAS
    public static Biome ChristmasDream = new WNChristmasDream("christmas_dream");

    //GIANT CONIFEROUS
    public static Biome GiantConiferousForest = new WNGiantConiferousForest("giant_coniferous_forest");
    public static Biome SnowyGiantConiferousForest = new WNSnowyGiantConiferousForest("snowy_giant_coniferous_forest");

    //AUTUMNAL
    public static Biome AutumnalSpruceForest = new WNAutumnalSpruceForest("autumnal_spruce");

    //BIRCH_GROVE
    public static Biome BirchGrove = new WNBirchGrove("birch_grove");
    public static Biome SnowyBirchGrove = new WNSnowyBirchGrove("snowy_birch_grove");
    public static Biome WeepingBirchForest = new WNWeepingBirchForest("weeping_birch_forest");
    public static Biome BirchScrubs = new WNBirchScrubs("birch_scrubs");
    public static Biome BirchMarsh = new WNBirchMarsh("birch_marsh");

    //FLOWER FIELD
    public static Biome FlowerField = new WNFlowerField("flower_field");
    public static Biome HyacinthFields = new WNHyacinthFields("hyacinth_fields");
    public static Biome MarigoldFields = new WNMarigoldFields("marigold_fields");

    //MEADOWS
    public static Biome Meadow = new WNMeadow("meadow");
    public static Biome WoodedMeadow = new WNWoodedMeadow("wooded_meadow");

    //SAHARA
    public static Biome Sahara = new WNSahara("sahara");

    //DESERT
    public static Biome Oasis = new WNOasis("oasis");
    public static Biome LushDesert = new WNLushDesert("lush_desert");
    public static Biome CrackedDesert = new WNCrackedDesert("cracked_desert");
    public static Biome TintedDesert = new WNTintedDesert("tinted_desert");
    public static Biome TintedDesertHills = new WNTintedDesertHills("tinted_desert_hills");
    public static Biome Badlands = new WNBadlands("badlands");
    public static Biome DeadDesolation = new WNDeadDesolation("dead_desolation");
    public static Biome Canyons = new WNCanyons("canyons");
    public static Biome GrandCanyon = new WNGrandCanyon("grand_canyon");

    //DENSE FOREST
    public static Biome DeciduousForest = new WNDeciduousForest("deciduous_forest");
    public static Biome Forest = new WNForest("forest");
    public static Biome ForestValley = new WNForestValley("forest_valley");
    public static Biome SnowyForest = new WNSnowyForest("snowy_forest");
    public static Biome ColdForest = new WNColdForest("cold_forest");

    public static Biome TemperateForest = new WNTemperateForest("temperate_forest");

    //GOLDEN WOODS
    public static Biome GoldenWoods = new WNGoldenWoods("golden_woods");

    //LAVENDER
    public static Biome LavenderGarden = new WNLavenderGarden("lavender_garden");

    //
    public static Biome SaltFlats = new WNSaltFlats("salt_flats");


    //FARMLANDS
    public static Biome Farmlands = new WNFarmlands("farmlands");

    //MAHOGANY
    public static Biome MahoganyRainforest = new WNMahoganyRainforest("mahogany_rainforest");

    //SAKURA
    public static Biome SakuraJungle = new WNSakuraJungle("sakura_jungle");

    //BADLANDS
    public static Biome TropicalBadlands = new WNTropicalBadlands("tropical_badlands");
    public static Biome Steppe = new WNSteppe("steppe");

    //ICE
    public static Biome Icelands = new WNIcelands("icelands");


    //RIVERED
    public static Biome Masuria = new WNMasuria("masuria");
    public static Biome LandOfRivers = new WNLandOfRivers("land_of_rivers");

    //WETLANDS
    public static Biome Wetlands = new WNWetlands("wetlands");
    public static Biome MangroveForest = new WNMangroveBayou("mangrove_bayou");
    public static Biome Backwaters = new WNBackwaters("backwaters");

    //TROPICAL
    public static Biome EucalyptusForest = new WNEucalyptusForest("eucalyptus_forest");
    public static Biome DaintreeForest = new WNDaintreeForest("daintree_forest");
    public static Biome DaintreePlateau = new WNDaintreePlateau("daintree_plateau");
    public static Biome DaintreeCliffs = new WNDaintreeCliffs("daintree_cliffs");

    public static Biome BananaThicket = new WNBananaThicket("banana_thicket");

    //CITRUS
    public static Biome OliveGarden = new WNOliveGarden("olive_grove");
    public static Biome OliveHills = new WNOliveHills("olive_hills");

    //HORNBEAM
    public static Biome HornbeamForest = new WNHornbeamForest("hornbeam_forest");
    public static Biome HornbeamHills = new WNHornbeamHills("hornbeam_hills");
    public static Biome HornbeamValley = new WNHornbeamValley("hornbeam_valley");

    //SPOOKY
    public static Biome Mirkwood = new WNMirkwood("mirkwood");
    public static Biome DarkMirkwood = new WNDarkMirkwood("dark_mirkwood");

    //SHIELD
    public static Biome ThujaShield = new WNThujaShield("thuja_shield");


    //ROOFED


    //LAKES
    public static Biome WarmLake = new WNWarmLake("warm_lake");
    public static Biome ColdLake = new WNColdLake("cold_lake");
    public static Biome TropicalLake = new WNTropicalLake("tropical_lake");
    public static Biome FrozenLake = new WNFrozenLake("frozen_lake");
    public static Biome DriedLake = new WNDriedLake("dried_lake");


    //ISLANDS
    public static Biome EasterIsland = new WNEasterIsland("easter_island");
    public static Biome TropicalIsland = new WNTropicalIsland("tropical_island");
    public static Biome TropicalCliffs = new WNTropicalCliffs("tropical_cliffs");
    public static Biome ChristmasIsland = new WNChristmasIsland("christmas_island");
    public static Biome Madagascar = new WNMadagascar("madagascar");
    public static Biome MadagascarValley = new WNMadagascarValley("madagascar_valley");

    //BEACHES
    public static Biome WhiteBeach = new WNWhiteBeach("white_beach");
    //public static Biome BeachCliffs = new WNBeachCliff("beach_cliffs");

    public static void registerBiomes(){
        register(Oaklands, BiomeManager.BiomeType.WARM,8, Type.FOREST, Type.DENSE);
        register(DenseOaklands, BiomeManager.BiomeType.WARM,5, Type.FOREST, Type.DENSE);
        register(HighForest, BiomeManager.BiomeType.WARM,12, Type.FOREST, Type.DENSE);
        register(Forest, BiomeManager.BiomeType.WARM,10, Type.FOREST, Type.DENSE);
        register(TemperateForest, BiomeManager.BiomeType.WARM,10, Type.FOREST, Type.DENSE);
        register(SnowyForest, BiomeManager.BiomeType.COOL,10, Type.FOREST, Type.DENSE, Type.SNOWY);
        register(ColdForest, BiomeManager.BiomeType.COOL,5, Type.FOREST, Type.DENSE, Type.SNOWY);
        register(DeciduousForest, BiomeManager.BiomeType.WARM,10, Type.FOREST, Type.DENSE);
        register(PoplarForest, BiomeManager.BiomeType.WARM,10, Type.FOREST, Type.DENSE);
        register(HornbeamForest, BiomeManager.BiomeType.WARM,3, Type.FOREST, Type.DENSE, Type.RARE, Type.SPOOKY);
        register(AspenGrove, BiomeManager.BiomeType.COOL,10, Type.FOREST, Type.DENSE);
        register(SnowyAspenGrove, BiomeManager.BiomeType.COOL,10, Type.FOREST, Type.DENSE, Type.SNOWY);
        register(SnowyBorealForest, BiomeManager.BiomeType.ICY,10, Type.FOREST, Type.DENSE, Type.COLD, Type.CONIFEROUS, Type.SNOWY);
        register(BeechForest, BiomeManager.BiomeType.COOL,7, Type.FOREST, Type.DENSE);
        register(PurpleWoodland, BiomeManager.BiomeType.COOL,1, Type.FOREST, Type.DENSE, Type.MAGICAL, Type.RARE);
        register(BorealForest, BiomeManager.BiomeType.COOL,10, Type.FOREST, Type.DENSE, Type.COLD, Type.CONIFEROUS);
        register(TucholaForest, BiomeManager.BiomeType.COOL,5, Type.FOREST, Type.DENSE, Type.COLD, Type.CONIFEROUS);
        register(Taiga, BiomeManager.BiomeType.COOL,10, Type.FOREST, Type.DENSE, Type.COLD, Type.CONIFEROUS);
        register(ColdTaiga, BiomeManager.BiomeType.ICY,10, Type.FOREST, Type.DENSE, Type.COLD, Type.CONIFEROUS, Type.SNOWY);
        register(DenseTucholaForest, BiomeManager.BiomeType.COOL,3, Type.FOREST, Type.DENSE, Type.COLD, Type.CONIFEROUS);
        register(SnowyTucholaForest, BiomeManager.BiomeType.ICY,5, Type.FOREST, Type.DENSE, Type.COLD, Type.SNOWY, Type.CONIFEROUS);
        register(SnowyDenseTucholaForest, BiomeManager.BiomeType.ICY,3, Type.FOREST, Type.DENSE, Type.COLD, Type.SNOWY, Type.CONIFEROUS);
        register(ThujaShield, BiomeManager.BiomeType.COOL,3, Type.FOREST, Type.DENSE, Type.RARE, Type.WET, Type.COLD);
        register(Orchard, BiomeManager.BiomeType.WARM,4, Type.FOREST, Type.PLAINS);
        register(CitrusOrchard, BiomeManager.BiomeType.WARM,3, Type.FOREST, Type.PLAINS, Type.JUNGLE, Type.HOT);
        register(CherryParadise, BiomeManager.BiomeType.WARM,4, Type.FOREST, Type.PLAINS, Type.RARE);
        register(VibrantForest, BiomeManager.BiomeType.WARM,1, Type.FOREST, Type.PLAINS,Type.MAGICAL, Type.RARE);
        register(GoldenWoods, BiomeManager.BiomeType.WARM,7, Type.FOREST, Type.PLAINS);
        register(Steppe, BiomeManager.BiomeType.WARM,7, Type.DRY, Type.PLAINS);
        register(MapleForest, BiomeManager.BiomeType.WARM,7, Type.FOREST, Type.DENSE);
        register(AutumnalMapleForest, BiomeManager.BiomeType.WARM,7, Type.FOREST, Type.DENSE);
        register(Grasslands, BiomeManager.BiomeType.WARM,12, Type.PLAINS);
        register(Fields, BiomeManager.BiomeType.WARM,12, Type.PLAINS);
        register(HazelFields, BiomeManager.BiomeType.WARM,9, Type.PLAINS, Type.FOREST);
        register(Shrublands, BiomeManager.BiomeType.WARM,8, Type.PLAINS, Type.HILLS);
        register(Scrublands, BiomeManager.BiomeType.WARM,7, Type.PLAINS, Type.HILLS);
        register(ForestedGrasslands, BiomeManager.BiomeType.WARM,10, Type.PLAINS, Type.FOREST);
        register(ForestedFields, BiomeManager.BiomeType.WARM,10, Type.PLAINS, Type.FOREST);
        register(Polders, BiomeManager.BiomeType.WARM,7, Type.PLAINS);
        register(Farmlands, BiomeManager.BiomeType.WARM,8, Type.PLAINS);
        register(LavenderGarden, BiomeManager.BiomeType.WARM,4, Type.PLAINS);
        register(Prairie, BiomeManager.BiomeType.WARM,10, Type.PLAINS, Type.DRY);
        register(Masuria, BiomeManager.BiomeType.WARM,6, Type.PLAINS, Type.WET);
        register(LandOfRivers, BiomeManager.BiomeType.COOL,6, Type.PLAINS, Type.WET);
        register(Wetlands, BiomeManager.BiomeType.WARM,9, Type.PLAINS, Type.WET);
        register(TropicalBadlands, BiomeManager.BiomeType.WARM,7, Type.HILLS, Type.MESA, Type.JUNGLE);
        register(RapeseedField, BiomeManager.BiomeType.WARM,10, Type.PLAINS, Type.DRY);
        register(CornField, BiomeManager.BiomeType.WARM,5, Type.PLAINS, Type.DRY);
        register(Outback, BiomeManager.BiomeType.DESERT,10, Type.DEAD, Type.DRY, Type.SAVANNA);
        register(TatraMountains, BiomeManager.BiomeType.ICY,10, Type.MOUNTAIN, Type.FOREST, Type.HILLS);
        register(SnowyTatraMountains, BiomeManager.BiomeType.ICY,10, Type.MOUNTAIN, Type.FOREST, Type.HILLS, Type.SNOWY, Type.COLD);
        register(BialowiezaForest, BiomeManager.BiomeType.COOL,7, Type.FOREST, Type.DENSE, Type.CONIFEROUS);
        register(BialowiezaForestS, BiomeManager.BiomeType.ICY,7, Type.FOREST, Type.DENSE, Type.COLD, Type.CONIFEROUS);
        register(BialowiezaMarsh, BiomeManager.BiomeType.COOL,6, Type.SWAMP, Type.WET);
        register(BialowiezaMarshS, BiomeManager.BiomeType.ICY,6, Type.SWAMP, Type.WET, Type.COLD);
        register(OvergrownCliffs, BiomeManager.BiomeType.COOL,8, Type.MOUNTAIN, Type.HILLS, Type.WATER);
        register(ForestedMountains, BiomeManager.BiomeType.COOL,8, Type.MOUNTAIN, Type.HILLS, Type.DENSE, Type.FOREST);
        register(MahoganyCliffs, BiomeManager.BiomeType.WARM,4, Type.MOUNTAIN, Type.HILLS, Type.WATER, Type.HOT, Type.JUNGLE,Type.WET);
        register(SnowyMountains, BiomeManager.BiomeType.ICY,9, Type.MOUNTAIN, Type.HILLS, Type.COLD, Type.SNOWY);
        register(Glacier, BiomeManager.BiomeType.ICY,9, Type.MOUNTAIN, Type.HILLS, Type.COLD);
        register(Himalayas, BiomeManager.BiomeType.ICY,7, Type.MOUNTAIN, Type.HILLS, Type.COLD, Type.SNOWY);
        register(Bog, BiomeManager.BiomeType.COOL,10, Type.WET, Type.SWAMP, Type.DEAD);
        register(Highlands, BiomeManager.BiomeType.COOL,10, Type.HILLS, Type.PLAINS);
        register(Rainforest, BiomeManager.BiomeType.WARM,7, Type.FOREST, Type.JUNGLE);
        register(MahoganyRainforest, BiomeManager.BiomeType.WARM,7, Type.FOREST, Type.JUNGLE);
        register(SakuraJungle, BiomeManager.BiomeType.WARM,2, Type.FOREST, Type.JUNGLE, Type.MAGICAL, Type.RARE);
        register(Safari, BiomeManager.BiomeType.DESERT,10, Type.SAVANNA);
        register(RedwoodForest, BiomeManager.BiomeType.WARM,9, Type.FOREST, Type.DENSE);
        register(Greenwood, BiomeManager.BiomeType.WARM,8, Type.FOREST, Type.DENSE);
        register(RoofedForest, BiomeManager.BiomeType.WARM,5, Type.FOREST, Type.DENSE, Type.LUSH);
        register(OldRedwoodForest, BiomeManager.BiomeType.WARM,4, Type.FOREST, Type.DENSE, Type.RARE);
        register(SequoiaForest, BiomeManager.BiomeType.WARM,3, Type.FOREST, Type.DENSE, Type.RARE);
        register(GiantConiferousForest, BiomeManager.BiomeType.COOL,8, Type.FOREST, Type.CONIFEROUS, Type.DENSE);
        register(SnowyGiantConiferousForest, BiomeManager.BiomeType.ICY,8, Type.FOREST, Type.CONIFEROUS, Type.SNOWY, Type.DENSE);
        register(ChristmasDream, BiomeManager.BiomeType.ICY,5, Type.PLAINS, Type.CONIFEROUS, Type.SNOWY, Type.COLD);
        register(AutumnalSpruceForest, BiomeManager.BiomeType.COOL,10, Type.PLAINS, Type.CONIFEROUS, Type.SNOWY, Type.COLD);
        register(BirchGrove, BiomeManager.BiomeType.WARM,10, Type.FOREST, Type.WET, Type.DENSE);
        register(WeepingBirchForest, BiomeManager.BiomeType.WARM,10, Type.FOREST, Type.WET, Type.DENSE);
        register(SnowyBirchGrove, BiomeManager.BiomeType.COOL,10, Type.FOREST, Type.SNOWY, Type.COLD);
        register(BirchScrubs, BiomeManager.BiomeType.WARM,10, Type.FOREST, Type.PLAINS, Type.DENSE);
        register(BirchMarsh, BiomeManager.BiomeType.COOL,7, Type.FOREST, Type.PLAINS, Type.SWAMP, Type.WET);
        register(FlowerField, BiomeManager.BiomeType.WARM,7, Type.PLAINS, Type.DENSE, Type.LUSH);
        register(Meadow, BiomeManager.BiomeType.WARM,3, Type.PLAINS, Type.DENSE, Type.LUSH);
        register(WoodedMeadow, BiomeManager.BiomeType.WARM,5, Type.PLAINS, Type.DENSE, Type.LUSH, Type.FOREST);
        register(MarigoldFields, BiomeManager.BiomeType.WARM,3, Type.PLAINS, Type.DENSE, Type.LUSH);
        register(HyacinthFields, BiomeManager.BiomeType.WARM,1, Type.PLAINS, Type.DENSE, Type.LUSH, Type.RARE);
        register(Sahara, BiomeManager.BiomeType.DESERT,10, Type.DEAD, Type.DRY, Type.SANDY);
        register(Badlands, BiomeManager.BiomeType.DESERT,8, Type.DEAD, Type.DRY, Type.SANDY);
        register(Canyons, BiomeManager.BiomeType.DESERT,5, Type.DEAD, Type.DRY, Type.MESA, Type.PLATEAU);
        register(GrandCanyon, BiomeManager.BiomeType.DESERT,1, Type.DEAD, Type.DRY, Type.MESA, Type.PLATEAU, Type.MOUNTAIN);
        register(Icelands, BiomeManager.BiomeType.ICY,2, Type.DEAD, Type.MESA, Type.PLATEAU, Type.MOUNTAIN, Type.SNOWY, Type.COLD, Type.WASTELAND);
        register(TintedDesert, BiomeManager.BiomeType.DESERT,5, Type.DEAD, Type.DRY, Type.SANDY);
        register(TintedDesertHills, BiomeManager.BiomeType.DESERT,3, Type.DEAD, Type.DRY, Type.SANDY, Type.MOUNTAIN, Type.HILLS);
        register(LushDesert, BiomeManager.BiomeType.DESERT,5, Type.LUSH, Type.DRY, Type.SANDY);
        register(CrackedDesert, BiomeManager.BiomeType.DESERT,2, Type.LUSH, Type.DRY, Type.SANDY);
        register(SaltFlats, BiomeManager.BiomeType.COOL,1, Type.WASTELAND, Type.DRY, Type.COLD);
        register(MangroveForest, BiomeManager.BiomeType.WARM,5, Type.FOREST, Type.SWAMP, Type.JUNGLE);
        register(Backwaters, BiomeManager.BiomeType.WARM,5, Type.FOREST, Type.SWAMP, Type.LUSH);
        register(PrehistoricValley, BiomeManager.BiomeType.WARM,1, Type.PLAINS, Type.FOREST, Type.RARE);
        register(ErodedFields, BiomeManager.BiomeType.WARM,4, Type.PLAINS, Type.HILLS, Type.FOREST,Type.RARE);
        register(SeasonalTaiga, BiomeManager.BiomeType.COOL,8, Type.FOREST, Type.CONIFEROUS, Type.DENSE);
        register(PineMixedForest, BiomeManager.BiomeType.COOL,8, Type.FOREST, Type.DENSE);
        register(PineMixedMarsh, BiomeManager.BiomeType.COOL,6, Type.FOREST, Type.DENSE, Type.SWAMP, Type.WET, Type.COLD);
        register(TemperatePineMixedForest, BiomeManager.BiomeType.WARM,8, Type.FOREST, Type.DENSE);
        register(Moor, BiomeManager.BiomeType.COOL,2, Type.FOREST, Type.LUSH);
        register(DenseMoor, BiomeManager.BiomeType.COOL,5, Type.FOREST, Type.DENSE, Type.LUSH);
        register(BaobabSavanna, BiomeManager.BiomeType.DESERT,5, Type.SAVANNA);
        register(GiantSavanna, BiomeManager.BiomeType.DESERT,4, Type.SAVANNA);
        register(DeadDesolation, BiomeManager.BiomeType.DESERT,6, Type.DEAD);
        register(CedarForest, BiomeManager.BiomeType.COOL,9, Type.FOREST, Type.DENSE, Type.COLD);
        register(SnowyCedarForest, BiomeManager.BiomeType.ICY,9, Type.FOREST, Type.DENSE, Type.COLD, Type.SNOWY);
        register(TemperateCedarScrubs, BiomeManager.BiomeType.WARM,7, Type.FOREST, Type.DENSE, Type.PLAINS);
        register(TemperateRedwoodScrubs, BiomeManager.BiomeType.WARM,7, Type.FOREST, Type.DENSE, Type.PLAINS);
        register(CypressFields, BiomeManager.BiomeType.WARM,7, Type.FOREST, Type.PLAINS);
        register(EucalyptusForest, BiomeManager.BiomeType.WARM,5, Type.FOREST, Type.DENSE, Type.JUNGLE, Type.HOT);
        register(OliveGarden, BiomeManager.BiomeType.WARM,5, Type.FOREST, Type.HILLS, Type.JUNGLE, Type.HOT);
        register(Mirkwood, BiomeManager.BiomeType.COOL,3, Type.FOREST, Type.DENSE, Type.SPOOKY, Type.RARE);
        register(DaintreeForest, BiomeManager.BiomeType.WARM,2, Type.FOREST, Type.HILLS, Type.JUNGLE, Type.HOT, Type.DENSE, Type.WET, Type.RARE);
        register(DaintreeCliffs, BiomeManager.BiomeType.WARM,1, Type.FOREST, Type.HILLS, Type.MOUNTAIN, Type.JUNGLE, Type.HOT, Type.DENSE, Type.WET, Type.RARE);
        register(BananaThicket, BiomeManager.BiomeType.WARM,3, Type.FOREST, Type.JUNGLE, Type.HOT, Type.DENSE, Type.WET);

        //DICTIONARY
        registerNonSpawn(River,Type.RIVER,Type.WET,Type.WATER);
        registerNonSpawn(FrozenRiver,Type.RIVER,Type.WET,Type.COLD, Type.SNOWY,Type.WATER);
        registerNonSpawn(NileRiver,Type.RIVER,Type.WET,Type.DRY,Type.HOT,Type.WATER,Type.SANDY);
        registerNonSpawn(AmazonRiver,Type.RIVER,Type.WET,Type.JUNGLE,Type.WATER);

        registerNonSpawn(WarmLake,Type.RIVER,Type.WET,Type.WATER);
        registerNonSpawn(TropicalLake,Type.RIVER,Type.WET,Type.JUNGLE,Type.WATER);
        registerNonSpawn(FrozenLake,Type.RIVER,Type.WET,Type.COLD, Type.SNOWY,Type.WATER);
        registerNonSpawn(ColdLake,Type.RIVER,Type.WET,Type.COLD,Type.WATER);

        //islands
        registerNonSpawn(ChristmasIsland,Type.SNOWY,Type.COLD,Type.MAGICAL,Type.RARE);
        registerNonSpawn(EasterIsland,Type.PLAINS,Type.WASTELAND,Type.MAGICAL,Type.RARE);
        registerNonSpawn(TropicalIsland,Type.HOT,Type.WET,Type.FOREST,Type.RARE);
        registerNonSpawn(Madagascar,Type.HOT,Type.WET,Type.FOREST,Type.RARE);
        registerNonSpawn(MadagascarValley,Type.HOT,Type.WET,Type.PLAINS,Type.RARE);

        BiomeGroups.register();
    }



    public static void register(Biome biome, WNBiomeManager.BiomeType type, int weight, Type... types){//adds biome to biome list that have to spawn naturally.
        Main.LOGGER.info("Preparing for registering " + biome.getRegistryName() + " biome to generate naturally...");
        if(CommonConfig.generateBiomes.get()) {
            biomesToRegister.add(new BiomeToRegister(biome, type, weight, types));
            BiomeDictionary.addTypes(biome, types);
        }
        generatorBiomes.add(biome);
    }

    public static void registerNonSpawn(Biome biome, Type... types){//adds biome to biome list that have to spawn naturally.
        if(CommonConfig.generateBiomes.get()) {
            Main.LOGGER.info("Registering dictionary for unusual biome: " + biome.getRegistryName() + " " + new ArrayList<Type>(Arrays.asList(types)).toString());
            BiomeDictionary.addTypes(biome, types);
        }
        generatorBiomes.add(biome);
    }

    public static void registerAll(){ //adds biome to biome list that have to spawn naturally.
        Main.LOGGER.info(" ----- Registering " + biomesToRegister.size() + " biomes ----- ");
        biomesToRegister.forEach(BiomeToRegister::registerIt);
        WNGlobalBiomeFeatures.setup();
        if(!CommonConfig.generateBiomes.get()){
            Main.LOGGER.info("Biome generation is not active");
        }
        Main.LOGGER.info(" -------------------------------------------------------------- ");
    }

    public static void unregisterBlacklisted(){
        ArrayList<BiomeManager.BiomeEntry> b = new ArrayList<>();
        try {
            b.addAll(Objects.requireNonNull(WNBiomeManager.getBiomes(BiomeManager.BiomeType.ICY)));
            b.addAll(Objects.requireNonNull(WNBiomeManager.getBiomes(BiomeManager.BiomeType.COOL)));
            b.addAll(Objects.requireNonNull(WNBiomeManager.getBiomes(BiomeManager.BiomeType.WARM)));
            b.addAll(Objects.requireNonNull(WNBiomeManager.getBiomes(BiomeManager.BiomeType.DESERT)));
            Main.LOGGER.debug(" -------------------------------------------------------------- ");
            b.forEach(biomeEntry -> {
                Main.LOGGER.debug("entry: " + biomeEntry.biome.getRegistryName());
            });
            Main.LOGGER.debug("entries: " + b.size());
            Main.LOGGER.debug(" -------------------------------------------------------------- ");
            for (BiomeManager.BiomeEntry biomeEntry : b) {
                if(CommonConfig.blacklistedBiomes.contains(biomeEntry.biome)){
                    Main.LOGGER.info("Removed blacklisted " + biomeEntry.biome.getRegistryName() + " biome from generation.");
                    WNBiomeManager.removeSpawnBiome(biomeEntry.biome);
                    WNBiomeManager.removeBiome(BiomeManager.BiomeType.ICY,biomeEntry);
                    WNBiomeManager.removeBiome(BiomeManager.BiomeType.COOL,biomeEntry);
                    WNBiomeManager.removeBiome(BiomeManager.BiomeType.WARM,biomeEntry);
                    WNBiomeManager.removeBiome(BiomeManager.BiomeType.DESERT,biomeEntry);
                }
            }
        }catch (Exception e){Main.LOGGER.warn("Unable to unregister blacklisted biomes. " + e.getLocalizedMessage());}
    }

    public static class BiomeToRegister{
        private Biome biome;
        private WNBiomeManager.BiomeType type;
        private int weight;
        private Type[] types;
        public BiomeToRegister(Biome biome, WNBiomeManager.BiomeType type, int weight, Type... types){
            this.biome=biome;
            this.type=type;
            this.weight=weight;
            this.types=types;
        }

        public void registerIt(){
            if(CommonConfig.blacklistedBiomes.contains(biome)){
                Main.LOGGER.info(biome.getRegistryName() + " is blacklisted.");

                return;
            }
            Main.LOGGER.info("Registered " + biome.getRegistryName() + " biome");


            WNBiomeManager.addBiome(type, new WNBiomeManager.BiomeEntry(biome, weight));
            WNBiomeManager.addSpawnBiome(biome);
            // Add all biomes to weighted list
            EnumBiomes.ALL.add(biome, weight);
        }
    }

}
