package drag0n1zed.bismuth.datagen;

import drag0n1zed.bismuth.block.ModBlocks;
import drag0n1zed.bismuth.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class RecipeProvider extends FabricRecipeProvider {

    public RecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new InnerRecipeGenerator(registryLookup, exporter);
    }

    @Override
    public String getName() {
        return "RecipeProvider";
    }

    private static class InnerRecipeGenerator extends RecipeGenerator {
        public InnerRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {super(registryLookup, exporter);}
        @Override
        public void generate() {
            RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);

            List<ItemConvertible> BISMUTH_SMELTABLES = List.of(ModBlocks.BISMUTH_ORE, ModItems.BISMUTH_POWDER);
            offerSmelting(BISMUTH_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH_CRYSTAL, 0.25f, 200, "bismuth");
            offerBlasting(BISMUTH_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH_CRYSTAL, 0.25f, 100, "bismuth");
        }
    }
}
