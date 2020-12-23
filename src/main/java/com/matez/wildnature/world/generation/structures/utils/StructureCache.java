package com.matez.wildnature.world.generation.structures.utils;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.world.generation.structures.WNAbstractStructure;
import com.matez.wildnature.world.generation.structures.WNStructures;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.chunk.IChunk;

import java.util.LinkedHashMap;
import java.util.concurrent.CompletableFuture;

public class StructureCache {
    private static LinkedHashMap<ChunkPos, StructureCache> cache = new LinkedHashMap<>();

    private int chunkX, chunkZ;
    private String structureName;
    private int structureCenterY;
    private WNAbstractStructure structure;
    private final CompletableFuture<?> future;
    private boolean removed = false;

    public StructureCache(int chunkX, int chunkZ, String structureName, int structureCenterY) {
        this.chunkX = chunkX;
        this.chunkZ = chunkZ;
        this.structureName = structureName;
        this.structureCenterY = structureCenterY;

        future = CompletableFuture.runAsync(() -> {
            structure = WNStructures.getRegistry().get(structureName);
        });
    }

    public int getChunkX() {
        return chunkX;
    }

    public int getChunkZ() {
        return chunkZ;
    }

    public String getStructureName() {
        return structureName;
    }

    public int getStructureCenterY() {
        return structureCenterY;
    }

    public void setStructureCenterY(int structureCenterY) {
        this.structureCenterY = structureCenterY;
    }

    public WNAbstractStructure getStructure() {
        future.join();
        return structure;
    }

    public static void write(IChunk chunk, CompoundNBT nbt) {
        if (nbt.contains("scStructureName") && nbt.contains("scStructureCenterY")) {
            ChunkPos key = chunk.getPos();
            if (cache.containsKey(key)) {
                StructureCache val = cache.get(key);
                nbt.putString("scStructureName", val.structureName);
                nbt.putInt("scStructureCenterY", val.structureCenterY);
            }
        }
    }

    public static void read(IChunk chunk, CompoundNBT nbt) {
        if (nbt.contains("scStructureName") && nbt.contains("scStructureCenterY")) {
            ChunkPos key = chunk.getPos();
            if (!cache.containsKey(key)) {
                String structureName = nbt.getString("scStructureName");
                int structureCenterY = nbt.getInt("scStructureCenterY");

                StructureCache structureCache = new StructureCache(key.x, key.z, structureName, structureCenterY);
                cache.put(key, structureCache);
            }
        }
    }

    public static void create(int chunkX, int chunkZ, String structureName, int structureCenterY){
        StructureCache structureCache = new StructureCache(chunkX, chunkZ, structureName, structureCenterY);
        cache.put(new ChunkPos(chunkX,chunkZ),structureCache);
    }

    public void remove(){
        removed = true;
    }

    public static void free(IChunk chunk) {
        ChunkPos key = chunk.getPos();
        cache.remove(key);
    }

    public static StructureCache get(ChunkPos pos){
        StructureCache c = cache.get(pos);
        if(c != null){
            if(c.removed){
                WN.LOGGER.debug("Removed structure at " + pos);
                return null;
            }
            return c;
        }
        return null;
    }
}
