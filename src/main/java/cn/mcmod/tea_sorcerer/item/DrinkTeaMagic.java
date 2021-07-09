package cn.mcmod.tea_sorcerer.item;

import cn.mcmod_mmf.mmlib.item.ItemDrinkBase;
import cn.mcmod_mmf.mmlib.item.info.FoodInfo;
import net.minecraft.item.ItemStack;

public class DrinkTeaMagic extends ItemDrinkBase {

	public DrinkTeaMagic(Properties prop, FoodInfo info) {
		super(prop, info);
	}

	@Override
	public boolean isFoil(ItemStack p_77636_1_) {
		return true;
	}
	
}
