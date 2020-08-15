package com.matez.wildnature.commands;

import com.matez.wildnature.Main;
import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.other.Utilities;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.command.CommandSource;
import net.minecraft.command.ISuggestionProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.server.ServerWorld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

public class BiomeArgument implements ArgumentType<Biome>
{
    private static int radius = -1, quality = 10,maxRadius = 10000;
    private static boolean speedSearch = false;
    public static final DynamicCommandExceptionType INVALID_BIOME_EXCEPTION = new DynamicCommandExceptionType((biome) -> {
        return new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(new StringTextComponent(TextFormatting.RED + "This biome is invalid."));
    });

    public static BiomeArgument createArgument()
    {
        return new BiomeArgument();
    }

    @Override
    public Biome parse(StringReader reader) throws CommandSyntaxException
    {
        ResourceLocation location = ResourceLocation.read(reader);
        return Registry.BIOME.getValue(location).orElseThrow(() ->
        {
            return INVALID_BIOME_EXCEPTION.create(location);
        });
    }

    public static Biome getValue(CommandContext<CommandSource> context, String name) throws CommandSyntaxException
    {
        return context.getArgument(name, Biome.class);
    }


    @Override
    public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> context, SuggestionsBuilder suggestionsBuilder)
    {
        return ISuggestionProvider.suggestIterable(Registry.BIOME.keySet(), suggestionsBuilder);
    }

    public static int findTeleportBiome(CommandSource cs, ServerPlayerEntity player, Biome... biome)
    {
        ArrayList<Biome> biomes = new ArrayList<>(Arrays.asList(biome));


        StringTextComponent s2;
        if(biomes.size()==1){
            if(CommonConfig.blacklistedBiomes.contains(biome)){
                StringTextComponent sx = new StringTextComponent(TextFormatting.RED + "This biome is blacklisted.");
                Main.sendChatMessage(player, new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(sx));
                return 0;
            }
            s2 = new StringTextComponent(TextFormatting.AQUA + "Trying to find " + TextFormatting.GOLD + new TranslationTextComponent(biomes.get(0).getTranslationKey()).getFormattedText() + TextFormatting.AQUA+" biome...");
        }else{
            int blacklisted =0;
            for (Biome biome1 : biomes) {
                if(CommonConfig.blacklistedBiomes.contains(biome1)){
                    blacklisted++;
                }
            }
            if(blacklisted==biomes.size()){
                StringTextComponent sx = new StringTextComponent(TextFormatting.RED + "All choosen biomes are blacklisted.");
                Main.sendChatMessage(player, new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(sx));
                return 0;
            }
            if(blacklisted==1){
                StringTextComponent sx = new StringTextComponent(TextFormatting.RED +"One " + " of " + biomes.size() + " biomes is blacklisted. Searching still possible");
                Main.sendChatMessage(player, new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(sx));
            }
            else if(blacklisted>1){
                StringTextComponent sx = new StringTextComponent(TextFormatting.RED +""+ blacklisted + " of " + biomes.size() + " biomes are blacklisted. Searching still possible");
                Main.sendChatMessage(player, new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(sx));
            }
            s2 = new StringTextComponent(TextFormatting.AQUA + "Trying to find one of " + TextFormatting.GOLD + biomes.size() + TextFormatting.AQUA+" biomes...");

        }



        Main.sendChatMessage(player, new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s2));
        StringTextComponent sx = new StringTextComponent(TextFormatting.AQUA + "This will take a moment.");
        Main.sendChatMessage(player, new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(sx));

        ServerWorld world = player.getServerWorld();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                BiomePos biomePos = lookForBiome(world, (int)player.getPosition().getX(), (int)player.getPosition().getZ(),player,biome);


                if (biomePos != null && biomePos.biome !=null && biomePos.pos!=null)
                {
                    BlockPos closestBiomePos = biomePos.pos;
                    double x = (double)closestBiomePos.getX();
                    double y = (double) getTopBlock(world, closestBiomePos.getX(), closestBiomePos.getZ()).getY();
                    double z = (double)closestBiomePos.getZ();

                    if (!world.getDimension().isSurfaceWorld())
                    {
                        y = (double)getY(world, closestBiomePos).getY();
                    }

                    //player.connection.setPlayerLocation(x, y, z, player.rotationYaw, player.rotationPitch);
                    Main.LOGGER.info("Found " + biomePos.biome.getRegistryName() + " biome at " + x + " " + y + " " + z + ". This taken " + radius + " attempts.");
                    StringTextComponent s3 = new StringTextComponent(TextFormatting.AQUA + "Found " + TextFormatting.LIGHT_PURPLE + new TranslationTextComponent(biomePos.biome.getTranslationKey()).getFormattedText() + TextFormatting.AQUA+" biome at ");
                    StringTextComponent s4 = new StringTextComponent(TextFormatting.YELLOW + ""+x+" " + y + " " + z);
                    StringTextComponent s42 = new StringTextComponent(TextFormatting.AQUA + " - " + TextFormatting.GOLD + (int)Utilities.getDistance(new BlockPos(player.getPosition().getX(),player.getPosition().getY(),player.getPosition().getZ()),new BlockPos(x,y,z)) + TextFormatting.AQUA+" blocks away.");
                    s4.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new StringTextComponent(TextFormatting.GOLD+"Click to copy to the command prompt")));
                    s4.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND,"" + x + " " + y + " " + z));
                    Main.sendChatMessage(player, new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s3).appendSibling(s4).appendSibling(s42));
                    StringTextComponent s5 = new StringTextComponent(TextFormatting.GREEN + "Click to teleport");
                    s5.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new StringTextComponent(TextFormatting.GOLD+"Click here")));
                    s5.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND,"/tp " + player.getName().getString() + " " + x + " " + y + " " + z));
                    Main.sendChatMessage(player, new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s5));
                    player.sendStatusMessage(new StringTextComponent(TextFormatting.GREEN+"Found biome " + TextFormatting.AQUA+ (int)Utilities.getDistance(new BlockPos(player.getPosition().getX(),player.getPosition().getY(),player.getPosition().getZ()),new BlockPos(x,y,z)) + TextFormatting.GREEN+" blocks away"),true);

                }
                else
                {
                    if(biomes.size()==1) {
                        StringTextComponent s3 = new StringTextComponent(TextFormatting.RED + "Unable to find " + TextFormatting.LIGHT_PURPLE + biomes.get(0).getRegistryName() + TextFormatting.RED + " biome.");
                        player.sendStatusMessage(new StringTextComponent(TextFormatting.RED + "Unable to find biome"), true);

                        s3.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new StringTextComponent(TextFormatting.DARK_RED + "Operation Failed :/")));
                        Main.sendChatMessage(player, new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s3));
                    }else{
                        StringTextComponent s3 = new StringTextComponent(TextFormatting.RED + "Unable to find any of " + TextFormatting.LIGHT_PURPLE + biomes.size() + TextFormatting.RED + " biomes.");
                        player.sendStatusMessage(new StringTextComponent(TextFormatting.RED + "Unable to find biomes"), true);

                        s3.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new StringTextComponent(TextFormatting.DARK_RED + "Operation Failed :/")));
                        Main.sendChatMessage(player, new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s3));
                    }

                }
            }
        });
        t.start();


        return 1;
    }

    public static BlockPos getY(World world, BlockPos pos)
    {
        IChunk chunk = world.getChunk(pos);
        BlockPos blockpos;
        BlockPos blockpos1;
        BlockPos blockpos2 = new BlockPos(pos.getX(), chunk.getTopFilledSegment() + 16, pos.getZ());

        for (blockpos = blockpos2; blockpos.getY() >= 0; blockpos = blockpos1)
        {
            blockpos1 = blockpos.down();
            BlockState state = chunk.getBlockState(blockpos1);

            if (!state.getMaterial().blocksMovement() && !world.isAirBlock(blockpos1.down()) && state.getMaterial() != Material.LEAVES)
            {
                return blockpos1;
            }
        }

        return blockpos2;
    }

    public static BlockPos getTopBlock(IWorld world, int x, int z)
    {
        IChunk chunk = world.getChunk(x >> 4, z >> 4, ChunkStatus.FULL);
        return new BlockPos(x, chunk.getTopBlockY(Heightmap.Type.MOTION_BLOCKING, x & 15, z & 15), z);
    }

    public static BiomePos lookForBiome(ServerWorld world, int startX, int startZ, PlayerEntity player, Biome... biomeToFind)
    {
        ArrayList<Biome> biomes = new ArrayList<>(Arrays.asList(biomeToFind));
        speedSearch=true;
        Main.LOGGER.info("Starting searching for " + biomes.size() + " biomes");
        BiomeProvider chunkManager = world.getChunkProvider().getChunkGenerator().getBiomeProvider();
        int maxDistance = CommonConfig.maxSearchRadius.get();
        for(int currDist = 0; currDist<maxDistance; currDist= currDist + quality){
            ArrayList<BlockPos> pos = drawCircle(startX,startZ,currDist);
            player.sendStatusMessage(new StringTextComponent(TextFormatting.YELLOW+"Searching in radius " + TextFormatting.GOLD + currDist + TextFormatting.YELLOW + "/" + TextFormatting.GOLD + + maxDistance),true);

            int x = 0;
            for (BlockPos vec : pos) {
                x++;
                for (Biome biome : biomes) {
                    if(Utilities.getBiomeOnPos(chunkManager,(int)vec.getX(),(int)vec.getZ())==biome){
                        radius = currDist;
                        return new BiomePos(new BlockPos((int)vec.getX(),0,(int)vec.getZ()),biome);
                    }
                }

            }

        }

        Biome b = biomes.get(Utilities.rint(0,biomes.size()-1));


        Main.LOGGER.info("Finding biome on the world, ignoring distance | " +b );

        return lookForBiomeAsap(world,b,startX,startZ,player);
    }

    public static BiomePos lookForBiomeAsap(ServerWorld world, Biome biomeToFind, int startX, int startZ, PlayerEntity player)
    {
        player.sendStatusMessage(new StringTextComponent(TextFormatting.YELLOW+"Unable to find the nearest biome. Searching ignoring distance..."),true);

        int sampleSpace = 4 << 12;
        int maxDist = sampleSpace * 100;
        int m = 0;
        BiomeProvider chunkManager = world.getChunkProvider().getChunkGenerator().getBiomeProvider();
        double a = sampleSpace / Math.sqrt(Math.PI);
        double b = 2 * Math.sqrt(Math.PI);
        double x = 0;
        double z = 0;
        double dist = 0;
        int n = 0;
        for (n = 0; dist < maxDist; ++n)
        {
            double rootN = Math.sqrt(n);
            dist = a * rootN;
            x = startX + (dist * Math.sin(b * rootN));
            z = startZ + (dist * Math.cos(b * rootN));
            Biome[] biomesAtSample = chunkManager.getBiomes((int)x, (int)z, 1, 1).toArray(new Biome[0]);
            if (biomesAtSample[0] == biomeToFind)
            {
                return new BiomePos(new BlockPos((int)x, 0, (int)z),biomeToFind);
            }
            if(n>=250000){
                return null;
            }
        }

        return null;
    }

    private static ArrayList<BlockPos> drawCircle(int x, int y, int r) {
        ArrayList<BlockPos> pos = new ArrayList<>();
        double PI = Math.PI;
        double i, angle, x1, y1;

        for (i = 0; i < 360; i += 1) {
            angle = i;
            x1 = r * Math.cos(angle * PI / 180);
            y1 = r * Math.sin(angle * PI / 180);

            int ElX = (int) Math.round(x + x1);
            int ElY = (int) Math.round(y + y1);
            pos.add(new BlockPos(ElX,0,ElY));
        }
        return pos;
    }

    public static class BiomePos{
        public BlockPos pos;
        public Biome biome;
        public BiomePos(BlockPos pos, Biome biome){
            this.pos=pos;
            this.biome=biome;
        }
}

}