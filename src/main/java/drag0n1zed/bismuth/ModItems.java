package drag0n1zed.bismuth;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Function;

import static drag0n1zed.bismuth.ModToolMaterials.BISMUTH_TOOL_MATERIAL;

public class ModItems {


    // --- Items ---
    // 物品
    public static final Item BISMUTH_CRYSTAL = registerItem(
            "bismuth_crystal",
            new Item.Settings()
            // Add any specific settings for this item here, e.g., .maxCount(16)
    );

    public static final Item BISMUTH_PICKAXE = register(
            "bismuth_pickaxe",
            settings -> new PickaxeItem(BISMUTH_TOOL_MATERIAL, 1f, 1f, settings),
            new Item.Settings()
    );

    // --- Item Group ---
    // 创造模式物品栏
    public static final RegistryKey<ItemGroup> BISMUTH_GROUP_KEY = RegistryKey.of(
            RegistryKeys.ITEM_GROUP,
            Identifier.of(Bismuth.MOD_ID, "item_group")
    );
    public static final ItemGroup BISMUTH_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.BISMUTH_CRYSTAL))
            .displayName(Text.translatable("itemGroup.bismuth"))
            .build();

    // --- Registration Helper Methods ---

    // For Vanilla item classes
    private static Item registerItem(String name, Item.Settings settings) {
        return register(name, Item::new, settings);
    }

    // Generic item registration
    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Bismuth.MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        return Registry.register(Registries.ITEM, itemKey.getValue(), item);
    }

    // --- Initialization ---
    public static void initialize() {
        // Register the ItemGroup
        // 注册物品组
        Registry.register(Registries.ITEM_GROUP, BISMUTH_GROUP_KEY, BISMUTH_GROUP);
        ItemGroupEvents.modifyEntriesEvent(BISMUTH_GROUP_KEY).register(content -> {
            content.add(BISMUTH_CRYSTAL);
            content.add(BISMUTH_PICKAXE);
        });

        Bismuth.LOGGER.info("Initialized Mod Items for {}", Bismuth.MOD_ID);
    }
}