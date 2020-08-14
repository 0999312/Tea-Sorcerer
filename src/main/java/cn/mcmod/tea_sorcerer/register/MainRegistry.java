package cn.mcmod.tea_sorcerer.register;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public final class MainRegistry {
	public List<Item> ITEMS = Lists.newArrayList();
	public List<Block> BLOCKS = Lists.newArrayList();
	public List<TileEntityType<?>> TILE_ENTITY_TYPES = Lists.newArrayList();
	public List<ContainerType<?>> CONTAINER_TYPES = Lists.newArrayList();
	public List<EntityType<?>> ENTITY_TYPES = Lists.newArrayList();
	public List<Effect> EFFECTS = Lists.newArrayList();
	public List<Feature<?>> FEATURES = Lists.newArrayList();
	public List<SoundEvent> SOUNDS = Lists.newArrayList();

	private static final MainRegistry instance = new MainRegistry();
	
	private MainRegistry() {
	}
	
	public static final MainRegistry getInstance() {
		return instance;
	}

	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(ITEMS.toArray(new Item[0]));
//		JSON_Creator.genLangForItems(ITEMS.toArray(new Item[0]));
	}

	@SubscribeEvent
	public void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(BLOCKS.toArray(new Block[0]));
	}

	@SubscribeEvent
	public void registerTileEntityTypes(RegistryEvent.Register<TileEntityType<?>> event) {
		event.getRegistry().registerAll(TILE_ENTITY_TYPES.toArray(new TileEntityType<?>[0]));
	}

	@SubscribeEvent
	public void registerEntityTypes(RegistryEvent.Register<EntityType<?>> event) {
		event.getRegistry().registerAll(ENTITY_TYPES.toArray(new EntityType<?>[0]));
	}

	@SubscribeEvent
	public void registerEffects(RegistryEvent.Register<Effect> event) {
		event.getRegistry().registerAll(EFFECTS.toArray(new Effect[0]));
	}

	@SubscribeEvent
	public void registerContainerTypes(RegistryEvent.Register<ContainerType<?>> event) {
		event.getRegistry().registerAll(CONTAINER_TYPES.toArray(new ContainerType<?>[0]));
	}

	@SubscribeEvent
	public void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
		event.getRegistry().registerAll(FEATURES.toArray(new Feature<?>[0]));
	}

	@SubscribeEvent
	public void registerSounds(RegistryEvent.Register<SoundEvent> event) {
		event.getRegistry().registerAll(SOUNDS.toArray(new SoundEvent[0]));
	}
	
    public void clearAll() {
        ITEMS = null;
        BLOCKS = null;
        TILE_ENTITY_TYPES = null;
        ENTITY_TYPES = null;
        CONTAINER_TYPES = null;
        EFFECTS = null;
        FEATURES = null;
        SOUNDS = null;
    }
}
