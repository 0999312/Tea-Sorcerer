package cn.mcmod.tea_sorcerer.item.magic;

import cn.mcmod.tea_sorcerer.Main;
import cn.mcmod.tea_sorcerer.effect.EffectRegister;
import cn.mcmod.tea_sorcerer.entity.DanmakuColor;
import cn.mcmod.tea_sorcerer.entity.DanmakuType;
import cn.mcmod.tea_sorcerer.entity.EntityBasicDanmaku;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class ItemLaserDanmaku extends ItemMagicBase {

	public ItemLaserDanmaku() {
		super(new Item.Properties().stacksTo(1).tab(Main.TEA_GROUP));
		this.setSpiritAmonut(100);
		this.setSpiritLevel(1);
		this.setActionTimer(25);
	}

	@Override
	public boolean UsingItemByRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		int amount = 1;
        if (playerIn.getEffect(EffectRegister.MAGIC_INCREASE.get()) != null){
        	amount = playerIn.getEffect(EffectRegister.MAGIC_INCREASE.get()).getAmplifier() + 1;
        }
		EntityBasicDanmaku danmaku = new EntityBasicDanmaku(worldIn, playerIn);
		danmaku.setDanmakuType(DanmakuType.ORBS).setColor(DanmakuColor.RED);
		danmaku.setDamage(amount * 5F);
		danmaku.setMaxTick(10);
		danmaku.shootFromRotation(playerIn, playerIn.xRot , playerIn.yRot, 0F, 5F, 0F);
		worldIn.addFreshEntity(danmaku);
		worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.SNOWBALL_THROW, playerIn.getSoundSource(), 1.0f, 1.0f);
		return true;
	}

	@Override
	public boolean UsingItemByActiveBlock(ItemUseContext context) {
		return false;
	}

}
