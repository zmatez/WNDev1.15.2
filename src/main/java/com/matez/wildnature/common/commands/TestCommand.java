package com.matez.wildnature.common.commands;

import com.matez.wildnature.common.blocks.WisteriaBlock;
import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.event.PlayerEventHandler;
import com.matez.wildnature.world.generation.biome.biomes.land.WNBialowiezaForest;
import com.matez.wildnature.world.generation.biome.setup.BiomeVariants;
import com.matez.wildnature.world.generation.biome.setup.grid.BiomeGroup;
import com.matez.wildnature.world.generation.biome.setup.grid.IslandBiome;
import com.matez.wildnature.world.generation.chunk.generation.ChunkArraySampler;
import com.matez.wildnature.world.generation.chunk.generation.WNSimplexChunkGenerator;
import com.matez.wildnature.world.generation.chunk.generation.landscape.ChunkLandscape;
import com.matez.wildnature.world.generation.chunk.generation.noise.NoiseProcessors;
import com.matez.wildnature.world.generation.chunk.generation.noise.ScaleNoiseProcessor;
import com.matez.wildnature.world.generation.generators.functions.interpolation.BiomeBlender;
import com.matez.wildnature.world.generation.generators.functions.interpolation.LerpConfiguration;
import com.matez.wildnature.world.generation.grid.Cell;
import com.matez.wildnature.world.generation.layer.SmoothColumnBiomeMagnifier;
import com.matez.wildnature.world.generation.provider.WNGridBiomeProvider;
import com.matez.wildnature.world.generation.provider.WNWorldType;
import com.matez.wildnature.world.generation.transformer.BiomeTransformer;
import com.matez.wildnature.world.generation.transformer.transformers.IslandTransformer;
import com.matez.wildnature.world.generation.transformer.transformers.MainBiomeTransformer;
import com.matez.wildnature.world.generation.transformer.transformers.ShoreTransformer;
import com.mojang.brigadier.context.CommandContext;
import it.unimi.dsi.fastutil.objects.Object2DoubleMap;
import it.unimi.dsi.fastutil.objects.Object2DoubleOpenHashMap;
import net.minecraft.command.CommandSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.ColumnFuzzedBiomeMagnifier;

import java.util.function.Function;

import static com.matez.wildnature.world.generation.generators.functions.interpolation.BiomeBlender.getDepth;

public class TestCommand {

    public int test(PlayerEntity entity, CommandContext<CommandSource> context){
        if(checkPlayer(entity)){
            try {
                execute(entity);

                StringTextComponent s2 = new StringTextComponent(TextFormatting.GREEN + "Execution successful!");
                WN.sendChatMessage(entity, new StringTextComponent("").appendSibling(WN.WNPrefix).appendSibling(s2));
            }catch (Exception e){
                StringTextComponent s2 = new StringTextComponent(TextFormatting.RED + "Execution failed. " + e.getLocalizedMessage());
                WN.sendChatMessage(entity, new StringTextComponent("").appendSibling(WN.WNPrefix).appendSibling(s2));
                System.out.println(e.getStackTrace());
            }
            return 1;
        }

        return 0;
    }
    private final BiomeTransformer mainBiomeTransformer = new MainBiomeTransformer();
    private final BiomeTransformer shoreTransformer = new ShoreTransformer();
    private final BiomeTransformer smallIslandTransformer = new IslandTransformer(IslandBiome.IslandType.SMALL);
    private final BiomeTransformer bigIslandTransformer = new IslandTransformer(IslandBiome.IslandType.BIG);
    private void execute(PlayerEntity entity){
        World worldIn = entity.getEntityWorld();
        ChunkPos pos = worldIn.getChunkAt(entity.getPosition()).getPos();
        if(WNWorldType.generator != null) {
            WNGridBiomeProvider provider = WNWorldType.generator.getGridProvider();
            int rx = entity.getPosition().getX();
            int ry = entity.getPosition().getY();
            int rz = entity.getPosition().getZ();
            Cell cell = provider.getNoiseCell(rx / 4, rz / 4);
            Biome biome = provider.getNoiseBiome(rx / 4, ry, rz / 4);
            Biome biome2 = provider.getNoiseBiome(rx >> 2, ry, rz >> 2);
            Biome biome3 = ColumnFuzzedBiomeMagnifier.INSTANCE.getBiome(worldIn.getSeed(),rx,0,rz,worldIn);
            Biome biome4 = SmoothColumnBiomeMagnifier.SMOOTH.getBiome(worldIn.getSeed(),rx,0,rz,worldIn);
            ChunkLandscape landscape = ChunkLandscape.getOrCreate(rx, rz, worldIn.getSeed(), worldIn.getSeaLevel(),biome,worldIn.getChunk(pos.x,pos.z));
            //
            int directionMove = 16;
            Cell northCell = provider.getNoiseCell((rx/4) + directionMove, (rz/4)).copy();
            Cell southCell = provider.getNoiseCell((rx/4) - directionMove, (rz/4) ).copy();
            Cell eastCell = provider.getNoiseCell((rx/4), (rz/4)  + directionMove).copy();
            Cell westCell = provider.getNoiseCell((rx/4), (rz/4) - directionMove).copy();

            BiomeGroup centerBG = mainBiomeTransformer.bgApply(cell), northBiomeGroup, eastBiomeGroup, southBiomeGroup, westBiomeGroup, shoreBiomeGroup;

            northBiomeGroup = mainBiomeTransformer.bgApply(northCell);
            southBiomeGroup = mainBiomeTransformer.bgApply(southCell);
            eastBiomeGroup = mainBiomeTransformer.bgApply(eastCell);
            westBiomeGroup = mainBiomeTransformer.bgApply(westCell);

            centerBG = smallIslandTransformer.bgApply(centerBG, cell);
            centerBG = bigIslandTransformer.bgApply(centerBG, cell);

            northBiomeGroup = smallIslandTransformer.bgApply(northBiomeGroup, northCell);
            northBiomeGroup = bigIslandTransformer.bgApply(northBiomeGroup, northCell);
            southBiomeGroup = smallIslandTransformer.bgApply(southBiomeGroup, southCell);
            southBiomeGroup = bigIslandTransformer.bgApply(southBiomeGroup, southCell);
            eastBiomeGroup = smallIslandTransformer.bgApply(eastBiomeGroup, eastCell);
            eastBiomeGroup = bigIslandTransformer.bgApply(eastBiomeGroup, eastCell);
            westBiomeGroup = smallIslandTransformer.bgApply(westBiomeGroup, westCell);
            westBiomeGroup = bigIslandTransformer.bgApply(westBiomeGroup, westCell);

            shoreBiomeGroup = shoreTransformer.apply(centerBG,northBiomeGroup,southBiomeGroup,eastBiomeGroup,westBiomeGroup,cell);
            //

            log(entity, "Biome identity: " + cell.biomeCellIdentity);
            log(entity, "NBiome identity: " + northCell.biomeCellIdentity);
            log(entity, "SBiome identity: " + southCell.biomeCellIdentity);
            log(entity, "EBiome identity: " + eastCell.biomeCellIdentity);
            log(entity, "WBiome identity: " + westCell.biomeCellIdentity);
            log(entity, "SubBiome identity: " + cell.subBiomeCellIdentity);
            log(entity, "SmallIsland identity: " + cell.smallIslandCellIdentity);
            log(entity, "BigIsland identity: " + cell.bigIslandCellIdentity);
            log(entity, "Temperature: " + cell.temparature);
            log(entity, "Moisture: " + cell.moisture);
            log(entity, "Cell Temperature: " + cell.cellTemparature);
            log(entity, "Cell Moisture: " + cell.cellMoisture);
            log(entity, "Continent Value: " + cell.continentValue);
            log(entity, "Cell Continent: " + cell.cellContinent);
            log(entity, "Category: " + BiomeTransformer.getCategoryFromContinent(cell.continentValue));
            log(entity, "Current TempCategory: " + BiomeTransformer.TempCategory.getFromTemperature(-0.1f,1,biome.getDefaultTemperature()).getName());
            log(entity, "Current WetCategory: " + BiomeTransformer.WetCategory.getFromMoisture(0f,1,biome.getDownfall()).getName());
            log(entity,"Cell TempCategory: " + BiomeTransformer.TempCategory.getFromTemperature(-1, 1, cell.cellTemparature).getName());
            log(entity,"Cell WetCategory: " + BiomeTransformer.WetCategory.getFromMoisture(-1, 1, cell.cellMoisture).getName());
            log(entity, "Biome/4: " + biome.getRegistryName());
            log(entity, "Biome>>2: " + biome2.getRegistryName());
            log(entity, "BiomeCF: " + biome3.getRegistryName());
            log(entity, "BiomeSF: " + biome4.getRegistryName());
            log(entity, "CenterBG: " + centerBG.getId() + ": " + centerBG.getBaseBiome().getRegistryName().toString());
            log(entity, "NBG: " + northBiomeGroup.getId() + ": " + northBiomeGroup.getBaseBiome().getRegistryName().toString());
            log(entity, "SBG: " + southBiomeGroup.getId() + ": " + southBiomeGroup.getBaseBiome().getRegistryName().toString());
            log(entity, "EBG: " + eastBiomeGroup.getId() + ": " + eastBiomeGroup.getBaseBiome().getRegistryName().toString());
            log(entity, "WBG: " + westBiomeGroup.getId() + ": " + westBiomeGroup.getBaseBiome().getRegistryName().toString());
            log(entity, "SHORE: " + shoreBiomeGroup.getId() + ": " + shoreBiomeGroup.getBaseBiome().getRegistryName().toString());

            log(entity,"D: "+biome.getDepth()+" S: " + biome.getScale() + "DS: " + (biome.getDepth() + biome.getScale()));
            log(entity,"CliffNoise: "+ ((ScaleNoiseProcessor)NoiseProcessors.SCALE).getCliffNoise().GetNoise(rx,rz));
            log(entity,"CliffNoiseMask: "+ ((ScaleNoiseProcessor)NoiseProcessors.SCALE).getCliffNoiseMask().GetNoise(rx,rz));

            final Object2DoubleMap<LerpConfiguration> weightMap16 = new Object2DoubleOpenHashMap<>(4), weightMap4 = new Object2DoubleOpenHashMap<>(2), weightMap1 = new Object2DoubleOpenHashMap<>();

            final ChunkArraySampler.CoordinateAccessor<LerpConfiguration> biomeAccessor = (x, z) -> {
                Biome b = SmoothColumnBiomeMagnifier.SMOOTH.getBiome(worldIn.getSeed(), (pos.x * 16) + x, 0, (pos.z * 16) + z, provider, true);
                return LerpConfiguration.get(b);
            };

            final LerpConfiguration[] sampledBiomes16 = ChunkArraySampler.fillSampledArray(new LerpConfiguration[10 * 10], biomeAccessor, 4);
            final LerpConfiguration[] sampledBiomes4 = ChunkArraySampler.fillSampledArray(new LerpConfiguration[13 * 13], biomeAccessor, 2);
            final LerpConfiguration[] sampledBiomes1 = ChunkArraySampler.fillSampledArray(new LerpConfiguration[24 * 24], biomeAccessor);

            for (int x = 0; x < 16; x++) {
                for (int z = 0; z < 16; z++) {
                    if ((pos.x * 16) + x == entity.getPosition().getX() && (pos.z * 16) + z == entity.getPosition().getZ()) {
                        log(entity, "Position: " + entity.getPosition().getX() + ", " + entity.getPosition().getZ());
                        // Sample biome weights at different distances
                        ChunkArraySampler.fillSampledWeightMap(sampledBiomes16, weightMap16, 4, x, z);
                        ChunkArraySampler.fillSampledWeightMap(sampledBiomes4, weightMap4, 2, x, z);
                        ChunkArraySampler.fillSampledWeightMap(sampledBiomes1, weightMap1, x, z);

                        Function<LerpConfiguration, BiomeVariants> variantAccessor = BiomeVariants::getVariantsFor;

                        // Group biomes at different distances. This has the effect of making some biome transitions happen over larger distances than others.
                        // This is used to make most land biomes blend at maximum distance, while allowing biomes such as rivers to blend at short distances, creating better cliffs as river biomes are smaller width than other biomes.
                        ChunkArraySampler.reduceGroupedWeightMap(weightMap4, weightMap16, variantAccessor.andThen(BiomeVariants::getLargeGroup), BiomeVariants.LargeGroup.SIZE);
                        ChunkArraySampler.reduceGroupedWeightMap(weightMap1, weightMap4, variantAccessor.andThen(BiomeVariants::getSmallGroup), BiomeVariants.SmallGroup.SIZE);
                        double[] values = BiomeBlender.smoothLerp( (pos.x * 16) + x,(pos.z * 16) + z,landscape, weightMap1, variantAccessor);
                        log(entity, "Height: " + values[0]);
                        log(entity, "FreqMin: " + values[3] + " FreqMax: " + values[4]);
                        log(entity, "Sample noise: " + landscape.sampleNoise(rx,rz,values[0],values[1],values[2],true));
                    }
                }
            }
        }
    }

    private double sigmoid(double noise) {
        return 256 / (Math.exp(8 / 3f - noise / 48) + 1);
    }


    private static double scaleBetween(double unscaledNum, double minAllowed, double maxAllowed, double min, double max) {
        return (maxAllowed - minAllowed) * (unscaledNum - min) / (max - min) + minAllowed;
    }

    public static boolean checkPlayer(PlayerEntity entity){
        int x = 0;
        try{
            x = PlayerEventHandler.isPatron(entity).getType();
        }catch (NullPointerException e){
            x=-1;
        }
        if(x==1||x==2||x==3){
            StringTextComponent s2 = new StringTextComponent(TextFormatting.AQUA + "Running the dev command... ");
            WN.sendChatMessage(entity, new StringTextComponent("").appendSibling(WN.WNPrefix).appendSibling(s2));
            return true;
        }else {
            StringTextComponent s2 = new StringTextComponent(TextFormatting.AQUA + "This is a developer command. It's useless for you :)");
            WN.sendChatMessage(entity, new StringTextComponent("").appendSibling(WN.WNPrefix).appendSibling(s2));
            return false;
        }
    }

    private void log(PlayerEntity entity, String text){
        StringTextComponent s = new StringTextComponent(TextFormatting.GRAY + text);
        WN.sendChatMessage(entity, new StringTextComponent("").appendSibling(WN.WNPrefix).appendSibling(s));
    }

}
