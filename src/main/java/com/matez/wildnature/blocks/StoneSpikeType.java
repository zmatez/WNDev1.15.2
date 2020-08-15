package com.matez.wildnature.blocks;

import net.minecraft.util.IStringSerializable;

public enum StoneSpikeType implements IStringSerializable {
   STALAGMITE("stalagmite", 0),
   STALACTITE("stalactite", 1);

   public static final StoneSpikeType[] VALUES = values();
   private final String name;
   private final int opposite;

   private StoneSpikeType(String name, int oppositeIn) {
      this.name = name;
      this.opposite = oppositeIn;
   }

   public String getName() {
      return this.name;
   }

   public StoneSpikeType opposite() {
      return VALUES[this.opposite];
   }
}