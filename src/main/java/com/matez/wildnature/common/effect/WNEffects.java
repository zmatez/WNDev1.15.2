package com.matez.wildnature.common.effect;

import com.matez.wildnature.init.WN;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;

public class WNEffects {
    public static final Effect IVY_POISON = register("ivy_poison",new WNEffect(EffectType.HARMFUL, 5149489));
    public static final Effect SHROOM_POISON = register("shroom_poison",new WNEffect(EffectType.HARMFUL, 3484199));
    public static final Effect MONKSHOOD_POISON = register("monkshood_poison",new WNEffect(EffectType.HARMFUL, 3484199));
    public static final Effect BELLADONNA_POISON = register("belladonna_poison",new WNEffect(EffectType.HARMFUL, 3484199));

    public static void registerAll(RegistryEvent.Register<Effect> registryEvent){
        registryEvent.getRegistry().registerAll(
                IVY_POISON,
                SHROOM_POISON,
                MONKSHOOD_POISON,
                BELLADONNA_POISON
        );
    }

    private static Effect register(String name, Effect effect){
        effect.setRegistryName(new ResourceLocation(WN.modid,name));
        return effect;
    }

}
