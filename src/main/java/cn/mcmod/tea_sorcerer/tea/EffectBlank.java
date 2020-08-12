package cn.mcmod.tea_sorcerer.tea;

import cn.mcmod.tea_sorcerer.Main;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class EffectBlank extends Effect {

	public EffectBlank(String name,EffectType typeIn, int liquidColorIn) {
		super(typeIn, liquidColorIn);
		this.setRegistryName(Main.MODID, name);
	}

}
