package com.matez.wildnature.common.items.blowpipe;

import com.matez.wildnature.common.entity.type.misc.blowpipe.AbstractBlowdartEntity;
import com.matez.wildnature.common.entity.type.misc.blowpipe.BlowdartEntity;
import com.matez.wildnature.common.entity.type.misc.blowpipe.darts.RowanBlowdartEntity;
import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.other.Pair;
import com.matez.wildnature.util.other.Utilities;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.Map;

public class BlowpipeItem extends Item {
    public BlowpipeItem(Properties properties) {
        super(properties);

        this.addPropertyOverride(new ResourceLocation("loaded"), (stack, world, entity) -> {
            return entity != null && entity.isHandActive() && entity.getActiveItemStack() == stack ? 1.0F : 0.0F;
        });
    }

    @Override
    public boolean isCrossbow(ItemStack stack) {
        return stack.getItem() instanceof BlowpipeItem;
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        itemstack.getOrCreateTag().putLong("lastShot",-1);
        Pair<BlowpipeAmmo,ItemStack> ammoPair = getAmmo(playerIn);
        if(ammoPair==null){
            return ActionResult.resultFail(itemstack);
        }
        ItemStack ammo = ammoPair.getValue();
        if(ammo.getCount() <= 0){
            return ActionResult.resultFail(itemstack);
        }
        ItemStack oldItemStack = Utilities.loadItem(itemstack.getOrCreateTag());
        if(oldItemStack.isEmpty() || oldItemStack.getItem() != ammo.getItem()) {
            playerIn.sendStatusMessage(new StringTextComponent(TextFormatting.GRAY + "Loaded " + TextFormatting.RED + ammo.getDisplayName().getFormattedText()), true);
        }
        Utilities.saveItem(itemstack.getOrCreateTag(),ammo);
        playerIn.setActiveHand(handIn);
        return ActionResult.resultConsume(itemstack);
    }

    public void shoot(ItemStack stack, World worldIn, LivingEntity entityLiving){
        Pair<BlowpipeAmmo,ItemStack> ammoPair = getAmmo(entityLiving);
        if(ammoPair==null){
            return;
        }
        ItemStack ammo = ammoPair.getValue();
        if(ammo.getCount() <= 0){
            return;
        }
        BlowpipeAmmo blowpipeAmmo = ammoPair.getKey();
        if(blowpipeAmmo==null){
            return;
        }
        if(entityLiving instanceof PlayerEntity) {
            if(((PlayerEntity)entityLiving).getCooldownTracker().getCooldown(this, 0.0f) > 0.0f){
                return;
            }
        }

        boolean shot = false;
        if(!ammo.isEmpty()){
            int count = Math.min(ammo.getCount(),Utilities.rint(blowpipeAmmo.getMinCount(),blowpipeAmmo.getMaxCount()));
            if(count > 0) {
                if(!(entityLiving.getActiveItemStack().getItem() instanceof BlowpipeItem)){
                    return;
                }
                int charge = 0;
                if(stack.getOrCreateTag().contains("lastShot") && stack.getOrCreateTag().getLong("lastShot") != -1){
                    charge = (int)(((double)(System.currentTimeMillis() - stack.getOrCreateTag().getLong("lastShot")) / 1000) * 20);
                }else {
                    charge = this.getUseDuration(stack) - entityLiving.getItemInUseCount();
                }

                if(entityLiving instanceof PlayerEntity) {
                    charge = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, ((PlayerEntity)entityLiving), charge, !ammo.isEmpty() || ((PlayerEntity)entityLiving).abilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0);
                    if (charge < 0) {
                        return;
                    };
                }

                for (int i = 0; i < count; i++) {
                    float velocity = getDartVelocity(charge);
                    if (!((double)velocity < 0.1D)) {
                        if (!worldIn.isRemote) {
                            AbstractBlowdartEntity blowdartEntity = null;
                            if(blowpipeAmmo.getDartType() == BlowpipeAmmo.DartType.ROWAN){
                                blowdartEntity = new RowanBlowdartEntity(entityLiving,worldIn);
                            }else{
                                return;
                            }

                            blowdartEntity.setDamage(Utilities.rint(0,blowpipeAmmo.getMaxDamageChance())==0 ? (Utilities.rdoub(blowpipeAmmo.getDamage(), blowpipeAmmo.getMaxDamage())) : blowpipeAmmo.getDamage());
                            blowdartEntity.setKnockbackStrength(Utilities.rint(0,blowpipeAmmo.getMaxKnockbackChance())==0 ? (Utilities.rint(blowpipeAmmo.getKnockback(), blowpipeAmmo.getMaxKnockback())) : blowpipeAmmo.getKnockback());
                            blowdartEntity.setItem(blowpipeAmmo.getAmmo());
                            WN.LOGGER.debug("Set item to " + blowdartEntity.getItem().getRegistryName());

                            blowdartEntity.shoot(entityLiving, entityLiving.rotationPitch, entityLiving.rotationYaw, 0.0F, velocity * 6.0F - (0.5f * i), 0.25F * (i + 1));
                            if (velocity >= 1.0F) {
                                blowdartEntity.setIsCritical(true);
                            }

                            int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);
                            if (j > 0) {
                                blowdartEntity.setDamage(blowdartEntity.getDamage() + (blowpipeAmmo.getMaxDamageChance())==0 ? (Utilities.rdoub(blowpipeAmmo.getDamage(), (double)j * 0.25D + 0.25D)) : 0);
                            }

                            int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);
                            if (k > 0) {
                                blowdartEntity.setKnockbackStrength(blowdartEntity.getKnockbackStrength() + k);
                            }

                            if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0) {
                                blowdartEntity.setFire(3);
                            }

                            stack.damageItem(1, entityLiving, (p_220009_1_) -> {
                                p_220009_1_.sendBreakAnimation(entityLiving.getActiveHand());
                            });

                            worldIn.addEntity(blowdartEntity);
                            shot = true;
                        }

                        worldIn.playSound(null, entityLiving.getPosX(), entityLiving.getPosY(), entityLiving.getPosZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (random.nextFloat() * 0.4F + 1.2F) + velocity * 0.5F);
                        if (entityLiving instanceof PlayerEntity) {
                            PlayerEntity playerIn = (PlayerEntity) entityLiving;
                            playerIn.addStat(Stats.ITEM_USED.get(this));
                            if (!playerIn.abilities.isCreativeMode) {
                                ammo.shrink(1);
                            }
                        }
                    }
                }
                if(shot){
                    if(entityLiving instanceof PlayerEntity) {
                        ((PlayerEntity)entityLiving).getCooldownTracker().setCooldown(this, blowpipeAmmo.getCooldown());
                    }
                    stack.getOrCreateTag().putLong("lastShot",System.currentTimeMillis());
                }

            }
        }
    }

    public int getUseDuration(ItemStack stack) {
        return 72000;
    }

    public Pair<BlowpipeAmmo, ItemStack> getAmmo(LivingEntity entity){
        if(entity instanceof PlayerEntity) {
            PlayerEntity playerEntity = (PlayerEntity)entity;
            ItemStack mainHandStack = playerEntity.getHeldItemMainhand();
            ItemStack offHandStack = playerEntity.getHeldItemOffhand();
            for (Map.Entry<String, BlowpipeAmmo> stringBlowpipeAmmoEntry : BlowpipeAmmo.AMMO.entrySet()) {
                BlowpipeAmmo ammo = stringBlowpipeAmmoEntry.getValue();
                if (mainHandStack.getItem() == ammo.getAmmo() && ammo.getMinCount() <= mainHandStack.getCount()) {
                    return new Pair<>(ammo, mainHandStack);
                } else if (offHandStack.getItem() == ammo.getAmmo() && ammo.getMinCount() <= offHandStack.getCount()) {
                    return new Pair<>(ammo, offHandStack);
                }
            }

            for (Map.Entry<String, BlowpipeAmmo> stringBlowpipeAmmoEntry : BlowpipeAmmo.AMMO.entrySet()) {
                for(int i = 0; i < playerEntity.inventory.getSizeInventory(); ++i) {
                    ItemStack stack = playerEntity.inventory.getStackInSlot(i);
                    if(stringBlowpipeAmmoEntry.getValue().getAmmo()==stack.getItem() && stringBlowpipeAmmoEntry.getValue().getMinCount() <= stack.getCount()){
                        return new Pair<>(stringBlowpipeAmmoEntry.getValue(),stack);
                    }
                }
            }
            if(playerEntity.isCreative()){
                for (Map.Entry<String, BlowpipeAmmo> stringBlowpipeAmmoEntry : BlowpipeAmmo.AMMO.entrySet()) {
                    return new Pair<>(stringBlowpipeAmmoEntry.getValue(),new ItemStack(stringBlowpipeAmmoEntry.getValue().getAmmo(),64));
                }
            }
        }else{
            for (Map.Entry<String, BlowpipeAmmo> stringBlowpipeAmmoEntry : BlowpipeAmmo.AMMO.entrySet()) {
                return new Pair<>(stringBlowpipeAmmoEntry.getValue(),new ItemStack(stringBlowpipeAmmoEntry.getValue().getAmmo(),64));
            }
        }
        return null;
    }

    /**
     * Gets the velocity of the dart entity from the pipe's charge
     */
    public static float getDartVelocity(int charge) {
        float f = (float)charge / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }
}
