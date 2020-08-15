package com.matez.wildnature.items;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class WrappingPaperItem extends Item {
    private GiftItem.GiftColor color;
    public WrappingPaperItem(Properties properties, GiftItem.GiftColor color) {
        super(properties);
        this.color=color;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if(color== GiftItem.GiftColor.CYAN_RED) {
            tooltip.add(new StringTextComponent(TextFormatting.DARK_AQUA+I18n.format("color.minecraft.cyan")+TextFormatting.GRAY+" & " +TextFormatting.RED+I18n.format("color.minecraft.red")));
        }
        if(color== GiftItem.GiftColor.RED_YELLOW) {
            tooltip.add(new StringTextComponent(TextFormatting.RED+I18n.format("color.minecraft.red")+TextFormatting.GRAY+" & " +TextFormatting.YELLOW+I18n.format("color.minecraft.yellow")));
        }
        if(color== GiftItem.GiftColor.BLUE_PINK) {
            tooltip.add(new StringTextComponent(TextFormatting.DARK_BLUE+I18n.format("color.minecraft.blue")+TextFormatting.GRAY+" & " +TextFormatting.LIGHT_PURPLE+I18n.format("color.minecraft.pink")));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
