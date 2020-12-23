package com.matez.wildnature.world.generation.biome.setup.grid;

import com.matez.wildnature.init.WN;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import java.util.ArrayList;
import java.util.Arrays;

public class BiomeTerrain {
    public static int ids = 0;
    /**
     * Terrain registry
     */
    public static ArrayList<BiomeTerrain> terrains = new ArrayList<>();

    /**
     * Registeres a BiomeGroup
     * @param group BiomeGroup (baseBiome + all subbiomes)
     * @param canGuess can be guessed by BiomeGroup.guess()
     * @param types biome dictionary. Applies to all biomes in group
     */
    public static void register(BiomeGroup group, boolean canGuess, BiomeDictionary.Type... types){
        ArrayList<BiomeDictionary.Type> ovTypes = new ArrayList<>(Arrays.asList(types));
        //terraforged needs it:
        ovTypes.add(BiomeDictionary.Type.OVERWORLD);
        terrains.add(new BiomeTerrain(group,canGuess,ovTypes.toArray(new BiomeDictionary.Type[0])));
    }

    public static void register(BiomeGroup group, BiomeDictionary.Type... types){
        ArrayList<BiomeDictionary.Type> ovTypes = new ArrayList<>(Arrays.asList(types));
        //terraforged needs it:
        ovTypes.add(BiomeDictionary.Type.OVERWORLD);
        terrains.add(new BiomeTerrain(group,true,ovTypes.toArray(new BiomeDictionary.Type[0])));
    }

    public static void register(BiomeGroup group, boolean canGuess){
        terrains.add(new BiomeTerrain(group,canGuess,BiomeDictionary.getTypes(group.getBaseBiome()).toArray(new BiomeDictionary.Type[0])));
    }

    public static void register(BiomeGroup group){
        terrains.add(new BiomeTerrain(group,true,BiomeDictionary.getTypes(group.getBaseBiome()).toArray(new BiomeDictionary.Type[0])));
    }

    public static void unregister(Biome biome){
        ArrayList<BiomeTerrain> terrainsToUnregister = new ArrayList<>();
        for (BiomeTerrain terrain : terrains) {
            if(terrain.getGroup().getBaseBiome() == biome){
                terrainsToUnregister.add(terrain);
            }else{
                for (SubBiome subBiome : terrain.getGroup().getSubBiomes().clone()) {
                    if(subBiome.getBiome() == biome){
                        WN.LOGGER.info("--- Removing blacklisted SubBiome " + biome.getRegistryName() + " from group " + terrain.getGroup().getName() + ":" + terrain.getGroup().getId());
                        ArrayList<SubBiome> subBiomes = new ArrayList<>(Arrays.asList(terrain.getGroup().getSubBiomes()));
                        subBiomes.remove(subBiome);
                        terrain.getGroup().setSubBiomes(subBiomes.toArray(new SubBiome[0]));
                    }
                }
            }
        }
        for (BiomeTerrain biomeTerrain : terrainsToUnregister) {
            WN.LOGGER.info("--- Removing blacklisted Biome " + biome.getRegistryName() + " and the whole group " + biomeTerrain.getGroup().getName() + ":" + biomeTerrain.getGroup().getId());
            terrains.remove(biomeTerrain);
        }
    }

    public static BiomeGroup getGroupByName(String name){
        for (BiomeTerrain terrain : terrains) {
            if(terrain.getGroup().getName().equals(name)){
                return terrain.getGroup();
            }
        }
        return null;
    }

    private BiomeGroup group;
    private boolean canGuess;
    private BiomeDictionary.Type[] types;
    private BiomeTerrain(BiomeGroup group, boolean canGuess, BiomeDictionary.Type[] types){
        this.group = group;
        this.canGuess = canGuess;
        this.types = types;

        if(types.length == 0){
            WN.LOGGER.warn("No types registered for group " + group.toString());
        }

        BiomeDictionary.addTypes(group.getBaseBiome(),types);
        for (SubBiome subBiome : group.getSubBiomes()) {
            ArrayList<BiomeDictionary.Type> typesArraylist = new ArrayList<>();
            typesArraylist.addAll(Arrays.asList(types));
            typesArraylist.addAll(Arrays.asList(subBiome.getAddionalTypes()));
            BiomeDictionary.addTypes(subBiome.getBiome(),typesArraylist.toArray(new BiomeDictionary.Type[0]));
            typesArraylist.clear();
        }
    }

    public static ArrayList<BiomeTerrain> getTerrains() {
        return terrains;
    }

    public BiomeGroup getGroup() {
        return group;
    }

    public BiomeDictionary.Type[] getTypes() {
        return types;
    }

    public boolean canGuess() {
        return canGuess;
    }
}
