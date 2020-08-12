package cn.mcmod.tea_sorcerer.util;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeHooks;

public class WorldUtil {

    public static boolean isItemFuel(ItemStack stack){
        return ForgeHooks.getBurnTime(stack)>0;
    }
    


}
