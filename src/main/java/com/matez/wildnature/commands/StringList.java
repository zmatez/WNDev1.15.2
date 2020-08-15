package com.matez.wildnature.commands;

import com.matez.wildnature.Main;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;

import java.util.ArrayList;

public class StringList {
    private int maxPages;
    private int pageLength=10;
    private StringTextComponent title, format;
    private PlayerEntity entity;
    private ArrayList list;
    public StringList(ArrayList arrayList, StringTextComponent title, StringTextComponent format, PlayerEntity entity){
        int i = arrayList.size()/pageLength;
        if(i==Math.round(arrayList.size()/pageLength)){
            maxPages=i;
        }else{
            maxPages=i+1;
        }
        this.title=title;
        this.format=format;
        this.entity=entity;
        this.list=arrayList;
    }

    public void showPage(int page){
        Main.sendChatMessage(entity,title.appendText(" " + TextFormatting.AQUA + page + TextFormatting.DARK_AQUA + "/"+TextFormatting.AQUA+maxPages));
        int startIndex = page-1;
        for (int i = 0; i <pageLength; i++){
            showListLine((String)list.get(startIndex+i));
        }
    }

    public void showListLine(String x){
        Main.sendChatMessage(entity,format.appendText(" "+x));
    }

}
