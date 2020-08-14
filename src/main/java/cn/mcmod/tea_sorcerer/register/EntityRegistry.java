package cn.mcmod.tea_sorcerer.register;

import cn.mcmod.tea_sorcerer.magic.BeamEntity;
import cn.mcmod.tea_sorcerer.magic.FlyingLeafEntity;
import cn.mcmod.tea_sorcerer.magic.MatchaBeamEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;

public class EntityRegistry extends ObjectRegistry {
	@SuppressWarnings("unchecked")
	public static final EntityType<FlyingLeafEntity> FLYING_LEAF = (EntityType<FlyingLeafEntity>) EntityType.Builder.<FlyingLeafEntity>create(FlyingLeafEntity::new, EntityClassification.MISC).setTrackingRange(4).setCustomClientFactory(FlyingLeafEntity::new).setUpdateInterval(4).setShouldReceiveVelocityUpdates(true).size(0.4F, 0.4F).build("tea_sorcerer.flying_leaf").setRegistryName("tea_sorcerer", "flying_leaf");
    @SuppressWarnings("unchecked")
	public static final EntityType<BeamEntity> BEAM = (EntityType<BeamEntity>) EntityType.Builder.<BeamEntity>create(BeamEntity::new, EntityClassification.MISC).setTrackingRange(4).setCustomClientFactory(BeamEntity::new).setUpdateInterval(4).setShouldReceiveVelocityUpdates(true).size(0.5F, 0.5F).build("tea_sorcerer.beam").setRegistryName("tea_sorcerer", "beam");
    @SuppressWarnings("unchecked")
	public static final EntityType<MatchaBeamEntity> MATCHA_BEAM = (EntityType<MatchaBeamEntity>) EntityType.Builder.<MatchaBeamEntity>create(MatchaBeamEntity::new, EntityClassification.MISC).setTrackingRange(4).setCustomClientFactory(MatchaBeamEntity::new).setUpdateInterval(4).setShouldReceiveVelocityUpdates(true).size(0.5F, 0.5F).build("tea_sorcerer.matcha_beam").setRegistryName("tea_sorcerer", "matcha_beam");
    
}
