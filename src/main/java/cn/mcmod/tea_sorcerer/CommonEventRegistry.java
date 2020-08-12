package cn.mcmod.tea_sorcerer;

import cn.mcmod.tea_sorcerer.capability.CapabilityRegistry;
import cn.mcmod.tea_sorcerer.capability.ISpiritCapability;
import cn.mcmod.tea_sorcerer.capability.SpiritCapabilityProvider;
import cn.mcmod.tea_sorcerer.event.EventUseMagic;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber()
public class CommonEventRegistry {
	@SubscribeEvent
	public static void onAttachCapabilityEvent(AttachCapabilitiesEvent<Entity> event) {
		Entity entity = event.getObject();
		if (entity instanceof PlayerEntity) {
			event.addCapability(new ResourceLocation(Main.MODID, "spirit"), new SpiritCapabilityProvider());
		}
	}

	@SubscribeEvent
	public static void onPlayerTick(LivingUpdateEvent event) {
		if (event.getEntityLiving() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntityLiving();
			LazyOptional<ISpiritCapability> SpiritCap = player.getCapability(CapabilityRegistry.SPIRIT_CAPABILITY);
			if (SpiritCap.isPresent()) {
				SpiritCap.ifPresent((newCap) -> {
					if (newCap.getLastActionTimer() != 0)
						newCap.setLastActionTimer(newCap.getLastActionTimer() - 1);
					else if (newCap.getLastActionTimer() == 0 && newCap.getSpiritAmount() < newCap.getMaxSpiritAmount())
						newCap.setSpiritAmount(newCap.getSpiritAmount() + 1);
				});
			}
		}
	}

	@SubscribeEvent
	public static void onPlayerCloned(PlayerEvent.Clone event) {
		LazyOptional<ISpiritCapability> oldSpiritCap = event.getOriginal()
				.getCapability(CapabilityRegistry.SPIRIT_CAPABILITY);
		LazyOptional<ISpiritCapability> newSpiritCap = event.getPlayer()
				.getCapability(CapabilityRegistry.SPIRIT_CAPABILITY);
		if (oldSpiritCap.isPresent() && newSpiritCap.isPresent()) {
			newSpiritCap.ifPresent((newCap) -> {
				oldSpiritCap.ifPresent((oldCap) -> {
					if (!event.isWasDeath()) {
						newCap.deserializeNBT(oldCap.serializeNBT());
					} else {
						newCap.setSpiritLevel(oldCap.getSpiritLevel());
						newCap.setMaxSpiritAmount(oldCap.getMaxSpiritAmount());
						newCap.setSpiritAmount(0);
					}
				});
			});
		}
	}
	@SubscribeEvent
	public static void onUsingMagic(EventUseMagic event) {
		PlayerEntity player =event.player;
		LazyOptional<ISpiritCapability> SpiritCap = player.getCapability(CapabilityRegistry.SPIRIT_CAPABILITY);
		if (SpiritCap.isPresent()) {
			SpiritCap.ifPresent((newCap) -> {
				if (newCap.getLastActionTimer() != 0)
					event.setCanceled(true);
			});
		}
	}
}
