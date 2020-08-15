package com.matez.wildnature.gui.screen;

import com.matez.wildnature.gui.tileEntities.DungeonCommanderTileEntity;
import com.matez.wildnature.commands.DungeonCommanderLogic;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.CommandBlockScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.CommandBlockLogic;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class DungeonCommanderScreen extends AbstractDungeonCommanderScreen implements INamedContainerProvider {
   private final DungeonCommanderTileEntity commandBlock;

   public DungeonCommanderScreen(DungeonCommanderTileEntity commandBlockIn) {
      this.commandBlock = commandBlockIn;
   }


   public DungeonCommanderLogic getLogic() {
      return this.commandBlock.getDungeonCommanderLogic();
   }

   public int func_195236_i() {
      return 135;
   }

   protected void init() {
      super.init();
      commandTextField.setText(commandBlock.getDungeonCommanderLogic().getCommand());
      this.doneButton.active = true;
      this.trackOutputButton.active = true;
   }


   public void resize(Minecraft p_resize_1_, int p_resize_2_, int p_resize_3_) {
      super.resize(p_resize_1_, p_resize_2_, p_resize_3_);
      this.doneButton.active = true;
      this.trackOutputButton.active = true;
   }

   protected void func_195235_a(CommandBlockLogic logic) {
      commandBlock.getDungeonCommanderLogic().setCommand(commandTextField.getText());
      logic.setCommand(commandTextField.getText());
      System.out.println("DungeonCommander command set: " + logic.getCommand());
      //this.minecraft.getConnection().sendPacket(new CUpdateCommandBlockPacket(new BlockPos(logic.getPositionVector()), this.commandTextField.getText(), CommandBlockTileEntity.Mode.REDSTONE, logic.shouldTrackOutput(), false, false));
   }


   @Override
   public ITextComponent getDisplayName() {
      return new StringTextComponent("wildnature:dungeon_commander");
   }

   @Nullable
   @Override
   public Container createMenu(int p_createMenu_1_, PlayerInventory p_createMenu_2_, PlayerEntity p_createMenu_3_) {
      System.out.println("Trying to open DungeonCommander");
      return null;
   }
}