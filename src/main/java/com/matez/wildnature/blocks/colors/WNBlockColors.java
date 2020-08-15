package com.matez.wildnature.blocks.colors;

import com.matez.wildnature.lists.WNBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.world.FoliageColors;
import net.minecraft.world.GrassColors;
import net.minecraft.world.biome.BiomeColors;

public class WNBlockColors {

    public BlockColors colors = Minecraft.getInstance().getBlockColors();
    public WNBlockColors(){
        //foliage: 7842607 default: 4764952
        //grass: 9551193 default: -7423631

        colors.register((p1, p2, p3, p4) -> {
            return p2 != null && p3 != null ? BiomeColors.getFoliageColor(p2, p3) : FoliageColors.getDefault();
        }, WNBlocks.BEECH_LEAVES, WNBlocks.ASPEN_LEAVES, WNBlocks.BAOBAB_LEAVES, WNBlocks.CEDAR_LEAVES, WNBlocks.HAZEL_LEAVES,WNBlocks.HORNBEAM_LEAVES, WNBlocks.MAHOGANY_LEAVES, WNBlocks.MANGROVE_LEAVES, WNBlocks.MAPLE_LEAVES, WNBlocks.POPLAR_LEAVES, WNBlocks.WILLOW_LEAVES, WNBlocks.MAGNOLIA_LEAVES, WNBlocks.DENSE_BUSH_LEAVES, WNBlocks.SMALL_BUSH_LEAVES, WNBlocks.LARGE_BUSH_LEAVES);

        colors.register((p1, p2, p3, p4) -> {
            return p2 != null && p3 != null ? BiomeColors.getFoliageColor(p2, p3) : FoliageColors.getDefault();
        }, WNBlocks.BEECH_SAPLING, WNBlocks.ASPEN_SAPLING, WNBlocks.BAOBAB_SAPLING, WNBlocks.CEDAR_SAPLING, WNBlocks.HORNBEAM_SAPLING, WNBlocks.MAHOGANY_SAPLING, WNBlocks.MANGROVE_SAPLING, WNBlocks.MAPLE_SAPLING, WNBlocks.POPLAR_SAPLING, WNBlocks.WILLOW_SAPLING, WNBlocks.HAZEL_SAPLING);
        
        colors.register((p_210225_0_, p_210225_1_, p_210225_2_, p_210225_3_) -> {
            return p_210225_1_ != null && p_210225_2_ != null ? BiomeColors.getGrassColor(p_210225_1_, p_210225_2_) : GrassColors.get(0.5D, 1.0D);
        }, WNBlocks.BROWN_GRASS_BLOCK, WNBlocks.MOLD_GRASS_BLOCK, WNBlocks.DESERT_GRASS_BLOCK, WNBlocks.DRIED_GRASS_BLOCK, WNBlocks.TROPICAL_GRASS_BLOCK, WNBlocks.OVERGROWN_STONE);

        colors.register((p_210225_0_, p_210225_1_, p_210225_2_, p_210225_3_) -> {
            return p_210225_1_ != null && p_210225_2_ != null ? BiomeColors.getGrassColor(p_210225_1_, p_210225_2_) : GrassColors.get(0.5D, 1.0D);
        }, WNBlocks.HEATHER_PINK, WNBlocks.HEATHER_PURPLE, WNBlocks.HEATHER_WHITE, WNBlocks.HEATHER_YELLOW
                , WNBlocks.BLUEBELL, WNBlocks.FORGET_ME_NOT_BLUE, WNBlocks.FORGET_ME_NOT_PINK, WNBlocks.FORGET_ME_NOT_WHITE
                , WNBlocks.IRIS_PINK, WNBlocks.IRIS_PURPLE, WNBlocks.IRIS_VIOLET, WNBlocks.IRIS_WHITE
                , WNBlocks.LUPINE_BLUE, WNBlocks.LUPINE_PINK, WNBlocks.LUPINE_RED, WNBlocks.LUPINE_VIOLET, WNBlocks.LUPINE_YELLOW
                , WNBlocks.PASQUE_PINK, WNBlocks.PASQUE_PURPLE, WNBlocks.PASQUE_WHITE, WNBlocks.PASQUE_YELLOW
                , WNBlocks.GRASS_FERNSPROUT, WNBlocks.GRASS_FLOWER, WNBlocks.GRASS_WHEAT, WNBlocks.GRASS_THISTLE
                , WNBlocks.WILD_WHEAT, WNBlocks.SMALL_GRASS, WNBlocks.MEDIUM_GRASS
                , WNBlocks.AZALEA_ORANGE, WNBlocks.AZALEA_PINK, WNBlocks.AZALEA_PURPLE, WNBlocks.AZALEA_RED, WNBlocks.AZALEA_WHITE, WNBlocks.AZALEA_YELLOW
                , WNBlocks.BUTTERCUP_ORANGE, WNBlocks.BUTTERCUP_YELLOW, WNBlocks.CANA_BULB_ORANGE, WNBlocks.CANA_BULB_PINK
                , WNBlocks.CANA_BULB_RED, WNBlocks.CANA_BULB_YELLOW, WNBlocks.PERENNIAL_BLUE, WNBlocks.PERENNIAL_PINK, WNBlocks.PERENNIAL_VIOLET
                , WNBlocks.VIBURNUM_PINK, WNBlocks.VIBURNUM_WHITE, WNBlocks.RADISSIUM_BLUE, WNBlocks.RADISSIUM_PINK, WNBlocks.RADISSIUM_RED
                , WNBlocks.YEW_BUSH, WNBlocks.POISON_IVY, WNBlocks.LAMPGRASS, WNBlocks.SPIDERGRASS, WNBlocks.BIRD_OF_PARADISE, WNBlocks.LAVENDER
                , WNBlocks.RAPESEED, WNBlocks.BUSH_BLACK_LILAC, WNBlocks.ANTHURIUM_PINK, WNBlocks.ANTHURIUM_RED, WNBlocks.ANTHURIUM_WHITE
                , WNBlocks.ORCHIS_PURPLE, WNBlocks.ORCHIS_WHITE, WNBlocks.PEACE_LILY, WNBlocks.WILD_ROSE
                , WNBlocks.ANEMONE, WNBlocks.CHRYSANTHEMUM_LIGHT_YELLOW,WNBlocks.CHRYSANTHEMUM_PURPLE,WNBlocks.CHRYSANTHEMUM_RED,WNBlocks.CHRYSANTHEMUM_WHITE,WNBlocks.CHRYSANTHEMUM_YELLOW
                , WNBlocks.CHAMOMILE_WHITE, WNBlocks.CHAMOMILE_DOUBLE_WHITE, WNBlocks.CROCUS_PURPLE,WNBlocks.CROCUS_WHITE,WNBlocks.GERANIUM_PINK,WNBlocks.GERANIUM_RED,WNBlocks.GERANIUM_WHITE
                , WNBlocks.HYACINTH_DARK_BLUE, WNBlocks.HYACINTH_LIGHT_BLUE, WNBlocks.HYACINTH_PINK, WNBlocks.HYACINTH_PURPLE, WNBlocks.HYACINTH_RED, WNBlocks.HYACINTH_WHITE
                , WNBlocks.MARIGOLD_ORANGE, WNBlocks.MARIGOLD_RED, WNBlocks.MARIGOLD_WHITE, WNBlocks.MARIGOLD_YELLOW, WNBlocks.SCOTCHBROOM_YELLOW, WNBlocks.SCOTCHBROOM_PURPLE, WNBlocks.TANSY
                , WNBlocks.HEPATICA_BLUE, WNBlocks.HEPATICA_PINK, WNBlocks.HEPATICA_PURPLE, WNBlocks.HEPATICA_VIOLET, WNBlocks.HEPATICA_WHITE, WNBlocks.CATNIP, WNBlocks.DAFFODIL
                , WNBlocks.PRIMROSE_BLUE, WNBlocks.PRIMROSE_PINK, WNBlocks.PRIMROSE_WHITE, WNBlocks.NETTLE, WNBlocks.WATER_LILY_WHITE, WNBlocks.WATER_LILY_YELLOW
                , WNBlocks.VIOLET_PURPLE, WNBlocks.HOLLYHOCK_PINK, WNBlocks.HOLLYHOCK_RED, WNBlocks.GLADIOLUS_PURPLE, WNBlocks.GLADIOLUS_YELLOW,WNBlocks.GLADIOLUS_ORANGE, WNBlocks.GLADIOLUS_RED
                , WNBlocks.COLUMBINE_BLUE, WNBlocks.COLUMBINE_PURPLE, WNBlocks.COLUMBINE_RED, WNBlocks.CARNATION_PINK, WNBlocks.CARNATION_RED,WNBlocks.CARNATION_WHITE
                , WNBlocks.CLEMATIS_BLUE, WNBlocks.CLEMATIS_PURPLE, WNBlocks.GOLDENROD, WNBlocks.HONEYSUCKLE_YELLOW, WNBlocks.GIANT_HOGWEED
                , WNBlocks.HYDRANGEA_BLUE, WNBlocks.HYDRANGEA_PURPLE, WNBlocks.HYDRANGEA_PINK, WNBlocks.HYDRANGEA_WHITE, WNBlocks.MATTHIOLA_PINK, WNBlocks.HEATH_PINK, WNBlocks.HEATH_PURPLE,WNBlocks.HEATH_WHITE
                , WNBlocks.MISCANTHUS_GRASS, WNBlocks.FIRE_WEED, WNBlocks.MONKSHOOD_BLUE, WNBlocks.RHODODENDRON_PINK, WNBlocks.RHODODENDRON_PURPLE, WNBlocks.TAMARISK, WNBlocks.PRAIRIE_GRASS
                , WNBlocks.BUSH_BLACKBERRY, WNBlocks.BUSH_CRANBERRY, WNBlocks.BUSH_RED_CURRANT, WNBlocks.BUSH_WHITE_CURRANT, WNBlocks.BUSH_BLACK_CURRANT, WNBlocks.BUSH_QUINCE, WNBlocks.BUSH_WILD_STRAWBERRY);

        colors.register((p1, p2, p3, p4) -> {
            return p2 != null && p3 != null ? BiomeColors.getFoliageColor(p2, p3) : FoliageColors.getDefault();
        }, WNBlocks.CLOVER, WNBlocks.LEAF_PILE, WNBlocks.BOXWOOD, WNBlocks.SHRUB, WNBlocks.SHRUB_TALL, WNBlocks.THUJA, WNBlocks.THUJA_LARGE,WNBlocks.BELLADONNA, WNBlocks.CHINESE_LANTERN_FLOWER);


        colors.register((p1, p2, p3, p4) -> {
            return FoliageColors.getDefault();
        }, WNBlocks.CAVE_LILY_FLOWER);
    }

}
