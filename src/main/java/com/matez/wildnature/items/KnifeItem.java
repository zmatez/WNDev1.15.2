package com.matez.wildnature.items;

import com.matez.wildnature.items.recipes.KnifeCrafting;
import com.matez.wildnature.lists.WNItems;
import com.matez.wildnature.other.Utilities;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class KnifeItem extends SwordItem {


    public KnifeItem(IItemTier p_i48460_1_, int p_i48460_2_, float p_i48460_3_, Properties p_i48460_4_) {
        super(p_i48460_1_, p_i48460_2_, p_i48460_3_, p_i48460_4_);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity playerEntity, Hand hand) {
        ActionResult<ItemStack> a =super.onItemRightClick(world, playerEntity, hand);
        ItemStack stack = playerEntity.getHeldItem(hand);
        ItemStack s = Utilities.loadItem(stack.getOrCreateTag());
        if(s!=null && !s.isEmpty()){
            playerEntity.inventory.addItemStackToInventory(KnifeCrafting.getValidItem(s.getItem()));
            stack.setTag(new CompoundNBT());
            stack.damageItem(1, playerEntity, (p_220045_0_) -> {
                p_220045_0_.sendBreakAnimation(hand);
            });
            return new ActionResult<>(ActionResultType.SUCCESS, stack);
        }
        return a;
    }

    @Override
    public void addInformation(ItemStack p_77624_1_, @Nullable World p_77624_2_, List<ITextComponent> p_77624_3_, ITooltipFlag p_77624_4_) {
        super.addInformation(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);
        ItemStack s = Utilities.loadItem(p_77624_1_.getOrCreateTag());
        if(s!=null && !s.isEmpty()){
            ITextComponent chop = (new StringTextComponent("").appendSibling(new StringTextComponent(TextFormatting.GRAY+ "Chopped "+TextFormatting.WHITE + s.getDisplayName().getFormattedText())));
            ITextComponent chop2 = (new StringTextComponent("").appendSibling(new StringTextComponent(TextFormatting.GRAY+ "Right click to get result.")));
            p_77624_3_.add(chop);
            p_77624_3_.add(chop2);
        }
    }
}
