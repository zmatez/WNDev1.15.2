package com.matez.wildnature.registry;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.SaplingBase;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.other.TreeWeighList;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.matez.wildnature.world.gen.structures.nature.SchemTree;
import com.matez.wildnature.world.gen.structures.nature.woods.baobab.*;
import com.matez.wildnature.world.gen.structures.nature.woods.beech.*;
import com.matez.wildnature.world.gen.structures.nature.woods.birch.tree_birch10;
import com.matez.wildnature.world.gen.structures.nature.woods.birch.tree_birch11;
import com.matez.wildnature.world.gen.structures.nature.woods.birch.tree_birch12;
import com.matez.wildnature.world.gen.structures.nature.woods.cedar.*;
import com.matez.wildnature.world.gen.structures.nature.woods.cherry.cherry1;
import com.matez.wildnature.world.gen.structures.nature.woods.cherry.cherry2;
import com.matez.wildnature.world.gen.structures.nature.woods.cherry.cherry3;
import com.matez.wildnature.world.gen.structures.nature.woods.cherry.cherry4;
import com.matez.wildnature.world.gen.structures.nature.woods.citrus.*;
import com.matez.wildnature.world.gen.structures.nature.woods.deco.*;
import com.matez.wildnature.world.gen.structures.nature.woods.ebony.ebony1;
import com.matez.wildnature.world.gen.structures.nature.woods.ebony.ebony2;
import com.matez.wildnature.world.gen.structures.nature.woods.ebony.ebony3;
import com.matez.wildnature.world.gen.structures.nature.woods.ebony.ebony4;
import com.matez.wildnature.world.gen.structures.nature.woods.eucalyptus.*;
import com.matez.wildnature.world.gen.structures.nature.woods.fir.*;
import com.matez.wildnature.world.gen.structures.nature.woods.hazel.hazel1;
import com.matez.wildnature.world.gen.structures.nature.woods.hazel.hazel2;
import com.matez.wildnature.world.gen.structures.nature.woods.hazel.hazel3;
import com.matez.wildnature.world.gen.structures.nature.woods.hazel.hazel4;
import com.matez.wildnature.world.gen.structures.nature.woods.hornbeam.tree_hornbeam1;
import com.matez.wildnature.world.gen.structures.nature.woods.hornbeam.tree_hornbeam3;
import com.matez.wildnature.world.gen.structures.nature.woods.hornbeam.tree_hornbeam5;
import com.matez.wildnature.world.gen.structures.nature.woods.hornbeam.tree_hornbeam7;
import com.matez.wildnature.world.gen.structures.nature.woods.jacaranda.jacaranda1;
import com.matez.wildnature.world.gen.structures.nature.woods.jacaranda.jacaranda2;
import com.matez.wildnature.world.gen.structures.nature.woods.jacaranda.jacaranda3;
import com.matez.wildnature.world.gen.structures.nature.woods.jacaranda.jacaranda4;
import com.matez.wildnature.world.gen.structures.nature.woods.larch.*;
import com.matez.wildnature.world.gen.structures.nature.woods.mahogany.mahogany1;
import com.matez.wildnature.world.gen.structures.nature.woods.mahogany.mahogany2;
import com.matez.wildnature.world.gen.structures.nature.woods.mahogany.mahogany3;
import com.matez.wildnature.world.gen.structures.nature.woods.mahogany.mahogany4;
import com.matez.wildnature.world.gen.structures.nature.woods.mangrove.*;
import com.matez.wildnature.world.gen.structures.nature.woods.nuytsia.*;
import com.matez.wildnature.world.gen.structures.nature.woods.oak.*;
import com.matez.wildnature.world.gen.structures.nature.woods.orchard.*;
import com.matez.wildnature.world.gen.structures.nature.woods.palm.*;
import com.matez.wildnature.world.gen.structures.nature.woods.pine.*;
import com.matez.wildnature.world.gen.structures.nature.woods.redwood.tree_redwood1;
import com.matez.wildnature.world.gen.structures.nature.woods.redwood.tree_redwood2;
import com.matez.wildnature.world.gen.structures.nature.woods.redwood.tree_redwood3;
import com.matez.wildnature.world.gen.structures.nature.woods.redwood.tree_redwood4;
import com.matez.wildnature.world.gen.structures.nature.woods.spruce.*;
import com.matez.wildnature.world.gen.structures.nature.woods.willow.*;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.trees.Tree;
import net.minecraft.item.Item;

public class SaplingRegistry {

    private Block[] saplings;

    public SaplingRegistry(){
        TreeWeighList weighList = new TreeWeighList();
        weighList.add(new apple1(),10);
        weighList.add(new apple2(),10);
        weighList.add(new apple3(),10);
        SchemTree appleTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new oak1().setCustomLog(Blocks.OAK_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PARADISE_APPLE_LEAVES)),10);
        weighList.add(new oak2().setCustomLog(Blocks.OAK_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PARADISE_APPLE_LEAVES)),10);
        weighList.add(new oak3().setCustomLog(Blocks.OAK_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PARADISE_APPLE_LEAVES)),10);
        SchemTree paradiseAppleTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();

        weighList.add(new tree_birch11().setCustomLog(Blocks.BIRCH_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.ASPEN_LEAVES)),10);
        weighList.add(new tree_birch12().setCustomLog(Blocks.BIRCH_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.ASPEN_LEAVES)),10);
        weighList.add(new tree_birch10().setCustomLog(Blocks.BIRCH_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.ASPEN_LEAVES)),5);

        SchemTree aspenTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();

        weighList.add(new baobab1(),10);
        weighList.add(new baobab2(),10);
        weighList.add(new baobab3(),10);
        weighList.add(new baobab4(),10);
        weighList.add(new baobab5(),10);


        SchemTree baobabTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new beech1(),10);
        weighList.add(new beech2(),10);
        weighList.add(new beech3(),10);
        weighList.add(new beech4(),10);
        weighList.add(new beech5(),10);
        weighList.add(new beech6(),10);
        weighList.add(new beech7(),10);
        weighList.add(new beech8(),10);
        weighList.add(new beech9(),10);
        weighList.add(new beech10(),10);
        weighList.add(new beech11(),10);
        weighList.add(new beech12(),10);
        SchemTree beechTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new leafy_beech_1().setCustomLog(WNBlocks.BEECH_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PURPLE_BEECH_LEAVES)),10);
        weighList.add(new leafy_beech_2().setCustomLog(WNBlocks.BEECH_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PURPLE_BEECH_LEAVES)),10);
        weighList.add(new leafy_beech_3().setCustomLog(WNBlocks.BEECH_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PURPLE_BEECH_LEAVES)),10);
        SchemTree purpleBeechTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();

        weighList.add(new cedar1(),10);
        weighList.add(new cedar2(),10);
        weighList.add(new cedar3(),10);
        weighList.add(new cedar4(),10);
        weighList.add(new cedar5(),10);
        weighList.add(new cedar6(),10);
        weighList.add(new cedar7(),10);
        weighList.add(new cedar8(),10);


        SchemTree cedarTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();

        weighList.add(new cherry1().setCustomLog( WNBlocks.CHERRY_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.CHERRY_LEAVES)),10);
        weighList.add(new cherry2().setCustomLog( WNBlocks.CHERRY_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.CHERRY_LEAVES)),10);
        weighList.add(new cherry3().setCustomLog( WNBlocks.CHERRY_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.CHERRY_LEAVES)),10);
        weighList.add(new cherry4().setCustomLog( WNBlocks.CHERRY_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.CHERRY_LEAVES)),10);
        weighList.add(new tree_oak2().setCustomLog( WNBlocks.CHERRY_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.CHERRY_LEAVES)),10);
        weighList.add(new tree_oak5().setCustomLog( WNBlocks.CHERRY_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.CHERRY_LEAVES)),10);
        SchemTree cherryTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();

        weighList.add(new cherry1().setCustomLog( WNBlocks.CHERRY_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.CHERRY_PINK_LEAVES)),10);
        weighList.add(new cherry2().setCustomLog( WNBlocks.CHERRY_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.CHERRY_PINK_LEAVES)),10);
        weighList.add(new cherry3().setCustomLog( WNBlocks.CHERRY_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.CHERRY_PINK_LEAVES)),10);
        weighList.add(new cherry4().setCustomLog( WNBlocks.CHERRY_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.CHERRY_PINK_LEAVES)),10);
        weighList.add(new tree_oak2().setCustomLog( WNBlocks.CHERRY_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.CHERRY_PINK_LEAVES)),10);
        weighList.add(new tree_oak5().setCustomLog( WNBlocks.CHERRY_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.CHERRY_PINK_LEAVES)),10);
        SchemTree cherryPinkTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();

        weighList.add(new cherry1().setCustomLog( WNBlocks.CHERRY_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.CHERRY_WHITE_LEAVES)),10);
        weighList.add(new cherry2().setCustomLog( WNBlocks.CHERRY_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.CHERRY_WHITE_LEAVES)),10);
        weighList.add(new cherry3().setCustomLog( WNBlocks.CHERRY_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.CHERRY_WHITE_LEAVES)),10);
        weighList.add(new cherry4().setCustomLog( WNBlocks.CHERRY_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.CHERRY_WHITE_LEAVES)),10);
        weighList.add(new tree_oak2().setCustomLog( WNBlocks.CHERRY_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.CHERRY_WHITE_LEAVES)),10);
        weighList.add(new tree_oak5().setCustomLog( WNBlocks.CHERRY_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.CHERRY_WHITE_LEAVES)),10);

        SchemTree cherryWhiteTrees = new SchemTree(weighList);

        weighList = new TreeWeighList();

        weighList.add(new ebony1().setCustomLog( WNBlocks.EBONY_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.EBONY_LEAVES)),10);
        weighList.add(new ebony2().setCustomLog( WNBlocks.EBONY_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.EBONY_LEAVES)),10);
        weighList.add(new ebony3().setCustomLog( WNBlocks.EBONY_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.EBONY_LEAVES)),10);
        weighList.add(new ebony4().setCustomLog( WNBlocks.EBONY_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.EBONY_LEAVES)),10);

        SchemTree ebonyTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();

        weighList.add(new eucalyptus_1(),10);
        weighList.add(new eucalyptus_2(),10);
        weighList.add(new eucalyptus_3(),10);
        weighList.add(new eucalyptus_4(),10);
        weighList.add(new eucalyptus_5(),10);
        weighList.add(new eucalyptus_6(),10);
        weighList.add(new eucalyptus_7(),10);
        weighList.add(new eucalyptus_8(),10);
        weighList.add(new eucalyptus_9(),10);
        weighList.add(new eucalyptus_10(),10);


        SchemTree eucalyptusTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new tree_taiga14().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.FIR_LEAVES)),10);
        weighList.add(new tree_taiga15().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.FIR_LEAVES)),10);
        weighList.add(new tree_taiga16().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.FIR_LEAVES)),10);
        weighList.add(new tree_taiga17().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.FIR_LEAVES)),10);
        weighList.add(new tree_taiga18().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.FIR_LEAVES)),10);
        weighList.add(new tree_fir1().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.FIR_LEAVES)),10);
        weighList.add(new tree_fir9().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.FIR_LEAVES)),10);
        weighList.add(new tree_fir18().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.FIR_LEAVES)),2);


        SchemTree firTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new silver_fir1(),10);
        weighList.add(new silver_fir2(),10);
        weighList.add(new silver_fir3(),10);
        weighList.add(new silver_fir4(),10);


        SchemTree firSilverTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new hazel1(),10);
        weighList.add(new hazel2(),10);
        weighList.add(new hazel3(),10);
        weighList.add(new hazel4(),10);


        SchemTree hazelTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new tree_hornbeam1().setCustomLog(Blocks.OAK_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.HORNBEAM_LEAVES)),10);
        weighList.add(new tree_hornbeam3().setCustomLog(Blocks.OAK_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.HORNBEAM_LEAVES)),10);
        weighList.add(new tree_hornbeam5().setCustomLog(Blocks.OAK_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.HORNBEAM_LEAVES)),10);
        weighList.add(new tree_hornbeam7().setCustomLog(Blocks.OAK_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.HORNBEAM_LEAVES)),10);
        SchemTree hornbeamTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new jacaranda1(),10);
        weighList.add(new jacaranda2(),10);
        weighList.add(new jacaranda3(),10);
        weighList.add(new jacaranda4(),10);
        SchemTree jacarandaTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new tree_larch1().setCustomLog( WNBlocks.LARCH_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.LARCH_LEAVES)),10);
        weighList.add(new tree_larch2().setCustomLog( WNBlocks.LARCH_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.LARCH_LEAVES)),10);
        weighList.add(new tree_larch3().setCustomLog( WNBlocks.LARCH_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.LARCH_LEAVES)),10);
        weighList.add(new tree_larch5().setCustomLog( WNBlocks.LARCH_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.LARCH_LEAVES)),10);
        weighList.add(new tree_larch6().setCustomLog( WNBlocks.LARCH_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.LARCH_LEAVES)),10);
        weighList.add(new tree_larch7().setCustomLog( WNBlocks.LARCH_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.LARCH_LEAVES)),10);
        weighList.add(new tree_larch8().setCustomLog( WNBlocks.LARCH_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.LARCH_LEAVES)),10);
        weighList.add(new tree_larch9().setCustomLog( WNBlocks.LARCH_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.LARCH_LEAVES)),10);


        SchemTree larchTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new mahogany1().setCustomLog(WNBlocks.MAHOGANY_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.MAHOGANY_LEAVES)),10);
        weighList.add(new mahogany2().setCustomLog(WNBlocks.MAHOGANY_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.MAHOGANY_LEAVES)),10);
        weighList.add(new mahogany3().setCustomLog(WNBlocks.MAHOGANY_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.MAHOGANY_LEAVES)),10);
        weighList.add(new mahogany4().setCustomLog(WNBlocks.MAHOGANY_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.MAHOGANY_LEAVES)),10);

        SchemTree mahoganyTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new mangrove1().setCustomLog( WNBlocks.MANGROVE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.MANGROVE_LEAVES)),10);
        weighList.add(new mangrove2().setCustomLog( WNBlocks.MANGROVE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.MANGROVE_LEAVES)),10);
        weighList.add(new mangrove3().setCustomLog( WNBlocks.MANGROVE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.MANGROVE_LEAVES)),10);
        weighList.add(new mangrove4().setCustomLog( WNBlocks.MANGROVE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.MANGROVE_LEAVES)),10);
        weighList.add(new mangrove5().setCustomLog( WNBlocks.MANGROVE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.MANGROVE_LEAVES)),10);

        SchemTree mangroveTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new tree_oak8().setCustomLog( WNBlocks.MAPLE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_LEAVES)),10);
        weighList.add(new tree_oak9().setCustomLog( WNBlocks.MAPLE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_LEAVES)),10);
        weighList.add(new tree_oak10().setCustomLog( WNBlocks.MAPLE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_LEAVES)),10);
        weighList.add(new tree_oak11().setCustomLog( WNBlocks.MAPLE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_LEAVES)),10);


        SchemTree mapleTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new tree_oak8().setCustomLog( WNBlocks.MAPLE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_RED_LEAVES)),10);
        weighList.add(new tree_oak9().setCustomLog( WNBlocks.MAPLE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_RED_LEAVES)),10);
        weighList.add(new tree_oak10().setCustomLog( WNBlocks.MAPLE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_RED_LEAVES)),10);
        weighList.add(new tree_oak11().setCustomLog( WNBlocks.MAPLE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_RED_LEAVES)),10);


        SchemTree mapleRedTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new tree_oak8().setCustomLog( WNBlocks.MAPLE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_ORANGE_LEAVES)),10);
        weighList.add(new tree_oak9().setCustomLog( WNBlocks.MAPLE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_ORANGE_LEAVES)),10);
        weighList.add(new tree_oak10().setCustomLog( WNBlocks.MAPLE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_ORANGE_LEAVES)),10);
        weighList.add(new tree_oak11().setCustomLog( WNBlocks.MAPLE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_ORANGE_LEAVES)),10);


        SchemTree mapleOrangeTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new tree_oak8().setCustomLog( WNBlocks.MAPLE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_YELLOW_LEAVES)),10);
        weighList.add(new tree_oak9().setCustomLog( WNBlocks.MAPLE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_YELLOW_LEAVES)),10);
        weighList.add(new tree_oak10().setCustomLog( WNBlocks.MAPLE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_YELLOW_LEAVES)),10);
        weighList.add(new tree_oak11().setCustomLog( WNBlocks.MAPLE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_YELLOW_LEAVES)),10);


        SchemTree mapleYellowTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new tree_oak8().setCustomLog( WNBlocks.MAPLE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_BROWN_LEAVES)),10);
        weighList.add(new tree_oak9().setCustomLog( WNBlocks.MAPLE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_BROWN_LEAVES)),10);
        weighList.add(new tree_oak10().setCustomLog( WNBlocks.MAPLE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_BROWN_LEAVES)),10);
        weighList.add(new tree_oak11().setCustomLog( WNBlocks.MAPLE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_BROWN_LEAVES)),10);


        SchemTree mapleBrownTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new tree_palm1().setCustomLog( WNBlocks.PALM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),10);
        weighList.add(new tree_palm2().setCustomLog( WNBlocks.PALM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),10);
        weighList.add(new tree_palm3().setCustomLog( WNBlocks.PALM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),10);
        weighList.add(new tree_palm4().setCustomLog( WNBlocks.PALM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),10);
        weighList.add(new tree_palm5().setCustomLog( WNBlocks.PALM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),10);
        weighList.add(new tree_palm6().setCustomLog( WNBlocks.PALM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),10);
        weighList.add(new tree_palm7().setCustomLog( WNBlocks.PALM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),10);
        weighList.add(new tree_palm8().setCustomLog( WNBlocks.PALM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),10);
        weighList.add(new tree_palm9().setCustomLog( WNBlocks.PALM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),10);
        weighList.add(new tree_palm10().setCustomLog( WNBlocks.PALM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),10);
        weighList.add(new tree_palm11().setCustomLog( WNBlocks.PALM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),10);
        weighList.add(new tree_palm12().setCustomLog( WNBlocks.PALM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),10);
        weighList.add(new tree_palm13().setCustomLog( WNBlocks.PALM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),10);
        weighList.add(new tree_palm14().setCustomLog( WNBlocks.PALM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),10);
        weighList.add(new tree_palm15().setCustomLog( WNBlocks.PALM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),10);
        weighList.add(new tree_palm16().setCustomLog( WNBlocks.PALM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),10);
        weighList.add(new tree_palm17().setCustomLog( WNBlocks.PALM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),10);

        SchemTree palmTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new pear1(),10);
        weighList.add(new pear2(),10);
        weighList.add(new pear3(),10);
        SchemTree pearTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new tree_pine1().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),10);
        weighList.add(new tree_pine2().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),10);
        weighList.add(new tree_pine3().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),10);
        weighList.add(new tree_pine4().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),10);
        weighList.add(new tree_pine5().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),10);
        weighList.add(new tree_pine6().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),10);

        SchemTree pineTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new tree_oak22().setCustomLog( WNBlocks.PLUM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PLUM_LEAVES)),10);
        weighList.add(new tree_oak5().setCustomLog( WNBlocks.PLUM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PLUM_LEAVES)),10);

        SchemTree plumTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new tree_oak22().setCustomLog( WNBlocks.PLUM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.MIRABELLE_PLUM_LEAVES)),10);
        weighList.add(new tree_oak5().setCustomLog( WNBlocks.PLUM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.MIRABELLE_PLUM_LEAVES)),10);

        SchemTree mirabellePlumTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new tree_birch10().setCustomLog(Blocks.OAK_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.POPLAR_LEAVES)),10);

        SchemTree poplarTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new tree_redwood1().setCustomLog( WNBlocks.REDWOOD_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.REDWOOD_LEAVES)),10);
        weighList.add(new tree_redwood2().setCustomLog( WNBlocks.REDWOOD_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.REDWOOD_LEAVES)),10);
        weighList.add(new tree_redwood3().setCustomLog( WNBlocks.REDWOOD_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.REDWOOD_LEAVES)),10);
        weighList.add(new tree_redwood4().setCustomLog( WNBlocks.REDWOOD_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.REDWOOD_LEAVES)),10);

        SchemTree redwoodTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();

        weighList.add(new tree_oak18().setCustomLog(Blocks.OAK_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.ROWAN_LEAVES_RED)),10);
        weighList.add(new tree_oak19().setCustomLog(Blocks.OAK_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.ROWAN_LEAVES_RED)),10);
        SchemTree rowanTreesRed = new SchemTree(weighList);

        weighList.add(new tree_oak18().setCustomLog(Blocks.OAK_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.ROWAN_LEAVES_ORANGE)),10);
        weighList.add(new tree_oak19().setCustomLog(Blocks.OAK_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.ROWAN_LEAVES_ORANGE)),10);
        SchemTree rowanTreesOrange = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new tree_willow1().setCustomLog(WNBlocks.WILLOW_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.WILLOW_LEAVES)),10);
        weighList.add(new tree_willow2().setCustomLog(WNBlocks.WILLOW_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.WILLOW_LEAVES)),10);
        weighList.add(new tree_willow3().setCustomLog(WNBlocks.WILLOW_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.WILLOW_LEAVES)),10);
        weighList.add(new tree_willow4().setCustomLog(WNBlocks.WILLOW_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.WILLOW_LEAVES)),10);
        weighList.add(new tree_willow5().setCustomLog(WNBlocks.WILLOW_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.WILLOW_LEAVES)),10);
        weighList.add(new tree_willow6().setCustomLog(WNBlocks.WILLOW_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.WILLOW_LEAVES)),10);
        weighList.add(new tree_willow7().setCustomLog(WNBlocks.WILLOW_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.WILLOW_LEAVES)),10);
        weighList.add(new tree_willow8().setCustomLog(WNBlocks.WILLOW_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.WILLOW_LEAVES)),10);
        weighList.add(new tree_willow9().setCustomLog(WNBlocks.WILLOW_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.WILLOW_LEAVES)),10);
        weighList.add(new tree_willow10().setCustomLog(WNBlocks.WILLOW_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.WILLOW_LEAVES)),10);
        weighList.add(new tree_willow11().setCustomLog(WNBlocks.WILLOW_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.WILLOW_LEAVES)),10);
        weighList.add(new tree_willow12().setCustomLog(WNBlocks.WILLOW_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.WILLOW_LEAVES)),10);
        weighList.add(new tree_willow13().setCustomLog(WNBlocks.WILLOW_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.WILLOW_LEAVES)),10);
        SchemTree willowTrees = new SchemTree(weighList);

        //CITRUS
        weighList = new TreeWeighList();
        weighList.add(new citrus1().setCustomLog(WNBlocks.CITRUS_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.LEMON_LEAVES)),10);
        weighList.add(new citrus2().setCustomLog(WNBlocks.CITRUS_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.LEMON_LEAVES)),10);
        SchemTree lemonTrees= new SchemTree(weighList);
        weighList = new TreeWeighList();

        weighList.add(new citrus1().setCustomLog(WNBlocks.CITRUS_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.ORANGE_LEAVES)),10);
        weighList.add(new citrus3().setCustomLog(WNBlocks.CITRUS_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.ORANGE_LEAVES)),10);

        SchemTree orangeTrees= new SchemTree(weighList);
        weighList = new TreeWeighList();

        weighList.add(new citrus2().setCustomLog(WNBlocks.CITRUS_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.GRAPE_FRUIT_LEAVES)),10);
        weighList.add(new citrus4().setCustomLog(WNBlocks.CITRUS_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.GRAPE_FRUIT_LEAVES)),10);
        SchemTree grapefruitTrees= new SchemTree(weighList);
        weighList = new TreeWeighList();

        weighList.add(new banana1().setCustomLog(WNBlocks.PALM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.BANANA_LEAVES)),10);
        weighList.add(new banana2().setCustomLog(WNBlocks.PALM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.BANANA_LEAVES)),10);
        weighList.add(new banana3().setCustomLog(WNBlocks.PALM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.BANANA_LEAVES)),10);
        weighList.add(new banana4().setCustomLog(WNBlocks.PALM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.BANANA_LEAVES)),10);

        SchemTree bananaTrees= new SchemTree(weighList);
        weighList = new TreeWeighList();

        weighList.add(new citrus1().setCustomLog(WNBlocks.CITRUS_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.LIME_LEAVES)),10);
        weighList.add(new citrus2().setCustomLog(WNBlocks.CITRUS_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.LIME_LEAVES)),10);

        SchemTree limeTrees= new SchemTree(weighList);
        weighList = new TreeWeighList();

        weighList.add(new olive1(),10);
        weighList.add(new olive2(),10);
        weighList.add(new olive3(),10);
        weighList.add(new olive4(),10);
        SchemTree oliveTrees= new SchemTree(weighList);
        weighList = new TreeWeighList();

        weighList.add(new citrus1().setCustomLog(WNBlocks.CITRUS_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PEACH_LEAVES)),10);
        weighList.add(new citrus3().setCustomLog(WNBlocks.CITRUS_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PEACH_LEAVES)),10);

        SchemTree peachTrees= new SchemTree(weighList);
        weighList = new TreeWeighList();

        weighList.add(new citrus3().setCustomLog(WNBlocks.CITRUS_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.POMEGRANATE_LEAVES)),10);
        weighList.add(new citrus4().setCustomLog(WNBlocks.CITRUS_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.POMEGRANATE_LEAVES)),10);

        SchemTree pomegranateTrees= new SchemTree(weighList);
        weighList = new TreeWeighList();

        weighList.add(new citrus1().setCustomLog(WNBlocks.CITRUS_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.MANGO_LEAVES)),10);
        weighList.add(new citrus2().setCustomLog(WNBlocks.CITRUS_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.MANGO_LEAVES)),10);

        SchemTree mangoTrees= new SchemTree(weighList);

        weighList.add(new nuytsia1(),10);
        weighList.add(new nuytsia2(),10);
        weighList.add(new nuytsia3(),10);
        weighList.add(new nuytsia4(),10);
        weighList.add(new nuytsia5(),10);
        weighList.add(new nuytsia6(),10);
        SchemTree nuytsiaTrees= new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new magnolia1(),10);
        weighList.add(new magnolia2(),10);
        weighList.add(new magnolia3(),10);
        weighList.add(new magnolia4(),10);
        weighList.add(new magnolia5(),10);
        SchemTree magnoliaTrees= new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new forsythia1(),10);
        weighList.add(new forsythia2(),10);
        weighList.add(new forsythia3(),10);
        weighList.add(new forsythia4(),10);
        weighList.add(new forsythia5(),10);
        SchemTree forsythiaTrees= new SchemTree(weighList);
        saplings = new Block[]{
                WNBlocks.APPLE_SAPLING = new SaplingBase(appleTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("apple_sapling")),
                WNBlocks.PARADISE_APPLE_SAPLING = new SaplingBase(paradiseAppleTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("paradise_apple_sapling")),
                WNBlocks.ASPEN_SAPLING = new SaplingBase(aspenTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("aspen_sapling")),
                WNBlocks.BAOBAB_SAPLING = new SaplingBase(baobabTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("baobab_sapling")),
                WNBlocks.BEECH_SAPLING = new SaplingBase(beechTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("beech_sapling")),
                WNBlocks.PURPLE_BEECH_SAPLING = new SaplingBase(purpleBeechTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("purple_beech_sapling")),
                WNBlocks.CEDAR_SAPLING = new SaplingBase(cedarTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("cedar_sapling")),
                WNBlocks.CHERRY_SAPLING = new SaplingBase(cherryTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("cherry_sapling")),
                WNBlocks.CHERRY_PINK_SAPLING = new SaplingBase(cherryPinkTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("cherry_pink_sapling")),
                WNBlocks.CHERRY_WHITE_SAPLING = new SaplingBase(cherryWhiteTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("cherry_white_sapling")),
                WNBlocks.EBONY_SAPLING = new SaplingBase(ebonyTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("ebony_sapling")),
                WNBlocks.EUCALYPTUS_SAPLING = new SaplingBase(eucalyptusTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("eucalyptus_sapling")),
                WNBlocks.FIR_SAPLING = new SaplingBase(firTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("fir_sapling")),
                WNBlocks.FIR_SILVER_SAPLING = new SaplingBase(firSilverTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("fir_silver_sapling")),
                WNBlocks.HAZEL_SAPLING = new SaplingBase(hazelTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("hazel_sapling")),
                WNBlocks.HORNBEAM_SAPLING = new SaplingBase(hornbeamTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("hornbeam_sapling")),
                WNBlocks.JACARANDA_SAPLING = new SaplingBase(jacarandaTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("jacaranda_sapling")),
                WNBlocks.LARCH_SAPLING = new SaplingBase(larchTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("larch_sapling")),
                WNBlocks.MAHOGANY_SAPLING = new SaplingBase(mahoganyTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("mahogany_sapling")),
                WNBlocks.MANGROVE_SAPLING = new SaplingBase(mangroveTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("mangrove_sapling")),
                WNBlocks.MAPLE_SAPLING = new SaplingBase(mapleTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("maple_sapling")),
                WNBlocks.MAPLE_RED_SAPLING = new SaplingBase(mapleRedTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("maple_red_sapling")),
                WNBlocks.MAPLE_ORANGE_SAPLING = new SaplingBase(mapleOrangeTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("maple_orange_sapling")),
                WNBlocks.MAPLE_YELLOW_SAPLING = new SaplingBase(mapleYellowTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("maple_yellow_sapling")),
                WNBlocks.MAPLE_BROWN_SAPLING = new SaplingBase(mapleBrownTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("maple_brown_sapling")),
                WNBlocks.PALM_SAPLING = new SaplingBase(palmTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("palm_sapling")),
                WNBlocks.PEAR_SAPLING = new SaplingBase(pearTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("pear_sapling")),
                WNBlocks.PINE_SAPLING = new SaplingBase(pineTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("pine_sapling")),
                WNBlocks.PLUM_SAPLING = new SaplingBase(plumTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("plum_sapling")),
                WNBlocks.MIRABELLE_PLUM_SAPLING = new SaplingBase(mirabellePlumTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("mirabelle_plum_sapling")),
                WNBlocks.POPLAR_SAPLING = new SaplingBase(poplarTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("poplar_sapling")),
                WNBlocks.REDWOOD_SAPLING = new SaplingBase(redwoodTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("redwood_sapling")),
                WNBlocks.ROWAN_SAPLING_RED = new SaplingBase(rowanTreesRed, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("rowan_sapling_red")),
                WNBlocks.ROWAN_SAPLING_ORANGE = new SaplingBase(rowanTreesOrange, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("rowan_sapling_orange")),
                WNBlocks.WILLOW_SAPLING = new SaplingBase(willowTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("willow_sapling")),
                WNBlocks.LEMON_SAPLING = new SaplingBase(lemonTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("lemon_sapling")),
                WNBlocks.ORANGE_SAPLING = new SaplingBase(orangeTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("orange_sapling")),
                WNBlocks.GRAPE_FRUIT_SAPLING = new SaplingBase(grapefruitTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("grape_fruit_sapling")),
                WNBlocks.BANANA_SAPLING = new SaplingBase(bananaTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("banana_sapling")),
                WNBlocks.LIME_SAPLING = new SaplingBase(limeTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("lime_sapling")),
                WNBlocks.OLIVE_SAPLING = new SaplingBase(oliveTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("olive_sapling")),
                WNBlocks.PEACH_SAPLING = new SaplingBase(peachTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("peach_sapling")),
                WNBlocks.POMEGRANATE_SAPLING = new SaplingBase(pomegranateTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("pomegranate_sapling")),
                WNBlocks.MANGO_SAPLING = new SaplingBase(mangoTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("mango_sapling")),
                WNBlocks.NUYTSIA_SAPLING = new SaplingBase(nuytsiaTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("nuytsia_sapling")),
                WNBlocks.MAGNOLIA_SAPLING = new SaplingBase(magnoliaTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("magnolia_sapling")),
                WNBlocks.FORSYTHIA_SAPLING = new SaplingBase(forsythiaTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("forsythia_sapling"))


        };
    }

    public Block[] getSaplings() {
        return saplings;
    }
}
