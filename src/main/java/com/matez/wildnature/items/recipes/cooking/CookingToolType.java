package com.matez.wildnature.items.recipes.cooking;

import net.minecraft.util.IStringSerializable;

public enum CookingToolType implements IStringSerializable {
   POT("pot"),
   FRYING_PAN("frying_pan"),
   CAKE_PAN("cake_pan"),
   NONE("none");

   private final String name;


   CookingToolType(String name) {
      this.name = name;

   }

   public String getName() {
      return this.name;
   }

}