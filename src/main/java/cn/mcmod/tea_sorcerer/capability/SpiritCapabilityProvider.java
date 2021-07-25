package cn.mcmod.tea_sorcerer.capability;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

public class SpiritCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundNBT> {
    private ISpiritCapability spiritCapability;

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return cap == CapabilityRegistry.SPIRIT_CAPABILITY ? LazyOptional.of(() -> {
            return this.getOrCreateCapability();
        }).cast() : LazyOptional.empty();
    }

    @Nonnull
    ISpiritCapability getOrCreateCapability() {
        if (spiritCapability == null) {
            this.spiritCapability = new SpiritCapability(1, 1000, 1000);
        }
        return this.spiritCapability;
    }

    @Override
    public CompoundNBT serializeNBT() {
        return getOrCreateCapability().serializeNBT();
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        getOrCreateCapability().deserializeNBT(nbt);
    }

}
