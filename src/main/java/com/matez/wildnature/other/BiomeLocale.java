package com.matez.wildnature.other;

import com.matez.wildnature.blocks.config.ConfigSettings;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.Heightmap;

public class BiomeLocale {
    public static BiomePos searchForBiome(World world, Biome biome, BlockPos startPos) {
        final int sampleSpace = 1000000 * ConfigSettings.biomeSize;
        final int maxDistance = 1000000 * ConfigSettings.biomeSize;

        int direction = -1;
        int samples = 0;
        int nextLength = sampleSpace;
        int x = startPos.getX();
        int z = startPos.getZ();
        while (nextLength / 2 <= maxDistance && samples <= 1000000) {
            final int fixedDirection = direction == -1 ? -1 : direction % 4;
            for (int i = 0; i < nextLength && samples <= 1000000; i += sampleSpace) {
                if (fixedDirection == 0) {
                    x += sampleSpace;
                } else if (fixedDirection == 1) {
                    z -= sampleSpace;
                } else if (fixedDirection == 2) {
                    x -= sampleSpace;
                } else if (fixedDirection == 3) {
                    z += sampleSpace;
                }

                final BlockPos pos = new BlockPos(x, world.getHeight(Heightmap.Type.WORLD_SURFACE, x, z), z);
                final Biome biomeAtPos = world.getChunk(pos).getBiomes().getNoiseBiome(pos.getX(),pos.getY(),pos.getZ());
                if (biomeAtPos == biome) {
                    return new BiomePos(x, z, nextLength / 2, samples, true);
                }

                samples++;
            }

            if (direction >= 0) {
                nextLength += sampleSpace;
            }
            direction++;
        }

        return new BiomePos(0, 0, nextLength / 2, samples, false);
    }

    public static class BiomePos {

        private int x;
        private int z;
        private int radius;
        private int samples;
        private boolean found;

        public BiomePos(int x, int z, int radius, int samples, boolean found) {
            this.x = x;
            this.z = z;
            this.radius = radius;
            this.samples = samples;
            this.found = found;
        }

        public int getX() {
            return x;
        }

        public int getZ() {
            return z;
        }

        public int getRadius() {
            return radius;
        }

        public int getSamples() {
            return samples;
        }

        public boolean found() {
            return found;
        }

    }
}
