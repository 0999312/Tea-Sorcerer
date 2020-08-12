package cn.mcmod.tea_sorcerer.magic;

import cn.mcmod.tea_sorcerer.capability.CapabilityRegistry;
import cn.mcmod.tea_sorcerer.capability.ISpiritCapability;
import cn.mcmod.tea_sorcerer.event.EventUseMagic;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.LazyOptional;

public class ItemMagicInfo extends Item {

	public ItemMagicInfo(Properties properties) {
		super(properties);
	}
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		if(worldIn.isRemote)
			return super.onItemRightClick(worldIn, playerIn, handIn);
		boolean result = MinecraftForge.EVENT_BUS.post(new EventUseMagic(playerIn, 0, 0));
		if(result)
			return super.onItemRightClick(worldIn, playerIn, handIn);
		LazyOptional<ISpiritCapability> Cap = playerIn.getCapability(CapabilityRegistry.SPIRIT_CAPABILITY);
        Cap.ifPresent((l) -> {
        		l.setLastActionTimer(10);
        		playerIn.sendMessage(new TranslationTextComponent("tea_sorcerer.spirit.info.level",l.getSpiritLevel()));
        		playerIn.sendMessage(new TranslationTextComponent("tea_sorcerer.spirit.info.amount",l.getSpiritAmount()));
        	}
        );
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

}
