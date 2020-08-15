package com.matez.wildnature.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class GeyserEssenceItem extends Item {
    private int ticksLeft = 60;
    private int tick = 0;
    public GeyserEssenceItem(Properties properties) {
        super(properties);
    }


    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        tick++;
        if(tick>=20){
            tick=0;
            sec(stack,worldIn,entityIn);
        }
    }



    public void sec(ItemStack stack, World worldIn, Entity entityIn){
        if(stack.getOrCreateTag().contains("ticksLeft")){
            stack.getTag().putInt("ticksLeft",stack.getTag().getInt("ticksLeft")-1);
            if (stack.getTag().getInt("ticksLeft") <= 0) {
                stack.shrink(1);
            }
        }else{
            stack.getTag().putInt("ticksLeft",ticksLeft);
        }
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent(TextFormatting.DARK_PURPLE+"Unstable"));
        if(stack.getOrCreateTag().contains("ticksLeft")) {
            if (stack.getTag().getInt("ticksLeft") != ticksLeft) {
                tooltip.add(new StringTextComponent(TextFormatting.GRAY + "Time to disappear: " + TextFormatting.RED + " " + Math.round(stack.getTag().getInt("ticksLeft"))));

            }
        }
    }
}
