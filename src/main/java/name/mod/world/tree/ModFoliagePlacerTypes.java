package name.mod.world.tree;

import name.mod.ModCore;
import name.mod.mixin.FoliagePlacerTypeInvoker;
import name.mod.world.tree.custom.SkytreeFoliagePlacer;
import net.fabricmc.fabric.mixin.gamerule.GameRulesAccessor;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class ModFoliagePlacerTypes {
    public static final FoliagePlacerType<?> SKYTREE_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("skytree_foliage_placer", SkytreeFoliagePlacer.CODEC);

    public static void register() {
        ModCore.LOGGER.info("Registering Foliage Placer for " + ModCore.MOD_ID);
    }
}