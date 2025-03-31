package drag0n1zed.bismuth;

import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;


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
            settings -> new PickaxeItem(ModToolMaterials.BISMUTH_TOOL_MATERIAL, 1.0F, -2.8F, settings),
            new Item.Settings()
    );

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

    public static void initialize() {

        Bismuth.LOGGER.info("Initialized Mod Items for {}", Bismuth.MOD_ID);
    }
}