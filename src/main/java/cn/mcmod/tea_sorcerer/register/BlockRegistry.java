package cn.mcmod.tea_sorcerer.register;

import cn.mcmod.tea_sorcerer.Main;
import cn.mcmod.tea_sorcerer.crop.BlockRiceRoot;
import cn.mcmod.tea_sorcerer.crop.CropRice;
import cn.mcmod.tea_sorcerer.crop.CropTea;
import net.minecraft.block.Block;

public class BlockRegistry extends ObjectRegistry {
	public static Block RICE_ROOT = new BlockRiceRoot().setRegistryName(Main.MODID, "rice_root");
	public static Block RICE_CROP = new CropRice().setRegistryName(Main.MODID, "rice_crop");
	public static Block TEA_TREE = new CropTea().setRegistryName(Main.MODID, "tea_tree");
}
