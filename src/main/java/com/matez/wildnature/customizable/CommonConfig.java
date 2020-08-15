package com.matez.wildnature.customizable;

import com.matez.wildnature.Main;
import com.matez.wildnature.world.gen.manager.WNBiomeManager;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonConfig {

    private static CommonConfig instance;
    public final ForgeConfigSpec.Builder builder;

    public static ForgeConfigSpec.ConfigValue<String> currentVersion;
    public static ForgeConfigSpec.BooleanValue changePanorama, newLoadingWorldScreen, generateOnlyWildNature;
    public static ForgeConfigSpec.BooleanValue useWNOnServer;
    public static ForgeConfigSpec.DoubleValue riverDepth;
    public static ForgeConfigSpec.BooleanValue messageOnJoin;
    public static ForgeConfigSpec.BooleanValue effectOnJoin;
    public static ForgeConfigSpec.BooleanValue renderCapes;
    public static ForgeConfigSpec.BooleanValue playAmbientSounds;
    public static ForgeConfigSpec.BooleanValue replaceDefaultTrees;
    public static ForgeConfigSpec.BooleanValue generateUndergroundPlants;
    public static ForgeConfigSpec.BooleanValue generateRiverCanes;
    public static ForgeConfigSpec.BooleanValue generatePoisonIves,generateCrystals,generateStalagmites,generatePebbles,generateCobweb,generateRockFormations,generateFruitBushes,generateVegeCrops,generateVines,generateSmallCacti,generateShells,generateMoss,generateFallenTrees;
    public static ForgeConfigSpec.DoubleValue ambientSoundsVolume;
    public static ForgeConfigSpec.BooleanValue waterLakeGeneration,lavaLakeGeneration,waterSpringGeneration,lavaSpringGeneration;
    public static ForgeConfigSpec.BooleanValue generateGlowingCaveOaks,generateBigGlowshrooms;

    public static ForgeConfigSpec.IntValue biomeSize,riverSize;
    public static ForgeConfigSpec.IntValue maxSearchRadius,biomeGroupSpawningSize, biomeGroupChance;
    public static ForgeConfigSpec.IntValue rockFormationChance;
    public static ForgeConfigSpec.BooleanValue generateOres, generateRocks, genBasalt, genConglomerate, genGneiss, genLimestone, genMarble, genPegmatite, genSlate;
    public static ForgeConfigSpec.IntValue rockChance, rockSize;
    public static ForgeConfigSpec.DoubleValue steamMaxAge;
    public static ForgeConfigSpec.ConfigValue<String> blacklistBiome;
    public static ForgeConfigSpec.BooleanValue generateBiomes;
    public static ForgeConfigSpec.BooleanValue flowerDisappearsOnWalk;
    public static ForgeConfigSpec.BooleanValue poisonIvyHurts;
    public static ForgeConfigSpec.BooleanValue poisonIvyPoisons;
    public static ForgeConfigSpec.DoubleValue poisonIvyDamage;
    public static ForgeConfigSpec.IntValue leafFruitChance, flowerBloomChance, flowerDropChance,fruitBushRarity,vegeCropRarity,mossRarity,mossRarityDense,riverCaneRarity,smallCactiRarity,poisonIvyRarity,riverCaneDensity,shellRarity;
    public static ForgeConfigSpec.IntValue tinRarity,copperRarity,amethystRarity,sapphireRarity,malachiteRarity,silverRarity,amberRarity,rubyRarity,saltSandRarity,saltStoneRarity;
    public static ForgeConfigSpec.BooleanValue vegeFarmFence;
    public static ForgeConfigSpec.BooleanValue generatePaths, generateUndergroundRivers;
    public static ForgeConfigSpec.DoubleValue pathFrequency;

    public static ForgeConfigSpec.IntValue tinOreHarvestLevel, copperOreHarvestLevel, amethystOreHarvestLevel, sapphireOreHarvestLevel, malachiteOreHarvestLevel, silverOreHarvestLevel, amberOreHarvestLevel, rubyOreHarvestLevel;
    public static ForgeConfigSpec.BooleanValue vegeGrassSpawn;

    public static ForgeConfigSpec.IntValue vegeCropChance, fruitBushChance;

    public static ArrayList<Biome> blacklistedBiomes = new ArrayList<>();

    public static ForgeConfigSpec.ConfigValue<String> generatorType;

    public CommonConfig(ForgeConfigSpec.Builder builder) {
        instance = this;

        this.builder = builder;
        builder.comment("WildNature configuration file");

        general();
        generator();
        sound();
        block();


    }

    public static CommonConfig get()
    {
        return instance;
    }

    private void general()
    {
        builder.push("general");

        currentVersion = builder
                .comment("Installed mod version. Please do not change this.").define("system.version", "");
        maxSearchRadius = builder
                .comment("Max *nearest* biome search radius. After exceeding this number, WildNature will search for biome ignoring radius.\nDefault: 15000")
                .defineInRange("system.max_search_radius", 15000,10,100000000);
        useWNOnServer = builder
                .comment("Always use WN World Generator on server?\nDefault:true")
                .define("system.wn_server_gen",true);
        messageOnJoin = builder
                .comment("Send messages to users on join?\nDefault:true")
                .define("system.message_on_join",true);
        effectOnJoin = builder
                .comment("Special effects on join?\nDefault:true")
                .define("system.effect_on_join",true);
        renderCapes = builder
                .comment("Should render capes?\nDefault:true")
                .define("system.render_capes",true);
        changePanorama = builder
                .comment("Should change main menu panorama?\nDefault:true")
                .define("system.panorama",true);
        newLoadingWorldScreen = builder
                .comment("Use new world loading screen?\nDefault:true")
                .define("system.worldLoadScreen",true);

        builder.pop();
    }

    private void generator()
    {

        builder.push("generator");

        generatorType = builder
                .comment("Generator version. \nAccepted Values: wildnature | wildnature-simplex").define("generatorType", "wildnature");


        biomeSize = builder
                .comment("Biome Size\nDefault: 5")
                .defineInRange("biomeSize",5, 1, 20);

        riverSize = builder
                .comment("River Size\nDefault: 4")
                .defineInRange("riverSize",4, 1, 20);

        generateOres = builder
                .comment("Generate Ores?\nDefault: true")
                .define("ores.all",true);

        generateRocks = builder
                .comment("Generate Rocks?\nDefault: true")
                .define("rocks.all",true);

        genBasalt = builder
                .comment("Generate Basalt?\nIf you set generator.rocks.all to FALSE, changing this has no sense\nDefault: true")
                .define("rocks.define.basalt",true);

        genConglomerate = builder
                .comment("Generate Conglomerate?\nIf you set generator.rocks.all to FALSE, changing this has no sense\nDefault: true")
                .define("rocks.define.conglomerate",true);

        genGneiss = builder
                .comment("Generate Gneiss?\nIf you set generator.rocks.all to FALSE, changing this has no sense\nDefault: true")
                .define("rocks.define.gneiss",true);

        genLimestone = builder
                .comment("Generate Limestone?\nIf you set generator.rocks.all to FALSE, changing this has no sense\nDefault: true")
                .define("rocks.define.limestone",true);

        genMarble = builder
                .comment("Generate Marble?\nIf you set generator.rocks.all to FALSE, changing this has no sense\nDefault: true")
                .define("rocks.define.marble",true);

        genPegmatite = builder
                .comment("Generate Pegmatite?\nIf you set generator.rocks.all to FALSE, changing this has no sense\nDefault: true")
                .define("rocks.define.pegmatite",true);

        genSlate = builder
                .comment("Generate Slate?\nIf you set generator.rocks.all to FALSE, changing this has no sense\nDefault: true")
                .define("rocks.define.slate",true);

        rockChance = builder
                .comment("Chance of rock generation\nDefault: 33")
                .defineInRange("rocks.chance",33, 0, 100);

        rockSize = builder
                .comment("Rock deposit size\nDefault: 10")
                .defineInRange("rocks.size",10, 0, 100);

        riverDepth=builder
                .comment("Depth of all of rivers\nDefault: -1.0")
                .defineInRange("biome.river.depth",-1.0,-10.0,10);

        biomeGroupSpawningSize=builder
                .comment("Size of sub-biomes\nbigger sub-biomes = lower number\nDefault: 3")
                .defineInRange("biome.group.size",3,1,100);

        biomeGroupChance=builder
                .comment("Chance of sub-biome spawn\nDefault: 5")
                .defineInRange("biome.group.chance",5,0 ,10);

        rockFormationChance = builder
                .comment("Rock formation chance\nSmaller = more common\nDefault: 7")
                .defineInRange("rocks.formation_chance",7, 0, 10000);

        tinRarity = builder
                .comment("Tin ore rarity\nSmaller = more rare\nDefault: 8")
                .defineInRange("ores.tin_rarity",8, 0, 500);

        copperRarity = builder
                .comment("Copper ore rarity\nSmaller = more rare\nDefault: 8")
                .defineInRange("ores.copper_rarity",8, 0, 500);

        amethystRarity = builder
                .comment("Amethyst ore rarity\nSmaller = more rare\nDefault: 4")
                .defineInRange("ores.amethyst_rarity",4, 0, 500);

        sapphireRarity = builder
                .comment("Sapphire ore rarity\nSmaller = more rare\nDefault: 3")
                .defineInRange("ores.sapphire_rarity",3, 0, 500);

        malachiteRarity = builder
                .comment("Malachite ore rarity\nSmaller = more rare\nDefault: 2")
                .defineInRange("ores.malachite_rarity",2, 0, 500);

        silverRarity = builder
                .comment("Silver ore rarity\nSmaller = more rare\nDefault: 1")
                .defineInRange("ores.silver_rarity",1, 0, 500);

        amberRarity = builder
                .comment("Amber ore rarity. Ambers generates on beaches only!!!\nSmaller = more rare\nDefault: 3")
                .defineInRange("ores.amber_rarity",3, 0, 500);

        rubyRarity = builder
                .comment("Ruby ore rarity\nWarning - rubies are rare because they're generated only under oceans.\nSmaller = more rare\nDefault: 2")
                .defineInRange("ores.ruby_rarity",2, 0, 500);

        saltStoneRarity = builder
                .comment("Stone salt ore rarity\nSmaller = more rare\nDefault: 7")
                .defineInRange("ores.salt_stone_rarity",7, 0, 500);

        saltSandRarity = builder
                .comment("Sandy salt ore rarity\nSmaller = more rare\nDefault: 6")
                .defineInRange("ores.salt_sand_rarity",6, 0, 500);

        generateBiomes = builder
                .comment("Generate Biomes?\nDefault: true")
                .define("biome.generate",true);

        generateOnlyWildNature = builder
                .comment("Generate only WildNature biomes?\nDefault: false")
                .define("biome.generate_only_wildnature",false);

        blacklistBiome = builder
                .comment("Insert biome ids that shouldn't generate naturally. Example - wildnature:grasslands,wildnature:bog").define("biome.blacklist", "");

        replaceDefaultTrees = builder
                .comment("Replace vanilla trees with WildNature ones?\nDefault: true")
                .define("biome.feature.replaceDefaultTrees",true);

        generateUndergroundPlants = builder
            .comment("Should generate cave plants like glowing mushrooms\nDefault: true")
            .define("biome.feature.cavePlants",true);

        generateCrystals = builder
                .comment("Should generate crystals?\nDefault: true")
                .define("biome.feature.crystals",true);

        generateStalagmites = builder
                .comment("Should generate stalagmites?\nDefault: true")
                .define("biome.feature.stalagmites",true);

        generatePebbles = builder
                .comment("Should generate pebbles?\nDefault: true")
                .define("biome.feature.pebbles",true);

        generateCobweb = builder
                .comment("Should generate cobweb?\nDefault: true")
                .define("biome.feature.cobweb",true);

        generateRockFormations = builder
                .comment("Should generate rock formations?\nDefault: true")
                .define("biome.feature.rock_formations",true);

        generateGlowingCaveOaks = builder
                .comment("Should generate glowing cave oaks?\nDefault: true")
                .define("biome.feature.glowingCaveOaks",true);

        generateBigGlowshrooms = builder
                .comment("Should generate big glowshrooms?\nDefault: true")
                .define("biome.feature.bigGlowshrooms",true);

        generatePoisonIves = builder
                .comment("Should generate poison ives & spidergrass?\nDefault: true")
                .define("biome.feature.special_plants",true);

        generateFruitBushes = builder
                .comment("Should generate fruit bushes?\nDefault: true")
                .define("biome.feature.fruit_bushes",true);

        generateVegeCrops = builder
                .comment("Should generate vege crops?\nDefault: true")
                .define("biome.feature.vege_crops",true);

        generateVines = builder
            .comment("Should generate vines?\nDefault: true")
            .define("biome.feature.vines",true);

        generateRiverCanes = builder
                .comment("Should generate river cane?\nDefault: true")
                .define("biome.feature.river_cane",true);

        generateSmallCacti = builder
                .comment("Should generate small cacti?\nDefault: true")
                .define("biome.feature.small_cacti",true);

        generateShells = builder
                .comment("Should generate shells?\nDefault: true")
                .define("biome.feature.shells",true);

        generateMoss = builder
                .comment("Should generate moss?\nDefault: true")
                .define("biome.feature.moss",true);

        generateFallenTrees = builder
                .comment("Should generate fallen trees?\nDefault: true")
                .define("biome.feature.fallenTrees",true);

        vegeFarmFence = builder
                .comment("Should generate fences near wild farms?\nDefault: true")
                .define("biome.feature.vege_farm_fence",true);

        fruitBushRarity = builder
                .comment("Fruit bushes spawn rarity\nSmaller = more rare\nDefault: 3")
                .defineInRange("biome.feature.fruit_bushes_rarity",3, 0, 500);

        vegeCropRarity = builder
                .comment("Vegetable crops spawn rarity\nSmaller = more rare\nDefault: 2")
                .defineInRange("biome.feature.vege_crops_rarity",2, 0, 500);

        fruitBushChance = builder
                .comment("Fruit bush spawn chance. Spawns if random from 0 and <number> equals 0\nSmaller = more common\nDefault: 2")
                .defineInRange("biome.feature.fruit_bushes_chance",2, 0, 500);

        vegeCropChance = builder
                .comment("Vege Crop spawn chance. Spawns if random from 0 and <number> equals 0\nSmaller = more common\nDefault: 1")
                .defineInRange("biome.feature.fruit_bushes_chance",1, 0, 500);

        poisonIvyRarity = builder
                .comment("Posion ivy & spidergrass & thistle & nettle rarity\nSmaller = more rare\nDefault: 2")
                .defineInRange("biome.feature.ivy_rarity",2, 0, 500);

        riverCaneRarity = builder
                .comment("River cane rarity\nSmaller = more rare\nDefault: 50")
                .defineInRange("biome.feature.river_cane_rarity",50, 0, 500);

        riverCaneDensity = builder
                .comment("River cane density\nSmaller = less\nDefault: 50")
                .defineInRange("biome.feature.river_cane_density",64, 0, 500);

        smallCactiRarity = builder
                .comment("Small cacti rarity\nSmaller = more rare\nDefault: 5")
                .defineInRange("biome.feature.small_cacti_rarity",5, 0, 500);
        shellRarity = builder
                .comment("Shell generation rarity\nSmaller = more rare\nDefault: 6")
                .defineInRange("biome.feature.shell_rarity",6, 0, 500);

        mossRarity = builder
                .comment("Moss spawn rarity in forests\nSmaller = more rare\nDefault: 4")
                .defineInRange("biome.feature.moss_rarity",4, 0, 500);

        mossRarityDense = builder
                .comment("Moss spawn rarity in dense forests\nSmaller = more rare\nDefault: 8")
                .defineInRange("biome.feature.moss_rarity_dense",8, 0, 500);

        generatePaths = builder
                .comment("Should generate pathways?\nDefault: true")
                .define("biome.feature.pathways",true);

        generateUndergroundRivers = builder
                .comment("Generate underground rivers?\nDefault: true")
                .define("biome.feature.undergroundRivers",true);

        pathFrequency = builder
                .comment("Pathway noise frequency\nDefault: 0.005")
                .defineInRange("biome.feature.pathway_frequency",0.005, 0.00001, 100);

        waterLakeGeneration = builder
                .comment("Should generate water lakes?\nDefault: true")
                .define("biome.feature.waterLakeGeneration",true);

        lavaLakeGeneration = builder
                .comment("Should generate lava lakes?\nDefault: true")
                .define("biome.feature.lavaLakeGeneration",true);

        waterSpringGeneration = builder
                .comment("Should generate water springs?\nDefault: true")
                .define("biome.feature.waterSpringGeneration",true);

        lavaSpringGeneration = builder
                .comment("Should generate lava springs?\nDefault: true")
                .define("biome.feature.lavaSpringGeneration",true);

        builder.pop();
    }

    private void sound()
    {
        builder.push("sound");

        playAmbientSounds = builder
                .comment("[W.I.P] Play ambient sounds on biomes?")
                .define("play_ambient",true);
        ambientSoundsVolume = builder
                .comment("[W.I.P] Ambient sounds volume")
                .defineInRange("volume_ambient",1,0.1,1);
        builder.pop();
    }


    private void block(){
        builder.push("block");

        steamMaxAge=builder
                .comment("Steam Particle max age multiplier - how long does steam live\nDefault: 10.0")
                .defineInRange("steam_max_age",10.0,1.0,100);

        flowerDisappearsOnWalk = builder
                .comment("Flower disappears on walk?\nDefault: true")
                .define("flowerDisappears",true);

        poisonIvyHurts = builder
                .comment("Poison ivy hurts on walk?\nDefault: true")
                .define("poisonIvyHurts",true);

        poisonIvyPoisons = builder
                .comment("Poison ivy poisons on walk?\nDefault: true")
                .define("poisonIvyPoison",true);

        poisonIvyDamage = builder
                .comment("Poison ivy damage?\nDefault: 0.5")
                .defineInRange("poisonIvyDamage",0.5,0.0,1000.0);

        leafFruitChance = builder
                .comment("Leaf fruit chance\nDefault: 10")
                .defineInRange("leafFruitChance",10,0,1000);

        flowerBloomChance = builder
                .comment("Flower bloom chance (Bone meal)\nDefault: 10")
                .defineInRange("flowerBloomChance",10,0,1000);

        flowerDropChance = builder
                .comment("Flower drop chance\nDefault: 2")
                .defineInRange("flowerDropChance",2,0,1000);

        tinOreHarvestLevel = builder
                .comment("Tin ore harvest level\nDefault: 1")
                .defineInRange("ore.tinOreHarvestLevel",1,0,100);

        copperOreHarvestLevel = builder
                .comment("Copper ore harvest level\nDefault: 1")
                .defineInRange("ore.copperOreHarvestLevel",1,0,100);

        amethystOreHarvestLevel = builder
                .comment("Amethyst ore harvest level\nDefault: 2")
                .defineInRange("ore.amethystOreHarvestLevel",2,0,100);

        sapphireOreHarvestLevel = builder
                .comment("Sapphire ore harvest level\nDefault: 3")
                .defineInRange("ore.sapphireOreHarvestLevel",3,0,100);

        malachiteOreHarvestLevel = builder
                .comment("Malachite ore harvest level\nDefault: 3")
                .defineInRange("ore.malachiteOreHarvestLevel",3,0,100);

        silverOreHarvestLevel = builder
                .comment("Silver ore harvest level\nDefault: 3")
                .defineInRange("ore.silverOreHarvestLevel",3,0,100);

        amberOreHarvestLevel = builder
                .comment("Amber ore harvest level\nDefault: 3")
                .defineInRange("ore.amberOreHarvestLevel",3,0,100);

        rubyOreHarvestLevel = builder
                .comment("Ruby ore harvest level\nDefault: 4")
                .defineInRange("ore.rubyOreHarvestLevel",4,0,100);

        vegeGrassSpawn = builder
                .comment("Can all veggies normally spawn on normal grass?\nDefault: false")
                .define("vegeGrassSpawn",false);


        builder.pop();
    }

    public static void compile(){
        ArrayList<String> strings = new ArrayList<>(Arrays.asList(blacklistBiome.get().replace(" ","").split(",")));
        Main.LOGGER.debug("Initializing biome blacklist module...\nValues: " + strings.toString()+"\nRaw values: " + blacklistBiome.get());
        for (String s : strings) {
            try {
                s = s + "";
                Main.LOGGER.debug("Blacklisting " + s + "...");
                Biome b = Main.getBiomeByID(s);
                if (b != Biomes.DEFAULT) {
                    Main.LOGGER.debug("Blacklisted Biome: " + b.getRegistryName());
                    blacklistedBiomes.add(b);
                } else {
                    Main.LOGGER.debug("Invalid Blacklisted Biome: " + b.getRegistryName());
                }
            }catch (Exception e){
                Main.LOGGER.debug("Invalid Blacklisted Biome: " + s+"");
            }
        }
    }
}