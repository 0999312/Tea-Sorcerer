package cn.mcmod.tea_sorcerer.tea;

import net.minecraft.block.ContainerBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class BlockDirtHeater extends ContainerBlock {

	public BlockDirtHeater(Properties properties) {
		super(properties);
	}

	@Override
	public TileEntity createNewTileEntity(IBlockReader worldIn) {
		return null;
	}

}
