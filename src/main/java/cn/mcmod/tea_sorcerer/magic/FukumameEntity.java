package cn.mcmod.tea_sorcerer.magic;

import cn.mcmod.tea_sorcerer.register.EntityRegistry;
import cn.mcmod.tea_sorcerer.register.ItemRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;

public class FukumameEntity extends ThrowableEntity {
    private Entity ignoreEntity;

    public FukumameEntity(EntityType<? extends FukumameEntity> p_i50159_1_, World p_i50159_2_) {
        super(p_i50159_1_, p_i50159_2_);
    }
    
    public FukumameEntity(World worldIn, LivingEntity throwerIn) {
        super(EntityRegistry.FLYING_LEAF, throwerIn, worldIn);
    }

    public FukumameEntity(World worldIn, double x, double y, double z) {
        super(EntityRegistry.FLYING_LEAF, x, y, z, worldIn);
    }

    public FukumameEntity(FMLPlayMessages.SpawnEntity spawnEntity, World world) {
        this(EntityRegistry.FLYING_LEAF, world);
    }

    @Override
    protected void registerData() {

    }

    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 3) {
            for (int i = 0; i < 6; ++i) {
                this.world.addParticle(new ItemParticleData(ParticleTypes.ITEM, new ItemStack(ItemRegistry.tea_leaves)), this.getPosX(), this.getPosY(), this.getPosZ(), ((double) this.rand.nextFloat() - 0.5D) * 0.08D, ((double) this.rand.nextFloat() - 0.5D) * 0.08D, ((double) this.rand.nextFloat() - 0.5D) * 0.08D);
            }
        }
    }


    @Override
    protected void onImpact(RayTraceResult result) {

        AxisAlignedBB axisalignedbb = this.getBoundingBox().expand(this.getMotion()).grow(1.0D);

        RayTraceResult result2 = ProjectileHelper.rayTrace(this, axisalignedbb, (p_213880_1_) -> {
            return !p_213880_1_.isSpectator() && p_213880_1_.canBeCollidedWith() && p_213880_1_ != this.ignoreEntity;
        }, RayTraceContext.BlockMode.COLLIDER, true);

        if (result2.getType() == RayTraceResult.Type.ENTITY) {
            Entity entity = ((EntityRayTraceResult) result2).getEntity();

            if (this.getThrower() == entity && this.ticksExisted < 3) {
                return;
            }

            entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float) 2);

            entity.hurtResistantTime = 5;

            if (!this.world.isRemote) {
                this.world.setEntityState(this, (byte) 3);
                this.remove();
            }
        } else if (result2.getType() == RayTraceResult.Type.BLOCK) {
            if (!this.world.isRemote) {
                this.world.setEntityState(this, (byte) 3);
                this.remove();
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean teleport) {
        this.setPosition(x, y, z);
        this.setRotation(yaw, pitch);
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
