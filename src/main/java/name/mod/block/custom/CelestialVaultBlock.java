package name.mod.block.custom;

import name.mod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RespawnAnchorBlock;
import net.minecraft.data.Main;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.block.BlockState;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.Objects;
import java.util.concurrent.locks.Lock;

public class CelestialVaultBlock extends Block {
    public static final BooleanProperty LOCKED = Properties.LOCKED;


    public CelestialVaultBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState) this.stateManager.getDefaultState().with(LOCKED, true));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LOCKED);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (hand == Hand.MAIN_HAND && !CelestialVaultBlock.isKeyItem(itemStack) && CelestialVaultBlock.isKeyItem(player.getStackInHand(Hand.OFF_HAND))) {
            return ActionResult.PASS;
        }
        if (CelestialVaultBlock.isKeyItem(itemStack) && state.get(LOCKED)) {
            if (!player.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }
            world.setBlockState(pos,state.with(LOCKED, false));
            world.spawnEntity(new ItemEntity(world, pos.getX() + 0.5f,pos.getY() + 1.1f, pos.getZ() + 0.5f, ModItems.MOON_EMBLEM.getDefaultStack()));
            world.playSoundFromEntity(null, player, SoundEvents.BLOCK_IRON_TRAPDOOR_OPEN, SoundCategory.PLAYERS, 1.0f, 1.0f);
            world.addParticle(ParticleTypes.END_ROD, pos.getX()+ 0.5f, pos.getY() + 1.1, pos.getZ()+ 0.5f,
                    0, 0.01, 0);
            for (int i = 0; i < 3; i++) {
                world.addParticle(ParticleTypes.END_ROD, pos.getX()+ 0.5f, pos.getY() + 1.1, pos.getZ()+ 0.5f,
                        (Math.random()/10) * 1, Math.random()/5, (Math.random()/10) * 1);
                world.addParticle(ParticleTypes.END_ROD, pos.getX()+ 0.5f, pos.getY() + 1.1, pos.getZ()+ 0.5f,
                        (Math.random()/10) * -1, Math.random()/5, (Math.random()/10) * -1);
            }
            return ActionResult.success(world.isClient);
        }
        return ActionResult.success(world.isClient);
    }
    private static boolean isKeyItem(ItemStack stack) {
        return stack.isOf(ModItems.CELESTIAL_KEY);
    }
}
