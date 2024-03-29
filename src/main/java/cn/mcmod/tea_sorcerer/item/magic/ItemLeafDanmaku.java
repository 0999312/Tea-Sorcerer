package cn.mcmod.tea_sorcerer.item.magic;

import cn.mcmod.tea_sorcerer.Main;
import cn.mcmod.tea_sorcerer.effect.EffectRegister;
import cn.mcmod.tea_sorcerer.entity.EntityLeafDanmaku;
import cn.mcmod.tea_sorcerer.item.ItemRegister;
import cn.mcmod_mmf.mmlib.utils.MathUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class ItemLeafDanmaku extends ItemMagicBase {

    public ItemLeafDanmaku() {
        super(new Item.Properties().stacksTo(1).tab(Main.TEA_GROUP));
        this.setSpiritAmonut(50);
        this.setSpiritLevel(1);
        this.setActionTimer(10);
    }

    @Override
    public boolean UsingItemByRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack ammo = findAmmo(playerIn, handIn);
        if(ammo.isEmpty() && !playerIn.abilities.instabuild)
            return false;
        int amount = 1;
        if (playerIn.getEffect(EffectRegister.MAGIC_INCREASE.get()) != null) {
            amount = playerIn.getEffect(EffectRegister.MAGIC_INCREASE.get()).getAmplifier() + 1;
        }
        for (int i = 0; i < 8; i++) {
            EntityLeafDanmaku danmaku = new EntityLeafDanmaku(worldIn, playerIn);
            danmaku.setDamage(amount * 2F);
            danmaku.setMaxTick(50);
            danmaku.shootFromRotation(playerIn, playerIn.xRot, playerIn.yRot + (float) MathUtil.sinValueIn(15F, i), 0, 2F, 5F);
            worldIn.addFreshEntity(danmaku);
        }
        if (!playerIn.abilities.instabuild) {
            ammo.shrink(1);
        }
        worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.SNOWBALL_THROW,
                playerIn.getSoundSource(), 1.0f, 1.0f);
        return true;
    }

    @Override
    public boolean UsingItemByActiveBlock(ItemUseContext context) {
        return false;
    }

    private ItemStack findAmmo(PlayerEntity player, Hand handIn) {
        if (this.isArrow(player.getItemInHand(handIn))) {
            return player.getItemInHand(handIn);
        }  else {
            for (int i = 0; i < player.inventory.getMaxStackSize(); ++i) {
                ItemStack itemstack = player.inventory.getItem(i);
                if (this.isArrow(itemstack)) {
                    return itemstack;
                }
            }

            return ItemStack.EMPTY;
        }
    }

    private boolean isArrow(ItemStack itemstack) {
        return itemstack.getItem() == ItemRegister.tea_knife.get();
    }

}
