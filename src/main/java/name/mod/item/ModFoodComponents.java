package name.mod.item;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static FoodComponent CELESTIAL_BERRY = new FoodComponent.Builder().hunger(4).saturationModifier(0.35f).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,600),0.33f).build();
}
