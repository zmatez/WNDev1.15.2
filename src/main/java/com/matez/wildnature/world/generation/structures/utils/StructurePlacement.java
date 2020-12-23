package com.matez.wildnature.world.generation.structures.utils;

import net.minecraft.world.IWorld;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.Heightmap;

import java.util.Random;

public enum StructurePlacement {
    SURFACE(new Placement() {
        @Override
        public int getPlacePosition(int x, int z, IChunk chunk, IWorld world, ChunkGenerator<?> chunkGenerator, Random random) {
            return chunk.getTopBlockY(Heightmap.Type.WORLD_SURFACE, x, z);
        }
    }, GenerationStage.Decoration.SURFACE_STRUCTURES);

    private Placement placement;
    private GenerationStage.Decoration generationStage;
    private StructurePlacement(Placement placement, GenerationStage.Decoration generationStage){
        this.placement = placement;
        this.generationStage = generationStage;
    }

    public GenerationStage.Decoration getGenerationStage() {
        return generationStage;
    }

    public Placement getPlacement() {
        return placement;
    }

    public static interface Placement{
        public int getPlacePosition(int x, int z, IChunk chunk, IWorld world, ChunkGenerator<?> chunkGenerator, Random random);
    }
}
