package cn.mcmod.tea_sorcerer.item;

import cn.mcmod.tea_sorcerer.Main;
import cn.mcmod.tea_sorcerer.Versions;
import cn.mcmod.tea_sorcerer.effect.EffectRegister;
import cn.mcmod_mmf.mmlib.item.ItemDrinkBase;
import cn.mcmod_mmf.mmlib.item.info.FoodInfo;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegister {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Versions.MODID);
//	public static final Item.Properties default_prop = new Item.Properties().tab(Main.TEA_GROUP);
	public static final RegistryObject<Item> cup = ITEMS.register("cup",
			() -> new Item(new Item.Properties().tab(Main.TEA_GROUP)));


	public static final RegistryObject<Item> green_tea_leaves = ITEMS.register("green_tea_leaves",
			() -> new Item(new Item.Properties().tab(Main.TEA_GROUP)));
	public static final RegistryObject<Item> black_tea_leaves = ITEMS.register("black_tea_leaves",
			() -> new Item(new Item.Properties().tab(Main.TEA_GROUP)));
	public static final RegistryObject<Item> earl_grey_leaves = ITEMS.register("earl_grey_leaves",
			() -> new Item(new Item.Properties().tab(Main.TEA_GROUP)));
	public static final RegistryObject<Item> fruit_tea_leaves = ITEMS.register("fruit_tea_leaves",
			() -> new Item(new Item.Properties().tab(Main.TEA_GROUP)));
	public static final RegistryObject<Item> rice_tea_leaves = ITEMS.register("rice_tea_leaves",
			() -> new Item(new Item.Properties().tab(Main.TEA_GROUP)));
	public static final RegistryObject<Item> wulong_tea_leaves = ITEMS.register("wulong_tea_leaves",
			() -> new Item(new Item.Properties().tab(Main.TEA_GROUP)));
	public static final RegistryObject<Item> flower_tea_leaves = ITEMS.register("flower_tea_leaves",
			() -> new Item(new Item.Properties().tab(Main.TEA_GROUP)));
	public static final RegistryObject<Item> cocoa_tea_leaves = ITEMS.register("cocoa_tea_leaves",
			() -> new Item(new Item.Properties().tab(Main.TEA_GROUP)));
	public static final RegistryObject<Item> mocha = ITEMS.register("mocha",
			() -> new Item(new Item.Properties().tab(Main.TEA_GROUP)));

	public static final RegistryObject<Item> crystal_fire = ITEMS.register("crystal_fire",
			() -> new Item(new Item.Properties().tab(Main.TEA_GROUP)));
	public static final RegistryObject<Item> crystal_metal = ITEMS.register("crystal_metal",
			() -> new Item(new Item.Properties().tab(Main.TEA_GROUP)));
	public static final RegistryObject<Item> crystal_wood = ITEMS.register("crystal_wood",
			() -> new Item(new Item.Properties().tab(Main.TEA_GROUP)));
	public static final RegistryObject<Item> crystal_water = ITEMS.register("crystal_water",
			() -> new Item(new Item.Properties().tab(Main.TEA_GROUP)));
	public static final RegistryObject<Item> crystal_earth = ITEMS.register("crystal_earth",
			() -> new Item(new Item.Properties().tab(Main.TEA_GROUP)));
	public static final RegistryObject<Item> crystal_solar = ITEMS.register("crystal_solar",
			() -> new Item(new Item.Properties().tab(Main.TEA_GROUP)));
	public static final RegistryObject<Item> crystal_luna = ITEMS.register("crystal_luna",
			() -> new Item(new Item.Properties().tab(Main.TEA_GROUP)));

	public static final RegistryObject<Item> dust_fire = ITEMS.register("dust_fire",
			() -> new Item(new Item.Properties().tab(Main.TEA_GROUP)));
	public static final RegistryObject<Item> dust_metal = ITEMS.register("dust_metal",
			() -> new Item(new Item.Properties().tab(Main.TEA_GROUP)));
	public static final RegistryObject<Item> dust_wood = ITEMS.register("dust_wood",
			() -> new Item(new Item.Properties().tab(Main.TEA_GROUP)));
	public static final RegistryObject<Item> dust_water = ITEMS.register("dust_water",
			() -> new Item(new Item.Properties().tab(Main.TEA_GROUP)));
	public static final RegistryObject<Item> dust_earth = ITEMS.register("dust_earth",
			() -> new Item(new Item.Properties().tab(Main.TEA_GROUP)));
	public static final RegistryObject<Item> dust_solar = ITEMS.register("dust_solar",
			() -> new Item(new Item.Properties().tab(Main.TEA_GROUP)));
	public static final RegistryObject<Item> dust_luna = ITEMS.register("dust_luna",
			() -> new Item(new Item.Properties().tab(Main.TEA_GROUP)));
	
	public static final RegistryObject<Item> green_tea_ingot = ITEMS.register("green_tea_ingot",
			() -> new Item(new Item.Properties().tab(Main.TEA_GROUP)));
	public static final RegistryObject<Item> black_tea_ingot = ITEMS.register("black_tea_ingot",
			() -> new Item(new Item.Properties().tab(Main.TEA_GROUP)));
	public static final RegistryObject<Item> rice_tea_ingot = ITEMS.register("rice_tea_ingot",
			() -> new Item(new Item.Properties().tab(Main.TEA_GROUP)));

	public static final RegistryObject<Item> SCROLL_INFO = ITEMS.register("scroll_info",
			() -> new ScrollMagicInfo(new Item.Properties().stacksTo(1).tab(Main.TEA_GROUP)));

	public static final RegistryObject<Item> GREEN_TEA = ITEMS.register("green_tea_drink",
			() -> new ItemDrinkBase(new Item.Properties().tab(Main.TEA_GROUP).craftRemainder(cup.get()),
					new FoodInfo("green_tea_drink", 1, 1, false, true, 16)
							.addEffect(() -> new EffectInstance(EffectRegister.FRESH.get(), 1200, 0), 1F)
							.addEffect(() -> new EffectInstance(EffectRegister.MAGIC_INCREASE.get(), 1200, 0), 1F)));
	public static final RegistryObject<Item> BLACK_TEA = ITEMS.register("black_tea_drink",
			() -> new ItemDrinkBase(new Item.Properties().tab(Main.TEA_GROUP).craftRemainder(cup.get()),
					new FoodInfo("black_tea_drink", 1, 1, false, true, 16)
							.addEffect(() -> new EffectInstance(EffectRegister.FRESH.get(), 1200, 0), 1F)
							.addEffect(() -> new EffectInstance(EffectRegister.MAGIC_INCREASE.get(), 1200, 0), 1F)));
	public static final RegistryObject<Item> EARL_GREY = ITEMS.register("earl_grey_drink",
			() -> new ItemDrinkBase(new Item.Properties().tab(Main.TEA_GROUP).craftRemainder(cup.get()),
					new FoodInfo("earl_grey_drink", 1, 1, false, true, 16)
							.addEffect(() -> new EffectInstance(EffectRegister.FRESH.get(), 1200, 0), 1F)
							.addEffect(() -> new EffectInstance(EffectRegister.MAGIC_INCREASE.get(), 1200, 0), 1F)));
	public static final RegistryObject<Item> WULONG_TEA = ITEMS.register("wulong_tea_drink",
			() -> new ItemDrinkBase(new Item.Properties().tab(Main.TEA_GROUP).craftRemainder(cup.get()),
					new FoodInfo("wulong_tea_drink", 1, 1, false, true, 16)
							.addEffect(() -> new EffectInstance(EffectRegister.FRESH.get(), 1200, 0), 1F)
							.addEffect(() -> new EffectInstance(EffectRegister.MAGIC_INCREASE.get(), 1200, 0), 1F)));
	public static final RegistryObject<Item> MOCHA_DRINK = ITEMS.register("mocha_drink",
			() -> new ItemDrinkBase(new Item.Properties().tab(Main.TEA_GROUP).craftRemainder(cup.get()),
					new FoodInfo("mocha_drink", 1, 1, false, true, 16)
							.addEffect(() -> new EffectInstance(EffectRegister.FRESH.get(), 1200, 0), 1F)
							.addEffect(() -> new EffectInstance(EffectRegister.MAGIC_INCREASE.get(), 1200, 0), 1F)));
	public static final RegistryObject<Item> FRUIT_DRINK = ITEMS.register("fruit_tea_drink",
			() -> new ItemDrinkBase(new Item.Properties().tab(Main.TEA_GROUP).craftRemainder(cup.get()),
					new FoodInfo("fruit_tea_drink", 1, 1, false, true, 16)
							.addEffect(() -> new EffectInstance(EffectRegister.FRESH.get(), 1200, 0), 1F)
							.addEffect(() -> new EffectInstance(EffectRegister.MAGIC_INCREASE.get(), 1200, 0), 1F)));
	public static final RegistryObject<Item> FLOWER_TEA = ITEMS.register("flower_tea_drink",
			() -> new ItemDrinkBase(new Item.Properties().tab(Main.TEA_GROUP).craftRemainder(cup.get()),
					new FoodInfo("flower_tea_drink", 1, 1, false, true, 16)
							.addEffect(() -> new EffectInstance(EffectRegister.FRESH.get(), 1800, 0), 1F)
							.addEffect(() -> new EffectInstance(EffectRegister.MAGIC_INCREASE.get(), 1800, 0), 1F)));
	public static final RegistryObject<Item> RICE_TEA = ITEMS.register("rice_tea_drink",
			() -> new ItemDrinkBase(new Item.Properties().tab(Main.TEA_GROUP).craftRemainder(cup.get()),
					new FoodInfo("rice_tea_drink", 1, 1, false, true, 16)
							.addEffect(() -> new EffectInstance(EffectRegister.FRESH.get(), 1800, 0), 1F)
							.addEffect(() -> new EffectInstance(EffectRegister.MAGIC_INCREASE.get(), 1800, 0), 1F)));

	public static final RegistryObject<Item> FIRE_TEA = ITEMS.register("fire_tea_drink",
			() -> new DrinkTeaMagic(new Item.Properties().tab(Main.TEA_GROUP).craftRemainder(cup.get()),
					new FoodInfo("fire_tea_drink", 1, 1, false, true, 16)
							.addEffect(() -> new EffectInstance(Effects.FIRE_RESISTANCE, 1200, 0), 1F)
							.addEffect(() -> new EffectInstance(EffectRegister.FRESH.get(), 1800, 0), 1F)
							.addEffect(() -> new EffectInstance(EffectRegister.MAGIC_INCREASE.get(), 1800, 1), 1F)));
	public static final RegistryObject<Item> METAL_TEA = ITEMS.register("metal_tea_drink",
			() -> new DrinkTeaMagic(new Item.Properties().tab(Main.TEA_GROUP).craftRemainder(cup.get()),
					new FoodInfo("metal_tea_drink", 1, 1, false, true, 16)
							.addEffect(() -> new EffectInstance(Effects.SATURATION, 1200, 0), 1F)
							.addEffect(() -> new EffectInstance(EffectRegister.FRESH.get(), 1800, 0), 1F)
							.addEffect(() -> new EffectInstance(EffectRegister.MAGIC_INCREASE.get(), 1800, 1), 1F)));
	public static final RegistryObject<Item> WOOD_TEA = ITEMS.register("wood_tea_drink",
			() -> new DrinkTeaMagic(new Item.Properties().tab(Main.TEA_GROUP).craftRemainder(cup.get()),
					new FoodInfo("wood_tea_drink", 1, 1, false, true, 16)
							.addEffect(() -> new EffectInstance(Effects.REGENERATION, 1200, 0), 1F)
							.addEffect(() -> new EffectInstance(EffectRegister.FRESH.get(), 1800, 0), 1F)
							.addEffect(() -> new EffectInstance(EffectRegister.MAGIC_INCREASE.get(), 1800, 1), 1F)));
	public static final RegistryObject<Item> WATER_TEA = ITEMS.register("water_tea_drink",
			() -> new DrinkTeaMagic(new Item.Properties().tab(Main.TEA_GROUP).craftRemainder(cup.get()),
					new FoodInfo("water_tea_drink ", 1, 1, false, true, 16)
							.addEffect(() -> new EffectInstance(Effects.WATER_BREATHING, 1200, 0), 1F)
							.addEffect(() -> new EffectInstance(EffectRegister.FRESH.get(), 1800, 0), 1F)
							.addEffect(() -> new EffectInstance(EffectRegister.MAGIC_INCREASE.get(), 1800, 1), 1F)));
	public static final RegistryObject<Item> EARTH_TEA = ITEMS.register("earth_tea_drink",
			() -> new DrinkTeaMagic(new Item.Properties().tab(Main.TEA_GROUP).craftRemainder(cup.get()),
					new FoodInfo("earth_tea_drink", 1, 1, false, true, 16)
							.addEffect(() -> new EffectInstance(Effects.DAMAGE_RESISTANCE, 1200, 0), 1F)
							.addEffect(() -> new EffectInstance(EffectRegister.FRESH.get(), 1800, 0), 1F)
							.addEffect(() -> new EffectInstance(EffectRegister.MAGIC_INCREASE.get(), 1800, 1), 1F)));
	public static final RegistryObject<Item> SOLAR_TEA = ITEMS.register("solar_tea_drink",
			() -> new DrinkTeaMagic(new Item.Properties().tab(Main.TEA_GROUP).craftRemainder(cup.get()),
					new FoodInfo("solar_tea_drink", 1, 1, false, true, 16)
							.addEffect(() -> new EffectInstance(Effects.DAMAGE_BOOST, 1200, 0), 1F)
							.addEffect(() -> new EffectInstance(EffectRegister.FRESH.get(), 1800, 0), 1F)
							.addEffect(() -> new EffectInstance(EffectRegister.MAGIC_INCREASE.get(), 1800, 1), 1F)));
	public static final RegistryObject<Item> LUNA_TEA = ITEMS.register("luna_tea_drink",
			() -> new DrinkTeaMagic(new Item.Properties().tab(Main.TEA_GROUP).craftRemainder(cup.get()),
					new FoodInfo("luna_tea_drink", 1, 1, false, true, 16)
							.addEffect(() -> new EffectInstance(Effects.NIGHT_VISION, 1200, 0), 1F)
							.addEffect(() -> new EffectInstance(EffectRegister.FRESH.get(), 1800, 0), 1F)
							.addEffect(() -> new EffectInstance(EffectRegister.MAGIC_INCREASE.get(), 1800, 1), 1F)));

	public static final RegistryObject<Item> SEVEN_MAGIC_TEA = ITEMS.register("seven_magic_tea_drink",
			() -> new DrinkTeaMagic(new Item.Properties().stacksTo(1).tab(Main.TEA_GROUP).craftRemainder(cup.get()),
					new FoodInfo("seven_magic_tea_drink", 1, 1, false, true, 16)
							.addEffect(() -> new EffectInstance(Effects.FIRE_RESISTANCE, 1800, 1), 1F)
							.addEffect(() -> new EffectInstance(Effects.SATURATION, 1800, 1), 1F)
							.addEffect(() -> new EffectInstance(Effects.REGENERATION, 1800, 1), 1F)
							.addEffect(() -> new EffectInstance(Effects.WATER_BREATHING, 1800, 1), 1F)
							.addEffect(() -> new EffectInstance(Effects.DAMAGE_RESISTANCE, 1800, 1), 1F)
							.addEffect(() -> new EffectInstance(Effects.DAMAGE_BOOST, 1800, 1), 1F)
							.addEffect(() -> new EffectInstance(Effects.NIGHT_VISION, 1800, 1), 1F)
							.addEffect(() -> new EffectInstance(EffectRegister.FRESH.get(), 1800, 0), 1F)
							.addEffect(() -> new EffectInstance(EffectRegister.MAGIC_INCREASE.get(), 1800, 2), 1F)));
	
}
