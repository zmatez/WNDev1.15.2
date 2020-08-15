package com.matez.wildnature.items;

import com.matez.wildnature.gui.container.CraftingManagerContainer;
import com.matez.wildnature.gui.container.PouchContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.List;

public class PouchItem extends Item {
    public PouchItem(Properties properties) {
        super(properties);
    }


    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if(!playerIn.getHeldItem(handIn).getOrCreateTag().contains("owner")){
            playerIn.getHeldItem(handIn).getOrCreateTag().putString("owner",playerIn.getDisplayName().getFormattedText());
        }
        if (!playerIn.getEntityWorld().isRemote) {
            //((ServerPlayerEntity)context.getPlayer()).openContainer(getContainer());
            NetworkHooks.openGui((ServerPlayerEntity)playerIn,getContainer());
            return new ActionResult<>(ActionResultType.SUCCESS, playerIn.getHeldItem(handIn));
        }
        return new ActionResult<>(ActionResultType.FAIL, playerIn.getHeldItem(handIn));
    }

    @Override
    public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        if(!stack.getOrCreateTag().contains("owner")){
            stack.getOrCreateTag().putString("owner",playerIn.getDisplayName().getFormattedText());
        }
    }

    public INamedContainerProvider getContainer() {
        return new INamedContainerProvider()
        {
            @Override
            public ITextComponent getDisplayName()
            {
                return new TranslationTextComponent("gui.wildnature.pouch");
            }

            @Nullable
            @Override
            public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity)
            {
                return new PouchContainer(i, playerEntity.getEntityWorld(),playerInventory,playerEntity);
            }
        };

    }

    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);

        if(stack.getOrCreateTag().contains("owner")){
            tooltip.add(new StringTextComponent(TextFormatting.GRAY+"Owner: " + TextFormatting.DARK_PURPLE+stack.getOrCreateTag().getString("owner")));
        }

        NonNullList<ItemStack> nonnulllist = NonNullList.withSize(27, ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(stack.getOrCreateTag(), nonnulllist);
        int i = 0;
        int j = 0;

        for(ItemStack itemstack : nonnulllist) {
            if (!itemstack.isEmpty()) {
                ++j;
                if (i <= 4) {
                    ++i;
                    ITextComponent itextcomponent = itemstack.getDisplayName().deepCopy().applyTextStyle(TextFormatting.DARK_AQUA);
                    ITextComponent itextcomponent2 = new StringTextComponent("").appendText(" x").appendText(String.valueOf(itemstack.getCount())).applyTextStyle(TextFormatting.GRAY);
                    tooltip.add(itextcomponent.appendSibling(itextcomponent2));
                }
            }
        }

        if (j - i > 0) {
            tooltip.add((new TranslationTextComponent("container.shulkerBox.more", j - i)).applyTextStyle(TextFormatting.GRAY).applyTextStyle(TextFormatting.ITALIC));
        }

    }
}
