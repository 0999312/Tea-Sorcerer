package cn.mcmod.tea_sorcerer;

import cn.mcmod.tea_sorcerer.register.BlockRegistry;
import cn.mcmod.tea_sorcerer.register.EntityRegistry;
import cn.mcmod.tea_sorcerer.register.ItemRegistry;
import cn.mcmod.tea_sorcerer.register.MainRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
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
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::serverSetup);
        new BlockRegistry();
        new ItemRegistry();
        new EntityRegistry();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    	MainRegistry.getInstance().clearAll();
    }
    
    private void serverSetup(final FMLDedicatedServerSetupEvent event) {
    }

}
