package cn.mcmod.tea_sorcerer.crop;

import java.util.Random;

import cn.mcmod.tea_sorcerer.register.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class CropTea extends CropsBlock {
	public static final IntegerProperty TEA_AGE = BlockStateProperties.AGE_0_3;
	public CropTea() {
		super(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.2f).sound(SoundType.PLANT));
		this.setDefaultState(this.stateContainer.getBaseState().with(this.getAgeProperty(), Integer.valueOf(0)));
	}

	@SuppressWarnings("deprecation")
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		if(state.get(getAgeProperty()).intValue()>=3){
			worldIn.setBlockState(pos, this.getDefaultState().with(this.getAgeProperty(), 2), 2);
			spawnAsEntity(worldIn, pos, new ItemStack(ItemRegistry.tea_leaves,1));
			return ActionResultType.SUCCESS;
		}
		return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
	}
	
	@Override
	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return state.getMaterial() == Material.EARTH;
	}
	
	public IntegerProperty getAgeProperty() {
		return TEA_AGE;
	}

	public int getMaxAge() {
		return 3;
	}

	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		if (rand.nextInt(3) != 0) {
			super.tick(state, worldIn, pos, rand);
		}

	}

	protected int getBonemealAgeIncrease(World worldIn) {
		return super.getBonemealAgeIncrease(worldIn) / 3;
	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(TEA_AGE);
	}

	@Override
	protected IItemProvider getSeedsItem() {
		return ItemRegistry.tea_seed;
	}

}
