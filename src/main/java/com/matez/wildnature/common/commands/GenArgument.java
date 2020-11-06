package com.matez.wildnature.common.commands;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.world.generation.structures.nature.SchemFeature;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.context.StringRange;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.Suggestion;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class GenArgument implements ArgumentType {

    public static GenArgument INSTANCE(){
        return new GenArgument();
    }

    private ArrayList<Suggestion> suggestions = new ArrayList<>();
    @Override
    public SchemFeature parse(StringReader reader) throws CommandSyntaxException {
        int x = 0;
        while(x< WN.treesList.size()){
            if(reader.getString().equals(WN.treesList.get(x).getClass().getSimpleName())){
                return WN.treesList.get(x);
            }
            x++;
        }
        return null;
    }

    @Override
    public CompletableFuture<Suggestions> listSuggestions(CommandContext context, SuggestionsBuilder builder) {

        int x =0;
        while(x< WN.treesList.size()){
            suggestions.add(new Suggestion(StringRange.at(0), WN.treesList.get(x).getClass().getSimpleName()));
            x++;
        }

        return CompletableFuture.completedFuture(Suggestions.create("tree", suggestions));
    }

}
