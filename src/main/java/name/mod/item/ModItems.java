package name.mod.item;

import name.mod.ModCore;
import name.mod.block.ModBlocks;
import name.mod.item.custom.AerialiteHammerItem;
import name.mod.item.custom.CloudBurstItem;
import name.mod.item.custom.HermesBootsItem;
import name.mod.item.custom.ParachuteItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModItems {

    public static final Item HARD_CLOUD = registerItem("hard_cloud", new Item(new FabricItemSettings()));
    public static final Item AERIALITE_INGOT = registerItem("aerialite_ingot", new Item(new FabricItemSettings()));
    public static final Item AERIALITE_RAW = registerItem("aerialite_raw", new Item(new FabricItemSettings()));
    public static final Item SUN_EMBLEM = registerItem("sun_emblem", new Item(new FabricItemSettings()));
    public static final Item MOON_EMBLEM = registerItem("moon_emblem", new Item(new FabricItemSettings()));
    public static final Item CELESTIAL_KEY = registerItem("celestial_key", new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON)));

    public static final Item CELESTIAL_BERRY = registerItem("celestial_berry", new Item(new FabricItemSettings().food(ModFoodComponents.CELESTIAL_BERRY)));
    public static final Item CELESTIAL_BUSH_SEED = registerItem("celestial_bush_seed", new AliasedBlockItem(ModBlocks.CELESTIAL_BUSH, new FabricItemSettings()));

    public static final Item AERIALITE_HAMMER = registerItem("aerialite_hammer", new AerialiteHammerItem(ModToolMaterial.AERIALITE_HAMMER,8,-3, new FabricItemSettings().maxCount(1)));

    public static final Item PARACHUTE =registerItem("parachute",new ParachuteItem(new FabricItemSettings().maxCount(1).maxDamage(126)));
    public static final Item CLOUD_CHARGE = registerItem("cloud_charge", new CloudBurstItem(new FabricItemSettings()));

    public static final Item AERIALITE_SWORD = registerItem("aerialite_sword", new SwordItem(ModToolMaterial.AERIALITE,6,-2.4f, new FabricItemSettings().maxCount(1)));
    public static final Item AERIALITE_PICKAXE = registerItem("aerialite_pickaxe", new PickaxeItem(ModToolMaterial.AERIALITE,3,-3, new FabricItemSettings().maxCount(1)));
    public static final Item AERIALITE_SHOVEL = registerItem("aerialite_shovel", new ShovelItem(ModToolMaterial.AERIALITE,2,-3, new FabricItemSettings().maxCount(1)));
    public static final Item AERIALITE_AXE = registerItem("aerialite_axe", new AxeItem(ModToolMaterial.AERIALITE,7,-3, new FabricItemSettings().maxCount(1)));
    public static final Item AERIALITE_HOE = registerItem("aerialite_hoe", new HoeItem(ModToolMaterial.AERIALITE,-2,-2, new FabricItemSettings().maxCount(1)));

    public static final Item AERIALITE_HELMET = registerItem("aerialite_helmet",new ArmorItem(ModArmorMaterials.AERIALITE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item AERIALITE_CHESTPLATE = registerItem("aerialite_chestplate",new ArmorItem(ModArmorMaterials.AERIALITE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item AERIALITE_LEGGINGS = registerItem("aerialite_leggings",new ArmorItem(ModArmorMaterials.AERIALITE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item AERIALITE_BOOTS = registerItem("aerialite_boots",new ArmorItem(ModArmorMaterials.AERIALITE, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item HERMES_BOOTS = registerItem("hermes_boots",new HermesBootsItem(ModArmorMaterials.HERMES, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(ModCore.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ModCore.LOGGER.info("Registering mod items for " +ModCore.MOD_ID);
    }
}
