package drag0n1zed.bismuth.client.datagen;

import drag0n1zed.bismuth.block.ModBlocks;
import drag0n1zed.bismuth.item.ModItems;
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
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BISMUTH_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BISMUTH_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.BISMUTH_POWDER, Models.GENERATED);

        itemModelGenerator.register(ModItems.BISMUTH_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.BISMUTH_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BISMUTH_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.BISMUTH_BOOTS, Models.GENERATED);

        itemModelGenerator.register(ModItems.BISMUTH_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BISMUTH_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BISMUTH_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BISMUTH_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BISMUTH_HOE, Models.HANDHELD);
    }

}
