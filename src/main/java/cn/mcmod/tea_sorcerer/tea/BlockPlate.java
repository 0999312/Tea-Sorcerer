package cn.mcmod.tea_sorcerer.tea;

import cn.mcmod.tea_sorcerer.register.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;

public class BlockPlate extends HorizontalBlock {

	public BlockPlate(Properties builder) {
		super(builder);
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlayer().getHorizontalFacing().getOpposite());
	}
	
	@Override
	public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
		return true;
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(HORIZONTAL_FACING);
	}
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return VoxelShapes.create(0.0D, 0.0D, 0.0D, 1.0D, 0.0625D, 1.0D);
	}

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }
	
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return BlockRegistry.PLATE_TE.create();
	}
	@Override
	public void harvestBlock(World worldIn, PlayerEntity player, BlockPos pos, BlockState state, TileEntity te,
			ItemStack stack) {
	    IItemHandler inventory = (IItemHandler) te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, Direction.UP);
	
	    if (inventory != null && inventory.getStackInSlot(0) != ItemStack.EMPTY) {
	        spawnAsEntity(worldIn, pos, inventory.getStackInSlot(0));
	        ((IItemHandlerModifiable) inventory).setStackInSlot(0, ItemStack.EMPTY);
	    }
		super.harvestBlock(worldIn, player, pos, state, te, stack);
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
        if (worldIn.isRemote)
            return ActionResultType.PASS;
        
		ItemStack stack = player.getHeldItem(handIn);
		TileEntity tile = worldIn.getTileEntity(pos);
		if (handIn == Hand.MAIN_HAND) {
		    if (tile instanceof TileEntityPlate) {
		    	TileEntityPlate tileEntity = (TileEntityPlate) tile;
		        if(!(tileEntity.getInventory().getStackInSlot(0)).isEmpty()&&!(stack.equals(tileEntity.getInventory().getStackInSlot(0)))){
		            spawnAsEntity(worldIn, pos, tileEntity.getInventory().getStackInSlot(0));
		            tileEntity.getInventory().setStackInSlot(0, ItemStack.EMPTY);
		            tileEntity.markDirty();
		            return ActionResultType.SUCCESS;
		        }
				ItemStack campfireStack=stack.copy();
				campfireStack.setCount(1);
				stack.shrink(1);
				tileEntity.getInventory().insertItem(0,campfireStack,false);
				tileEntity.markDirty();
				return ActionResultType.SUCCESS;
		    }
		}

		return ActionResultType.PASS;
	}
}
