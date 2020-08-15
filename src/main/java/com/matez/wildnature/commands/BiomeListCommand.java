package com.matez.wildnature.commands;

import com.matez.wildnature.Main;
import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.world.gen.biomes.setup.WNBiome;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.loading.FMLPaths;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class BiomeListCommand {


    private int maxPages;
    private PlayerEntity entity;
    private ArrayList<Biome> list;
    public BiomeListCommand(PlayerEntity entity){
        this.list=new ArrayList();
        Registry.BIOME.forEach(biome -> {
            list.add(biome);
        });
        int i = list.size()/10;

        int a = 0;
        while(a<list.size()){
            a=a+10;
            maxPages++;
        }


        this.entity=entity;

    }

    public int showPage(int page){
        if(maxPages<page){
            Main.sendChatMessage(entity, new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(new StringTextComponent(TextFormatting.RED+"Unknown page. Use values from " + TextFormatting.GOLD + "1" + TextFormatting.RED+" to " + TextFormatting.GOLD + maxPages+TextFormatting.RED+".")));
            return 0;
        }
        StringTextComponent s = new StringTextComponent(TextFormatting.GREEN+"Biome List "+TextFormatting.GRAY+" - - - "+TextFormatting.LIGHT_PURPLE+" page " + TextFormatting.AQUA + page + TextFormatting.DARK_AQUA + "/"+TextFormatting.AQUA+maxPages);
        ITextComponent hovermsg = new StringTextComponent(TextFormatting.GRAY + "Showing " + TextFormatting.DARK_AQUA+ list.size() + TextFormatting.GRAY+" biomes")
                .appendSibling(new StringTextComponent(TextFormatting.GRAY+"\n"+"Including " + TextFormatting.DARK_AQUA + WNBiomes.registerBiomes.size() +TextFormatting.GRAY+ " WildNature biomes"));


        s.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,hovermsg));
        StringTextComponent s2 = new StringTextComponent(TextFormatting.GOLD +""+TextFormatting.BOLD + " >>>");
        s2.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,new StringTextComponent(TextFormatting.GREEN+"Click to show next page")));
        s2.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND,"/wn biome list " +(page+1)+""));
        ITextComponent s3 = new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s);
        if(page<maxPages){
            s3.appendSibling(s2);
        }
        Main.sendChatMessage(entity,s3);
        int startIndex = page*10-10;
        for (int i = 0; i <10; i++){
            try {
                showListLine(list.get(startIndex + i), startIndex + i + 1 + "");
            }catch(Exception e){
                showListLine(null, "-");
            }
        }

        return 1;
    }

    public void showListLine(Biome biome, String index){
        if(biome==null){
            Main.sendChatMessage(entity,new StringTextComponent(TextFormatting.DARK_GRAY+"["+index+"]").appendSibling(new StringTextComponent(TextFormatting.AQUA+" ")));
        }else {
            boolean isWildNature = WNBiomes.registerBiomes.contains(biome);
            String wiki = isWildNature ? "https://wildnaturemod.com/"+biome.getRegistryName().getPath().replace("_","-") : "";
            String search = "/wn biome locate "+biome.getRegistryName();
            boolean active = !CommonConfig.blacklistedBiomes.contains(biome);
            boolean subbiome = !WNBiomes.generatorBiomes.contains(biome);

            StringTextComponent wikicomponent = null;
            if(wiki.isEmpty()){
                wikicomponent = new StringTextComponent(TextFormatting.LIGHT_PURPLE+"-");
                wikicomponent.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new StringTextComponent(TextFormatting.DARK_RED + "Wiki unavailable for this biome")));
            }else {
                wikicomponent = new StringTextComponent(TextFormatting.LIGHT_PURPLE+"W");
                wikicomponent.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new StringTextComponent(TextFormatting.DARK_PURPLE + "Click to see the wiki page for this biome")));
                wikicomponent.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, wiki));
            }

            StringTextComponent searchcomponent = new StringTextComponent(TextFormatting.GREEN + "T");
            searchcomponent.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,new StringTextComponent(TextFormatting.DARK_GREEN+"Click to teleport")));
            searchcomponent.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND,search));

            TextFormatting t = TextFormatting.AQUA;
            if(!active){
                t = TextFormatting.RED;
            }


            StringTextComponent infocomponent = new StringTextComponent(t + new TranslationTextComponent(biome.getTranslationKey()).getFormattedText());
            infocomponent.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,new StringTextComponent(TextFormatting.GOLD+"--- INFORMATION ---")
                    .appendSibling(new StringTextComponent(TextFormatting.GRAY+"\n-> " + TextFormatting.DARK_AQUA+"id: " + biome.getRegistryName()))
                    .appendSibling(new StringTextComponent(TextFormatting.GRAY+"\n-> " + TextFormatting.DARK_AQUA+"index: " + Registry.BIOME.getId(biome)))
                    .appendSibling(new StringTextComponent(TextFormatting.GRAY+"\n-> " + TextFormatting.DARK_AQUA+"mod: " + new TranslationTextComponent(biome.getRegistryName().getNamespace()).getFormattedText()))
                    .appendSibling(new StringTextComponent(TextFormatting.GRAY+"\n-> " + TextFormatting.DARK_AQUA+"active: " + active))
                    .appendSibling(new StringTextComponent(TextFormatting.GRAY+"\n-> " + TextFormatting.DARK_AQUA+"sub-biome: " + subbiome))


            ));

            Main.sendChatMessage(entity, new StringTextComponent(TextFormatting.DARK_GRAY + "[" + index + "] ")
                    .appendSibling(new StringTextComponent(TextFormatting.GOLD+""+TextFormatting.BOLD+"|"))
                    .appendSibling(wikicomponent)
                    .appendSibling(new StringTextComponent(TextFormatting.GOLD+""+TextFormatting.BOLD+":"))
                    .appendSibling(searchcomponent)
                    .appendSibling(new StringTextComponent(TextFormatting.GOLD+""+TextFormatting.BOLD+"|"))
                    .appendSibling(new StringTextComponent(TextFormatting.GRAY+" - "))
                    .appendSibling(infocomponent));
        }
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
