package com.matez.wildnature.common.items;

import com.matez.wildnature.client.gui.container.BackpackBigContainer;
import com.matez.wildnature.client.gui.container.BackpackMediumContainer;
import com.matez.wildnature.common.items.dye.IDyeableItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import javax.annotation.Nullable;

public class BackpackBigItem extends PouchItem implements IDyeableItem {
    public BackpackBigItem(Properties properties) {
        super(properties);
    }

    public INamedContainerProvider getContainer() {
        return new INamedContainerProvider() {
            @Override
            public ITextComponent getDisplayName() {
                return new TranslationTextComponent("gui.wildnature.backpack_big");
            }

            @Nullable
            @Override
            public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
                return new BackpackBigContainer(i, playerEntity.getEntityWorld(), playerInventory, playerEntity);
            }
        };

    }
}
