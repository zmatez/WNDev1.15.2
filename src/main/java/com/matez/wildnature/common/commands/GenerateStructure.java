package com.matez.wildnature.common.commands;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.world.generation.structures.WNAbstractStructure;
import com.matez.wildnature.world.generation.structures.WNStructures;
import com.matez.wildnature.world.generation.structures.nature.SchemFeature;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import net.minecraft.command.CommandSource;
import net.minecraft.command.ISuggestionProvider;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.server.ServerWorld;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class GenerateStructure implements ArgumentType<WNAbstractStructure> {

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

    public static int generateStructure(CommandSource cs, ServerPlayerEntity player, BlockPos pos, WNAbstractStructure structure, boolean force) {
        ServerWorld w = cs.getWorld();
        boolean success = false;
        if(force){
            success = structure.generate(w,w.getChunkProvider().getChunkGenerator(),w.getRandom(),pos);
        }else{
            success = structure.generate(w,w.getChunkProvider().getChunkGenerator(),w.getRandom(),pos);
        }

        ITextComponent output = null;
        if(!success){
            output = new StringTextComponent("").appendSibling(WN.WNPrefix).appendSibling(new StringTextComponent(TextFormatting.RED + "Unable to place blocks."));
            WN.sendChatMessage(player,output);
            return 0;
        }

        String name = structure.getName();
        output = new StringTextComponent("").appendSibling(WN.WNPrefix).appendSibling(new StringTextComponent(TextFormatting.GREEN + "Generated " + TextFormatting.LIGHT_PURPLE + name + TextFormatting.GREEN + " on " + TextFormatting.YELLOW + (pos.getX() + " " + pos.getY() + " " + pos.getZ()) + TextFormatting.GREEN + "."));


        WN.sendChatMessage(player,output);
        return 1;
    }

}