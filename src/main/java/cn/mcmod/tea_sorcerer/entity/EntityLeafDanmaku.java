package cn.mcmod.tea_sorcerer.entity;

import cn.mcmod.tea_sorcerer.client.particle.ParticleRegister;
import cn.mcmod_mmf.mmlib.entity.EntityBullet;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particles.IParticleData;
import net.minecraft.world.World;

public class EntityLeafDanmaku extends EntityBullet {

	public EntityLeafDanmaku(EntityType<? extends EntityBullet> p_i50160_1_, World p_i50160_2_) {
		super(p_i50160_1_, p_i50160_2_);
	}
	
	public EntityLeafDanmaku(World worldIn, LivingEntity shooter) {
		this(worldIn, shooter, 0, 0, 0);
		setPos(shooter.getX(), shooter.getEyeY() - 0.1, shooter.getZ());
	}

	public EntityLeafDanmaku(World worldIn, LivingEntity shooter, double accelX, double accelY, double accelZ) {
		super(EntityRegister.LEAF_DANMAKU.get(),worldIn, shooter, accelX, accelY, accelZ);
	}

	public EntityLeafDanmaku(World worldIn, double x, double y, double z, double accelX, double accelY, double accelZ) {
		super(EntityRegister.LEAF_DANMAKU.get(),worldIn, x, y, z, accelX, accelY, accelZ);
	}

	@Override
	public void onLivingEntityHit(EntityBullet arg0, LivingEntity arg1, Entity arg2, World arg3) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public IParticleData getTrailParticle() {
	      return ParticleRegister.LEAF_TRAIL.get();
	}
}
