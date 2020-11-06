package com.matez.wildnature.world.generation.structures.nature.fallen;

import com.google.common.collect.ArrayListMultimap;
import com.matez.wildnature.init.WN;
import com.matez.wildnature.world.generation.biome.features.LogType;
import com.matez.wildnature.world.generation.structures.nature.fallen.acacia.*;
import com.matez.wildnature.world.generation.structures.nature.fallen.apple.*;
import com.matez.wildnature.world.generation.structures.nature.fallen.aspen.*;
import com.matez.wildnature.world.generation.structures.nature.fallen.baobab.fallen_baobab_1;
import com.matez.wildnature.world.generation.structures.nature.fallen.baobab.fallen_baobab_2;
import com.matez.wildnature.world.generation.structures.nature.fallen.beech.*;
import com.matez.wildnature.world.generation.structures.nature.fallen.birch.fallen_birch1;
import com.matez.wildnature.world.generation.structures.nature.fallen.birch.fallen_birch2;
import com.matez.wildnature.world.generation.structures.nature.fallen.birch.fallen_birch3;
import com.matez.wildnature.world.generation.structures.nature.fallen.birch.fallen_birch4;
import com.matez.wildnature.world.generation.structures.nature.fallen.cedar.*;
import com.matez.wildnature.world.generation.structures.nature.fallen.cherry.*;
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
import com.matez.wildnature.world.generation.structures.nature.fallen.jacaranda.fallen_jacaranda4;
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
import com.matez.wildnature.world.generation.structures.nature.fallen.oak.*;
import com.matez.wildnature.world.generation.structures.nature.fallen.palm.fallen_palm1;
import com.matez.wildnature.world.generation.structures.nature.fallen.palm.fallen_palm2;
import com.matez.wildnature.world.generation.structures.nature.fallen.palm.fallen_palm3;
import com.matez.wildnature.world.generation.structures.nature.fallen.palm.fallen_palm4;
import com.matez.wildnature.world.generation.structures.nature.fallen.pear.fallen_pear1;
import com.matez.wildnature.world.generation.structures.nature.fallen.pear.fallen_pear2;
import com.matez.wildnature.world.generation.structures.nature.fallen.pear.fallen_pear3;
import com.matez.wildnature.world.generation.structures.nature.fallen.pear.fallen_pear4;
import com.matez.wildnature.world.generation.structures.nature.fallen.pine.fallen_pine1;
import com.matez.wildnature.world.generation.structures.nature.fallen.pine.fallen_pine2;
import com.matez.wildnature.world.generation.structures.nature.fallen.pine.fallen_pine3;
import com.matez.wildnature.world.generation.structures.nature.fallen.pine.fallen_pine4;
import com.matez.wildnature.world.generation.structures.nature.fallen.plum.*;
import com.matez.wildnature.world.generation.structures.nature.fallen.poplar.fallen_poplar1;
import com.matez.wildnature.world.generation.structures.nature.fallen.poplar.fallen_poplar2;
import com.matez.wildnature.world.generation.structures.nature.fallen.poplar.fallen_poplar3;
import com.matez.wildnature.world.generation.structures.nature.fallen.poplar.fallen_poplar4;
import com.matez.wildnature.world.generation.structures.nature.fallen.redwood.fallen_giant_redwood1;
import com.matez.wildnature.world.generation.structures.nature.fallen.spruce.fallen_spruce_1;
import com.matez.wildnature.world.generation.structures.nature.fallen.spruce.fallen_spruce_2;
import com.matez.wildnature.world.generation.structures.nature.fallen.spruce.fallen_spruce_3;
import com.matez.wildnature.world.generation.structures.nature.fallen.spruce.fallen_spruce_4;

import java.util.List;

public class FallenRegistry {
    private static ArrayListMultimap<LogType, FallenSchemFeature> REGISTRY = ArrayListMultimap.create();
    public static void registerAll(){
        WN.LOGGER.info("Registering fallen trees...");
        register(LogType.OAK);
        register(LogType.SMALL_OAK,
                new fallen_oak_1(),
                new fallen_oak_2(),
                new fallen_oak_3(),
                new fallen_oak_4(),
                new fallen_oak_5());
        register(LogType.DOUBLE_OAK);
        register(LogType.BALD_OAK);
        register(LogType.SEQUOIA);
        register(LogType.DEAD);
        register(LogType.BIG_OAK);
        register(LogType.SPRUCE,
                new fallen_spruce_1(),
                new fallen_spruce_2(),
                new fallen_spruce_3(),
                new fallen_spruce_4());
        register(LogType.BIG_SPRUCE);
        register(LogType.BIRCH);
        register(LogType.SMALL_BIRCH,
                new fallen_birch1(),
                new fallen_birch2(),
                new fallen_birch3(),
                new fallen_birch4());
        register(LogType.JUNGLE,
                new fallen_jungle_1(),
                new fallen_jungle_2(),
                new fallen_jungle_3());
        register(LogType.ACACIA,
                new fallen_acacia_1(),
                new fallen_acacia_2(),
                new fallen_acacia_3(),
                new fallen_acacia_4(),
                new fallen_acacia_5());
        register(LogType.BIG_ACACIA);
        register(LogType.DARK_OAK);
        register(LogType.DOUBLE_DARK_OAK);
        register(LogType.ROOFED);
        register(LogType.SPOOKY);

        register(LogType.SPRUCE_THICK);
        register(LogType.BIRCH_THICK);

        register(LogType.ASPEN,
                new fallen_aspen_1(),
                new fallen_aspen_2(),
                new fallen_aspen_3(),
                new fallen_aspen_4(),
                new fallen_aspen_5());
        register(LogType.WILLOW);
        register(LogType.BAOBAB,
                new fallen_baobab_1(),
                new fallen_baobab_2());
        register(LogType.BIG_BAOBAB);
        register(LogType.BEECH);
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
        register(LogType.WEEPING_CEDAR);
        register(LogType.CYPRESS);
        register(LogType.EBONY,
                new fallen_ebony_1(),
                new fallen_ebony_2(),
                new fallen_ebony_3(),
                new fallen_ebony_4());
        register(LogType.SMALL_EBONY);
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
        register(LogType.REDWOOD);
        register(LogType.BIG_REDWOOD,
                new fallen_giant_redwood1());
        register(LogType.NUYTSIA);

        register(LogType.MAPLE);
        register(LogType.MAPLE_RED);
        register(LogType.MAPLE_ORANGE);
        register(LogType.MAPLE_BROWN);
        register(LogType.MAPLE_YELLOW);

        register(LogType.SEASONAL_BIRCH_RED);
        register(LogType.SEASONAL_BIRCH_ORANGE);
        register(LogType.SEASONAL_BIRCH_BROWN);
        register(LogType.SEASONAL_BIRCH_YELLOW);

        register(LogType.METASEQUOIA_GREEN);
        register(LogType.METASEQUOIA_RED);
        register(LogType.METASEQUOIA_ORANGE);
        register(LogType.METASEQUOIA_YELLOW);
        register(LogType.METASEQUOIA_BROWN);

        register(LogType.BEECH_THICK,
                new fallen_beech_1(),
                new fallen_beech_2(),
                new fallen_beech_3(),
                new fallen_beech_4());

        register(LogType.FIR,
                new fallen_fir1(),
                new fallen_fir2(),
                new fallen_fir3(),
                new fallen_fir4());
        register(LogType.BIG_FIR);
        register(LogType.SILVER_FIR,
                new fallen_silver_fir1(),
                new fallen_silver_fir2(),
                new fallen_silver_fir3());
        register(LogType.PINE,
                new fallen_pine1(),
                new fallen_pine2(),
                new fallen_pine3(),
                new fallen_pine4());
        register(LogType.BIG_PINE);
        register(LogType.SMALL_PINE);
        register(LogType.BIALOWIEZA);
        register(LogType.LARCH,
                new fallen_larch1(),
                new fallen_larch2(),
                new fallen_larch3(),
                new fallen_larch4(),
                new fallen_larch5());

        register(LogType.PINE_THICK);

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
        register(LogType.BANANA);
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
        register(LogType.SAKURA);
        register(LogType.WILD_CHERRY);
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
                new fallen_jacaranda3(),
                new fallen_jacaranda4());

        register(LogType.ROWAN);

        register(LogType.LEMON);
        register(LogType.ORANGE);
        register(LogType.POMEGRANATE);
        register(LogType.LIME);
        register(LogType.MANGO);
        register(LogType.OLIVE);
        register(LogType.GRAPEFRUIT);
        register(LogType.PEACH);

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

    private static void register(LogType type, FallenSchemFeature... fallenTrees){
        for (FallenSchemFeature fallenTree : fallenTrees) {
            REGISTRY.put(type,fallenTree);
        }
    }

    public static List<FallenSchemFeature> getTreesFor(LogType logType){
        return REGISTRY.get(logType);
    }
}
