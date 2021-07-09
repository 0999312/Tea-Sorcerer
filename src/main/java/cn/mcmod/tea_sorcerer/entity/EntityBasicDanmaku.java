package cn.mcmod.tea_sorcerer.entity;

import cn.mcmod.tea_sorcerer.client.particle.ParticleRegister;
import cn.mcmod_mmf.mmlib.entity.EntityBullet;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.IParticleData;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

public class EntityBasicDanmaku extends EntityBullet {

    private static final DataParameter<Integer> DANMAKU_TYPE = EntityDataManager.defineId(EntityBasicDanmaku.class, DataSerializers.INT);
    private static final DataParameter<Integer> COLOR = EntityDataManager.defineId(EntityBasicDanmaku.class, DataSerializers.INT);
    
    private static final String DANMAKU_TYPE_TAG = "DanmakuType";
    private static final String DANMAKU_COLOR_TAG = "DanmakuColor";
    
	public EntityBasicDanmaku(EntityType<? extends EntityBullet> p_i50160_1_, World p_i50160_2_) {
		super(p_i50160_1_, p_i50160_2_);
	}
	
    @Override
    protected void defineSynchedData() {
        this.entityData.define(DANMAKU_TYPE, DanmakuType.PELLET.ordinal());
        this.entityData.define(COLOR, DanmakuColor.RED.ordinal());
    }
    
    @Override
	public void readAdditionalSaveData(CompoundNBT compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains(DANMAKU_TYPE_TAG, Constants.NBT.TAG_INT)) {
            setDanmakuType(DanmakuType.getType(compound.getInt(DANMAKU_TYPE_TAG)));
        }
        if (compound.contains(DANMAKU_COLOR_TAG, Constants.NBT.TAG_INT)) {
            setColor(DanmakuColor.getColor(compound.getInt(DANMAKU_COLOR_TAG)));
        }
    }

    @Override
	public void addAdditionalSaveData(CompoundNBT compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt(DANMAKU_TYPE_TAG, getDanmakuType().ordinal());
        compound.putInt(DANMAKU_COLOR_TAG, getColor().ordinal());
    }
	
	public EntityBasicDanmaku(World worldIn, LivingEntity shooter) {
		this(worldIn, shooter, 0, 0, 0);
		setPos(shooter.getX(), shooter.getEyeY() - 0.1, shooter.getZ());
	}

	public EntityBasicDanmaku(World worldIn, LivingEntity shooter, double accelX, double accelY, double accelZ) {
		super(EntityRegister.BASIC_DANMAKU.get(),worldIn, shooter, accelX, accelY, accelZ);
	}

	public EntityBasicDanmaku(World worldIn, double x, double y, double z, double accelX, double accelY, double accelZ) {
		super(EntityRegister.BASIC_DANMAKU.get(),worldIn, x, y, z, accelX, accelY, accelZ);
	}

	@Override
	public void onLivingEntityHit(EntityBullet arg0, LivingEntity arg1, Entity arg2, World arg3) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public IParticleData getTrailParticle() {
	      return ParticleRegister.EMPTY_TRAIL.get();
	}
	
    public DanmakuType getDanmakuType() {
        return DanmakuType.getType(this.entityData.get(DANMAKU_TYPE));
    }

    public EntityBasicDanmaku setDanmakuType(DanmakuType type) {
        this.entityData.set(DANMAKU_TYPE, type.ordinal());
        return this;
    }

    public DanmakuColor getColor() {
        return DanmakuColor.getColor(this.entityData.get(COLOR));
    }

    public EntityBasicDanmaku setColor(DanmakuColor color) {
        this.entityData.set(COLOR, color.ordinal());
        return this;
    }
}
