package drag0n1zed.bismuth;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import javax.tools.Tool;

public class ModToolMaterials {

    // Define the specific TagKey for items that repair Bismuth tools
    public static final TagKey<Item> REPAIRS_WITH_BISMUTH_CRYSTAL = TagKey.of(
            RegistryKeys.ITEM,
            Identifier.of(Bismuth.MOD_ID, "repairs_with_bismuth_crystal") // Tag ID: "bismuth:repairs_with_bismuth_crystal"
    );
    public static final ToolMaterial BISMUTH_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.NEEDS_IRON_TOOL,
            455, // durability
            5.0F, // speed
            1.5F, // attackDamageBonus
            22, // enchantmentValue
            REPAIRS_WITH_BISMUTH_CRYSTAL
    );
}
