package cn.mcmod.tea_sorcerer;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cn.mcmod.tea_sorcerer.block.BlockRegister;
import cn.mcmod.tea_sorcerer.client.particle.ParticleRegister;
import cn.mcmod.tea_sorcerer.compat.CompatHandler;
import cn.mcmod.tea_sorcerer.effect.EffectRegister;
import cn.mcmod.tea_sorcerer.entity.EntityRegister;
import cn.mcmod.tea_sorcerer.item.ItemRegister;
import cn.mcmod.tea_sorcerer.sound.SoundRegister;
import cn.mcmod_mmf.mmlib.utils.ClientUtil;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("tea_sorcerer")
public class Main {
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public static final ItemGroup TEA_GROUP = new ItemGroup("tea_sorcerer") {
        @Override
        public ItemStack makeIcon() {
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
        EntityRegister.ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ParticleRegister.PARTICLE_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        SoundRegister.SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
        
        if(ModList.get().isLoaded("chinese_sword"))
            CompatHandler.INSTANCE.InitChineseSword();
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        ClientUtil.loadModel(new ResourceLocation(Versions.MODID, "models/armor/wanderer_model.json"));
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
    }

    private void processIMC(final InterModProcessEvent event) {
    }

    public static Logger getLogger() {
        return LOGGER;
    }
}
