package name.mod.block;

import name.mod.ModCore;
import name.mod.block.custom.CelestialBerryCropBlock;
import name.mod.block.custom.CelestialVaultBlock;
import name.mod.world.tree.custom.SkytreeSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class ModBlocks {

    public static final Block CLOUD_BLOCK = registerBlock("cloud_block",
            new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));

    public static final Block CLOUD_STONE = registerBlock("cloud_stone",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE)));

    public static final Block AERIALITE_ORE = registerBlock("aerialite_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE)));

    public static final Block CLOUD_GRASS = registerBlock("cloud_grass",
            new Block(FabricBlockSettings.copyOf(Blocks.GRASS_BLOCK)));

    public static final Block SKYTREE_SAPLING = registerBlock("skytree_sapling",
            new SaplingBlock(new SkytreeSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)){
                @Override
                protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
                    return floor.isOf(ModBlocks.CLOUD_GRASS);
                }
            });

    public static final Block SKY_LOG = registerBlock("sky_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(4)));
    public static final Block SKY_WOOD = registerBlock("sky_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(4)));
    public static final Block SKY_LOG_STRIPPED = registerBlock("sky_log_stripped",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).strength(4)));
    public static final Block SKY_WOOD_STRIPPED = registerBlock("sky_wood_stripped",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).strength(4)));

    public static final Block SKY_PLANKS = registerBlock("sky_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4)));
    public static final Block SKY_LEAVES = registerBlock("sky_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).strength(4).nonOpaque()));

    public static final Block CELESTIAL_VAULT = registerBlock("celestial_vault",
            new CelestialVaultBlock(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK).dropsNothing().strength(1,10).strength(10)));

    public static final Block CELESTIAL_BUSH = registerBlock("celestial_bush", new CelestialBerryCropBlock(FabricBlockSettings.copyOf(Blocks.SWEET_BERRY_BUSH)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(ModCore.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(ModCore.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        ModCore.LOGGER.info("Registering mod blocks for"+ModCore.MOD_ID);

    }
}
