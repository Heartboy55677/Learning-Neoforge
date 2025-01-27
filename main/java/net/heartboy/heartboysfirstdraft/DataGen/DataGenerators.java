package net.heartboy.heartboysfirstdraft.DataGen;

import net.heartboy.heartboysfirstdraft.main.FirstDraft;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(bus=EventBusSubscriber.Bus.MOD, modid= FirstDraft.MOD_ID)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        event.addProvider(new ModModelProvider(output));

        event.addProvider(new ModRecipeProvider.Runner(output, lookupProvider) {
            @Override
            public @NotNull String getName() {
                return "heartboysfirstdraft:recipes";
            }
        });

        BlockTagsProvider blockTagsProvider = new ModBlockTagProvider(output, lookupProvider);
        event.addProvider(blockTagsProvider);
        event.addProvider(new ModItemTagProvider(output,lookupProvider, blockTagsProvider.contentsGetter()));

        event.addProvider(
                new LootTableProvider(
                        output,
                        Set.of(),
                        List.of(new LootTableProvider.SubProviderEntry(
                                    ModBlockLootTableProvider::new,
                                    LootContextParamSets.BLOCK)),
                        lookupProvider
                )
        );
    }
}