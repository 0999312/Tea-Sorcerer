package cn.mcmod.tea_sorcerer.item;

import cn.mcmod.tea_sorcerer.Main;
import cn.mcmod.tea_sorcerer.Versions;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Versions.MODID)
public class FlowerTeaSigh extends Item {

    public FlowerTeaSigh() {
        super(new Item.Properties().stacksTo(1).tab(Main.TEA_GROUP));
    }

}
