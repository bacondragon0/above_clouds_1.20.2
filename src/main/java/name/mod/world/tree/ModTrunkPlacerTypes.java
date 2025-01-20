package name.mod.world.tree;

import name.mod.ModCore;
import name.mod.mixin.TrunkPlacerTypeInvoker;
import name.mod.world.tree.custom.SkytreeTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class ModTrunkPlacerTypes {
    public static final TrunkPlacerType<?> SKYTREE_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("skytree_trunk_placer", SkytreeTrunkPlacer.CODEC);

    public static void register() {
        ModCore.LOGGER.info("Registering Trunk Placers for " + ModCore.MOD_ID);
    }
}
