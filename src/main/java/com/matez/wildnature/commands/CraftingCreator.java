package com.matez.wildnature.commands;

import com.matez.wildnature.gui.container.CraftingManagerContainer;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.util.text.TranslationTextComponent;

public class CraftingCreator {
    public CraftingCreator(){

    }

    public int craft(CommandContext<CommandSource> context){
        try {
            if(context.getSource().asPlayer()!=null){
                System.out.println("Opening crafting manager...");
                context.getSource().asPlayer().openContainer(getContainer());

                return 1;
            }

        } catch (CommandSyntaxException e) {
            return 0;
        }
        return 0;
    }
    public INamedContainerProvider getContainer() {
        return new SimpleNamedContainerProvider((p_220270_2_, p_220270_3_, p_220270_4_) -> {
            System.out.println(p_220270_2_ + " x " + p_220270_3_ + " x " + p_220270_4_);
            return new CraftingManagerContainer(p_220270_2_, p_220270_3_);
        }, new TranslationTextComponent("container.crafting"));
    }

}
