package net.heartboy.heartboysfirstdraft.item;

import net.heartboy.heartboysfirstdraft.block.ModBlocks;
import net.heartboy.heartboysfirstdraft.main.FirstDraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FirstDraft.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BISMUTH_ITEMS_TAB = CREATIVE_MODE_TABS.register("bismuth_items", () -> CreativeModeTab.builder()
            .title(Component.translatable("creativetab.heartboysfirstdraft.bismuth_items"))
            .icon(() -> ModItems.BISMUTH.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(ModItems.BISMUTH.get());
                output.accept(ModItems.RAW_BISMUTH.get());
                output.accept(ModItems.CHISEL.get());
                output.accept(ModItems.RADISH.get());
                output.accept(ModItems.FROSTFIRE_ICE.get());
                output.accept(ModItems.STARLIGHT_ASHES.get());
            }).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BISMUTH_BLOCKS_TAB = CREATIVE_MODE_TABS.register("bismuth_blocks", () -> CreativeModeTab.builder()
            .title(Component.translatable("creativetab.heartboysfirstdraft.bismuth_blocks"))
            .withTabsBefore(ResourceLocation.fromNamespaceAndPath(FirstDraft.MOD_ID,"bismuth_items"))
            .icon(() -> ModBlocks.BISMUTH_BLOCK_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(ModBlocks.BISMUTH_ORE.get());
                output.accept(ModBlocks.BISMUTH_BLOCK.get());
                output.accept(ModBlocks.BISMUTH_DEEPSLATE_ORE.get());
                output.accept(ModBlocks.MAGIC_BLOCK.get());
            }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
