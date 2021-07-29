package cn.mcmod.tea_sorcerer.item;

import cn.mcmod.tea_sorcerer.Main;
import cn.mcmod.tea_sorcerer.Versions;
import cn.mcmod.tea_sorcerer.block.BlockRegister;
import cn.mcmod.tea_sorcerer.effect.EffectRegister;
import cn.mcmod.tea_sorcerer.item.armor.ArmorWanderer;
import cn.mcmod.tea_sorcerer.item.magic.ItemLaserDanmaku;
import cn.mcmod.tea_sorcerer.item.magic.ItemLeafDanmaku;
import cn.mcmod.tea_sorcerer.item.magic.ItemSpellCard;
import cn.mcmod.tea_sorcerer.item.magic.ScrollMagicInfo;
import cn.mcmod.tea_sorcerer.item.tool.TeaItemTier;
import cn.mcmod_mmf.mmlib.item.ItemDrinkBase;
import cn.mcmod_mmf.mmlib.item.info.FoodInfo;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegister {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Versions.MODID);
    public static final RegistryObject<Item> cup = ITEMS.register("cup",
            () -> new Item(new Item.Properties().tab(Main.TEA_GROUP)));

    public static final RegistryObject<Item> tea_seed = ITEMS.register("tea_seed",
            () -> new BlockNamedItem(BlockRegister.TEA_CROP.get(), new Item.Properties().tab(Main.TEA_GROUP)));
    
    public static final RegistryObject<Item> marguerite = ITEMS.register("marguerite",
            () -> new BlockItem(BlockRegister.marguerite.get(), new Item.Properties().tab(Main.TEA_GROUP)));
    
    public static final RegistryObject<Item> radiata = ITEMS.register("radiata",
            () -> new BlockItem(BlockRegister.radiata.get(), new Item.Properties().tab(Main.TEA_GROUP)));
    
    public static final RegistryObject<Item> sambac = ITEMS.register("sambac",
            () -> new BlockItem(BlockRegister.sambac.get(), new Item.Properties().tab(Main.TEA_GROUP)));
    
    public static final RegistryObject<Item> TEA_POT = ITEMS.register("tea_pot",
            () -> new BlockItem(BlockRegister.TEA_POT.get(), new Item.Properties().tab(Main.TEA_GROUP)));

    public static final RegistryObject<Item> tea_leaves = ITEMS.register("tea_leaves",
            () -> new Item(new Item.Properties().tab(Main.TEA_GROUP)));
    
    public static final RegistryObject<Item> straw = ITEMS.register("straw",
            () -> new Item(new Item.Properties().tab(Main.TEA_GROUP)));
    
    public static final RegistryObject<Item> rice = ITEMS.register("rice",
            () -> new Item(new Item.Properties().tab(Main.TEA_GROUP)));
    
    public static final RegistryObject<Item> brown_rice = ITEMS.register("brown_rice",
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
    
    public static final RegistryObject<Item> BLACK_TEA_SWORD = ITEMS.register("black_tea_sword",
            () -> new SwordItem(TeaItemTier.TEA_INGOT, 5, -2F,new Item.Properties().stacksTo(1).tab(Main.TEA_GROUP)));
   
    public static final RegistryObject<Item> BLACK_TEA_AXE = ITEMS.register("black_tea_axe",
            () -> new AxeItem(TeaItemTier.TEA_INGOT, 8, -3F,new Item.Properties().stacksTo(1).tab(Main.TEA_GROUP)));
    
    public static final RegistryObject<Item> BLACK_TEA_PICKAXE = ITEMS.register("black_tea_pickaxe",
            () -> new PickaxeItem(TeaItemTier.TEA_INGOT, 3, -2F,new Item.Properties().stacksTo(1).tab(Main.TEA_GROUP)));
    
    public static final RegistryObject<Item> BLACK_TEA_SHOVEL = ITEMS.register("black_tea_shovel",
            () -> new ShovelItem(TeaItemTier.TEA_INGOT, 2, -2F,new Item.Properties().stacksTo(1).tab(Main.TEA_GROUP)));
    
    public static final RegistryObject<Item> BLACK_TEA_HOE = ITEMS.register("black_tea_hoe",
            () -> new HoeItem(TeaItemTier.TEA_INGOT, 0, 0F,new Item.Properties().stacksTo(1).tab(Main.TEA_GROUP)));

    public static final RegistryObject<Item> WANDERER_HAT = ITEMS.register("wanderer_hat",
            () -> new ArmorWanderer(EquipmentSlotType.HEAD, new Item.Properties().stacksTo(1).tab(Main.TEA_GROUP)));
    public static final RegistryObject<Item> WANDERER_CLOTH = ITEMS.register("wanderer_cloth",
            () -> new ArmorWanderer(EquipmentSlotType.CHEST, new Item.Properties().stacksTo(1).tab(Main.TEA_GROUP)));
    public static final RegistryObject<Item> WANDERER_PANTS = ITEMS.register("wanderer_pants",
            () -> new ArmorWanderer(EquipmentSlotType.LEGS, new Item.Properties().stacksTo(1).tab(Main.TEA_GROUP)));

    public static final RegistryObject<Item> SCROLL_INFO = ITEMS.register("scroll_info", ScrollMagicInfo::new);
    
    public static final RegistryObject<Item> LEAF_DANMAKU_BOOK = ITEMS.register("leaf_danmaku_magic_book",
            ItemLeafDanmaku::new);
    
    public static final RegistryObject<Item> tea_knife = ITEMS.register("tea_knife",
            () -> new Item(new Item.Properties().tab(Main.TEA_GROUP)));
    
    public static final RegistryObject<Item> flower_tea_sign = ITEMS.register("flower_tea_sign",
            FlowerTeaSigh::new);
    
    public static final RegistryObject<Item> BEAM_DANMAKU_BOOK = ITEMS.register("beam_danmaku_magic_book",
            ItemLaserDanmaku::new);
    
    public static final RegistryObject<Item> TEST_SPELL = ITEMS.register("spell_test", ItemSpellCard::new);

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

    public static final RegistryObject<Item> TEA_REIMU = ITEMS.register("tea_drink_reimu",
            () -> new DrinkTeaChara(new Item.Properties().tab(Main.TEA_GROUP).craftRemainder(cup.get()),
                    new FoodInfo("tea_drink_reimu", 1, 1, false, true, 16)
                            .addEffect(() -> new EffectInstance(EffectRegister.FRESH.get(), 1200, 0), 1F)
                            .addEffect(() -> new EffectInstance(Effects.SLOW_FALLING, 1200, 0), 0.25F)
                            .addEffect(() -> new EffectInstance(EffectRegister.MAGIC_INCREASE.get(), 2400, 1), 1F)));
    public static final RegistryObject<Item> TEA_MARISA = ITEMS.register("tea_drink_marisa",
            () -> new DrinkTeaChara(new Item.Properties().tab(Main.TEA_GROUP).craftRemainder(cup.get()),
                    new FoodInfo("tea_drink_marisa", 1, 1, false, true, 16)
                            .addEffect(() -> new EffectInstance(EffectRegister.FRESH.get(), 1200, 0), 1F)
                            .addEffect(() -> new EffectInstance(Effects.HUNGER, 1200, 0), 0.51F)
                            .addEffect(() -> new EffectInstance(EffectRegister.MAGIC_INCREASE.get(), 2400, 0), 1F)));

    public static final RegistryObject<Item> TEA_ALICE = ITEMS.register("tea_drink_alice",
            () -> new DrinkTeaChara(new Item.Properties().stacksTo(1).tab(Main.TEA_GROUP).craftRemainder(cup.get()),
                    new FoodInfo("tea_drink_alice", 1, 1, false, true, 16)
                            .addEffect(() -> new EffectInstance(Effects.HEALTH_BOOST, 1200, 0), 1F)
                            .addEffect(() -> new EffectInstance(Effects.DAMAGE_RESISTANCE, 1200, 0), 1F)
                            .addEffect(() -> new EffectInstance(Effects.DAMAGE_BOOST, 1200, 1), 1F)
                            .addEffect(() -> new EffectInstance(EffectRegister.FRESH.get(), 1800, 0), 1F)
                            .addEffect(() -> new EffectInstance(EffectRegister.MAGIC_INCREASE.get(), 1800, 2), 1F)));

    public static final RegistryObject<Item> TEA_PATCHOULI = ITEMS.register("tea_drink_patchouli",
            () -> new DrinkTeaChara(new Item.Properties().stacksTo(1).tab(Main.TEA_GROUP).craftRemainder(cup.get()),
                    new FoodInfo("tea_drink_patchouli", 1, 1, false, true, 16)
                            .addEffect(() -> new EffectInstance(Effects.FIRE_RESISTANCE, 2400, 2), 1F)
                            .addEffect(() -> new EffectInstance(Effects.SATURATION, 2400, 2), 1F)
                            .addEffect(() -> new EffectInstance(Effects.REGENERATION, 2400, 2), 1F)
                            .addEffect(() -> new EffectInstance(Effects.WATER_BREATHING, 2400, 2), 1F)
                            .addEffect(() -> new EffectInstance(Effects.DAMAGE_RESISTANCE, 2400, 2), 1F)
                            .addEffect(() -> new EffectInstance(Effects.DAMAGE_BOOST, 2400, 2), 1F)
                            .addEffect(() -> new EffectInstance(Effects.NIGHT_VISION, 2400, 2), 1F)

                            .addEffect(() -> new EffectInstance(Effects.WITHER, 2400, 1), 0.25F)
                            .addEffect(() -> new EffectInstance(Effects.BLINDNESS, 2400, 10), 0.25F)
                            .addEffect(() -> new EffectInstance(Effects.CONFUSION, 2400, 1), 0.25F)
                            .addEffect(() -> new EffectInstance(Effects.WEAKNESS, 2400, 1), 0.25F)

                            .addEffect(() -> new EffectInstance(EffectRegister.MAGIC_INCREASE.get(), 2400, 2), 1F)));

    public static final RegistryObject<Item> TEA_RUMIA = ITEMS.register("tea_drink_rumia",
            () -> new DrinkTeaChara(new Item.Properties().tab(Main.TEA_GROUP).craftRemainder(cup.get()),
                    new FoodInfo("tea_drink_rumia", 1, 1, false, true, 16)
                            .addEffect(() -> new EffectInstance(EffectRegister.FRESH.get(), 1200, 0), 1F)
                            .addEffect(() -> new EffectInstance(Effects.NIGHT_VISION, 2400, 0), 1F)
                            .addEffect(() -> new EffectInstance(EffectRegister.MAGIC_INCREASE.get(), 1200, 0), 1F)));

    public static final RegistryObject<Item> TEA_AYA = ITEMS.register("tea_drink_aya",
            () -> new DrinkTeaChara(new Item.Properties().stacksTo(1).tab(Main.TEA_GROUP).craftRemainder(cup.get()),
                    new FoodInfo("tea_drink_aya", 1, 1, false, true, 16)
                            .addEffect(() -> new EffectInstance(Effects.DIG_SPEED, 1800, 2), 1F)
                            .addEffect(() -> new EffectInstance(Effects.MOVEMENT_SPEED, 1800, 2), 1F)
                            .addEffect(() -> new EffectInstance(Effects.SLOW_FALLING, 1200, 0), 1F)
                            .addEffect(() -> new EffectInstance(EffectRegister.FRESH.get(), 1800, 0), 1F)
                            .addEffect(() -> new EffectInstance(EffectRegister.MAGIC_INCREASE.get(), 1800, 0), 1F)));

    public static final RegistryObject<Item> TEA_TENKO = ITEMS.register("tea_drink_tenko",
            () -> new DrinkTeaChara(new Item.Properties().tab(Main.TEA_GROUP).craftRemainder(cup.get()),
                    new FoodInfo("tea_drink_tenko", 1, 1, false, true, 16)
                            .addEffect(() -> new EffectInstance(EffectRegister.FRESH.get(), 1200, 0), 1F)
                            .addEffect(() -> new EffectInstance(Effects.REGENERATION, 1200, 0), 1F)
                            .addEffect(() -> new EffectInstance(Effects.DAMAGE_RESISTANCE, 1200, 2), 1F)
                            .addEffect(() -> new EffectInstance(EffectRegister.MAGIC_INCREASE.get(), 1200, 0), 1F)));

    public static final RegistryObject<Item> TEA_TEWI = ITEMS.register("tea_drink_tewi",
            () -> new DrinkTeaChara(new Item.Properties().tab(Main.TEA_GROUP).craftRemainder(cup.get()),
                    new FoodInfo("tea_drink_tewi", 1, 1, false, true, 16)
                            .addEffect(() -> new EffectInstance(EffectRegister.FRESH.get(), 1200, 0), 1F)
                            .addEffect(() -> new EffectInstance(Effects.LUCK, 1200, 2), 1F)
                            .addEffect(() -> new EffectInstance(EffectRegister.MAGIC_INCREASE.get(), 1200, 0), 1F)));

    public static final RegistryObject<Item> TEA_ZHENG = ITEMS.register("tea_drink_zheng",
            () -> new DrinkTeaChara(new Item.Properties().stacksTo(1).tab(Main.TEA_GROUP).craftRemainder(cup.get()),
                    new FoodInfo("tea_drink_zheng", 1, 1, false, true, 16)
                            .addEffect(() -> new EffectInstance(Effects.DIG_SPEED, 1800, 1), 1F)
                            .addEffect(() -> new EffectInstance(Effects.MOVEMENT_SPEED, 1800, 1), 1F)
                            .addEffect(() -> new EffectInstance(Effects.SLOW_FALLING, 1800, 0), 1F)
                            .addEffect(() -> new EffectInstance(EffectRegister.FRESH.get(), 1800, 0), 1F)
                            .addEffect(() -> new EffectInstance(EffectRegister.MAGIC_INCREASE.get(), 1800, 1), 1F)));
}
