package cn.mcmod.tea_sorcerer.tea;

import cn.mcmod.tea_sorcerer.Main;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;

public class EffectFresh extends Effect {
	public EffectFresh(EffectType typeIn, int liquidColorIn) {
		super(typeIn, liquidColorIn);
		this.setRegistryName(Main.MODID,"fresh");
	}
	@Override
	public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
		  entityLivingBaseIn.removePotionEffect(Effects.POISON);
		  entityLivingBaseIn.removePotionEffect(Effects.WITHER);
		  entityLivingBaseIn.removePotionEffect(Effects.NAUSEA);
	}
	@Override
	public boolean isReady(int duration, int amplifier) {
		return (duration & 1) == 0;
	}
}
