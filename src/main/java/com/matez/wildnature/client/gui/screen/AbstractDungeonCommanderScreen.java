package com.matez.wildnature.client.gui.screen;

import com.google.common.collect.Lists;
import com.matez.wildnature.common.commands.DungeonCommanderLogic;
import com.mojang.brigadier.ParseResults;
import com.mojang.brigadier.suggestion.Suggestions;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.command.ISuggestionProvider;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public abstract class AbstractDungeonCommanderScreen extends Screen {
   protected TextFieldWidget commandTextField;
   protected TextFieldWidget resultTextField;
   protected Button doneButton;
   protected Button cancelButton;
   protected Button trackOutputButton;
   protected boolean field_195238_s;
   protected final List<String> field_209111_t = Lists.newArrayList();
   protected int field_209112_u;
   protected int field_209113_v;
   protected ParseResults<ISuggestionProvider> field_209114_w;
   protected CompletableFuture<Suggestions> field_209115_x;
   private boolean field_212342_z;

   public AbstractDungeonCommanderScreen() {
      super(new StringTextComponent("Dungeon Commander"));
   }

   public void tick() {
      this.commandTextField.tick();
   }

   public abstract DungeonCommanderLogic getLogic();

}