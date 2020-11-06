package com.matez.wildnature.world.generation.generators.functions.interpolation;

import com.matez.wildnature.world.generation.biome.setup.BiomeVariants;
import net.minecraft.world.biome.Biome;

public class LerpConfiguration {
    private Biome biome;

    private float customDepth;
    private float customScale;
    private BiomeVariants customVariants;

    private boolean customDepthApplied = false;
    private boolean customScaleApplied = false;
    private boolean customVariantsApplied = false;

    public LerpConfiguration(Biome biome) {
        this.biome = biome;
    }

    public Biome getBiome() {
        return biome;
    }

    public void setCustomDepth(float customDepth) {
        customDepthApplied = true;
        this.customDepth = customDepth;
    }

    public void setCustomScale(float customScale) {
        customScaleApplied = true;
        this.customScale = customScale;
    }

    public void setCustomVariants(BiomeVariants customVariants) {
        customVariantsApplied = true;
        this.customVariants = customVariants;
    }

    public float getDepth() {
        return customDepthApplied ? customDepth : biome.getDepth();
    }

    public float getScale() {
        return customScaleApplied ? customScale : biome.getScale();
    }

    public BiomeVariants getBiomeVariants() {
        return customVariantsApplied ? customVariants : BiomeVariants.getVariantsFor(biome);
    }
}
