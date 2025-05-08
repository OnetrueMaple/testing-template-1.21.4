package pain;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pain.block.ModBlocks;
import pain.item.ModItems;
import pain.world.gen.ModWorldGeneration;

public class Testing implements ModInitializer {
	public static final String MOD_ID = "testing";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModWorldGeneration.generateModWorldGen();
	}
}