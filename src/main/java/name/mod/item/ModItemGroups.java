package name.mod.item;

import com.sun.jna.platform.win32.Mpr;
import name.mod.ModClient;
import name.mod.ModCore;
import name.mod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup MAIN_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(ModCore.MOD_ID,"cloud"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.cloud")).icon(() -> new ItemStack(ModItems.HARD_CLOUD))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.CELESTIAL_BUSH_SEED);
                        entries.add(ModItems.CELESTIAL_BERRY);
                        entries.add(ModItems.HARD_CLOUD);
                        entries.add(ModItems.SUN_EMBLEM);
                        entries.add(ModItems.MOON_EMBLEM);
                        entries.add(ModItems.PARACHUTE);
                        entries.add(ModItems.CLOUD_CHARGE);
                        entries.add(ModItems.AERIALITE_RAW);
                        entries.add(ModItems.AERIALITE_INGOT);
                        entries.add(ModItems.AERIALITE_HAMMER);
                        entries.add(ModItems.AERIALITE_SWORD);
                        entries.add(ModItems.AERIALITE_PICKAXE);
                        entries.add(ModItems.AERIALITE_AXE);
                        entries.add(ModItems.AERIALITE_SHOVEL);
                        entries.add(ModItems.AERIALITE_HOE);
                        entries.add(ModItems.AERIALITE_HELMET);
                        entries.add(ModItems.AERIALITE_CHESTPLATE);
                        entries.add(ModItems.AERIALITE_LEGGINGS);
                        entries.add(ModItems.AERIALITE_BOOTS);
                        entries.add(ModItems.HERMES_BOOTS);
                        entries.add(ModBlocks.CLOUD_BLOCK);
                        entries.add(ModBlocks.CLOUD_GRASS);
                        entries.add(ModBlocks.CLOUD_STONE);
                        entries.add(ModBlocks.AERIALITE_ORE);
                        entries.add(ModBlocks.SKYTREE_SAPLING);
                        entries.add(ModBlocks.SKY_LOG);
                        entries.add(ModBlocks.SKY_LOG_STRIPPED);
                        entries.add(ModBlocks.SKY_WOOD);
                        entries.add(ModBlocks.SKY_WOOD_STRIPPED);
                        entries.add(ModBlocks.SKY_PLANKS);
                        entries.add(ModBlocks.SKY_LEAVES);
                        entries.add(ModItems.CELESTIAL_KEY);
                        entries.add(ModBlocks.CELESTIAL_VAULT);

                    }).build());



    public static void registerItemGroups() {
        ModCore.LOGGER.info("Registering item groups for " + ModCore.MOD_ID);
    }
}
