package name.mod.item;

import name.mod.ModCore;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    // Aerialite Armor
    AERIALITE("aerialite_armor",25,new int[] {2,7,5,2},19, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 1,0.1f, () -> Ingredient.ofItems(ModItems.AERIALITE_INGOT)),
    HERMES("hermes_armor",15,new int[] {2,7,5,1},19, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 0.5f,0.1f, () -> Ingredient.ofItems(ModItems.SUN_EMBLEM)),
    ;
    private final String name;
    private final Integer durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float thougness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] baseDurability = {11, 60, 15, 13};

    ModArmorMaterials(String name, Integer durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float thougness, float knockbackResistance, Supplier<Ingredient> repaierIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.thougness = thougness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repaierIngredient;
    }

    @Override
    public int getDurability(ArmorItem.Type type) {
        return baseDurability[type.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return ModCore.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.thougness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
