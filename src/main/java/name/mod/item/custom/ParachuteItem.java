package name.mod.item.custom;

import name.mod.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ParachuteItem extends Item {
    public ParachuteItem(Settings settings) {
        super(settings);
    }
    private int damageToDeal = 0;
    private boolean damageDone;

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!entity.isOnGround() && entity instanceof LivingEntity && ((LivingEntity) entity).isHolding(ModItems.PARACHUTE))  {
            entity.setVelocity(entity.getVelocity().x,entity.getVelocity().y*0.7,entity.getVelocity().z);
            entity.limitFallDistance();
            damageToDeal = damageToDeal + 1;
            damageDone = false;
        }
        if (!entity.isOnGround() && entity instanceof LivingEntity && !((LivingEntity) entity).isHolding(ModItems.PARACHUTE))  {
            if (!damageDone) damageToDeal = damageToDeal + 1;

        }
        if (entity.isOnGround() && entity instanceof LivingEntity)  {
            stack.damage(damageToDeal,((LivingEntity) entity), p -> p.sendToolBreakStatus(((LivingEntity) entity).getActiveHand()));
            damageToDeal = 0;
            damageDone = true;
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
