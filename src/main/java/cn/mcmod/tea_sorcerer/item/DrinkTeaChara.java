package cn.mcmod.tea_sorcerer.item;

import java.util.List;

import cn.mcmod_mmf.mmlib.item.ItemDrinkBase;
import cn.mcmod_mmf.mmlib.item.info.FoodInfo;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class DrinkTeaChara extends ItemDrinkBase {

	public DrinkTeaChara(Properties prop, FoodInfo info) {
		super(prop, info);
	}

	@Override
	public boolean isFoil(ItemStack p_77636_1_) {
		return true;
	}
	
	@Override
	public void appendHoverText(ItemStack p_77624_1_, World p_77624_2_, List<ITextComponent> p_77624_3_,
			ITooltipFlag p_77624_4_) {
		super.appendHoverText(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);
		p_77624_3_.add(new TranslationTextComponent("line." + this.getDescriptionId()));
	}
}
