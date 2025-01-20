package name.mod.item.custom;

import name.mod.ModCore;
import name.mod.enchantments.ForceEnchantment;
import name.mod.enchantments.ModEnchantments;
import name.mod.item.ModItems;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import static com.ibm.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static net.minecraft.block.BedBlock.getDirection;

public class AerialiteHammerItem extends AxeItem {

    private boolean inUse;
    private float fallDistance;
    private float forceMult;
    private float radiusMult;
    private int levitationBuff;
    private List<LivingEntity> entityList;

    public AerialiteHammerItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }


    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!entity.isOnGround() && entity instanceof LivingEntity && ((LivingEntity) entity).isHolding(ModItems.AERIALITE_HAMMER)) {
            fallDistance = fallDistance + (float) 1 / 30;
        }
        if(entity.isOnGround() && entity instanceof LivingEntity) {
            fallDistance = 0f;
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (fallDistance > 1 && attacker instanceof PlayerEntity player) {
            forceMult = EnchantmentHelper.getLevel(ModEnchantments.FORCE,stack);
            radiusMult = EnchantmentHelper.getLevel(ModEnchantments.EARTHQUAKE,stack);
            levitationBuff = EnchantmentHelper.getLevel(ModEnchantments.ASCENSION,stack);
            if (EnchantmentHelper.getLevel(ModEnchantments.ASCENSION,stack) == 0) { attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION,10,1 ,false,false)); }
            if (EnchantmentHelper.getLevel(ModEnchantments.ASCENSION,stack) > 0) { attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION,10 * levitationBuff + 1,6 ,false,false));}
            attacker.getWorld().playSoundFromEntity(null, target, SoundEvents.ITEM_TRIDENT_HIT_GROUND, SoundCategory.PLAYERS, 1.0f, 1.0f);
            attacker.getWorld().playSoundFromEntity(null, target, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.PLAYERS, 1.0f, 2.0f);
            ((PlayerEntity) attacker).stopFallFlying();
            List<Entity> list = player.getWorld().getOtherEntities(null, new Box(player.getBlockPos()).expand(3 + EnchantmentHelper.getLevel(ModEnchantments.EARTHQUAKE,stack)).stretch(0.0, (double) player.getWorld().getHeight(), 0.0));
            for (Entity entity : list) {
                if (fallDistance > 1 && !(entity instanceof PlayerEntity)) {
                    if (EnchantmentHelper.getLevel(ModEnchantments.DEATH_FROM_ABOVE,stack) == 0) { entity.addVelocity((getDirection(player.getX(), entity.getX())) * (fallDistance * 0.1), fallDistance * 0.45 * ( (forceMult * 0.4) + 1), (getDirection(player.getZ(), entity.getZ())) * (fallDistance * 0.1)); }
                    if (EnchantmentHelper.getLevel(ModEnchantments.DEATH_FROM_ABOVE,stack) > 0) { entity.damage(entity.getDamageSources().fall(),fallDistance * 1.5f * (((forceMult * 0.1f) + 1))); }
                }
            }
            stack.damage(1, attacker, p -> p.sendToolBreakStatus(attacker.getActiveHand()));
        }
        return super.postHit(stack, target, attacker);
    }
    public double getDirection(double value, double otherValue) {
        if (Math.abs(otherValue - value) == otherValue - value) return 1;
        else return -1;
    }
}
