package drag0n1zed.bismuth.client.datagen;

import drag0n1zed.bismuth.ModBlocks;
import drag0n1zed.bismuth.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class ModelProvider extends FabricModelProvider {
    public ModelProvider(FabricDataOutput generator) {
        super(generator);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BISMUTH_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BISMUTH_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.BISMUTH_SWORD, Models.GENERATED);
        itemModelGenerator.register(ModItems.BISMUTH_SHOVEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.BISMUTH_PICKAXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BISMUTH_AXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BISMUTH_HOE, Models.GENERATED);
    }

}
