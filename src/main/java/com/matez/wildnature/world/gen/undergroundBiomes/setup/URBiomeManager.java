package com.matez.wildnature.world.gen.undergroundBiomes.setup;

import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.other.WeightedList;
import com.matez.wildnature.world.gen.noise.sponge.module.source.Voronoi;
import com.matez.wildnature.world.gen.undergroundBiomes.biomes.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;

import java.util.ArrayList;
import java.util.Random;

public class URBiomeManager {
    public static Voronoi biomeNoise = new Voronoi();
    public static WeightedList<URBiome> riverBiomes = new WeightedList<>();
    public static ArrayList<URBiomeEntry> riverBiomesCategorized = new ArrayList<>();

    public static URBiome STONE_RIVER = register(new URBiome("stone_river",null,null,30,1f,0x123123,0x321321));
    public static URBiome BASALT_RIVER = register(new BasaltRiver("basalt_river",null,null,7,1f));
    public static URBiome CRYSTAL_RIVER = register(new CrystalRiver("crystal_river",null,null,2,1f));
    public static URBiome SKELETON_RIVER = register(new SkeletonRiver("skeleton_river",Biome.Category.JUNGLE,null,1,1f));
    public static URBiome STALAGMITE_RIVER = register(new StalagmiteRiver("stalagmite_river",null,null,5,1f,0x123123,0x321321));
    public static URBiome SANDSTONE_RIVER = register(new SandstoneRiver("sandstone_river", Biome.Category.DESERT,null,30,1f,0x123123,0x321321));
    public static URBiome TROPICAL_RIVER = register(new TropicalRiver("tropical_river", Biome.Category.JUNGLE,null,30,1f,0x123123,0x321321));
    public static URBiome ICY_RIVER = register(new IcyRiver("icy_river", null, Biome.TempCategory.COLD,15,1f,0x123123,0x321321));

    //public static URBiome STALAGMITE_CAVERN = register(new StalagmiteCavern("stalagmite_cavern",null,null,3,1f,0x123123,0x321321));

    static {
        URBiome[] biomes = new URBiome[]{
                STONE_RIVER,
                BASALT_RIVER,
                CRYSTAL_RIVER,
                SKELETON_RIVER,
                STALAGMITE_RIVER,
                SANDSTONE_RIVER,
                TROPICAL_RIVER,
                ICY_RIVER
        };

        biomeNoise.setFrequency(0.004);

        for (Biome.TempCategory tempCategory : Biome.TempCategory.values()) {
            for (Biome.Category value : Biome.Category.values()) {
                WeightedList<URBiome> list = new WeightedList<>();
                riverBiomes.forEach((urBiome -> {
                    if (urBiome.getCategory() == null) {
                        if(urBiome.getTempCategory()==null){
                            list.add(urBiome, riverBiomes.getRarityFor(urBiome));
                        }else{
                            if (tempCategory == urBiome.getTempCategory()) {
                                list.add(urBiome, riverBiomes.getRarityFor(urBiome));
                            }
                        }
                    } else {
                        if (value == urBiome.getCategory()) {
                            if(urBiome.getTempCategory()==null){
                                list.add(urBiome, riverBiomes.getRarityFor(urBiome));
                            }else{
                                if (tempCategory == urBiome.getTempCategory()) {
                                    list.add(urBiome, riverBiomes.getRarityFor(urBiome));
                                }
                            }
                        }
                    }
                }));
                riverBiomesCategorized.add(new URBiomeEntry(value,tempCategory, list));
            }
        }

    }

    private static URBiome register(URBiome biome){
        riverBiomes.add(biome,biome.getRarity());
        return biome;
    }

    public static URBiome getBiomeAt(IChunk chunk, BlockPos pos, long seed){
        Biome.Category category = Utilities.getBiomeOnPos(chunk.getBiomes(),pos.getX(),pos.getZ()).getCategory();
        Biome.TempCategory tempCategory = Utilities.getBiomeOnPos(chunk.getBiomes(),pos.getX(),pos.getZ()).getTempCategory();
        URBiomeEntry entry = null;
        for (URBiomeEntry urBiomeEntry : riverBiomesCategorized) {
            if(urBiomeEntry.tempCategory==tempCategory){
                if(urBiomeEntry.category==category){
                    entry=urBiomeEntry;
                }
            }
        }
        if(entry==null || entry.list.isEmpty()){
            return STONE_RIVER;
        }
        biomeNoise.setSeed((int)seed);
        URBiome biome = (URBiome)Utilities.getWeightedEntry(entry.list,new Random(seed+(int)(biomeNoise.getValue(pos.getX(),pos.getY(),pos.getZ())*1000)));
        return biome;
    }


    public static class URBiomeEntry{

        private Biome.Category category;
        private Biome.TempCategory tempCategory;
        private WeightedList<URBiome> list;
        public URBiomeEntry(Biome.Category category, Biome.TempCategory tempCategory, WeightedList<URBiome> list){
            this.category=category;
            this.tempCategory=tempCategory;
            this.list=list;
        }
    }
}
