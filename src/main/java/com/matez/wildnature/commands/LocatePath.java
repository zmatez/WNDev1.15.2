package com.matez.wildnature.commands;

import com.matez.wildnature.Main;
import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.other.Utilities;
import com.sun.javafx.geom.Vec2d;
import net.minecraft.client.resources.I18n;
import net.minecraft.command.CommandSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.dimension.OverworldDimension;
import net.minecraftforge.common.BiomeDictionary;

import java.util.ArrayList;

public class LocatePath {

    public static ArrayList<BlockPos> paths = new ArrayList<>();

    public static int findTeleportBiome(CommandSource cs, ServerPlayerEntity player){
        if(!CommonConfig.generatePaths.get()){
            StringTextComponent sa = new StringTextComponent(TextFormatting.RED + "Generating path is OFF. Change that it config and try again.");
            Main.sendChatMessage(player, new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(sa));
        }
        if(player.getEntityWorld().getDimension() instanceof OverworldDimension) {

            StringTextComponent s2 = new StringTextComponent(TextFormatting.AQUA + "Trying to find the nearest path");
            Main.sendChatMessage(player, new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s2));
            StringTextComponent sx = new StringTextComponent(TextFormatting.AQUA + "This will take a moment.");
            Main.sendChatMessage(player, new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(sx));
            BlockPos path = lookForPath(player);
            if(path!=null){
                Main.LOGGER.info("Found nearest path at " + path.getX() + " " + path.getY() + " " + path.getZ());
                StringTextComponent s3 = new StringTextComponent(TextFormatting.AQUA + "Found nearest path at ");
                StringTextComponent s4 = new StringTextComponent(TextFormatting.YELLOW + ""+path.getX() + " " + path.getY() + " " + path.getZ());
                StringTextComponent s42 = new StringTextComponent(TextFormatting.AQUA + " - " + TextFormatting.GOLD + (int)Utilities.getDistance(new BlockPos(player.getPosition().getX(),player.getPosition().getY(),player.getPosition().getZ()),path) + TextFormatting.AQUA+" blocks away.");
                s4.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new StringTextComponent(TextFormatting.GOLD+"Click to copy to the command prompt")));
                s4.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND,"" + path.getX() + " " + path.getY() + " " + path.getZ()));
                Main.sendChatMessage(player, new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s3).appendSibling(s4).appendSibling(s42));
                StringTextComponent s5 = new StringTextComponent(TextFormatting.GREEN + "Click to teleport");
                s5.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new StringTextComponent(TextFormatting.GOLD+"Click here")));
                s5.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND,"/tp " + player.getName().getString() + " " + path.getX() + " " + path.getY() + " " + path.getZ()));
                Main.sendChatMessage(player, new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s5));
                player.sendStatusMessage(new StringTextComponent(TextFormatting.GREEN+"Found path " + TextFormatting.AQUA+ (int)Utilities.getDistance(new BlockPos(player.getPosition().getX(),player.getPosition().getY(),player.getPosition().getZ()),path) + TextFormatting.GREEN+" blocks away"),true);

                return 1;
            }else{
                StringTextComponent sa = new StringTextComponent(TextFormatting.RED + "Unable to find path.");
                StringTextComponent sa2 = new StringTextComponent(TextFormatting.RED + "Teleport to path-allowed biome and try again.");
                StringTextComponent sa3 = new StringTextComponent(TextFormatting.GOLD + "Starting searching...");
                Main.sendChatMessage(player, new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(sa));
                Main.sendChatMessage(player, new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(sa2));
                Main.sendChatMessage(player, new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(sa3));
                ArrayList<Biome> validBiomes = new ArrayList<>();
                ArrayList<Biome> biomes = new ArrayList<>();
                biomes.addAll(BiomeDictionary.getBiomes(BiomeDictionary.Type.FOREST));
                biomes.addAll(BiomeDictionary.getBiomes(BiomeDictionary.Type.DENSE));
                biomes.forEach(biome -> {
                    if(BiomeDictionary.getBiomes(BiomeDictionary.Type.FOREST).contains(biome) && BiomeDictionary.getBiomes(BiomeDictionary.Type.DENSE).contains(biome) ){
                        validBiomes.add(biome);
                    }
                });

                Biome[] biomez = validBiomes.toArray(new Biome[validBiomes.size()]);


                BiomeArgument.findTeleportBiome(cs,player, biomez);
            }
        }else{
            StringTextComponent sx = new StringTextComponent(TextFormatting.RED + "Paths not exist in this dimension.");
            Main.sendChatMessage(player, new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(sx));
            return 0;
        }
        return 0;
    }

    public static BlockPos lookForPath(PlayerEntity player)
    {
        Main.LOGGER.info("Starting searching for path... ");
        double closestDistance = 0;
        BlockPos closestPos = null;
        for(BlockPos pos : paths){
            double distance = Utilities.getDistance(pos,player.getPosition());
            TextFormatting color = null;
            if(closestPos==null){
                closestDistance=distance;
                closestPos=pos;
                color = TextFormatting.WHITE;
            }else{
                if(distance<closestDistance){
                    closestDistance=distance;
                    closestPos = pos;
                    color=TextFormatting.GREEN;
                }else{
                    color=TextFormatting.RED;
                }
            }
            player.sendStatusMessage(new StringTextComponent(""+color + TextFormatting.BOLD + "| "+ TextFormatting.YELLOW+"Searching in paths " + TextFormatting.GOLD + paths.indexOf(pos) + TextFormatting.YELLOW + "/" + TextFormatting.GOLD + + paths.size() + color + TextFormatting.BOLD + " |"),true);

        }
        return closestPos;
    }
}
