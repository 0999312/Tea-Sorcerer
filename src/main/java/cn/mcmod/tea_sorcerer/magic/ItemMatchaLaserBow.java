package cn.mcmod.tea_sorcerer.magic;

import java.util.List;

import cn.mcmod.tea_sorcerer.capability.CapabilityRegistry;
import cn.mcmod.tea_sorcerer.capability.ISpiritCapability;
import cn.mcmod.tea_sorcerer.register.ItemRegistry;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.util.LazyOptional;

public class ItemMatchaLaserBow extends Item {

	public ItemMatchaLaserBow(Properties properties) {
		super(properties);
	      this.addPropertyOverride(new ResourceLocation("pull"), (p_210310_0_, p_210310_1_, p_210310_2_) -> {
	          if (p_210310_2_ == null) {
	             return 0.0F;
	          } else {
	             return !(p_210310_2_.getActiveItemStack().getItem() instanceof ItemMatchaLaserBow) ? 0.0F : (float)(p_210310_0_.getUseDuration() - p_210310_2_.getItemInUseCount()) / 20.0F;
	          }
	       });
	       this.addPropertyOverride(new ResourceLocation("pulling"), (p_210309_0_, p_210309_1_, p_210309_2_) -> {
	          return p_210309_2_ != null && p_210309_2_.isHandActive() && p_210309_2_.getActiveItemStack() == p_210309_0_ ? 1.0F : 0.0F;
	       });
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		tooltip.add(new TranslationTextComponent("tea_sorcerer.spirit_level_request", 0));
		tooltip.add(new TranslationTextComponent("tea_sorcerer.spirit_amonut_request", 100));
		tooltip.add(new TranslationTextComponent("tea_sorcerer.wip_item"));
	}
	
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {
		if (entityLiving instanceof PlayerEntity) {
			PlayerEntity playerentity = (PlayerEntity) entityLiving;
			ItemStack itemstack = this.findAmmo(playerentity);
			boolean flag1 = playerentity.abilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
	        int i = this.getUseDuration(stack) - timeLeft;
	        i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, playerentity, i, !itemstack.isEmpty() || flag1);
	        if (i < 0) return;

			if (!worldIn.isRemote) {
				LazyOptional<ISpiritCapability> Cap = playerentity.getCapability(CapabilityRegistry.SPIRIT_CAPABILITY);
				Cap.ifPresent((l) -> {
					if (l.getSpiritAmount() >= 100)
						l.setSpiritAmount(l.getSpiritAmount() - 100);
					else
						playerentity.attackEntityFrom(new DamageSource("use_too_much_spirit"), 4F);
					l.setLastActionTimer(50);
				});
				float f = 0.4F;
				MatchaBeamEntity beam = new MatchaBeamEntity(worldIn, playerentity, MathHelper.sin(playerentity.rotationYaw / 180.0F * (float) Math.PI)
						* MathHelper.cos(playerentity.rotationPitch / 180.0F * (float) Math.PI) * f / 2D,
						-(MathHelper.cos(playerentity.rotationYaw / 180.0F * (float) Math.PI)
								* MathHelper.cos(playerentity.rotationPitch / 180.0F * (float) Math.PI) * f) / 2D,
						MathHelper.sin(playerentity.rotationPitch / 180.0F * (float) Math.PI) * f / 2D);
				beam.setPosition(beam.getPosX(), playerentity.getPosY() + (double) (playerentity.getEyeHeight()), beam.getPosZ());
				beam.setRotation(playerentity.rotationYaw + 180, -playerentity.rotationPitch);
				worldIn.addEntity(beam);
				playerentity.playSound(SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.PLAYERS, 1.0F,
						1.0F / (random.nextFloat() * 0.4F + 1.2F) + 0.5F);
				if (!flag1 && !playerentity.abilities.isCreativeMode) {
					itemstack.shrink(1);
					if (itemstack.isEmpty()) {
						playerentity.inventory.deleteStack(itemstack);
					}
				}

				playerentity.addStat(Stats.ITEM_USED.get(this));
			}
		}
	}

	/**
	 * How long it takes to use or consume an item
	 */
	public int getUseDuration(ItemStack stack) {
		return 72000;
	}

	/**
	 * returns the action that specifies what animation to play when the items
	 * is being used
	 */
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.BOW;
	}

	/**
	 * Called to trigger the item's "innate" right click behavior. To handle
	 * when this item is used on a Block, see {@link #onItemUse}.
	 */
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		boolean flag = !playerIn.findAmmo(itemstack).isEmpty();

		ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, worldIn,
				playerIn, handIn, flag);
		if (ret != null)
			return ret;

		if (!playerIn.abilities.isCreativeMode && !flag) {
			return ActionResult.resultFail(itemstack);
		} else {
			playerIn.setActiveHand(handIn);
			return ActionResult.resultConsume(itemstack);
		}
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
		return itemstack.getItem() == ItemRegistry.mocha;
	}
}
