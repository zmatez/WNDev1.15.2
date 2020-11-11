package com.matez.wildnature.world.generation.biome.setup;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.world.generation.chunk.terrain.Terrain;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import java.util.ArrayList;
import java.util.Arrays;

public class BiomeGroup {
    private int weight;
    private Biome baseBiome;
    private SubBiome[] subBiomes;
    private Biome[] weightedBiomes;

    private BiomeGroup(int weight, Biome baseBiome, SubBiome... subBiomes){
        this.weight = weight;
        this.baseBiome = baseBiome;
        this.subBiomes = subBiomes;
        this.weightedBiomes = initWeightedBiomes();
    }

    public Biome getBaseBiome() {
        return baseBiome;
    }

    public SubBiome[] getSubBiomes() {
        return subBiomes;
    }

    public int getWeight() {
        return weight;
    }

    public Biome[] initWeightedBiomes(){
        ArrayList<Biome> biomeGroups = new ArrayList<>();
        for (SubBiome subBiome : getSubBiomes()) {
            for(int i = 0; i < subBiome.getWeight(); i++){
                biomeGroups.add(subBiome.getBiome());
            }
        }
        for(int i = 0; i < 10; i++){
            biomeGroups.add(getBaseBiome());
        }


        return biomeGroups.toArray(new Biome[0]);
    }

    public Biome[] getWeightedBiomes(){
        return weightedBiomes;
    }

    @Override
    public String toString() {
        return "BiomeGroup{" +
                "weight=" + weight +
                ", baseBiome=" + baseBiome +
                ", subBiomes=" + Arrays.toString(subBiomes) +
                '}';
    }

    public static BiomeGroup[] guess(Terrain.Category category, BiomeDictionary.Type[] allowedTypes, BiomeDictionary.Type[] deniedTypes){
        ArrayList<BiomeGroup> groups = new ArrayList<>();
        //Terrain.Category categoryBefore = category.getIndex() == 0 ? category : Terrain.Category.getByIndex(category.getIndex() - 1);
        //Terrain.Category categoryAfter = category.getIndex() == Terrain.Category.values().length-1 ? category : Terrain.Category.getByIndex(category.getIndex() + 1);

        for (BiomeTerrain terrain : BiomeTerrain.getTerrains()) {
            if(!terrain.canGuess()){
                continue;
            }
            BiomeGroup group = terrain.getGroup();
            if(allowedTypes.length != 0) {
                if (!BiomeDictionary.getTypes(group.getBaseBiome()).containsAll(Arrays.asList(allowedTypes))) {
                    continue;
                }
            }

            if(deniedTypes.length != 0) {
                boolean containsDenied = false;
                for (BiomeDictionary.Type deniedType : deniedTypes) {
                    if (BiomeDictionary.getTypes(group.getBaseBiome()).contains(deniedType)) {
                        containsDenied = true;
                        break;
                    }
                }
                if (containsDenied) {
                    continue;
                }
            }

            BiomeGroup newGroup = null;
            float baseBiomeDepth = group.baseBiome.getDepth();
            Terrain.Category depthCategory = getCategoryByDepth(baseBiomeDepth);
            SubBiome maxBiome = null;
            float maxBiomeDepth = 0;
            Terrain.Category maxBiomeCategory = null;
            SubBiome minBiome = null;
            float minBiomeDepth = 0;
            Terrain.Category minBiomeCategory = null;
            for (SubBiome subBiome : group.getSubBiomes()) {
                float depth = subBiome.getBiome().getDepth();
                if(depth > maxBiomeDepth || maxBiome == null){
                    maxBiomeDepth = depth;
                    maxBiome = subBiome;
                    maxBiomeCategory = getCategoryByDepth(maxBiomeDepth);
                }
                if(depth < minBiomeDepth || minBiome == null){
                    minBiomeDepth = depth;
                    minBiome = subBiome;
                    minBiomeCategory = getCategoryByDepth(minBiomeDepth);
                }
            }

            ArrayList<SubBiome> subBiomes = new ArrayList<>(Arrays.asList(group.getSubBiomes()));

            if(depthCategory == category){
                newGroup = group;
            }else if(maxBiomeCategory == category){
                subBiomes.remove(maxBiome);
                subBiomes.add(new SubBiome(group.getBaseBiome(),maxBiome.getWeight()));
                int weight = group.weight - (group.weight/3);
                if(weight == 0){
                    weight = 1;
                }else if(weight < 0){
                    continue;
                }
                newGroup = new BiomeGroup(weight, maxBiome.getBiome(), subBiomes.toArray(new SubBiome[0]));
            }else if(minBiomeCategory == category){
                subBiomes.remove(minBiome);
                subBiomes.add(new SubBiome(group.getBaseBiome(),minBiome.getWeight()));
                int weight = group.weight - (group.weight/3);
                if(weight == 0){
                    weight = 1;
                }else if(weight < 0){
                    continue;
                }
                newGroup = new BiomeGroup(weight, minBiome.getBiome(), subBiomes.toArray(new SubBiome[0]));
            }

            if(newGroup != null){
                groups.add(newGroup);
            }
        }
        WN.LOGGER.info("Guessed " + groups.size() + " groups for terrain " + category.getName() + " and types: " + Arrays.toString(allowedTypes));
        return groups.toArray(new BiomeGroup[0]);
    }

    private static float getDepthByCategory(Terrain.Category category){
        float biomeDepth = 0;
        if(category == Terrain.Category.DEEP_OCEAN){
            biomeDepth = -1.8F;
        }else if(category == Terrain.Category.OCEAN){
            biomeDepth = -1.2F;
        }else if(category == Terrain.Category.SEA){
            biomeDepth = -0.4F;
        }else if(category == Terrain.Category.SHORE){
            biomeDepth = 0.0F;
        }else if(category == Terrain.Category.LOWLANDS){
            biomeDepth = 0.3F;
        }else if(category == Terrain.Category.MIDLANDS){
            biomeDepth = 0.7F;
        }else if(category == Terrain.Category.HIGHLANDS){
            biomeDepth = 1.1F;
        }else if(category == Terrain.Category.MOUNTAINS){
            biomeDepth = 1.8F;
        }
        return biomeDepth;
    }

    private static Terrain.Category getCategoryByDepth(float depth){
        if(depth < -1.2F){
            return Terrain.Category.DEEP_OCEAN;
        }else if(depth < -0.4){
            return Terrain.Category.OCEAN;
        }else if(depth < 0.0F){
            return Terrain.Category.SEA;
        }else if (depth < 0.3F) {
            return Terrain.Category.SHORE;
        }else if(depth < 0.7){
            return Terrain.Category.LOWLANDS;
        }else if(depth < 1.1F){
            return Terrain.Category.MIDLANDS;
        }else if(depth < 1.5F){
            return Terrain.Category.HIGHLANDS;
        }else{
            return Terrain.Category.MOUNTAINS;
        }
    }

    public static class Builder{
        private ArrayList<BiomeGroup> groups = new ArrayList<>();

        public Builder add(int weight, Biome baseBiome, SubBiome... subBiomes){
            groups.add(new BiomeGroup(weight,baseBiome, subBiomes));
            return this;
        }

        /**
         * default weight = 10
         */
        public Builder add(Biome baseBiome, SubBiome... subBiomes){
            groups.add(new BiomeGroup(10,baseBiome, subBiomes));
            return this;
        }

        public BiomeGroup[] build(){
            return groups.toArray(new BiomeGroup[0]);
        }
    }

    public static class SingleBuilder{
        public static BiomeGroup configure(int weight, Biome baseBiome, SubBiome... subBiomes){
            return new BiomeGroup(weight,baseBiome,subBiomes);
        }

        /**
         * default weight = 10
         */
        public static BiomeGroup configure(Biome baseBiome, SubBiome... subBiomes){
            return new BiomeGroup(10,baseBiome,subBiomes);
        }
    }
}