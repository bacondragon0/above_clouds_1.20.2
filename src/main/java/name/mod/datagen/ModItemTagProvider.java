package name.mod.datagen;

import name.mod.block.ModBlocks;
import name.mod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.AERIALITE_HELMET)
                .add(ModItems.AERIALITE_CHESTPLATE)
                .add(ModItems.AERIALITE_LEGGINGS)
                .add(ModItems.AERIALITE_BOOTS);
        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.SKY_PLANKS.asItem());
        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.SKY_LOG.asItem())
                .add(ModBlocks.SKY_WOOD.asItem())
                .add(ModBlocks.SKY_LOG_STRIPPED.asItem())
                .add(ModBlocks.SKY_WOOD_STRIPPED.asItem());
    }
}
