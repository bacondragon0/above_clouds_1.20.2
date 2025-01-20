package name.mod;

import name.mod.block.ModBlocks;
import name.mod.enchantments.ModEnchantments;
import name.mod.item.ModItemGroups;
import name.mod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModCore implements ModInitializer {
	public static final String MOD_ID = "above_clouds";
    public static final Logger LOGGER = LoggerFactory.getLogger("mod-logger");

	@Override
	public void onInitialize() {
		LOGGER.info("Hello World");

		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
		ModEnchantments.registerModEnchantments();

		StrippableBlockRegistry.register(ModBlocks.SKY_LOG, ModBlocks.SKY_LOG_STRIPPED);
		StrippableBlockRegistry.register(ModBlocks.SKY_WOOD, ModBlocks.SKY_WOOD_STRIPPED);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SKY_LOG,5,5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SKY_LOG_STRIPPED,5,5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SKY_WOOD,5,5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SKY_WOOD_STRIPPED,5,5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SKY_PLANKS,5,20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SKY_LEAVES,30,5);
	}
}