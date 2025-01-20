package name.mod.enchantments;

import name.mod.ModCore;
import net.fabricmc.api.ModInitializer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantments {
    public static Enchantment FORCE = new ForceEnchantment();
    public static Enchantment EARTHQUAKE = new EarthquakeEnchantment();
    public static Enchantment ASCENSION = new AscensionEnchantment();
    public static Enchantment DEATH_FROM_ABOVE = new DeathfromAboveEnchantment();

    public static void registerModEnchantments() {
        Registry.register(Registries.ENCHANTMENT, new Identifier("above_clouds", "force"), FORCE);
        Registry.register(Registries.ENCHANTMENT, new Identifier("above_clouds", "earthshatter"), EARTHQUAKE);
        Registry.register(Registries.ENCHANTMENT, new Identifier("above_clouds", "ascension"), ASCENSION);
        Registry.register(Registries.ENCHANTMENT, new Identifier("above_clouds", "death_from_above"), DEATH_FROM_ABOVE);
        System.out.println("Registering Enchantments for " + ModCore.MOD_ID);
    }
}
