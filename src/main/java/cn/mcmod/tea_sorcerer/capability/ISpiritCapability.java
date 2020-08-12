package cn.mcmod.tea_sorcerer.capability;

import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;

public interface ISpiritCapability extends INBTSerializable<CompoundNBT> {
	int getSpiritLevel();
	void setSpiritLevel(int level);
	int getSpiritAmount();
	void setSpiritAmount(int amount);
	int getMaxSpiritAmount();
	void setMaxSpiritAmount(int amount);
	int getLastActionTimer();
	void setLastActionTimer(int tick);
}
