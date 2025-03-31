package drag0n1zed.bismuth;

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

    public static void initialize(){
        Registry.register(Registries.ITEM_GROUP, BISMUTH_GROUP_KEY, BISMUTH_GROUP);
        // Custom Item Group
        ItemGroupEvents.modifyEntriesEvent(BISMUTH_GROUP_KEY).register(content -> {
            content.add(ModItems.BISMUTH_CRYSTAL);
            content.add(ModItems.BISMUTH_PICKAXE);
        });

        // Vanilla Item Groups
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
                    content.addAfter(Items.NETHERITE_HOE,ModItems.BISMUTH_PICKAXE);
                }
        );
        Bismuth.LOGGER.info("Initialized Creative Mode Item Groups for {}", Bismuth.MOD_ID);
    }
}
