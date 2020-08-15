package com.matez.wildnature.world.gen.biomes.setup;

import com.mojang.datafixers.DataFixer;
import net.minecraft.world.chunk.listener.IChunkStatusListener;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.world.server.ServerChunkProvider;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.DimensionSavedDataManager;

import java.io.File;
import java.util.concurrent.Executor;
import java.util.function.Supplier;

public class WNServerChunkProvider extends ServerChunkProvider {
    public WNServerChunkProvider(ServerWorld p_i51537_1_, File p_i51537_2_, DataFixer p_i51537_3_, TemplateManager p_i51537_4_, Executor p_i51537_5_, ChunkGenerator<?> p_i51537_6_, int p_i51537_7_, IChunkStatusListener p_i51537_8_, Supplier<DimensionSavedDataManager> p_i51537_9_) {
        super(p_i51537_1_, p_i51537_2_, p_i51537_3_, p_i51537_4_, p_i51537_5_, p_i51537_6_, p_i51537_7_, p_i51537_8_, p_i51537_9_);
    }
}
