package drag0n1zed.bismuth;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import java.util.concurrent.CompletableFuture;

public class ModDataGenerator implements DataGeneratorEntrypoint{

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();

        pack.addProvider(TagGenerator::new);
    }

    private static class TagGenerator extends FabricTagProvider.ItemTagProvider {
        public TagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup arg) {
            // This creates a tag builder.
            // This will automatically generate "src/main/generated/data/tutorial/tags/items/repairs_with_bismuth_crystal.json" in the "generated" folder.
            getOrCreateTagBuilder(ModTags.REPAIRS_WITH_BISMUTH_CRYSTAL)
                    .add(ModItems.BISMUTH_CRYSTAL);
        }
    }
}
