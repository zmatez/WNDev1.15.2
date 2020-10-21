package com.matez.wildnature.commands;

import com.matez.wildnature.Main;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import javafx.util.Pair;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;

import java.util.ArrayList;
import java.util.Comparator;

public class StructureListCommand {


    private int maxPages;
    private final PlayerEntity entity;
    private final ArrayList<Pair<String, SchemFeature>> schemFeatures = new ArrayList<>();
    public StructureListCommand(PlayerEntity entity){
        int a = 0;
        while(a< SchemFeature.schemFeatures.size()){
            a=a+10;
            maxPages++;
        }

        SchemFeature.schemFeatures.forEach((key,value)-> {
            schemFeatures.add(new Pair<>(key,value));
        });

        schemFeatures.sort(new Comparator<Pair<String, SchemFeature>>() {
            @Override
            public int compare(Pair<String, SchemFeature> o1, Pair<String, SchemFeature> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        this.entity=entity;
    }

    public int showPage(int page){
        if(maxPages<page){
            Main.sendChatMessage(entity, new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(new StringTextComponent(TextFormatting.RED+"Unknown page. Use values from " + TextFormatting.GOLD + "1" + TextFormatting.RED+" to " + TextFormatting.GOLD + maxPages+TextFormatting.RED+".")));
            return 0;
        }
        StringTextComponent s = new StringTextComponent(TextFormatting.GREEN+"Structure List "+TextFormatting.GRAY+" - - - "+TextFormatting.LIGHT_PURPLE+" page " + TextFormatting.AQUA + page + TextFormatting.DARK_AQUA + "/"+TextFormatting.AQUA+maxPages);
        ITextComponent hovermsg = new StringTextComponent(TextFormatting.GRAY + "Showing " + TextFormatting.DARK_AQUA+ SchemFeature.schemFeatures.size() + TextFormatting.GRAY+" structures");


        s.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,hovermsg));
        StringTextComponent s2 = new StringTextComponent(TextFormatting.GOLD +""+TextFormatting.BOLD + " >>>");
        s2.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,new StringTextComponent(TextFormatting.GREEN+"Click to show next page")));
        s2.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND,"/wn structure list " +(page+1)+""));
        ITextComponent s3 = new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s);
        if(page<maxPages){
            s3.appendSibling(s2);
        }
        Main.sendChatMessage(entity,s3);
        int startIndex = page*10-10;
        for (int i = 0; i <10; i++){
            try {
                showListLine(SchemFeature.schemFeatures.values().toArray()[startIndex + i], startIndex + i + 1 + "");
            }catch(Exception e){
                showListLine(null, "-");
            }
        }

        return 1;
    }

    public void showListLine(Object obj, String index){
        if(!(obj instanceof SchemFeature)){
            Main.sendChatMessage(entity,new StringTextComponent(TextFormatting.DARK_GRAY+"["+index+"]").appendSibling(new StringTextComponent(TextFormatting.AQUA+" ")));
        }else {
            SchemFeature f = (SchemFeature) obj;
            StringTextComponent infocomponent = new StringTextComponent(f.getClass().getSimpleName().toLowerCase());
            /*infocomponent.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,new StringTextComponent(TextFormatting.GOLD+"--- INFORMATION ---")
                    .appendSibling(new StringTextComponent(TextFormatting.GRAY+"\n-> " + TextFormatting.DARK_AQUA+"id: " + biome.getRegistryName()))
                    .appendSibling(new StringTextComponent(TextFormatting.GRAY+"\n-> " + TextFormatting.DARK_AQUA+"index: " + Registry.BIOME.getId(biome)))
                    .appendSibling(new StringTextComponent(TextFormatting.GRAY+"\n-> " + TextFormatting.DARK_AQUA+"mod: " + new TranslationTextComponent(biome.getRegistryName().getNamespace()).getFormattedText()))
                    .appendSibling(new StringTextComponent(TextFormatting.GRAY+"\n-> " + TextFormatting.DARK_AQUA+"active: " + active))
                    .appendSibling(new StringTextComponent(TextFormatting.GRAY+"\n-> " + TextFormatting.DARK_AQUA+"sub-biome: " + subbiome))
            ));*/

            Main.sendChatMessage(entity, new StringTextComponent(TextFormatting.DARK_GRAY + "[" + index + "] " + TextFormatting.AQUA)
                    .appendSibling(infocomponent));
        }
    }
}
