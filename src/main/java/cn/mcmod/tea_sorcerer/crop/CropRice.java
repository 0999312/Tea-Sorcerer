package cn.mcmod.tea_sorcerer.crop;

import cn.mcmod.tea_sorcerer.register.BlockRegistry;
import cn.mcmod.tea_sorcerer.register.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class CropRice extends CropsBlock {
	public CropRice() {
		super(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.CROP));
	}
	
	@Override
	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return state.getBlock() == BlockRegistry.RICE_ROOT;
	}
	
	@Override
	protected IItemProvider getSeedsItem() {
		return ItemRegistry.rice_seed;
	}

}
