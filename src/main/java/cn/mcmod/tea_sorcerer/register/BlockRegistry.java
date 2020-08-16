package cn.mcmod.tea_sorcerer.register;

import cn.mcmod.tea_sorcerer.Main;
import cn.mcmod.tea_sorcerer.crop.BlockRiceRoot;
import cn.mcmod.tea_sorcerer.crop.CropRice;
import cn.mcmod.tea_sorcerer.crop.CropTea;
import cn.mcmod.tea_sorcerer.tea.BlockTeaCauldron;
import cn.mcmod.tea_sorcerer.tea.BlockTeaPot;
import net.minecraft.block.Block;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.potion.Effects;

public class BlockRegistry extends ObjectRegistry {
	public static Block RICE_ROOT = new BlockRiceRoot().setRegistryName(Main.MODID, "rice_root");
	public static Block RICE_CROP = new CropRice().setRegistryName(Main.MODID, "rice_crop");
	public static Block TEA_TREE = new CropTea().setRegistryName(Main.MODID, "tea_tree");
	public static Block TEA_POT = new BlockTeaPot(
			Block.Properties.create(Material.ROCK).notSolid().hardnessAndResistance(1F).sound(SoundType.STONE))
					.setRegistryName(Main.MODID, "tea_pot");
	public static Block TEA_CAULDRON = new BlockTeaCauldron(
			Block.Properties.create(Material.IRON).notSolid().hardnessAndResistance(2F).sound(SoundType.METAL))
					.setRegistryName(Main.MODID, "tea_cauldron");

	public static Block marguerite = new FlowerBlock(Effects.REGENERATION, 8, Block.Properties.create(Material.PLANTS)
			.doesNotBlockMovement().notSolid().hardnessAndResistance(0F).sound(SoundType.PLANT))
			.setRegistryName(Main.MODID, "marguerite");
	public static Block radiata = new FlowerBlock(Effects.WITHER, 8, Block.Properties.create(Material.PLANTS)
			.doesNotBlockMovement().notSolid().hardnessAndResistance(0F).sound(SoundType.PLANT))
			.setRegistryName(Main.MODID, "radiata");
	public static Block sambac = new FlowerBlock(Effects.SPEED, 8, Block.Properties.create(Material.PLANTS)
			.doesNotBlockMovement().notSolid().hardnessAndResistance(0F).sound(SoundType.PLANT))
			.setRegistryName(Main.MODID, "sambac");
}
