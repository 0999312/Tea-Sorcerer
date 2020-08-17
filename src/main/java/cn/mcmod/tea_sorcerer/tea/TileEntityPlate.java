package cn.mcmod.tea_sorcerer.tea;

import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.texture.ITickable;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import cn.mcmod.tea_sorcerer.register.BlockRegistry;

public class TileEntityPlate extends TileEntity implements ITickable {
    public TileEntityPlate() {
		super(BlockRegistry.PLATE_TE);
	}

	private ItemStackHandler inventory = new ItemStackHandler() {
        @Override
        protected void onContentsChanged(int slot) {
            TileEntityPlate.this.refresh();
        }
    };
    
    public ItemStackHandler getInventory() {
        return this.inventory;
    }
    protected void refresh() {
        if (hasWorld() && !world.isRemote) {
            BlockState state = world.getBlockState(getPos());
            world.markAndNotifyBlock(getPos(), world.getChunkAt(getPos()), state, state, 11);
        }
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
    	super.onDataPacket(net, pkt);
    	readPacketNBT(pkt.getNbtCompound());
    }
    
    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
    	CompoundNBT tag = new CompoundNBT();
    	write(tag);
    	return new SUpdateTileEntityPacket(getPos(), -999, tag);
    }
    
    @Override
    public CompoundNBT getUpdateTag() {
    	return  write(new CompoundNBT());
    }
    
	public void writePacketNBT(CompoundNBT cmp) {
        cmp.put("Inventory", inventory.serializeNBT());
	}

	public void readPacketNBT(CompoundNBT cmp) {
        inventory.deserializeNBT(cmp.getCompound("Inventory"));
	}
	@Override
	public void tick() {
	}
	@Override
	public void read(CompoundNBT compound) {
		readPacketNBT(compound);
		super.read(compound);
	}
	@Override
	public CompoundNBT write(CompoundNBT compound) {
		CompoundNBT ret = super.write(compound);
		writePacketNBT(ret);
		return ret;
	}
    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (side == Direction.UP && cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return LazyOptional.of(() -> {
                return inventory;
            }).cast();
        }
        return super.getCapability(cap, side);
    }
}