package drag0n1zed.bismuth;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bismuth implements ModInitializer {

    public static final String MOD_ID="bismuth";
    public static final Logger LOGGER = LoggerFactory.getLogger("Bismuth");
    @Override
    public void onInitialize() {
        LOGGER.info("Hello World! Bismuth Loading!");
        ModItems.initialize();
        ModItemGroups.initialize();
    }
}
