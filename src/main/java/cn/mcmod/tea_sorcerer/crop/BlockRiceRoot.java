package cn.mcmod.tea_sorcerer.crop;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BushBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.PlantType;

import javax.annotation.Nullable;
import java.util.Random;

public class BlockRiceRoot extends BushBlock implements net.minecraftforge.common.IPlantable {
    public BlockRiceRoot() {
        super(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.CROP));
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (!state.isValidPosition(worldIn, pos)) {
            worldIn.destroyBlock(pos, true);
        }
    }

    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.isIn(BlockTags.SAND) || state.getBlock() == Blocks.GRASS_BLOCK || state.getBlock() == Blocks.DIRT || state.getBlock() == Blocks.GRAVEL;
    }

    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        IFluidState ifluidstate = worldIn.getFluidState(pos);
        return super.isValidPosition(state, worldIn, pos) && ifluidstate.isTagged(FluidTags.WATER) && ifluidstate.getLevel() == 8;
    }

    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockState blockstate = super.getStateForPlacement(context);
        if (blockstate != null) {
            IFluidState ifluidstate = context.getWorld().getFluidState(context.getPos().up());
            if (ifluidstate.isTagged(FluidTags.WATER) && ifluidstate.getLevel() == 8) {
                return blockstate;
            }
        }

        return null;
    }

    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
        return true;
    }

    @Override
    public PlantType getPlantType(IBlockReader world, BlockPos pos) {
        return PlantType.Water;
    }

    @Override
    public IFluidState getFluidState(BlockState state) {
        return Fluids.WATER.getStillFluidState(false);
    }
}
