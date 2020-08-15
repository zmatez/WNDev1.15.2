package com.matez.wildnature.world.gen.biomes.layer;

import com.matez.wildnature.world.gen.biomes.setup.WNBiomes;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.layer.traits.IAreaTransformer2;
import net.minecraft.world.gen.layer.traits.IDimOffset0Transformer;
import net.minecraftforge.common.BiomeDictionary;

import java.util.ArrayList;

public class WNMixRiverLayer implements IAreaTransformer2, IDimOffset0Transformer {
    public static WNMixRiverLayer INSTANCE = new WNMixRiverLayer();

    private static final int FROZEN_RIVER = Registry.BIOME.getId(WNBiomes.FrozenRiver);
    private static final int AMAZON_RIVER = Registry.BIOME.getId(WNBiomes.AmazonRiver);
    private static final int NILE_RIVER = Registry.BIOME.getId(WNBiomes.NileRiver);
    //private static final int SNOWY_TUNDRA = Registry.BIOME.getId(Biomes.SNOWY_TUNDRA);
    private static final int MUSHROOM_FIELDS = Registry.BIOME.getId(Biomes.MUSHROOM_FIELDS);
    private static final int MUSHROOM_FIELD_SHORE = Registry.BIOME.getId(Biomes.MUSHROOM_FIELD_SHORE);

    private static final int RIVER = Registry.BIOME.getId(WNBiomes.River);

    private static final int POLDERS = Registry.BIOME.getId(WNBiomes.Polders);
    private static final int POLDERS_EDGE = Registry.BIOME.getId(WNBiomes.PoldersEdge);

    private static final int JUNGLE = Registry.BIOME.getId(Biomes.JUNGLE);
    private static final int JUNGLE2 = Registry.BIOME.getId(Biomes.JUNGLE_EDGE);
    private static final int JUNGLE3 = Registry.BIOME.getId(Biomes.JUNGLE_HILLS);
    private static final int JUNGLE4 = Registry.BIOME.getId(Biomes.BAMBOO_JUNGLE);
    private static final int JUNGLE5 = Registry.BIOME.getId(Biomes.BAMBOO_JUNGLE_HILLS);
    private static final int JUNGLE6 = Registry.BIOME.getId(Biomes.MODIFIED_JUNGLE);
    private static final int JUNGLE7 = Registry.BIOME.getId(Biomes.MODIFIED_JUNGLE_EDGE);

    private static final int DESERT = Registry.BIOME.getId(Biomes.DESERT);
    private static final int DESERT2 = Registry.BIOME.getId(Biomes.DESERT_HILLS);
    private static final int DESERT3 = Registry.BIOME.getId(Biomes.DESERT_LAKES);

    private static final int CANYONS = Registry.BIOME.getId(WNBiomes.Canyons);
    private static final int GRAND_CANYON = Registry.BIOME.getId(WNBiomes.GrandCanyon);
    private static final int CANYON_RIVER = Registry.BIOME.getId(WNBiomes.CanyonRiver);

    private static final int ICELANDS = Registry.BIOME.getId(WNBiomes.Icelands);
    private static final int ICELAND_RIVER = Registry.BIOME.getId(WNBiomes.IcelandRiver);

    private static final int DAINTREE_CLIFFS = Registry.BIOME.getId(WNBiomes.DaintreeCliffs);
    private static final int DAINTREE_RIVER = Registry.BIOME.getId(WNBiomes.DaintreeRiver);

    private static final int CRACOW_GORGE = Registry.BIOME.getId(WNBiomes.CracowGorge);
    private static final int TATRA_STREAM = Registry.BIOME.getId(WNBiomes.TatraStream);

    public int apply(INoiseRandom p_215723_1_, IArea p_215723_2_, IArea p_215723_3_, int p_215723_4_, int p_215723_5_) {
        int i = p_215723_2_.getValue(this.func_215721_a(p_215723_4_), this.func_215722_b(p_215723_5_));
        int j = p_215723_3_.getValue(this.func_215721_a(p_215723_4_), this.func_215722_b(p_215723_5_));
        Biome surfaceBiome = Registry.BIOME.getByValue(i);
        ArrayList<Biome> junglebiomes = new ArrayList<>();
        junglebiomes.addAll(BiomeDictionary.getBiomes(BiomeDictionary.Type.JUNGLE));

        ArrayList<Integer> jb = new ArrayList<>();
        for(int x = 0; x<junglebiomes.size(); x++){
            jb.add(Registry.BIOME.getId(junglebiomes.get(x)));
        }

        ArrayList<Biome> desertbiomes = new ArrayList<>();
        desertbiomes.addAll(BiomeDictionary.getBiomes(BiomeDictionary.Type.SANDY));

        ArrayList<Integer> db = new ArrayList<>();
        for(int x = 0; x<desertbiomes.size(); x++){
            db.add(Registry.BIOME.getId(desertbiomes.get(x)));
        }

        if (WNLayerUtil.isOcean(i)) {
            return i;
        }else if(i==GRAND_CANYON || i ==CANYONS){
            return i;
        }else if(i==ICELANDS){
            return i;
        }else if(i==DAINTREE_CLIFFS){
            return i;
        }else if(i==CRACOW_GORGE){
            return i;
        }else if(i==POLDERS || i==POLDERS_EDGE){
            return i;
        }else if (j == RIVER) {
            if(Registry.BIOME.getId(surfaceBiome.getRiver())==CANYON_RIVER){
                return CANYON_RIVER;
            }else if(Registry.BIOME.getId(surfaceBiome.getRiver())==ICELAND_RIVER){
                return ICELAND_RIVER;
            }else if(Registry.BIOME.getId(surfaceBiome.getRiver())==DAINTREE_RIVER){
                return DAINTREE_RIVER;
            }else if(Registry.BIOME.getId(surfaceBiome.getRiver())==TATRA_STREAM){
                return TATRA_STREAM;
            }
            else if (surfaceBiome.getPrecipitation()== Biome.RainType.SNOW) {
                return FROZEN_RIVER;
            } else if(Registry.BIOME.getId(surfaceBiome.getRiver())==AMAZON_RIVER || i == JUNGLE || i == JUNGLE2|| i == JUNGLE3|| i == JUNGLE4|| i == JUNGLE5|| i == JUNGLE6|| i == JUNGLE7 || jb.contains(i)){
                return AMAZON_RIVER;

            } else if(Registry.BIOME.getId(surfaceBiome.getRiver())==NILE_RIVER || i == DESERT || i == DESERT2 || i == DESERT3 || db.contains(i)){
                return NILE_RIVER;

            }else if(j==POLDERS || j==POLDERS_EDGE){
                return POLDERS_EDGE;
            }
            else {
                return i != MUSHROOM_FIELDS && i != MUSHROOM_FIELD_SHORE ? j & 255 : MUSHROOM_FIELD_SHORE;
            }
        } else {
            return i;
        }
    }
}
