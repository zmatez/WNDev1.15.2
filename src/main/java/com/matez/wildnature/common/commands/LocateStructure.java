package com.matez.wildnature.common.commands;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.config.CommonConfig;
import com.matez.wildnature.util.other.Utilities;
import com.matez.wildnature.world.generation.provider.WNWorldType;
import com.matez.wildnature.world.generation.structures.WNAbstractStructure;
import com.matez.wildnature.world.generation.structures.WNStructures;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import net.minecraft.command.CommandSource;
import net.minecraft.command.ISuggestionProvider;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraft.world.dimension.OverworldDimension;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class LocateStructure implements ArgumentType<WNAbstractStructure> {

    public static final DynamicCommandExceptionType INVALID_STRUCTURE_EXCEPTION = new DynamicCommandExceptionType((biome) -> {
        return new StringTextComponent("").appendSibling(WN.WNPrefix).appendSibling(new StringTextComponent(TextFormatting.RED + "This structure does not exist."));
    });

    public static SchemArgument createArgument() {
        return new SchemArgument();
    }

    @Override
    public WNAbstractStructure parse(StringReader reader) throws CommandSyntaxException {
        ResourceLocation location = ResourceLocation.read(reader);

        for (Map.Entry<String, WNAbstractStructure> stringSchemFeatureEntry : WNStructures.getRegistry().entrySet()) {
            if (location.toString().equals(stringSchemFeatureEntry.getKey())) {
                return stringSchemFeatureEntry.getValue();
            }
        }

        throw INVALID_STRUCTURE_EXCEPTION.create(location);
    }

    private ArrayList<ResourceLocation> suggestions = new ArrayList<>();
    @Override
    public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> context, SuggestionsBuilder suggestionsBuilder) {
        if (suggestions.isEmpty()) {
            for (Map.Entry<String, WNAbstractStructure> stringSchemFeatureEntry : WNStructures.getRegistry().entrySet()) {
                suggestions.add(stringSchemFeatureEntry.getValue().getPath());
            }
        }

        return ISuggestionProvider.suggestIterable(suggestions, suggestionsBuilder);
    }

    public static WNAbstractStructure getValue(CommandContext<CommandSource> context, String name) throws CommandSyntaxException {
        return context.getArgument(name, WNAbstractStructure.class);
    }

    public static int findTeleportStructure(CommandSource cs, ServerPlayerEntity player, WNAbstractStructure structure) {
        if (player.getEntityWorld().getDimension() instanceof OverworldDimension && WNWorldType.generator != null) {
            StringTextComponent s2 = new StringTextComponent(TextFormatting.AQUA + "Trying to find the nearest " + TextFormatting.GOLD + structure.getName() + TextFormatting.AQUA + " structure");
            WN.sendChatMessage(player, new StringTextComponent("").appendSibling(WN.WNPrefix).appendSibling(s2));
            StringTextComponent sx = new StringTextComponent(TextFormatting.AQUA + "This will take a moment.");
            WN.sendChatMessage(player, new StringTextComponent("").appendSibling(WN.WNPrefix).appendSibling(sx));
            new Thread(new Runnable() {
                @Override
                public void run() {
                    BlockPos strct = lookForStructure(structure,player);
                    if (strct != null) {
                        WN.LOGGER.info("Found nearest structure at " + strct.getX() + " " + strct.getY() + " " + strct.getZ());
                        StringTextComponent s3 = new StringTextComponent(TextFormatting.AQUA + "Found " + TextFormatting.GOLD + structure.getName() + TextFormatting.AQUA + " structure at ");
                        StringTextComponent s4 = new StringTextComponent(TextFormatting.YELLOW + "" + strct.getX() + " " + strct.getY() + " " + strct.getZ());
                        StringTextComponent s42 = new StringTextComponent(TextFormatting.AQUA + " - " + TextFormatting.GOLD + (int) Utilities.getDistance(new BlockPos(player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ()), strct) + TextFormatting.AQUA + " blocks away.");
                        s4.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new StringTextComponent(TextFormatting.GOLD + "Click to copy to the command prompt")));
                        s4.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "" + strct.getX() + " " + strct.getY() + " " + strct.getZ()));
                        WN.sendChatMessage(player, new StringTextComponent("").appendSibling(WN.WNPrefix).appendSibling(s3).appendSibling(s4).appendSibling(s42));
                        StringTextComponent s5 = new StringTextComponent(TextFormatting.GREEN + "Click to teleport");
                        s5.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new StringTextComponent(TextFormatting.GOLD + "Click here")));
                        s5.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tp " + player.getName().getString() + " " + strct.getX() + " " + strct.getY() + " " + strct.getZ()));
                        WN.sendChatMessage(player, new StringTextComponent("").appendSibling(WN.WNPrefix).appendSibling(s5));
                        player.sendStatusMessage(new StringTextComponent(TextFormatting.GREEN + "Found structure " + TextFormatting.AQUA + (int) Utilities.getDistance(new BlockPos(player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ()), strct) + TextFormatting.GREEN + " blocks away"), true);
                    } else {
                        StringTextComponent sa = new StringTextComponent(TextFormatting.RED + "Unable to find structure.");
                        WN.sendChatMessage(player, new StringTextComponent("").appendSibling(WN.WNPrefix).appendSibling(sa));
                    }
                }
            }).start();
        } else {
            StringTextComponent sx = new StringTextComponent(TextFormatting.RED + "Paths not exist in this dimension.");
            WN.sendChatMessage(player, new StringTextComponent("").appendSibling(WN.WNPrefix).appendSibling(sx));
            return 0;
        }
        return 1;
    }

    public static BlockPos lookForStructure(WNAbstractStructure structure, PlayerEntity player) {
        int radius = CommonConfig.maxSearchRadius.get() / 100;

        if(WNWorldType.generator != null) {
            return structure.findNearest(player.getEntityWorld(), WNWorldType.generator, WNWorldType.generator, player.getPosition(), radius,false,(x, z) -> {
                player.sendStatusMessage(new StringTextComponent(TextFormatting.YELLOW + "Searching on chunk " + TextFormatting.GOLD + x + TextFormatting.YELLOW + ", " + TextFormatting.GOLD + z), true);
            });
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
