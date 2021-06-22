package cn.mcmod.tea_sorcerer.effect;

import cn.mcmod.tea_sorcerer.Versions;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EffectRegister {
	public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, Versions.MODID);
	
	public static final RegistryObject<Effect> FRESH = EFFECTS.register("fresh", EffectFresh::new);
	
	public static final RegistryObject<Effect> MAGIC_INCREASE = EFFECTS.register("magic_increase", ()->new EffectBlank(EffectType.BENEFICIAL, 0x579943));
	public static final RegistryObject<Effect> IMMOTRAL = EFFECTS.register("immortal", ()->new EffectBlank(EffectType.BENEFICIAL, 0x7F0000));
}
