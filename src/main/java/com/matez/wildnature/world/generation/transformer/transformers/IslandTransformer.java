package com.matez.wildnature.world.generation.transformer.transformers;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.other.Utilities;
import com.matez.wildnature.world.generation.biome.setup.grid.BiomeGroup;
import com.matez.wildnature.world.generation.biome.setup.grid.IslandBiome;
import com.matez.wildnature.world.generation.grid.Cell;
import com.matez.wildnature.world.generation.transformer.BiomeTransformer;
import net.minecraft.world.biome.Biome;

import java.util.ArrayList;
import java.util.Random;

public class IslandTransformer extends BiomeTransformer {
    private IslandBiome.IslandType type;
    private ArrayList<IslandBiome> islandBiomes = new ArrayList<>();
    public IslandTransformer(IslandBiome.IslandType type){
        this.type = type;
        for (IslandBiome islandBiome : IslandBiome.getIslandBiomes()) {
            if(islandBiome.getType() == type) {
                for(int i = 0; i < islandBiome.getWeight(); i++){
                    islandBiomes.add(islandBiome);
                }
            }
        }
        WN.LOGGER.debug("Added island biomes for island type " + type.name() + ": " + islandBiomes.toString());
    }

    @Override
    protected BiomeGroup bgApply(BiomeGroup oldBiomeGroup, TempCategory tempCategory, WetCategory wetCategory, Cell cell, MainBiomeTransformer.TerrainCategory category, float identity) {
        if(!islandBiomes.isEmpty()) {
            Random random = new Random((long) ((type == IslandBiome.IslandType.SMALL ? cell.smallIslandCellIdentity : cell.bigIslandCellIdentity) * 1000000));
            if ((type == IslandBiome.IslandType.BIG && Utilities.rint(0, IslandBiome.RARITY_BIG, random) == 0) || (type == IslandBiome.IslandType.SMALL && Utilities.rint(0, IslandBiome.RARITY_SMALL, random) == 0)) {
                ArrayList<BiomeGroup> passingBiomeGroups = new ArrayList<>();
                for (IslandBiome islandBiome : islandBiomes) {
                    boolean passing = false;
                    for (Biome ocean : islandBiome.getOceans()) {
                        if (oldBiomeGroup.getBaseBiome() == ocean) {
                            passing = true;
                            break;
                        }
                    }
                    if (passing) {
                        passingBiomeGroups.add(islandBiome.getIslandBiome());
                    }
                }

                if(passingBiomeGroups.isEmpty()){
                    return oldBiomeGroup;
                }

                return getBiomeGroup(passingBiomeGroups, type == IslandBiome.IslandType.SMALL ? cell.smallIslandCellIdentity : cell.bigIslandCellIdentity);
            }
        }
        return oldBiomeGroup;
    }
}
