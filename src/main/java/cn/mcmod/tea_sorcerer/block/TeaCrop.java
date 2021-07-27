package cn.mcmod.tea_sorcerer.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class TeaCrop extends CropsBlock {

    public static final IntegerProperty TEA_AGE = BlockStateProperties.AGE_3;

    public TeaCrop() {
        super(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0.2f).sound(SoundType.CROP));
        this.registerDefaultState(this.stateDefinition.any().setValue(this.getAgeProperty(), Integer.valueOf(0)));
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return TEA_AGE;
    }

    @Override
    public int getMaxAge() {
        return 3;
    }

    @Override
    protected int getBonemealAgeIncrease(World levelIn) {
        return super.getBonemealAgeIncrease(levelIn) / 3;
    }

    @Override
    protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
        builder.add(TEA_AGE);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (rand.nextInt(3) != 0) {
            super.randomTick(state, worldIn, pos, rand);
        }
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.getMaterial() == Material.DIRT;
    }
}
