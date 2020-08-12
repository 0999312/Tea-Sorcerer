package cn.mcmod.tea_sorcerer.register;

import cn.mcmod.tea_sorcerer.magic.BeamEntity;
import cn.mcmod.tea_sorcerer.magic.FukumameEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;

public class EntityRegistry extends ObjectRegistry {
	@SuppressWarnings("unchecked")
	public static final EntityType<FukumameEntity> FLYING_LEAF = (EntityType<FukumameEntity>) EntityType.Builder.<FukumameEntity>create(FukumameEntity::new, EntityClassification.MISC).setTrackingRange(4).setCustomClientFactory(FukumameEntity::new).setUpdateInterval(4).setShouldReceiveVelocityUpdates(true).size(0.4F, 0.4F).build("tea_sorcerer.flying_leaf").setRegistryName("tea_sorcerer", "flying_leaf");
    @SuppressWarnings("unchecked")
	public static final EntityType<BeamEntity> BEAM = (EntityType<BeamEntity>) EntityType.Builder.<BeamEntity>create(BeamEntity::new, EntityClassification.MISC).setTrackingRange(4).setCustomClientFactory(BeamEntity::new).setUpdateInterval(4).setShouldReceiveVelocityUpdates(true).size(0.5F, 0.5F).build("tea_sorcerer.beam").setRegistryName("tea_sorcerer", "beam");
    
}
