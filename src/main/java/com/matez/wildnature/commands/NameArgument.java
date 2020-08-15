package com.matez.wildnature.commands;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

public class NameArgument implements ArgumentType<String> {

    public static NameArgument nameArgument(){
        return new NameArgument();
    }
    @Override
    public String parse(StringReader reader) throws CommandSyntaxException {
        return reader.readString();
    }


}
