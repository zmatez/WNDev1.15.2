package com.matez.wildnature.common.commands;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.config.CommonConfig;
import com.matez.wildnature.world.generation.biome.registry.WNBiomes;
import com.matez.wildnature.world.generation.biome.setup.grid.BiomeGroup;
import com.matez.wildnature.world.generation.biome.setup.grid.BiomeTerrain;
import com.matez.wildnature.world.generation.biome.setup.grid.SubBiome;
import com.matez.wildnature.world.generation.chunk.WNWorldContext;
import com.matez.wildnature.world.generation.layer.grid.GridBiomeLayer;
import com.matez.wildnature.world.generation.provider.WNWorldType;
import com.matez.wildnature.world.generation.transformer.BiomeTransformer;
import com.matez.wildnature.world.generation.transformer.transformers.MainBiomeTransformer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.loading.FMLPaths;

import java.io.File;
import java.util.ArrayList;

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
            WN.sendChatMessage(entity, new StringTextComponent("").appendSibling(WN.WNPrefix).appendSibling(new StringTextComponent(TextFormatting.RED+"Unknown page. Use values from " + TextFormatting.GOLD + "1" + TextFormatting.RED+" to " + TextFormatting.GOLD + maxPages+TextFormatting.RED+".")));
            return 0;
        }
        StringTextComponent s = new StringTextComponent(TextFormatting.GREEN+"Biome List "+TextFormatting.GRAY+" - - - "+TextFormatting.LIGHT_PURPLE+" page " + TextFormatting.AQUA + page + TextFormatting.DARK_AQUA + "/"+TextFormatting.AQUA+maxPages);
        ITextComponent hovermsg = new StringTextComponent(TextFormatting.GRAY + "Showing " + TextFormatting.DARK_AQUA+ list.size() + TextFormatting.GRAY+" biomes")
                .appendSibling(new StringTextComponent(TextFormatting.GRAY+"\n"+"Including " + TextFormatting.DARK_AQUA + WNBiomes.registerBiomes.size() +TextFormatting.GRAY+ " WildNature biomes"));


        s.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,hovermsg));
        StringTextComponent s2 = new StringTextComponent(TextFormatting.GOLD +""+TextFormatting.BOLD + " >>>");
        s2.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,new StringTextComponent(TextFormatting.GREEN+"Click to show next page")));
        s2.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND,"/wn biome list " +(page+1)+""));
        ITextComponent s3 = new StringTextComponent("").appendSibling(WN.WNPrefix).appendSibling(s);
        if(page<maxPages){
            s3.appendSibling(s2);
        }
        WN.sendChatMessage(entity,s3);
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
            WN.sendChatMessage(entity,new StringTextComponent(TextFormatting.DARK_GRAY+"["+index+"]").appendSibling(new StringTextComponent(TextFormatting.AQUA+" ")));
        }else {
            boolean isWildNature = WNBiomes.registerBiomes.contains(biome);
            String wiki = isWildNature ? "https://wildnaturemod.com/"+biome.getRegistryName().getPath().replace("_","-") : "";
            String search = "/wn biome locate "+biome.getRegistryName();


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




            boolean active = !CommonConfig.blacklistedBiomes.contains(biome);
            TextFormatting t = TextFormatting.AQUA;
            if(!active){
                t = TextFormatting.RED;
            }
            StringTextComponent infocomponent = new StringTextComponent(t + new TranslationTextComponent(biome.getTranslationKey()).getFormattedText());
            infocomponent.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,new StringTextComponent(TextFormatting.GOLD+"--- INFORMATION ---").appendSibling(getBiomeInfo(biome))));
            infocomponent.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/wn biome info " + biome.getRegistryName()));
            WN.sendChatMessage(entity, new StringTextComponent(TextFormatting.DARK_GRAY + "[" + index + "] ")
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

    public static ITextComponent getBiomeInfo(Biome biome){
        boolean active = !CommonConfig.blacklistedBiomes.contains(biome);

        BiomeTransformer.TempCategory category = BiomeTransformer.TempCategory.getFromTemperature(-0.1f,1f,biome.getDefaultTemperature());
        BiomeTransformer.WetCategory moisture = BiomeTransformer.WetCategory.getFromMoisture(0f,1f,biome.getDownfall());
        String climaticSpawns = "none";
        String groupSpawns = "none";
        String dictionaries = "none";
        if(WNWorldType.generator != null){
            GridBiomeLayer layer = WNWorldType.generator.getGridProvider().getLayer();
            MainBiomeTransformer transformer = (MainBiomeTransformer) layer.getMainBiomeTransformer();
            ArrayList<BiomeGroup> usedAsBase = new ArrayList<>();
            ArrayList<BiomeGroup> usedAsSub = new ArrayList<>();
            for (MainBiomeTransformer.TerrainCategory terrainValue : MainBiomeTransformer.TerrainCategory.values()) {
                for (BiomeTransformer.TempCategory tempValue : BiomeTransformer.TempCategory.values()) {
                    for (BiomeTransformer.WetCategory wetCategory : BiomeTransformer.WetCategory.values()) {
                        ArrayList<BiomeGroup> usedGroups = new ArrayList<>();
                        for (BiomeGroup climaticBiomeGroup : transformer.getClimaticBiomeGroups(terrainValue, tempValue, wetCategory)) {
                            if(climaticBiomeGroup.getBaseBiome() == biome){
                                if(!usedGroups.contains(climaticBiomeGroup)){
                                    climaticSpawns += TextFormatting.DARK_GRAY+"\n---> " + TextFormatting.DARK_AQUA +"Base: " + terrainValue.getName() + "/" + tempValue.getName() + "/" + wetCategory.getName();
                                }
                                usedAsBase.add(climaticBiomeGroup);
                                usedGroups.add(climaticBiomeGroup);
                            }
                            for (SubBiome subBiome : climaticBiomeGroup.getSubBiomes()) {
                                if(subBiome.getBiome() == biome){
                                    if(!usedGroups.contains(climaticBiomeGroup)){
                                        climaticSpawns += TextFormatting.DARK_GRAY+"\n---> " + TextFormatting.DARK_AQUA + "Sub: " + terrainValue.getName() + "/" + tempValue.getName() + "/" + wetCategory.getName();
                                    }
                                    usedAsSub.add(climaticBiomeGroup);
                                    usedGroups.add(climaticBiomeGroup);
                                }
                            }
                        }
                        usedGroups.clear();
                    }
                }
            }
            String base = "";
            if(usedAsBase.size() > 0) {
                base = "Base biome of:";
                ArrayList<Integer> usedIds = new ArrayList<>();
                for (BiomeGroup group : usedAsBase) {
                    if(!usedIds.contains(group.getId())) {
                        base += TextFormatting.DARK_GRAY+"\n---> " + TextFormatting.DARK_AQUA + "[" + group.getId() + "] " + group.getName();
                        usedIds.add(group.getId());
                    }
                }
                usedIds.clear();
            }else{
                base = "Never spawns as base biome";
            }
            String sub = "";
            if(usedAsSub.size() > 0) {
                sub = "SubBiome in:";
                ArrayList<Integer> usedIds = new ArrayList<>();
                for (BiomeGroup group : usedAsSub) {
                    if(!usedIds.contains(group.getId())) {
                        sub += TextFormatting.DARK_GRAY+"\n---> " + TextFormatting.DARK_AQUA + "[" + group.getId() + "] " + group.getName() + ", base biome: " + group.getBaseBiome().getRegistryName();
                        usedIds.add(group.getId());
                    }
                }
                usedIds.clear();
            }else{
                sub = "Never spawns as sub biome";
            }
            groupSpawns = "\n" + base + "\n---\n" + sub;
            usedAsBase.clear();
            usedAsSub.clear();
        }

        if(!BiomeDictionary.getTypes(biome).isEmpty()) {
            dictionaries = "";
            for (BiomeDictionary.Type type : BiomeDictionary.getTypes(biome)) {
                dictionaries += " " + type.getName();
            }
        }

        ITextComponent infocomponent = new StringTextComponent("")
                .appendSibling(new StringTextComponent(TextFormatting.GRAY+"\n-> " + TextFormatting.DARK_AQUA+"id: " + biome.getRegistryName()))
                .appendSibling(new StringTextComponent(TextFormatting.GRAY+"\n-> " + TextFormatting.DARK_AQUA+"index: " + Registry.BIOME.getId(biome)))
                .appendSibling(new StringTextComponent(TextFormatting.GRAY+"\n-> " + TextFormatting.DARK_AQUA+"mod: " + new TranslationTextComponent(biome.getRegistryName().getNamespace()).getFormattedText()))
                .appendSibling(new StringTextComponent(TextFormatting.GRAY+"\n-> " + TextFormatting.DARK_AQUA+"blacklisted: " + !active))
                .appendSibling(new StringTextComponent(TextFormatting.GRAY+"\n-> " + TextFormatting.DARK_AQUA+"category: " + biome.getCategory().getName()))
                .appendSibling(new StringTextComponent(TextFormatting.GRAY+"\n-> " + TextFormatting.DARK_AQUA+"temp category: " + category.getName()))
                .appendSibling(new StringTextComponent(TextFormatting.GRAY+"\n-> " + TextFormatting.DARK_AQUA+"wet category: " + moisture.getName()))
                .appendSibling(new StringTextComponent(TextFormatting.GRAY+"\n-> " + TextFormatting.DARK_AQUA+"dictionaries: " + dictionaries))
                .appendSibling(new StringTextComponent(TextFormatting.GRAY+"\n-> " + TextFormatting.DARK_AQUA+"spawns in: " + climaticSpawns))
                .appendSibling(new StringTextComponent(TextFormatting.GRAY+"\n-> " + TextFormatting.DARK_AQUA+"groups: " + groupSpawns));
        return infocomponent;
    }
}
