package net.matez.pokeUniverseBiomeBuilder.sponge;

public class AbstractNoise {
    private double frequency, lacunarity, persistence;
    private int octaveCount, seed;
    private String module;
    public AbstractNoise(String noise){
        module=noise;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public void setLacunarity(double lacunarity) {
        this.lacunarity = lacunarity;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public void setOctaveCount(int octaveCount) {
        this.octaveCount = octaveCount;
    }

    public void setPersistence(double persistence) {
        this.persistence = persistence;
    }

    public void setSeed(int seed) {
        this.seed = seed;
    }

    public double getFrequency() {
        return frequency;
    }

    public double getLacunarity() {
        return lacunarity;
    }

    public int getOctaveCount() {
        return octaveCount;
    }

    public double getPersistence() {
        return persistence;
    }

    public int getSeed() {
        return seed;
    }

    public String getModule() {
        return module;
    }
}
