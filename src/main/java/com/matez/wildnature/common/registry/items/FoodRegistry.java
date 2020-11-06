package com.matez.wildnature.common.registry.items;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.client.tabs.WNTabs;
import com.matez.wildnature.common.items.*;
import com.matez.wildnature.common.items.recipes.cooking.FillTool;
import com.matez.wildnature.util.lists.WNItems;
import net.minecraft.item.*;

import static com.matez.wildnature.init.WN.RegistryEvents.location;

public class FoodRegistry {

    public Item[] items;
    private Food smallFruit = (new Food.Builder()).hunger(2).saturation(0.6F).fastToEat().build();

    private Food CHERRY = (new Food.Builder()).hunger(2).saturation(0.6F).build();
    private Food PLUM = (new Food.Builder()).hunger(2).saturation(0.6F).build();
    private Food CORN = (new Food.Builder()).hunger(2).saturation(0.3F).build();
    private Food TOMATO = (new Food.Builder()).hunger(2).saturation(0.5F).build();
    private Food TOMATO_SOUP = (new Food.Builder()).hunger(16).saturation(1F).build();
    private Food CANDY_CANE = (new Food.Builder()).hunger(3).saturation(0.3F).build();
    private Food CANDY = (new Food.Builder()).hunger(3).saturation(0.3F).build();
    private Food DONUTS = (new Food.Builder()).hunger(2).saturation(0.3F).build();
    private Food CHOCOLATE = (new Food.Builder()).hunger(5).saturation(0.3F).build();
    private Food CARAMEL = (new Food.Builder()).hunger(1).saturation(0.2F).build();
    private Food DRINK = (new Food.Builder()).hunger(0).saturation(0.7F).build();

    public FoodRegistry(){
        items = new Item[]{
                //FRUITS
                WNItems.GREEN_APPLE = new Item(new Item.Properties().group(WNTabs.FOOD).food(Foods.APPLE)).setRegistryName(location("green_apple")),
                WNItems.PARADISE_APPLE = new Item(new Item.Properties().group(WNTabs.FOOD).food(Foods.APPLE)).setRegistryName(location("paradise_apple")),
                WNItems.CHERRY = new Item(new Item.Properties().group(WNTabs.FOOD).food(CHERRY)).setRegistryName(location("cherry")),
                WNItems.PEAR = new Item(new Item.Properties().group(WNTabs.FOOD).food(Foods.APPLE)).setRegistryName(location("pear")),
                WNItems.RASPBERRY = new Item(new Item.Properties().group(WNTabs.FOOD).food(smallFruit)).setRegistryName(location("raspberry")),
                WNItems.BLUEBERRY = new Item(new Item.Properties().group(WNTabs.FOOD).food(smallFruit)).setRegistryName(location("blueberry")),
                WNItems.LINGONBERRY = new Item(new Item.Properties().group(WNTabs.FOOD).food(smallFruit)).setRegistryName(location("lingonberry")),
                WNItems.BLACKBERRY = new Item(new Item.Properties().group(WNTabs.FOOD).food(smallFruit)).setRegistryName(location("blackberry")),
                WNItems.GOOSEBERRY = new Item(new Item.Properties().group(WNTabs.FOOD).food(smallFruit)).setRegistryName(location("gooseberry")),
                WNItems.CHOKE_BERRY = new Item(new Item.Properties().group(WNTabs.FOOD).food(smallFruit)).setRegistryName(location("chokeberry")),
                WNItems.BLACK_CURRANT = new Item(new Item.Properties().group(WNTabs.FOOD).food(smallFruit)).setRegistryName(location("black_currant")),
                WNItems.RED_CURRANT = new Item(new Item.Properties().group(WNTabs.FOOD).food(smallFruit)).setRegistryName(location("red_currant")),
                WNItems.WHITE_CURRANT = new Item(new Item.Properties().group(WNTabs.FOOD).food(smallFruit)).setRegistryName(location("white_currant")),
                WNItems.HAWTHORN_BERRY = new Item(new Item.Properties().group(WNTabs.FOOD).food(smallFruit)).setRegistryName(location("hawthorn_berry")),
                WNItems.KAMCHATKA_BERRY = new Item(new Item.Properties().group(WNTabs.FOOD).food(smallFruit)).setRegistryName(location("kamchatka_berry")),
                WNItems.WILD_STRAWBERRY = new Item(new Item.Properties().group(WNTabs.FOOD).food(smallFruit)).setRegistryName(location("wild_strawberry")),
                WNItems.QUINCE_FRUIT = new Item(new Item.Properties().group(WNTabs.FOOD).food(smallFruit)).setRegistryName(location("quince_fruit")),
                WNItems.BILBERRIES = new Item(new Item.Properties().group(WNTabs.FOOD).food(smallFruit)).setRegistryName(location("bilberries")),
                WNItems.BLACK_LILAC_BERRIES = new Item(new Item.Properties().group(WNTabs.FOOD).food(smallFruit)).setRegistryName(location("black_lilac_berries")),
                WNItems.CRANBERRIES = new Item(new Item.Properties().group(WNTabs.FOOD).food(smallFruit)).setRegistryName(location("cranberries")),


                WNItems.PLUM = new Item(new Item.Properties().group(WNTabs.FOOD).food(PLUM)).setRegistryName(location("plum")),
                WNItems.MIRABELLE_PLUM = new Item(new Item.Properties().group(WNTabs.FOOD).food(PLUM)).setRegistryName(location("mirabelle_plum")),
                WNItems.ACORN = new Item(new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("acorn")),

                WNItems.GRAPES_PURPLE = new Item(new Item.Properties().group(WNTabs.FOOD).food(Foods.APPLE)).setRegistryName(location("grapes_purple")),
                WNItems.GRAPES_YELLOW = new Item(new Item.Properties().group(WNTabs.FOOD).food(Foods.APPLE)).setRegistryName(location("grapes_yellow")),

                WNItems.WILD_ROSE_FRUIT = new Item(new Item.Properties().group(WNTabs.FOOD).food(Foods.APPLE)).setRegistryName(location("wild_rose_fruit")),

                WNItems.BELLADONNA_FRUIT = new BelladonnaItem(new Item.Properties().group(WNTabs.FOOD).food(Foods.APPLE)).setRegistryName(location("belladonna_fruit")),


                //CITRUS
                WNItems.LEMON = new Item(new Item.Properties().group(WNTabs.FOOD).food(PLUM)).setRegistryName(location("lemon")),
                WNItems.ORANGE = new Item(new Item.Properties().group(WNTabs.FOOD).food(PLUM)).setRegistryName(location("orange")),
                WNItems.GRAPEFRUIT = new Item(new Item.Properties().group(WNTabs.FOOD).food(PLUM)).setRegistryName(location("grapefruit")),
                WNItems.BANANA = new Item(new Item.Properties().group(WNTabs.FOOD).food(PLUM)).setRegistryName(location("banana")),
                WNItems.LIME = new Item(new Item.Properties().group(WNTabs.FOOD).food(PLUM)).setRegistryName(location("lime")),
                WNItems.OLIVES = new Item(new Item.Properties().group(WNTabs.FOOD).food(PLUM)).setRegistryName(location("olives")),
                WNItems.PEACH = new Item(new Item.Properties().group(WNTabs.FOOD).food(PLUM)).setRegistryName(location("peach")),
                WNItems.PINEAPPLE = new BlockNamedItem(WN.getBlockByID("wildnature:pineapple_plant"),new Item.Properties().group(WNTabs.FOOD).food(PLUM)).setRegistryName(location("pineapple")),
                WNItems.POMEGRANATE = new Item(new Item.Properties().group(WNTabs.FOOD).food(PLUM)).setRegistryName(location("pomegranate")),
                WNItems.MANGO = new Item(new Item.Properties().group(WNTabs.FOOD).food(PLUM)).setRegistryName(location("mango")),

                WNItems.LEMON_WEDGE = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food(TOMATO)).setRegistryName(location("lemon_wedge")),



                //PLANTS
                WNItems.BROCCOLI = new BlockNamedItem(WN.getBlockByID("wildnature:broccoli_plant"),new Item.Properties().group(WNTabs.FOOD).food(TOMATO)).setRegistryName(location("broccoli")),
                WNItems.CABBAGE = new BlockNamedItem(WN.getBlockByID("wildnature:cabbage_plant"),new Item.Properties().group(WNTabs.FOOD).food(TOMATO)).setRegistryName(location("cabbage")),
                WNItems.CAULIFLOWER = new BlockNamedItem(WN.getBlockByID("wildnature:cauliflower_plant"),new Item.Properties().group(WNTabs.FOOD).food(TOMATO)).setRegistryName(location("cauliflower")),
                WNItems.CELERY = new BlockNamedItem(WN.getBlockByID("wildnature:celery_plant"),new Item.Properties().group(WNTabs.FOOD).food(TOMATO)).setRegistryName(location("celery")),
                WNItems.CHIVES = new BlockNamedItem(WN.getBlockByID("wildnature:chives_plant"),new Item.Properties().group(WNTabs.FOOD).food(TOMATO)).setRegistryName(location("chives")),
                WNItems.CORN = new BlockNamedItem(WN.getBlockByID("wildnature:corn_bush"),new Item.Properties().group(WNTabs.FOOD).food(CORN)).setRegistryName(location("corn")),
                WNItems.CUCUMBER = new BlockNamedItem(WN.getBlockByID("wildnature:cucumber_plant"),new Item.Properties().group(WNTabs.FOOD).food(TOMATO)).setRegistryName(location("cucumber")),
                WNItems.EGGPLANT = new BlockNamedItem(WN.getBlockByID("wildnature:eggplant_plant"),new Item.Properties().group(WNTabs.FOOD).food(TOMATO)).setRegistryName(location("eggplant")),
                WNItems.GARLIC = new BlockNamedItem(WN.getBlockByID("wildnature:garlic_plant"),new Item.Properties().group(WNTabs.FOOD).food(TOMATO)).setRegistryName(location("garlic")),
                WNItems.GINGER = new BlockNamedItem(WN.getBlockByID("wildnature:ginger_plant"),new Item.Properties().group(WNTabs.FOOD).food(TOMATO)).setRegistryName(location("ginger")),
                WNItems.GREEN_BEANS = new BlockNamedItem(WN.getBlockByID("wildnature:green_bean_bush"),new Item.Properties().group(WNTabs.FOOD).food(TOMATO)).setRegistryName(location("green_beans")),
                WNItems.GREEN_PEPPER = new BlockNamedItem(WN.getBlockByID("wildnature:green_pepper_plant"),new Item.Properties().group(WNTabs.FOOD).food(TOMATO)).setRegistryName(location("green_pepper")),
                WNItems.HORSE_RADISH = new BlockNamedItem(WN.getBlockByID("wildnature:horse_radish_plant"),new Item.Properties().group(WNTabs.FOOD).food(TOMATO)).setRegistryName(location("horse_radish")),
                WNItems.LEEK = new BlockNamedItem(WN.getBlockByID("wildnature:leek_plant"),new Item.Properties().group(WNTabs.FOOD).food(TOMATO)).setRegistryName(location("leek")),
                WNItems.LETTUCE = new BlockNamedItem(WN.getBlockByID("wildnature:lettuce_plant"),new Item.Properties().group(WNTabs.FOOD).food(TOMATO)).setRegistryName(location("lettuce")),
                WNItems.ONION = new BlockNamedItem(WN.getBlockByID("wildnature:onion_plant"),new Item.Properties().group(WNTabs.FOOD).food(TOMATO)).setRegistryName(location("onion")),
                WNItems.PEANUT = new BlockNamedItem(WN.getBlockByID("wildnature:peanut_plant"),new Item.Properties().group(WNTabs.FOOD).food(TOMATO)).setRegistryName(location("peanut")),
                WNItems.PEAS = new BlockNamedItem(WN.getBlockByID("wildnature:pea_plant"),new Item.Properties().group(WNTabs.FOOD).food(TOMATO)).setRegistryName(location("peas")),
                WNItems.RED_ONION = new BlockNamedItem(WN.getBlockByID("wildnature:red_onion_plant"),new Item.Properties().group(WNTabs.FOOD).food(TOMATO)).setRegistryName(location("red_onion")),
                WNItems.RED_PEPPER = new BlockNamedItem(WN.getBlockByID("wildnature:red_pepper_plant"),new Item.Properties().group(WNTabs.FOOD).food(TOMATO)).setRegistryName(location("red_pepper")),
                WNItems.RHUBARB = new BlockNamedItem(WN.getBlockByID("wildnature:rhubarb_plant"),new Item.Properties().group(WNTabs.FOOD).food(TOMATO)).setRegistryName(location("rhubarb")),
                WNItems.RICE = new BlockNamedItem(WN.getBlockByID("wildnature:rice_plant"),new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("rice")),
                WNItems.TOMATO = new Item(new Item.Properties().group(WNTabs.FOOD).food(TOMATO)).setRegistryName(location("tomato")),
                WNItems.TOMATO_SEEDS = new BlockNamedItem(WN.getBlockByID("wildnature:tomato_plant"),new Item.Properties().group(WNTabs.SURFACE_PLANTS)).setRegistryName(location("tomato_seeds")),
                WNItems.TURNIP = new BlockNamedItem(WN.getBlockByID("wildnature:turnip_plant"),new Item.Properties().group(WNTabs.FOOD).food(TOMATO)).setRegistryName(location("turnip")),



                WNItems.COTTON = new BlockNamedItem(WN.getBlockByID("wildnature:cotton_plant"),new Item.Properties().group(WNTabs.SURFACE_PLANTS)).setRegistryName(location("cotton")),
                

                WNItems.BASIL = new BlockNamedItem(WN.getBlockByID("wildnature:basil_plant"),new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("basil")),
                WNItems.CHOPPED_CHIVES = new FoodItem(new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("chopped_chives")),
                WNItems.CURRY_LEAVES = new BlockNamedItem(WN.getBlockByID("wildnature:curry_plant"),new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("curry_leaves")),
                WNItems.DRIED_MARJORAM = new Item(new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("dried_marjoram")),
                WNItems.DRIED_PARSLEY = new Item(new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("dried_parsley")),
                WNItems.DRIED_SAGE = new Item(new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("dried_sage")),
                WNItems.FRESH_MARJORAM = new BlockNamedItem(WN.getBlockByID("wildnature:marjoram_plant"),new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("fresh_marjoram")),
                WNItems.FRESH_ROSEMARY = new BlockNamedItem(WN.getBlockByID("wildnature:rosemary_plant"),new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("fresh_rosemary")),
                WNItems.GARLIC_CLOVES = new FoodItem(new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("garlic_cloves")),
                WNItems.TURMERIC = new BlockNamedItem(WN.getBlockByID("wildnature:tumeric_plant"),new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("turmeric")),

                WNItems.SALT = new Item(new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("salt")),
                WNItems.PEPPER = new BlockNamedItem(WN.getBlockByID("wildnature:black_pepper_plant"),new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("pepper")),

                WNItems.BUTTER = new FoodItem(new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("butter")),
                WNItems.DOUGH_BALL = new FoodItem(new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("dough_ball")),


                //TEA LEAF
                WNItems.BLACK_TEA_LEAVES = new BlockNamedItem(WN.getBlockByID("wildnature:black_tea_plant"),new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("black_tea_leaves")),
                WNItems.GREEN_TEA_LEAVES = new BlockNamedItem(WN.getBlockByID("wildnature:green_tea_plant"),new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("green_tea_leaves")),
                WNItems.MELISSA_TEA_LEAF = new BlockNamedItem(WN.getBlockByID("wildnature:melissa_tea_plant"),new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("melissa_tea_leaf")),
                WNItems.MINT = new BlockNamedItem(WN.getBlockByID("wildnature:mint_plant"),new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("mint")),
                WNItems.WHITE_TEA_LEAVES = new BlockNamedItem(WN.getBlockByID("wildnature:white_tea_plant"),new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("white_tea_leaves")),

                WNItems.MUSHROOM_MIX = new FoodItem(new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("mushroom_mix")),
                WNItems.DRIED_MUSHROOM_MIX = new FoodItem(new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("dried_mushroom_mix")),


                WNItems.COFFEE_LEAVES = new Item(new Item.Properties().group(WNTabs.SURFACE_PLANTS)).setRegistryName(location("coffee_leaves")),
                WNItems.COFFEE_BRANCH = new Item(new Item.Properties().group(WNTabs.SURFACE_PLANTS)).setRegistryName(location("coffee_branch")),
                WNItems.COFFEE_BERRY_GREEN = new Item(new Item.Properties().group(WNTabs.SURFACE_PLANTS)).setRegistryName(location("coffee_berry_green")),
                WNItems.COFFEE_BERRY = new Item(new Item.Properties().group(WNTabs.SURFACE_PLANTS)).setRegistryName(location("coffee_berry")),
                WNItems.COFFEE_BEAN = new Item(new Item.Properties().group(WNTabs.SURFACE_PLANTS)).setRegistryName(location("coffee_bean")),
                WNItems.COFFEE_POWDER = new Item(new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("coffee_powder")),

                WNItems.CUP_OF_COFFEE = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).maxStackSize(1),("wildnature:cup")).setRegistryName(location("cup_of_coffee")),
                WNItems.JUG_WATER = new WaterJugItem(new Item.Properties().group(WNTabs.FOOD).maxStackSize(1)).setRegistryName(location("jug_water")),
                WNItems.CACAO = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).maxStackSize(1),("wildnature:glass"),true).setRegistryName(location("cacao")),
                WNItems.JAR_WATER = new DrinkItem(new Item.Properties().group(WNTabs.FOOD),("wildnature:jar"),true).setRegistryName(location("jar_water")),
                WNItems.CARAMEL_JAR = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).maxStackSize(1),("wildnature:jar"),true).setRegistryName(location("caramel_jar")),


                //SOUPS
                WNItems.CABBAGE_LETTUCE_SALAD = new DeepBowlSoupItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(10).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("cabbage_lettuce_salad")),
                WNItems.CEASAR_SALAD = new DeepBowlSoupItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(14).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("ceasar_salad")),
                WNItems.GARDEN_SALAD = new DeepBowlSoupItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(14).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("garden_salad")),
                WNItems.ONION_SALAD = new DeepBowlSoupItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(14).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("onion_salad")),
                WNItems.RICE_VEGGIE_CURRY_BOWL = new DeepBowlSoupItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(22).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("rice_veggie_curry_bowl")),
                WNItems.VEGETABLE_SALAD = new DeepBowlSoupItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(22).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("vegetable_salad")),

                WNItems.BIGOS = new MapleSoupItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(12).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("bigos")),
                WNItems.BEEF_STEW = new MapleSoupItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(18).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("beef_stew")),
                WNItems.BORSCHT = new MapleSoupItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(18).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("borscht")),
                WNItems.CABBAGE_SOUP = new MapleSoupItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(16).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("cabbage_soup")),
                WNItems.CHICKEN_SOUP = new MapleSoupItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(18).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("chicken_soup")),
                WNItems.CREAM_OF_BROCCOLI_SOUP = new MapleSoupItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(12).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("cream_of_broccoli_soup")),
                WNItems.CREAM_OF_MUSHROOM_SOUP = new MapleSoupItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(14).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("cream_of_mushroom_soup")),
                WNItems.CUCUMBER_SOUP = new MapleSoupItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(15).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("cucumber_soup")),
                WNItems.CURRY_SOUP = new MapleSoupItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(11).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("curry_soup")),
                WNItems.GARLIC_MUSHROOM_GRAVY = new MapleSoupItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(13).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("garlic_mushroom_gravy")),
                WNItems.ONION_SOUP = new MapleSoupItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(15).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("onion_soup")),
                WNItems.PEA_SOUP = new MapleSoupItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(15).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("pea_soup")),
                WNItems.RED_WINE_REDUCTION_SAUCE = new MapleSoupItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(16).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("red_wine_reduction_sauce")),
                WNItems.SAUERKRAUT_SOUP = new MapleSoupItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(14).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("sauerkraut_soup")),
                WNItems.TOMATO_SOUP = new MapleSoupItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(15).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("tomato_soup")),


                //MEALS
                WNItems.ASIAGO_CHEESE = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(4).saturation(0.9F).build())).setRegistryName(location("asiago_cheese")),
                WNItems.CHEDDAR_CHEESE = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(3).saturation(0.9F).build())).setRegistryName(location("cheddar_cheese")),
                WNItems.SWISS_CHEESE = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(5).saturation(0.9F).build())).setRegistryName(location("swiss_cheese")),

                WNItems.BAGEL_POPPY_SEED = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(6).saturation(0.2F).build())).setRegistryName(location("bagel_poppy_seed")),
                WNItems.BANANA_BREAD = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(6).saturation(0.2F).build())).setRegistryName(location("banana_bread")),
                WNItems.SLICED_BREAD = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(1).saturation(0.2F).build())).setRegistryName(location("sliced_bread")),
                WNItems.GARLIC_BREAD = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(2).saturation(0.2F).build())).setRegistryName(location("garlic_bread")),
                WNItems.TOAST = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(2).saturation(0.2F).build())).setRegistryName(location("toast")),
                WNItems.FRENCH_TOAST = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(5).saturation(0.4F).build())).setRegistryName(location("french_toast")),

                WNItems.RAW_BACON = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(4).saturation(0.5F).build())).setRegistryName(location("raw_bacon")),
                WNItems.COOKED_BACON = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(5).saturation(0.5F).build())).setRegistryName(location("cooked_bacon")),
                WNItems.BACON_BITS = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(2).saturation(0.5F).build())).setRegistryName(location("bacon_bits")),

                WNItems.FRIED_EGG = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(4).saturation(0.6F).build())).setRegistryName(location("fried_egg")),

                WNItems.GRAHAM_CRACKER = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(2).saturation(0.2F).build())).setRegistryName(location("graham_cracker")),
                WNItems.GRILLED_CAULIFLOWER = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(5).saturation(0.3F).build())).setRegistryName(location("grilled_cauliflower")),
                WNItems.SAUERKRAUT = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(5).saturation(1F).build()), FillTool.PLATE).setRegistryName(location("sauerkraut")),
                WNItems.SMORE = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(7).saturation(0.2F).build())).setRegistryName(location("smore")),
                WNItems.SUSHI = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(6).saturation(1F).build())).setRegistryName(location("sushi")),

                WNItems.CHEESE_PIZZA = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(22).saturation(0.5F).build())).setRegistryName(location("cheese_pizza")),
                WNItems.HAWAIIAN_PIZZA = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(22).saturation(0.7F).build())).setRegistryName(location("hawaiian_pizza")),
                WNItems.PEPPERONI_PIZZA = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(22).saturation(0.5F).build())).setRegistryName(location("pepperoni_pizza")),
                WNItems.CEBULARZ = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(10).saturation(0.7F).build())).setRegistryName(location("cebularz")),

                WNItems.TORTILLA = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(4).saturation(0.5F).build())).setRegistryName(location("tortilla")),
                WNItems.BEEF_AND_PEPPER_BURRITO = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(18).saturation(0.5F).build())).setRegistryName(location("beef_and_pepper_burrito")),
                WNItems.CHICKEN_AND_CORN_BURRITO = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(18).saturation(0.5F).build())).setRegistryName(location("chicken_and_corn_burrito")),
                WNItems.PORK_AND_GREEN_BEAN_BURRITO = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(18).saturation(0.5F).build())).setRegistryName(location("pork_and_green_bean_burrito")),
                WNItems.VEGETABLE_AND_CHEESE_BURRITO = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(18).saturation(0.5F).build())).setRegistryName(location("vegetable_and_cheese_burrito")),

                WNItems.BEEF_SANDWICH = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(14).saturation(0.6F).build())).setRegistryName(location("beef_sandwich")),
                WNItems.BEEF_SANDWICH_WITH_CHEDDAR = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(18).saturation(0.8F).build())).setRegistryName(location("beef_sandwich_with_cheddar")),
                WNItems.CHICKEN_SANDWICH = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(14).saturation(0.6F).build())).setRegistryName(location("chicken_sandwich")),
                WNItems.PORK_SANDWICH = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(14).saturation(0.6F).build())).setRegistryName(location("pork_sandwich")),


                WNItems.BREAKFAST_MEAL = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(12).saturation(0.6F).build()).maxStackSize(1),FillTool.PLATE).setRegistryName(location("breakfast_meal")),
                WNItems.BROCCOLI_AND_CHEESE = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(10).saturation(0.8F).build()).maxStackSize(1),FillTool.PLATE).setRegistryName(location("broccoli_and_cheese")),
                WNItems.MUTTON_DINNER_WITH_REDWINE_SAUCE = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(16).saturation(0.7F).build()).maxStackSize(1),FillTool.PLATE).setRegistryName(location("mutton_dinner_with_redwine_sauce")),
                WNItems.OMELET_BREAKFAST = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(11).saturation(0.5F).build()).maxStackSize(1),FillTool.PLATE).setRegistryName(location("omelet_breakfast")),
                WNItems.PANCAKES = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(12).saturation(0.4F).build()).maxStackSize(1),FillTool.PLATE).setRegistryName(location("pancakes")),
                WNItems.PIEROGIES = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(14).saturation(0.5F).build()).maxStackSize(1),FillTool.PLATE).setRegistryName(location("pierogies")),
                WNItems.ROAST_CHICKEN_DINNER = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(14).saturation(0.5F).build()).maxStackSize(1),FillTool.PLATE).setRegistryName(location("roast_chicken_dinner")),
                WNItems.ROASTED_VEGGIES = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(8).saturation(0.6F).build()).maxStackSize(1),FillTool.PLATE).setRegistryName(location("roasted_veggies")),
                WNItems.SAUTEED_VEGGIES_WITH_GRAVY = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(12).saturation(0.8F).build()).maxStackSize(1),FillTool.PLATE).setRegistryName(location("sauteed_veggies_with_gravy")),
                WNItems.STEAK_DINNER_WITH_GRAVY = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(15).saturation(0.8F).build()).maxStackSize(1),FillTool.PLATE).setRegistryName(location("steak_dinner_with_gravy")),
                WNItems.STEAK_DINNER_WITH_REDWINE_SAUCE = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(19).saturation(0.9F).build()).maxStackSize(1),FillTool.PLATE).setRegistryName(location("steak_dinner_with_redwine_sauce")),




                //OTHER
                WNItems.LEMON_MERINGUE_PIE = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(10).saturation(0.4F).build())).setRegistryName(location("lemon_meringue_pie")),
                WNItems.STRAWBERRY_RHUBARB_PIE = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food((new Food.Builder()).hunger(10).saturation(0.4F).build())).setRegistryName(location("strawberry_rhubarb_pie")),
                WNItems.BREAD_ROLL = new FoodItem(new Item.Properties().group(WNTabs.FOOD).food(Foods.BREAD)).setRegistryName(location("bread_roll")),

                WNItems.CANDY_1 = new Item(new Item.Properties().group(WNTabs.FOOD).food(CANDY)).setRegistryName(location("candy_1")),
                WNItems.CANDY_2 = new Item(new Item.Properties().group(WNTabs.FOOD).food(CANDY)).setRegistryName(location("candy_2")),
                WNItems.CANDY_3 = new Item(new Item.Properties().group(WNTabs.FOOD).food(CANDY)).setRegistryName(location("candy_3")),
                WNItems.CANDY_CANE_1 = new Item(new Item.Properties().group(WNTabs.FOOD).food(CANDY_CANE)).setRegistryName(location("candy_cane_1")),
                WNItems.CANDY_CANE_2 = new Item(new Item.Properties().group(WNTabs.FOOD).food(CANDY_CANE)).setRegistryName(location("candy_cane_2")),
                WNItems.CARAMEL_CANDY = new Item(new Item.Properties().group(WNTabs.FOOD).food(Foods.BREAD)).setRegistryName(location("caramel_candy")),
                WNItems.CREAM_CARAMEL = new Item(new Item.Properties().group(WNTabs.FOOD).food(Foods.BREAD)).setRegistryName(location("cream_caramel")),
                //ItemsList.DONUT = new Item(new Item.Properties().group(WNTabs.FOOD).food(DONUTS)).setRegistryName(location("donut")),
                //ItemsList.DONUT_2 = new Item(new Item.Properties().group(WNTabs.FOOD).food(DONUTS)).setRegistryName(location("donut_2")),
                WNItems.EMPTY_BAG = new Item(new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("empty_bag")),

                //ItemsList.GINGERBREAD_1 = new Item(new Item.Properties().group(WNTabs.FOOD).food(Foods.BREAD)).setRegistryName(location("gingerbread_1")),
                //ItemsList.GINGERBREAD_2 = new Item(new Item.Properties().group(WNTabs.FOOD).food(Foods.BREAD)).setRegistryName(location("gingerbread_2")),
                WNItems.MARSHMALLOW = new Item(new Item.Properties().group(WNTabs.FOOD).food(Foods.BREAD)).setRegistryName(location("marshmallow")),
                WNItems.CHOCOLATE_DARK = new Item(new Item.Properties().group(WNTabs.FOOD).food(CHOCOLATE)).setRegistryName(location("chocolate_dark")),
                WNItems.CHOCOLATE_MILK = new Item(new Item.Properties().group(WNTabs.FOOD).food(CHOCOLATE)).setRegistryName(location("chocolate_milk")),
                WNItems.CHOCOLATE_WHITE = new Item(new Item.Properties().group(WNTabs.FOOD).food(CHOCOLATE)).setRegistryName(location("chocolate_white")),
                WNItems.CHOCOLATE_CARAMEL = new Item(new Item.Properties().group(WNTabs.FOOD).food(CHOCOLATE)).setRegistryName(location("chocolate_caramel")),

                WNItems.CARAMEL = new Item(new Item.Properties().group(WNTabs.FOOD).food(CANDY)).setRegistryName(location("caramel")),

                WNItems.FLOUR = new Item(new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("flour")),
                WNItems.POPPY_SEED = new Item(new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("poppy_seed")),
                WNItems.RICE_BAG = new Item(new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("rice_bag")),
                WNItems.YEAST = new Item(new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("yeast")),


                //DRINKS
                WNItems.BEER = new AlcoItem(new Item.Properties().group(WNTabs.FOOD).maxStackSize(1),("wildnature:wooden_mug")).setRegistryName(location("beer")),
                WNItems.RED_WINE = new AlcoItem(new Item.Properties().group(WNTabs.FOOD).maxStackSize(1),("wildnature:wine_bottle")).setRegistryName(location("red_wine")),
                WNItems.WHITE_WINE = new AlcoItem(new Item.Properties().group(WNTabs.FOOD).maxStackSize(1),("wildnature:wine_bottle")).setRegistryName(location("white_wine")),

                WNItems.COMPOT_APPLE_PEAR = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).food(DRINK).maxStackSize(1),("wildnature:jug")).setRegistryName(location("compot_apple_pear")),
                WNItems.COMPOT_APPLE_RASPBERRY_CURRANT = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).food(DRINK).maxStackSize(1),("wildnature:jug")).setRegistryName(location("compot_apple_raspberry_currant")),
                WNItems.COMPOT_BLACK_CURRANT = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).food(DRINK).maxStackSize(1),("wildnature:jug")).setRegistryName(location("compot_black_currant")),
                WNItems.COMPOT_BLACKBERRY_GOOSEBERRY = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).food(DRINK).maxStackSize(1),("wildnature:jug")).setRegistryName(location("compot_blackberry_gooseberry")),
                WNItems.COMPOT_CHERRY_BLUEBERRY_RASPBERRY = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).food(DRINK).maxStackSize(1),("wildnature:jug")).setRegistryName(location("compot_cherry_blueberry_raspberry")),
                WNItems.COMPOT_CHOKEBERRY_BLACKBERRY_LINGONBERRY = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).food(DRINK).maxStackSize(1),("wildnature:jug")).setRegistryName(location("compot_chokeberry_blackberry_lingonberry")),
                WNItems.COMPOT_CRANBERRY = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).food(DRINK).maxStackSize(1),("wildnature:jug")).setRegistryName(location("compot_cranberry")),
                WNItems.COMPOT_PLUM_APPLE = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).food(DRINK).maxStackSize(1),("wildnature:jug")).setRegistryName(location("compot_plum_apple")),
                WNItems.COMPOT_WHITE_CURRANT = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).food(DRINK).maxStackSize(1),("wildnature:jug")).setRegistryName(location("compot_white_currant")),

                WNItems.JUICE_APPLE = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).food(DRINK).maxStackSize(1),("wildnature:glass_cup")).setRegistryName(location("juice_apple")),
                WNItems.JUICE_GRAPE = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).food(DRINK).maxStackSize(1),("wildnature:glass_cup")).setRegistryName(location("juice_grape")),
                WNItems.JUICE_GRAPEFRUIT = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).food(DRINK).maxStackSize(1),("wildnature:glass_cup")).setRegistryName(location("juice_grapefruit")),
                WNItems.JUICE_LEMON = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).food(DRINK).maxStackSize(1),("wildnature:glass_cup")).setRegistryName(location("juice_lemon")),
                WNItems.JUICE_MANGO_PINEAPPLE = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).food(DRINK).maxStackSize(1),("wildnature:glass_cup")).setRegistryName(location("juice_mango_pineapple")),
                WNItems.JUICE_ORANGE = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).food(DRINK).maxStackSize(1),("wildnature:glass_cup")).setRegistryName(location("juice_orange")),
                WNItems.JUICE_PEACH = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).food(DRINK).maxStackSize(1),("wildnature:glass_cup")).setRegistryName(location("juice_peach")),
                WNItems.JUICE_PINEAPPLE = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).food(DRINK).maxStackSize(1),("wildnature:glass_cup")).setRegistryName(location("juice_pineapple")),
                WNItems.LEMONADE = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).food(DRINK).maxStackSize(1),("wildnature:glass_cup")).setRegistryName(location("lemonade")),

                WNItems.TEA_BLACK = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).food(DRINK).maxStackSize(1),("wildnature:glass")).setRegistryName(location("tea_black")),
                WNItems.TEA_BLACK_LEMON = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).food(DRINK).maxStackSize(1),("wildnature:glass")).setRegistryName(location("tea_black_lemon")),
                WNItems.TEA_GREEN = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).food(DRINK).maxStackSize(1),("wildnature:glass")).setRegistryName(location("tea_green")),
                WNItems.TEA_GREEN_CHERRY = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).food(DRINK).maxStackSize(1),("wildnature:glass")).setRegistryName(location("tea_green_cherry")),
                WNItems.TEA_GREEN_QUINCE = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).food(DRINK).maxStackSize(1),("wildnature:glass")).setRegistryName(location("tea_green_quince")),
                WNItems.TEA_MELISSA_PEACH = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).food(DRINK).maxStackSize(1),("wildnature:glass")).setRegistryName(location("tea_melissa_peach")),
                WNItems.TEA_MINT = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).food(DRINK).maxStackSize(1),("wildnature:glass")).setRegistryName(location("tea_mint")),
                WNItems.TEA_MINT_LEMON = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).food(DRINK).maxStackSize(1),("wildnature:glass")).setRegistryName(location("tea_mint_lemon")),
                WNItems.TEA_WHITE = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).food(DRINK).maxStackSize(1),("wildnature:glass")).setRegistryName(location("tea_white")),
                WNItems.TEA_WHITE_ORANGE = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).food(DRINK).maxStackSize(1),("wildnature:glass")).setRegistryName(location("tea_white_orange")),


                WNItems.JAM_BLACKBERRY = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).maxStackSize(1),("wildnature:jar")).setRegistryName(location("jam_blackberry")),
                WNItems.JAM_BLUEBERRY = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).maxStackSize(1),("wildnature:jar")).setRegistryName(location("jam_blueberry")),
                WNItems.JAM_CHOKE_BERRY = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).maxStackSize(1),("wildnature:jar")).setRegistryName(location("jam_choke_berry")),
                WNItems.JAM_GOOSEBERRY = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).maxStackSize(1),("wildnature:jar")).setRegistryName(location("jam_gooseberry")),
                WNItems.JAM_HAWTHORN_BERRY = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).maxStackSize(1),("wildnature:jar")).setRegistryName(location("jam_hawthorn_berry")),
                WNItems.JAM_KAMCHATKA_BERRY = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).maxStackSize(1),("wildnature:jar")).setRegistryName(location("jam_kamchatka_berry")),
                WNItems.JAM_ORANGE = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).maxStackSize(1),("wildnature:jar")).setRegistryName(location("jam_orange")),
                WNItems.JAM_PEACH = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).maxStackSize(1),("wildnature:jar")).setRegistryName(location("jam_peach")),
                WNItems.JAM_QUINCE = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).maxStackSize(1),("wildnature:jar")).setRegistryName(location("jam_quince")),
                WNItems.JAM_RASPBERRY = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).maxStackSize(1),("wildnature:jar")).setRegistryName(location("jam_raspberry")),
                WNItems.JAM_WILD_STRAWBERRY = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).maxStackSize(1),("wildnature:jar")).setRegistryName(location("jam_wild_strawberry")),



                WNItems.MAPLE_SYRUP = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).maxStackSize(1),("wildnature:jug"),true).setRegistryName(location("maple_syrup")),
                WNItems.PEANUT_BUTTER = new DrinkItem(new Item.Properties().group(WNTabs.FOOD).maxStackSize(1),("wildnature:jar")).setRegistryName(location("peanut_butter"))

        };
    }

    public Item[] getItems() {
        return items;
    }
}
