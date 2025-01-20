package name.mod.datagen;

import name.mod.block.ModBlocks;
import name.mod.block.custom.CelestialBerryCropBlock;
import name.mod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CLOUD_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CLOUD_STONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.AERIALITE_ORE);
        blockStateModelGenerator.registerLog(ModBlocks.SKY_LOG).log(ModBlocks.SKY_LOG).wood(ModBlocks.SKY_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.SKY_LOG_STRIPPED).log(ModBlocks.SKY_LOG_STRIPPED).wood(ModBlocks.SKY_WOOD_STRIPPED);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SKY_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SKY_PLANKS);
        blockStateModelGenerator.registerTintableCross(ModBlocks.SKYTREE_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
    }
    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.HARD_CLOUD, Models.GENERATED);
        itemModelGenerator.register(ModItems.AERIALITE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.AERIALITE_RAW, Models.GENERATED);
        itemModelGenerator.register(ModItems.SUN_EMBLEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.MOON_EMBLEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.PARACHUTE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLOUD_CHARGE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CELESTIAL_KEY, Models.GENERATED);
        itemModelGenerator.register(ModItems.CELESTIAL_BERRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.CELESTIAL_BUSH_SEED, Models.GENERATED);

        itemModelGenerator.register(ModItems.AERIALITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AERIALITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AERIALITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AERIALITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AERIALITE_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.AERIALITE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.AERIALITE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.AERIALITE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.AERIALITE_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.HERMES_BOOTS));

        itemModelGenerator.register(ModItems.AERIALITE_HAMMER, Models.HANDHELD);
    }
}
