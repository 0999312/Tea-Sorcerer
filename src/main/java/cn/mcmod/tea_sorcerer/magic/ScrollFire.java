package cn.mcmod.tea_sorcerer.magic;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FireBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.FlintAndSteelItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class ScrollFire extends ItemMagicBase {

	public ScrollFire(Properties properties) {
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
		IWorld iworld = context.getWorld();
		BlockPos blockpos = context.getPos();
		BlockState blockstate = iworld.getBlockState(blockpos);
		playerentity.playSound(SoundEvents.ENTITY_BLAZE_SHOOT, SoundCategory.HOSTILE, 2.0F,
				random.nextFloat() * 0.4F + 0.8F);
		if (FlintAndSteelItem.isUnlitCampfire(blockstate)) {
			iworld.setBlockState(blockpos, blockstate.with(BlockStateProperties.LIT, Boolean.valueOf(true)), 11);
		} else {
			BlockPos blockpos1 = blockpos.offset(context.getFace());
			if (FlintAndSteelItem.canSetFire(iworld.getBlockState(blockpos1), iworld, blockpos1)) {
				BlockState blockstate1 = ((FireBlock) Blocks.FIRE).getStateForPlacement(iworld, blockpos1);
				iworld.setBlockState(blockpos1, blockstate1, 11);
				ItemStack itemstack = context.getItem();
				if (playerentity instanceof ServerPlayerEntity) {
					CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayerEntity) playerentity, blockpos1, itemstack);
					itemstack.damageItem(1, playerentity, (p_219998_1_) -> {
						p_219998_1_.sendBreakAnimation(context.getHand());
					});
				}
			}
		}
	}

}
