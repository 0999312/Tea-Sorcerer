package cn.mcmod.tea_sorcerer;

import cn.mcmod.tea_sorcerer.client.render.BeamRender;
import cn.mcmod.tea_sorcerer.client.render.FlyingLeafRender;
import cn.mcmod.tea_sorcerer.client.render.MatchaBeamRender;
import cn.mcmod.tea_sorcerer.magic.FlyingLeafEntity;
import cn.mcmod.tea_sorcerer.register.BlockRegistry;
import cn.mcmod.tea_sorcerer.register.EntityRegistry;
import cn.mcmod.tea_sorcerer.register.ItemRegistry;
import cn.mcmod.tea_sorcerer.register.MainRegistry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Main.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD,modid = Main.MODID)
public class Main {
	public static final String MODID = "tea_sorcerer";
	
	public static final ItemGroup TS_GROUP = new ItemGroup(Main.MODID) {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(ItemRegistry.green_tea_leaves);
		}
	};
    public Main() {
    	FMLJavaModLoadingContext.get().getModEventBus().register(MainRegistry.getInstance());
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::serverSetup);
        new BlockRegistry();
        new ItemRegistry();
        new EntityRegistry();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    	MainRegistry.getInstance().clearAll();
    }

    private void clientSetup(final FMLClientSetupEvent event) {
    	RenderTypeLookup.setRenderLayer(BlockRegistry.RICE_CROP, RenderType.getCutoutMipped());
     	RenderTypeLookup.setRenderLayer(BlockRegistry.RICE_ROOT, RenderType.getCutoutMipped());
     	RenderTypeLookup.setRenderLayer(BlockRegistry.TEA_TREE, RenderType.getCutoutMipped());
     	
    	RenderTypeLookup.setRenderLayer(BlockRegistry.marguerite, RenderType.getCutoutMipped());
     	RenderTypeLookup.setRenderLayer(BlockRegistry.radiata, RenderType.getCutoutMipped());
     	RenderTypeLookup.setRenderLayer(BlockRegistry.sambac, RenderType.getCutoutMipped());
     	
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
    
    private void serverSetup(final FMLDedicatedServerSetupEvent event) {
    }

}
