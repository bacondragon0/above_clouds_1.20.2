package name.mod.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class HermesBootsItem extends ArmorItem {
    public HermesBootsItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }
    private boolean equipped;
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient()) {
            if (entity instanceof PlayerEntity player) {
                if (player.getEquippedStack(EquipmentSlot.FEET).getItem() == this && player.getHealth() >= 20f) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED,
                            65, 0, false, false));
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST,
                            65, 0, false, false));
                    equipped = true;
                }
                if (player.getEquippedStack(EquipmentSlot.FEET).getItem() != this && equipped) {
                   player.removeStatusEffect(StatusEffects.SPEED);
                   player.removeStatusEffect(StatusEffects.JUMP_BOOST);
                   equipped = false;
                }
            }
        }
    }
}
