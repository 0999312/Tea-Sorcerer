package cn.mcmod.tea_sorcerer.item.magic;

import cn.mcmod.tea_sorcerer.Main;
import cn.mcmod.tea_sorcerer.effect.EffectRegister;
import cn.mcmod.tea_sorcerer.entity.DanmakuColor;
import cn.mcmod.tea_sorcerer.entity.DanmakuType;
import cn.mcmod.tea_sorcerer.entity.EntityBasicDanmaku;
import cn.mcmod.tea_sorcerer.sound.SoundRegister;
import cn.mcmod_mmf.mmlib.utils.MathUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.Hand;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class ItemSpellCard extends ItemMagicBase {

    public ItemSpellCard() {
        super(new Item.Properties().stacksTo(1).tab(Main.TEA_GROUP));
        this.setSpiritAmonut(500);
        this.setSpiritLevel(1);
        this.setActionTimer(50);
    }

    @Override
    public boolean UsingItemByRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        int amount = 1;
        if (playerIn.getEffect(EffectRegister.MAGIC_INCREASE.get()) != null) {
            amount = playerIn.getEffect(EffectRegister.MAGIC_INCREASE.get()).getAmplifier() + 1;
        }
        for (int i = 0; i < 75; i++) {
            EntityBasicDanmaku danmaku = new EntityBasicDanmaku(worldIn, playerIn);
            danmaku.setDanmakuType(DanmakuType.ORBS).setColor(DanmakuColor.RED);
            danmaku.setDamage(amount * 5F);
            danmaku.setMaxTick(50);
            danmaku.shootFromRotation(playerIn, playerIn.xRot, playerIn.yRot + (float) MathUtil.sinValueIn(360F, i), 0,
                    2F, 5F);
            worldIn.addFreshEntity(danmaku);
        }
        playerIn.sendMessage(new TranslationTextComponent(getDescriptionId()), playerIn.getUUID());
//        playerIn.playSound(, 1.0f, 0.8f);
        worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundRegister.SPELLCARD.get(),
                playerIn.getSoundSource(), 1.0f, 1.0f);
        return true;
    }

    @Override
    public boolean UsingItemByActiveBlock(ItemUseContext context) {
        return false;
    }

}
