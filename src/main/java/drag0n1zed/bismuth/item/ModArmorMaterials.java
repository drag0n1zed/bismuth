package drag0n1zed.bismuth.item;

import drag0n1zed.bismuth.Bismuth;
import drag0n1zed.bismuth.ModTags;
import net.minecraft.item.equipment.*;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.Map;

public class ModArmorMaterials {
    public static final int BISMUTH_ARMOR_DURABILITY = 15;
    public static final ArmorMaterial BISMUTH_ARMOR_MATERIAL = new ArmorMaterial(
            15, // Base durability
            Map.of(
                    EquipmentType.HELMET, 3,
                    EquipmentType.CHESTPLATE, 8,
                    EquipmentType.LEGGINGS, 6,
                    EquipmentType.BOOTS, 3,
                    EquipmentType.BODY, 9 // Horse armor
            ),
            5,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            0.0F,
            0.0F,
            ModTags.REPAIRS_WITH_BISMUTH,
            keyOfEquipmentAsset("bismuth")
    );

    private static RegistryKey<EquipmentAsset> keyOfEquipmentAsset(String name) {
        return RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(Bismuth.MOD_ID, name));
    }
}
