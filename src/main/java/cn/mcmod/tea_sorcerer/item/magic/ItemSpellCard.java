package cn.mcmod.tea_sorcerer.item.magic;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public abstract class ItemSpellCard extends ItemMagicBase {

	public ItemSpellCard(Properties p_i48487_1_) {
		super(p_i48487_1_);
	}
	

	@Override
	public boolean UsingItemByRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		return false;
	}

	@Override
	public boolean UsingItemByActiveBlock(ItemUseContext context) {
		return false;
	}

}
