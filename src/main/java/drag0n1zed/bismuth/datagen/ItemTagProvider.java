package drag0n1zed.bismuth.datagen;

import drag0n1zed.bismuth.item.ModItems;
import drag0n1zed.bismuth.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ItemTagProvider extends FabricTagProvider.ItemTagProvider{
    public ItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        // Bismuth repairs
        getOrCreateTagBuilder(ModTags.REPAIRS_WITH_BISMUTH_CRYSTAL)
                .add(ModItems.BISMUTH_CRYSTAL);

    }
}
