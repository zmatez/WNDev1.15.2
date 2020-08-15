package com.matez.wildnature.world.gen.provider;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.matez.wildnature.world.gen.biomes.setup.WNGenSettings;
import com.matez.wildnature.world.gen.chunk.WNChunkGeneratorOverworld;
import com.matez.wildnature.world.gen.chunk.WNChunkGeneratorType;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.JsonOps;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.nbt.NBTDynamicOps;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.biome.provider.*;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.OverworldDimension;
import net.minecraft.world.gen.*;

public class WildNatureDimension extends OverworldDimension {
    public WildNatureDimension(World worldIn, DimensionType typeIn) {
        super(worldIn, typeIn);
    }

    @Override
    public ChunkGenerator<? extends GenerationSettings> createChunkGenerator() {
        ChunkGeneratorType<NetherGenSettings, NetherChunkGenerator> chunkgeneratortype2 = ChunkGeneratorType.CAVES;
        ChunkGeneratorType<EndGenerationSettings, EndChunkGenerator> chunkgeneratortype3 = ChunkGeneratorType.FLOATING_ISLANDS;
        ChunkGeneratorType<WNGenSettings, WNChunkGeneratorOverworld> wildnature = WNChunkGeneratorType.WILDNATURE;
        BiomeProviderType<SingleBiomeProviderSettings, SingleBiomeProvider> biomeprovidertype = BiomeProviderType.FIXED;
        BiomeProviderType<OverworldBiomeProviderSettings, WildNatureBiomeProvider> bpt = WNBiomeProviderType.WILDNATURE;



        BiomeProvider biomeprovider = null;
        JsonElement jsonelement = Dynamic.convert(NBTDynamicOps.INSTANCE, JsonOps.INSTANCE, this.world.getWorldInfo().getGeneratorOptions());
        JsonObject jsonobject = jsonelement.getAsJsonObject();
        JsonObject jsonobject1 = jsonobject.getAsJsonObject("biome_source");

        System.out.println("Using WNBPT");
        OverworldBiomeProviderSettings overworldbiomeprovidersettings1 = bpt.createSettings(world.getWorldInfo()).setGeneratorSettings(new WNGenSettings());
        biomeprovider = bpt.create(overworldbiomeprovidersettings1);

        BlockState blockstate = Blocks.STONE.getDefaultState();
        BlockState blockstate1 = Blocks.WATER.getDefaultState();
        JsonObject jsonobject3 = jsonobject.getAsJsonObject("chunk_generator");
        if (jsonobject3 != null && jsonobject3.has("options")) {
            JsonObject jsonobject4 = jsonobject3.getAsJsonObject("options");
            if (jsonobject4.has("default_block")) {
                String s = jsonobject4.getAsJsonPrimitive("default_block").getAsString();
                blockstate = Registry.BLOCK.getOrDefault(new ResourceLocation(s)).getDefaultState();
            }

            if (jsonobject4.has("default_fluid")) {
                String s1 = jsonobject4.getAsJsonPrimitive("default_fluid").getAsString();
                blockstate1 = Registry.BLOCK.getOrDefault(new ResourceLocation(s1)).getDefaultState();
            }
        }

        if (jsonobject3 != null && jsonobject3.has("type")) {
            ChunkGeneratorType<?, ?> chunkgeneratortype5 = Registry.CHUNK_GENERATOR_TYPE.getOrDefault(new ResourceLocation(jsonobject3.getAsJsonPrimitive("type").getAsString()));
            if (ChunkGeneratorType.CAVES == chunkgeneratortype5) {
                NetherGenSettings nethergensettings = chunkgeneratortype2.createSettings();
                nethergensettings.setDefaultBlock(blockstate);
                nethergensettings.setDefaultFluid(blockstate1);
                return chunkgeneratortype2.create(this.world, biomeprovider, nethergensettings);
            }

            if (ChunkGeneratorType.FLOATING_ISLANDS == chunkgeneratortype5) {
                EndGenerationSettings endgenerationsettings = chunkgeneratortype3.createSettings();
                endgenerationsettings.setSpawnPos(new BlockPos(0, 64, 0));
                endgenerationsettings.setDefaultBlock(blockstate);
                endgenerationsettings.setDefaultFluid(blockstate1);
                return chunkgeneratortype3.create(this.world, biomeprovider, endgenerationsettings);
            }
        }

        WNGenSettings overworldgensettings1 = wildnature.createSettings();
        overworldgensettings1.setDefaultBlock(Blocks.STONE.getDefaultState());
        overworldgensettings1.setDefaultFluid(Blocks.WATER.getDefaultState());
        return wildnature.create(this.world, biomeprovider, overworldgensettings1);
    }
}
