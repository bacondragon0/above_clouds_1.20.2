package name.mod.datagen;

import name.mod.block.ModBlocks;
import name.mod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> AERIALITE_SMELTABLES = List.of(
            ModItems.AERIALITE_RAW,
            ModBlocks.AERIALITE_ORE
    );

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, AERIALITE_SMELTABLES, RecipeCategory.MISC, ModItems.AERIALITE_INGOT, 0.8f,180,"aerialite");
        offerBlasting(exporter, AERIALITE_SMELTABLES, RecipeCategory.MISC, ModItems.AERIALITE_INGOT, 0.8f,120,"aerialite");

        //PARACHUTE CRAFT
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.PARACHUTE, 1)
                .pattern("HHH")
                .pattern("S S")
                .pattern(" S ")
                .input('H', ModItems.HARD_CLOUD)
                .input('S', Items.STRING)
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .criterion(hasItem(ModItems.HARD_CLOUD), conditionsFromItem(ModItems.HARD_CLOUD))
                .offerTo(exporter, new Identifier("above_clouds", getRecipeName(ModItems.PARACHUTE)));

        //CLOUD CHARGE CRAFT
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CLOUD_CHARGE, 1)
                .pattern(" H ")
                .pattern("HSH")
                .pattern(" H ")
                .input('H', ModItems.HARD_CLOUD)
                .input('S', ModItems.SUN_EMBLEM)
                .criterion(hasItem(ModItems.SUN_EMBLEM), conditionsFromItem(ModItems.SUN_EMBLEM))
                .criterion(hasItem(ModItems.HARD_CLOUD), conditionsFromItem(ModItems.HARD_CLOUD))
                .offerTo(exporter, new Identifier("above_clouds", getRecipeName(ModItems.CLOUD_CHARGE)));

        //AERIALITE SWORD
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.AERIALITE_SWORD, 1)
                .pattern(" A ")
                .pattern("SAS")
                .pattern(" B ")
                .input('A', ModItems.AERIALITE_INGOT)
                .input('S', ModItems.SUN_EMBLEM)
                .input('B', Items.BLAZE_ROD)
                .criterion(hasItem(ModItems.SUN_EMBLEM), conditionsFromItem(ModItems.SUN_EMBLEM))
                .criterion(hasItem(ModItems.AERIALITE_INGOT), conditionsFromItem(ModItems.AERIALITE_INGOT))
                .criterion(hasItem(Items.BLAZE_ROD), conditionsFromItem(Items.BLAZE_ROD))
                .offerTo(exporter, new Identifier("above_clouds", getRecipeName(ModItems.AERIALITE_SWORD)));

        //AERIALITE PICKAXE
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.AERIALITE_PICKAXE, 1)
                .pattern("ASA")
                .pattern(" B ")
                .pattern(" B ")
                .input('A', ModItems.AERIALITE_INGOT)
                .input('S', ModItems.SUN_EMBLEM)
                .input('B', Items.BLAZE_ROD)
                .criterion(hasItem(ModItems.SUN_EMBLEM), conditionsFromItem(ModItems.SUN_EMBLEM))
                .criterion(hasItem(ModItems.AERIALITE_INGOT), conditionsFromItem(ModItems.AERIALITE_INGOT))
                .criterion(hasItem(Items.BLAZE_ROD), conditionsFromItem(Items.BLAZE_ROD))
                .offerTo(exporter, new Identifier("above_clouds", getRecipeName(ModItems.AERIALITE_PICKAXE)));

        //AERIALITE SHOVEL
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.AERIALITE_SHOVEL, 1)
                .pattern(" A ")
                .pattern(" S ")
                .pattern(" B ")
                .input('A', ModItems.AERIALITE_INGOT)
                .input('S', ModItems.SUN_EMBLEM)
                .input('B', Items.BLAZE_ROD)
                .criterion(hasItem(ModItems.SUN_EMBLEM), conditionsFromItem(ModItems.SUN_EMBLEM))
                .criterion(hasItem(ModItems.AERIALITE_INGOT), conditionsFromItem(ModItems.AERIALITE_INGOT))
                .criterion(hasItem(Items.BLAZE_ROD), conditionsFromItem(Items.BLAZE_ROD))
                .offerTo(exporter, new Identifier("above_clouds", getRecipeName(ModItems.AERIALITE_SHOVEL)));
        //AERIALITE AXE
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.AERIALITE_AXE, 1)
                .pattern("AAS")
                .pattern("AB ")
                .pattern(" B ")
                .input('A', ModItems.AERIALITE_INGOT)
                .input('S', ModItems.SUN_EMBLEM)
                .input('B', Items.BLAZE_ROD)
                .criterion(hasItem(ModItems.SUN_EMBLEM), conditionsFromItem(ModItems.SUN_EMBLEM))
                .criterion(hasItem(ModItems.AERIALITE_INGOT), conditionsFromItem(ModItems.AERIALITE_INGOT))
                .criterion(hasItem(Items.BLAZE_ROD), conditionsFromItem(Items.BLAZE_ROD))
                .offerTo(exporter, new Identifier("above_clouds", getRecipeName(ModItems.AERIALITE_AXE)));
        //AERIALITE HOE
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.AERIALITE_HOE, 1)
                .pattern("AS ")
                .pattern(" B ")
                .pattern(" B ")
                .input('A', ModItems.AERIALITE_INGOT)
                .input('S', ModItems.SUN_EMBLEM)
                .input('B', Items.BLAZE_ROD)
                .criterion(hasItem(ModItems.SUN_EMBLEM), conditionsFromItem(ModItems.SUN_EMBLEM))
                .criterion(hasItem(ModItems.AERIALITE_INGOT), conditionsFromItem(ModItems.AERIALITE_INGOT))
                .criterion(hasItem(Items.BLAZE_ROD), conditionsFromItem(Items.BLAZE_ROD))
                .offerTo(exporter, new Identifier("above_clouds", getRecipeName(ModItems.AERIALITE_HOE)));


        //AERIALITE HAMMER
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.AERIALITE_HAMMER, 1)
                .pattern("ASA")
                .pattern("ABA")
                .pattern(" B ")
                .input('B', Items.BLAZE_ROD)
                .input('A', ModItems.AERIALITE_INGOT)
                .input('S', ModItems.SUN_EMBLEM)
                .criterion(hasItem(ModItems.SUN_EMBLEM), conditionsFromItem(ModItems.SUN_EMBLEM))
                .criterion(hasItem(Items.BLAZE_ROD), conditionsFromItem(Items.BLAZE_ROD))
                .criterion(hasItem(ModItems.AERIALITE_INGOT), conditionsFromItem(ModItems.AERIALITE_INGOT))
                .offerTo(exporter, new Identifier("above_clouds", getRecipeName(ModItems.AERIALITE_HAMMER)));

        //AERIALITE HELMET
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.AERIALITE_HELMET, 1)
                .pattern("AAA")
                .pattern("A A")
                .pattern("   ")
                .input('A', ModItems.AERIALITE_INGOT)
                .criterion(hasItem(ModItems.AERIALITE_INGOT), conditionsFromItem(ModItems.AERIALITE_INGOT))
                .offerTo(exporter, new Identifier("above_clouds", getRecipeName(ModItems.AERIALITE_HELMET)));
        //AERIALITE CHESTPLATE
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.AERIALITE_CHESTPLATE, 1)
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .input('A', ModItems.AERIALITE_INGOT)
                .criterion(hasItem(ModItems.AERIALITE_INGOT), conditionsFromItem(ModItems.AERIALITE_INGOT))
                .offerTo(exporter, new Identifier("above_clouds", getRecipeName(ModItems.AERIALITE_CHESTPLATE)));
        //AERIALITE LEGGINGS
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.AERIALITE_LEGGINGS, 1)
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .input('A', ModItems.AERIALITE_INGOT)
                .criterion(hasItem(ModItems.AERIALITE_INGOT), conditionsFromItem(ModItems.AERIALITE_INGOT))
                .offerTo(exporter, new Identifier("above_clouds", getRecipeName(ModItems.AERIALITE_LEGGINGS)));
        //AERIALITE BOOTS
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.AERIALITE_BOOTS, 1)
                .pattern("   ")
                .pattern("A A")
                .pattern("A A")
                .input('A', ModItems.AERIALITE_INGOT)
                .criterion(hasItem(ModItems.AERIALITE_INGOT), conditionsFromItem(ModItems.AERIALITE_INGOT))
                .offerTo(exporter, new Identifier("above_clouds", getRecipeName(ModItems.AERIALITE_BOOTS)));

        //HERMES BOOTS
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.HERMES_BOOTS, 1)
                .pattern("F F")
                .pattern("S S")
                .pattern("A A")
                .input('A', ModItems.AERIALITE_INGOT)
                .input('S',ModItems.SUN_EMBLEM)
                .input('F',Items.FEATHER)
                .criterion(hasItem(ModItems.AERIALITE_INGOT), conditionsFromItem(ModItems.AERIALITE_INGOT))
                .criterion(hasItem(ModItems.SUN_EMBLEM), conditionsFromItem(ModItems.SUN_EMBLEM))
                .criterion(hasItem(Items.FEATHER), conditionsFromItem(Items.FEATHER))
                .offerTo(exporter, new Identifier("above_clouds", getRecipeName(ModItems.HERMES_BOOTS)));
    }
}
