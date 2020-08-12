package cn.mcmod.tea_sorcerer.event;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.eventbus.api.Cancelable;
import net.minecraftforge.eventbus.api.Event;

@Cancelable
public class EventUseMagic extends Event {
	public final int spirit_level;
	public final int spirit_amonut;
	public final PlayerEntity player;
	public EventUseMagic(PlayerEntity player,int level,int amonut) {
		this.player=player;
		this.spirit_level=level;
		this.spirit_amonut=amonut;
	}
}
