package name.mod.item.custom;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class CloudBurstItem extends Item {
    public CloudBurstItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user.isOnGround()) {
            user.addVelocity(0,10,0);
            world.addParticle(ParticleTypes.CLOUD,user.getX() + 0, user.getY() -0.2, user.getZ() + 0,
                    1, 0, 1);
            world.playSoundFromEntity(null, user, SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.PLAYERS, 1.0f, 1.0f);
            user.getStackInHand(hand).decrement(1);
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING,100,1,false,false));
        }
        return super.use(world, user, hand);
    }
}
