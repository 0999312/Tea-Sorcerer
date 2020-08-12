package cn.mcmod.tea_sorcerer.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;

public class RecipesUtil {
    public static CompoundNBT getItemTagCompound(ItemStack stack) {
        return stack.getOrCreateTag();
    }
    
	private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
	private static File RECIPE_DIR = null;
    
	private static void setupDir() {
		if (RECIPE_DIR == null) {
			RECIPE_DIR = new File("json_create" + "\\recipes\\");
		}

		if (!RECIPE_DIR.exists()) {
			RECIPE_DIR.mkdir();
		}
		
	}
	
	public static void addShapedRecipe(ItemStack result, Object... components) {
		setupDir();

		Map<String, Object> json = new HashMap<>();

		List<String> pattern = new ArrayList<>();
		int i = 0;
		while (i < components.length && components[i] instanceof String) {
			pattern.add((String) components[i]);
			i++;
		}
		json.put("pattern", pattern);
		Map<String, Map<String, Object>> key = new HashMap<>();
		Character curKey = null;
		for (; i < components.length; i++) {
			Object o = components[i];
			if (o instanceof Character) {
				if (curKey != null)
					throw new IllegalArgumentException("Provided two char keys in a row");
				curKey = (Character) o;
			} else {
				if (curKey == null)
					throw new IllegalArgumentException("Providing object without a char key");
				key.put(Character.toString(curKey), serializeItem(o));
				curKey = null;
			}
		}
		json.put("key", key);
		json.put("type", "minecraft:crafting_shaped");
		json.put("result", serializeItem(result));

		// names the json the same name as the output's registry name
		// repeatedly adds _alt if a file already exists
		// janky I know but it works
		File f = new File(RECIPE_DIR, result.getItem().getRegistryName().getPath() + ".json");
		String suffix = "";
		while (f.exists()) {
			suffix += "_alt";
			f = new File(RECIPE_DIR, result.getItem().getRegistryName().getPath() + suffix + ".json");
		}

		try (FileWriter w = new FileWriter(f)) {
			GSON.toJson(json, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void addShapelessRecipe(ItemStack result, Object... components) {
		setupDir();

		Map<String, Object> json = new HashMap<>();

		List<Map<String, Object>> ingredients = new ArrayList<>();
		for (Object o : components) {
			ingredients.add(serializeItem(o));
		}
		json.put("ingredients", ingredients);
		json.put("type", "minecraft:crafting_shapeless");
		json.put("result", serializeItem(result));

		File f = new File(RECIPE_DIR, result.getItem().getRegistryName().getPath() + ".json");
		String suffix = "";
		while (f.exists()) {
			suffix += "_alt";
			f = new File(RECIPE_DIR, result.getItem().getRegistryName().getPath() + suffix + ".json");
		}

		try (FileWriter w = new FileWriter(f)) {
			GSON.toJson(json, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void addSmeltingRecipe(ItemStack result, Object item,float exp) {
		setupDir();

		Map<String, Object> json = new HashMap<>();
		
		json.put("ingredient", serializeItem(item));
		json.put("type", "minecraft:smelting");
		json.put("result", serializeItem(result));
		json.put("experience", exp);

		String suffix = "_smelting";
		File f = new File(RECIPE_DIR, result.getItem().getRegistryName().getPath() + suffix + ".json");
		while (f.exists()) {
			suffix += "_alt";
			f = new File(RECIPE_DIR, result.getItem().getRegistryName().getPath() + suffix + ".json");
		}

		try (FileWriter w = new FileWriter(f)) {
			GSON.toJson(json, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void addSmokerRecipe(ItemStack result, Object item,float exp) {
		setupDir();

		Map<String, Object> json = new HashMap<>();
		
		json.put("ingredient", serializeItem(item));
		json.put("type", "minecraft:smoking");
		json.put("result", serializeItem(result));
		json.put("experience", exp);

		String suffix = "_smoking";
		File f = new File(RECIPE_DIR, result.getItem().getRegistryName().getPath() + suffix + ".json");
		while (f.exists()) {
			suffix += "_alt";
			f = new File(RECIPE_DIR, result.getItem().getRegistryName().getPath() + suffix + ".json");
		}

		try (FileWriter w = new FileWriter(f)) {
			GSON.toJson(json, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void addCampfireCookingRecipe(ItemStack result, Object item,float exp) {
		setupDir();

		Map<String, Object> json = new HashMap<>();
		
		json.put("ingredient", serializeItem(item));
		json.put("type", "minecraft:campfire_cooking");
		json.put("result", serializeItem(result));
		json.put("experience", exp);

		String suffix = "_campfire";
		File f = new File(RECIPE_DIR, result.getItem().getRegistryName().getPath() + suffix + ".json");
		while (f.exists()) {
			suffix += "_alt";
			f = new File(RECIPE_DIR, result.getItem().getRegistryName().getPath() + suffix + ".json");
		}

		try (FileWriter w = new FileWriter(f)) {
			GSON.toJson(json, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void addBlastingRecipe(ItemStack result, Object item,float exp) {
		setupDir();

		Map<String, Object> json = new HashMap<>();
		
		json.put("ingredient", serializeItem(item));
		json.put("type", "minecraft:blasting");
		json.put("result", serializeItem(result));
		json.put("experience", exp);
		
		String suffix = "_blasting";
		File f = new File(RECIPE_DIR, result.getItem().getRegistryName().getPath() + suffix + ".json");
		while (f.exists()) {
			suffix += "_alt";
			f = new File(RECIPE_DIR, result.getItem().getRegistryName().getPath() + suffix + ".json");
		}

		try (FileWriter w = new FileWriter(f)) {
			GSON.toJson(json, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void addFoodSmelting(boolean campfire,ItemStack result, Object item,float exp) {
		addSmeltingRecipe(result, item, exp);
		addSmokerRecipe(result, item, exp);
		if(campfire)
			addCampfireCookingRecipe(result, item, exp);
	}
	
	public static void addOreSmelting(ItemStack result, Object item,float exp) {
		addSmeltingRecipe(result, item, exp);
		addBlastingRecipe(result, item, exp);
	}

	private static Map<String, Object> serializeItem(Object thing) {
		if (thing instanceof Item) {
			return serializeItem(new ItemStack((Item) thing));
		}
		if (thing instanceof Block) {
			return serializeItem(new ItemStack((Block) thing));
		}
		if (thing instanceof ItemStack) {
			ItemStack stack = (ItemStack) thing;
			Map<String, Object> ret = new HashMap<>();
			ret.put("item", stack.getItem().getRegistryName().toString());

			if (stack.getCount() > 1) {
				ret.put("count", stack.getCount());
			}

			if (stack.hasTag()) {
				ret.put("type", "minecraft:item_nbt");
				ret.put("nbt", stack.getTag().toString());
			}

			return ret;
		}
		if (thing instanceof String) {
			Map<String, Object> ret = new HashMap<>();
			ret.put("tag", "forge:" + thing);
			return ret;
		}

		throw new IllegalArgumentException("Not a block, item, item stack, or tag");
	}

}
