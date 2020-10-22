/*
 * Work under Copyright. Licensed under the EUPL.
 * See the project README.md and LICENSE.txt for more information.
 */

package com.matez.wildnature.world.generation.chunk.primers;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.ChunkSection;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.Heightmap;

public class FastChunkPrimer implements IChunkDelegate
{
    private static final BlockState VOID_AIR = Blocks.VOID_AIR.getDefaultState();

    public static FastChunkPrimer deslowificate(IChunk chunk)
    {
        if (chunk instanceof FastChunkPrimer)
        {
            return (FastChunkPrimer) chunk;
        }
        if (chunk instanceof ChunkPrimer)
        {
            return new FastChunkPrimer((ChunkPrimer) chunk);
        }
        throw new IllegalStateException("Tried to deslowificate a chunk which could not be deslowificated! It was: " + chunk);
    }

    public static void updateChunkHeightMaps(IChunk chunk)
    {
        if (chunk instanceof FastChunkPrimer)
        {
            ((FastChunkPrimer) chunk).updateHeightMaps();
        }
    }

    private final ChunkPrimer chunk;
    private final int chunkX, chunkZ;
    private final Heightmap oceanFloorHeightMap, worldSurfaceHeightMap;
    private final BlockPos.Mutable mutablePos;

    public FastChunkPrimer(ChunkPrimer chunk)
    {
        this.chunk = chunk;
        this.chunkX = chunk.getPos().getXStart();
        this.chunkZ = chunk.getPos().getZStart();

        // This serves a dual purpose of initializing the height maps so we don't have to check that every time in setBlockState
        this.oceanFloorHeightMap = chunk.getHeightmap(Heightmap.Type.OCEAN_FLOOR_WG);
        this.worldSurfaceHeightMap = chunk.getHeightmap(Heightmap.Type.WORLD_SURFACE_WG);

        this.mutablePos = new BlockPos.Mutable();
    }

    @Override
    public IChunk getDelegate()
    {
        return chunk;
    }

    @Nullable
    @Override
    public BlockState setBlockState(BlockPos pos, BlockState state, boolean isMoving)
    {
        if (pos.getY() >= 0 && pos.getY() < 256)
        {
            ChunkSection chunkSection = chunk.getSection(pos.getY() >> 4);
            chunkSection.lock();

            int localX = pos.getX() & 15;
            int localY = pos.getY() & 15;
            int localZ = pos.getZ() & 15;

            if (state.getLightValue(chunk, pos) > 0)
            {
                mutablePos.setPos(chunkX | localX, pos.getY(), chunkZ | localZ);
                chunk.addLightPosition(mutablePos);
            }

            BlockState prevState = chunkSection.setBlockState(localX, localY, localZ, state, false);
            chunkSection.unlock();
            return prevState;
        }
        else
        {
            return VOID_AIR;
        }
    }

    public void updateHeightMaps()
    {
        int maxY = chunk.getTopFilledSegment() + 16;
        for (int localX = 0; localX < 16; ++localX)
        {
            for (int localZ = 0; localZ < 16; ++localZ)
            {
                boolean reachedTopSurface = false;
                for (int y = maxY - 1; y >= 0; --y)
                {
                    mutablePos.setPos(localX, y, localZ);
                    BlockState state = chunk.getBlockState(mutablePos);
                    if (state.getBlock() != Blocks.AIR)
                    {
                        if (!reachedTopSurface)
                        {
                            // Non-air block found, update world surface height map
                            worldSurfaceHeightMap.set(localX, localZ, y + 1);
                            reachedTopSurface = true;
                        }

                        if (Heightmap.Type.OCEAN_FLOOR_WG.getHeightLimitPredicate().test(state))
                        {
                            // Update ocean floor height map, then go to next x/z position
                            oceanFloorHeightMap.set(localX, localZ, y + 1);
                            break;
                        }
                    }
                }
            }
        }
    }
}
