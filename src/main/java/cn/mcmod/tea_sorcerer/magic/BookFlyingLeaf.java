package cn.mcmod.tea_sorcerer.magic;

import cn.mcmod.tea_sorcerer.register.ItemRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.stats.Stats;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class BookFlyingLeaf extends ItemMagicBase {

	public BookFlyingLeaf(Properties properties) {
		super(properties);
		this.setSpiritAmonut(100);
		this.setSpiritLevel(2);
		this.setActionTimer(5);
	}

	@Override
	public void UsingItemByRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

    	ItemStack itemstack = this.findAmmo(playerIn);
    	if (!itemstack.isEmpty() || playerIn.abilities.isCreativeMode) {
        for (int i = 0; i < 12; i++) {
            FlyingLeafEntity fukumamelentity = new FlyingLeafEntity(worldIn, playerIn);
            float d0 = (worldIn.rand.nextFloat() * 20.0F) - 10.0F;

            fukumamelentity.shoot(playerIn, playerIn.rotationPitch + d0 * 0.25F, playerIn.rotationYaw + d0, 0.0F, 1.5F, 1F);
            worldIn.addEntity(fukumamelentity);
        }
    	
		if (!playerIn.abilities.isCreativeMode) {
			itemstack.shrink(1);
			if (itemstack.isEmpty()) {
				playerIn.inventory.deleteStack(itemstack);
			}
		}
        playerIn.addStat(Stats.ITEM_USED.get(this));
        }
	}

	@Override
	public void UsingItemByActiveBlock(ItemUseContext context) {
		// DO NOTHING
	}
	private ItemStack findAmmo(PlayerEntity player) {
		if (this.isArrow(player.getHeldItem(Hand.OFF_HAND))) {
			return player.getHeldItem(Hand.OFF_HAND);
		} else if (this.isArrow(player.getHeldItem(Hand.MAIN_HAND))) {
			return player.getHeldItem(Hand.MAIN_HAND);
		} else {
			for (int i = 0; i < player.inventory.getSizeInventory(); ++i) {
				ItemStack itemstack = player.inventory.getStackInSlot(i);

				if (this.isArrow(itemstack)) {
					return itemstack;
				}
			}

			return ItemStack.EMPTY;
		}
	}

	private boolean isArrow(ItemStack itemstack) {
		return itemstack.getItem() == ItemRegistry.tea_knife;
	}
}
