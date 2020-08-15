package com.matez.wildnature.world.gen.feature.configs;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class WNBlobConfig implements IFeatureConfig {
    public final BlockState state;
    public final int startRadius;
    public final boolean surfaceBlob;
    public final boolean undergroundBlob;
    public boolean flatInTerrain = false;

    public WNBlobConfig(BlockState state, int startRadius, boolean surfaceBlob, boolean undergroundBlob) {

        this.state = state;
        this.startRadius = startRadius;
        this.surfaceBlob=surfaceBlob;
        this.undergroundBlob=undergroundBlob;
    }

    public WNBlobConfig(BlockState state, int startRadius, boolean surfaceBlob, boolean undergroundBlob, boolean flatInTerrain) {

        this.state = state;
        this.startRadius = startRadius;
        this.surfaceBlob=surfaceBlob;
        this.undergroundBlob=undergroundBlob;
        this.flatInTerrain=flatInTerrain;
    }

    public <T> Dynamic<T> serialize(DynamicOps<T> p_214634_1_) {
        return new Dynamic(p_214634_1_, p_214634_1_.createMap(ImmutableMap.of(p_214634_1_.createString("state"), BlockState.serialize(p_214634_1_, this.state).getValue(), p_214634_1_.createString("start_radius"), p_214634_1_.createInt(this.startRadius),p_214634_1_.createString("surface_blob"), p_214634_1_.createBoolean(this.surfaceBlob),p_214634_1_.createString("underground_blob"), p_214634_1_.createBoolean(this.undergroundBlob))));
    }

    public static <T> WNBlobConfig deserialize(Dynamic<T> p_214682_0_) {
        BlockState lvt_1_1_ = (BlockState)p_214682_0_.get("state").map(BlockState::deserialize).orElse(Blocks.AIR.getDefaultState());
        int lvt_2_1_ = p_214682_0_.get("start_radius").asInt(0);
        boolean sb = p_214682_0_.get("surface_blob").asBoolean(true);
        boolean ub = p_214682_0_.get("underground_blob").asBoolean(true);
        return new WNBlobConfig(lvt_1_1_, lvt_2_1_,sb,ub);
    }
}
