package drag0n1zed.bismuth.datagen;

import drag0n1zed.bismuth.block.ModBlocks;
import drag0n1zed.bismuth.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.recipe.Recipe;
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
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);
                offerSmelting(
                        List.of(ModBlocks.BISMUTH_ORE), // Inputs
                        RecipeCategory.FOOD, // Category
                        ModItems.BISMUTH_CRYSTAL, // Output
                        0.1f, // Experience
                        300, // Cooking time
                        "ore_to_crystal" // group
                );
            }
        };
    }

    @Override
    public String getName() {
        return "RecipeProvider";
    }
}
