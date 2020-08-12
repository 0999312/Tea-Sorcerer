package cn.mcmod.tea_sorcerer.capability;

import javax.annotation.Nullable;

import cn.mcmod.tea_sorcerer.Main;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = Main.MODID)
public class CapabilityRegistry {
	@CapabilityInject(ISpiritCapability.class)
	public static Capability<ISpiritCapability> SPIRIT_CAPABILITY;

	@SubscribeEvent
	public static void onCapabilityRegistry(FMLCommonSetupEvent event) {
		CapabilityManager.INSTANCE.register(ISpiritCapability.class, new Capability.IStorage<ISpiritCapability>() {
			@Nullable
			@Override
			public INBT writeNBT(Capability<ISpiritCapability> capability, ISpiritCapability instance, Direction side) {
				return null;
			}

			@Override
			public void readNBT(Capability<ISpiritCapability> capability, ISpiritCapability instance, Direction side, INBT nbt) {

			}
		}, () -> null);
	}
}
