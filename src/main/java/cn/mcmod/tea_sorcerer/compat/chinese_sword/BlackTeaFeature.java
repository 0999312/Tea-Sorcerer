package cn.mcmod.tea_sorcerer.compat.chinese_sword;

import java.util.function.Consumer;

import cn.mcmod.chinese_sword.item.feature.WeaponFeature;
import cn.mcmod.tea_sorcerer.capability.CapabilityRegistry;
import cn.mcmod.tea_sorcerer.capability.ISpiritCapability;
import cn.mcmod.tea_sorcerer.effect.EffectRegister;
import cn.mcmod.tea_sorcerer.event.EventUseMagic;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.LazyOptional;

public class BlackTeaFeature extends WeaponFeature {

    public BlackTeaFeature() {
        super("black_tea_steel");
    }

    @Override
    public <T extends LivingEntity> int damageItem(ItemStack arg0, int arg1, T arg2, Consumer<T> arg3) {
        return 0;
    }

    @Override
    public void inventoryTick(ItemStack arg0, World arg1, Entity arg2, int arg3, boolean arg4) {

    }

    @Override
    public void onLeftClickEntity(ItemStack stackIn, PlayerEntity player, Entity entity) {
        boolean result = MinecraftForge.EVENT_BUS.post(new EventUseMagic(player, 0, 100));
        if (player.getEffect(EffectRegister.MAGIC_INCREASE.get()) != null) {
            if (!result) {
                int level = player.getEffect(EffectRegister.MAGIC_INCREASE.get()).getAmplifier();
                entity.hurt(DamageSource.MAGIC, level * 2F);
                UseSpirit(player);
            }
        }
    }
    
    protected void UseSpirit(PlayerEntity playerIn) {
        LazyOptional<ISpiritCapability> Cap = playerIn.getCapability(CapabilityRegistry.SPIRIT_CAPABILITY);
        Cap.ifPresent((l) -> {
            if (l.getSpiritAmount() >= 100)
                l.setSpiritAmount(l.getSpiritAmount() - 100);
            l.setLastActionTimer(1);
        });
    }

    @Override
    public void use(World arg0, PlayerEntity arg1, Hand arg2) {

    }

}
