package cn.mcmod.tea_sorcerer.compat;

import cn.mcmod.tea_sorcerer.compat.chinese_sword.ChineseSwordRegistry;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public enum CompatHandler {
    INSTANCE;
    
    public void InitChineseSword() {
        ChineseSwordRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
