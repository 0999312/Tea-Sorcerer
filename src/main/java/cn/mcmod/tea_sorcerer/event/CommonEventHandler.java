package cn.mcmod.tea_sorcerer.event;

import cn.mcmod.tea_sorcerer.Versions;
import cn.mcmod.tea_sorcerer.capability.CapabilityRegistry;
import cn.mcmod.tea_sorcerer.capability.ISpiritCapability;
import cn.mcmod.tea_sorcerer.capability.SpiritCapabilityProvider;
import cn.mcmod.tea_sorcerer.effect.EffectRegister;
import cn.mcmod.tea_sorcerer.item.FlowerTeaSigh;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Versions.MODID)
public class CommonEventHandler {
    @SubscribeEvent
    public static void onAttachCapabilityEvent(AttachCapabilitiesEvent<Entity> event) {
        Entity entity = event.getObject();
        if (entity instanceof PlayerEntity) {
            event.addCapability(new ResourceLocation(Versions.MODID, "spirit"), new SpiritCapabilityProvider());
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
                    else if (newCap.getSpiritAmount() < newCap.getMaxSpiritAmount()) {
                        int amount = 1;
                        if (player.getEffect(EffectRegister.MAGIC_INCREASE.get()) != null) {
                            amount = player.getEffect(EffectRegister.MAGIC_INCREASE.get()).getAmplifier() * 5;
                        }
                        newCap.setSpiritAmount(newCap.getSpiritAmount() + amount);
                    }
                });
            }

            if (!player.level.isClientSide) {
                if (player.getHealth() < 4) {
                    ItemStack sigh = findFlowerTeaSigh(player);
                    if (!sigh.isEmpty()) {
                        sigh.shrink(1);
                        player.heal(player.getMaxHealth());
                        player.level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_BREAK, player.getSoundSource(), 1.0f, 1.0f);
                        player.level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.PLAYER_LEVELUP, player.getSoundSource(), 1.0f, 1.0f);
                    }
                }
            }
        }
    }

    private static ItemStack findFlowerTeaSigh(PlayerEntity player) {
        for (int i = 0; i < player.inventory.getMaxStackSize(); ++i) {
            ItemStack itemstack = player.inventory.getItem(i);
            if (isSigh(itemstack)) {
                return itemstack;
            }
        }
        return ItemStack.EMPTY;
    }

    private static boolean isSigh(ItemStack itemInHand) {
        return itemInHand.getItem() instanceof FlowerTeaSigh;
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
        PlayerEntity player = event.player;
        LazyOptional<ISpiritCapability> SpiritCap = player.getCapability(CapabilityRegistry.SPIRIT_CAPABILITY);
        if (SpiritCap.isPresent()) {
            SpiritCap.ifPresent((newCap) -> {
                if (newCap.getSpiritLevel() < event.spirit_level) {
                    player.hurt(new DamageSource("use_higher_level_spirit"), 16F);
                    event.setCanceled(true);
                }
                if (newCap.getLastActionTimer() != 0) {
                    player.playSound(SoundEvents.FIRE_EXTINGUISH, 1.5F, 1.0F);
                    event.setCanceled(true);
                }
            });
        }
    }
}
