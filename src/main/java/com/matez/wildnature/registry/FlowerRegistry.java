package com.matez.wildnature.registry;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.*;
import com.matez.wildnature.lists.WNBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.Item;

import java.util.ArrayList;

public class FlowerRegistry {

    Block[] flowers;
    private ArrayList<FruitableLeaves.StageFruit> lemonFruits = new ArrayList<>();
    private ArrayList<FruitableLeaves.StageFruit> orangeFruits = new ArrayList<>();
    private ArrayList<FruitableLeaves.StageFruit> grapeFruitFruits = new ArrayList<>();
    private ArrayList<FruitableLeaves.StageFruit> bananaFruits = new ArrayList<>();
    private ArrayList<FruitableLeaves.StageFruit> limeFruits = new ArrayList<>();
    private ArrayList<FruitableLeaves.StageFruit> oliveFruits = new ArrayList<>();
    private ArrayList<FruitableLeaves.StageFruit> peachFruits = new ArrayList<>();
    private ArrayList<FruitableLeaves.StageFruit> pomegranateFruits = new ArrayList<>();
    private ArrayList<FruitableLeaves.StageFruit> mangoFruits = new ArrayList<>();
    public FlowerRegistry(){
        lemonFruits.add(new FruitableLeaves.StageFruit(0, new FruitableLeaves.ItemPortion("",0,0)));
        lemonFruits.add(new FruitableLeaves.StageFruit(1, new FruitableLeaves.ItemPortion("",0,0)));
        lemonFruits.add(new FruitableLeaves.StageFruit(2, new FruitableLeaves.ItemPortion("wildnature:lemon",1,1)));
        lemonFruits.add(new FruitableLeaves.StageFruit(3, new FruitableLeaves.ItemPortion("wildnature:lemon",1,1)));
        lemonFruits.add(new FruitableLeaves.StageFruit(4, new FruitableLeaves.ItemPortion("wildnature:lemon",1,1)));
        lemonFruits.add(new FruitableLeaves.StageFruit(5, new FruitableLeaves.ItemPortion("wildnature:lemon",1,1)));
        lemonFruits.add(new FruitableLeaves.StageFruit(6, new FruitableLeaves.ItemPortion("wildnature:lemon",1,1)));
        lemonFruits.add(new FruitableLeaves.StageFruit(7, new FruitableLeaves.ItemPortion("wildnature:lemon",1,1)));

        orangeFruits.add(new FruitableLeaves.StageFruit(0, new FruitableLeaves.ItemPortion("",0,0)));
        orangeFruits.add(new FruitableLeaves.StageFruit(1, new FruitableLeaves.ItemPortion("",0,0)));
        orangeFruits.add(new FruitableLeaves.StageFruit(2, new FruitableLeaves.ItemPortion("wildnature:orange",1,1)));
        orangeFruits.add(new FruitableLeaves.StageFruit(3, new FruitableLeaves.ItemPortion("wildnature:orange",1,1)));
        orangeFruits.add(new FruitableLeaves.StageFruit(4, new FruitableLeaves.ItemPortion("wildnature:orange",1,1)));
        orangeFruits.add(new FruitableLeaves.StageFruit(5, new FruitableLeaves.ItemPortion("wildnature:orange",1,1)));
        orangeFruits.add(new FruitableLeaves.StageFruit(6, new FruitableLeaves.ItemPortion("wildnature:orange",1,1)));
        orangeFruits.add(new FruitableLeaves.StageFruit(7, new FruitableLeaves.ItemPortion("wildnature:orange",1,1)));

        grapeFruitFruits.add(new FruitableLeaves.StageFruit(0, new FruitableLeaves.ItemPortion("",0,0)));
        grapeFruitFruits.add(new FruitableLeaves.StageFruit(1, new FruitableLeaves.ItemPortion("",0,0)));
        grapeFruitFruits.add(new FruitableLeaves.StageFruit(2, new FruitableLeaves.ItemPortion("wildnature:grapefruit",1,1)));
        grapeFruitFruits.add(new FruitableLeaves.StageFruit(3, new FruitableLeaves.ItemPortion("wildnature:grapefruit",1,1)));
        grapeFruitFruits.add(new FruitableLeaves.StageFruit(4, new FruitableLeaves.ItemPortion("wildnature:grapefruit",1,1)));
        grapeFruitFruits.add(new FruitableLeaves.StageFruit(5, new FruitableLeaves.ItemPortion("wildnature:grapefruit",1,1)));
        grapeFruitFruits.add(new FruitableLeaves.StageFruit(6, new FruitableLeaves.ItemPortion("wildnature:grapefruit",1,1)));
        grapeFruitFruits.add(new FruitableLeaves.StageFruit(7, new FruitableLeaves.ItemPortion("wildnature:grapefruit",1,1)));

        limeFruits.add(new FruitableLeaves.StageFruit(0, new FruitableLeaves.ItemPortion("",0,0)));
        limeFruits.add(new FruitableLeaves.StageFruit(1, new FruitableLeaves.ItemPortion("",0,0)));
        limeFruits.add(new FruitableLeaves.StageFruit(2, new FruitableLeaves.ItemPortion("wildnature:lime",1,1)));
        limeFruits.add(new FruitableLeaves.StageFruit(3, new FruitableLeaves.ItemPortion("wildnature:lime",1,1)));
        limeFruits.add(new FruitableLeaves.StageFruit(4, new FruitableLeaves.ItemPortion("wildnature:lime",1,1)));
        limeFruits.add(new FruitableLeaves.StageFruit(5, new FruitableLeaves.ItemPortion("wildnature:lime",1,1)));
        limeFruits.add(new FruitableLeaves.StageFruit(6, new FruitableLeaves.ItemPortion("wildnature:lime",1,1)));
        limeFruits.add(new FruitableLeaves.StageFruit(7, new FruitableLeaves.ItemPortion("wildnature:lime",1,1)));

        oliveFruits.add(new FruitableLeaves.StageFruit(0, new FruitableLeaves.ItemPortion("",0,0)));
        oliveFruits.add(new FruitableLeaves.StageFruit(1, new FruitableLeaves.ItemPortion("",0,0)));
        oliveFruits.add(new FruitableLeaves.StageFruit(2, new FruitableLeaves.ItemPortion("wildnature:olives",1,1)));
        oliveFruits.add(new FruitableLeaves.StageFruit(3, new FruitableLeaves.ItemPortion("wildnature:olives",1,1)));
        oliveFruits.add(new FruitableLeaves.StageFruit(4, new FruitableLeaves.ItemPortion("wildnature:olives",1,1)));
        oliveFruits.add(new FruitableLeaves.StageFruit(5, new FruitableLeaves.ItemPortion("wildnature:olives",1,1)));
        oliveFruits.add(new FruitableLeaves.StageFruit(6, new FruitableLeaves.ItemPortion("wildnature:olives",1,1)));
        oliveFruits.add(new FruitableLeaves.StageFruit(7, new FruitableLeaves.ItemPortion("wildnature:olives",1,1)));

        peachFruits.add(new FruitableLeaves.StageFruit(0, new FruitableLeaves.ItemPortion("",0,0)));
        peachFruits.add(new FruitableLeaves.StageFruit(1, new FruitableLeaves.ItemPortion("",0,0)));
        peachFruits.add(new FruitableLeaves.StageFruit(2, new FruitableLeaves.ItemPortion("wildnature:peach",1,1)));
        peachFruits.add(new FruitableLeaves.StageFruit(3, new FruitableLeaves.ItemPortion("wildnature:peach",1,1)));
        peachFruits.add(new FruitableLeaves.StageFruit(4, new FruitableLeaves.ItemPortion("wildnature:peach",1,1)));
        peachFruits.add(new FruitableLeaves.StageFruit(5, new FruitableLeaves.ItemPortion("wildnature:peach",1,1)));
        peachFruits.add(new FruitableLeaves.StageFruit(6, new FruitableLeaves.ItemPortion("wildnature:peach",1,1)));
        peachFruits.add(new FruitableLeaves.StageFruit(7, new FruitableLeaves.ItemPortion("wildnature:peach",1,1)));

        pomegranateFruits.add(new FruitableLeaves.StageFruit(0, new FruitableLeaves.ItemPortion("",0,0)));
        pomegranateFruits.add(new FruitableLeaves.StageFruit(1, new FruitableLeaves.ItemPortion("",0,0)));
        pomegranateFruits.add(new FruitableLeaves.StageFruit(2, new FruitableLeaves.ItemPortion("wildnature:pomegranate",1,1)));
        pomegranateFruits.add(new FruitableLeaves.StageFruit(3, new FruitableLeaves.ItemPortion("wildnature:pomegranate",1,1)));
        pomegranateFruits.add(new FruitableLeaves.StageFruit(4, new FruitableLeaves.ItemPortion("wildnature:pomegranate",1,1)));
        pomegranateFruits.add(new FruitableLeaves.StageFruit(5, new FruitableLeaves.ItemPortion("wildnature:pomegranate",1,1)));
        pomegranateFruits.add(new FruitableLeaves.StageFruit(6, new FruitableLeaves.ItemPortion("wildnature:pomegranate",1,1)));
        pomegranateFruits.add(new FruitableLeaves.StageFruit(7, new FruitableLeaves.ItemPortion("wildnature:pomegranate",1,1)));

        mangoFruits.add(new FruitableLeaves.StageFruit(0, new FruitableLeaves.ItemPortion("",0,0)));
        mangoFruits.add(new FruitableLeaves.StageFruit(1, new FruitableLeaves.ItemPortion("",0,0)));
        mangoFruits.add(new FruitableLeaves.StageFruit(2, new FruitableLeaves.ItemPortion("wildnature:mango",1,1)));
        mangoFruits.add(new FruitableLeaves.StageFruit(3, new FruitableLeaves.ItemPortion("wildnature:mango",1,1)));
        mangoFruits.add(new FruitableLeaves.StageFruit(4, new FruitableLeaves.ItemPortion("wildnature:mango",1,1)));
        mangoFruits.add(new FruitableLeaves.StageFruit(5, new FruitableLeaves.ItemPortion("wildnature:mango",1,1)));
        mangoFruits.add(new FruitableLeaves.StageFruit(6, new FruitableLeaves.ItemPortion("wildnature:mango",1,1)));
        mangoFruits.add(new FruitableLeaves.StageFruit(7, new FruitableLeaves.ItemPortion("wildnature:mango",1,1)));


        flowers = new Block[]{
                WNBlocks.CHERRY_FLOWER = new FlatBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("cherry_flower")),
                WNBlocks.JACARANDA_FLOWER = new FlatBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("jacaranda_flower")),
                WNBlocks.PLUM_FLOWER = new FlatBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("plum_flower")),
                WNBlocks.DAISY = new FlatBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("daisy")),
                WNBlocks.HEATHER_PURPLE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("heather_purple")),
                WNBlocks.HEATHER_PINK = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("heather_pink")),
                WNBlocks.HEATHER_WHITE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("heather_white")),
                WNBlocks.HEATHER_YELLOW = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("heather_yellow")),
                WNBlocks.BLUEBELL = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("bluebell")),
                WNBlocks.FORGET_ME_NOT_BLUE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("forget_me_not_blue")),
                WNBlocks.FORGET_ME_NOT_PINK = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("forget_me_not_pink")),
                WNBlocks.FORGET_ME_NOT_WHITE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("forget_me_not_white")),
                WNBlocks.IRIS_PINK = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("iris_pink")),
                WNBlocks.IRIS_PURPLE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("iris_purple")),
                WNBlocks.IRIS_VIOLET = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("iris_violet")),
                WNBlocks.IRIS_WHITE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("iris_white")),
                WNBlocks.LUPINE_BLUE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("lupine_blue")),
                WNBlocks.LUPINE_PINK = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("lupine_pink")),
                WNBlocks.LUPINE_RED = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("lupine_red")),
                WNBlocks.LUPINE_VIOLET = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("lupine_violet")),
                WNBlocks.LUPINE_YELLOW = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("lupine_yellow")),
                WNBlocks.PASQUE_PINK = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("pasque_pink")),
                WNBlocks.PASQUE_PURPLE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("pasque_purple")),
                WNBlocks.PASQUE_WHITE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("pasque_white")),
                WNBlocks.PASQUE_YELLOW = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("pasque_yellow")),
                WNBlocks.AZALEA_ORANGE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("azalea_orange")),
                WNBlocks.AZALEA_PINK = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("azalea_pink")),
                WNBlocks.AZALEA_PURPLE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("azalea_purple")),
                WNBlocks.AZALEA_RED = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("azalea_red")),
                WNBlocks.AZALEA_WHITE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("azalea_white")),
                WNBlocks.AZALEA_YELLOW = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("azalea_yellow")),
                WNBlocks.BUTTERCUP_ORANGE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("buttercup_orange")),
                WNBlocks.BUTTERCUP_YELLOW = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("buttercup_yellow")),
                WNBlocks.CANA_BULB_ORANGE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("cana_bulb_orange")),
                WNBlocks.CANA_BULB_PINK = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("cana_bulb_pink")),
                WNBlocks.CANA_BULB_RED = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("cana_bulb_red")),
                WNBlocks.CANA_BULB_YELLOW = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("cana_bulb_yellow")),
                WNBlocks.PERENNIAL_BLUE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("perennial_blue")),
                WNBlocks.PERENNIAL_PINK = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("perennial_pink")),
                WNBlocks.PERENNIAL_VIOLET = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("perennial_violet")),
                WNBlocks.VIBURNUM_PINK = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("viburnum_pink")),
                WNBlocks.VIBURNUM_WHITE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("viburnum_white")),
                WNBlocks.RADISSIUM_BLUE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("radissium_blue")),
                WNBlocks.RADISSIUM_PINK = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("radissium_pink")),
                WNBlocks.RADISSIUM_RED = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("radissium_red")),
                WNBlocks.LAVENDER = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("lavender")),
                WNBlocks.ANTHURIUM_PINK = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("anthurium_pink")),
                WNBlocks.ANTHURIUM_RED = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("anthurium_red")),
                WNBlocks.ANTHURIUM_WHITE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("anthurium_white")),
                WNBlocks.ORCHIS_PURPLE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("orchis_purple")),
                WNBlocks.ORCHIS_WHITE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("orchis_white")),
                WNBlocks.PEACE_LILY = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("peace_lily")),
                WNBlocks.WILD_ROSE = new WildRosePlant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("wild_rose")),
                WNBlocks.ANEMONE = new AnemonePlant(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("anemone")),
                WNBlocks.CHAMOMILE_WHITE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("chamomile_white")),
                WNBlocks.CHAMOMILE_DOUBLE_WHITE = new DoubleBushBaseFlowering(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("chamomile_double_white")),
                WNBlocks.CHRYSANTHEMUM_PURPLE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("chrysanthemum_purple")),
                WNBlocks.CHRYSANTHEMUM_RED = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("chrysanthemum_red")),
                WNBlocks.CHRYSANTHEMUM_YELLOW = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("chrysanthemum_yellow")),
                WNBlocks.CHRYSANTHEMUM_LIGHT_YELLOW = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("chrysanthemum_light_yellow")),
                WNBlocks.CHRYSANTHEMUM_WHITE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("chrysanthemum_white")),
                WNBlocks.CROCUS_PURPLE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("crocus_purple")),
                WNBlocks.CROCUS_WHITE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("crocus_white")),
                WNBlocks.GERANIUM_RED = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("geranium_red")),
                WNBlocks.GERANIUM_PINK = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("geranium_pink")),
                WNBlocks.GERANIUM_WHITE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("geranium_white")),
                WNBlocks.HYACINTH_DARK_BLUE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("hyacinth_dark_blue")),
                WNBlocks.HYACINTH_PURPLE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("hyacinth_purple")),
                WNBlocks.HYACINTH_RED = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("hyacinth_red")),
                WNBlocks.HYACINTH_PINK = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("hyacinth_pink")),
                WNBlocks.HYACINTH_LIGHT_BLUE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("hyacinth_light_blue")),
                WNBlocks.HYACINTH_WHITE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("hyacinth_white")),
                WNBlocks.MARIGOLD_RED = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("marigold_red")),
                WNBlocks.MARIGOLD_ORANGE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("marigold_orange")),
                WNBlocks.MARIGOLD_YELLOW = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("marigold_yellow")),
                WNBlocks.MARIGOLD_WHITE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("marigold_white")),
                WNBlocks.CATNIP = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("catnip_purple")),
                WNBlocks.DAFFODIL = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("daffodil_yellow")),
                WNBlocks.HEPATICA_VIOLET = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("hepatica_violet")),
                WNBlocks.HEPATICA_PURPLE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("hepatica_purple")),
                WNBlocks.HEPATICA_PINK = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("hepatica_pink")),
                WNBlocks.HEPATICA_BLUE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("hepatica_blue")),
                WNBlocks.HEPATICA_WHITE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("hepatica_white")),
                WNBlocks.PRIMROSE_BLUE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("primrose_blue")),
                WNBlocks.PRIMROSE_PINK = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("primrose_pink")),
                WNBlocks.PRIMROSE_WHITE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("primrose_white")),
                WNBlocks.VIOLET_PURPLE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("violet_purple")),
                WNBlocks.HOLLYHOCK_PINK = new DoubleBushBaseFlowering(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("hollyhock_pink")),
                WNBlocks.HOLLYHOCK_RED = new DoubleBushBaseFlowering(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("hollyhock_red")),
                WNBlocks.GLADIOLUS_PURPLE = new DoubleBushBaseFlowering(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("gladiolus_purple")),
                WNBlocks.GLADIOLUS_RED = new DoubleBushBaseFlowering(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("gladiolus_red")),
                WNBlocks.GLADIOLUS_ORANGE = new DoubleBushBaseFlowering(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("gladiolus_orange")),
                WNBlocks.GLADIOLUS_YELLOW = new DoubleBushBaseFlowering(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("gladiolus_yellow")),
                WNBlocks.COLUMBINE_BLUE = new DoubleBushBaseFlowering(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("columbine_blue")),
                WNBlocks.COLUMBINE_PURPLE = new DoubleBushBaseFlowering(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("columbine_purple")),
                WNBlocks.COLUMBINE_RED = new DoubleBushBaseFlowering(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("columbine_red")),
                WNBlocks.CARNATION_RED = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("carnation_red")),
                WNBlocks.CARNATION_PINK = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("carnation_pink")),
                WNBlocks.CARNATION_WHITE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("carnation_white")),
                WNBlocks.YUCCA = new YuccaBlock(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("yucca")),
                WNBlocks.CHINESE_LANTERN_FLOWER = new BelladonnaBlock(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("chinese_lantern_flower")),
                WNBlocks.SCOTCHBROOM_YELLOW = new DoubleBushBaseFlowering(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("scotchbroom_yellow")),
                WNBlocks.SCOTCHBROOM_PURPLE = new DoubleBushBaseFlowering(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("scotchbroom_purple")),
                WNBlocks.CLEMATIS_BLUE = new DoubleBushBaseFlowering(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("clematis_blue")),
                WNBlocks.CLEMATIS_PURPLE = new DoubleBushBaseFlowering(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("clematis_purple")),
                WNBlocks.GOLDENROD = new DoubleBushBaseFlowering(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("goldenrod")),
                WNBlocks.HONEYSUCKLE_YELLOW = new DoubleBushBaseFlowering(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("giant_hogweed")),
                WNBlocks.GIANT_HOGWEED = new DoubleBushBaseFlowering(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("honeysuckle_yellow")),
                WNBlocks.HYDRANGEA_BLUE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("hydrangea_blue")),
                WNBlocks.HYDRANGEA_PURPLE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("hydrangea_purple")),
                WNBlocks.HYDRANGEA_PINK = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("hydrangea_pink")),
                WNBlocks.HYDRANGEA_WHITE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("hydrangea_white")),
                WNBlocks.MATTHIOLA_PINK = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("matthiola_pink")),
                WNBlocks.HEATH_PURPLE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("heath_purple")),
                WNBlocks.HEATH_PINK = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("heath_pink")),
                WNBlocks.HEATH_WHITE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("heath_white")),
                WNBlocks.MISCANTHUS_GRASS = new DoubleBushBaseFlowering(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("miscanthus_grass")),
                WNBlocks.FIRE_WEED = new FireWeedBush(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("fire_weed")),
                WNBlocks.MONKSHOOD_BLUE = new MonkshoodBlueBlock(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("monkshood_blue")),
                WNBlocks.SNOWDROP = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("snowdrop")),



                WNBlocks.RHODODENDRON_PINK = new BigBushFloweringBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("rhododendron_pink")),
                WNBlocks.RHODODENDRON_PURPLE = new BigBushFloweringBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("rhododendron_purple")),
                WNBlocks.TAMARISK = new BigBushFloweringBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("tamarisk")),

                WNBlocks.WISTERIA_PINK = new WisteriaBlock(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("wisteria_pink")),


                WNBlocks.BOXWOOD = new BushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("boxwood")),
                WNBlocks.SHRUB = new BushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("shrub")),
                WNBlocks.SHRUB_TALL = new BushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("shrub_tall")),
                WNBlocks.THUJA = new BushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("thuja")),
                WNBlocks.THUJA_LARGE = new DoubleBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("thuja_large")),
                WNBlocks.THUJA_LIMEGREEN = new BushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("thuja_limegreen")),
                WNBlocks.THUJA_LIMEGREEN_LARGE = new DoubleBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("thuja_limegreen_large")),



                WNBlocks.GRASS_FERNSPROUT = new BushBase(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("grass_fernsprout")),
                WNBlocks.GRASS_FLOWER = new FloweringBushBase(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("grass_flower")),
                WNBlocks.GRASS_THISTLE = new ThistleBlock(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("grass_thistle")),
                WNBlocks.GRASS_WHEAT = new FloweringBushBase(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("grass_wheat")),
                WNBlocks.WILD_WHEAT = new FloweringBushBase(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("wild_wheat")),
                WNBlocks.PRAIRIE_GRASS = new FloweringBushBase(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("prairie_grass")),
                WNBlocks.MEDIUM_GRASS = new BushBase(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("medium_grass")),
                WNBlocks.SMALL_GRASS = new BushBase(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("small_grass")),
                WNBlocks.DESERT_GRASS = new DesertBush(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("desert_grass")),
                WNBlocks.DEAD_SHORT_GRASS = new DesertBush(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("dead_short_grass")),
                WNBlocks.LEAF_PILE = new FlatBushBase(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("leaf_pile")),
                WNBlocks.DEAD_LEAF_PILE = new FlatBushBase(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("dead_leaf_pile")),
                WNBlocks.CLOVER = new FlatBushBase(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("clover")),
                WNBlocks.POISON_IVY = new PoisonIvyBlock(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("poison_ivy")),
                WNBlocks.NETTLE = new NettleBlock(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("nettle")),
                WNBlocks.LAMPGRASS = new FloweringBushBase(Block.Properties.create(Material.TALL_PLANTS).lightValue(4),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("lampgrass")),
                WNBlocks.SPIDERGRASS = new SpidergrassBlock(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("spidergrass")),
                WNBlocks.MOSS = new MossBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().sound(SoundType.CROP),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("moss")),
                WNBlocks.LICHEN = new LichenBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().sound(SoundType.SWEET_BERRY_BUSH),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("lichen")),

                WNBlocks.YEW_BUSH = new BushBase(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("yew_bush")),
                WNBlocks.CATTAIL = new CattailBlock(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("cattail")),
                WNBlocks.BIRD_OF_PARADISE = new DoubleBushBaseFlowering(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("bird_of_paradise")),
                WNBlocks.RAPESEED = new DoubleBushBaseFlowering(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("rapeseed")),
                WNBlocks.COFFEE_SAPLING = new CoffeeSapling(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("coffee_sapling")),
                WNBlocks.COFFEE_BUSH = new CoffeeBush(Block.Properties.create(Material.TALL_PLANTS), Main.RegistryEvents.location("coffee_bush")),
                WNBlocks.CORN_BUSH = new CornPlant(Block.Properties.create(Material.TALL_PLANTS), Main.RegistryEvents.location("corn_bush")),
                WNBlocks.RIVER_CANE = new RiverCaneBush(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("river_cane")),
                WNBlocks.SMALL_CACTI = new DesertBush(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("small_cacti")),
                WNBlocks.FESTUCA_ELIJAHBLUE = new BushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("festuca_elijahblue")),
                WNBlocks.FESTUCA = new DoubleBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("festuca")),
                WNBlocks.TANSY = new BushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("tansy")),
                WNBlocks.SEA_KALE = new DesertBush(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("sea_kale")),
                WNBlocks.CORDYLINE_AUSTRALIS = new DesertBush(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("cordyline_australis")),
                WNBlocks.SEABEACH_SANDWORT = new DesertBush(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("seabeach_sandwort")),
                WNBlocks.RED_SAND_VERBENA = new FloweringDesertBush(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("red_sand_verbena")),
                WNBlocks.REEDS = new ReedsBlock(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("reeds")),
                WNBlocks.HOTTENTOT = new FloweringDesertBush(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("hottentot")),
                WNBlocks.PRICKLY_PEAR_CACTUS = new PricklyPearBlock(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("prickly_pear_cactus")),
                WNBlocks.SUCCULENTS = new BushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("succulents")),



                //UNDERWATER & WATER
                WNBlocks.GREEN_WATERLILY = new WaterLilyBase(Block.Properties.create(Material.PLANTS), Main.RegistryEvents.location("green_waterlily")),
                WNBlocks.RED_WATERLILY = new WaterLilyBase(Block.Properties.create(Material.PLANTS), Main.RegistryEvents.location("red_waterlily")),
                WNBlocks.DUCKWEED = new WaterLilyBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement(), Main.RegistryEvents.location("duckweed")),
                WNBlocks.WATER_POPPY = new FloweringWaterLily(Block.Properties.create(Material.PLANTS).doesNotBlockMovement(), Main.RegistryEvents.location("water_poppy")),
                WNBlocks.WATER_LILY_WHITE = new FloweringWaterLily(Block.Properties.create(Material.PLANTS).doesNotBlockMovement(), Main.RegistryEvents.location("water_lily_white")),
                WNBlocks.WATER_LILY_YELLOW = new FloweringWaterLily(Block.Properties.create(Material.PLANTS).doesNotBlockMovement(), Main.RegistryEvents.location("water_lily_yellow")),
                WNBlocks.LOTUS_PINK = new FloweringWaterLily(Block.Properties.create(Material.PLANTS).doesNotBlockMovement(), Main.RegistryEvents.location("lotus_pink")),
                WNBlocks.LOTUS_LIGHT_PINK = new FloweringWaterLily(Block.Properties.create(Material.PLANTS).doesNotBlockMovement(), Main.RegistryEvents.location("lotus_light_pink")),
                WNBlocks.LOTUS_WHITE = new FloweringWaterLily(Block.Properties.create(Material.PLANTS).doesNotBlockMovement(), Main.RegistryEvents.location("lotus_white")),
                WNBlocks.WATER_HYACINTH = new FloweringWaterLily(Block.Properties.create(Material.PLANTS).doesNotBlockMovement(), Main.RegistryEvents.location("water_hyacinth")),
                WNBlocks.POND_WEED = new WaterLilyBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement(), Main.RegistryEvents.location("pond_weed")),
                WNBlocks.PARROTS_FEATHER_PLANT = new WaterLilyBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement(), Main.RegistryEvents.location("parrots_feather_plant")),
                WNBlocks.WATER_WEED = new UnderwaterBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("water_weed")),
                WNBlocks.ALGAE = new UnderwaterBushBase(Block.Properties.create(Material.OCEAN_PLANT),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("algae")),
                WNBlocks.RED_ALGAE = new UnderwaterBushBase(Block.Properties.create(Material.OCEAN_PLANT),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("red_algae")),
                WNBlocks.OAR_WEED = new UnderwaterBushBase(Block.Properties.create(Material.OCEAN_PLANT),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("oar_weed")),
                WNBlocks.RED_SEA_WHIP = new UnderwaterBushBase(Block.Properties.create(Material.OCEAN_PLANT),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("red_sea_whip")),
                WNBlocks.SEA_ANEMONE = new UnderwaterBushBase(Block.Properties.create(Material.OCEAN_PLANT),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("sea_anemone")),
                WNBlocks.SHRIMP_TUBE_WEED = new UnderwaterBushBase(Block.Properties.create(Material.OCEAN_PLANT),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("shrimp_tube_weed")),
                WNBlocks.SHRIMP_TUBE = new UnderwaterBushBase(Block.Properties.create(Material.OCEAN_PLANT),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("shrimp_tube")),
                WNBlocks.SHALLOW_WATER_GRASS = new UnderwaterBushBase(Block.Properties.create(Material.OCEAN_PLANT),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("shallow_water_grass")),
                WNBlocks.ROCK_WEED = new UnderwaterBushBase(Block.Properties.create(Material.OCEAN_PLANT),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("rock_weed")),
                WNBlocks.LILY_TONGUE = new UnderwaterBushBase(Block.Properties.create(Material.OCEAN_PLANT),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("lily_tongue")),
                WNBlocks.GLOWING_SEA_BANANA = new UnderwaterBushBase(Block.Properties.create(Material.OCEAN_PLANT).lightValue(9),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("glowing_sea_banana")),
                WNBlocks.GLOW_RIBBON = new UnderwaterDoubleBushBase(Block.Properties.create(Material.OCEAN_PLANT),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("glow_ribbon")),
                WNBlocks.DEEP_SEA_VINE = new UnderwaterVineBase(Block.Properties.create(Material.OCEAN_PLANT),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("deep_sea_vine")),
                WNBlocks.DEEP_SEA_NIGHT_SHADE = new UnderwaterBushBase(Block.Properties.create(Material.OCEAN_PLANT),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("deep_sea_night_shade")),
                WNBlocks.BULB_VINE = new UnderwaterDoubleBushBase(Block.Properties.create(Material.OCEAN_PLANT),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("bulb_vine")),

                //CORALS
                WNBlocks.BAMBOO_CORAL = new UnderwaterBushBase(Block.Properties.create(Material.OCEAN_PLANT),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("bamboo_coral")),
                WNBlocks.CRAB_CORAL = new UnderwaterBushBase(Block.Properties.create(Material.OCEAN_PLANT),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("crab_coral")),




                WNBlocks.BUSH_RASPBERRY = new BushBerryBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("bush_raspberry"),new FruitableLeaves.StageFruit(1,new FruitableLeaves.ItemPortion("wildnature:raspberry",1,3))),
                WNBlocks.BUSH_BLUEBERRY = new BushBerryBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("bush_blueberry"),new FruitableLeaves.StageFruit(1,new FruitableLeaves.ItemPortion("wildnature:blueberry",1,3))),
                WNBlocks.BUSH_LINGONBERRY = new BushBerryBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("bush_lingonberry"),new FruitableLeaves.StageFruit(1,new FruitableLeaves.ItemPortion("wildnature:lingonberry",1,3))),
                WNBlocks.BUSH_GOOSEBERRY = new BushBerryBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("bush_gooseberry"),new FruitableLeaves.StageFruit(1,new FruitableLeaves.ItemPortion("wildnature:gooseberry",1,3))),
                WNBlocks.BUSH_CHOKEBERRY = new BushBerryBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("bush_chokeberry"),new FruitableLeaves.StageFruit(1,new FruitableLeaves.ItemPortion("wildnature:chokeberry",1,3))),
                WNBlocks.BUSH_BILBERRY = new BushBerryBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("bush_bilberry"),new FruitableLeaves.StageFruit(1,new FruitableLeaves.ItemPortion("wildnature:bilberries",1,3))),
                WNBlocks.BUSH_HAWTHORN = new BushBerryBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("bush_hawthorn"),new FruitableLeaves.StageFruit(1,new FruitableLeaves.ItemPortion("wildnature:hawthorn_berry",1,3))),
                WNBlocks.BUSH_KAMCHATKA = new BushBerryBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("bush_kamchatka"),new FruitableLeaves.StageFruit(1,new FruitableLeaves.ItemPortion("wildnature:kamchatka_berry",1,3))),
                WNBlocks.BUSH_BLACK_CURRANT = new CurrantPlant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("bush_black_currant")),
                WNBlocks.BUSH_RED_CURRANT = new CurrantPlant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("bush_red_currant")),
                WNBlocks.BUSH_WHITE_CURRANT = new CurrantPlant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("bush_white_currant")),
                WNBlocks.BUSH_WILD_STRAWBERRY = new WildStrawberryPlant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("bush_wild_strawberry")),
                WNBlocks.BUSH_QUINCE = new QuincePlant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("bush_quince")),
                WNBlocks.BUSH_BLACK_LILAC = new BlackLilacPlant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("bush_black_lilac")),
                WNBlocks.BUSH_BLACKBERRY = new BlackberryPlant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("bush_blackberry")),
                WNBlocks.BUSH_CRANBERRY = new CranberryPlant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("bush_cranberry")),
                WNBlocks.BUSH_WILD_BLUEBERRY = new WildBlueberryPlant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("bush_wild_blueberry")),

                WNBlocks.BELLADONNA = new BelladonnaBlock(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("belladonna")),

                //VINES
                WNBlocks.GRAPE_VINE_PURPLE = new GrapeVine(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.PLANT),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("grape_vine_purple"), GrapeVine.VineType.PURPLE),
                WNBlocks.GRAPE_VINE_YELLOW = new GrapeVine(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.PLANT),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("grape_vine_yellow"), GrapeVine.VineType.YELLOW),
                WNBlocks.ROSEVINE_RED = new RoseVine(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.PLANT),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("rosevine_red")),
                WNBlocks.ROSEVINE_PINK = new RoseVine(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.PLANT),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("rosevine_pink")),
                WNBlocks.ROSEVINE_YELLOW = new RoseVine(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.PLANT),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("rosevine_yellow")),
                WNBlocks.ROSEVINE_WHITE = new RoseVine(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.PLANT),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("rosevine_white")),



                //CITRUS
                WNBlocks.BANANA_LEAVES = new BananaLeavesBlock(Block.Properties.create(Material.LEAVES),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("banana_leaves")),
                WNBlocks.GRAPE_FRUIT_LEAVES = new CitrusLeavesBlock(Block.Properties.create(Material.LEAVES),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("grape_fruit_leaves"),grapeFruitFruits),
                WNBlocks.LEMON_LEAVES = new CitrusLeavesBlock(Block.Properties.create(Material.LEAVES),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("lemon_leaves"),lemonFruits),
                WNBlocks.LIME_LEAVES = new CitrusLeavesBlock(Block.Properties.create(Material.LEAVES),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("lime_leaves"),limeFruits),
                WNBlocks.OLIVE_LEAVES = new CitrusLeavesBlock(Block.Properties.create(Material.LEAVES),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("olive_leaves"),oliveFruits),
                WNBlocks.ORANGE_LEAVES = new CitrusLeavesBlock(Block.Properties.create(Material.LEAVES),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("orange_leaves"),orangeFruits),
                WNBlocks.PEACH_LEAVES = new CitrusLeavesBlock(Block.Properties.create(Material.LEAVES),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("peach_leaves"),peachFruits),
                WNBlocks.POMEGRANATE_LEAVES = new CitrusLeavesBlock(Block.Properties.create(Material.LEAVES),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("pomegranate_leaves"),pomegranateFruits),
                WNBlocks.MANGO_LEAVES = new CitrusLeavesBlock(Block.Properties.create(Material.LEAVES),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("mango_leaves"),mangoFruits),

                WNBlocks.BANANA_FRUIT = new BananaFruitBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.4F,0.1F).sound(SoundType.STEM)).setRegistryName(Main.RegistryEvents.location("banana_fruit")),



                //PLANTS
                WNBlocks.TOMATO_PLANT = new TomatoPlant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("tomato_plant")),
                WNBlocks.LETTUCE_PLANT = new LettucePlant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("lettuce_plant")),
                WNBlocks.ONION_PLANT = new OnionPlant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("onion_plant")),
                WNBlocks.RED_ONION_PLANT = new OnionPlant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("red_onion_plant")),
                WNBlocks.GREEN_BEANS_BUSH = new GreenBeansBush(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("green_bean_bush")),
                WNBlocks.BASIL_PLANT = new Age3Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("basil_plant"),"wildnature:basil"),
                WNBlocks.CAULIFLOWER_PLANT = new Age4Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("cauliflower_plant"),"wildnature:cauliflower"),
                WNBlocks.CELERY_PLANT = new Age4Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("celery_plant"),"wildnature:celery"),
                WNBlocks.GARLIC_PLANT = new Age4Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("garlic_plant"),"wildnature:garlic"),
                WNBlocks.GINGER_PLANT = new Age4Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("ginger_plant"),"wildnature:ginger"),
                WNBlocks.GREEN_PEPPER_PLANT = new Age6Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("green_pepper_plant"),"wildnature:green_pepper"),
                WNBlocks.LEEK_PLANT = new Age4Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("leek_plant"),"wildnature:leek"),
                WNBlocks.PARSLEY_PLANT = new Age3Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("parsley_plant"),"wildnature:dried_parsley"),
                WNBlocks.RED_PEPPER_PLANT = new Age6Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("red_pepper_plant"),"wildnature:red_pepper"),
                WNBlocks.RHUBARB_PLANT = new Age4Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("rhubarb_plant"),"wildnature:rhubarb"),
                WNBlocks.RICE_PLANT = new Age5Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("rice_plant"),"wildnature:rice",false),
                WNBlocks.SAGE_PLANT = new Age3Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("sage_plant"),"wildnature:dried_sage"),
                WNBlocks.TURMERIC_PLANT = new Age3Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("turmeric_plant"),"wildnature:turmeric"),
                WNBlocks.TURNIP_PLANT = new Age4Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("turnip_plant"),"wildnature:turnip"),
                WNBlocks.BROCCOLI_PLANT = new Age4Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("broccoli_plant"),"wildnature:broccoli"),
                WNBlocks.CABBAGE_PLANT = new Age4Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("cabbage_plant"),"wildnature:cabbage"),
                WNBlocks.CHIVES_PLANT = new Age4Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("chives_plant"),"wildnature:chives"),
                WNBlocks.CUCUMBER_PLANT = new Age4Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("cucumber_plant"),"wildnature:cucumber"),
                WNBlocks.EGGPLANT_PLANT = new EggPlant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("eggplant_plant")),
                WNBlocks.CURRY_PLANT = new Age3Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("curry_plant"),"wildnature:curry_leaf"),
                WNBlocks.MARJORAM_PLANT = new Age3Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("marjoram_plant"),"wildnature:fresh_marjoram"),
                WNBlocks.ROSEMARY_PLANT = new Age3Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("rosemary_plant"),"wildnature:fresh_rosemary"),
                WNBlocks.PEA_PLANT = new Age4Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("pea_plant"),"wildnature:peas"),
                WNBlocks.PEANUT_PLANT = new Age3Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("peanut_plant"),"wildnature:peanut"),
                WNBlocks.HORSE_RADISH_PLANT = new BushBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP),null, "wildnature:horse_radish", 1,2,0,Main.RegistryEvents.location("horse_radish_plant")),
                WNBlocks.BLACK_PEPPER_PLANT = new Age4Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("black_pepper_plant"),"wildnature:pepper"),


                WNBlocks.COTTON_PLANT = new Age2Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("cotton_plant"),"wildnature:cotton",false),
                WNBlocks.PINEAPPLE_PLANT = new Age2Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("pineapple_plant"),"wildnature:pineapple",false),


                WNBlocks.BLACK_TEA_PLANT = new Age2Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("black_tea_plant"),"wildnature:black_tea_leaves",false),
                WNBlocks.GREEN_TEA_PLANT = new Age2Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("green_tea_plant"),"wildnature:green_tea_leaves",false),
                WNBlocks.MELISSA_PLANT = new Age2Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("melissa_tea_plant"),"wildnature:melissa_tea_leaf",false),
                WNBlocks.MINT_PLANT = new BushBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP),null, "wildnature:mint", 1,2,0,Main.RegistryEvents.location("mint_plant")),
                WNBlocks.WHITE_TEA = new Age2Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("white_tea_plant"),"wildnature:white_tea_leaves",false),




                WNBlocks.MUSHROOM1_PORCINO = new MushroomBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("mushroom1")),
                WNBlocks.MUSHROOM2_SLIPPERY_JACK = new MushroomBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("mushroom2")),
                WNBlocks.MUSHROOM3_CHAMPIGNON = new MushroomBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("mushroom3")),
                WNBlocks.MUSHROOM4_DEATH_CAP = new MushroomBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("mushroom4")),
                WNBlocks.MUSHROOM5_TOADSTOOL = new MushroomBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("mushroom5")),
                WNBlocks.MUSHROOM6_SAFFRON_MILK_CAP = new MushroomBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("mushroom6")),
                WNBlocks.MUSHROOM7_BIRCH_BOLETE = new MushroomBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("mushroom7")),
                WNBlocks.MUSHROOM8_BOLETUS = new MushroomBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("mushroom8")),
                WNBlocks.MUSHROOM9_CHANTARELLE = new MushroomBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("mushroom9")),
                WNBlocks.PSILOCYBIN_MUSHROOM = new MushroomBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("psilocybin_mushroom")),
                WNBlocks.FUZZBALL = new FuzzballShroom(Block.Properties.create(Material.PLANTS).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("fuzzball")),





                //UNDERGROUNDS
                WNBlocks.GLOW_SHROOM = new CaveShroomBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().lightValue(6),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("glowshroom"),false),
                WNBlocks.ICE_SHROOM = new CaveShroomBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().lightValue(6),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("ice_shroom"),false),
                WNBlocks.GLOWING_SLIMESHROOM_GREEN = new CaveShroomBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().lightValue(9),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("glowing_slimeshroom_green"),false),
                WNBlocks.GLOWING_SLIMESHROOM_BLUE = new CaveShroomBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().lightValue(9),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("glowing_slimeshroom_blue"),false),
                WNBlocks.HANGING_GLOWING_SLIMESHROOM_GREEN = new CaveShroomBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().lightValue(9),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("hanging_glowing_slimeshroom_green"),true),
                WNBlocks.HANGING_GLOWING_SLIMESHROOM_BLUE = new CaveShroomBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().lightValue(9),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("hanging_glowing_slimeshroom_blue"),true),
                WNBlocks.JELLYSHROOM = new JellyShroomBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().lightValue(7),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("jellyshroom"),false),
                WNBlocks.SULFUR_SHROOM = new CaveShroomBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("sulfur_shroom"),false),
                WNBlocks.POISON_SHROOM = new CaveShroomBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("poison_shroom"),false),
                WNBlocks.MAGMA_SHROOM = new CaveShroomBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().lightValue(6),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("magma_shroom"),false),
                WNBlocks.DRAGON_SHROOM = new CaveShroomBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().lightValue(3),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("dragon_shroom"),false),
                WNBlocks.GLOWING_SHADOWSHROOM = new ShadowShroomBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().lightValue(5),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("glowing_shadowshroom"),false),
                WNBlocks.GRAVITYSHROOM = new GravityShroom(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().lightValue(1),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("gravityshroom")),
                WNBlocks.TUBESHROOM = new Tubeshroom(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().lightValue(7),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("tubeshroom"),false),
                WNBlocks.SUNSHROOM = new Sunshroom(Block.Properties.create(Material.PLANTS).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("sunshroom"),false),
                WNBlocks.MAGMA_PAD = new MagmaPadBlock(Block.Properties.create(Material.PLANTS), Main.RegistryEvents.location("magma_pad")),

                WNBlocks.CAVE_LILY_FLOWER = new CaveFloweringBushBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().lightValue(3),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("cave_lily"),false),


                WNBlocks.STONE_GRASS = new CaveBush(Block.Properties.create(Material.ROCK),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("stone_grass"),false),
                WNBlocks.ICE_GRASS = new CaveBush(Block.Properties.create(Material.ICE),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("ice_grass"),false),

                WNBlocks.ICYCLE = new CaveBush(Block.Properties.create(Material.ICE),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("icycle"),true),
                WNBlocks.ROOTS = new CaveBush(Block.Properties.create(Material.WOOD),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("roots"),true),
                WNBlocks.STALACTITE = new CaveBush(Block.Properties.create(Material.ROCK),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("stalactite"),true),
                WNBlocks.STALAGMITE = new CaveBush(Block.Properties.create(Material.ROCK),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("stalagmite"),false),

                WNBlocks.LARGE_GLOWSHROOM = new DoubleCaveBushBase(Block.Properties.create(Material.PLANTS).lightValue(10),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("large_glowshroom"),false),
                WNBlocks.LARGE_ICYCLE = new DoubleCaveBushBase(Block.Properties.create(Material.ICE),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("large_icycle"),true),
                WNBlocks.LARGE_ROOT = new DoubleCaveBushBase(Block.Properties.create(Material.WOOD),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("large_root"),true),
                WNBlocks.LARGE_STALACTITE = new DoubleCaveBushBase(Block.Properties.create(Material.ROCK),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("large_stalactite"),true),
                WNBlocks.LARGE_STALAGMITE = new DoubleCaveBushBase(Block.Properties.create(Material.ROCK),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("large_stalagmite"),false),

                WNBlocks.GLOW_VINE = new VineBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().lightValue(6).sound(SoundType.PLANT),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("glow_vine")),

                WNBlocks.CAVE_STAR = new CaveStarBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.GLASS).hardnessAndResistance(2f,1f).harvestLevel(3),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("cave_star")),

                WNBlocks.GLOWSHROOM_BLOCK = new HugeMushroomBase(Block.Properties.create(Material.WOOD, MaterialColor.WOOL).sound(SoundType.WOOD).hardnessAndResistance(0.2F),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("glowshroom_block")),
                WNBlocks.GLOWSHROOM_STEM = new HugeMushroomBase(Block.Properties.create(Material.WOOD, MaterialColor.WOOL).sound(SoundType.WOOD).hardnessAndResistance(0.2F),new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP), Main.RegistryEvents.location("glowshroom_stem")),



        };
    }

    public Block[] getFlowers() {
        return flowers;
    }
}
