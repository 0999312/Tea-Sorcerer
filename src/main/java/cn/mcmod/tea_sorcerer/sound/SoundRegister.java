package cn.mcmod.tea_sorcerer.sound;

import cn.mcmod.tea_sorcerer.Versions;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundRegister {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS,Versions.MODID);
    public static final RegistryObject<SoundEvent> SPELLCARD = SOUNDS.register("spellcard", () -> new SoundEvent(new ResourceLocation(Versions.MODID, "spellcard")));
	
}
