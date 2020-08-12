package cn.mcmod.tea_sorcerer.tea;

import cn.mcmod.tea_sorcerer.capability.CapabilityRegistry;
import cn.mcmod.tea_sorcerer.capability.ISpiritCapability;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.LazyOptional;

public class DrinkTeaMagic extends DrinkTeaBase {

	public DrinkTeaMagic(Properties properties) {
		super(properties);
	}
	
	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
	
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
		if(!worldIn.isRemote){
			PlayerEntity playerIn = entityLiving instanceof PlayerEntity ? (PlayerEntity) entityLiving : null;
	        if (playerIn == null || !playerIn.abilities.isCreativeMode) {
	        	return super.onItemUseFinish(stack, worldIn, entityLiving);
	        }
			LazyOptional<ISpiritCapability> Cap = playerIn.getCapability(CapabilityRegistry.SPIRIT_CAPABILITY);
	        Cap.ifPresent((l) -> {
	        		l.setLastActionTimer(10);
	        		int amount = l.getSpiritAmount()+500;
	        		if(amount<l.getMaxSpiritAmount())
	        			l.setSpiritAmount(amount);
	        		else
	        			l.setSpiritAmount(l.getMaxSpiritAmount());
	        	}
	        );
		}
		return super.onItemUseFinish(stack, worldIn, entityLiving);
	}

}
