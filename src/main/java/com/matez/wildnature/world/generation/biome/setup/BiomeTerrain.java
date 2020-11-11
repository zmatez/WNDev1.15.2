package com.matez.wildnature.world.generation.biome.setup;

import com.matez.wildnature.init.WN;
import net.minecraftforge.common.BiomeDictionary;

import java.util.ArrayList;
import java.util.Arrays;

public class BiomeTerrain {
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
