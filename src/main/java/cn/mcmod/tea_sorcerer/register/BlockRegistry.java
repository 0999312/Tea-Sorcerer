package cn.mcmod.tea_sorcerer.register;

import cn.mcmod.tea_sorcerer.Main;
import cn.mcmod.tea_sorcerer.crop.BlockRiceRoot;
import cn.mcmod.tea_sorcerer.crop.CropRice;
import cn.mcmod.tea_sorcerer.crop.CropTea;
import cn.mcmod.tea_sorcerer.tea.BlockTeaCauldron;
import cn.mcmod.tea_sorcerer.tea.BlockTeaPot;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockRegistry extends ObjectRegistry {
	public static Block RICE_ROOT = new BlockRiceRoot().setRegistryName(Main.MODID, "rice_root");
	public static Block RICE_CROP = new CropRice().setRegistryName(Main.MODID, "rice_crop");
	public static Block TEA_TREE = new CropTea().setRegistryName(Main.MODID, "tea_tree");
	public static Block TEA_POT = new BlockTeaPot(Block.Properties.create(Material.ROCK).notSolid().hardnessAndResistance(1F).sound(SoundType.STONE)).setRegistryName(Main.MODID, "tea_pot");
	public static Block TEA_CAULDRON = new BlockTeaCauldron(Block.Properties.create(Material.IRON).notSolid().hardnessAndResistance(2F).sound(SoundType.METAL)).setRegistryName(Main.MODID, "tea_cauldron");
}
