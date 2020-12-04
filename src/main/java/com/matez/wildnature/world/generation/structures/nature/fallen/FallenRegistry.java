package com.matez.wildnature.world.generation.structures.nature.fallen;

import com.google.common.collect.ArrayListMultimap;
import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.world.generation.biome.features.LogType;
import com.matez.wildnature.world.generation.structures.nature.SchemFeature;
import com.matez.wildnature.world.generation.structures.nature.fallen.acacia.*;
import com.matez.wildnature.world.generation.structures.nature.fallen.apple.*;
import com.matez.wildnature.world.generation.structures.nature.fallen.aspen.*;
import com.matez.wildnature.world.generation.structures.nature.fallen.banana.fallen_banana1;
import com.matez.wildnature.world.generation.structures.nature.fallen.banana.fallen_banana2;
import com.matez.wildnature.world.generation.structures.nature.fallen.banana.fallen_banana3;
import com.matez.wildnature.world.generation.structures.nature.fallen.baobab.*;
import com.matez.wildnature.world.generation.structures.nature.fallen.beech.*;
import com.matez.wildnature.world.generation.structures.nature.fallen.bialowieza.fallen_bialowieza1;
import com.matez.wildnature.world.generation.structures.nature.fallen.bialowieza.fallen_bialowieza2;
import com.matez.wildnature.world.generation.structures.nature.fallen.bialowieza.fallen_bialowieza3;
import com.matez.wildnature.world.generation.structures.nature.fallen.birch.*;
import com.matez.wildnature.world.generation.structures.nature.fallen.cedar.*;
import com.matez.wildnature.world.generation.structures.nature.fallen.cherry.*;
import com.matez.wildnature.world.generation.structures.nature.fallen.citrus.*;
import com.matez.wildnature.world.generation.structures.nature.fallen.coniferous.fallen_big_coniferous1;
import com.matez.wildnature.world.generation.structures.nature.fallen.coniferous.fallen_big_coniferous2;
import com.matez.wildnature.world.generation.structures.nature.fallen.cypress.fallen_cypress1;
import com.matez.wildnature.world.generation.structures.nature.fallen.cypress.fallen_cypress2;
import com.matez.wildnature.world.generation.structures.nature.fallen.cypress.fallen_cypress3;
import com.matez.wildnature.world.generation.structures.nature.fallen.dark.fallen_roofed1;
import com.matez.wildnature.world.generation.structures.nature.fallen.dark.fallen_roofed2;
import com.matez.wildnature.world.generation.structures.nature.fallen.dark.fallen_roofed3;
import com.matez.wildnature.world.generation.structures.nature.fallen.dead.fallen_dead1;
import com.matez.wildnature.world.generation.structures.nature.fallen.dead.fallen_dead2;
import com.matez.wildnature.world.generation.structures.nature.fallen.dead.fallen_dead3;
import com.matez.wildnature.world.generation.structures.nature.fallen.ebony.fallen_ebony_1;
import com.matez.wildnature.world.generation.structures.nature.fallen.ebony.fallen_ebony_2;
import com.matez.wildnature.world.generation.structures.nature.fallen.ebony.fallen_ebony_3;
import com.matez.wildnature.world.generation.structures.nature.fallen.ebony.fallen_ebony_4;
import com.matez.wildnature.world.generation.structures.nature.fallen.eucalyptus.*;
import com.matez.wildnature.world.generation.structures.nature.fallen.fir.*;
import com.matez.wildnature.world.generation.structures.nature.fallen.forsythia.*;
import com.matez.wildnature.world.generation.structures.nature.fallen.hazel.fallen_hazel1;
import com.matez.wildnature.world.generation.structures.nature.fallen.hazel.fallen_hazel2;
import com.matez.wildnature.world.generation.structures.nature.fallen.hazel.fallen_hazel3;
import com.matez.wildnature.world.generation.structures.nature.fallen.hazel.fallen_hazel4;
import com.matez.wildnature.world.generation.structures.nature.fallen.hornbeam.fallen_hornbeam1;
import com.matez.wildnature.world.generation.structures.nature.fallen.hornbeam.fallen_hornbeam2;
import com.matez.wildnature.world.generation.structures.nature.fallen.hornbeam.fallen_hornbeam3;
import com.matez.wildnature.world.generation.structures.nature.fallen.jacaranda.fallen_jacaranda1;
import com.matez.wildnature.world.generation.structures.nature.fallen.jacaranda.fallen_jacaranda2;
import com.matez.wildnature.world.generation.structures.nature.fallen.jacaranda.fallen_jacaranda3;
import com.matez.wildnature.world.generation.structures.nature.fallen.jungle.fallen_jungle_1;
import com.matez.wildnature.world.generation.structures.nature.fallen.jungle.fallen_jungle_2;
import com.matez.wildnature.world.generation.structures.nature.fallen.jungle.fallen_jungle_3;
import com.matez.wildnature.world.generation.structures.nature.fallen.larch.*;
import com.matez.wildnature.world.generation.structures.nature.fallen.magnolia.fallen_magnolia_1;
import com.matez.wildnature.world.generation.structures.nature.fallen.magnolia.fallen_magnolia_2;
import com.matez.wildnature.world.generation.structures.nature.fallen.magnolia.fallen_magnolia_3;
import com.matez.wildnature.world.generation.structures.nature.fallen.magnolia.fallen_magnolia_4;
import com.matez.wildnature.world.generation.structures.nature.fallen.mahogany.fallen_mahogany1;
import com.matez.wildnature.world.generation.structures.nature.fallen.mahogany.fallen_mahogany2;
import com.matez.wildnature.world.generation.structures.nature.fallen.mahogany.fallen_mahogany3;
import com.matez.wildnature.world.generation.structures.nature.fallen.mahogany.fallen_mahogany4;
import com.matez.wildnature.world.generation.structures.nature.fallen.mangrove.fallen_mangrove1;
import com.matez.wildnature.world.generation.structures.nature.fallen.mangrove.fallen_mangrove2;
import com.matez.wildnature.world.generation.structures.nature.fallen.mangrove.fallen_mangrove3;
import com.matez.wildnature.world.generation.structures.nature.fallen.mangrove.fallen_mangrove4;
import com.matez.wildnature.world.generation.structures.nature.fallen.maple.fallen_maple1;
import com.matez.wildnature.world.generation.structures.nature.fallen.maple.fallen_maple2;
import com.matez.wildnature.world.generation.structures.nature.fallen.maple.fallen_maple3;
import com.matez.wildnature.world.generation.structures.nature.fallen.nuytsia.fallen_nuytsia1;
import com.matez.wildnature.world.generation.structures.nature.fallen.nuytsia.fallen_nuytsia2;
import com.matez.wildnature.world.generation.structures.nature.fallen.nuytsia.fallen_nuytsia3;
import com.matez.wildnature.world.generation.structures.nature.fallen.nuytsia.fallen_nuytsia4;
import com.matez.wildnature.world.generation.structures.nature.fallen.oak.*;
import com.matez.wildnature.world.generation.structures.nature.fallen.olive.fallen_olive1;
import com.matez.wildnature.world.generation.structures.nature.fallen.olive.fallen_olive2;
import com.matez.wildnature.world.generation.structures.nature.fallen.olive.fallen_olive3;
import com.matez.wildnature.world.generation.structures.nature.fallen.palm.fallen_palm1;
import com.matez.wildnature.world.generation.structures.nature.fallen.palm.fallen_palm2;
import com.matez.wildnature.world.generation.structures.nature.fallen.palm.fallen_palm3;
import com.matez.wildnature.world.generation.structures.nature.fallen.palm.fallen_palm4;
import com.matez.wildnature.world.generation.structures.nature.fallen.pear.fallen_pear1;
import com.matez.wildnature.world.generation.structures.nature.fallen.pear.fallen_pear2;
import com.matez.wildnature.world.generation.structures.nature.fallen.pear.fallen_pear3;
import com.matez.wildnature.world.generation.structures.nature.fallen.pear.fallen_pear4;
import com.matez.wildnature.world.generation.structures.nature.fallen.pine.*;
import com.matez.wildnature.world.generation.structures.nature.fallen.plum.*;
import com.matez.wildnature.world.generation.structures.nature.fallen.poplar.fallen_poplar1;
import com.matez.wildnature.world.generation.structures.nature.fallen.poplar.fallen_poplar2;
import com.matez.wildnature.world.generation.structures.nature.fallen.poplar.fallen_poplar3;
import com.matez.wildnature.world.generation.structures.nature.fallen.poplar.fallen_poplar4;
import com.matez.wildnature.world.generation.structures.nature.fallen.redwood.fallen_giant_redwood1;
import com.matez.wildnature.world.generation.structures.nature.fallen.redwood.fallen_small_redwood1;
import com.matez.wildnature.world.generation.structures.nature.fallen.redwood.fallen_small_redwood2;
import com.matez.wildnature.world.generation.structures.nature.fallen.redwood.fallen_small_redwood3;
import com.matez.wildnature.world.generation.structures.nature.fallen.rowan.fallen_rowan1;
import com.matez.wildnature.world.generation.structures.nature.fallen.rowan.fallen_rowan2;
import com.matez.wildnature.world.generation.structures.nature.fallen.rowan.fallen_rowan3;
import com.matez.wildnature.world.generation.structures.nature.fallen.sequoia.fallen_sequoia1;
import com.matez.wildnature.world.generation.structures.nature.fallen.sequoia.fallen_sequoia2;
import com.matez.wildnature.world.generation.structures.nature.fallen.sequoia.fallen_sequoia3;
import com.matez.wildnature.world.generation.structures.nature.fallen.spooky.fallen_spooky1;
import com.matez.wildnature.world.generation.structures.nature.fallen.spooky.fallen_spooky2;
import com.matez.wildnature.world.generation.structures.nature.fallen.spooky.fallen_spooky3;
import com.matez.wildnature.world.generation.structures.nature.fallen.spruce.fallen_spruce_1;
import com.matez.wildnature.world.generation.structures.nature.fallen.spruce.fallen_spruce_2;
import com.matez.wildnature.world.generation.structures.nature.fallen.spruce.fallen_spruce_3;
import com.matez.wildnature.world.generation.structures.nature.fallen.spruce.fallen_spruce_4;
import com.matez.wildnature.world.generation.structures.nature.fallen.willow.*;
import net.minecraft.block.Blocks;

import java.util.List;

public class FallenRegistry {
    private static final ArrayListMultimap<LogType, FallenSchemFeature> REGISTRY = ArrayListMultimap.create();

    public static void registerAll() {
        WN.LOGGER.info("Registering fallen trees...");
        register(LogType.OAK,
                new fallen_big_oak1(),
                new fallen_big_oak2(),
                new fallen_big_oak3());
        register(LogType.SMALL_OAK,
                new fallen_oak_1(),
                new fallen_oak_2(),
                new fallen_oak_3(),
                new fallen_oak_4(),
                new fallen_oak_5());
        register(LogType.DOUBLE_OAK,
                new fallen_double_oak1(),
                new fallen_double_oak2(),
                new fallen_double_oak3());
        register(LogType.BALD_OAK,
                new fallen_bald_oak1(),
                new fallen_bald_oak2(),
                new fallen_bald_oak3());
        register(LogType.SEQUOIA,
                new fallen_sequoia1(),
                new fallen_sequoia2(),
                new fallen_sequoia3());
        register(LogType.DEAD,
                new fallen_dead1(),
                new fallen_dead2(),
                new fallen_dead3());
        register(LogType.BIG_OAK,
                new fallen_mega_oak1(),
                new fallen_mega_oak2(),
                new fallen_mega_oak3());
        register(LogType.SPRUCE,
                new fallen_spruce_1(),
                new fallen_spruce_2(),
                new fallen_spruce_3(),
                new fallen_spruce_4());
        register(LogType.BIG_SPRUCE,
                new fallen_big_coniferous1().setCustomLogOverride(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeafOverride(SchemFeature.notDecayingLeaf(Blocks.SPRUCE_LEAVES)),
                new fallen_big_coniferous2().setCustomLogOverride(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeafOverride(SchemFeature.notDecayingLeaf(Blocks.SPRUCE_LEAVES)));
        register(LogType.BIRCH,
                new fallen_tall_birch1(),
                new fallen_tall_birch2(),
                new fallen_tall_birch3(),
                new fallen_tall_birch4());
        register(LogType.SMALL_BIRCH,
                new fallen_birch1(),
                new fallen_birch2(),
                new fallen_birch3(),
                new fallen_birch4());
        register(LogType.JUNGLE_MEDIUM,
                new fallen_jungle_1(),
                new fallen_jungle_2(),
                new fallen_jungle_3());
        register(LogType.ACACIA,
                new fallen_acacia_1(),
                new fallen_acacia_2(),
                new fallen_acacia_3(),
                new fallen_acacia_4(),
                new fallen_acacia_5());
        register(LogType.BIG_ACACIA,
                new fallen_big_acacia1(),
                new fallen_big_acacia2(),
                new fallen_big_acacia3());
        register(LogType.DOUBLE_DARK_OAK,
                new fallen_double_oak1(),
                new fallen_double_oak2(),
                new fallen_double_oak3());
        register(LogType.ROOFED,
                new fallen_roofed1(),
                new fallen_roofed2(),
                new fallen_roofed3());
        register(LogType.SPOOKY,
                new fallen_spooky1(),
                new fallen_spooky2(),
                new fallen_spooky3());

        register(LogType.BIRCH_THICK,
                new fallen_thick_birch1(),
                new fallen_thick_birch2(),
                new fallen_thick_birch3(),
                new fallen_thick_birch4());

        register(LogType.ASPEN,
                new fallen_aspen_1(),
                new fallen_aspen_2(),
                new fallen_aspen_3(),
                new fallen_aspen_4(),
                new fallen_aspen_5());
        register(LogType.WILLOW,
                new fallen_willow1(),
                new fallen_willow2(),
                new fallen_willow3(),
                new fallen_willow_1(),
                new fallen_willow_2(),
                new fallen_willow_3());
        register(LogType.BAOBAB,
                new fallen_baobab_1(),
                new fallen_baobab_2());
        register(LogType.BIG_BAOBAB,
                new fallen_big_baobab1(),
                new fallen_big_baobab2(),
                new fallen_big_baobab3());
        register(LogType.BEECH,
                new fallen_beech1(),
                new fallen_beech2(),
                new fallen_beech3(),
                new fallen_beech4());
        register(LogType.PURPLE_BEECH,
                new fallen_purple_beech_1(),
                new fallen_purple_beech_2(),
                new fallen_purple_beech_3(),
                new fallen_purple_beech_4(),
                new fallen_purple_beech_5());
        register(LogType.CEDAR,
                new fallen_cedar1(),
                new fallen_cedar2(),
                new fallen_cedar3(),
                new fallen_cedar4(),
                new fallen_cedar5());
        register(LogType.WEEPING_CEDAR,
                new fallen_weeping_cedar1(),
                new fallen_weeping_cedar2(),
                new fallen_weeping_cedar3());
        register(LogType.CYPRESS,
                new fallen_cypress1(),
                new fallen_cypress2(),
                new fallen_cypress3());
        register(LogType.EBONY,
                new fallen_ebony_1(),
                new fallen_ebony_2(),
                new fallen_ebony_3(),
                new fallen_ebony_4());
        register(LogType.SMALL_EBONY);//no fallen here since it's a bush
        register(LogType.EUCALYPTUS,
                new fallen_eucalyptus1(),
                new fallen_eucalyptus2(),
                new fallen_eucalyptus3(),
                new fallen_eucalyptus4(),
                new fallen_eucalyptus5());
        register(LogType.BIG_EUCALYPTUS,
                new fallen_big_eucalyptus1(),
                new fallen_big_eucalyptus2(),
                new fallen_big_eucalyptus3());
        register(LogType.MAHOGANY,
                new fallen_mahogany1(),
                new fallen_mahogany2(),
                new fallen_mahogany3(),
                new fallen_mahogany4());
        register(LogType.PALM,
                new fallen_palm1(),
                new fallen_palm2(),
                new fallen_palm3(),
                new fallen_palm4());
        register(LogType.HORNBEAM,
                new fallen_hornbeam1(),
                new fallen_hornbeam2(),
                new fallen_hornbeam3());
        register(LogType.POPLAR,
                new fallen_poplar1(),
                new fallen_poplar2(),
                new fallen_poplar3(),
                new fallen_poplar4());
        register(LogType.HAZEL,
                new fallen_hazel1(),
                new fallen_hazel2(),
                new fallen_hazel3(),
                new fallen_hazel4());
        register(LogType.MANGROVE,
                new fallen_mangrove1(),
                new fallen_mangrove2(),
                new fallen_mangrove3(),
                new fallen_mangrove4());
        register(LogType.REDWOOD,
                new fallen_small_redwood1(),
                new fallen_small_redwood2(),
                new fallen_small_redwood3());
        register(LogType.BIG_REDWOOD,
                new fallen_giant_redwood1());
        register(LogType.NUYTSIA,
                new fallen_nuytsia1(),
                new fallen_nuytsia2(),
                new fallen_nuytsia3(),
                new fallen_nuytsia4());

        register(LogType.MAPLE,
                new fallen_maple1(),
                new fallen_maple2(),
                new fallen_maple3());
        register(LogType.MAPLE_RED,
                new fallen_maple1().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_RED_LEAVES)),
                new fallen_maple2().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_RED_LEAVES)),
                new fallen_maple3().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_RED_LEAVES)));
        register(LogType.MAPLE_ORANGE,
                new fallen_maple1().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_ORANGE_LEAVES)),
                new fallen_maple2().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_ORANGE_LEAVES)),
                new fallen_maple3().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_ORANGE_LEAVES)));
        register(LogType.MAPLE_BROWN,
                new fallen_maple1().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_BROWN_LEAVES)),
                new fallen_maple2().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_BROWN_LEAVES)),
                new fallen_maple3().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_BROWN_LEAVES)));
        register(LogType.MAPLE_YELLOW,
                new fallen_maple1().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_YELLOW_LEAVES)),
                new fallen_maple2().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_YELLOW_LEAVES)),
                new fallen_maple3().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_YELLOW_LEAVES)));

        register(LogType.SEASONAL_BIRCH_RED,
                new fallen_seasonal_birch1().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_RED_LEAVES)),
                new fallen_seasonal_birch2().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_RED_LEAVES)),
                new fallen_seasonal_birch3().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_RED_LEAVES)));
        register(LogType.SEASONAL_BIRCH_ORANGE,
                new fallen_seasonal_birch1().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_ORANGE_LEAVES)),
                new fallen_seasonal_birch2().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_ORANGE_LEAVES)),
                new fallen_seasonal_birch3().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_ORANGE_LEAVES)));
        register(LogType.SEASONAL_BIRCH_BROWN,
                new fallen_seasonal_birch1().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_BROWN_LEAVES)),
                new fallen_seasonal_birch2().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_BROWN_LEAVES)),
                new fallen_seasonal_birch3().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_BROWN_LEAVES)));
        register(LogType.SEASONAL_BIRCH_YELLOW,
                new fallen_seasonal_birch1().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_YELLOW_LEAVES)),
                new fallen_seasonal_birch2().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_YELLOW_LEAVES)),
                new fallen_seasonal_birch3().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_YELLOW_LEAVES)));

        register(LogType.METASEQUOIA_GREEN,
                new fallen_sequoia1().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_GREEN_LEAVES)),
                new fallen_sequoia2().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_GREEN_LEAVES)),
                new fallen_sequoia3().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_GREEN_LEAVES)));
        register(LogType.METASEQUOIA_RED,
                new fallen_sequoia1().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_RED_LEAVES)),
                new fallen_sequoia2().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_RED_LEAVES)),
                new fallen_sequoia3().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_RED_LEAVES)));
        register(LogType.METASEQUOIA_ORANGE,
                new fallen_sequoia1().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_ORANGE_LEAVES)),
                new fallen_sequoia2().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_ORANGE_LEAVES)),
                new fallen_sequoia3().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_ORANGE_LEAVES)));
        register(LogType.METASEQUOIA_YELLOW,
                new fallen_sequoia1().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_YELLOW_LEAVES)),
                new fallen_sequoia2().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_YELLOW_LEAVES)),
                new fallen_sequoia3().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_YELLOW_LEAVES)));
        register(LogType.METASEQUOIA_BROWN,
                new fallen_sequoia1().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_BROWN_LEAVES)),
                new fallen_sequoia2().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_BROWN_LEAVES)),
                new fallen_sequoia3().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_BROWN_LEAVES)));

        register(LogType.BEECH_THICK,
                new fallen_beech_thick1(),
                new fallen_beech_thick2(),
                new fallen_beech_thick3(),
                new fallen_beech_thick4());

        register(LogType.FIR,
                new fallen_fir1(),
                new fallen_fir2(),
                new fallen_fir3(),
                new fallen_fir4());
        register(LogType.BIG_FIR,
                new fallen_big_coniferous1().setCustomLogOverride(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.FIR_LEAVES)),
                new fallen_big_coniferous2().setCustomLogOverride(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.FIR_LEAVES)));
        register(LogType.SILVER_FIR,
                new fallen_silver_fir1(),
                new fallen_silver_fir2(),
                new fallen_silver_fir3());
        register(LogType.PINE,
                new fallen_pine1(),
                new fallen_pine2(),
                new fallen_pine3(),
                new fallen_pine4());
        register(LogType.BIG_PINE,
                new fallen_big_coniferous1().setCustomLogOverride(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),
                new fallen_big_coniferous2().setCustomLogOverride(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)));
        register(LogType.SMALL_PINE,
                new fallen_mini_pine1(),
                new fallen_mini_pine2(),
                new fallen_mini_pine3(),
                new fallen_mini_pine4(),
                new fallen_mini_pine5(),
                new fallen_mini_pine6(),
                new fallen_mini_pine7(),
                new fallen_mini_pine8(),
                new fallen_mini_pine9());
        register(LogType.BIALOWIEZA,
                new fallen_bialowieza1(),
                new fallen_bialowieza2(),
                new fallen_bialowieza3());
        register(LogType.LARCH,
                new fallen_larch1(),
                new fallen_larch2(),
                new fallen_larch3(),
                new fallen_larch4(),
                new fallen_larch5());

        register(LogType.PINE_THICK,
                new fallen_thick_pine1(),
                new fallen_thick_pine2(),
                new fallen_thick_pine3(),
                new fallen_thick_pine4());

        register(LogType.PARADISE_APPLE,
                new fallen_paradise_apple_1(),
                new fallen_paradise_apple_2(),
                new fallen_paradise_apple_3());

        register(LogType.APPLE,
                new fallen_apple_1(),
                new fallen_apple_2(),
                new fallen_apple_3(),
                new fallen_apple_4(),
                new fallen_apple_5());

        register(LogType.PEAR,
                new fallen_pear1(),
                new fallen_pear2(),
                new fallen_pear3(),
                new fallen_pear4());
        register(LogType.BANANA,
                new fallen_banana1(),
                new fallen_banana2(),
                new fallen_banana3());
        register(LogType.CHERRY,
                new fallen_cherry1(),
                new fallen_cherry2(),
                new fallen_cherry3(),
                new fallen_cherry4());
        register(LogType.PINK_CHERRY,
                new fallen_cherry_pink1(),
                new fallen_cherry_pink1(),
                new fallen_cherry_pink3(),
                new fallen_cherry_pink4());
        register(LogType.WHITE_CHERRY,
                new fallen_cherry_white1(),
                new fallen_cherry_white1(),
                new fallen_cherry_white3(),
                new fallen_cherry_white4());
        register(LogType.SAKURA,
                new fallen_sakura1(),
                new fallen_sakura2(),
                new fallen_sakura3());
        register(LogType.WILD_CHERRY,
                new fallen_wild_cherry1(),
                new fallen_wild_cherry2(),
                new fallen_wild_cherry3());
        register(LogType.PLUM,
                new fallen_plum1(),
                new fallen_plum2(),
                new fallen_plum3(),
                new fallen_plum4());
        register(LogType.MIRABELLE_PLUM,
                new fallen_mirabelle_plum1(),
                new fallen_mirabelle_plum2(),
                new fallen_mirabelle_plum3(),
                new fallen_mirabelle_plum4());
        register(LogType.JACARANDA,
                new fallen_jacaranda1(),
                new fallen_jacaranda2(),
                new fallen_jacaranda3());
        register(LogType.ROWAN,
                new fallen_rowan1(),
                new fallen_rowan2(),
                new fallen_rowan3());

        register(LogType.LEMON,
                new fallen_lemon1(),
                new fallen_lemon2(),
                new fallen_lemon3());
        register(LogType.ORANGE,
                new fallen_orange1(),
                new fallen_orange2(),
                new fallen_orange3());
        register(LogType.POMEGRANATE,
                new fallen_pomegranate1(),
                new fallen_pomegranate2(),
                new fallen_pomegranate3());
        register(LogType.LIME,
                new fallen_lime1(),
                new fallen_lime2(),
                new fallen_lime3());
        register(LogType.MANGO,
                new fallen_mango1(),
                new fallen_mango2());
        register(LogType.BIG_MANGO,
                new fallen_big_mango1(),
                new fallen_big_mango2());
        register(LogType.OLIVE,
                new fallen_olive1(),
                new fallen_olive2(),
                new fallen_olive3());
        register(LogType.GRAPEFRUIT,
                new fallen_grapefruit1(),
                new fallen_grapefruit2(),
                new fallen_grapefruit3());
        register(LogType.PEACH,
                new fallen_peach1(),
                new fallen_peach2(),
                new fallen_peach3());

        register(LogType.FORSYTHIA,
                new fallen_forsythia_1(),
                new fallen_forsythia_2(),
                new fallen_forsythia_3(),
                new fallen_forsythia_4(),
                new fallen_forsythia_5());
        register(LogType.MAGNOLIA,
                new fallen_magnolia_1(),
                new fallen_magnolia_2(),
                new fallen_magnolia_3(),
                new fallen_magnolia_4());

        WN.LOGGER.info("Registered " + REGISTRY.size() + " fallen trees.");
    }

    private static void register(LogType type, FallenSchemFeature... fallenTrees) {
        for (FallenSchemFeature fallenTree : fallenTrees) {
            REGISTRY.put(type, fallenTree);
        }
    }

    public static List<FallenSchemFeature> getTreesFor(LogType logType) {
        return REGISTRY.get(logType);
    }
}
