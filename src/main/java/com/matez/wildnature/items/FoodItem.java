package com.matez.wildnature.items;

import com.matez.wildnature.items.recipes.cooking.FillTool;
import com.matez.wildnature.lists.WNItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class FoodItem extends Item {
    public FoodItem(Properties p_i48487_1_) {
        super(p_i48487_1_);
    }

    private FillTool fillTool;
    public FoodItem(Properties p_i48487_1_, FillTool fillTool) {
        super(p_i48487_1_);
        this.fillTool=fillTool;
        WNItems.FOOD.add(this);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        IHaveRecipe.addInformation(this,stack,worldIn,tooltip,flagIn);
    }

    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        super.onItemUseFinish(stack,worldIn,entityLiving);
        if (entityLiving instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverplayerentity = (ServerPlayerEntity)entityLiving;
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayerentity, stack);
            serverplayerentity.addStat(Stats.ITEM_USED.get(this));
        }

        if (entityLiving instanceof PlayerEntity && !((PlayerEntity)entityLiving).abilities.isCreativeMode) {
            stack.shrink(1);
        }

        if(stack==null){
            return new ItemStack(fillTool.getItem());
        }
        if(fillTool==null){
            return ItemStack.EMPTY;
        }
        return stack.isEmpty() ? new ItemStack(fillTool.getItem()) : stack;
    }

}
