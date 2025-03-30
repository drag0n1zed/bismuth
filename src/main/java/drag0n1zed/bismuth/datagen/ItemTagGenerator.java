package drag0n1zed.bismuth.datagen;

import drag0n1zed.bismuth.ModItems;
import drag0n1zed.bismuth.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import java.util.concurrent.CompletableFuture;

public class ItemTagGenerator extends FabricTagProvider.ItemTagProvider{
    public ItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
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
