package drag0n1zed.bismuth.item;

import drag0n1zed.bismuth.Bismuth;
import drag0n1zed.bismuth.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final RegistryKey<ItemGroup> BISMUTH_GROUP_KEY = RegistryKey.of(
            RegistryKeys.ITEM_GROUP,
            Identifier.of(Bismuth.MOD_ID, "item_group")
    );
    public static final ItemGroup BISMUTH_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.BISMUTH_CRYSTAL))
            .displayName(Text.translatable("itemGroup.bismuth"))
            .build();

    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, BISMUTH_GROUP_KEY, BISMUTH_GROUP);
        // Custom Item Group
        ItemGroupEvents.modifyEntriesEvent(BISMUTH_GROUP_KEY).register(content -> {
            content.add(ModItems.BISMUTH_CRYSTAL);
            content.add(ModItems.BISMUTH_POWDER);
            content.add(ModItems.BISMUTH_SWORD);
            content.add(ModItems.BISMUTH_SHOVEL);
            content.add(ModItems.BISMUTH_PICKAXE);
            content.add(ModItems.BISMUTH_AXE);
            content.add(ModItems.BISMUTH_HOE);
            content.add(ModBlocks.BISMUTH_ORE.asItem());
        });

        // Vanilla Item Groups
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
                    content.addAfter(Items.NETHERITE_HOE, ModItems.BISMUTH_SHOVEL);
                    content.addAfter(ModItems.BISMUTH_SHOVEL, ModItems.BISMUTH_PICKAXE);
                    content.addAfter(ModItems.BISMUTH_PICKAXE, ModItems.BISMUTH_AXE);
                    content.addAfter(ModItems.BISMUTH_AXE, ModItems.BISMUTH_HOE);
                }
        );
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
                    content.addAfter(Items.NETHERITE_SWORD, ModItems.BISMUTH_SWORD);
                }
        );
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
                    content.addAfter(Items.DIAMOND, ModItems.BISMUTH_CRYSTAL);
                }
        );
        Bismuth.LOGGER.info("Initialized creative mode item groups for {}", Bismuth.MOD_ID);
    }
}
