package cn.mcmod.tea_sorcerer.entity;

import cn.mcmod.tea_sorcerer.Versions;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityRegister {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES,
            Versions.MODID);

    public static final RegistryObject<EntityType<EntityLeafDanmaku>> LEAF_DANMAKU = ENTITY_TYPES.register(
            "leaf_danmaku",
            () -> EntityType.Builder.<EntityLeafDanmaku>of(EntityLeafDanmaku::new, EntityClassification.MISC)
                    .sized(0.3125f, 0.3125f).setUpdateInterval(10).setTrackingRange(64)
                    .setShouldReceiveVelocityUpdates(true).build("leaf_danmaku"));
    public static final RegistryObject<EntityType<EntityBasicDanmaku>> BASIC_DANMAKU = ENTITY_TYPES.register(
            "basic_danmaku",
            () -> EntityType.Builder.<EntityBasicDanmaku>of(EntityBasicDanmaku::new, EntityClassification.MISC)
                    .sized(0.3125f, 0.3125f).setUpdateInterval(10).setTrackingRange(64)
                    .setShouldReceiveVelocityUpdates(true).build("basic_danmaku"));
}
