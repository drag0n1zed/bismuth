package drag0n1zed.bismuth;

import drag0n1zed.bismuth.block.ModBlocks;
import drag0n1zed.bismuth.item.ModItemGroups;
import drag0n1zed.bismuth.item.ModItems;
import drag0n1zed.bismuth.world.gen.ModOreGeneration;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bismuth implements ModInitializer {

    public static final String MOD_ID = "bismuth";
    public static final Logger LOGGER = LoggerFactory.getLogger("Bismuth");

    @Override
    public void onInitialize() {
        LOGGER.info("Hello World! Bismuth Loading!");
        ModItems.initializeItems();
        ModBlocks.initializeBlocks();
        ModItemGroups.initializeItemGroups();
        ModOreGeneration.generateOres();
    }
}
