package drag0n1zed.bismuth.client;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

import drag0n1zed.bismuth.datagen.*;
import drag0n1zed.bismuth.datagen.lang.*;
import drag0n1zed.bismuth.client.datagen.*;

public class ModDataGenerator implements DataGeneratorEntrypoint{

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();

        pack.addProvider(ItemTagProvider::new);
        pack.addProvider(ModelProvider::new);

        // lang
        pack.addProvider(EnUsProvider::new);
        pack.addProvider(ZhCnProvider::new);
    }
}
