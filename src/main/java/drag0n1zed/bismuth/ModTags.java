package drag0n1zed.bismuth;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    // Items that repair Bismuth tools
    public static final TagKey<Item> REPAIRS_WITH_BISMUTH_CRYSTAL = TagKey.of(
            RegistryKeys.ITEM,
            Identifier.of(Bismuth.MOD_ID, "repairs_with_bismuth_crystal") // "bismuth:repairs_with_bismuth_crystal"
    );

    private ModTags() {}
}
