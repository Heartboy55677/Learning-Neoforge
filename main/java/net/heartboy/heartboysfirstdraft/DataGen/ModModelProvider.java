package net.heartboy.heartboysfirstdraft.DataGen;

import net.heartboy.heartboysfirstdraft.block.ModBlocks;
import net.heartboy.heartboysfirstdraft.item.ModItems;
import net.heartboy.heartboysfirstdraft.main.FirstDraft;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output){super (output, FirstDraft.MOD_ID);}

    private final List<@NotNull Item> FLAT_ITEMS = List.of(
            ModItems.BISMUTH.get(),
            ModItems.RAW_BISMUTH.get(),
            ModItems.RADISH.get(),
            ModItems.FROSTFIRE_ICE.get(),
            ModItems.STARLIGHT_ASHES.get()
    );
    private final List<@NotNull Block> SIMPLE_BLOCKS = List.of(
            ModBlocks.MAGIC_BLOCK.get(),
            ModBlocks.BISMUTH_BLOCK.get(),
            ModBlocks.BISMUTH_ORE.get(),
            ModBlocks.BISMUTH_DEEPSLATE_ORE.get()
    );

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels){

      SIMPLE_BLOCKS.forEach(blockModels::createTrivialCube);

      FLAT_ITEMS.forEach(item ->
              itemModels.generateFlatItem(item, ModelTemplates.FLAT_ITEM));

      itemModels.generateFlatItem(ModItems.CHISEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

    }
}