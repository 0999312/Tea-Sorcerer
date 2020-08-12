package cn.mcmod.tea_sorcerer.register;

import cn.mcmod.tea_sorcerer.Main;
import cn.mcmod.tea_sorcerer.crop.SeedRice;
import cn.mcmod.tea_sorcerer.magic.ItemMagicInfo;
import cn.mcmod.tea_sorcerer.magic.ScrollFire;
import cn.mcmod.tea_sorcerer.tea.DrinkTeaBase;
import cn.mcmod.tea_sorcerer.tea.DrinkTeaMagic;
import cn.mcmod.tea_sorcerer.tea.EffectBlank;
import cn.mcmod.tea_sorcerer.tea.EffectFresh;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = Main.MODID)
public class ItemRegistry extends ObjectRegistry {
	public static Effect MAGIC_INCREASE = new EffectBlank("magic_increase", EffectType.BENEFICIAL, 0x579943);
	public static Effect FRESH = new EffectFresh(EffectType.BENEFICIAL, 0xD7FFCC);
	
	public static Item tea_seed = new BlockItem(BlockRegistry.TEA_TREE, new Properties().group(Main.TS_GROUP))
			.setRegistryName(Main.MODID, "tea_seed");
	public static Item rice_seed = new SeedRice(BlockRegistry.RICE_CROP, new Properties().group(Main.TS_GROUP))
			.setRegistryName(Main.MODID, "rice_seed");
	public static Item straw = new Item(new Properties().group(Main.TS_GROUP)).setRegistryName(Main.MODID, "straw");
	public static Item tea_leaves = new Item(new Properties().group(Main.TS_GROUP)).setRegistryName(Main.MODID,
			"tea_leaves");
	public static Item rice = new Item(new Properties().group(Main.TS_GROUP)).setRegistryName(Main.MODID, "rice");
	public static Item brown_rice = new Item(new Properties().group(Main.TS_GROUP)).setRegistryName(Main.MODID,
			"brown_rice");
	public static Item cup = new Item(new Properties().group(Main.TS_GROUP)).setRegistryName(Main.MODID, "cup");
	public static Item green_tea_leaves = new Item(new Properties().group(Main.TS_GROUP)).setRegistryName(Main.MODID,
			"green_tea_leaves");
	public static Item black_tea_leaves = new Item(new Properties().group(Main.TS_GROUP)).setRegistryName(Main.MODID,
			"black_tea_leaves");
	public static Item earl_grey_leaves = new Item(new Properties().group(Main.TS_GROUP)).setRegistryName(Main.MODID,
			"earl_grey_leaves");
	public static Item fruit_tea_leaves = new Item(new Properties().group(Main.TS_GROUP)).setRegistryName(Main.MODID,
			"fruit_tea_leaves");
	public static Item rice_tea_leaves = new Item(new Properties().group(Main.TS_GROUP)).setRegistryName(Main.MODID,
			"rice_tea_leaves");
	public static Item wulong_tea_leaves = new Item(new Properties().group(Main.TS_GROUP)).setRegistryName(Main.MODID,
			"wulong_tea_leaves");
	public static Item flower_tea_leaves = new Item(new Properties().group(Main.TS_GROUP)).setRegistryName(Main.MODID,
			"flower_tea_leaves");
	public static Item cocoa_tea_leaves = new Item(new Properties().group(Main.TS_GROUP)).setRegistryName(Main.MODID,
			"cocoa_tea_leaves");
	public static Item mocha = new Item(new Properties().group(Main.TS_GROUP)).setRegistryName(Main.MODID,
			"mocha");

	public static Item crystal_fire = new Item(new Properties().group(Main.TS_GROUP)).setRegistryName(Main.MODID,
			"crystal_fire");
	public static Item crystal_metal = new Item(new Properties().group(Main.TS_GROUP)).setRegistryName(Main.MODID,
			"crystal_metal");
	public static Item crystal_wood = new Item(new Properties().group(Main.TS_GROUP)).setRegistryName(Main.MODID,
			"crystal_wood");
	public static Item crystal_water = new Item(new Properties().group(Main.TS_GROUP)).setRegistryName(Main.MODID,
			"crystal_water");
	public static Item crystal_earth = new Item(new Properties().group(Main.TS_GROUP)).setRegistryName(Main.MODID,
			"crystal_earth");
	public static Item crystal_solar = new Item(new Properties().group(Main.TS_GROUP)).setRegistryName(Main.MODID,
			"crystal_solar");
	public static Item crystal_luna = new Item(new Properties().group(Main.TS_GROUP)).setRegistryName(Main.MODID,
			"crystal_luna");

	public static Item dust_fire = new Item(new Properties().group(Main.TS_GROUP)).setRegistryName(Main.MODID,
			"dust_fire");
	public static Item dust_metal = new Item(new Properties().group(Main.TS_GROUP)).setRegistryName(Main.MODID,
			"dust_metal");
	public static Item dust_wood = new Item(new Properties().group(Main.TS_GROUP)).setRegistryName(Main.MODID,
			"dust_wood");
	public static Item dust_water = new Item(new Properties().group(Main.TS_GROUP)).setRegistryName(Main.MODID,
			"dust_water");
	public static Item dust_earth = new Item(new Properties().group(Main.TS_GROUP)).setRegistryName(Main.MODID,
			"dust_earth");
	public static Item dust_solar = new Item(new Properties().group(Main.TS_GROUP)).setRegistryName(Main.MODID,
			"dust_solar");
	public static Item dust_luna = new Item(new Properties().group(Main.TS_GROUP)).setRegistryName(Main.MODID,
			"dust_luna");

	public static Item scroll_fire = new ScrollFire(new Properties().group(Main.TS_GROUP)).setRegistryName(Main.MODID,
			"scroll_fire");
	public static Item scroll_info = new ItemMagicInfo(new Properties().group(Main.TS_GROUP))
			.setRegistryName(Main.MODID, "scroll_info");
	
	public static Item green_tea_drink = new DrinkTeaBase(new Properties().group(Main.TS_GROUP)
			.food(
				new Food.Builder()
				.effect( () -> new EffectInstance(MAGIC_INCREASE,  1200, 0), 1F)
				.effect( () -> new EffectInstance(FRESH,  1200, 0), 1F)
				.setAlwaysEdible().build())
			)
	.setRegistryName(Main.MODID, "green_tea_drink");
	public static Item black_tea_drink = new DrinkTeaBase(new Properties().group(Main.TS_GROUP)
			.food(
				new Food.Builder()
				.effect( () -> new EffectInstance(MAGIC_INCREASE, 1200, 0), 1F)
				.effect( () -> new EffectInstance(FRESH, 1200, 0), 1F)
				.setAlwaysEdible().build())
			)
	.setRegistryName(Main.MODID, "black_tea_drink");
	public static Item wulong_tea_drink = new DrinkTeaBase(new Properties().group(Main.TS_GROUP)
			.food(
				new Food.Builder()
				.effect( () -> new EffectInstance(MAGIC_INCREASE, 1200, 0), 1F)
				.effect( () -> new EffectInstance(FRESH, 1200, 0), 1F)
				.setAlwaysEdible().build())
			)
	.setRegistryName(Main.MODID, "wulong_tea_drink");
	public static Item mocha_drink = new DrinkTeaBase(new Properties().group(Main.TS_GROUP)
			.food(
				new Food.Builder()
				.effect( () -> new EffectInstance(MAGIC_INCREASE, 1200, 0), 1F)
				.effect( () -> new EffectInstance(FRESH,  1200, 0), 1F)
				.setAlwaysEdible().build())
			)
	.setRegistryName(Main.MODID, "mocha_drink");
	
	public static Item flower_tea_drink = new DrinkTeaBase(new Properties().group(Main.TS_GROUP)
			.food(
				new Food.Builder()
				.effect( () -> new EffectInstance(MAGIC_INCREASE,  1800, 0), 1F)
				.effect( () -> new EffectInstance(FRESH, 1800, 0), 1F)
				.setAlwaysEdible().build())
			)
	.setRegistryName(Main.MODID, "flower_tea_drink");
	public static Item rice_tea_drink = new DrinkTeaBase(new Properties().group(Main.TS_GROUP)
			.food(
				new Food.Builder()
				.effect( () -> new EffectInstance(MAGIC_INCREASE, 1800, 0), 1F)
				.effect( () -> new EffectInstance(FRESH,  1800, 0), 1F)
				.setAlwaysEdible().build())
			)
	.setRegistryName(Main.MODID, "rice_tea_drink");
	public static Item cocoa_tea_drink = new DrinkTeaBase(new Properties().group(Main.TS_GROUP)
			.food(
				new Food.Builder()
				.effect( () -> new EffectInstance(MAGIC_INCREASE, 1800, 0), 1F)
				.effect( () -> new EffectInstance(FRESH, 1800, 0), 1F)
				.setAlwaysEdible().build())
			)
	.setRegistryName(Main.MODID, "cocoa_tea_drink");
	public static Item fruit_tea_drink = new DrinkTeaBase(new Properties().group(Main.TS_GROUP)
			.food(
				new Food.Builder()
				.effect( () -> new EffectInstance(MAGIC_INCREASE,  1200, 1), 1F)
				.effect( () -> new EffectInstance(FRESH, 1200, 0), 1F)
				.setAlwaysEdible().build())
			)
	.setRegistryName(Main.MODID, "fruit_tea_drink");
	public static Item earl_grey_drink = new DrinkTeaBase(new Properties().group(Main.TS_GROUP)
			.food(
				new Food.Builder()
				.effect( () -> new EffectInstance(MAGIC_INCREASE, 1200, 1), 1F)
				.effect( () -> new EffectInstance(FRESH, 1200, 0), 1F)
				.setAlwaysEdible().build())
			)
	.setRegistryName(Main.MODID, "earl_grey_drink");
	
	public static Item fire_tea_drink = new DrinkTeaMagic(new Properties().group(Main.TS_GROUP)
			.food(
				new Food.Builder()
				.effect( () -> new EffectInstance(MAGIC_INCREASE, 1200, 1), 1F)
				.effect( () -> new EffectInstance(FRESH, 1200, 0), 1F)
				.effect( () -> new EffectInstance(Effects.FIRE_RESISTANCE, 1200, 0), 1F)
				.setAlwaysEdible().build())
			)
	.setRegistryName(Main.MODID, "fire_tea_drink");
	public static Item metal_tea_drink = new DrinkTeaMagic(new Properties().group(Main.TS_GROUP)
			.food(
				new Food.Builder()
				.effect( () -> new EffectInstance(MAGIC_INCREASE, 1200, 1), 1F)
				.effect( () -> new EffectInstance(FRESH, 1200, 0), 1F)
				.effect( () -> new EffectInstance(Effects.SATURATION, 100, 0), 1F)
				.setAlwaysEdible().build())
			)
	.setRegistryName(Main.MODID, "metal_tea_drink");
	public static Item wood_tea_drink = new DrinkTeaMagic(new Properties().group(Main.TS_GROUP)
			.food(
				new Food.Builder()
				.effect( () -> new EffectInstance(MAGIC_INCREASE, 1200, 1), 1F)
				.effect( () -> new EffectInstance(FRESH, 1200, 0), 1F)
				.effect( () -> new EffectInstance(Effects.REGENERATION, 1200, 0), 1F)
				.setAlwaysEdible().build())
			)
	.setRegistryName(Main.MODID, "wood_tea_drink");
	public static Item water_tea_drink = new DrinkTeaMagic(new Properties().group(Main.TS_GROUP)
			.food(
				new Food.Builder()
				.effect( () -> new EffectInstance(MAGIC_INCREASE, 1200, 1), 1F)
				.effect( () -> new EffectInstance(FRESH, 1200, 0), 1F)
				.effect( () -> new EffectInstance(Effects.CONDUIT_POWER, 1200, 1), 1F)
				.effect( () -> new EffectInstance(Effects.DOLPHINS_GRACE, 1200, 1), 1F)
				.setAlwaysEdible().build())
			)
	.setRegistryName(Main.MODID, "water_tea_drink");
	public static Item earth_tea_drink = new DrinkTeaMagic(new Properties().group(Main.TS_GROUP)
			.food(
				new Food.Builder()
				.effect( () -> new EffectInstance(MAGIC_INCREASE, 1200, 1), 1F)
				.effect( () -> new EffectInstance(FRESH, 1200, 0), 1F)
				.effect( () -> new EffectInstance(Effects.RESISTANCE, 1200, 0), 1F)
				.effect( () -> new EffectInstance(Effects.SLOW_FALLING, 1200, 0), 1F)
				.setAlwaysEdible().build())
			)
	.setRegistryName(Main.MODID, "earth_tea_drink");
	public static Item solar_tea_drink = new DrinkTeaMagic(new Properties().group(Main.TS_GROUP)
			.food(
				new Food.Builder()
				.effect( () -> new EffectInstance(MAGIC_INCREASE, 1200, 1), 1F)
				.effect( () -> new EffectInstance(FRESH, 1200, 0), 1F)
				.effect( () -> new EffectInstance(Effects.HASTE, 1200, 2), 1F)
				.effect( () -> new EffectInstance(Effects.STRENGTH, 1200, 2), 1F)
				.setAlwaysEdible().build())
			)
	.setRegistryName(Main.MODID, "solar_tea_drink");
	public static Item luna_tea_drink = new DrinkTeaMagic(new Properties().group(Main.TS_GROUP)
			.food(
				new Food.Builder()
				.effect( () -> new EffectInstance(MAGIC_INCREASE, 1200, 1), 1F)
				.effect( () -> new EffectInstance(FRESH, 1200, 0), 1F)
				.effect( () -> new EffectInstance(Effects.RESISTANCE, 1200, 2), 1F)
				.effect( () -> new EffectInstance(Effects.NIGHT_VISION, 1200, 0), 1F)
				.setAlwaysEdible().build())
			)
	.setRegistryName(Main.MODID, "luna_tea_drink");
}
