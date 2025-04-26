package pain.block;

import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import pain.Testing;

import java.util.function.Function;

public class ModBlocks {

    // Obsidian with non-spawnable properties v
    //public static final Block OBSIDIAN = Blocks.register("obsidian", AbstractBlock.Settings.create().mapColor(MapColor.BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(50.0F, 1200.0F).allowsSpawning(Blocks::never));


    public static final Block RUBY_BLOCK = registerBlock("ruby_block", Block::new,
            Block.Settings.create()
                    .strength(5.0F, 6.0F)
                    .requiresTool()
                    .sounds(BlockSoundGroup.METAL)
    );

    public static final Block RUBY_ORE = registerBlock("ruby_ore",
            settings -> new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.STONE_GRAY)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(3.0F, 3.0F)
    );

    public static final Block DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            settings -> new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DEEPSLATE_GRAY)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(4.5F, 3.0F)
                    .sounds(BlockSoundGroup.DEEPSLATE)
    );

    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final Block block = Blocks.register(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Testing.MOD_ID, name)), factory, settings);
        Items.register(block);
        return block;
    }

    //private static void

    public static void registerModBlocks() {
        Testing.LOGGER.info("Registering Mod Blocks for " + Testing.MOD_ID);
    }
}
