package com.matez.wildnature.world.gen.provider;

import com.matez.wildnature.Main;
import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.gui.screen.WNWorldConfigScreen;
import com.matez.wildnature.world.gen.biomes.layer.WNBiomeLayer;
import com.matez.wildnature.world.gen.biomes.setup.WNGenSettings;
import com.matez.wildnature.world.gen.chunk.WNSimplexChunkGenerator;
import com.matez.wildnature.world.gen.chunk.WNChunkGeneratorOverworld;
import com.matez.wildnature.world.gen.chunk.WNChunkGeneratorType;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.CreateBuffetWorldScreen;
import net.minecraft.client.gui.screen.CreateFlatWorldScreen;
import net.minecraft.client.gui.screen.CreateWorldScreen;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.biome.provider.BiomeProviderType;
import net.minecraft.world.biome.provider.OverworldBiomeProviderSettings;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.layer.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.LongFunction;

public class WNWorldType extends WorldType {
    public WNWorldType(String name) {
        super(name);
    }


    public ChunkGenerator<?> createChunkGenerator(World world)
    {
        System.out.println("Generating dimension: " + world.getDimension().getType().toString());

        if(world.getDimension().getType()==DimensionType.OVERWORLD) {
            Main.wnInfo("Generating WildNature World");
            Main.runningWorld=world;
            ChunkGeneratorType<WNGenSettings, WNChunkGeneratorOverworld> gen = WNChunkGeneratorType.WILDNATURE;
            ChunkGeneratorType<NetherGenSettings, NetherChunkGenerator> genNether = ChunkGeneratorType.CAVES;
            ChunkGeneratorType<EndGenerationSettings, EndChunkGenerator> genEnd = ChunkGeneratorType.FLOATING_ISLANDS;
            ChunkGeneratorType<WNGenSettings, WNSimplexChunkGenerator> genTest = WNChunkGeneratorType.SIMPLEX_TEST;


            WNGenSettings overworldgensettings1 = gen.createSettings();
            overworldgensettings1.setDefaultBlock(Blocks.STONE.getDefaultState());
            overworldgensettings1.setDefaultFluid(Blocks.WATER.getDefaultState());

            BiomeProviderType<OverworldBiomeProviderSettings, WildNatureBiomeProvider> bpt = WNBiomeProviderType.WILDNATURE;

            OverworldBiomeProviderSettings overworldbiomeprovidersettings1 = bpt.createSettings(world.getWorldInfo()).setGeneratorSettings(new OverworldGenSettings());

            BiomeProvider provider = bpt.create(overworldbiomeprovidersettings1);

            // Change to genTest if you want the simplex generator (WNChunkGeneratorEarth + SmoothChunkGenerator)
            if(CommonConfig.generatorType.get().equals("wildnature")){
                return gen.create(world, provider, overworldgensettings1);
            }else {
                return genTest.create(world, provider, overworldgensettings1);
            }
        }else{
            return world.getDimension().createChunkGenerator();
        }
    }


    public <T extends IArea, C extends IExtendedNoiseRandom<T>> IAreaFactory<T> getBiomeLayer(IAreaFactory<T> parentLayer, OverworldGenSettings chunkSettings, LongFunction<C> contextFactory)
    {
        parentLayer = (new WNBiomeLayer(getWorldType(), chunkSettings)).apply(contextFactory.apply(200L), parentLayer);
        parentLayer = AddBambooForestLayer.INSTANCE.apply(contextFactory.apply(1001L), parentLayer);
        parentLayer = LayerUtil.repeat(1000L, ZoomLayer.NORMAL, parentLayer, 2, contextFactory);
        parentLayer = EdgeBiomeLayer.INSTANCE.apply(contextFactory.apply(1000L), parentLayer);
        return parentLayer;
    }

    @OnlyIn(Dist.CLIENT)
    public void onCustomizeButton(Minecraft mc, CreateWorldScreen gui)
    {
        if (this == WorldType.FLAT)
            mc.displayGuiScreen(new CreateFlatWorldScreen(gui, gui.chunkProviderSettingsJson));
        else if (this == WorldType.BUFFET)
            mc.displayGuiScreen(new CreateBuffetWorldScreen(gui, gui.chunkProviderSettingsJson));
        else if(this == Main.WNWorldType)
            mc.displayGuiScreen(new WNWorldConfigScreen(gui, gui.chunkProviderSettingsJson));
    }


    //"{\"coordinateScale\":684.412,\"heightScale\":1.0,\"lowerLimitScale\":512.0,\"upperLimitScale\":512.0,\"depthNoiseScaleX\":200.0,\"depthNoiseScaleZ\":200.0,\"depthNoiseScaleExponent\":0.5,\"mainNoiseScaleX\":5000.0,\"mainNoiseScaleY\":5000.0,\"mainNoiseScaleZ\":5000.0,\"baseSize\":8.5,\"stretchY\":12.0,\"biomeDepthWeight\":1.0,\"biomeDepthOffset\":0.0,\"biomeScaleWeight\":5.0140843,\"biomeScaleOffset\":0.0,\"seaLevel\":63,\"useCaves\":true,\"useDungeons\":true,\"dungeonChance\":8,\"useStrongholds\":true,\"useVillages\":true,\"useMineShafts\":true,\"useTemples\":true,\"useRavines\":true,\"useWaterLakes\":true,\"waterLakeChance\":4,\"useLavaLakes\":true,\"lavaLakeChance\":50,\"useLavaOceans\":false,\"fixedBiome\":-1,\"biomeSize\":8,\"riverSize\":5,\"dirtSize\":33,\"dirtCount\":10,\"dirtMinHeight\":0,\"dirtMaxHeight\":256,\"gravelSize\":33,\"gravelCount\":8,\"gravelMinHeight\":0,\"gravelMaxHeight\":256,\"graniteSize\":33,\"graniteCount\":10,\"graniteMinHeight\":0,\"graniteMaxHeight\":80,\"dioriteSize\":33,\"dioriteCount\":10,\"dioriteMinHeight\":0,\"dioriteMaxHeight\":80,\"andesiteSize\":33,\"andesiteCount\":10,\"andesiteMinHeight\":0,\"andesiteMaxHeight\":80,\"coalSize\":17,\"coalCount\":20,\"coalMinHeight\":0,\"coalMaxHeight\":128,\"ironSize\":9,\"ironCount\":20,\"ironMinHeight\":0,\"ironMaxHeight\":64,\"goldSize\":9,\"goldCount\":2,\"goldMinHeight\":0,\"goldMaxHeight\":32,\"redstoneSize\":8,\"redstoneCount\":8,\"redstoneMinHeight\":0,\"redstoneMaxHeight\":16,\"diamondSize\":8,\"diamondCount\":1,\"diamondMinHeight\":0,\"diamondMaxHeight\":16,\"lapisSize\":7,\"lapisCount\":1,\"lapisCenterHeight\":16,\"lapisSpread\":16}";
    //{"coordinateScale":684.412,"heightScale":684.412,"lowerLimitScale":512.0,"upperLimitScale":512.0,"depthNoiseScaleX":200.0,"depthNoiseScaleZ":200.0,"depthNoiseScaleExponent":0.5,"mainNoiseScaleX":80.0,"mainNoiseScaleY":160.0,"mainNoiseScaleZ":80.0,"baseSize":8.5,"stretchY":12.0,"biomeDepthWeight":1.0,"biomeDepthOffset":0.0,"biomeScaleWeight":1.0,"biomeScaleOffset":0.0,"seaLevel":63,"useCaves":true,"useDungeons":true,"dungeonChance":8,"useStrongholds":true,"useVillages":true,"useMineShafts":true,"useTemples":true,"useMonuments":true,"useMansions":true,"useRavines":true,"useWaterLakes":true,"waterLakeChance":4,"useLavaLakes":true,"lavaLakeChance":80,"useLavaOceans":false,"fixedBiome":-1,"biomeSize":4,"riverSize":4,"dirtSize":33,"dirtCount":10,"dirtMinHeight":0,"dirtMaxHeight":256,"gravelSize":33,"gravelCount":8,"gravelMinHeight":0,"gravelMaxHeight":256,"graniteSize":33,"graniteCount":10,"graniteMinHeight":0,"graniteMaxHeight":80,"dioriteSize":33,"dioriteCount":10,"dioriteMinHeight":0,"dioriteMaxHeight":80,"andesiteSize":33,"andesiteCount":10,"andesiteMinHeight":0,"andesiteMaxHeight":80,"coalSize":17,"coalCount":20,"coalMinHeight":0,"coalMaxHeight":128,"ironSize":9,"ironCount":20,"ironMinHeight":0,"ironMaxHeight":64,"goldSize":9,"goldCount":2,"goldMinHeight":0,"goldMaxHeight":32,"redstoneSize":8,"redstoneCount":8,"redstoneMinHeight":0,"redstoneMaxHeight":16,"diamondSize":8,"diamondCount":1,"diamondMinHeight":0,"diamondMaxHeight":16,"lapisSize":7,"lapisCount":1,"lapisCenterHeight":16,"lapisSpread":16}
}
