package com.matez.wildnature.registry;

import net.minecraft.client.particle.PortalParticle;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleType;
import net.minecraft.util.registry.Registry;

public class ParticleRegistry {

    public static final BasicParticleType DUNGEON_HEART = register("wildnature:dungeon_heart", false);
    public static final BasicParticleType CRYSTAL = register("wildnature:crystal", false);
    public static final BasicParticleType CRYSTAL_SPARK = register("wildnature:crystal_spark", false);
    public static final BasicParticleType GEYSER = register("wildnature:geyser", false);
    public static final BasicParticleType STEAM = register("wildnature:steam", false);
    public static final BasicParticleType FLOWERING_LEAF_WHITE_DUST = register("wildnature:flowering_leaf_white_dust", false);
    public static final ParticleType<BlockParticleData> POLLEN = register("wildnature:pollen", BlockParticleData.DESERIALIZER);
    public static final BasicParticleType WISTERIA_PINK = register("wildnature:wisteria_pink", false);
    public static final BasicParticleType SLIMESHROOM_GREEN = register("wildnature:slimeshroom_green", false);
    public static final BasicParticleType SLIMESHROOM_BLUE = register("wildnature:slimeshroom_blue", false);
    public static final BasicParticleType THERMAL_SMOKE = register("wildnature:thermal_smoke", false);
    public static final BasicParticleType FUZZBALL_EXPLOSION = register("wildnature:fuzzball_explosion", false);

    private static BasicParticleType register(String key, boolean alwaysShow) {
        System.out.println("Registering particle: " + key);
        return (BasicParticleType) Registry.<ParticleType<? extends IParticleData>>register(Registry.PARTICLE_TYPE, key, new BasicParticleType(alwaysShow));
    }

    private static <T extends IParticleData> ParticleType<T> register(String key, IParticleData.IDeserializer<T> deserializer) {
        return Registry.register(Registry.PARTICLE_TYPE, key, new ParticleType<>(false, deserializer));
    }
}
