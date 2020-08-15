package com.matez.wildnature.blocks;

import com.matez.wildnature.Main;
import com.matez.wildnature.customizable.CommonConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootContext;

import java.util.ArrayList;
import java.util.List;

public class RockBase extends BlockBase{
    //0 - skały typu kamień(normalne) (0-255)
    //1 - skały osadowe (55-255)
    //2 - skały metamorficzne (30-55)
    //3 - skały magmowe (5-30)
    private int type;
    private int size = CommonConfig.rockChance.get();
    private int count = CommonConfig.rockSize.get();
    private ResourceLocation regName;
    private static Properties Properties(Properties properties, int type){
        properties.sound(SoundType.STONE);
        if(type==0) {
            properties.hardnessAndResistance(1.5F, 6F);
        }else if(type==1){
            properties.hardnessAndResistance(1.2F, 3F);
        }else if(type==2){
            properties.hardnessAndResistance(1.6F, 7F);
        }else if(type==3){
            properties.hardnessAndResistance(2F, 9F);
        }
        return properties;
    }

    public RockBase(Properties properties, Item.Properties builder, ResourceLocation regName, int type) {
        super(Properties(properties, type), builder, regName);
        this.regName=regName;
        this.type=type;
    }

    public int getType() {
        return type;
    }

    public int getSize() {
        return size;
    }

    public int getCount() {
        return count;
    }

    public int getMinYByType(int seaLevel){
        int defaultMinY = Math.round(seaLevel/3);
        if(type==0){
            return 0;
        }else if(type==1){
            return defaultMinY+defaultMinY+5;
        }else if(type==2){
            return defaultMinY+5;
        }else if(type==3){
            return 5;
        }
        return 0;
    }

    public int getMaxYByType(int seaLevel, int worldHeight){
        int defaultMaxY = Math.round(seaLevel/3);
        if(type==0){
            return worldHeight;
        }else if(type==1){
            return seaLevel;//47-63
        }else if(type==2){
            return defaultMaxY+defaultMaxY+5;//26-47
        }else if(type==3){
            return defaultMaxY+5;//5-26
        }
        return 0;
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        boolean silkTouch = false;
        List<ItemStack> list = new ArrayList<>();
        String rock = regName.getPath().toString();
        list.add(new ItemStack(Main.getBlockByID("wildnature:"+rock+"_cobble"), 1));


        return list;
    }

}
