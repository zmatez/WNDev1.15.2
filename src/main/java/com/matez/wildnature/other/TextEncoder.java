package com.matez.wildnature.other;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;

public class TextEncoder {

    public static ITextComponent encode(String s){
        return ITextComponent.Serializer.fromJson(s);
    }

    public static String decode(ITextComponent t){
        return ITextComponent.Serializer.toJson(t);
    }


}
