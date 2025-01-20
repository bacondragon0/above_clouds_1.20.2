package name.mod.datagen;

import name.mod.block.ModBlocks;
import name.mod.block.custom.CelestialBerryCropBlock;
import name.mod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.predicate.StatePredicate;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.CLOUD_STONE);
        addDrop(ModBlocks.CLOUD_GRASS, drops(ModBlocks.CLOUD_GRASS, Blocks.DIRT));
        addDrop(ModBlocks.AERIALITE_ORE, oreDrops(ModBlocks.AERIALITE_ORE, ModItems.AERIALITE_RAW).apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE)));

        addDrop(ModBlocks.SKY_LOG);
        addDrop(ModBlocks.SKY_LOG_STRIPPED);
        addDrop(ModBlocks.SKY_WOOD);
        addDrop(ModBlocks.SKY_WOOD_STRIPPED);
        addDrop(ModBlocks.SKY_PLANKS);
        addDrop(ModBlocks.SKY_LEAVES, leavesDrops(ModBlocks.SKY_LEAVES, ModBlocks.SKYTREE_SAPLING,0.10f)); //TODO

        BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(ModBlocks.CELESTIAL_BUSH).properties(StatePredicate.Builder.create()
                .exactMatch(CelestialBerryCropBlock.AGE, 2).exactMatch(CelestialBerryCropBlock.AGE, 3));
        addDrop(ModBlocks.CELESTIAL_BUSH, cropDrops(ModBlocks.CELESTIAL_BUSH, ModItems.CELESTIAL_BERRY, ModItems.CELESTIAL_BUSH_SEED, builder));
    }
}
