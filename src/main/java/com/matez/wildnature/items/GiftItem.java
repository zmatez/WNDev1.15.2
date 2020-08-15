package com.matez.wildnature.items;

import com.matez.wildnature.other.Utilities;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class GiftItem extends Item {
    private GiftColor color;
    public GiftItem(Properties properties, GiftColor color) {
        super(properties.maxStackSize(1));
        this.color=color;
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        ItemStack i = context.getPlayer().getHeldItem(context.getHand());
        ItemStack gift = Utilities.loadItem(i.getTag());

        if(gift.isEmpty()) {
            return ActionResultType.PASS;
        }else{
            context.getPlayer().setHeldItem(context.getHand(),gift);
            context.getWorld().playSound(context.getPlayer(),context.getPlayer().getPosition(),SoundEvents.ENTITY_PLAYER_LEVELUP,SoundCategory.MASTER,0.8F,1.1F);
            return ActionResultType.SUCCESS;
        }
    }

    @Override
    public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        ItemStack gift = Utilities.loadItem(stack.getTag());
        if(!gift.isEmpty() && !stack.getOrCreateTag().contains("owner")){
            stack.getOrCreateTag().putString("owner",playerIn.getDisplayName().getFormattedText());
        }
    }

    @OnlyIn(Dist.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        ItemStack gift = Utilities.loadItem(stack.getTag());
        return !gift.isEmpty();
    }


    public enum GiftColor implements IStringSerializable {
        CYAN_RED("cyan_red"),
        RED_YELLOW("red_yellow"),
        BLUE_PINK("blue_pink");

        public static final GiftColor[] VALUES = values();
        private final String name;

        private GiftColor(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return null;
        }
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {

        if(stack.getOrCreateTag().contains("owner")){
            tooltip.add(new StringTextComponent(TextFormatting.GRAY+"from " + TextFormatting.DARK_PURPLE+stack.getOrCreateTag().getString("owner")));
        }else {

            if (color == GiftItem.GiftColor.CYAN_RED) {
                tooltip.add(new StringTextComponent(TextFormatting.DARK_AQUA + I18n.format("color.minecraft.cyan") + TextFormatting.GRAY + " & " + TextFormatting.RED + I18n.format("color.minecraft.red")));
            }
            if (color == GiftItem.GiftColor.RED_YELLOW) {
                tooltip.add(new StringTextComponent(TextFormatting.RED + I18n.format("color.minecraft.red") + TextFormatting.GRAY + " & " + TextFormatting.YELLOW + I18n.format("color.minecraft.yellow")));
            }
            if (color == GiftItem.GiftColor.BLUE_PINK) {
                tooltip.add(new StringTextComponent(TextFormatting.DARK_BLUE + I18n.format("color.minecraft.blue") + TextFormatting.GRAY + " & " + TextFormatting.LIGHT_PURPLE + I18n.format("color.minecraft.pink")));
            }
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }




}
