package com.matez.wildnature.common.items.blowpipe;

import com.matez.wildnature.util.lists.WNItems;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class BlowpipeAmmo {
    public static final HashMap<String, BlowpipeAmmo> AMMO = new HashMap<>();
    public static void registerAll(){
        register("rowanberry_red",new BlowpipeAmmo(WNItems.ROWANBERRY_RED, 60,5,0,0.5f,16,0,1,16,1,5,DartType.ROWAN));
        register("rowanberry_orange",new BlowpipeAmmo(WNItems.ROWANBERRY_ORANGE, 60,5,0,0.5f,16,0,1,16,1,5, DartType.ROWAN));
    }

    public static void register(String name,BlowpipeAmmo ammo){
        AMMO.put(name, ammo);
        ammo.setName(name);
    }

    private Item ammo;
    private int loadDuration;
    private int cooldown;
    private float damage;
    private float maxDamage;
    private int maxDamageChance;
    private int knockback;
    private int maxKnockback;
    private int maxKnockbackChance;
    private int minCount = 1;
    private int maxCount = 1;
    private String name;
    private DartType dartType;
    public BlowpipeAmmo(Item ammo, int loadDuration, int cooldown, float damage, float maxDamage, int maxDamageChance, int knockback, int maxKnockback, int maxKnockbackChance, int minCount, int maxCount, DartType dartType){
        this.ammo = ammo;
        this.loadDuration = loadDuration;
        this.cooldown = cooldown;
        this.damage = damage;
        this.maxDamage = maxDamage;
        this.maxDamageChance = maxDamageChance;
        this.knockback = knockback;
        this.maxKnockback = maxKnockback;
        this.maxKnockbackChance = maxKnockbackChance;
        this.minCount = minCount;
        this.maxCount = maxCount;
        this.dartType = dartType;
    }

    public int getKnockback() {
        return knockback;
    }

    public int getMaxKnockback() {
        return maxKnockback;
    }

    public int getMaxKnockbackChance() {
        return maxKnockbackChance;
    }

    public DartType getDartType() {
        return dartType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public int getMinCount() {
        return minCount;
    }

    public float getDamage() {
        return damage;
    }

    public float getMaxDamage() {
        return maxDamage;
    }

    public int getCooldown() {
        return cooldown;
    }

    public int getLoadDuration() {
        return loadDuration;
    }

    public int getMaxDamageChance() {
        return maxDamageChance;
    }

    public Item getAmmo() {
        return ammo;
    }

    public enum DartType{
        ROWAN
    }
}
