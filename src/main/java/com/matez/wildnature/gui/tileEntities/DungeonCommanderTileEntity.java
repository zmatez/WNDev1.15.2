package com.matez.wildnature.gui.tileEntities;


import com.matez.wildnature.commands.DungeonCommanderLogic;
import com.matez.wildnature.gui.initGuis;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.command.CommandSource;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class DungeonCommanderTileEntity extends TileEntity {
   private boolean powered;
   private boolean sendToClient;
   private final DungeonCommanderLogic DungeonCommanderLogic = new DungeonCommanderLogic() {
      /**
       * Sets the command.
       */
      public void setCommand(String command) {
         super.setCommand(command);
         DungeonCommanderTileEntity.this.markDirty();
      }

      public ServerWorld getWorld() {
         return (ServerWorld) DungeonCommanderTileEntity.this.world;
      }

      public void updateCommand() {
         BlockState blockstate = DungeonCommanderTileEntity.this.world.getBlockState(DungeonCommanderTileEntity.this.pos);
         this.getWorld().notifyBlockUpdate(DungeonCommanderTileEntity.this.pos, blockstate, blockstate, 3);
      }

      @OnlyIn(Dist.CLIENT)
      public Vec3d getPositionVector() {
         return new Vec3d((double) DungeonCommanderTileEntity.this.pos.getX() + 0.5D, (double) DungeonCommanderTileEntity.this.pos.getY() + 0.5D, (double) DungeonCommanderTileEntity.this.pos.getZ() + 0.5D);
      }

      public CommandSource getCommandSource() {
         return new CommandSource(this, new Vec3d((double) DungeonCommanderTileEntity.this.pos.getX() + 0.5D, (double) DungeonCommanderTileEntity.this.pos.getY() + 0.5D, (double) DungeonCommanderTileEntity.this.pos.getZ() + 0.5D), Vec2f.ZERO, this.getWorld(), 2, this.getName().getString(), this.getName(), this.getWorld().getServer(), (Entity)null);
      }
   };

   public DungeonCommanderTileEntity() {
      super(initGuis.DUNGEON_COMMANDER);
   }

   public CompoundNBT write(CompoundNBT compound) {
      super.write(compound);
      //System.out.println(getDungeonCommanderLogic().getCommand());
      compound = this.DungeonCommanderLogic.write(compound);
      //System.out.println("WRITE " + compound.getString("Command"));
      compound.putBoolean("powered", this.isPowered());
      return compound;
   }

   public void read(CompoundNBT compound) {
      super.read(compound);

      this.DungeonCommanderLogic.read(compound);
      //System.out.println("READ " + getDungeonCommanderLogic().getCommand());
      this.powered = compound.getBoolean("powered");
   }

   @Nullable
   public SUpdateTileEntityPacket getUpdatePacket() {
      if (this.isSendToClient()) {
         this.setSendToClient(false);
         CompoundNBT compoundnbt = this.write(new CompoundNBT());
         return new SUpdateTileEntityPacket(this.pos, 2, compoundnbt);
      } else {
         return null;
      }
   }

   /**
    * Checks if players can use this tile entity to access operator (permission level 2) commands either directly or
    * indirectly, such as give or setblock. A similar method exists for entities at {@link
    * net.minecraft.entity.Entity#ignoreItemEntityData()}.<p>For example, {@link
    * net.minecraft.tileentity() signs} (player right-clicking) and {@link
    * net.minecraft.tileentity() command blocks} are considered
    * accessible.</p>@return true if this block entity offers ways for unauthorized players to use restricted commands
    */
   public boolean onlyOpsCanSetNbt() {
      return true;
   }

   public DungeonCommanderLogic getDungeonCommanderLogic() {
      return this.DungeonCommanderLogic;
   }

   public void setPowered(boolean poweredIn) {
      this.powered = poweredIn;
   }

   public boolean isPowered() {
      return this.powered;
   }




   public boolean isSendToClient() {
      return this.sendToClient;
   }

   public void setSendToClient(boolean p_184252_1_) {
      this.sendToClient = p_184252_1_;
   }

   public DungeonCommanderTileEntity.Mode getMode() {
      Block block = this.getBlockState().getBlock();
      return DungeonCommanderTileEntity.Mode.REDSTONE;
   }

   /**
    * validates a tile entity
    */
   public void validate() {
      this.updateContainingBlockInfo();
      super.validate();
   }



   public static enum Mode {
      SEQUENCE,
      AUTO,
      REDSTONE;
   }
}