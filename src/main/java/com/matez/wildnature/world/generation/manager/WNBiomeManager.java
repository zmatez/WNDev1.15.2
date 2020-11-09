package com.matez.wildnature.world.generation.manager;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager;

import java.util.ArrayList;

public class WNBiomeManager extends net.minecraftforge.common.BiomeManager {
    public static void removeAllBiomes(String contains) {
        ArrayList<Biome> biomes = new ArrayList<>();
        Registry.BIOME.forEach((event) -> {
            if (event.getRegistryName().toString().contains(contains)) {
                biomes.add(event);
            }
        });

        int x = 0;
        while (x < biomes.size()) {
            rb(biomes.get(x), BiomeType.ICY);
            rb(biomes.get(x), BiomeType.COOL);
            rb(biomes.get(x), BiomeType.WARM);
            rb(biomes.get(x), BiomeType.DESERT);

            x++;
        }
    }

    private static void rb(Biome biome, BiomeManager.BiomeType type) {
        if (BiomeManager.getBiomes(type) != null) {
            int x = 0;
            BiomeEntry entry = null;
            while (x < BiomeManager.getBiomes(type).size()) {
                if (BiomeManager.getBiomes(type).get(x).biome == biome) {
                    entry = BiomeManager.getBiomes(type).get(x);
                    break;
                }
                x++;
            }
            if (entry != null) {
                BiomeManager.removeBiome(type, entry);

            }
        }
    }

}
