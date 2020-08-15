package com.matez.wildnature.commands;

import com.matez.wildnature.Main;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraftforge.fml.loading.FMLPaths;

import java.io.File;
import java.util.ArrayList;

public class GetFiles {


    private int maxPages;
    private PlayerEntity entity;
    private ArrayList list;
    public GetFiles(PlayerEntity entity){
        this.list=getFiles();
        int i = list.size()/5;

        int a = 0;
        while(a<list.size()){
            a=a+5;
            maxPages++;
        }


        this.entity=entity;

    }

    public int showPage(int page){
        if(maxPages<page){
            Main.sendChatMessage(entity, new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(new StringTextComponent(TextFormatting.RED+"Unknown page. Use values from " + TextFormatting.GOLD + "1" + TextFormatting.RED+" to " + TextFormatting.GOLD + maxPages+TextFormatting.RED+".")));
            return 0;
        }
        File folder = new File(FMLPaths.CONFIGDIR.get().resolve("wildnature/export").toString());
        StringTextComponent s = new StringTextComponent(TextFormatting.GREEN+"Showing all available files "+TextFormatting.GRAY+" - - - "+TextFormatting.LIGHT_PURPLE+" page " + TextFormatting.AQUA + page + TextFormatting.DARK_AQUA + "/"+TextFormatting.AQUA+maxPages);
        s.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,new StringTextComponent(TextFormatting.AQUA+"Found " + TextFormatting.DARK_AQUA + list.size() + TextFormatting.AQUA+" files in \n" + TextFormatting.DARK_PURPLE + folder.getPath() + TextFormatting.GREEN+"\nClick to open in Explorer")));
        s.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE,folder.getPath()));
        StringTextComponent s2 = new StringTextComponent(TextFormatting.GOLD +""+TextFormatting.BOLD + " >>>");
        s2.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,new StringTextComponent(TextFormatting.GREEN+"Click to show next page")));
        s2.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND,"/wn dev files " +(page+1)+""));
        ITextComponent s3 = new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s);
        if(page<maxPages){
            s3.appendSibling(s2);
        }
        Main.sendChatMessage(entity,s3);
        int startIndex = page*5-5;
        for (int i = 0; i <5; i++){
            try {
                showListLine((String) list.get(startIndex + i), startIndex + i + 1 + "");
            }catch(Exception e){
                showListLine("", "-");
            }
        }

        return 1;
    }

    public void showListLine(String x, String index){
        Main.sendChatMessage(entity,new StringTextComponent(TextFormatting.GOLD+" ["+index+"]").appendSibling(new StringTextComponent(TextFormatting.AQUA+" "+x)));
    }

    public static ArrayList<String> getFiles() {
        ArrayList<String> files = new ArrayList<>();
        File folder = new File(FMLPaths.CONFIGDIR.get().resolve("wildnature/export").toString());
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                //listFilesForFolder(fileEntry);
            } else {
                files.add(fileEntry.getName());
            }
        }
        return files;
    }
}
