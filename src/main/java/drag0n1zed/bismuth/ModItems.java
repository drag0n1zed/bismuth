package drag0n1zed.bismuth;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;
public class ModItems {

    public static final Item BISMUTH_CRYSTAL = register("bismuth_crystal", Item::new, new Item.Settings());

    // Item register!
    // 物品注册台!
    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Bismuth.MOD_ID, name));

        Item item = itemFactory.apply(settings.registryKey(itemKey));

        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }
    // When this method is called, the class is statically initialized (if not previously loaded).
    // All static fields will be evaluated with this method.
    // 第一次被引用时会静态初始化这个class
    // 里面所有的static开头的都会被初始化
    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.add(ModItems.BISMUTH_CRYSTAL));
    }
}
