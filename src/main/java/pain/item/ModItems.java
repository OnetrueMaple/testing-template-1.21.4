package pain.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import pain.Testing;

import java.util.function.Function;

public class ModItems {
    public static final Item RUBY = registerItem("ruby", Item::new, new Item.Settings());

    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        return Items.register(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Testing.MOD_ID, name)), factory, settings);
    }

    private static void sortIntoIngredients(FabricItemGroupEntries entries) {
        entries.add(RUBY);
    }

    public static void registerModItems() {
        Testing.LOGGER.info("Registering Mod Items for " + Testing.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::sortIntoIngredients);
    }
}
