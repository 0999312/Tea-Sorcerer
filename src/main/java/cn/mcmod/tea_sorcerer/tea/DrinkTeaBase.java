package cn.mcmod.tea_sorcerer.tea;

import org.apache.commons.lang3.tuple.Pair;

import cn.mcmod.tea_sorcerer.register.ItemRegistry;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class DrinkTeaBase extends Item {
	public DrinkTeaBase(Properties properties) {
		super(properties);
	}
	
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        PlayerEntity playerentity = entityLiving instanceof PlayerEntity ? (PlayerEntity) entityLiving : null;

        applyFoodEffects(stack, worldIn, entityLiving);

        if (playerentity == null || !playerentity.abilities.isCreativeMode) {
            stack.shrink(1);
        }

        if (playerentity instanceof ServerPlayerEntity) {
            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayerEntity) playerentity, stack);
        }

        if (playerentity != null) {
            playerentity.addStat(Stats.ITEM_USED.get(this));
        }

        if (playerentity == null || !playerentity.abilities.isCreativeMode) {
            if (stack.isEmpty()) {
                return new ItemStack(ItemRegistry.cup);
            }

            if (playerentity != null) {
                playerentity.inventory.addItemStackToInventory(new ItemStack(ItemRegistry.cup));
            }
        }

        return stack;
    }

    private void applyFoodEffects(ItemStack p_213349_1_, World p_213349_2_, LivingEntity p_213349_3_) {
        Item item = p_213349_1_.getItem();
        if (item.isFood()) {
            for (Pair<EffectInstance, Float> pair : item.getFood().getEffects()) {
                if (!p_213349_2_.isRemote && pair.getLeft() != null && p_213349_2_.rand.nextFloat() < pair.getRight()) {
                    p_213349_3_.addPotionEffect(new EffectInstance(pair.getLeft()));
                }
            }
        }
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        playerIn.setActiveHand(handIn);
        return new ActionResult<>(ActionResultType.SUCCESS, playerIn.getHeldItem(handIn));
    }

    @Override
    public UseAction getUseAction(ItemStack p_77661_1_) {
        return UseAction.DRINK;
    }
}
