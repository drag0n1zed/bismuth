package drag0n1zed.bismuth.datagen.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ZhCnProvider extends FabricLanguageProvider {
    public ZhCnProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "zh_cn", registryLookup);
    }
    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add("itemGroup.bismuth", "铋养的!");
        translationBuilder.add("item.bismuth.bismuth_crystal", "铋水晶");
        translationBuilder.add("item.bismuth.bismuth_sword", "铋剑");
        translationBuilder.add("item.bismuth.bismuth_shovel", "铋铲");
        translationBuilder.add("item.bismuth.bismuth_pickaxe", "铋稿");
        translationBuilder.add("item.bismuth.bismuth_axe", "铋斧");
        translationBuilder.add("item.bismuth.bismuth_hoe", "铋锄");
    }
}