package com.matez.wildnature.world.generation.generators.carves;

import com.matez.wildnature.world.generation.noise.OpenSimplex2S;
import com.matez.wildnature.world.generation.noise.fastNoise.FastNoise;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;

public class CliffGenerator {
    private FastNoise fastNoise;
    public CliffGenerator(IWorld worldIn){
        fastNoise = new FastNoise((int)worldIn.getSeed());
        fastNoise.SetFractalType(FastNoise.FractalType.RigidMulti);
        fastNoise.SetFrequency(0.05F);
    }

    public void getCliffNoise(Biome biome, int x, int z){
        double noise = fastNoise.GetSimplexFractal(x,z);
        noise = noise < 0 ? 1 - noise : (noise + 1) * 0.875;
        //TODO cliffs
    }

}
