package com.matez.wildnature.world.generation.biome.registry;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.config.CommonConfig;
import com.matez.wildnature.world.generation.biome.biomes.beach.*;
import com.matez.wildnature.world.generation.biome.biomes.island.*;
import com.matez.wildnature.world.generation.biome.biomes.lake.WNColdLake;
import com.matez.wildnature.world.generation.biome.biomes.lake.WNDriedLake;
import com.matez.wildnature.world.generation.biome.biomes.lake.WNFrozenLake;
import com.matez.wildnature.world.generation.biome.biomes.lake.WNWarmLake;
import com.matez.wildnature.world.generation.biome.biomes.land.*;
import com.matez.wildnature.world.generation.biome.biomes.ocean.WNDeepJellyOcean;
import com.matez.wildnature.world.generation.biome.biomes.river.*;
import com.matez.wildnature.world.generation.biome.biomes.river.edge.*;
import com.matez.wildnature.world.generation.biome.features.WNGlobalBiomeFeatures;
import com.matez.wildnature.world.generation.biome.setup.deprecated.BiomeGroups;
import com.matez.wildnature.world.generation.biome.setup.deprecated.EnumBiomes;
import com.matez.wildnature.world.generation.biome.setup.grid.*;
import com.matez.wildnature.world.generation.manager.WNBiomeManager;
import com.matez.wildnature.world.generation.transformer.BiomeTransformer;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;

import java.util.*;

public class WNBiomes {
    public static ArrayList<Biome> biomes = new ArrayList<>();
    public static ArrayList<Biome> registerBiomes = new ArrayList<>();
    public static ArrayList<Biome> generatorBiomes = new ArrayList<>();
    public static ArrayList<BiomeToRegister> biomesToRegister = new ArrayList<>();
    public static ArrayList<String> biomesString = new ArrayList<String>();

    //OCEANS
    public static Biome DeepJellyOcean = new WNDeepJellyOcean("deep_jelly_ocean");

    public static BiomeGroup OCEAN = BiomeGroup.SingleBuilder.configure("ocean",Biomes.OCEAN);
    public static BiomeGroup COLD_OCEAN = BiomeGroup.SingleBuilder.configure("cold_ocean",Biomes.COLD_OCEAN);
    public static BiomeGroup FROZEN_OCEAN = BiomeGroup.SingleBuilder.configure("frozen_ocean",Biomes.FROZEN_OCEAN);
    public static BiomeGroup LUKEWARM_OCEAN = BiomeGroup.SingleBuilder.configure("lukewarm_ocean",Biomes.LUKEWARM_OCEAN,
            new SubBiome(DeepJellyOcean,1, Type.MAGICAL, Type.RARE, Type.LUSH),
            new SubBiome(Biomes.WARM_OCEAN,10));
    public static BiomeGroup WARM_OCEAN = BiomeGroup.SingleBuilder.configure("warm_ocean",Biomes.WARM_OCEAN,
            new SubBiome(DeepJellyOcean,2, Type.MAGICAL, Type.RARE, Type.LUSH),
            new SubBiome(Biomes.WARM_OCEAN,10));
    public static BiomeGroup DEEP_OCEAN = BiomeGroup.SingleBuilder.configure("deep_ocean",Biomes.DEEP_OCEAN);
    public static BiomeGroup DEEP_COLD_OCEAN = BiomeGroup.SingleBuilder.configure("deep_cold_ocean",Biomes.DEEP_COLD_OCEAN);
    public static BiomeGroup DEEP_FROZEN_OCEAN = BiomeGroup.SingleBuilder.configure("deep_frozen_ocean",Biomes.DEEP_FROZEN_OCEAN);
    public static BiomeGroup DEEP_LUKEWARM_OCEAN = BiomeGroup.SingleBuilder.configure("deep_lukewarm_ocean",Biomes.DEEP_LUKEWARM_OCEAN);
    public static BiomeGroup DEEP_WARM_OCEAN = BiomeGroup.SingleBuilder.configure("deep_warm_ocean",Biomes.DEEP_WARM_OCEAN);

    //RIVERS
    //fake biome
    public static Biome RiverValleySharp = new WNRiverValley("river_valley_sharp");
    public static Biome RiverValleySmooth = new WNRiverValley("river_valley_smooth");

    public static Biome River = new WNRiverBiome("river");
    public static Biome FrozenRiver = new WNFrozenRiverBiome("frozen_river");
    public static Biome AmazonRiver = new WNAmazonRiverBiome("amazon_river");
    public static Biome NileRiver = new WNNileRiverBiome("nile_river");
    public static Biome CanyonRiver = new WNCanyonRiver();
    public static Biome IcelandRiver = new WNIcelandRiver();
    public static Biome DaintreeRiver = new WNDaintreeRiver();
    public static Biome TatraStream = new WNTatraStream();

    public static BiomeGroup RIVER = BiomeGroup.SingleBuilder.configure("river",River);
    public static BiomeGroup FROZEN_RIVER = BiomeGroup.SingleBuilder.configure("frozen_river",FrozenRiver);
    public static BiomeGroup AMAZON_RIVER = BiomeGroup.SingleBuilder.configure("amazon_river",AmazonRiver);
    public static BiomeGroup NILE_RIVER = BiomeGroup.SingleBuilder.configure("nile_river",NileRiver);

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
    public static Biome AutumnalPoplarForest = new WNAutumnalPoplarForest("autumnal_poplar_forest");
    public static Biome AutumnalPoplarForestValley = new WNAutumnalPoplarForestValley("autumnal_poplar_forest_valley");
    public static Biome AutumnalPoplarForestHills = new WNAutumnalPoplarForestHills("autumnal_poplar_forest_hills");


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
    public static Biome BeechForestTall = new WNBeechForestTall("beech_tall_forest");
    public static Biome BeechGrove = new WNBeechGrove("beech_grove");

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
    public static Biome PrairiePlateau = new WNPrairiePlateau("prairie_plateau");
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
    public static Biome SnowyFireweedValley = new WNSnowyTatraFireweedValley("snowy_tatra_fireweed_valley");
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

    public static Biome Silverlands = new WNSilverlands("silverlands");
    public static Biome ColdSilverlands = new WNSilverlands("cold_silverlands");

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

    public static Biome CaatingaScrubs = new WNCaatingaScrubs("caatinga_scrubs");
    public static Biome CaatingaHills = new WNCaatingaHills("caatinga_hills");

    //REDWOOD
    public static Biome RedwoodForest = new WNRedwoodForest("redwood_forest");
    public static Biome RedwoodHills = new WNRedwoodHills("redwood_hills");
    public static Biome OldRedwoodForest = new WNOldRedwoodForest("old_redwood_forest");
    public static Biome CedarForest = new WNCedarForest("cedar_fields");
    public static Biome SnowyCedarForest = new WNSnowyCedarForest("snowy_cedar_fields");
    public static Biome TemperateCedarScrubs = new WNTemperateCedarScrubs("temperate_cedar_scrubs");
    public static Biome TemperateRedwoodScrubs = new WNTemperateRedwoodScrubs("temperate_redwood_scrubs");
    public static Biome CypressFields = new WNCypressFields("cypress_fields");
    public static Biome CypressHills = new WNCypressHills("cypress_hills");

    //SEQUOIA
    public static Biome SequoiaForest = new WNSequoiaForest("sequoia_forest");
    public static Biome SequoiaHills = new WNSequoiaHills("sequoia_hills");
    public static Biome SequoiaValley = new WNSequoiaValley("sequoia_valley");

    //TEMPERATE RAINFOREST
    public static Biome TemperateSequoiaRainforest = new WNTemperateSequoiaRainforest("temperate_sequoia_rainforest");
    public static Biome TemperateSequoiaRainforestHills = new WNSequoiaHills("temperate_sequoia_rainforest_hills");
    public static Biome TemperateSequoiaRainforestValley = new WNSequoiaValley("temperate_sequoia_rainforest_valley");

    public static Biome AutumnalSequoiaRainforest = new WNAutumnalSequoiaRainforest("autumnal_sequoia_rainforest");
    public static Biome AutumnalSequoiaRainforestHills = new WNSequoiaHills("autumnal_sequoia_rainforest_hills");
    public static Biome AutumnalSequoiaRainforestValley = new WNSequoiaValley("autumnal_sequoia_rainforest_valley");

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
    public static Biome WoodedJacarandaMeadow = new WNWoodedJacarandaMeadow("wooded_jacaranda_meadow");

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
    public static Biome MahoganyCliffs = new WNMahoganyCliffs("mahogany_cliffs");

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
    public static Biome GiantEucalyptusForest = new WNGiantEucalyptusForest("giant_eucalyptus_forest");

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
    public static Biome ParadiseIsland = new WNParadiseIsland("paradise_island");

    public static Biome Island = new WNIsland("island");
    public static Biome ForestedIsland = new WNForestedIsland("forested_island");
    public static Biome SnowyIsland = new WNSnowyIsland("snowy_island");

    //BEACHES
    public static Biome Beach = new WNBeach("beach");
    public static Biome PalmBeach = new WNPalmBeach("palm_beach");
    public static Biome WhiteBeach = new WNWhiteBeach("white_beach");
    public static Biome WhitePalmBeach = new WNWhitePalmBeach("white_palm_beach");
    public static Biome BeachDunes = new WNDuneBeach("dune_beach");
    public static Biome ColdBeach = new WNColdBeach("cold_beach");
    public static Biome StoneShore = new WNStoneShore("stone_shore");
    public static Biome ColdStoneShore = new WNColdStoneShore("cold_stone_shore");

    public static BiomeGroup TEMPERATE_BEACH = BiomeGroup.SingleBuilder.configure("temperate_beach",10,Beach,
            new SubBiome(BeachDunes,3));
    public static BiomeGroup WARM_BEACH = BiomeGroup.SingleBuilder.configure("warm_beach",10,Beach,
            new SubBiome(PalmBeach,3),
            new SubBiome(WhiteBeach,2),
            new SubBiome(BeachDunes,2));
    public static BiomeGroup TROPICAL_BEACH = BiomeGroup.SingleBuilder.configure("tropical_beach",10,WhiteBeach,
            new SubBiome(WhitePalmBeach,5));
    public static BiomeGroup COLD_BEACH = BiomeGroup.SingleBuilder.configure("cold_beach",10,Beach);
    public static BiomeGroup ICY_BEACH = BiomeGroup.SingleBuilder.configure("cold_beach",10,ColdBeach);
    public static BiomeGroup STONE_SHORE = BiomeGroup.SingleBuilder.configure("stone_shore",10,StoneShore);
    public static BiomeGroup COLD_STONE_SHORE = BiomeGroup.SingleBuilder.configure("cold_stone_shore",10,ColdStoneShore);
    public static BiomeGroup MUSHROOM_FIELD_SHORE = BiomeGroup.SingleBuilder.configure("mushroom_field_shore",10,Biomes.MUSHROOM_FIELD_SHORE);

    public static void registerAllBiomes(){
        registerWildNature();
        registerVanilla();
        registerEdges();
        registerIslands();
        registerNonSpawns();
    }

    private static void registerWildNature() {
        register(BiomeGroup.SingleBuilder
                        .configure(8, WNBiomes.Oaklands,
                                new SubBiome(WNBiomes.OaklandHills, 4, Type.HILLS),
                                new SubBiome(WNBiomes.DenseOaklands, 4, Type.DENSE),
                                new SubBiome(WNBiomes.OakValley, 3, Type.PLAINS)
                        ),
                Type.FOREST);

        register(BiomeGroup.SingleBuilder
                        .configure(10, WNBiomes.PoplarForest,
                                new SubBiome(WNBiomes.PoplarForestHills, 4, Type.HILLS),
                                new SubBiome(WNBiomes.PoplarForestValley, 3, Type.PLAINS)
                        ),
                Type.FOREST, Type.DENSE);

        register(BiomeGroup.SingleBuilder
                        .configure(6, WNBiomes.AutumnalPoplarForest,
                                new SubBiome(WNBiomes.AutumnalPoplarForestHills, 4, Type.HILLS),
                                new SubBiome(WNBiomes.AutumnalPoplarForestValley, 3, Type.PLAINS)
                        ),
                Type.FOREST, Type.DENSE, Type.COLD);

        register(BiomeGroup.SingleBuilder
                        .configure(10, WNBiomes.HighForest,
                                new SubBiome(WNBiomes.HighForestHills, 6, Type.HILLS),
                                new SubBiome(WNBiomes.HighForestValley, 3, Type.PLAINS)
                        ),
                Type.FOREST, Type.DENSE);

        register(BiomeGroup.SingleBuilder
                        .configure(9, WNBiomes.ForestedMountains),
                Type.FOREST, Type.DENSE, Type.MOUNTAIN, Type.HILLS);

        register(BiomeGroup.SingleBuilder
                        .configure(7, WNBiomes.AspenGrove),
                Type.FOREST, Type.DENSE);

        register(BiomeGroup.SingleBuilder
                        .configure(7, WNBiomes.SnowyAspenGrove),
                Type.FOREST, Type.DENSE, Type.SNOWY, Type.COLD);

        register(BiomeGroup.SingleBuilder
                        .configure(9, WNBiomes.BeechForest,
                                new SubBiome(WNBiomes.BeechForestHills, 4, Type.HILLS),
                                new SubBiome(WNBiomes.BeechValley, 3, Type.PLAINS)
                        ),
                Type.FOREST, Type.DENSE);

        register(BiomeGroup.SingleBuilder
                        .configure(4, WNBiomes.PurpleWoodland),
                Type.FOREST, Type.DENSE, Type.RARE);

        register(BiomeGroup.SingleBuilder
                        .configure(9, WNBiomes.BeechForest,
                                new SubBiome(WNBiomes.BeechForestHills, 4, Type.HILLS),
                                new SubBiome(WNBiomes.BeechValley, 3, Type.PLAINS),
                                new SubBiome(WNBiomes.BeechForestTall,3),
                                new SubBiome(WNBiomes.BeechGrove,1, Type.RARE, Type.MAGICAL)
                        ),
                Type.FOREST, Type.DENSE);

        register(BiomeGroup.SingleBuilder
                        .configure(6, WNBiomes.Orchard,
                                new SubBiome(WNBiomes.OrchardPlum, 3)
                        ),
                Type.FOREST, Type.PLAINS);

        register(BiomeGroup.SingleBuilder
                        .configure(4, WNBiomes.CherryParadise),
                Type.PLAINS, Type.RARE);

        register(BiomeGroup.SingleBuilder
                        .configure(5, WNBiomes.CitrusOrchard),
                Type.PLAINS, Type.HILLS);

        register(BiomeGroup.SingleBuilder
                        .configure(3, WNBiomes.VibrantForest),
                Type.FOREST, Type.RARE, Type.MAGICAL);

        register(BiomeGroup.SingleBuilder
                        .configure(10, WNBiomes.MapleForest),
                Type.FOREST);

        register(BiomeGroup.SingleBuilder
                        .configure(9, WNBiomes.AutumnalMapleForest),
                Type.FOREST);

        register(BiomeGroup.SingleBuilder
                        .configure(12, WNBiomes.Grasslands,
                                new SubBiome(WNBiomes.GrasslandsHills, 7, Type.HILLS)
                        ),
                Type.PLAINS);

        register(BiomeGroup.SingleBuilder
                        .configure(11, WNBiomes.ForestedGrasslands,
                                new SubBiome(WNBiomes.ForestedGrasslandsHills, 7, Type.HILLS)
                        ),
                Type.PLAINS);

        register(BiomeGroup.SingleBuilder
                        .configure(1, WNBiomes.Polders),
                Type.PLAINS, Type.LUSH);

        register(BiomeGroup.SingleBuilder
                        .configure(9, WNBiomes.Shrublands,
                                new SubBiome(WNBiomes.Shrublands, 15),
                                new SubBiome(WNBiomes.HillyShrublands, 10, Type.HILLS)
                        ),
                Type.PLAINS, Type.PLATEAU);

        register(BiomeGroup.SingleBuilder
                        .configure(9, WNBiomes.Scrublands),
                Type.PLAINS, Type.HILLS);

        register(BiomeGroup.SingleBuilder
                        .configure(9, WNBiomes.HazelFields),
                Type.PLAINS, Type.FOREST);

        register(BiomeGroup.SingleBuilder
                        .configure(12, WNBiomes.Fields,
                                new SubBiome(WNBiomes.SunflowerFields, 1, Type.RARE),
                                new SubBiome(WNBiomes.PoppyFields, 5),
                                new SubBiome(WNBiomes.ForestedFields,4)
                        ),
                Type.PLAINS, Type.FOREST);

        register(BiomeGroup.SingleBuilder
                        .configure(1, WNBiomes.PrehistoricValley),
                Type.FOREST, Type.RARE, Type.MAGICAL, Type.LUSH);

        register(BiomeGroup.SingleBuilder
                        .configure(6, WNBiomes.ErodedFields,
                                new SubBiome(WNBiomes.ErodedHills, 4, Type.HILLS)
                        ),
                Type.PLAINS);

        register(BiomeGroup.SingleBuilder
                        .configure(10, WNBiomes.Prairie,
                                new SubBiome(WNBiomes.Prairie, 14),
                                new SubBiome(WNBiomes.PrairieHills, 10, Type.HILLS),
                                new SubBiome(WNBiomes.CottonFields, 1, Type.RARE),
                                new SubBiome(WNBiomes.PrairiePlateau, 2, Type.PLATEAU)

                        ),
                Type.PLAINS, Type.DRY);

        register(BiomeGroup.SingleBuilder
                        .configure(7, WNBiomes.RapeseedField),
                Type.PLAINS);

        register(BiomeGroup.SingleBuilder
                        .configure(3, WNBiomes.CornField),
                Type.PLAINS, Type.RARE);

        register(BiomeGroup.SingleBuilder
                        .configure(10, WNBiomes.Outback,
                                new SubBiome(WNBiomes.WoodedOutback, 3, Type.FOREST)
                        ),
                Type.PLAINS, Type.SANDY, Type.MESA, Type.DRY);

        register(BiomeGroup.SingleBuilder
                                        .configure("tatras",10, WNBiomes.TatraMountains,
                                new SubBiome(WNBiomes.TatraLowerForest, 4, Type.FOREST),
                                new SubBiome(WNBiomes.TatraUpperForest, 3, Type.FOREST),
                                new SubBiome(WNBiomes.TatraGreenedPeak,6),
                                new SubBiome(WNBiomes.TatraRedPeak,2),
                                new SubBiome(WNBiomes.TatraKasprowyPeak,3, Type.COLD),
                                new SubBiome(WNBiomes.ChocholowskaGlade, 3, Type.PLAINS),
                                new SubBiome(WNBiomes.FireweedValley, 4, Type.PLAINS),
                                new SubBiome(WNBiomes.Giewont,2)
                        ),
                Type.MOUNTAIN);

        register(BiomeGroup.SingleBuilder
                        .configure("snowy_tatras",10, WNBiomes.SnowyTatraMountains,
                                new SubBiome(WNBiomes.SnowyTatraLowerForest, 4, Type.FOREST),
                                new SubBiome(WNBiomes.SnowyTatraUpperForest, 3, Type.FOREST),
                                new SubBiome(WNBiomes.SnowyTatraKasprowyPeak,3, Type.COLD),
                                new SubBiome(WNBiomes.SnowyChocholowskaGlade, 3, Type.PLAINS),
                                new SubBiome(WNBiomes.SnowyFireweedValley, 4, Type.PLAINS),
                                new SubBiome(WNBiomes.SnowyGiewont,2),
                                new SubBiome(WNBiomes.Rysy,1, Type.RARE)
                        ),
                Type.MOUNTAIN, Type.SNOWY);

        register(BiomeGroup.SingleBuilder
                        .configure(7,WNBiomes.BialowiezaForest,
                                new SubBiome(WNBiomes.BialowiezaMarsh,2, Type.SWAMP, Type.LUSH)
                        ),
                Type.FOREST, Type.DENSE, Type.WET, Type.CONIFEROUS);

        register(BiomeGroup.SingleBuilder
                        .configure(7, WNBiomes.BialowiezaForestS,
                                new SubBiome(WNBiomes.BialowiezaMarshS, 2, Type.SWAMP, Type.LUSH)
                        ),
                Type.FOREST, Type.DENSE, Type.WET, Type.COLD, Type.SNOWY, Type.CONIFEROUS);

        register(BiomeGroup.SingleBuilder
                        .configure(10, WNBiomes.SnowyMountains),
                Type.MOUNTAIN, Type.SNOWY);

        register(BiomeGroup.SingleBuilder
                        .configure(5, WNBiomes.Glacier),
                Type.MOUNTAIN, Type.COLD);

        register(BiomeGroup.SingleBuilder
                        .configure(6, WNBiomes.Himalayas),
                Type.MOUNTAIN);

        register(BiomeGroup.SingleBuilder
                        .configure(9, WNBiomes.OvergrownCliffs),
                Type.HILLS, Type.PLATEAU);

        register(BiomeGroup.SingleBuilder
                        .configure(8, WNBiomes.Bog),
                Type.PLAINS, Type.FOREST, Type.WET, Type.LUSH, Type.COLD);

        register(BiomeGroup.SingleBuilder
                        .configure(10, WNBiomes.BorealForest,
                                new SubBiome(WNBiomes.BorealForestHills, 4, Type.HILLS),
                                new SubBiome(WNBiomes.BorealValley, 3, Type.PLAINS)
                        ),
                Type.FOREST, Type.DENSE, Type.CONIFEROUS);

        register(BiomeGroup.SingleBuilder
                        .configure(9, WNBiomes.SnowyBorealForest,
                                new SubBiome(WNBiomes.SnowyBorealForestHills, 4, Type.HILLS),
                                new SubBiome(WNBiomes.SnowyBorealValley, 3, Type.PLAINS)
                        ),
                Type.FOREST, Type.DENSE, Type.SNOWY, Type.CONIFEROUS);

        register(BiomeGroup.SingleBuilder
                        .configure(6, WNBiomes.SeasonalTaiga),
                Type.FOREST);

        register(BiomeGroup.SingleBuilder
                        .configure(10, WNBiomes.PineMixedForest,
                                new SubBiome(WNBiomes.PineMixedMarsh, 4, Type.SWAMP, Type.LUSH, Type.WET)
                        ),
                Type.FOREST, Type.DENSE, Type.CONIFEROUS);

        register(BiomeGroup.SingleBuilder
                        .configure(8, WNBiomes.TemperatePineMixedForest),
                Type.FOREST, Type.DENSE);

        register(BiomeGroup.SingleBuilder
                        .configure(5, WNBiomes.Moor,
                                new SubBiome(WNBiomes.DenseMoor, 3, Type.DENSE, Type.FOREST)
                        ),
                Type.PLAINS);

        register(BiomeGroup.SingleBuilder
                        .configure(10, WNBiomes.TucholaForest,
                                new SubBiome(WNBiomes.DenseTucholaForest, 6, Type.DENSE),
                                new SubBiome(WNBiomes.TucholaForestHill, 3, Type.HILLS),
                                new SubBiome(WNBiomes.TucholaValley, 3, Type.PLAINS)
                        ),
                Type.FOREST, Type.CONIFEROUS);

        register(BiomeGroup.SingleBuilder
                        .configure(10, WNBiomes.SnowyTucholaForest,
                                new SubBiome(WNBiomes.SnowyDenseTucholaForest, 6, Type.DENSE),
                                new SubBiome(WNBiomes.SnowyTucholaForestHill, 3, Type.HILLS),
                                new SubBiome(WNBiomes.SnowyTucholaValley, 3, Type.PLAINS)
                        ),
                Type.FOREST, Type.CONIFEROUS, Type.SNOWY);

        register(BiomeGroup.SingleBuilder
                        .configure("taiga",10, WNBiomes.Taiga,
                                new SubBiome(WNBiomes.TaigaHills, 5, Type.HILLS),
                                new SubBiome(WNBiomes.TaigaValley, 3, Type.PLAINS),
                                new SubBiome(WNBiomes.TaigaClearing,3, Type.PLAINS),
                                new SubBiome(WNBiomes.WetTaiga,2,Type.WET, Type.LUSH),
                                new SubBiome(WNBiomes.TaigaMarsh, 2, Type.WET, Type.LUSH, Type.SWAMP),
                                new SubBiome(WNBiomes.BerryTaiga, 2, Type.RARE),
                                new SubBiome(WNBiomes.RockyTaiga,4, Type.HILLS)
                        ),
                Type.FOREST, Type.DENSE, Type.CONIFEROUS);

        register(BiomeGroup.SingleBuilder
                        .configure("cold_taiga",10, WNBiomes.ColdTaiga,
                                new SubBiome(WNBiomes.ColdTaigaHills, 5, Type.HILLS),
                                new SubBiome(WNBiomes.ColdTaigaValley, 3, Type.PLAINS),
                                new SubBiome(WNBiomes.ColdTaigaClearing,3, Type.PLAINS),
                                new SubBiome(WNBiomes.FrozenTaiga,2,Type.WET, Type.LUSH),
                                new SubBiome(WNBiomes.ColdTaigaMarsh, 2, Type.WET, Type.LUSH, Type.SWAMP),
                                new SubBiome(WNBiomes.ColdBerryTaiga, 2, Type.RARE),
                                new SubBiome(WNBiomes.ColdRockyTaiga,4, Type.HILLS)
                        ),
                Type.FOREST, Type.DENSE, Type.CONIFEROUS, Type.COLD, Type.SNOWY);

        register(BiomeGroup.SingleBuilder
                        .configure(3, WNBiomes.Silverlands),
                Type.FOREST, Type.DENSE, Type.CONIFEROUS, Type.RARE);

        register(BiomeGroup.SingleBuilder
                        .configure(3, WNBiomes.ColdSilverlands),
                Type.FOREST, Type.DENSE, Type.CONIFEROUS, Type.SNOWY, Type.RARE);

        register(BiomeGroup.SingleBuilder
                        .configure(10, WNBiomes.Highlands),
                Type.PLAINS, Type.DENSE, Type.CONIFEROUS, Type.HILLS);

        register(BiomeGroup.SingleBuilder
                        .configure(10, WNBiomes.Rainforest,
                                new SubBiome(WNBiomes.RainforestHills, 4, Type.HILLS),
                                new SubBiome(WNBiomes.RainforestMoor, 3, Type.PLAINS)
                        ),
                Type.FOREST, Type.DENSE, Type.JUNGLE, Type.LUSH);

        register(BiomeGroup.SingleBuilder
                        .configure(10, WNBiomes.Safari,
                                new SubBiome(WNBiomes.SafariHills, 4, Type.HILLS)
                        ),
                Type.PLAINS, Type.DRY, Type.SAVANNA);

        register(BiomeGroup.SingleBuilder
                        .configure(5, WNBiomes.GiantSavanna),
                Type.FOREST, Type.DRY, Type.SAVANNA);

        register(BiomeGroup.SingleBuilder
                        .configure(5, WNBiomes.CaatingaScrubs,
                                new SubBiome(WNBiomes.CaatingaHills, 3, Type.HILLS, Type.PLATEAU)),
                Type.DRY, Type.SAVANNA);

        register(BiomeGroup.SingleBuilder
                        .configure(7, WNBiomes.BaobabSavanna),
                Type.SAVANNA, Type.DRY, Type.FOREST);

        register(BiomeGroup.SingleBuilder
                        .configure(8, WNBiomes.RedwoodForest,
                                new SubBiome(WNBiomes.RedwoodHills, 4, Type.HILLS)
                        ),
                Type.FOREST, Type.DENSE);

        register(BiomeGroup.SingleBuilder
                        .configure(1, WNBiomes.OldRedwoodForest),
                Type.FOREST, Type.RARE);

        register(BiomeGroup.SingleBuilder
                        .configure(10, WNBiomes.CedarForest),
                Type.FOREST, Type.DENSE, Type.PLAINS);

        register(BiomeGroup.SingleBuilder
                        .configure(10, WNBiomes.SnowyCedarForest),
                Type.FOREST, Type.DENSE, Type.PLAINS);

        register(BiomeGroup.SingleBuilder
                        .configure(7, WNBiomes.TemperateCedarScrubs),
                Type.FOREST, Type.DENSE, Type.LUSH);

        register(BiomeGroup.SingleBuilder
                        .configure(7, WNBiomes.TemperateRedwoodScrubs),
                Type.FOREST, Type.DENSE, Type.LUSH);

        register(BiomeGroup.SingleBuilder
                        .configure(7, WNBiomes.CypressFields,
                                new SubBiome(WNBiomes.CypressHills, 4, Type.HILLS)
                        ),
                Type.PLAINS);

        register(BiomeGroup.SingleBuilder
                        .configure(8, WNBiomes.SequoiaForest,
                                new SubBiome(WNBiomes.SequoiaHills, 4, Type.HILLS),
                                new SubBiome(WNBiomes.SequoiaValley, 3, Type.PLAINS)
                        ),
                Type.FOREST, Type.DENSE);

        register(BiomeGroup.SingleBuilder
                        .configure(5, WNBiomes.TemperateSequoiaRainforest,
                                new SubBiome(WNBiomes.TemperateSequoiaRainforestHills, 4, Type.HILLS),
                                new SubBiome(WNBiomes.TemperateSequoiaRainforestValley, 3, Type.PLAINS)
                        ),
                Type.FOREST, Type.DENSE, Type.WET, Type.LUSH);

        register(BiomeGroup.SingleBuilder
                        .configure(2, WNBiomes.AutumnalSequoiaRainforest,
                                new SubBiome(WNBiomes.AutumnalSequoiaRainforestHills, 4, Type.HILLS),
                                new SubBiome(WNBiomes.AutumnalSequoiaRainforestValley, 3, Type.PLAINS)
                        ),
                Type.FOREST, Type.DENSE, Type.WET, Type.LUSH, Type.COLD, Type.RARE);

        register(BiomeGroup.SingleBuilder
                        .configure(7, WNBiomes.Greenwood,
                                new SubBiome(WNBiomes.GreenwoodHills, 4, Type.HILLS),
                                new SubBiome(WNBiomes.GreenwoodValley, 3, Type.PLAINS)
                        ),
                Type.FOREST, Type.DENSE);

        register(BiomeGroup.SingleBuilder
                        .configure(5, WNBiomes.RoofedForest,
                                new SubBiome(WNBiomes.RoofedValley, 4, Type.PLAINS)
                        ),
                Type.FOREST, Type.DENSE, Type.MUSHROOM);

        register(BiomeGroup.SingleBuilder
                        .configure(2, WNBiomes.ChristmasDream),
                Type.FOREST, Type.DENSE, Type.SNOWY, Type.COLD, Type.CONIFEROUS, Type.RARE);

        register(BiomeGroup.SingleBuilder
                        .configure(7, WNBiomes.GiantConiferousForest),
                Type.FOREST, Type.DENSE, Type.CONIFEROUS, Type.COLD);

        register(BiomeGroup.SingleBuilder
                        .configure(7, WNBiomes.SnowyGiantConiferousForest),
                Type.FOREST, Type.DENSE, Type.CONIFEROUS, Type.COLD, Type.SNOWY);

        register(BiomeGroup.SingleBuilder
                        .configure(3, WNBiomes.AutumnalSpruceForest),
                Type.FOREST, Type.DENSE, Type.COLD);

        register(BiomeGroup.SingleBuilder
                        .configure(10, WNBiomes.BirchGrove),
                Type.FOREST, Type.DENSE);

        register(BiomeGroup.SingleBuilder
                        .configure(10, WNBiomes.SnowyBirchGrove),
                Type.FOREST, Type.DENSE, Type.SNOWY);

        register(BiomeGroup.SingleBuilder
                        .configure(7, WNBiomes.WeepingBirchForest),
                Type.FOREST, Type.DENSE);

        register(BiomeGroup.SingleBuilder
                        .configure(8, WNBiomes.BirchScrubs,
                                new SubBiome(WNBiomes.BirchMarsh, 4, Type.HILLS)
                        ),
                Type.FOREST);

        register(BiomeGroup.SingleBuilder
                        .configure(3, WNBiomes.FlowerField),
                Type.PLAINS, Type.MAGICAL);

        register(BiomeGroup.SingleBuilder
                        .configure(2, WNBiomes.HyacinthFields),
                Type.PLAINS, Type.MAGICAL);

        register(BiomeGroup.SingleBuilder
                        .configure(2, WNBiomes.MarigoldFields),
                Type.PLAINS, Type.MAGICAL);

        register(BiomeGroup.SingleBuilder
                        .configure(10, WNBiomes.Meadow,
                                new SubBiome(WNBiomes.WoodedMeadow, 7, Type.FOREST),
                                new SubBiome(WNBiomes.WoodedJacarandaMeadow, 4, Type.FOREST, Type.RARE)
                        ),
                Type.PLAINS);

        register(BiomeGroup.SingleBuilder
                        .configure(10, WNBiomes.Sahara,
                                new SubBiome(WNBiomes.Oasis, 1, Type.WET, Type.LUSH, Type.JUNGLE)),
                Type.DEAD, Type.SANDY, Type.DRY, Type.HILLS);

        register(BiomeGroup.SingleBuilder
                        .configure(5, WNBiomes.LushDesert),
                Type.SANDY, Type.DRY, Type.WET, Type.PLAINS, Type.LUSH);

        register(BiomeGroup.SingleBuilder
                        .configure(3, WNBiomes.CrackedDesert),
                Type.DEAD, Type.SANDY, Type.DRY, Type.PLAINS);

        register(BiomeGroup.SingleBuilder
                        .configure(7, WNBiomes.TintedDesert,
                                new SubBiome(WNBiomes.TintedDesertHills, 7, Type.HILLS)
                        ),
                Type.SANDY, Type.DRY, Type.MAGICAL, Type.PLAINS);

        register(BiomeGroup.SingleBuilder
                        .configure(10, WNBiomes.Badlands,
                                new SubBiome(WNBiomes.TropicalBadlands, 3, Type.JUNGLE, Type.LUSH)
                        ),
                Type.PLAINS, Type.SANDY);

        register(BiomeGroup.SingleBuilder
                        .configure(8, WNBiomes.DeadDesolation),
                Type.PLAINS, Type.DEAD, Type.DRY);

        /*register(BiomeGroup.SingleBuilder
                        .configure(6, WNBiomes.Canyons,
                                new SubBiome(WNBiomes.GrandCanyon, 4, Type.MOUNTAIN)
                        ),
                Type.MESA, Type.SANDY, Type.HILLS);*/

        register(BiomeGroup.SingleBuilder
                        .configure(10, WNBiomes.DeciduousForest,
                                new SubBiome(WNBiomes.ForestValley, 3, Type.PLAINS)
                        ),
                Type.FOREST, Type.DENSE);

        register(BiomeGroup.SingleBuilder
                        .configure(10, WNBiomes.Forest,
                                new SubBiome(WNBiomes.ForestValley, 3, Type.PLAINS)
                        ),
                Type.FOREST, Type.DENSE);

        register(BiomeGroup.SingleBuilder
                        .configure(10, WNBiomes.SnowyForest),
                Type.FOREST, Type.DENSE, Type.SNOWY);

        register(BiomeGroup.SingleBuilder
                        .configure(8, WNBiomes.ColdForest),
                Type.FOREST, Type.DENSE, Type.SNOWY, Type.COLD);

        register(BiomeGroup.SingleBuilder
                        .configure(7, WNBiomes.TemperateForest),
                Type.FOREST, Type.DENSE);

        register(BiomeGroup.SingleBuilder
                        .configure(6, WNBiomes.GoldenWoods),
                Type.FOREST, Type.MAGICAL, Type.PLAINS);

        register(BiomeGroup.SingleBuilder
                        .configure(4, WNBiomes.LavenderGarden),
                Type.FOREST, Type.PLAINS, Type.MAGICAL, Type.RARE);

        register(BiomeGroup.SingleBuilder
                        .configure(3, WNBiomes.SaltFlats),
                Type.PLAINS, Type.DEAD, Type.COLD);

        register(BiomeGroup.SingleBuilder
                        .configure(9, WNBiomes.Farmlands),
                Type.FOREST, Type.DENSE);

        register(BiomeGroup.SingleBuilder
                        .configure(9, WNBiomes.MahoganyRainforest,
                                new SubBiome(WNBiomes.MahoganyCliffs,4)
                        ),
                Type.FOREST, Type.JUNGLE, Type.LUSH);

        register(BiomeGroup.SingleBuilder
                        .configure(3, WNBiomes.SakuraJungle),
                Type.FOREST, Type.JUNGLE, Type.MAGICAL, Type.RARE);

        register(BiomeGroup.SingleBuilder
                        .configure(10, WNBiomes.Steppe),
                Type.PLAINS, Type.DRY);

        /*register(BiomeGroup.SingleBuilder
                        .configure(3, WNBiomes.Icelands),
                Type.MOUNTAIN, Type.COLD);*/

        /*register(BiomeGroup.SingleBuilder
                        .configure(3, WNBiomes.Masuria),
                Type.FOREST, Type.RIVER, Type.WATER, Type.LUSH);*/

        register(BiomeGroup.SingleBuilder
                        .configure(8, WNBiomes.Wetlands),
                Type.PLAINS, Type.WET, Type.LUSH, Type.WATER);

        register(BiomeGroup.SingleBuilder
                        .configure(8, WNBiomes.MangroveForest),
                Type.FOREST, Type.WATER);

        register(BiomeGroup.SingleBuilder
                        .configure(7, WNBiomes.Backwaters),
                Type.FOREST, Type.WATER);

        register(BiomeGroup.SingleBuilder
                        .configure(8, WNBiomes.EucalyptusForest),
                Type.JUNGLE, Type.FOREST, Type.DENSE, Type.WET, Type.LUSH);

        register(BiomeGroup.SingleBuilder
                        .configure(3, WNBiomes.GiantEucalyptusForest),
                Type.JUNGLE, Type.FOREST, Type.DENSE, Type.WET, Type.LUSH, Type.MAGICAL, Type.RARE);

        register(BiomeGroup.SingleBuilder
                        .configure(3, WNBiomes.DaintreeForest,
                                new SubBiome(WNBiomes.DaintreePlateau,3, Type.PLATEAU)
                        ),
                Type.FOREST, Type.LUSH, Type.JUNGLE);

        /*register(BiomeGroup.SingleBuilder
                        .configure(3, WNBiomes.DaintreeCliffs,
                                new SubBiome(WNBiomes.DaintreeForest,2)
                        ),
                Type.FOREST, Type.LUSH, Type.JUNGLE, Type.HILLS);*/

        register(BiomeGroup.SingleBuilder
                        .configure(4, WNBiomes.BananaThicket),
                Type.JUNGLE, Type.FOREST);

        register(BiomeGroup.SingleBuilder
                        .configure(6, WNBiomes.OliveGarden,
                                new SubBiome(WNBiomes.OliveHills, 3,Type.HILLS)
                        ),
                Type.PLAINS, Type.HOT, Type.SPARSE);

        register(BiomeGroup.SingleBuilder
                        .configure(8, WNBiomes.HornbeamForest,
                                new SubBiome(WNBiomes.HornbeamHills,4, Type.HILLS),
                                new SubBiome(WNBiomes.HornbeamValley,3, Type.PLAINS)
                        ),
                Type.FOREST, Type.DENSE, Type.LUSH);

        register(BiomeGroup.SingleBuilder
                        .configure(2, WNBiomes.Mirkwood,
                                new SubBiome(WNBiomes.DarkMirkwood,3)),
                Type.FOREST, Type.DENSE, Type.RARE, Type.SPOOKY);

        register(BiomeGroup.SingleBuilder
                        .configure(5, WNBiomes.ThujaShield),
                Type.FOREST, Type.LUSH, Type.WET);


        //DICTIONARY
        registerNonSpawn(River, Type.RIVER, Type.WET, Type.WATER, Type.OVERWORLD);
        registerNonSpawn(FrozenRiver, Type.RIVER, Type.WET, Type.COLD, Type.SNOWY, Type.WATER, Type.OVERWORLD);
        registerNonSpawn(NileRiver, Type.RIVER, Type.WET, Type.DRY, Type.HOT, Type.WATER, Type.SANDY, Type.OVERWORLD);
        registerNonSpawn(AmazonRiver, Type.RIVER, Type.WET, Type.JUNGLE, Type.WATER, Type.OVERWORLD);

        registerNonSpawn(WarmLake, Type.RIVER, Type.WET, Type.WATER, Type.OVERWORLD);
        registerNonSpawn(TropicalLake, Type.RIVER, Type.WET, Type.JUNGLE, Type.WATER, Type.OVERWORLD);
        registerNonSpawn(FrozenLake, Type.RIVER, Type.WET, Type.COLD, Type.SNOWY, Type.WATER, Type.OVERWORLD);
        registerNonSpawn(ColdLake, Type.RIVER, Type.WET, Type.COLD, Type.WATER, Type.OVERWORLD);

        BiomeGroups.register();
    }

    private static void registerVanilla(){
        register(BiomeGroup.SingleBuilder
                        .configure(10, Biomes.PLAINS,
                                new SubBiome(Biomes.SUNFLOWER_PLAINS,1,Type.RARE)
                        ),
                Type.PLAINS);

        register(BiomeGroup.SingleBuilder
                        .configure(10, Biomes.DESERT,
                                new SubBiome(Biomes.DESERT_HILLS,4, Type.HILLS),
                                new SubBiome(Biomes.DESERT_LAKES,2, Type.WATER)
                        ),
                Type.SANDY, Type.DRY, Type.DEAD);

        register(BiomeGroup.SingleBuilder
                        .configure(10, Biomes.MOUNTAINS,
                                new SubBiome(Biomes.GRAVELLY_MOUNTAINS,3),
                                new SubBiome(Biomes.MODIFIED_GRAVELLY_MOUNTAINS,3, Type.MODIFIED)
                        ),
                Type.MOUNTAIN);

        register(BiomeGroup.SingleBuilder
                        .configure(10, Biomes.FOREST,
                                new SubBiome(Biomes.WOODED_HILLS, 4, Type.HILLS),
                                new SubBiome(Biomes.FLOWER_FOREST,1,Type.LUSH)
                        ),
                Type.FOREST);

        register(BiomeGroup.SingleBuilder
                        .configure(10, Biomes.TAIGA,
                                new SubBiome(Biomes.TAIGA_HILLS, 4, Type.HILLS)
                        ),
                Type.FOREST, Type.CONIFEROUS);

        register(BiomeGroup.SingleBuilder
                        .configure("swamp",10, Biomes.SWAMP,
                                new SubBiome(Biomes.SWAMP_HILLS,4, Type.HILLS)
                        ),
                Type.SWAMP, Type.WET);

        register(BiomeGroup.SingleBuilder
                        .configure(10, Biomes.SNOWY_TUNDRA,
                                new SubBiome(Biomes.ICE_SPIKES,3,Type.RARE, Type.MODIFIED)
                        ),
                Type.COLD, Type.PLAINS, Type.SNOWY);

        register(BiomeGroup.SingleBuilder
                        .configure(10, Biomes.SNOWY_MOUNTAINS),
                Type.MOUNTAIN, Type.SNOWY);

        register(BiomeGroup.SingleBuilder
                        .configure("jungle",10, Biomes.JUNGLE,
                                new SubBiome(Biomes.JUNGLE_HILLS,4, Type.HILLS),
                                new SubBiome(Biomes.MODIFIED_JUNGLE,2, Type.MODIFIED)
                        ),
                Type.FOREST, Type.DENSE, Type.JUNGLE);

        register(BiomeGroup.SingleBuilder
                        .configure(10, Biomes.BIRCH_FOREST,
                                new SubBiome(Biomes.BIRCH_FOREST_HILLS,4,Type.HILLS)
                        ),
                Type.FOREST);

        register(BiomeGroup.SingleBuilder
                        .configure(10, Biomes.SNOWY_TAIGA,
                                new SubBiome(Biomes.SNOWY_TAIGA_HILLS,4, Type.HILLS)
                        ),
                Type.COLD, Type.CONIFEROUS, Type.FOREST, Type.SNOWY);

        register(BiomeGroup.SingleBuilder
                        .configure(6, Biomes.DARK_FOREST,
                                new SubBiome(Biomes.DARK_FOREST_HILLS,4,Type.HILLS)),
                Type.FOREST, Type.DENSE);

        register(BiomeGroup.SingleBuilder
                        .configure(5, Biomes.GIANT_TREE_TAIGA,
                                new SubBiome(Biomes.GIANT_TREE_TAIGA_HILLS,3,Type.HILLS)),
                Type.FOREST, Type.CONIFEROUS, Type.COLD);

        register(BiomeGroup.SingleBuilder
                        .configure(10, Biomes.WOODED_MOUNTAINS),
                Type.MOUNTAIN, Type.FOREST);

        register(BiomeGroup.SingleBuilder
                        .configure(10, Biomes.SAVANNA,
                                new SubBiome(Biomes.SAVANNA_PLATEAU,4,Type.PLATEAU)),
                Type.SAVANNA, Type.DRY);

        register(BiomeGroup.SingleBuilder
                        .configure(10, Biomes.BADLANDS,
                                new SubBiome(Biomes.BADLANDS_PLATEAU, 4, Type.PLATEAU),
                                new SubBiome(Biomes.WOODED_BADLANDS_PLATEAU,3, Type.PLATEAU, Type.FOREST, Type.SPARSE),
                                new SubBiome(Biomes.ERODED_BADLANDS,2, Type.MODIFIED),
                                new SubBiome(Biomes.MODIFIED_BADLANDS_PLATEAU,3,Type.MODIFIED),
                                new SubBiome(Biomes.MODIFIED_WOODED_BADLANDS_PLATEAU,3, Type.MODIFIED)
                        ),
                Type.MESA);

        register(BiomeGroup.SingleBuilder
                        .configure(10, Biomes.TAIGA_MOUNTAINS),
                Type.MOUNTAIN, Type.CONIFEROUS, Type.FOREST);

        register(BiomeGroup.SingleBuilder
                        .configure(10, Biomes.SNOWY_TAIGA_MOUNTAINS),
                Type.MOUNTAIN, Type.CONIFEROUS, Type.FOREST, Type.SNOWY);

        register(BiomeGroup.SingleBuilder
                        .configure("bamboo_jungle",5, Biomes.BAMBOO_JUNGLE,
                                new SubBiome(Biomes.BAMBOO_JUNGLE_HILLS,3, Type.HILLS)
                        ),
                Type.JUNGLE, Type.LUSH);

        register(BiomeGroup.SingleBuilder
                        .configure(10, Biomes.TALL_BIRCH_FOREST,
                                new SubBiome(Biomes.TALL_BIRCH_HILLS,3, Type.HILLS)
                        ),
                Type.DENSE, Type.FOREST);

        register(BiomeGroup.SingleBuilder
                        .configure(3, Biomes.GIANT_SPRUCE_TAIGA,
                                new SubBiome(Biomes.GIANT_SPRUCE_TAIGA_HILLS,3,Type.HILLS)),
                Type.FOREST, Type.CONIFEROUS, Type.COLD, Type.RARE);

        register(BiomeGroup.SingleBuilder
                        .configure(10, Biomes.PLAINS),
                Type.PLAINS);

        register(BiomeGroup.SingleBuilder
                        .configure(5, Biomes.SHATTERED_SAVANNA,
                                new SubBiome(Biomes.SHATTERED_SAVANNA_PLATEAU,3,Type.PLATEAU)),
                Type.SAVANNA, Type.HILLS);
    }

    private static void registerEdges(){
        BiomeGroup jungleEdge = BiomeGroup.SingleBuilder.configure("jungle_edge",Biomes.JUNGLE_EDGE);
        EdgeBiome.register(jungleEdge,BiomeTerrain.getGroupByName("jungle"));
        EdgeBiome.register(jungleEdge,BiomeTerrain.getGroupByName("bamboo_jungle"));
        BiomeGroup tatraFoothills = BiomeGroup.SingleBuilder.configure("tatra_foothills",WNBiomes.TatraFoothills);
        BiomeGroup snowyTatraFoothills = BiomeGroup.SingleBuilder.configure("snowy_tatra_foothills",WNBiomes.SnowyTatraFoothills);
        EdgeBiome.register(tatraFoothills,BiomeTerrain.getGroupByName("tatras"));
        EdgeBiome.register(snowyTatraFoothills,BiomeTerrain.getGroupByName("snowy_tatras"));
    }

    private static void registerIslands(){
        Biome[] hot_deep_oceans = new Biome[]{
                Biomes.DEEP_LUKEWARM_OCEAN, Biomes.DEEP_WARM_OCEAN
        };
        Biome[] cold_deep_oceans = new Biome[]{
                Biomes.DEEP_COLD_OCEAN, Biomes.DEEP_FROZEN_OCEAN
        };
        Biome[] temperate_deep_oceans = new Biome[]{
                Biomes.DEEP_LUKEWARM_OCEAN, Biomes.DEEP_OCEAN, Biomes.DEEP_COLD_OCEAN
        };

        IslandBiome.register(
                BiomeGroup.SingleBuilder.configure("island", WNBiomes.Island), 6, IslandBiome.IslandType.SMALL, temperate_deep_oceans, Type.PLAINS, Type.WATER
        );

        IslandBiome.register(
                BiomeGroup.SingleBuilder.configure("forested_island", WNBiomes.ForestedIsland), 4, IslandBiome.IslandType.SMALL, temperate_deep_oceans, Type.FOREST, Type.WATER
        );

        IslandBiome.register(
                BiomeGroup.SingleBuilder.configure("snowy_island", WNBiomes.SnowyIsland), 6, IslandBiome.IslandType.SMALL, cold_deep_oceans, Type.PLAINS, Type.COLD, Type.SNOWY, Type.WATER
        );

        IslandBiome.register(
                BiomeGroup.SingleBuilder.configure("easter_island", WNBiomes.EasterIsland), 2, IslandBiome.IslandType.BIG, temperate_deep_oceans, Type.PLAINS, Type.RARE, Type.WATER
        );

        IslandBiome.register(
                BiomeGroup.SingleBuilder.configure("tropical_island",WNBiomes.TropicalIsland,
                    new SubBiome(WNBiomes.TropicalCliffs,4,Type.HILLS)
                ), 5, hot_deep_oceans, Type.JUNGLE, Type.LUSH, Type.WET, Type.RARE, Type.WATER
        );

        IslandBiome.register(
                BiomeGroup.SingleBuilder.configure("paradise_island",WNBiomes.ParadiseIsland), 1, IslandBiome.IslandType.SMALL, temperate_deep_oceans, Type.FOREST, Type.PLAINS, Type.LUSH, Type.WET, Type.RARE, Type.WATER
        );

        IslandBiome.register(
                BiomeGroup.SingleBuilder.configure("christmas_island",WNBiomes.ChristmasIsland), 5, IslandBiome.IslandType.BIG, cold_deep_oceans, Type.COLD, Type.CONIFEROUS, Type.MAGICAL, Type.SNOWY, Type.WATER
        );

        IslandBiome.register(
                BiomeGroup.SingleBuilder.configure("madagascar",WNBiomes.Madagascar,
                        new SubBiome(WNBiomes.MadagascarValley,3,Type.PLAINS)
                ), 4, IslandBiome.IslandType.BIG, hot_deep_oceans, Type.FOREST, Type.DENSE, Type.JUNGLE, Type.LUSH
        );

        IslandBiome.register(
                BiomeGroup.SingleBuilder.configure("mushroom_island",Biomes.MUSHROOM_FIELDS),3, IslandBiome.IslandType.BIG, temperate_deep_oceans,Type.MUSHROOM, Type.MAGICAL, Type.PLAINS
        );

    }

    private static void registerNonSpawns(){
        registerNonSpawn(WNBiomes.Beach, Type.SANDY, Type.BEACH, Type.WATER);
        registerNonSpawn(WNBiomes.PalmBeach, Type.SANDY, Type.BEACH, Type.WATER, Type.FOREST);
        registerNonSpawn(WNBiomes.WhiteBeach, Type.SANDY, Type.BEACH, Type.WATER, Type.HOT);
        registerNonSpawn(WNBiomes.WhitePalmBeach, Type.SANDY, Type.BEACH, Type.WATER, Type.HOT, Type.FOREST);
        registerNonSpawn(WNBiomes.BeachDunes, Type.SANDY, Type.BEACH, Type.WATER, Type.LUSH, Type.MODIFIED);
        registerNonSpawn(WNBiomes.ColdBeach, Type.SANDY, Type.BEACH, Type.WATER, Type.COLD, Type.SNOWY);
        registerNonSpawn(WNBiomes.StoneShore, Type.BEACH, Type.WATER, Type.COLD);
        registerNonSpawn(WNBiomes.ColdStoneShore, Type.BEACH, Type.WATER, Type.COLD, Type.SNOWY);

        registerNonSpawn(WNBiomes.DeepJellyOcean, Type.OCEAN, Type.WATER, Type.MAGICAL, Type.RARE);
    }

    public static void register(BiomeGroup group, boolean canGuess, BiomeDictionary.Type... types) {
        putToRegistry(group);
        BiomeTerrain.register(group, canGuess, types);
    }

    public static void register(BiomeGroup group, BiomeDictionary.Type... types) {
        putToRegistry(group);
        BiomeTerrain.register(group, types);
        WN.LOGGER.info("Registered BiomeGroup " + group.getName() + " (baseBiome: " + group.getBaseBiome().getRegistryName() + ") --- T: " + BiomeTransformer.TempCategory.getFromTemperature(-0.1f,1,group.getBaseBiome().getDefaultTemperature()) + ", M: " + BiomeTransformer.WetCategory.getFromMoisture(0,1,group.getBaseBiome().getDownfall()));
    }

    public static void register(BiomeGroup group, boolean canGuess) {
        putToRegistry(group);
        BiomeTerrain.register(group, canGuess);
    }

    public static void register(BiomeGroup group) {
        putToRegistry(group);
        BiomeTerrain.register(group);
    }

    private static void putToRegistry(BiomeGroup group, BiomeDictionary.Type... types){
        boolean containsBaseBiome = false;
        for (BiomeToRegister biomeToRegister : biomesToRegister) {
            if(biomeToRegister.biome == group.getBaseBiome()){
                containsBaseBiome = true;
                break;
            }
        }

        if(!containsBaseBiome && group.getBaseBiome().getRegistryName().getNamespace().equals("wildnature")) {
            BiomeDictionary.addTypes(group.getBaseBiome(), types);
            biomesToRegister.add(new BiomeToRegister(group.getBaseBiome(), null, group.getWeight()));
        }

        for (SubBiome subBiome : group.getSubBiomes()) {
            boolean containsSubBiome = false;
            for (BiomeToRegister biomeToRegister : biomesToRegister) {
                if(biomeToRegister.biome == subBiome.getBiome()){
                    containsSubBiome = true;
                    break;
                }
            }

            if(!containsSubBiome && subBiome.getBiome().getRegistryName().getNamespace().equals("wildnature")) {
                //BiomeDictionary.addTypes(subBiome.getBiome(), subTypes.toArray(new Type[0])); TODO types crash
                biomesToRegister.add(new BiomeToRegister(subBiome.getBiome(), null, subBiome.getWeight()));
            }
        }
    }


    public static void registerNonSpawn(Biome biome, Type... types) {//adds biome to biome list that have to spawn naturally.
        if (CommonConfig.generateBiomes.get()) {
            WN.LOGGER.info("Registering dictionary for unusual biome: " + biome.getRegistryName() + " " + new ArrayList<Type>(Arrays.asList(types)).toString());
            BiomeDictionary.addTypes(biome, types);
        }
        generatorBiomes.add(biome);
    }

    public static void registerAll() { //adds biome to biome list that have to spawn naturally.
        WN.LOGGER.info(" ----- Registering " + biomesToRegister.size() + " biomes ----- ");
        biomesToRegister.forEach(BiomeToRegister::registerIt);
        WNGlobalBiomeFeatures.setup();
        if (!CommonConfig.generateBiomes.get()) {
            WN.LOGGER.info("Biome generation is not active");
        }
        WN.LOGGER.info(" -------------------------------------------------------------- ");
    }

    public static void unregisterBlacklisted() {
        ArrayList<BiomeManager.BiomeEntry> b = new ArrayList<>();
        try {
            b.addAll(Objects.requireNonNull(WNBiomeManager.getBiomes(BiomeManager.BiomeType.ICY)));
            b.addAll(Objects.requireNonNull(WNBiomeManager.getBiomes(BiomeManager.BiomeType.COOL)));
            b.addAll(Objects.requireNonNull(WNBiomeManager.getBiomes(BiomeManager.BiomeType.WARM)));
            b.addAll(Objects.requireNonNull(WNBiomeManager.getBiomes(BiomeManager.BiomeType.DESERT)));
            WN.LOGGER.debug(" -------------------------------------------------------------- ");
            b.forEach(biomeEntry -> {
                WN.LOGGER.debug("entry: " + biomeEntry.biome.getRegistryName());
            });
            WN.LOGGER.debug("entries: " + b.size());
            WN.LOGGER.debug(" -------------------------------------------------------------- ");
            for (BiomeManager.BiomeEntry biomeEntry : b) {
                if (CommonConfig.blacklistedBiomes.contains(biomeEntry.biome)) {
                    WN.LOGGER.info("Removed blacklisted " + biomeEntry.biome.getRegistryName() + " biome from generation.");
                    WNBiomeManager.removeSpawnBiome(biomeEntry.biome);
                    WNBiomeManager.removeBiome(BiomeManager.BiomeType.ICY, biomeEntry);
                    WNBiomeManager.removeBiome(BiomeManager.BiomeType.COOL, biomeEntry);
                    WNBiomeManager.removeBiome(BiomeManager.BiomeType.WARM, biomeEntry);
                    WNBiomeManager.removeBiome(BiomeManager.BiomeType.DESERT, biomeEntry);
                }
            }
        } catch (Exception e) {
            WN.LOGGER.warn("Unable to unregister blacklisted biomes. " + e.getLocalizedMessage());
        }
    }

    public static class BiomeToRegister {
        private Biome biome;
        private WNBiomeManager.BiomeType type;
        private int weight;
        private Type[] types;

        public BiomeToRegister(Biome biome, WNBiomeManager.BiomeType type, int weight, Type... types) {
            this.biome = biome;
            this.type = type;
            this.weight = weight;
            this.types = types;

            if(type==null){
                if(biome.getDefaultTemperature() < 0){
                    this.type = BiomeManager.BiomeType.ICY;
                }else if(biome.getDefaultTemperature() < 0.4){
                    this.type = BiomeManager.BiomeType.COOL;
                }else if(biome.getDefaultTemperature() < 0.8){
                    this.type = BiomeManager.BiomeType.WARM;
                }else{
                    this.type = BiomeManager.BiomeType.DESERT;
                }
            }
        }

        /**
         * Registers addional biomes, only for other generator compatibility
         */
        public void registerIt() {
            if (CommonConfig.blacklistedBiomes.contains(biome)) {
                WN.LOGGER.info(biome.getRegistryName() + " is blacklisted.");

                return;
            }
            WN.LOGGER.info("Registered " + biome.getRegistryName() + " biome");


            WNBiomeManager.addBiome(type, new WNBiomeManager.BiomeEntry(biome, weight));
            WNBiomeManager.addSpawnBiome(biome);
            // Add all biomes to weighted list
            EnumBiomes.ALL.add(biome, weight);
        }
    }

}
