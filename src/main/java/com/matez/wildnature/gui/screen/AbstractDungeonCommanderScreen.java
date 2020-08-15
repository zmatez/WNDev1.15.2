package com.matez.wildnature.gui.screen;

import com.google.common.collect.Lists;
import com.matez.wildnature.commands.DungeonCommanderLogic;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.Message;
import com.mojang.brigadier.ParseResults;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.context.CommandContextBuilder;
import com.mojang.brigadier.context.SuggestionContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.Suggestion;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.tree.CommandNode;
import com.mojang.brigadier.tree.LiteralCommandNode;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.chat.NarratorChatListener;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.renderer.Rectangle2d;
import net.minecraft.client.resources.I18n;
import net.minecraft.command.ISuggestionProvider;
import net.minecraft.tileentity.CommandBlockLogic;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextComponentUtils;
import net.minecraft.util.text.TextFormatting;
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