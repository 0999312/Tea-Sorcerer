package cn.mcmod.tea_sorcerer.block;

import cn.mcmod.tea_sorcerer.Versions;
import net.minecraft.block.Block;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegister {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            Versions.MODID);
    public static final RegistryObject<Block> TEA_CROP = BLOCKS.register("tea_tree", TeaCrop::new);
    
    public static final RegistryObject<Block> TEA_POT = BLOCKS.register("tea_pot", TeaPotBlock::new);

    public static final RegistryObject<Block> marguerite = BLOCKS.register("marguerite", () -> new FlowerBlock(
            Effects.REGENERATION, 8,
            Block.Properties.of(Material.PLANT).noCollission().noOcclusion().strength(0F).sound(SoundType.GRASS)));

    public static final RegistryObject<Block> radiata = BLOCKS.register("radiata", () -> new FlowerBlock(
            Effects.WITHER,  8,
            Block.Properties.of(Material.PLANT).noCollission().noOcclusion().strength(0F).sound(SoundType.GRASS)));

    public static final RegistryObject<Block> sambac = BLOCKS.register("sambac", () -> new FlowerBlock(
            Effects.MOVEMENT_SPEED, 8,
            Block.Properties.of(Material.PLANT).noCollission().noOcclusion().strength(0F).sound(SoundType.GRASS)));

}
