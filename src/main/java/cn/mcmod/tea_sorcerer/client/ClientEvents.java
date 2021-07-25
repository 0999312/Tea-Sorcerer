package cn.mcmod.tea_sorcerer.client;

import cn.mcmod.chinese_sword.item.AncientSwordItem;
import cn.mcmod.chinese_sword.item.ChineseSwordItem;
import cn.mcmod.tea_sorcerer.Versions;
import cn.mcmod.tea_sorcerer.block.BlockRegister;
import cn.mcmod.tea_sorcerer.client.particle.ParticleRegister;
import cn.mcmod.tea_sorcerer.client.particle.TrailParticleLeaf;
import cn.mcmod.tea_sorcerer.client.particle.TrailParticleNull;
import cn.mcmod.tea_sorcerer.client.render.RenderLeafDanmaku;
import cn.mcmod.tea_sorcerer.client.render.RendererBasicDanmaku;
import cn.mcmod.tea_sorcerer.compat.chinese_sword.ChineseSwordRegistry;
import cn.mcmod.tea_sorcerer.entity.EntityRegister;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = Versions.MODID, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void clientStuff(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(BlockRegister.TEA_CROP.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(BlockRegister.marguerite.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(BlockRegister.radiata.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(BlockRegister.sambac.get(), RenderType.cutoutMipped());
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.LEAF_DANMAKU.get(), RenderLeafDanmaku::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.BASIC_DANMAKU.get(), RendererBasicDanmaku::new);
    }

    @SubscribeEvent
    public static void setupClient(final FMLClientSetupEvent event) {
        if(ModList.get().isLoaded("chinese_sword"))
        event.enqueueWork(() -> {
            // 进行批量注册Item Property Override
            ChineseSwordRegistry.ITEMS.getEntries().forEach(ClientEvents::registerBlockingProperties);
        });
    }

    private static void registerBlockingProperties(RegistryObject<Item> item) {
        if (item.get() instanceof AncientSwordItem || item.get() instanceof ChineseSwordItem)
            // 注册原版的blocking Property
            ItemModelsProperties.register(item.get(), new ResourceLocation("blocking"),
                    (itemStack, clientWorld, livingEntity) -> (livingEntity != null && livingEntity.isUsingItem()
                            && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F));
    }
    
    @SubscribeEvent
    public static void onParticleFactoryRegistration(ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particleEngine.register(ParticleRegister.LEAF_TRAIL.get(),
                TrailParticleLeaf.Factory::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegister.EMPTY_TRAIL.get(),
                TrailParticleNull.Factory::new);
    }
}
