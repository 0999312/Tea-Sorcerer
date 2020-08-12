package cn.mcmod.tea_sorcerer.register;

import java.lang.reflect.Field;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.gen.feature.Feature;

public class ObjectRegistry {
	
	public ObjectRegistry() {
		try {
			for (Field field : getClass().getFields()) {
				Object o = field.get(this);
				if (o instanceof Item) {
					MainRegistry.getInstance().ITEMS.add((Item) o);
				} else if (o instanceof Block) {
					MainRegistry.getInstance().BLOCKS.add((Block) o);
				} else if (o instanceof TileEntityType<?>) {
					MainRegistry.getInstance().TILE_ENTITY_TYPES.add((TileEntityType<?>) o);
				} else if (o instanceof ContainerType<?>) {
					MainRegistry.getInstance().CONTAINER_TYPES.add((ContainerType<?>) o);
				} else if (o instanceof EntityType<?>) {
					MainRegistry.getInstance().ENTITY_TYPES.add((EntityType<?>) o);
				} else if (o instanceof Effect) {
					MainRegistry.getInstance().EFFECTS.add((Effect) o);
				} else if (o instanceof Feature<?>) {
					MainRegistry.getInstance().FEATURES.add((Feature<?>) o);
				} else if (o instanceof SoundEvent) {
					MainRegistry.getInstance().SOUNDS.add((SoundEvent) o);
				}
			}
		} catch (Exception ignored) {
				
		}
	}
}
