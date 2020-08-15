package com.matez.wildnature.data;

import com.matez.wildnature.Main;
import com.matez.wildnature.commands.LocatePath;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.storage.WorldSavedData;

public class PathData extends WorldSavedData {
    public PathData(String name) {
        super(name);
    }

    @Override
    public void read(CompoundNBT nbt) {
        try {
            ListNBT nbtList = (ListNBT) nbt.get("pathList");
            for (INBT inbt : nbtList) {
                CompoundNBT n = (CompoundNBT) inbt;
                BlockPos p = new BlockPos(n.getInt("x"),n.getInt("y"),n.getInt("z"));
                LocatePath.paths.add(p);
            }
        }catch (Exception e){
            Main.LOGGER.debug("Unable to load paths");
        }
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        ListNBT nbt = new ListNBT();
        for (BlockPos path : LocatePath.paths) {
            CompoundNBT n = new CompoundNBT();
            n.putInt("x",path.getX());
            n.putInt("y",path.getY());
            n.putInt("z",path.getZ());
            nbt.add(n);
        }
        compound.put("pathList",nbt);
        return compound;
    }
}
