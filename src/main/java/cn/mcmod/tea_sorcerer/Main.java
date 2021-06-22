package cn.mcmod.tea_sorcerer;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cn.mcmod.tea_sorcerer.block.BlockRegister;
import cn.mcmod.tea_sorcerer.effect.EffectRegister;
import cn.mcmod.tea_sorcerer.item.ItemRegister;
import cn.mcmod_mmf.mmlib.utils.ClientUtil;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("tea_sorcerer")
public class Main {
	// Directly reference a log4j logger.
	private static final Logger LOGGER = LogManager.getLogger();

	public static final ItemGroup TEA_GROUP = new ItemGroup("tea_sorcerer") {
		
		@Override
		public ItemStack makeIcon() {
			// TODO Auto-generated method stub
			return new ItemStack(ItemRegister.green_tea_leaves.get());
		}
	};
	
	public Main() {
		// Register the setup method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		// Register the enqueueIMC method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
		// Register the processIMC method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
		// Register the doClientStuff method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

		// Register ourselves for server and other game events we are interested in
		MinecraftForge.EVENT_BUS.register(this);
		
		ItemRegister.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		BlockRegister.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		EffectRegister.EFFECTS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	private void setup(final FMLCommonSetupEvent event) {
		// some preinit code
	}

	private void doClientStuff(final FMLClientSetupEvent event) {
		// do something that can only be done on the client
		ClientUtil.loadModel(new ResourceLocation(Versions.MODID, "models/armor/wanderer_model.json"));
	}

	private void enqueueIMC(final InterModEnqueueEvent event) {
		// some example code to dispatch IMC to another mod
	}

	private void processIMC(final InterModProcessEvent event) {
		// some example code to receive and process InterModComms from other mods
	}

	// You can use SubscribeEvent and let the Event Bus discover methods to call
	@SubscribeEvent
	public void onServerStarting(FMLServerStartingEvent event) {
		// do something when the server starts
	}

	public static Logger getLogger() {
		return LOGGER;
	}
}
