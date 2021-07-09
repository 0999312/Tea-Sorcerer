package cn.mcmod.tea_sorcerer.item.magic;

import java.util.List;

import cn.mcmod.tea_sorcerer.capability.CapabilityRegistry;
import cn.mcmod.tea_sorcerer.capability.ISpiritCapability;
import cn.mcmod.tea_sorcerer.event.EventUseMagic;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.LazyOptional;

public abstract class ItemMagicBase extends Item {
	private int spirit_level;
	private int spirit_amonut;
	private int spirit_timer;
	public ItemMagicBase(Properties p_i48487_1_) {
		super(p_i48487_1_);
	}
	@Override
	public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
		if(worldIn.isClientSide)
			return super.use(worldIn, playerIn, handIn);
		boolean result = MinecraftForge.EVENT_BUS.post(new EventUseMagic(playerIn, 0, 0));
		if(result)
			return super.use(worldIn, playerIn, handIn);
		if(UsingItemByRightClick(worldIn, playerIn, handIn))
			UseSpirit(worldIn, playerIn);
		return super.use(worldIn, playerIn, handIn);
	}
	@Override
	public void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
		tooltip.add(new TranslationTextComponent("tea_sorcerer.spirit_level_request", this.getSpiritLevel()));
		tooltip.add(new TranslationTextComponent("tea_sorcerer.spirit_amonut_request", this.getSpiritAmonut()));
	}
	@Override
	public ActionResultType useOn(ItemUseContext context) {
		World worldIn = context.getLevel();
		PlayerEntity playerIn = context.getPlayer();
		boolean result = MinecraftForge.EVENT_BUS.post(new EventUseMagic(playerIn, getSpiritLevel(), getSpiritAmonut()));
		if(result)
			return super.useOn(context);
		if(worldIn.isClientSide)
			return super.useOn(context);
		if(UsingItemByActiveBlock(context))
			UseSpirit(worldIn, playerIn);
		return super.useOn(context);
	}
	
	public abstract boolean UsingItemByRightClick(World worldIn, PlayerEntity playerIn, Hand handIn);
	public abstract boolean UsingItemByActiveBlock(ItemUseContext context);
	
	protected void UseSpirit(World worldIn, PlayerEntity playerIn) {
		LazyOptional<ISpiritCapability> Cap = playerIn.getCapability(CapabilityRegistry.SPIRIT_CAPABILITY);
        Cap.ifPresent((l) -> {
        		if(l.getSpiritAmount()>=this.getSpiritAmonut())
        			l.setSpiritAmount(l.getSpiritAmount()-this.getSpiritAmonut());
        		else playerIn.hurt(new DamageSource("use_too_much_spirit"), 4F);
        		l.setLastActionTimer(getActionTimer());
        	}
        );
	}
	
	public int getSpiritLevel() {
		return spirit_level;
	}
	public ItemMagicBase setSpiritLevel(int spirit_level) {
		this.spirit_level = spirit_level;
		return this;
	}
	public int getSpiritAmonut() {
		return spirit_amonut;
	}
	public ItemMagicBase setSpiritAmonut(int spirit_amonut) {
		this.spirit_amonut = spirit_amonut;
		return this;
	}
	public int getActionTimer() {
		return spirit_timer;
	}
	public void setActionTimer(int spirit_timer) {
		this.spirit_timer = spirit_timer;
	}
}
