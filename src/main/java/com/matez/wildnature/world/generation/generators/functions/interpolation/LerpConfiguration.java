package com.matez.wildnature.world.generation.generators.functions.interpolation;

import com.matez.wildnature.world.generation.biome.setup.BiomeVariants;
import net.minecraft.world.biome.Biome;

import java.util.LinkedHashMap;

public class LerpConfiguration {
    private static LinkedHashMap<Biome, LerpConfiguration> cache = new LinkedHashMap<>();
    private Biome biome;

    private float customDepth;
    private float customScale;
    private BiomeVariants customVariants;

    private boolean customDepthApplied = false;
    private boolean customScaleApplied = false;
    private boolean customVariantsApplied = false;

    public static LerpConfiguration get(Biome biome){
        if (cache.containsKey(biome)) {
            return cache.get(biome);
        }else{
            return new LerpConfiguration(biome);
        }
    }

    public LerpConfiguration(Biome biome) {
        this.biome = biome;
        cache.put(biome,this);
    }

    public LerpConfiguration(Biome biome, boolean custom) {
        this.biome = biome;
        cache.put(biome,this);
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

    public LerpConfiguration clone(){
        LerpConfiguration configuration = new LerpConfiguration(this.getBiome(),true);
        if(this.customVariantsApplied){
            configuration.setCustomVariants(this.getBiomeVariants());
        }
        if(this.customScaleApplied){
            configuration.setCustomScale(this.getScale());
        }
        if(this.customDepthApplied){
            configuration.setCustomDepth(this.getDepth());
        }
        return configuration;
    }
}
