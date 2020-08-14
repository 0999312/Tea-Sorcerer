package cn.mcmod.tea_sorcerer.tea;

import cn.mcmod.tea_sorcerer.capability.CapabilityRegistry;
import cn.mcmod.tea_sorcerer.capability.ISpiritCapability;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.LazyOptional;

public class DrinkTeaSevenMagic extends DrinkTeaBase {

	public DrinkTeaSevenMagic(Properties properties) {
		super(properties);
	}
	
	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
	@Override
	public Rarity getRarity(ItemStack stack) {
		// TODO Auto-generated method stub
		return Rarity.RARE;
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
	        		switch (l.getSpiritLevel()) {
						case 1:
							l.setSpiritLevel(2);
							l.setMaxSpiritAmount(1500);
							break;
						case 2:
							l.setSpiritLevel(3);
							l.setMaxSpiritAmount(2000);
							break;
						case 3:
							l.setSpiritLevel(4);
							l.setMaxSpiritAmount(2500);
							break;
						default:
							break;
					}
	        		l.setSpiritAmount(l.getMaxSpiritAmount());
	        	}
	        );
		}
		return super.onItemUseFinish(stack, worldIn, entityLiving);
	}

}
