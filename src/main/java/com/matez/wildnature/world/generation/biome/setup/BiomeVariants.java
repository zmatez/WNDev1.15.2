package com.matez.wildnature.world.generation.biome.setup;

import com.matez.wildnature.world.generation.biome.registry.WNBiomes;
import com.matez.wildnature.world.generation.generators.functions.interpolation.LerpConfiguration;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

public class BiomeVariants {
    private final SmallGroup smallGroup;
    private final LargeGroup largeGroup;

    public BiomeVariants(SmallGroup smallGroup, LargeGroup largeGroup) {
        this.smallGroup = smallGroup;
        this.largeGroup = largeGroup;
    }

    public LargeGroup getLargeGroup() {
        return largeGroup;
    }

    public SmallGroup getSmallGroup() {
        return smallGroup;
    }

    public enum LargeGroup {
        LAND, OCEAN, RIVER, LAKE;

        public static final int SIZE = LargeGroup.values().length;
    }

    public enum SmallGroup {
        BODY, RIVER;

        public static final int SIZE = SmallGroup.values().length;
    }

    public static BiomeVariants LAND = new BiomeVariants(SmallGroup.BODY,LargeGroup.LAND);
    public static BiomeVariants PLATEAU = new BiomeVariants(SmallGroup.RIVER,LargeGroup.LAND);
    public static BiomeVariants RIVER = new BiomeVariants(SmallGroup.RIVER,LargeGroup.RIVER);
    public static BiomeVariants LAKE = new BiomeVariants(SmallGroup.BODY,LargeGroup.LAKE);
    public static BiomeVariants SHORE = new BiomeVariants(SmallGroup.BODY,LargeGroup.LAKE);
    public static BiomeVariants OCEAN = new BiomeVariants(SmallGroup.BODY,LargeGroup.OCEAN);
    public static BiomeVariants SMALL_ISLAND = new BiomeVariants(SmallGroup.RIVER,LargeGroup.OCEAN);

    //custom
    public static BiomeVariants PATH = new BiomeVariants(SmallGroup.RIVER,LargeGroup.RIVER);

    public static BiomeVariants getVariantsFor(Biome biome){
        if(biome == WNBiomes.RiverValleySharp){
            return SHORE;
        }else if(biome == WNBiomes.RiverValleySmooth){
            return LAND;
        }
        if(biome == WNBiomes.Island || biome == WNBiomes.ForestedIsland || biome == WNBiomes.SnowyIsland || biome == WNBiomes.ParadiseIsland){
            return SMALL_ISLAND;
        }

        if(BiomeDictionary.hasType(biome, BiomeDictionary.Type.OCEAN)){
            return OCEAN;
        }else if(biome == WNBiomes.ColdLake || biome == WNBiomes.DriedLake || biome == WNBiomes.FrozenLake || biome == WNBiomes.TropicalLake || biome == WNBiomes.WarmLake|| biome == WNBiomes.MorskieOko|| biome == WNBiomes.FrozenMorskieOko){
            return LAKE;
        }else if(BiomeDictionary.hasType(biome, BiomeDictionary.Type.BEACH)){
            return SHORE;
        }else if(BiomeDictionary.hasType(biome, BiomeDictionary.Type.RIVER)){
            return RIVER;
        }else{
            if(BiomeDictionary.hasType(biome, BiomeDictionary.Type.PLATEAU)){
                return PLATEAU;
            }
            return LAND;
        }
    }

    public static BiomeVariants getVariantsFor(LerpConfiguration configuration){
        return getVariantsFor(configuration.getBiome());
    }
}