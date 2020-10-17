package com.matez.wildnature.world.gen.biomes.setup;

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
    public static BiomeVariants RIVER = new BiomeVariants(SmallGroup.RIVER,LargeGroup.RIVER);
    public static BiomeVariants LAKE = new BiomeVariants(SmallGroup.BODY,LargeGroup.LAKE);
    public static BiomeVariants SHORE = new BiomeVariants(SmallGroup.BODY,LargeGroup.LAND);
    public static BiomeVariants OCEAN = new BiomeVariants(SmallGroup.BODY,LargeGroup.OCEAN);
    public static BiomeVariants getVariantsFor(Biome biome){
        if(BiomeDictionary.hasType(biome, BiomeDictionary.Type.OCEAN)){
            return OCEAN;
        }else if(BiomeDictionary.hasType(biome, BiomeDictionary.Type.BEACH)){
            return SHORE;
        }else if(BiomeDictionary.hasType(biome, BiomeDictionary.Type.RIVER)){
            return RIVER;
        }else if(biome == WNBiomes.ColdLake || biome == WNBiomes.DriedLake || biome == WNBiomes.FrozenLake || biome == WNBiomes.TropicalLake || biome == WNBiomes.WarmLake){
            return LAKE;
        }else{
            return LAND;
        }
    }
}