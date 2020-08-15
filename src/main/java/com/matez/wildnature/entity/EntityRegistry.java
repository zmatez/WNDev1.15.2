package com.matez.wildnature.entity;

import com.matez.wildnature.entity.type.animal.bird.SparrowEntity;
import com.matez.wildnature.entity.type.animal.boar.BoarEntity;
import com.matez.wildnature.entity.type.animal.deer.AbstractDeerEntity;
import com.matez.wildnature.entity.type.animal.deer.BuckEntity;
import com.matez.wildnature.entity.type.animal.deer.DoeEntity;
import com.matez.wildnature.entity.type.animal.deer.FawnEntity;
import com.matez.wildnature.entity.type.animal.duck.*;
import com.matez.wildnature.entity.type.animal.fish.PiranhaEntity;
import com.matez.wildnature.entity.type.animal.insect.DragonflyEntity;
import com.matez.wildnature.entity.type.monster.GoblinEntity;
import com.matez.wildnature.gui.tileEntities.seat.SeatEntity;
import com.matez.wildnature.lists.WNItems;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;

import java.util.ArrayList;
import java.util.Arrays;

public class EntityRegistry {

    public static EntityType<GoblinEntity> GOBLIN = (EntityType<GoblinEntity>) EntityType.Builder.<GoblinEntity>create(GoblinEntity::new, EntityClassification.MONSTER).build("wildnature:goblin").setRegistryName("wildnature:goblin");

    //ANIMALS
    //ducks
    public static EntityType<DrakeEntity> DRAKE = (EntityType<DrakeEntity>) EntityType.Builder.<DrakeEntity>create(DrakeEntity::new, EntityClassification.CREATURE).size(0.4F, 0.7F).build("wildnature:drake").setRegistryName("wildnature:drake");
    public static EntityType<DuckEntity> DUCK = (EntityType<DuckEntity>) EntityType.Builder.<DuckEntity>create(DuckEntity::new, EntityClassification.CREATURE).size(0.4F, 0.7F).build("wildnature:duck").setRegistryName("wildnature:duck");
    public static EntityType<DucklingEntity> DUCKLING = (EntityType<DucklingEntity>) EntityType.Builder.<DucklingEntity>create(DucklingEntity::new, EntityClassification.CREATURE).size(0.2F, 0.3F).build("wildnature:duckling").setRegistryName("wildnature:duckling");

    //deers
    public static EntityType<BuckEntity> BUCK = (EntityType<BuckEntity>) EntityType.Builder.<BuckEntity>create(BuckEntity::new, EntityClassification.CREATURE).size(1.4F, 2.2F).build("wildnature:buck").setRegistryName("wildnature:buck");
    public static EntityType<DoeEntity> DOE = (EntityType<DoeEntity>) EntityType.Builder.<DoeEntity>create(DoeEntity::new, EntityClassification.CREATURE).size(1.4F, 2.2F).build("wildnature:doe").setRegistryName("wildnature:doe");
    public static EntityType<FawnEntity> FAWN = (EntityType<FawnEntity>) EntityType.Builder.<FawnEntity>create(FawnEntity::new, EntityClassification.CREATURE).size(1F, 1.7F).build("wildnature:fawn").setRegistryName("wildnature:fawn");


    public static EntityType<BoarEntity> BOAR = (EntityType<BoarEntity>) EntityType.Builder.<BoarEntity>create(BoarEntity::new, EntityClassification.CREATURE).size(1F, 1F).build("wildnature:boar").setRegistryName("wildnature:boar");

    public static EntityType<PiranhaEntity> PIRANHA = (EntityType<PiranhaEntity>) EntityType.Builder.<PiranhaEntity>create(PiranhaEntity::new, EntityClassification.CREATURE).size(0.7F, 0.9F).build("wildnature:piranha").setRegistryName("wildnature:piranha");

    public static EntityType<DragonflyEntity> DRAGONFLY = (EntityType<DragonflyEntity>) EntityType.Builder.<DragonflyEntity>create(DragonflyEntity::new, EntityClassification.CREATURE).size(0.2F, 0.3F).build("wildnature:dragonfly").setRegistryName("wildnature:dragonfly");

    //birds
    public static EntityType<SparrowEntity> SPARROW_MALE = (EntityType<SparrowEntity>) EntityType.Builder.<SparrowEntity>create(SparrowEntity::new, EntityClassification.CREATURE).size(0.3F, 0.4F).build("wildnature:sparrow_male").setRegistryName("wildnature:sparrow_female");

    //SEAT
    public static EntityType<SeatEntity> SEAT = (EntityType<SeatEntity>) EntityType.Builder.<SeatEntity>create(SeatEntity::new, EntityClassification.CREATURE).size(0.3F, 0.4F).build("wildnature:seat").setRegistryName("wildnature:seat");


    public static void registerSpawningEggs(final RegistryEvent.Register<Item> register){
        WNItems.GOBLIN_EGG = registerSpawningEggs(GOBLIN,0x6c6d57,0x635136,"goblin_egg");

        WNItems.DRAKE_EGG = registerSpawningEggs(DRAKE,0x2A6425,0x422F2B,"drake_egg");
        WNItems.DUCK_EGG = registerSpawningEggs(DUCK,0x636363,0x515151,"duck_egg");


        register.getRegistry().registerAll(registerSpawningEggs());
    }

    public static Item[] registerSpawningEggs(){
        return new Item[]{
                //WNItems.DRAKE_EGG,WNItems.DUCK_EGG
        };
    }

    public static Item registerSpawningEggs(EntityType<?> type, int color1, int color2, String name){
        SpawnEggItem item = new SpawnEggItem(type,color1,color2,new Item.Properties().group(ItemGroup.MISC));
        item.setRegistryName(name);
        return item;
    }

    public static void registerEntitySpawns(){
        ArrayList<Biome> biomes = new ArrayList<>();
        Registry.BIOME.forEach(biomes::add);
        //registerEntitySpawns(GOBLIN,2,2,1,EntityClassification.MONSTER, (Biome[])biomes.toArray());
        //registerEntitySpawns(DRAKE,5,5,3,EntityClassification.MONSTER, Biomes.RIVER, WNBiomes.River,WNBiomes.AmazonRiver,WNBiomes.ColdLake,WNBiomes.WarmLake,Biomes.BEACH,Biomes.SNOWY_BEACH,WNBiomes.WhiteBeach);
        //registerEntitySpawns(DUCK,5,5,3,EntityClassification.MONSTER, Biomes.RIVER, WNBiomes.River,WNBiomes.AmazonRiver,WNBiomes.ColdLake,WNBiomes.WarmLake,Biomes.BEACH,Biomes.SNOWY_BEACH,WNBiomes.WhiteBeach);

    }

    public static void registerEntitySpawns(EntityType<?> type, int weight, int max, int min,EntityClassification e, Biome... biomes){
        Arrays.asList(biomes).forEach(biome -> {
            if(biome!=null){
                biome.getSpawns(e).add(new Biome.SpawnListEntry(type,weight,min,max));
            }
        });
    }
}
