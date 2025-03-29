package drag0n1zed.bismuth;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;
public class ModItems {

    public static final Item BISMUTH_INGOT = register("bismuth_ingot", Item::new, new Item.Settings());

    // The mod register!
    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Bismuth.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }
    // Does nothing.
    // When this method is called, the class is statically initialized (if not previously loaded).
    // All static fields will be evaluated with this method.
    public static void initialize() {
    }
}
