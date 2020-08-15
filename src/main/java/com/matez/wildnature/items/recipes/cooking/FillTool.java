package com.matez.wildnature.items.recipes.cooking;

import com.matez.wildnature.lists.WNItems;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.IStringSerializable;

public enum FillTool implements IStringSerializable {
   MAPLE_BOWL("maple_bowl", WNItems.MAPLE_BOWL),
   DEEP_BOWL("deep_bowl",WNItems.DEEP_BOWL),
   BOWL("bowl", Items.BOWL),
   PLATE("plate", WNItems.PLATE),
   GLASS("glass", WNItems.GLASS),
   JUG("jug", WNItems.JUG),
   CUP("cup", WNItems.CUP),
   GLASS_CUP("glass_cup", WNItems.GLASS_CUP),
   WINE_BOTTLE("wine_bottle", WNItems.WINE_BOTTLE),
   JAR("jar", WNItems.JAR),

   NONE("none",null);

   private final String name;
   private final Item item;


   FillTool(String name, Item item) {
      this.name = name;
      this.item=item;

   }

   public String getName() {
      return this.name;
   }

   public Item getItem() {
      return item;
   }
}