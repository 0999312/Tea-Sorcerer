package cn.mcmod.tea_sorcerer.client.particle;

import cn.mcmod.tea_sorcerer.Versions;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ParticleRegister {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister
            .create(ForgeRegistries.PARTICLE_TYPES, Versions.MODID);
    public static final RegistryObject<BasicParticleType> LEAF_TRAIL = PARTICLE_TYPES.register("leaf_trail",
            () -> new BasicParticleType(false));
    public static final RegistryObject<BasicParticleType> EMPTY_TRAIL = PARTICLE_TYPES.register("empty_trail",
            () -> new BasicParticleType(false));
}
