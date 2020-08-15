package com.matez.wildnature.commands;

import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomes;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.biome.Biome;

import java.util.ArrayList;

public class BiomeListCommandX {

    private static ArrayList<ArrayList<Biome>> pages = new ArrayList<>();
    private static ArrayList<Biome> savedBiomes = new ArrayList<>();

    private static int perPage = 5;
    private static int biomeint = 0;
    private static int fullbiome = 0;
    private static int currentPage = 0;
    public static void prepare(){
        Registry.BIOME.forEach(biome -> {
            fullbiome++;
            if(biomeint>perPage){
                biomeint=0;
            }
            if(biomeint==0){
                pages.add(new ArrayList<>());
                currentPage++;
            }

            ArrayList<Biome> a = pages.get(currentPage-1);
            a.add(biome);
            savedBiomes.add(biome);
            biomeint++;
        });
    }

    public static boolean show(int page){
        if(page>pages.size()){
            return false;
        }
        ArrayList<ITextComponent> tx = new ArrayList<>();
        pages.get(page-1).forEach(biome -> {
            boolean isWildNature = WNBiomes.registerBiomes.contains(biome);
            String wiki = isWildNature ? "wildnaturemod.com/"+biome.getRegistryName().getPath().replace("_","-") : "";
            String search = "/wn biome tp "+biome.getRegistryName();
            boolean active = !CommonConfig.blacklistedBiomes.contains(biome);
            boolean subbiome = !WNBiomes.generatorBiomes.contains(biome);
            int biomeint = savedBiomes.indexOf(biome)+1;

            StringTextComponent line = new StringTextComponent("");

            StringTextComponent s = new StringTextComponent("");
            //tx.add();
        });



        return true;
    }


}
