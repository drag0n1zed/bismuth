package drag0n1zed.bismuth.item;

import drag0n1zed.bismuth.ModTags;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;

public class ModToolMaterials {

    public static final ToolMaterial BISMUTH_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_IRON_TOOL,
            455, // durability
            5.0F, // speed
            1.5F, // attackDamageBonus
            22, // enchantmentValue
            ModTags.REPAIRS_WITH_BISMUTH_CRYSTAL
    );
}
