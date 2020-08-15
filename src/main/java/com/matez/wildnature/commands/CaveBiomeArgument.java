package com.matez.wildnature.commands;

import com.matez.wildnature.Main;
import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.world.gen.chunk.WNNoiseChunkGenerator;
import com.matez.wildnature.world.gen.noise.sponge.module.source.RidgedMulti;
import com.matez.wildnature.world.gen.undergroundBiomes.setup.URBiome;
import com.matez.wildnature.world.gen.undergroundBiomes.setup.URBiomeManager;
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
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.Heightmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

public class CaveBiomeArgument implements ArgumentType<URBiome>
{
    private static int radius = -1, quality = 10,maxRadius = 10000;
    private static boolean speedSearch = false;
    public static final DynamicCommandExceptionType INVALID_URBIOME_EXCEPTION = new DynamicCommandExceptionType((URBiome) -> {
        return new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(new StringTextComponent(TextFormatting.RED + "This biome is invalid."));
    });

    public static CaveBiomeArgument createArgument()
    {
        return new CaveBiomeArgument();
    }
    private static ArrayList<ResourceLocation> urURBiomeNames = new ArrayList<>();
    @Override
    public URBiome parse(StringReader reader) throws CommandSyntaxException
    {
        ResourceLocation location = ResourceLocation.read(reader);

        for (URBiome object : URBiomeManager.riverBiomes.getObjects()) {
            if(location.getPath().equals(object.getName())){
                return object;
            }
        }
        throw INVALID_URBIOME_EXCEPTION.create(location);
    }

    public static URBiome getValue(CommandContext<CommandSource> context, String name) throws CommandSyntaxException
    {
        return context.getArgument(name, URBiome.class);
    }


    @Override
    public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> context, SuggestionsBuilder suggestionsBuilder)
    {
        if(urURBiomeNames.isEmpty()){
            for (URBiome object : URBiomeManager.riverBiomes.getObjects()) {
                urURBiomeNames.add(new ResourceLocation("wildnature",object.name));
            }
        }

        return ISuggestionProvider.suggestIterable(urURBiomeNames, suggestionsBuilder);
    }

    public static int findTeleportURBiome(CommandSource cs, ServerPlayerEntity player, URBiome... URBiome)
    {
        ArrayList<URBiome> URBiomes = new ArrayList<>(Arrays.asList(URBiome));

        StringTextComponent s2;
        if(URBiomes.size()==1){
            s2 = new StringTextComponent(TextFormatting.AQUA + "Trying to find " + TextFormatting.GOLD + "wildnature:" + URBiome[0].getName() + TextFormatting.AQUA+" biome...");
        }else{
            s2 = new StringTextComponent(TextFormatting.AQUA + "Trying to find one of " + TextFormatting.GOLD + URBiomes.size() + TextFormatting.AQUA+" biomes...");

        }



        Main.sendChatMessage(player, new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s2));
        StringTextComponent sx = new StringTextComponent(TextFormatting.AQUA + "This will take a moment.");
        Main.sendChatMessage(player, new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(sx));

        World world = player.world;
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                RidgedMulti multi = WNNoiseChunkGenerator.getCaveNoise();
                URBiomePos URBiomePos = null;
                if(multi==null){
                    StringTextComponent s3 = new StringTextComponent(TextFormatting.RED + "No biomes are generated on this world! Please use WildNature world type.");
                    player.sendStatusMessage(new StringTextComponent(TextFormatting.RED + "Unable to find biome"), true);

                    s3.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new StringTextComponent(TextFormatting.DARK_RED + "Operation Failed :/")));
                    Main.sendChatMessage(player, new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s3));
                }else {
                    URBiomePos = lookForURBiome(multi,world, (int) player.getPosition().getX(), (int) player.getPosition().getZ(), player, URBiome);
                }

                if (URBiomePos != null && URBiomePos.URBiome !=null && URBiomePos.pos!=null)
                {
                    BlockPos closestURBiomePos = URBiomePos.pos;
                    double x = (double)closestURBiomePos.getX();
                    double y = (double)13.0;
                    double z = (double)closestURBiomePos.getZ();

                    if (!world.getDimension().isSurfaceWorld())
                    {
                        y = (double)getY(world, closestURBiomePos).getY();
                    }

                    //player.connection.setPlayerLocation(x, y, z, player.rotationYaw, player.rotationPitch);
                    Main.LOGGER.info("Found " + URBiomePos.URBiome.getName() + " urbiome at " + x + " " + y + " " + z + ". This taken " + radius + " attempts.");
                    StringTextComponent s3 = new StringTextComponent(TextFormatting.AQUA + "Found " + TextFormatting.LIGHT_PURPLE + new TranslationTextComponent(URBiomePos.URBiome.getName()).getFormattedText() + TextFormatting.AQUA+" biome at ");
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
                    if(URBiomes.size()==1) {
                        StringTextComponent s3 = new StringTextComponent(TextFormatting.RED + "Unable to find " + TextFormatting.LIGHT_PURPLE + URBiomes.get(0).getName() + TextFormatting.RED + " biome.");
                        player.sendStatusMessage(new StringTextComponent(TextFormatting.RED + "Unable to find biome"), true);

                        s3.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new StringTextComponent(TextFormatting.DARK_RED + "Operation Failed :/")));
                        Main.sendChatMessage(player, new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s3));
                    }else{
                        StringTextComponent s3 = new StringTextComponent(TextFormatting.RED + "Unable to find any of " + TextFormatting.LIGHT_PURPLE + URBiomes.size() + TextFormatting.RED + " biomes.");
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

    public static URBiomePos lookForURBiome(RidgedMulti noise, World world, int startX, int startZ, PlayerEntity player, URBiome... URBiomeToFind)
    {
        ArrayList<URBiome> URBiomes = new ArrayList<>(Arrays.asList(URBiomeToFind));
        speedSearch=true;
        Main.LOGGER.info("Starting searching for " + URBiomes.size() + " URBiomes");
        int maxDistance = CommonConfig.maxSearchRadius.get();
        for(int currDist = 0; currDist<maxDistance; currDist= currDist + quality){
            ArrayList<BlockPos> pos = drawCircle(startX,startZ,currDist);
            player.sendStatusMessage(new StringTextComponent(TextFormatting.YELLOW+"Searching in radius " + TextFormatting.GOLD + currDist + TextFormatting.YELLOW + "/" + TextFormatting.GOLD + + maxDistance),true);


            int x = 0;
            for (BlockPos vec : pos) {

                x++;
                double vnoise = noise.getValue(vec.getX(), 1, vec.getZ());
                if (vnoise >= 0.60 && vnoise <= 2) {
                for (URBiome URBiome : URBiomes) {
                    if (URBiomeManager.getBiomeAt(world.getChunk(new BlockPos((int) vec.getX(), 1, (int) vec.getZ())), new BlockPos((int) vec.getX(), 1, (int) vec.getZ()), world.getSeed()) == URBiome) {
                        radius = currDist;
                        return new URBiomePos(new BlockPos((int) vec.getX(), 0, (int) vec.getZ()), URBiome);
                    }
                }
                }

            }

        }

        URBiome b = URBiomes.get(Utilities.rint(0,URBiomes.size()-1));


        Main.LOGGER.info("Finding URBiome on the world, ignoring distance | " +b );

        return lookForURBiomeAsap(world,b,startX,startZ,player);
    }

    public static URBiomePos lookForURBiomeAsap(World world, URBiome URBiomeToFind, int startX, int startZ, PlayerEntity player)
    {
        /*player.sendStatusMessage(new StringTextComponent(TextFormatting.YELLOW+"Unable to find the nearest URBiome. Searching ignoring distance..."),true);

        int sampleSpace = 4 << 12;
        int maxDist = sampleSpace * 100;
        int m = 0;
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
            URBiome[] URBiomesAtSample = URBiomeManager.getBiomeAt(world.getChunk(new BlockPos((int)x,1,(int)z)),new BlockPos((int)x,1,(int)z),world.getSeed());
            if (URBiomesAtSample[0] == URBiomeToFind)
            {
                return new URBiomePos(new BlockPos((int)x, 0, (int)z),URBiomeToFind);
            }
            if(n>=250000){
                return null;
            }
        }*/

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

    public static class URBiomePos{
        public BlockPos pos;
        public URBiome URBiome;
        public URBiomePos(BlockPos pos, URBiome URBiome){
            this.pos=pos;
            this.URBiome=URBiome;
        }
}

}