package cn.mcmod.tea_sorcerer.compat.chinese_sword;

import cn.mcmod.chinese_sword.item.AncientSwordItem;
import cn.mcmod.chinese_sword.item.ChineseSwordItem;
import cn.mcmod.chinese_sword.item.SwordSheathItem;
import cn.mcmod.chinese_sword.item.WeaponTier;
import cn.mcmod.tea_sorcerer.Versions;
import cn.mcmod.tea_sorcerer.item.tool.TeaItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ChineseSwordRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Versions.MODID);

    public static final WeaponTier BLACK_TEA = new WeaponTier("black_tea", TeaItemTier.TEA_INGOT,
            new ResourceLocation("forge", "ingots/black_tea"), new BlackTeaFeature());
    
    public static final RegistryObject<Item> BLACK_TEA_CHINESE_SWORD_SHEATH = ITEMS.register("black_tea_chinese_sword_sheath",
            SwordSheathItem::new);

    public static final RegistryObject<Item> BLACK_TEA_ANCIENT_SWORD_SHEATH = ITEMS.register("black_tea_ancient_sword_sheath",
            SwordSheathItem::new);
    
    public static final RegistryObject<Item> BLACK_TEA_CHINESE_SWORD = ITEMS.register("black_tea_chinese_sword",
            () -> new ChineseSwordItem(BLACK_TEA, new ItemStack(BLACK_TEA_CHINESE_SWORD_SHEATH.get())));

    public static final RegistryObject<Item> BLACK_TEA_ANCIENT_SWORD = ITEMS.register("black_tea_ancient_sword",
            () -> new AncientSwordItem(BLACK_TEA, new ItemStack(BLACK_TEA_ANCIENT_SWORD_SHEATH.get())));
}
