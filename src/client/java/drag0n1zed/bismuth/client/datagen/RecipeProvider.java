package drag0n1zed.bismuth.client.datagen;

import drag0n1zed.bismuth.block.ModBlocks;
import drag0n1zed.bismuth.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
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
        return new InnerRecipeGenerator(registryLookup, exporter);
    }

    @Override
    public String getName() {
        return "RecipeProvider";
    }

    private static class InnerRecipeGenerator extends RecipeGenerator {
        public InnerRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
            super(registryLookup, exporter);
        }

        @Override
        public void generate() {
            RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);
            List<ItemConvertible> BISMUTH_SMELTABLES = List.of(ModBlocks.BISMUTH_ORE, ModItems.BISMUTH_POWDER);
            offerSmelting(BISMUTH_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH_CRYSTAL, 0.25f, 200, "bismuth");
            offerBlasting(BISMUTH_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH_CRYSTAL, 0.3f, 100, "bismuth");
            createShapeless(RecipeCategory.MISC, ModItems.BISMUTH_CRYSTAL, 4)
                    .input(ModBlocks.BISMUTH_BLOCK)
                    .criterion(hasItem(ModBlocks.BISMUTH_BLOCK), conditionsFromItem(ModBlocks.BISMUTH_BLOCK))
                    .offerTo(exporter);
            createShaped(RecipeCategory.MISC, ModBlocks.BISMUTH_BLOCK)
                    .pattern("CCC")
                    .pattern("CCC")
                    .pattern("CCC")
                    .input('C', ModItems.BISMUTH_CRYSTAL)
                    .criterion(hasItem(ModItems.BISMUTH_CRYSTAL), conditionsFromItem(ModItems.BISMUTH_CRYSTAL))
                    .offerTo(exporter);
            createShaped(RecipeCategory.MISC, ModItems.BISMUTH_HELMET)
                    .pattern("CCC")
                    .pattern("C C")
                    .input('C', ModItems.BISMUTH_CRYSTAL)
                    .criterion(hasItem(ModItems.BISMUTH_CRYSTAL), conditionsFromItem(ModItems.BISMUTH_CRYSTAL))
                    .offerTo(exporter);
            createShaped(RecipeCategory.MISC, ModItems.BISMUTH_CHESTPLATE)
                    .pattern("C C")
                    .pattern("CCC")
                    .pattern("CCC")
                    .input('C', ModItems.BISMUTH_CRYSTAL)
                    .criterion(hasItem(ModItems.BISMUTH_CRYSTAL), conditionsFromItem(ModItems.BISMUTH_CRYSTAL))
                    .offerTo(exporter);
            createShaped(RecipeCategory.MISC, ModItems.BISMUTH_LEGGINGS)
                    .pattern("CCC")
                    .pattern("C C")
                    .pattern("C C")
                    .input('C', ModItems.BISMUTH_CRYSTAL)
                    .criterion(hasItem(ModItems.BISMUTH_CRYSTAL), conditionsFromItem(ModItems.BISMUTH_CRYSTAL))
                    .offerTo(exporter);
            createShaped(RecipeCategory.MISC, ModItems.BISMUTH_BOOTS)
                    .pattern("C C")
                    .pattern("C C")
                    .input('C', ModItems.BISMUTH_CRYSTAL)
                    .criterion(hasItem(ModItems.BISMUTH_CRYSTAL), conditionsFromItem(ModItems.BISMUTH_CRYSTAL))
                    .offerTo(exporter);
            createShaped(RecipeCategory.MISC, ModItems.BISMUTH_SWORD)
                    .pattern("C")
                    .pattern("C")
                    .pattern("S")
                    .input('C', ModItems.BISMUTH_CRYSTAL)
                    .input('S', Items.STICK)
                    .criterion(hasItem(ModItems.BISMUTH_CRYSTAL), conditionsFromItem(ModItems.BISMUTH_CRYSTAL))
                    .offerTo(exporter);
            createShaped(RecipeCategory.MISC, ModItems.BISMUTH_SHOVEL)
                    .pattern("C")
                    .pattern("S")
                    .pattern("S")
                    .input('C', ModItems.BISMUTH_CRYSTAL)
                    .input('S', Items.STICK)
                    .criterion(hasItem(ModItems.BISMUTH_CRYSTAL), conditionsFromItem(ModItems.BISMUTH_CRYSTAL))
                    .offerTo(exporter);
            createShaped(RecipeCategory.MISC, ModItems.BISMUTH_PICKAXE)
                    .pattern("CCC")
                    .pattern(" S ")
                    .pattern(" S ")
                    .input('C', ModItems.BISMUTH_CRYSTAL)
                    .input('S', Items.STICK)
                    .criterion(hasItem(ModItems.BISMUTH_CRYSTAL), conditionsFromItem(ModItems.BISMUTH_CRYSTAL))
                    .offerTo(exporter);
            createShaped(RecipeCategory.MISC, ModItems.BISMUTH_AXE)
                    .pattern("CC")
                    .pattern("CS")
                    .pattern(" S")
                    .input('C', ModItems.BISMUTH_CRYSTAL)
                    .input('S', Items.STICK)
                    .criterion(hasItem(ModItems.BISMUTH_CRYSTAL), conditionsFromItem(ModItems.BISMUTH_CRYSTAL))
                    .offerTo(exporter);
            createShaped(RecipeCategory.MISC, ModItems.BISMUTH_HOE)
                    .pattern("CC")
                    .pattern(" S")
                    .pattern(" S")
                    .input('C', ModItems.BISMUTH_CRYSTAL)
                    .input('S', Items.STICK)
                    .criterion(hasItem(ModItems.BISMUTH_CRYSTAL), conditionsFromItem(ModItems.BISMUTH_CRYSTAL))
                    .offerTo(exporter);
        }
    }
}

