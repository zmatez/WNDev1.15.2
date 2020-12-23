package com.matez.wildnature.common.commands;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.config.CommonConfig;
import com.matez.wildnature.util.other.Utilities;
import com.matez.wildnature.world.generation.chunk.generation.noise.NoiseProcessors;
import com.matez.wildnature.world.generation.chunk.generation.noise.ScaleNoiseProcessor;
import com.matez.wildnature.world.generation.provider.WNWorldType;
import net.minecraft.command.CommandSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.dimension.OverworldDimension;
import net.minecraft.world.server.ServerWorld;

import java.util.ArrayList;
import java.util.Arrays;

public class LocateCliff {

    public static ArrayList<BlockPos> paths = new ArrayList<>();

    public static int findTeleportBiome(CommandSource cs, ServerPlayerEntity player) {
        if (player.getEntityWorld().getDimension() instanceof OverworldDimension && WNWorldType.generator != null) {
            StringTextComponent s2 = new StringTextComponent(TextFormatting.AQUA + "Trying to find the nearest cliff");
            WN.sendChatMessage(player, new StringTextComponent("").appendSibling(WN.WNPrefix).appendSibling(s2));
            StringTextComponent sx = new StringTextComponent(TextFormatting.AQUA + "This will take a moment.");
            WN.sendChatMessage(player, new StringTextComponent("").appendSibling(WN.WNPrefix).appendSibling(sx));
            BlockPos path = lookForPath(player);
            if (path != null) {
                WN.LOGGER.info("Found nearest cliff at " + path.getX() + " " + path.getY() + " " + path.getZ());
                StringTextComponent s3 = new StringTextComponent(TextFormatting.AQUA + "Found nearest cliff at ");
                StringTextComponent s4 = new StringTextComponent(TextFormatting.YELLOW + "" + path.getX() + " " + path.getY() + " " + path.getZ());
                StringTextComponent s42 = new StringTextComponent(TextFormatting.AQUA + " - " + TextFormatting.GOLD + (int) Utilities.getDistance(new BlockPos(player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ()), path) + TextFormatting.AQUA + " blocks away.");
                s4.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new StringTextComponent(TextFormatting.GOLD + "Click to copy to the command prompt")));
                s4.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "" + path.getX() + " " + path.getY() + " " + path.getZ()));
                WN.sendChatMessage(player, new StringTextComponent("").appendSibling(WN.WNPrefix).appendSibling(s3).appendSibling(s4).appendSibling(s42));
                StringTextComponent s5 = new StringTextComponent(TextFormatting.GREEN + "Click to teleport");
                s5.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new StringTextComponent(TextFormatting.GOLD + "Click here")));
                s5.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tp " + player.getName().getString() + " " + path.getX() + " " + path.getY() + " " + path.getZ()));
                WN.sendChatMessage(player, new StringTextComponent("").appendSibling(WN.WNPrefix).appendSibling(s5));
                player.sendStatusMessage(new StringTextComponent(TextFormatting.GREEN + "Found path " + TextFormatting.AQUA + (int) Utilities.getDistance(new BlockPos(player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ()), path) + TextFormatting.GREEN + " blocks away"), true);

                return 1;
            } else {
                StringTextComponent sa = new StringTextComponent(TextFormatting.RED + "Unable to find cliff.");
                WN.sendChatMessage(player, new StringTextComponent("").appendSibling(WN.WNPrefix).appendSibling(sa));
            }
        } else {
            StringTextComponent sx = new StringTextComponent(TextFormatting.RED + "Paths not exist in this dimension.");
            WN.sendChatMessage(player, new StringTextComponent("").appendSibling(WN.WNPrefix).appendSibling(sx));
            return 0;
        }
        return 0;
    }

    public static BlockPos lookForPath(PlayerEntity player) {
        int maxDistance = CommonConfig.maxSearchRadius.get();
        for (int currDist = 0; currDist < maxDistance; currDist = currDist + 3) {
            ArrayList<BlockPos> pos = drawCircle(player.getPosition().getX(), player.getPosition().getZ(), currDist);
            player.sendStatusMessage(new StringTextComponent(TextFormatting.YELLOW + "Searching in radius " + TextFormatting.GOLD + currDist + TextFormatting.YELLOW + "/" + TextFormatting.GOLD + +maxDistance), true);

            int i = 0;
            for (BlockPos vec : pos) {
                i++;
                int x = (int) vec.getX();
                int z = (int) vec.getZ();
                double cliffNoise = ((ScaleNoiseProcessor) NoiseProcessors.SCALE).getCliffNoise().GetNoise(x,z);
                double cliffNoiseMask = ((ScaleNoiseProcessor) NoiseProcessors.SCALE).getCliffNoiseMask().GetNoise(x,z);

                if(cliffNoise > 0.6 && cliffNoise < 0.63){
                    if(cliffNoiseMask > 0.5 && cliffNoiseMask < 0.7){
                        return vec;
                    }
                }
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
            pos.add(new BlockPos(ElX, 0, ElY));
        }
        return pos;
    }
}
