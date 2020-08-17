package cn.mcmod.tea_sorcerer;

import cn.mcmod.tea_sorcerer.client.render.BeamRender;
import cn.mcmod.tea_sorcerer.client.render.FlyingLeafRender;
import cn.mcmod.tea_sorcerer.client.render.MatchaBeamRender;
import cn.mcmod.tea_sorcerer.magic.FlyingLeafEntity;
import cn.mcmod.tea_sorcerer.register.BlockRegistry;
import cn.mcmod.tea_sorcerer.register.EntityRegistry;
import cn.mcmod.tea_sorcerer.tea.RenderTileEntityPlate;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD,value = Dist.CLIENT,modid = Main.MODID)
public class ClientEventRegistry {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
    	RenderTypeLookup.setRenderLayer(BlockRegistry.RICE_CROP, RenderType.getCutoutMipped());
     	RenderTypeLookup.setRenderLayer(BlockRegistry.RICE_ROOT, RenderType.getCutoutMipped());
     	RenderTypeLookup.setRenderLayer(BlockRegistry.TEA_TREE, RenderType.getCutoutMipped());
     	
    	RenderTypeLookup.setRenderLayer(BlockRegistry.marguerite, RenderType.getCutoutMipped());
     	RenderTypeLookup.setRenderLayer(BlockRegistry.radiata, RenderType.getCutoutMipped());
     	RenderTypeLookup.setRenderLayer(BlockRegistry.sambac, RenderType.getCutoutMipped());
     	
     	ClientRegistry.bindTileEntityRenderer(BlockRegistry.PLATE_TE, (tileEntityRendererDispatcher -> {
            return new RenderTileEntityPlate(tileEntityRendererDispatcher);
        }));
     	
     	RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.MATCHA_BEAM,  (EntityRendererManager manager) -> {
            return new MatchaBeamRender(manager);
        });
     	RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.BEAM, (EntityRendererManager manager) -> {
     		return new BeamRender(manager);
     	});
     	RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.FLYING_LEAF, (EntityRendererManager manager) -> {
     		return new FlyingLeafRender<FlyingLeafEntity>(manager);
     	});
    }
	
}
