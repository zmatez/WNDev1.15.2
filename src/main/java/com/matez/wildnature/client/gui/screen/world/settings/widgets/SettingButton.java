package com.matez.wildnature.client.gui.screen.world.settings.widgets;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SettingButton extends AbstractSettingButton {
   protected final SettingButton.IPressable onPress;

   public SettingButton(int baseX, int baseY, int width, int height, String text, SettingButton.IPressable onPress) {
      super(baseX, baseY, width, height, text);
      this.onPress = onPress;
   }

   public void onPress() {
      this.onPress.onPress(this);
   }

   @OnlyIn(Dist.CLIENT)
   public interface IPressable {
      void onPress(SettingButton p_onPress_1_);
   }
}
