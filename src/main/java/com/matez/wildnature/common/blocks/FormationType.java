package com.matez.wildnature.common.blocks;

import net.minecraft.util.IStringSerializable;

public enum FormationType implements IStringSerializable {
   BIG("big", 0),
   SMALL("small", 1);

   public static final FormationType[] VALUES = values();
   private final String name;
   private final int opposite;

   private FormationType(String name, int oppositeIn) {
      this.name = name;
      this.opposite = oppositeIn;
   }

   public String getName() {
      return this.name;
   }

   public FormationType opposite() {
      return VALUES[this.opposite];
   }
}