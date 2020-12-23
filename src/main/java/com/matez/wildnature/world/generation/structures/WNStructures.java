package com.matez.wildnature.world.generation.structures;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.world.generation.structures.ambient.WNSeaCaveStructure;
import com.matez.wildnature.world.generation.structures.utils.StructurePlacement;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.CompletableFuture;

public class WNStructures {
    public static ArrayList<CompletableFuture<?>> futures = new ArrayList<>();
    public static LinkedHashMap<String, WNAbstractStructure> REGISTRY = new LinkedHashMap<>();
    public static int count = 0;

    //AMBIENT
    //--- sea caves
    public static final WNSeaCaveStructure SEA_CAVE_1 = new WNSeaCaveStructure(loc("ambient/sea_caves/sea_cave1"), StructurePlacement.SURFACE, Direction.WEST);
    public static final WNSeaCaveStructure SEA_CAVE_2 = new WNSeaCaveStructure(loc("ambient/sea_caves/sea_cave2"), StructurePlacement.SURFACE, Direction.WEST);
    public static final WNSeaCaveStructure SEA_CAVE_3 = new WNSeaCaveStructure(loc("ambient/sea_caves/sea_cave3"), StructurePlacement.SURFACE, Direction.WEST);
    public static final WNSeaCaveStructure SEA_CAVE_4 = new WNSeaCaveStructure(loc("ambient/sea_caves/sea_cave4"), StructurePlacement.SURFACE, Direction.WEST);
    public static final WNSeaCaveStructure SEA_CAVE_5 = new WNSeaCaveStructure(loc("ambient/sea_caves/sea_cave5"), StructurePlacement.SURFACE, Direction.WEST);
    public static final WNSeaCaveStructure SEA_CAVE_6 = new WNSeaCaveStructure(loc("ambient/sea_caves/sea_cave6"), StructurePlacement.SURFACE, Direction.WEST);
    public static final WNSeaCaveStructure SEA_CAVE_7 = new WNSeaCaveStructure(loc("ambient/sea_caves/sea_cave7"), StructurePlacement.SURFACE, Direction.SOUTH);



    public static void init(){
        WN.LOGGER.debug("Registering structures...");
        registerAll();
        WN.LOGGER.debug("Registered " + count + " structures.");
    }

    private static void registerAll(){
        register(SEA_CAVE_1);
        register(SEA_CAVE_2);
        register(SEA_CAVE_3);
        register(SEA_CAVE_4);
        register(SEA_CAVE_5);
        register(SEA_CAVE_6);
        register(SEA_CAVE_7);
    }

    private static void register(WNAbstractStructure structure){
        structure.init();
        REGISTRY.put(structure.getName(),structure);
        count++;
    }

    public static void finish(){
        for (CompletableFuture<?> future : futures) {
            future.join();
        }
        futures.clear();
    }

    public static LinkedHashMap<String, WNAbstractStructure> getRegistry() {
        return REGISTRY;
    }

    public static ResourceLocation loc(String path){
        return new ResourceLocation("wildnature",path);
    }
}
