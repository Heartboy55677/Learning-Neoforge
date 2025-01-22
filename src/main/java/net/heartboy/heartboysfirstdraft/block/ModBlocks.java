package net.heartboy.heartboysfirstdraft.block;

import net.heartboy.heartboysfirstdraft.main.FirstDraft;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static net.heartboy.heartboysfirstdraft.item.ModItems.ITEMS;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(FirstDraft.MOD_ID);

    public static final DeferredBlock<Block> BISMUTH_BLOCK = BLOCKS.registerSimpleBlock("bismuth_block",
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST));

    public static final DeferredItem<BlockItem> BISMUTH_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("bismuth_block",
            BISMUTH_BLOCK);

    public static final DeferredBlock<Block> BISMUTH_ORE = BLOCKS.registerBlock("bismuth_ore",
            Block::new,
            BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(4f).requiresCorrectToolForDrops().mapColor(MapColor.STONE));

    public static final DeferredItem<BlockItem> BISMUTH_ORE_ITEM = ITEMS.registerSimpleBlockItem("bismuth_ore",
            BISMUTH_ORE);

    public static final DeferredBlock<Block> BISMUTH_DEEPSLATE_ORE = BLOCKS.registerBlock("bismuth_deepslate_ore",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).sound(SoundType.DEEPSLATE).strength(4f).requiresCorrectToolForDrops());

    public static final DeferredItem<BlockItem> BISMUTH_DEEPSLATE_ORE_ITEM = ITEMS.registerSimpleBlockItem("bismuth_deepslate_ore",
            BISMUTH_DEEPSLATE_ORE);

    public static void register (IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
