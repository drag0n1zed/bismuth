package util;

import drag0n1zed.bismuth.Bismuth;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Items {
        public static final TagKey<Item> REPAIRS_WITH_BISMUTH = createTag("repairs_with_bismuth");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Bismuth.MOD_ID, name));
        }
    }

    public static class Blocks{
        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Bismuth.MOD_ID, name));
        }
    }

}
