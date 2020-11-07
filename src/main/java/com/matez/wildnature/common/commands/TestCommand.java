package com.matez.wildnature.common.commands;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.event.PlayerEventHandler;
import com.matez.wildnature.world.generation.biome.setup.BiomeVariants;
import com.matez.wildnature.world.generation.chunk.generation.ChunkArraySampler;
import com.matez.wildnature.world.generation.generators.functions.interpolation.LerpConfiguration;
import com.matez.wildnature.world.generation.layer.SmoothColumnBiomeMagnifier;
import com.mojang.brigadier.context.CommandContext;
import it.unimi.dsi.fastutil.objects.Object2DoubleMap;
import it.unimi.dsi.fastutil.objects.Object2DoubleOpenHashMap;
import net.minecraft.command.CommandSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

import java.util.function.Function;

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

    private void execute(PlayerEntity entity){
        World worldIn = entity.getEntityWorld();
        ChunkPos pos = worldIn.getChunkAt(entity.getPosition()).getPos();

        final Object2DoubleMap<Biome> weightMap16 = new Object2DoubleOpenHashMap<>(4), weightMap4 = new Object2DoubleOpenHashMap<>(2), weightMap1 = new Object2DoubleOpenHashMap<>();

        final ChunkArraySampler.CoordinateAccessor<Biome> biomeAccessor = (x, z) -> {
            return SmoothColumnBiomeMagnifier.SMOOTH.getBiome(worldIn.getSeed(), pos.getXStart() + x, 0, pos.getZStart() + z, worldIn);
        };

        final Biome[] sampledBiomes16 = ChunkArraySampler.fillSampledArray(new Biome[10 * 10], biomeAccessor, 4);
        final Biome[] sampledBiomes4 = ChunkArraySampler.fillSampledArray(new Biome[13 * 13], biomeAccessor, 2);
        final Biome[] sampledBiomes1 = ChunkArraySampler.fillSampledArray(new Biome[24 * 24], biomeAccessor);

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                if((pos.x * 16) + x == entity.getPosition().getX() && (pos.z * 16) + z == entity.getPosition().getZ()){
                    log(entity,"Position: " + entity.getPosition().getX() + ", " + entity.getPosition().getZ());
                    // Sample biome weights at different distances
                    ChunkArraySampler.fillSampledWeightMap(sampledBiomes16, weightMap16, 4, x, z);
                    ChunkArraySampler.fillSampledWeightMap(sampledBiomes4, weightMap4, 2, x, z);
                    ChunkArraySampler.fillSampledWeightMap(sampledBiomes1, weightMap1, x, z);

                    Function<Biome, BiomeVariants> variantAccessor = BiomeVariants::getVariantsFor;

                    // Group biomes at different distances. This has the effect of making some biome transitions happen over larger distances than others.
                    // This is used to make most land biomes blend at maximum distance, while allowing biomes such as rivers to blend at short distances, creating better cliffs as river biomes are smaller width than other biomes.
                    ChunkArraySampler.reduceGroupedWeightMap(weightMap4, weightMap16, variantAccessor.andThen(BiomeVariants::getLargeGroup), BiomeVariants.LargeGroup.SIZE);
                    ChunkArraySampler.reduceGroupedWeightMap(weightMap1, weightMap4, variantAccessor.andThen(BiomeVariants::getSmallGroup), BiomeVariants.SmallGroup.SIZE);
                    Biome biome = worldIn.getNoiseBiome(((pos.x * 16) + x)/4, 1,((pos.z * 16) + z)/4);
                    double factor = smoothLerp(entity, (pos.x * 16) + x, (pos.z * 16) + z,biome,weightMap1,variantAccessor);
                    log(entity,"Noise: "+(factor * 50) + 65);
                    log(entity,"Height: "+sigmoid((factor * 50) + 65));
                }
            }
        }
    }

    public double smoothLerp(PlayerEntity entity, int x, int z, Biome biomeIn, Object2DoubleMap<Biome> weightMap1, Function<Biome, BiomeVariants> variantAccessor){
        // Based on total weight of all biomes included, calculate heights of a couple important groups
        double totalNoiseFactor = 0;
        double biomeInWeight = 0;
        double biomeOutWeight = 0;

        int amountIn = 0;
        int amountOut = 0;
        for (Object2DoubleMap.Entry<Biome> entry : weightMap1.object2DoubleEntrySet()) {
            BiomeVariants variants = variantAccessor.apply(entry.getKey());
            Biome biome = entry.getKey();
            double weight = entry.getDoubleValue();


            if(biome == biomeIn){
                biomeInWeight += weight;
                amountIn ++;
            }else{
                biomeOutWeight += weight;
                amountOut ++;
            }
        }

        double maxValue = biomeInWeight + biomeOutWeight;

        totalNoiseFactor = scaleBetween(Math.max(biomeInWeight, biomeOutWeight),0,1,0.5,maxValue);
        log(entity,"BiomeInWeight: " + biomeInWeight);
        log(entity,"BiomeOutWeight: " + biomeOutWeight);
        log(entity,"AmountIn: " + amountIn);
        log(entity,"AmountOut: " + amountOut);
        log(entity, "MaxValue: " + maxValue);
        log(entity, "Biome: " + biomeIn.getRegistryName());
        log(entity,"Factor:" + totalNoiseFactor);

        return totalNoiseFactor;
    }

    private double sigmoid(double noise) {
        return 256 / (Math.exp(8 / 3f - noise / 48) + 1);
    }


    private static double scaleBetween(double unscaledNum, double minAllowed, double maxAllowed, double min, double max) {
        return (maxAllowed - minAllowed) * (unscaledNum - min) / (max - min) + minAllowed;
    }

    private boolean checkPlayer(PlayerEntity entity){
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
