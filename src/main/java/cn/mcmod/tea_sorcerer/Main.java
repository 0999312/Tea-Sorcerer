package cn.mcmod.tea_sorcerer;

import cn.mcmod.tea_sorcerer.register.BlockRegistry;
import cn.mcmod.tea_sorcerer.register.ItemRegistry;
import cn.mcmod.tea_sorcerer.register.MainRegistry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
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
        //通过方法引用注册监听器
    	FMLJavaModLoadingContext.get().getModEventBus().register(MainRegistry.getInstance());
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::serverSetup);
        new BlockRegistry();
        new ItemRegistry();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        //TODO: 一些需要同时在物理服务端和客户端完成的任务.
    	MainRegistry.getInstance().clearAll();
    }

    private void clientSetup(final FMLClientSetupEvent event) {
    	RenderTypeLookup.setRenderLayer(BlockRegistry.RICE_CROP, RenderType.getCutoutMipped());
     	RenderTypeLookup.setRenderLayer(BlockRegistry.RICE_ROOT, RenderType.getCutoutMipped());
     	RenderTypeLookup.setRenderLayer(BlockRegistry.TEA_TREE, RenderType.getCutoutMipped());
    }
    
    private void serverSetup(final FMLDedicatedServerSetupEvent event) {
        //TODO: 一些只需要在物理服务端完成的任务.
    }

}
