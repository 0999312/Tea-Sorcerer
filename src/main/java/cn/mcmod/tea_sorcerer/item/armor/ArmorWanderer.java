package cn.mcmod.tea_sorcerer.item.armor;

import cn.mcmod.tea_sorcerer.Versions;
import cn.mcmod_mmf.mmlib.utils.ClientUtil;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ArmorWanderer extends ArmorItem {

    public ArmorWanderer(EquipmentSlotType p_i48534_2_, Properties p_i48534_3_) {
        super(TeaArmorMaterial.WANDERER, p_i48534_2_, p_i48534_3_);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack,
            EquipmentSlotType armorSlot, A _default) {
        return (A) ClientUtil.getArmorModelFromJSON(
                new ResourceLocation(Versions.MODID, "models/armor/wanderer_model.json"), armorSlot);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return "tea_sorcerer:textures/models/armor/wanderer_model.png";
    }
}
