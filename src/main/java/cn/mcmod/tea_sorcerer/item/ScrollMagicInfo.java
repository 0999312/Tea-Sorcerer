package cn.mcmod.tea_sorcerer.item;

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

public class ScrollMagicInfo extends Item {

	public ScrollMagicInfo(Properties p_i48487_1_) {
		super(p_i48487_1_);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
		if(worldIn.isClientSide)
			return super.use(worldIn, playerIn, handIn);
		boolean result = MinecraftForge.EVENT_BUS.post(new EventUseMagic(playerIn, 0, 0));
		if(result)
			return super.use(worldIn, playerIn, handIn);
		LazyOptional<ISpiritCapability> Cap = playerIn.getCapability(CapabilityRegistry.SPIRIT_CAPABILITY);
        Cap.ifPresent((l) -> {
        		l.setLastActionTimer(10);
        		playerIn.sendMessage(new TranslationTextComponent("tea_sorcerer.spirit.info.level",l.getSpiritLevel()), playerIn.getUUID());
        		playerIn.sendMessage(new TranslationTextComponent("tea_sorcerer.spirit.info.amount",l.getSpiritAmount()), playerIn.getUUID());
        	}
        );
		return super.use(worldIn, playerIn, handIn);
	}

}
