package cn.mcmod.tea_sorcerer.capability;

import net.minecraft.nbt.CompoundNBT;

public class SpiritCapability implements ISpiritCapability {
    private int level;
    private int amount;
    private int max_amount;
    private int last_action_timer = 0;

    public SpiritCapability(int level, int amount, int max) {
        this.level = level;
        this.amount = amount;
        this.max_amount = max;
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT compoundNBT = new CompoundNBT();
        compoundNBT.putInt("spirit_level", this.level);
        compoundNBT.putInt("spirit_amount", this.amount);
        compoundNBT.putInt("spirit_max_amount", this.max_amount);
        compoundNBT.putInt("spirit_last_action_timer", this.last_action_timer);
        return compoundNBT;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        this.level = nbt.getInt("level");
        this.amount = nbt.getInt("spirit_amount");
        this.max_amount = nbt.getInt("spirit_max_amount");
        this.last_action_timer = nbt.getInt("spirit_last_action_timer");
    }

	@Override
	public int getSpiritLevel() {
		return level;
	}

	@Override
	public int getSpiritAmount() {
		return amount;
	}

	@Override
	public void setSpiritLevel(int level) {
//		if((this.getSpiritLevel() + level) > 5) this.level = 5;
		this.level = level;
	}

	@Override
	public void setSpiritAmount(int amount) {
//		if((this.getSpiritAmount() + amount) > getMaxSpiritAmount()) this.amount = getMaxSpiritAmount();
		this.amount = amount;
	}

	@Override
	public int getMaxSpiritAmount() {
		return max_amount;
	}

	@Override
	public void setMaxSpiritAmount(int amount) {
		this.max_amount = amount;
	}

	@Override
	public int getLastActionTimer() {
		return this.last_action_timer;
	}

	@Override
	public void setLastActionTimer(int tick) {
		this.last_action_timer = tick;
	}
}
