package com.matez.wildnature.registry;

import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.blocks.SignBase;
import com.matez.wildnature.blocks.WallSignBase;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class SignRegistry {

    Block[] sign;
    public SignRegistry(){
        sign = new Block[]{
                WNBlocks.ROSACEAE_SIGN = new SignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("rosaceae_sign"),
                WNBlocks.ROSACEAE_WALL_SIGN = new WallSignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("rosaceae_wall_sign"),
                //BlocksList.ASPEN_SIGN = new SignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("aspen_sign"),
                //BlocksList.ASPEN_WALL_SIGN = new WallSignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("aspen_wall_sign"),
                WNBlocks.BAOBAB_SIGN = new SignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("baobab_sign"),
                WNBlocks.BAOBAB_WALL_SIGN = new WallSignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("baobab_wall_sign"),
                WNBlocks.BEECH_SIGN = new SignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("beech_sign"),
                WNBlocks.BEECH_WALL_SIGN = new WallSignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("beech_wall_sign"),
                WNBlocks.CEDAR_SIGN = new SignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("cedar_sign"),
                WNBlocks.CEDAR_WALL_SIGN = new WallSignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("cedar_wall_sign"),
                WNBlocks.CHERRY_SIGN = new SignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("cherry_sign"),
                WNBlocks.CHERRY_WALL_SIGN = new WallSignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("cherry_wall_sign"),
                WNBlocks.EBONY_SIGN = new SignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("ebony_sign"),
                WNBlocks.EBONY_WALL_SIGN = new WallSignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("ebony_wall_sign"),
                //BlocksList.EUCALYPTUS_SIGN = new SignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("eucalyptus_sign"),
                //BlocksList.EUCALYPTUS_WALL_SIGN = new WallSignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("eucalyptus_wall_sign"),
                //BlocksList.FIR_SIGN = new SignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("fir_sign"),
                //BlocksList.FIR_WALL_SIGN = new WallSignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("fir_wall_sign"),
                //BlocksList.HAZEL_SIGN = new SignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("hazel_sign"),
                //BlocksList.HAZEL_WALL_SIGN = new WallSignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("hazel_wall_sign"),
                //BlocksList.HORNBEAM_SIGN = new SignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("hornbeam_sign"),
                //BlocksList.HORNBEAM_WALL_SIGN = new WallSignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("hornbeam_wall_sign"),
                WNBlocks.JACARANDA_SIGN = new SignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("jacaranda_sign"),
                WNBlocks.JACARANDA_WALL_SIGN = new WallSignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("jacaranda_wall_sign"),
                WNBlocks.LARCH_SIGN = new SignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("larch_sign"),
                WNBlocks.LARCH_WALL_SIGN = new WallSignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("larch_wall_sign"),
                WNBlocks.MAHOGANY_SIGN = new SignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("mahogany_sign"),
                WNBlocks.MAHOGANY_WALL_SIGN = new WallSignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("mahogany_wall_sign"),
                WNBlocks.MANGROVE_SIGN = new SignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("mangrove_sign"),
                WNBlocks.MANGROVE_WALL_SIGN = new WallSignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("mangrove_wall_sign"),
                WNBlocks.MAPLE_SIGN = new SignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("maple_sign"),
                WNBlocks.MAPLE_WALL_SIGN = new WallSignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("maple_wall_sign"),
                WNBlocks.PALM_SIGN = new SignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("palm_sign"),
                WNBlocks.PALM_WALL_SIGN = new WallSignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("palm_wall_sign"),
                //BlocksList.PEAR_SIGN = new SignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("pear_sign"),
                //BlocksList.PEAR_WALL_SIGN = new WallSignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("pear_wall_sign"),
                //BlocksList.PINE_SIGN = new SignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("pine_sign"),
                //BlocksList.PINE_WALL_SIGN = new WallSignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("pine_wall_sign"),
                WNBlocks.PLUM_SIGN = new SignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("plum_sign"),
                WNBlocks.PLUM_WALL_SIGN = new WallSignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("plum_wall_sign"),
                //BlocksList.POPLAR_SIGN = new SignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("poplar_sign"),
                //BlocksList.POPLAR_WALL_SIGN = new WallSignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("poplar_wall_sign"),
                WNBlocks.REDWOOD_SIGN = new SignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("redwood_sign"),
                WNBlocks.REDWOOD_WALL_SIGN = new WallSignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("redwood_wall_sign"),
                //BlocksList.ROWAN_SIGN = new SignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("rowan_sign"),
                //BlocksList.ROWAN_WALL_SIGN = new WallSignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("rowan_wall_sign"),
                WNBlocks.WILLOW_SIGN = new SignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("willow_sign"),
                WNBlocks.WILLOW_WALL_SIGN = new WallSignBase(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.5F,0.25F)).setRegistryName("willow_wall_sign")
        };

    }

    public Block[] getSign() {
        return sign;
    }
}
