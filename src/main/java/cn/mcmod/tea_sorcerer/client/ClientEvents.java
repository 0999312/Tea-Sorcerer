package cn.mcmod.tea_sorcerer.client;

import cn.mcmod.tea_sorcerer.Versions;
import cn.mcmod.tea_sorcerer.client.particle.ParticleRegister;
import cn.mcmod.tea_sorcerer.client.particle.TrailParticleLeaf;
import cn.mcmod.tea_sorcerer.client.particle.TrailParticleNull;
import cn.mcmod.tea_sorcerer.client.render.RenderLeafDanmaku;
import cn.mcmod.tea_sorcerer.client.render.RendererBasicDanmaku;
import cn.mcmod.tea_sorcerer.entity.EntityRegister;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = Versions.MODID, value = Dist.CLIENT)
public class ClientEvents {

	@SubscribeEvent
	public static void clientStuff(final FMLClientSetupEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityRegister.LEAF_DANMAKU.get(), RenderLeafDanmaku::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityRegister.BASIC_DANMAKU.get(), RendererBasicDanmaku::new);
	}
	@SubscribeEvent
    public static void onParticleFactoryRegistration(ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particleEngine.register(ParticleRegister.LEAF_TRAIL.get(), TrailParticleLeaf.Factory::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegister.EMPTY_TRAIL.get(), TrailParticleNull.Factory::new);
    }
}
