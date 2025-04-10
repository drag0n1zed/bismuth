package drag0n1zed.bismuth.client.datagen;

import drag0n1zed.bismuth.Bismuth;
import drag0n1zed.bismuth.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class AdvancementProvider extends FabricAdvancementProvider {
    public AdvancementProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {super(output, registryLookup);}

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup wrapperLookup, Consumer<AdvancementEntry> consumer) {
        AdvancementEntry getBismuth = Advancement.Builder.create()
                .display(
                        ModItems.BISMUTH_CRYSTAL, // The display icon
                        Text.translatable("advancement.bismuth.get_bismuth.title"), // The title
                        Text.translatable("advancement.bismuth.get_bismuth.description"), // The description
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/adventure.png"), // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementFrame.TASK, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                // "got_bismuth" is the name referenced by other advancements when they want to have "requirements."
                .criterion("got_bismuth", InventoryChangedCriterion.Conditions.items(ModItems.BISMUTH_CRYSTAL))
                // Give the advancement an id
                .build(consumer, Bismuth.MOD_ID + ":get_bismuth");
    }
}
