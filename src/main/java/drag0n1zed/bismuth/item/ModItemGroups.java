package drag0n1zed.bismuth.item;

import drag0n1zed.bismuth.Bismuth;
import drag0n1zed.bismuth.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final RegistryKey<ItemGroup> BISMUTH_ITEM_GROUP_KEY = RegistryKey.of(
            RegistryKeys.ITEM_GROUP,
            Identifier.of(Bismuth.MOD_ID, "item_group_items")
    );
    public static final ItemGroup BISMUTH_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.BISMUTH_CRYSTAL))
            .displayName(Text.translatable("itemGroup.bismuth.items"))
            .build();
    public static final RegistryKey<ItemGroup> BISMUTH_BLOCK_GROUP_KEY = RegistryKey.of(
            RegistryKeys.ITEM_GROUP,
            Identifier.of(Bismuth.MOD_ID, "item_group_blocks")
    );
    public static final ItemGroup BISMUTH_BLOCK_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.BISMUTH_CRYSTAL))
            .displayName(Text.translatable("itemGroup.bismuth.blocks"))
            .build();

    public static void initializeItemGroups() {
        Registry.register(Registries.ITEM_GROUP, BISMUTH_ITEM_GROUP_KEY, BISMUTH_ITEM_GROUP);
        ItemGroupEvents.modifyEntriesEvent(BISMUTH_ITEM_GROUP_KEY).register(entries -> {
            entries.add(ModItems.BISMUTH_CRYSTAL);
            entries.add(ModItems.BISMUTH_POWDER);
            entries.add(ModItems.BISMUTH_SWORD);
            entries.add(ModItems.BISMUTH_SHOVEL);
            entries.add(ModItems.BISMUTH_PICKAXE);
            entries.add(ModItems.BISMUTH_AXE);
            entries.add(ModItems.BISMUTH_HOE);
            entries.add(ModItems.BISMUTH_HELMET);
            entries.add(ModItems.BISMUTH_CHESTPLATE);
            entries.add(ModItems.BISMUTH_LEGGINGS);
            entries.add(ModItems.BISMUTH_BOOTS);
        });
        Registry.register(Registries.ITEM_GROUP, BISMUTH_BLOCK_GROUP_KEY, BISMUTH_BLOCK_GROUP);
        ItemGroupEvents.modifyEntriesEvent(BISMUTH_BLOCK_GROUP_KEY).register(entries -> {
            entries.add(ModBlocks.BISMUTH_ORE.asItem());
        });

        Bismuth.LOGGER.info("Initialized creative mode item groups for {}", Bismuth.MOD_ID);
    }
}
