package com.matez.wildnature.client.gui.screen;

import com.matez.wildnature.client.gui.container.BackpackBigContainer;
import com.matez.wildnature.client.gui.container.BackpackMediumContainer;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BackpackBigScreen extends ContainerScreen<BackpackBigContainer> {
   private static final ResourceLocation BACKPACK_TEXTURE = new ResourceLocation("wildnature:textures/gui/backpack_big.png");

   public BackpackBigScreen(BackpackBigContainer backpack, PlayerInventory inv, ITextComponent text) {
      super(backpack, inv, text);
      this.passEvents = false;
      this.ySize = 196;
      this.xSize = 224;
   }

   public void render(int p_render_1_, int p_render_2_, float p_render_3_) {
      this.renderBackground();
      super.render(p_render_1_, p_render_2_, p_render_3_);
      this.renderHoveredToolTip(p_render_1_, p_render_2_);
   }

   /**
    * Draw the foreground layer for the GuiContainer (everything in front of the items)
    */
   protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
      this.font.drawString(this.title.getFormattedText(), 8.0F, 9.0F, 0xe0e0e0);
      this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 32.0F, (float)(this.ySize - 96 + 2), 0xe0e0e0);
   }

   /**
    * Draws the background layer of this container (behind the items).
    */
   protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
      GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.minecraft.getTextureManager().bindTexture(BACKPACK_TEXTURE);
      int i = (this.width - this.xSize) / 2;
      int j = (this.height - this.ySize) / 2;
      this.blit(i, j, 0, 0, this.xSize, this.ySize);
   }
}