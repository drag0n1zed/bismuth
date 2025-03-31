package drag0n1zed.bismuth.client;
import drag0n1zed.bismuth.datagen.ItemTagGenerator;
import drag0n1zed.bismuth.client.datagen.ModelGenerator;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ModDataGenerator implements DataGeneratorEntrypoint{

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();

        pack.addProvider(ItemTagGenerator::new);
        pack.addProvider(ModelGenerator::new);
    }
}
