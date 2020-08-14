package cn.mcmod.tea_sorcerer.magic;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class ScrollWood extends ItemMagicBase {

	public ScrollWood(Properties properties) {
		super(properties);
		this.setSpiritAmonut(50);
		this.setSpiritLevel(1);
		this.setActionTimer(5);
	}

	@Override
	public void UsingItemByRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		playerIn.playSound(SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 1.5F,
				random.nextFloat() * 0.4F + 0.8F);
	}

	@Override
	public void UsingItemByActiveBlock(ItemUseContext context) {
		PlayerEntity playerentity = context.getPlayer();
		playerentity.playSound(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 2.0F,
				random.nextFloat() * 0.4F + 0.8F);
		Items.BONE_MEAL.onItemUse(context);
	}

}
